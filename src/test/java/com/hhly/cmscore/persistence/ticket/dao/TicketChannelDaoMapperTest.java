
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

import com.hhly.cmscore.persistence.ticket.dao.TicketChannelDaoMapper;
import com.hhly.cmscore.persistence.ticket.po.TicketChannelPO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketChannelVO;

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
public class TicketChannelDaoMapperTest {

	@Autowired
	TicketChannelDaoMapper ticketChannelDaoMapper;
	
	@Test
	public void testCountPage() {
		TicketChannelVO vo = new TicketChannelVO();
		vo.setTicketStatus((short)1);
		ticketChannelDaoMapper.countPage(vo);
	}

	@Test
	public void testListPage() {
		TicketChannelVO vo = new TicketChannelVO();
		vo.setTicketStatus((short)1);
		vo.setPageIndex(0);
		vo.setPageSize(10);
		ticketChannelDaoMapper.listPage(vo);
	}

	@Test
	public void testListDrawerName() {
		ticketChannelDaoMapper.listDrawerIdName();
	}

	@Test
	@Rollback(true)
	public void testUpdate() {
		TicketChannelPO po = new TicketChannelPO();
		po.setId(1);
		po.setTicketChannelId("1");
		po.setDrawerName("123");
		po.setDrawerAccount("123");
		po.setAccountPassword("123");
		po.setAuthCode("123");
		po.setSendUrl("123");
		po.setSearchUrl("123");
		po.setSearchUrlSpare("123");
		po.setNoticeUrl("123");
		po.setAccountBalance(1);
		po.setModifyBy("cheng.chen");
		po.setRemark("123");
		po.setCreateBy("cheng.chen");
		po.setChannelStatus((short)1);
		po.setLotteryStatus((short)1);
		po.setTicketStatus((short)1);
		ticketChannelDaoMapper.update(po);
	}

	@Test
	@Rollback(true)
	public void testAdd() {
		TicketChannelPO po = new TicketChannelPO();
		po.setTicketChannelId("1");
		po.setDrawerName("123");
		po.setDrawerAccount("123");
		po.setAccountPassword("123");
		po.setAuthCode("123");
		po.setSendUrl("123");
		po.setSearchUrl("123");
		po.setSearchUrlSpare("123");
		po.setNoticeUrl("123");
		po.setAccountBalance(1);
		po.setModifyBy("cheng.chen");
		po.setRemark("123");
		po.setCreateBy("cheng.chen");
		po.setChannelStatus((short)1);
		po.setLotteryStatus((short)1);
		po.setTicketStatus((short)1);
		ticketChannelDaoMapper.add(po);
	}

	@Test
	public void testListDrawerIdName() {
		ticketChannelDaoMapper.listDrawerIdName();
	}

}
