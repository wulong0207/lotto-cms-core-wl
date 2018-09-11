package com.hhly.cmscore.persistence.ticket.dao;

import java.util.List;

import com.hhly.cmscore.persistence.ticket.po.TicketAlarmConfigPO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketAlarmConfigBO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketAlarmConfigVO;


public interface TicketAlarmConfigDaoMapper {

    int countPage(TicketAlarmConfigVO vo);

    List<TicketAlarmConfigBO> listPage(TicketAlarmConfigVO vo);

    int update(TicketAlarmConfigPO po);

    int add(TicketAlarmConfigPO po);

    
}