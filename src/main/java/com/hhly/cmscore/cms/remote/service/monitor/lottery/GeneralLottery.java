package com.hhly.cmscore.cms.remote.service.monitor.lottery;

import java.util.List;
import java.util.concurrent.Future;

import com.hhly.cmscore.cms.remote.service.ITicketMgrService;
import com.hhly.cmscore.cms.remote.service.monitor.AbstractLottery;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryIssueCmsBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoCmsBO;
import com.hhly.skeleton.cms.ticketmgr.bo.OrderTicketMonitorBO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketInfoBO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketInfoVO;

/**
 * @desc 常规彩种，有需要按照期号进行统计
 * @author jiangwei
 * @date 2017-2-17
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class GeneralLottery extends AbstractLottery {
    
    public GeneralLottery(ITicketMgrService maintenanceMgrService,
             int lotteryCode,
            String lotteryName) {
        super(maintenanceMgrService, lotteryCode, lotteryName);
    }

    @Override
    public OrderTicketMonitorBO getTimelyData() {
        Future<OrderInfoCmsBO> future = getOrderInfo();
        TicketInfoVO vo = new TicketInfoVO();
        vo.setLotteryCode(lotteryCode);
        vo.setLotteryIssue(issue);
        List<TicketInfoBO> tickets = maintenanceMgrService.listOrderTicketChannel(vo);
        OrderTicketMonitorBO orderTicketMonitorBO =  statisticsData(tickets);
        statisticsOrderInfo(future, orderTicketMonitorBO);
        return orderTicketMonitorBO;
    }

    @Override
    public void getLotteryIssueInfo(){
        LotteryIssueCmsBO issueBO = maintenanceMgrService.getLotteryIssueMonitor(lotteryCode);
        if (issueBO == null) {
            this.issue = null;
            this.lotteryEndTime = null;
            return;
        }
        this.lotteryEndTime = issueBO.getOfficialEndTime();
        this.issue = issueBO.getIssueCode();
    }

}
