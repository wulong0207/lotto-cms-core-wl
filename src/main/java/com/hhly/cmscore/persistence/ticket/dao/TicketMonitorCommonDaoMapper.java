package com.hhly.cmscore.persistence.ticket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.ticket.po.TicketMonitorCommonPO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketMonitorCommonBO;


public interface TicketMonitorCommonDaoMapper {

    List<TicketMonitorCommonBO> list();

    int update(@Param("pos")List<TicketMonitorCommonPO> pos);
    
}