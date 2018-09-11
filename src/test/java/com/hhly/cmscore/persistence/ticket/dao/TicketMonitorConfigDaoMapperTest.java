
package com.hhly.cmscore.persistence.ticket.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.ticket.dao.TicketMonitorConfigDaoMapper;
import com.hhly.cmscore.persistence.ticket.po.TicketMonitorConfigPO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketMonitorConfigVO;

/**
 * @desc    
 * @author  cheng chen
 * @date    2017年6月6日
 * @company 益彩网络科技公司
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager")
public class TicketMonitorConfigDaoMapperTest {

	@Autowired
	TicketMonitorConfigDaoMapper ticketMonitorConfigDaoMapper;
	
	@Test
	public void testCountPage() {
		TicketMonitorConfigVO vo = new TicketMonitorConfigVO();
		ticketMonitorConfigDaoMapper.countPage(vo);
	}

	@Test
	public void testListPage() {
		TicketMonitorConfigVO vo = new TicketMonitorConfigVO();
		vo.setPageIndex(0);
		vo.setPageSize(10);
		ticketMonitorConfigDaoMapper.countPage(vo);
	}

	@Test
	@Rollback(true)
	public void testUpdate() {
		TicketMonitorConfigPO po = new TicketMonitorConfigPO();
		po.setId(1);
		po.setNoSplit(1);
		po.setNoOut(1);
		po.setNoOutMoney(1);
		po.setNoSend(1);
		po.setSend(1);
		po.setEndTime(1);
		po.setChannelTicketNum(1);
		po.setChannelMoney(1);
		po.setMaxSendtime(1);
		po.setRefreshTime("1");
		po.setStatus((short)1);
		po.setModifyBy("cheng.chen");
		po.setBeforeIssueEnd(1);
		po.setBeforeIssueEndSecond(1);
		ticketMonitorConfigDaoMapper.update(po);

	}

	@Test
	@Rollback(true)
	public void testAdd() {
		TicketMonitorConfigPO po = new TicketMonitorConfigPO();
		po.setNoSplit(1);
		po.setNoOut(1);
		po.setNoOutMoney(1);
		po.setNoSend(1);
		po.setSend(1);
		po.setLotteryId(1);
		po.setLotteryName("双色扭曲");
		po.setEndTime(1);
		po.setChannelTicketNum(1);
		po.setChannelMoney(1);
		po.setMaxSendtime(1);
		po.setRefreshTime("1");
		po.setStatus((short)1);
		po.setModifyBy("cheng.chen");
		po.setBeforeIssueEnd(1);
		po.setBeforeIssueEndSecond(1);
		ticketMonitorConfigDaoMapper.add(po);
	}

	@Test
	public void testGetRefreshTime() {
		int lotteryCode = 300;
		ticketMonitorConfigDaoMapper.getRefreshTime(lotteryCode);
	}

}
