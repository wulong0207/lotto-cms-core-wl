package com.hhly.cmscore.cms.remote.service;

import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryIssueCmsBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoCmsBO;
import com.hhly.skeleton.cms.ticketmgr.bo.*;
import com.hhly.skeleton.cms.ticketmgr.vo.*;

import java.util.List;

/**
 * 
 * @desc 运维管理
 * @author jiangwei
 * @date 2017-2-5
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface ITicketMgrService {
    /**
     * 出票渠道
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-6 下午4:28:05
     * @param vo
     * @return
     */
    PagingBO<TicketChannelBO> listTicketChannel(TicketChannelVO vo);
    /**
     * 出票渠道
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-6 下午4:28:23
     * @param vo
     * @return
     */
    List<String> listDrawerName();
    /**
     * 查询所有渠道的ID和名称
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-6 下午4:56:41
     * @return
     */
    List<TicketChannelBO> listDrawerIdName(String lotteryCode);
    /**
     * 出票渠道
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-6 下午4:28:23
     * @param vo
     * @return
     */
    int updOrderTicketChannel(TicketChannelVO vo);
    /**
     * 出票渠道
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-6 下午4:28:23
     * @param vo
     * @return
     */
    int addOrderTicketChannel(TicketChannelVO vo);
    
    /**
     * 出票渠道配置
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-6 下午4:28:23
     * @param vo
     * @return
     */
    int addTicketConfig(TicketConfigVO vo);
    /**
     * 出票渠道配置
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-6 下午4:28:23
     * @param vo
     * @return
     */
    int updTicketConfig(TicketConfigVO vo);
    /**
     * 出票渠道配置
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-6 下午4:28:23
     * @param vo
     * @return
     */
    PagingBO<TicketConfigBO> listTicketConfig(TicketConfigVO vo);
    
    /**
     * 报警信息
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-7 下午2:37:01
     * @param vo
     * @return
     */
    PagingBO<TicketAlarmInfoBO> listTicketAlarmInfo(TicketAlarmInfoVO vo);
    /**
     * 报警配置信息查询
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-7 下午2:37:24
     * @param vo
     * @return
     */
    PagingBO<TicketAlarmConfigBO> listTicketAlarmConfig(TicketAlarmConfigVO vo);
    
    /**
     * 报警配置信息修改
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-7 下午2:37:47
     * @param vo
     * @return
     */
    int updTicketAlarmConfig(TicketAlarmConfigVO vo);
    
    /**
     * 报警配置信息添加
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-7 下午2:38:22
     * @param vo
     * @return
     */
    int addTicketAlarmConfig(TicketAlarmConfigVO vo);
    /**
     * 批量修改报警信息状态
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-7 下午5:42:03
     * @param vo
     * @return
     */
    int updTicketAlarmInfoStatus(TicketAlarmInfoVO vo);
    
    /**
     * 出票监控配置信息
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-14 上午9:14:44
     * @param vo
     * @return
     */
    PagingBO<TicketMonitorConfigBO> listTicketMonitorConfig(
            TicketMonitorConfigVO vo);

    /**
     * 修改监控配置信息
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-14 上午9:14:57
     * @param vo
     * @return
     */
    int updTicketMonitorConfig(TicketMonitorConfigVO vo);

    /**
     * 添加监控配置信息
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-14 上午9:15:25
     * @param vo
     * @return
     */
    int addTicketMonitorConfig(TicketMonitorConfigVO vo);

    /**
     * 监控常规配置
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-14 上午9:15:39
     * @return
     */
    List<TicketMonitorCommonBO> listTicketMonitorCommon();

    /**
     * 修改常规配置
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-14 上午9:16:13
     * @param list
     * @return
     */
    int updTicketMonitorCommon(List<TicketMonitorCommonVO> list);
    
    /**
     * 查询出票监控设置的彩种code集合
     * @return
     * @date 2017年8月19日下午4:58:04
     * @author cheng.chen
     */
    List<String> queryLotteryMonitorConfig(Integer lotteryCategory);
    
    /**
     * 查询彩种出票监控信息
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-14 下午4:20:52
     * @return
     */
    OrderTicketMonitorBO getTicketMonitor(int lotteryCode);
    /**
     * 获取属性时间
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-16 下午3:45:09
     * @param lotteryCode
     * @return
     */
    TicketMonitorConfigBO getRefreshTime(int lotteryCode);
    
    /**
     * 查询出票监控的彩期信息
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-16 下午4:22:13
     * @param lotteryCode
     * @return
     */
    LotteryIssueCmsBO getLotteryIssueMonitor(int lotteryCode);
    /**
     * 渠道信息缓存key
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-16 下午5:45:00
     * @param channelId
     * @param lotteryCode
     * @return
     */
    String getChannelConfigKey(String channelId,Integer lotteryCode);
    
    /**
     * 获取出票商配置信息
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-16 下午5:47:23
     * @param key
     * @param channelId
     * @param lotteryId
     * @return
     */
    TicketConfigBO getTicketConfig(String key, String channelId,Integer lotteryId);
    /**
     * 获取订单出票信息，根据彩期和渠道统计分组
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-15 上午10:10:53
     * @param lotteryCode 彩种
     * @param issue 彩期
     * @return
     */
    List<TicketInfoBO> listOrderTicketChannel(TicketInfoVO vo);
    /**
     * 查询竞技彩最近需要统计的一期
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-17 下午12:11:02
     * @param lotteryCode
     * @return
     */
    TicketInfoBO getLotteryIssueMonitorSport(int lotteryCode);
    /**
     * 统计订单未拆票和合买数据
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-20 下午3:37:23
     * @param lotteryCode
     * @param lotteryIssue
     * @return
     */
    OrderInfoCmsBO getMonitorOrderInfo(int lotteryCode, String lotteryIssue);
    
    /*************************************** 票管理操作 **********************************************/
	/**
	 * @desc 票管理：分页查询
	 * @author huangb
	 * @date 2017年2月20日
	 * @param ticketInfoVO
	 *            参数对象
	 * @return 票管理：分页查询
	 */
	PagingBO<TicketInfoBO> findPagingTicket(TicketInfoVO ticketInfoVO);

	/**
	 * @desc 票管理：查询单个
	 * @author huangb
	 * @date 2017年2月20日
	 * @param ticketInfoVO
	 *            查询对象
	 * @return 票管理：查询单个
	 */
	TicketInfoBO findSingleTicket(TicketInfoVO ticketInfoVO);

	/**
	 * @desc 票管理：查询excel导出
	 * @author huangb
	 * @date 2017年2月20日
	 * @param ticketInfoVO
	 *            查询对象
	 * @return 票管理：查询excel导出
	 */
	List<TicketInfoBO> findExcelTicket(TicketInfoVO ticketInfoVO);

	/**
	 * @desc 票管理：修改票信息(包括票状态、回执内容、票图片、票内容、备注)
	 * @author huangb
	 * @date 2017年2月20日
	 * @param ticketInfoVO
	 * @return 票管理：修改票信息(包括票状态、回执内容、票图片、票内容、备注)
	 */
	int updTicket(TicketInfoVO ticketInfoVO);

	/*************************************** 票管理操作 **********************************************/
	/**
	 * 查询票不等于指定状态的数量
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年3月14日 下午2:40:50
	 * @param orderCode
	 * @param status
	 * @return
	 */
	int countTicketInfoNotEqual(String orderCode, int status);
	/**
	 * 修改票管理
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年3月20日 下午2:54:10
	 * @param vo
	 * @return
	 */
	String updateTicketStatus(TicketInfoStatusVO vo);
	/**
	 * 上传票号
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年3月21日 上午10:48:24
	 * @param ticketType
	 * @param ticketNo
	 */
	void uploadTicketNo(String ticketType, String ticketNo);
	/**
	 * 根据票状态执行操作
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年3月21日 上午10:58:41
	 * @param operate 操作类型
	 * @param id 票ID
	 * @return
	 */
	String updateTicketOperate(String operate, String id,String modifyBy);
	/**
     * 添加报警进行
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017年8月8日 上午11:17:05
     * @param vo
     */
	int addTicketAlarmInfo(TicketAlarmInfoVO vo);
	/**
	 * 查询订单存在指定状态票数
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年8月15日 下午4:32:14
	 * @param orderCode
	 * @param status
	 * @return
	 */
	int countTicketStatus(String orderCode, int status);
	
	/**
	 * @desc   查询符合条件的报警信息
	 * @author Tony Wang
	 * @create 2017年10月25日
	 * @param vo
	 * @return 
	 */
	List<TicketAlarmInfoBO> findTicketAlarmInfo(TicketAlarmInfoVO vo);
}
