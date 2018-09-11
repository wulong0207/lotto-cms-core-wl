package com.hhly.cmscore.persistence.ticket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.ticket.po.TicketMonitorConfigPO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketMonitorConfigBO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketMonitorConfigVO;


public interface TicketMonitorConfigDaoMapper {

    int countPage(TicketMonitorConfigVO vo);

    List<TicketMonitorConfigBO> listPage(TicketMonitorConfigVO vo);

    int update(TicketMonitorConfigPO po);

    int add(TicketMonitorConfigPO po);
    /**
     * 查询刷新时间
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-16 下午3:51:17
     * @param lotteryCode
     * @return
     */
    TicketMonitorConfigBO getRefreshTime(@Param("lotteryCode")int lotteryCode);
    
    List<String> queryLotteryMonitorConfig(@Param("lotteryCategory") Integer lotteryCategory);
    
}