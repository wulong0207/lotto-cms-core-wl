package com.hhly.cmscore.cms.remote.service.monitor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.Assert;

import com.hhly.cmscore.cms.remote.service.ITicketMgrService;
import com.hhly.cmscore.cms.remote.service.common.ThreadPool;
import com.hhly.cmscore.cms.remote.service.monitor.entity.RefreshTime;
import com.hhly.skeleton.base.constants.SymbolConstants;
import com.hhly.skeleton.base.exception.ServiceRuntimeException;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.base.util.NumberUtil;
import com.hhly.skeleton.base.util.ObjectUtil;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoCmsBO;
import com.hhly.skeleton.cms.ticketmgr.bo.OrderTicketChannelMonitorBO;
import com.hhly.skeleton.cms.ticketmgr.bo.OrderTicketMonitorBO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketConfigBO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketInfoBO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketMonitorConfigBO;

/**
 * @desc 彩种出票监控统计抽象实现
 * @author jiangwei
 * @date 2017-2-16
 * @company 益彩网络科技公司
 * @version 1.0
 */
public abstract class AbstractLottery implements ILottery {
    private static final Logger LOGGER = LogManager.getLogger(AbstractLottery.class);
    /**
     * 服务
     */
    protected final ITicketMgrService maintenanceMgrService;
    /**
     * 彩种id
     */
    protected final int lotteryCode;
    /**
     * 彩种名称
     */
    protected final String lotteryName;
    /**
     * 期号
     */
    protected String issue;
    /**
     * 最近一期截止时间
     */
    protected Date lotteryEndTime;

    /**
     * 刷新时间周期
     */
    private RefreshTime[] refresh;

    /**
     * 上一次刷新时间(当天秒)
     */
    private int lastRefreshTime;
    /**
     * 彩期截止刷新频率配置
     * 截止前时间（秒）
     */
    private int beforeIssueEnd;
    /**
     *  彩期截止刷新频率配置
     *  截止前时间（秒） 刷新频率
     */
    private int beforeIssueEndSecond;
    
    /**
     * 未拆方案书
     */
    private Integer noSplit;
    
    /**
     * 截止未出数
     */
    private Integer noOut;
    
    /**
     * 未出票金额
     */
    private Integer noOutMoney;
    
    /**
     * 未出票金额
     */
    private Integer noSend;
    
    /**
     * 已送票数
     */
    @SuppressWarnings("unused")
	private Integer send;  
    
    /**
     * 截止时间
     */
    @SuppressWarnings("unused")
	private Integer endTime;  
    
    /**
     * 出票商票数
     */
    @SuppressWarnings("unused")
	private Integer channelTicketNum;  

    /**
     * 出票商金额
     */
    @SuppressWarnings("unused")
	private Integer channelMoney;  
    
    /**
     * 统计结果
     */
    protected OrderTicketMonitorBO monitorBO;
    /**
     * 加载数据锁
     */
    private Lock lockData = new ReentrantLock();

    public AbstractLottery(ITicketMgrService maintenanceMgrService,
            int lotteryCode,String lotteryName) {
    	Assert.notNull(maintenanceMgrService);
        this.maintenanceMgrService = maintenanceMgrService;
        this.lotteryName = lotteryName;
        this.lotteryCode = lotteryCode;
        loadRefreshTime();
    }
    
    @Override
    public final OrderTicketMonitorBO getData() {
        if(isRefreshData()){
        	try {
        		lockData.lock();
        		if (isRefreshData()) {
                    //加载彩期信息
                    loadLotteryInfo();
                    //获取及时数据
                    OrderTicketMonitorBO ticketMonitorBO = getTimelyData();
                    //对出票监控数据判断是否达到警告级别
                    isTicketMonitorData(ticketMonitorBO);
                    //更新缓存
                    refreshData(ticketMonitorBO);
                }
			} finally {
				lockData.unlock();
			}
        }
        return this.monitorBO;
    }

    @Override
    public final void loadRefreshTime() {
        //查询配置信息
        TicketMonitorConfigBO bo = maintenanceMgrService.getRefreshTime(lotteryCode);
        if(ObjectUtil.isNotNull(bo)){
        	refresh = getRefreshTime(bo.getRefreshTime());
        	this.beforeIssueEnd = bo.getBeforeIssueEnd() == null ? 0 : bo.getBeforeIssueEnd();
            this.beforeIssueEndSecond = bo.getBeforeIssueEndSecond() == null ? 0: bo.getBeforeIssueEndSecond();
            this.noSplit = bo.getNoSplit() == null ? 0 : bo.getNoSplit();
            this.noOut = bo.getNoOut() == null ? 0 : bo.getNoOut();
            this.noOutMoney = bo.getNoOutMoney() == null ? 0 : bo.getNoOutMoney();
            this.noSend = bo.getNoSend() == null ? 0 : bo.getNoSend();
            this.send = bo.getSend() == null ? 0 : bo.getSend();
            this.endTime= bo.getEndTime() == null ? 0 : bo.getEndTime();
            this.channelTicketNum = bo.getChannelTicketNum() == null ? 0 : bo.getChannelTicketNum();
            this.channelMoney = bo.getChannelMoney() == null ? 0 : bo.getChannelMoney();
        }
    }
    /**
     * 获取订单统计信息
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-20 下午3:55:20
     * @return
     */
    protected Future<OrderInfoCmsBO> getOrderInfo(){
        return ThreadPool.THREAD_POOL.submit(new Callable<OrderInfoCmsBO>(){
            @Override
            public OrderInfoCmsBO call() throws Exception {
                return maintenanceMgrService.getMonitorOrderInfo(lotteryCode,issue);
            }
        });
    }
    /**
     * 出订单数据进行统计
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-20 下午4:09:00
     * @param future
     * @param orderTicketMonitorBO
     */
    protected void statisticsOrderInfo(Future<OrderInfoCmsBO> future,OrderTicketMonitorBO orderTicketMonitorBO) {
        OrderInfoCmsBO orderInfo;
        try {
            orderInfo = future.get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error("竞技彩统计异常", e);
            throw new ServiceRuntimeException("竞技彩统计异常");
        }
        orderTicketMonitorBO.setNotSplitOrderCount(orderInfo.getCount());
        orderTicketMonitorBO.setNotSplitOrderMoney(orderInfo.getOrderAmount()==null?0:orderInfo.getOrderAmount());
    }
    
    /**
     * 判断是否刷新数据
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-17 上午11:49:54
     * @return
     */
    private final  boolean isRefreshData() {
        int week = DateUtil.dayForWeek();
        int time = getNowSecond();
        if (ObjectUtil.isNull(refresh)) {
            return true;
        }
        int interval = time - lastRefreshTime;
        //跨天判断
        if(interval < 0){
        	LOGGER.info("跨天刷新出票监控数据lotteryCode:" + lotteryCode);
        	interval = time;
        	lastRefreshTime = 0;
        }
        //判断比赛截止前一段时间的刷新频率
        if(beforeIssueEnd > 0 && beforeIssueEndSecond > 0){
            int end = getDateSecond(lotteryEndTime) - time;
            //如果设置时间比当前时间大
            if(beforeIssueEnd > end){
                return interval > beforeIssueEndSecond;
            }
        }
        //常规配置刷新频率
        for (RefreshTime rt : refresh) {
            if (week == rt.getWeek() && rt.getStart() <= time
                    && rt.getEnd() >= time) {
                return interval > rt.getTime();
            }
        }
        return true;
    }
   
    
    /**
     * 数据库查询彩期信息
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-17 下午12:00:08
     */
    protected abstract void getLotteryIssueInfo();
    /**
     * 计算统计信息
     * 
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-16 下午3:16:19
     */
    protected OrderTicketMonitorBO statisticsData(List<TicketInfoBO> tickets) {
        OrderTicketMonitorBO ticketMonitorBO = new OrderTicketMonitorBO(lotteryName, issue, lotteryCode, lotteryEndTime);
        Map<String, OrderTicketChannelMonitorBO> channelMonitorMap = new HashMap<String, OrderTicketChannelMonitorBO>();
        for (TicketInfoBO bo : tickets) {
        	
        	OrderTicketChannelMonitorBO channelMonitorBO = null; 
        	if(!ObjectUtil.isBlank(bo.getChannelId())){
                String key = String.valueOf(lotteryCode) + bo.getChannelId();
                // 出票商统计对象
                channelMonitorBO = channelMonitorMap.get(key);
                if (ObjectUtil.isNull(channelMonitorBO)) {
                    channelMonitorBO = createChannelMonitor(bo);
                    channelMonitorMap.put(key, channelMonitorBO);
                    ticketMonitorBO.getChannelInfo().add(channelMonitorBO);
                }        		
        	}

            switch (bo.getTicketStatus()) {
            case -2:// 出票失败
                ticketMonitorBO.setFailOutTicketCount(ticketMonitorBO.getFailOutTicketCount() + bo.getCount());
                break;
            case -1:// 送票失败
            	 ticketMonitorBO.setNotSendTicketCount(ticketMonitorBO.getNotSendTicketCount() + bo.getCount());
                break;
            case 0:
                // 不出票
                break;
            case 1:
                // 待分配
                ticketMonitorBO.setNotSendTicketCount(ticketMonitorBO.getNotSendTicketCount() + bo.getCount());
                ticketMonitorBO.setNotOutTicketCount(ticketMonitorBO.getNotOutTicketCount() + bo.getCount());
                ticketMonitorBO.setNotOutTicketMoney(NumberUtil.sum(ticketMonitorBO.getNotOutTicketMoney(),bo.getTicketMoney()));
                break;
            case 2:
                // 已分配
                ticketMonitorBO.setNotSendTicketCount(ticketMonitorBO.getNotSendTicketCount() + bo.getCount());
                ticketMonitorBO.setNotOutTicketCount(ticketMonitorBO.getNotOutTicketCount() + bo.getCount());
                ticketMonitorBO.setNotOutTicketMoney(NumberUtil.sum(ticketMonitorBO.getNotOutTicketMoney(),bo.getTicketMoney()));
                break;
            case 3:
                // 已送票
                ticketMonitorBO.setSendTicketCount(ticketMonitorBO.getSendTicketCount() + bo.getCount());
                ticketMonitorBO.setNotOutTicketCount(ticketMonitorBO.getNotOutTicketCount() + bo.getCount());
                ticketMonitorBO.setNotOutTicketMoney(NumberUtil.sum(ticketMonitorBO.getNotOutTicketMoney(),bo.getTicketMoney()));
                channelMonitorBO.setSendTicketCount(channelMonitorBO.getSendTicketCount() + bo.getCount());
                channelMonitorBO.setSendTicketMoney(NumberUtil.sum(channelMonitorBO.getSendTicketMoney(),bo.getTicketMoney()));
                channelMonitorBO.setComeOutTime(DateUtil.getMinDate(bo.getComeOutTime(),channelMonitorBO.getComeOutTime()));
                break;
            case 4:
                // 已出票
                break;
            default:
                break;
            }
        }
        return ticketMonitorBO;
    }
    /**
     * 解析刷新时间格式
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年3月3日 上午11:44:20
	 * @param refreshTime 属性时间
	 * @return 刷新时间对象
	 */
	public RefreshTime[] getRefreshTime(String refreshTime ) {
		List<RefreshTime> list = new ArrayList<>();
		// 解析格式 2|04:00:00|08:00:00|20,1|01:00:00|01:00:00|10
		if (StringUtils.isNotBlank(refreshTime)) {
		    String[] times = refreshTime.split(SymbolConstants.COMMA);
		    for (String time : times) {
		        String[] contents = org.springframework.util.StringUtils.tokenizeToStringArray(time, SymbolConstants.VERTICAL_BAR);
		        if (contents.length != 4) {
		            throw new ServiceRuntimeException("彩种配置刷新时间有误");
		        }
		        RefreshTime rt = new RefreshTime();
		        rt.setWeek(Integer.parseInt(contents[0]));
		        rt.setStart(getTimeSecond(contents[1]));
		        rt.setEnd(getTimeSecond(contents[2]));
		        rt.setTime(Integer.parseInt(contents[3]));
		        list.add(rt);
		    }
		}
		return list.toArray(new RefreshTime[list.size()]);
	}
    /**
     * 获取当前时间秒
     * 
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-16 下午5:00:28
     * @return
     */
    private static int getNowSecond() {
        return getDateSecond(null);
    }
    
    private static int getDateSecond(Date date){
        Calendar calendar = Calendar.getInstance();
        if(date != null){
            calendar.setTime(date);   
        }
        long time = TimeUnit.HOURS.toSeconds(calendar.get(Calendar.HOUR_OF_DAY));
        time += TimeUnit.MINUTES.toSeconds(calendar.get(Calendar.MINUTE));
        time += calendar.get(Calendar.SECOND);
        return (int) time;
    }

    /**
     * 装换时间为秒
     * 
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-16 下午4:47:37
     * @param time
     *            格式"HH:mm:ss"
     * @return
     */
    private static int getTimeSecond(String timeStr) {
        String[] str = timeStr.split(SymbolConstants.COLON);
        long time = TimeUnit.HOURS.toSeconds(Integer.parseInt(str[0]));
        time += TimeUnit.MINUTES.toSeconds(Integer.parseInt(str[1]));
        time += Integer.parseInt(str[2]);
        return (int) time;
    }

    /**
     * 创建出票商统计信息
     * 
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-16 下午5:51:52
     * @param bo
     * @return
     */
    private OrderTicketChannelMonitorBO createChannelMonitor(TicketInfoBO bo) {
        OrderTicketChannelMonitorBO channelMonitorBO;
        channelMonitorBO = new OrderTicketChannelMonitorBO();
        String channelConfigKey = maintenanceMgrService.getChannelConfigKey(
                bo.getChannelId(),lotteryCode);
        // 出票商配置信息
        TicketConfigBO ticketConfigBO = maintenanceMgrService.getTicketConfig(
                channelConfigKey, bo.getChannelId(), lotteryCode);

        if (ObjectUtil.isNotNull(ticketConfigBO)) {
            channelMonitorBO.setChannelName(ticketConfigBO.getDrawerName());
            channelMonitorBO.setSendWeight(ticketConfigBO.getSendWeight());
            channelMonitorBO.setTicketChannelId(bo.getChannelId());
        }
        return channelMonitorBO;
    }
    /**
     * 刷新缓存数据
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-17 上午11:50:12
     * @param ticketMonitorBO
     */
    private final  void refreshData(OrderTicketMonitorBO ticketMonitorBO) {
        this.monitorBO = ticketMonitorBO;
        this.lastRefreshTime = getNowSecond();
        LOGGER.info("刷新出票监控数据lotteryCode："+lotteryCode);
    }
    /**
     * 加载彩种信息
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-17 上午11:50:24
     */
    private final void loadLotteryInfo() {
    	//判断是否需要重新加载彩期信息
        if (lotteryEndTime != null
                && lotteryEndTime.getTime() > System.currentTimeMillis()) {
            return;
        }
        getLotteryIssueInfo();
    }
    
    /**
     * 
     * @param ticketMonitorBO
     * @date 2017年5月20日下午5:32:17
     * @author cheng.chen
     */
    private final void isTicketMonitorData(OrderTicketMonitorBO ticketMonitorBO){
    	try {
    		if(ObjectUtil.isBlank(ticketMonitorBO))
    			return;
        	Map<String, Integer> isWarnMap = new HashMap<String, Integer>();
        	if(!ObjectUtil.isBlank(noSplit) && noSplit > 0){
        		isWarnMap.put("isNoSplit", ticketMonitorBO.getNotSplitOrderCount() > noSplit ? 1 : 0);
        	}
        	if(!ObjectUtil.isBlank(noOut) && noOut > 0){
        		isWarnMap.put("isNoOut", ticketMonitorBO.getNotOutTicketCount() > noOut ? 1 : 0);
        	}
        	if(!ObjectUtil.isBlank(noOutMoney) && noOutMoney > 0){
        		isWarnMap.put("isNoOutMoney", ticketMonitorBO.getNotOutTicketMoney() > noOutMoney ? 1 : 0);
        	}
        	if(!ObjectUtil.isBlank(noSend) && noSend > 0){
        		isWarnMap.put("isNoSend", ticketMonitorBO.getNotSendTicketCount() > noSend ? 1 : 0);
        	}
        	if(!ObjectUtil.isBlank(noSplit) && noSplit > 0){
        		isWarnMap.put("isNoSplit", ticketMonitorBO.getNotSplitOrderCount() > noSplit ? 1 : 0);
        	}
        	ticketMonitorBO.setIsWarnMap(isWarnMap);			
		} catch (Exception e) {
			LOGGER.error("判断是否警告异常, " + e.getMessage());
		}
    }
}
