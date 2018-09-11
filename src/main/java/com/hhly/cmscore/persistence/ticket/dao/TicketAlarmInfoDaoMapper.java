package com.hhly.cmscore.persistence.ticket.dao;

import java.util.List;

import com.hhly.cmscore.persistence.ticket.po.TicketAlarmInfoPO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketAlarmInfoBO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketAlarmInfoVO;


public interface TicketAlarmInfoDaoMapper {

    int countPage(TicketAlarmInfoVO vo);

    List<TicketAlarmInfoBO> listPage(TicketAlarmInfoVO vo);

    int updTicketAlarmInfoStatus(TicketAlarmInfoVO vo);

	int addTicketAlarmInfo(TicketAlarmInfoPO po);
   
}