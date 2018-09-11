package com.hhly.cmscore.cms.remote.service.monitor.lottery;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.commons.lang.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hhly.cmscore.cms.remote.service.ITicketMgrService;
import com.hhly.cmscore.cms.remote.service.common.ThreadPool;
import com.hhly.cmscore.cms.remote.service.monitor.AbstractLottery;
import com.hhly.skeleton.base.exception.ServiceRuntimeException;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryIssueCmsBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoCmsBO;
import com.hhly.skeleton.cms.ticketmgr.bo.OrderTicketMonitorBO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketInfoBO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketInfoVO;

/**
 * @desc 竞技彩类型，不按期号进行统计
 * @author jiangwei
 * @date 2017-2-17
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class SportLottery extends AbstractLottery {
    
    private static final Logger LOGGER = LogManager.getLogger(SportLottery.class);
    //是否存在票
    private Date issueEndTime;
  
    public SportLottery(ITicketMgrService maintenanceMgrService, int lotteryCode,
            String lotteryName) {
        super(maintenanceMgrService, lotteryCode, lotteryName);
    }
    
    @Override
    public OrderTicketMonitorBO getTimelyData() {
        if(this.lotteryEndTime == null){
        	return  new OrderTicketMonitorBO(lotteryName, issue, lotteryCode, issueEndTime);
        }
        //订单统计数据
        Future<OrderInfoCmsBO> futureOrder = getOrderInfo();
        //竞技彩最近截止
        TicketInfoVO beforeVO = new TicketInfoVO(lotteryCode,new Date(),lotteryEndTime);
        Future<List<TicketInfoBO>> beforeFuture = getDataMonitor(beforeVO);
        //最近截止后的
        Date start = DateUtils.addSeconds(lotteryEndTime, 1);
        TicketInfoVO afterVO = new TicketInfoVO(lotteryCode,start,null);
        Future<List<TicketInfoBO>> afterFuture = getDataMonitor(afterVO);
        
        //计算统计
        List<TicketInfoBO> beforeTicket = null;
        List<TicketInfoBO> afterTicket = null;
        try {
            beforeTicket = beforeFuture.get();
            afterTicket = afterFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error("竞技彩统计异常", e);
            throw new ServiceRuntimeException("竞技彩统计异常");
        }
        int outTicketCount = getNotOutTicketCount(beforeTicket);
        afterTicket.addAll(beforeTicket);
        OrderTicketMonitorBO ticketMonitorBO  =  statisticsData(afterTicket);
        ticketMonitorBO.setNotOutTicketCountSport(outTicketCount);
        //统计订单未拆票信息
        statisticsOrderInfo(futureOrder, ticketMonitorBO);
        return ticketMonitorBO;
        
    }
    
    /**
     * 重数据库查询统计数据
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-17 下午3:17:07
     * @param vo
     * @return
     */
    private Future<List<TicketInfoBO>> getDataMonitor(final TicketInfoVO vo){
        return ThreadPool.THREAD_POOL.submit(new Callable<List<TicketInfoBO>>() {
            @Override
            public List<TicketInfoBO> call() throws Exception {
                return maintenanceMgrService.listOrderTicketChannel(vo);
            }
        });
    }
    
    @Override
    public void getLotteryIssueInfo() {
    	//查询截止送票时间大于当前时间的票
        TicketInfoBO orderTicketBO = maintenanceMgrService.getLotteryIssueMonitorSport(lotteryCode);
        if(orderTicketBO == null){
        	LotteryIssueCmsBO issueBO = maintenanceMgrService.getLotteryIssueMonitor(lotteryCode);
        	if(issueBO != null){
        		this.issue = issueBO.getIssueCode();
        	    this.issueEndTime = issueBO.getOfficialEndTime();
        	}else{
        		this.lotteryEndTime = null;
                this.issue = null;
        	}
        }else{
        	this.issue = orderTicketBO.getLotteryIssue();
            this.lotteryEndTime = orderTicketBO.getEndTicketTime();
        }
        
    }
    
    /**
     * 只统计未出票数（统计，待分配和已分配）
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-17 下午2:38:00
     * @param tickets
     * @return
     */
    private int getNotOutTicketCount(List<TicketInfoBO> tickets){
        int count = 0;
        for (TicketInfoBO bo : tickets) {
            if(bo.getTicketStatus() == 1 
                    || bo.getTicketStatus() == 2){
                count += bo.getCount();
            }
        }
        return count;
    }
}  
