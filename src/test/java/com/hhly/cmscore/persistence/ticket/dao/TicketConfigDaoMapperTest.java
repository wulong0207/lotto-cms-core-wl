
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

import com.hhly.cmscore.persistence.ticket.dao.TicketConfigDaoMapper;
import com.hhly.cmscore.persistence.ticket.po.TicketConfigPO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketConfigVO;

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
public class TicketConfigDaoMapperTest {

	@Autowired
	TicketConfigDaoMapper ticketConfigDaoMapper;
	
	@Test
	public void testCountPage() {
		TicketConfigVO vo = new TicketConfigVO();
		vo.setSendStatus((short)1);
		ticketConfigDaoMapper.countPage(vo);
	}

	@Test
	public void testListPage() {
		TicketConfigVO vo = new TicketConfigVO();
		vo.setSendStatus((short)1);
		vo.setPageIndex(1);
		vo.setPageSize(10);
		ticketConfigDaoMapper.listPage(vo);
	}

	@Test
	@Rollback(true)
	public void testUpdate() {
		TicketConfigPO po = new TicketConfigPO();
		po.setId(1);
		po.setTicketChannelId("1");
		po.setLotteryCode(300);
		po.setSendStatus((short)1);
		po.setPreBatch("123");
		po.setPreTicket("123");
		po.setSendWeight((short)1);
		po.setSendEachBatch((short)1);
		po.setThreadCount((short)1);
		po.setSearchAuto((short)1);
		po.setSearchIdent("123");
		po.setSearchMaxTicket((short)1);
		po.setEndSendSpace("300|1200|10");
		po.setAllowSendTime("600");
		po.setStopLottery("123");
		po.setRemark("fds");
		po.setCreateBy("cheng.chen");
		po.setModifyBy("cheng.chen");
		ticketConfigDaoMapper.update(po);
	}

	@Test
	@Rollback(true)
	public void testAdd() {
		TicketConfigPO po = new TicketConfigPO();
		po.setTicketChannelId("1");
		po.setLotteryCode(300);
		po.setSendStatus((short)1);
		po.setPreBatch("123");
		po.setPreTicket("123");
		po.setSendWeight((short)1);
		po.setSendEachBatch((short)1);
		po.setThreadCount((short)1);
		po.setSearchAuto((short)1);
		po.setSearchIdent("123");
		po.setSearchMaxTicket((short)1);
		po.setEndSendSpace("300|1200|10");
		po.setAllowSendTime("600");
		po.setStopLottery("123");
		po.setRemark("fds");
		po.setCreateBy("cheng.chen");
		po.setModifyBy("cheng.chen");
		ticketConfigDaoMapper.add(po);
	}

	@Test
	public void testGetTicketConfig() {
		String channelId = "2";
		Integer lotteryCode = 100;
		ticketConfigDaoMapper.getTicketConfig(channelId, lotteryCode);
	}

}
