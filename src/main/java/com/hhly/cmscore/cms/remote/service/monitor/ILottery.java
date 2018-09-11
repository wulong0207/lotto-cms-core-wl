package com.hhly.cmscore.cms.remote.service.monitor;

import com.hhly.skeleton.cms.ticketmgr.bo.OrderTicketMonitorBO;

/**
 * 彩种出票监控统计接口
 * 
 * @author jiangwei
 * @date 2017-2-16
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface ILottery {
    /**
     * 根据策略获取统计后数据
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-16 下午3:16:03
     * @return
     */
    OrderTicketMonitorBO getData();
    /**
     * 获取及时数据
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-17 上午11:33:54
     * @return
     */
    OrderTicketMonitorBO getTimelyData();
    /**
     * 加载刷新时间
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-16 下午3:46:33
     */
    void loadRefreshTime();
}
