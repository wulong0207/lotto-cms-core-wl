
package com.hhly.cmscore.persistence.ticket.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.ticket.dao.TicketInfoDaoMapper;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketInfoBO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketInfoVO;

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
public class TicketInfoDaoMapperTest {

	@Autowired
	TicketInfoDaoMapper ticketInfoDaoMapper;
	
	@Test
	public void testListTicketInfoChannel() {
		TicketInfoVO vo = new TicketInfoVO();
		vo.setLotteryCode(100);
		ticketInfoDaoMapper.listTicketInfoChannel(vo);
	}

	@Test
	public void testGetLotteryIssueMonitorSport() {
		int lotteryCode = 300;
		ticketInfoDaoMapper.getLotteryIssueMonitorSport(lotteryCode);
	}

	@Test
	public void testFindPagingTicket() {
		TicketInfoVO vo = new TicketInfoVO();
		vo.setChannelId("2");
		vo.setPageIndex(0);
		vo.setPageSize(10);
		ticketInfoDaoMapper.findPagingTicket(vo);
	}

	@Test
	public void testFindCountTicket() {
		TicketInfoVO vo = new TicketInfoVO();
		ticketInfoDaoMapper.findCountTicket(vo);
	}

	@Test
	public void testFindSingleTicket() {
		TicketInfoVO vo = new TicketInfoVO();
		vo.setId(1l);
		ticketInfoDaoMapper.findSingleTicket(vo);
	}

	@Test
	public void testFindExcelTicket() {
		TicketInfoVO vo = new TicketInfoVO();
		ticketInfoDaoMapper.findExcelTicket(vo);
	}

	@Test
	@Rollback(true)
	public void testUpdTicket() {
		TicketInfoVO vo = new TicketInfoVO();
		vo.setId(1l);
		vo.setReceiptContent("213");
		vo.setTicketImg("123");
		vo.setTicketImgTxt("23");
		vo.setTicketRemark("123");
		vo.setModifyBy("cheng.chen");
		vo.setComeOutTime(DateUtil.getNowDate());
		ticketInfoDaoMapper.updTicket(vo);
	}

	@Test
	public void testCountTicketInfoNotEqual() {
		String orderCode = "sdfdsf";
		int status = 1;
		ticketInfoDaoMapper.countTicketInfoNotEqual(orderCode, status);
	}

	@Test
	public void testListTicketStatus() {
		List<String> ids = new ArrayList<>();
		ids.add("123");
		ids.add("abc");
		ticketInfoDaoMapper.listTicketStatus(ids);
	}

	@Test
	@Rollback(true)
	public void testUpdateTicketStatus() {
		List<Integer> ids = new ArrayList<>();
		ids.add(123);
		ids.add(654);
		Short status = 1;
		String modifyBy = "cheng.chen";
		ticketInfoDaoMapper.updateTicketStatus(ids, status, modifyBy);
	}

	@Test
	public void testQueryFailTicketInfo() {
		String orderCode = "1";
		Integer ticketStatus = 1;
		ticketInfoDaoMapper.queryFailTicketInfo(orderCode, ticketStatus);
	}

	/**
	 * 该方法在CMS和lotto无用处
	 * 
	 * @date 2017年6月6日上午11:51:01
	 * @author cheng.chen
	 */
	@Test
	@Rollback(true)
	public void testAddTicketInfoList() {
		List<TicketInfoBO> list = new ArrayList<>();
		TicketInfoBO bo = new TicketInfoBO();
		bo.setLotteryCode(100);
		bo.setLotteryName("双色球");
		bo.setLotteryIssue("20170504");
		bo.setUserId(1l);
		bo.setTicketMoney(15.00);
		bo.setOrderCode("123");
		bo.setWinningStatus((short)1);
		bo.setEndTicketTime(DateUtil.convertStrToDate("2017-09-10",  "yyyy-MM-dd"));
		bo.setContentType(1);
		bo.setBuyScreen("123");
		bo.setLottoAdd((short)1);
		bo.setMultipleNum(4);
		bo.setTicketContent("123");
		bo.setSaleTime(DateUtil.convertStrToDate("2017-09-9",  "yyyy-MM-dd"));
		list.add(bo);
		ticketInfoDaoMapper.addTicketInfoList(list);
		
	}

}
