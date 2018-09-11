package com.hhly.test;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.hhly.cmscore.cms.remote.service.ITicketMgrService;
import com.hhly.persistence.util.HessianUtils;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketAlarmConfigVO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketAlarmInfoVO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketChannelVO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketConfigVO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketInfoVO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketMonitorConfigVO;

public class TicketMgrServiceTest {
	
	private String url;
	
	private ITicketMgrService sys;
	
	@Before
	public void before() throws MalformedURLException{
	    url = "http://localhost:8081/lotto-cms-core/remote//ticketMgrService";
	    sys = HessianUtils.getRemoteService(ITicketMgrService.class, url);
	}
	
	@Test
	public void testListTicketChannel() {
		TicketChannelVO vo = new TicketChannelVO();
		vo.setId(1);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		sys.listTicketChannel(vo);	
	}
	
	@Test
	public void testListDrawerName() {
		sys.listDrawerName();		
	}
	
	@Test
	public void testListDrawerIdName() {
		sys.listDrawerIdName("");		
	}
	
	@Test
	public void testListTicketConfig() {
		TicketConfigVO vo = new TicketConfigVO();
		vo.setId(1);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		sys.listTicketConfig(vo);		
	}
	
	@Test
	public void testListTicketAlarmInfo() {
		TicketAlarmInfoVO vo = new TicketAlarmInfoVO();
		vo.setId(1);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		sys.listTicketAlarmInfo(vo);		
	}
	
	@Test
	public void testListTicketAlarmConfig() {
		TicketAlarmConfigVO vo = new TicketAlarmConfigVO();
		vo.setId(1);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		sys.listTicketAlarmConfig(vo);		
	}
	
	@Test
	public void testListTicketMonitorConfig() {
		TicketMonitorConfigVO vo = new TicketMonitorConfigVO();
		vo.setId(1);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		sys.listTicketMonitorConfig(vo);		
	}
	
	@Test
	public void testListTicketMonitorCommon() {		
		sys.listTicketMonitorCommon();		
	}
	
	@Test
	public void testQueryLotteryMonitorConfig() {		
		sys.queryLotteryMonitorConfig(1);		
	}
		
	@Test
	public void testGetTicketMonitor() {		
		sys.getTicketMonitor(100);		
	}
	
	@Test
	public void testGetRefreshTime() {		
		sys.getRefreshTime(100);		
	}
	
	@Test
	public void testGetLotteryIssueMonitor() {		
		sys.getLotteryIssueMonitor(100);		
	}
	
	@Test
	public void testGetChannelConfigKey() {		
		sys.getChannelConfigKey("1",100);		
	}
	
	@Test
	public void testGetMonitorOrderInfo() {		
		sys.getMonitorOrderInfo(100,"2016060");		
	}
	
	@Test
	public void testGetLotteryIssueMonitorSport() {		
		sys.getLotteryIssueMonitorSport(100);		
	}
	
	@Test
	public void testListOrderTicketChannel() {
		TicketInfoVO vo = getTicketInfoVO();
		sys.listOrderTicketChannel(vo);		
	}
	
	@Test
	public void testFindPagingTicket() {
		TicketInfoVO vo = getTicketInfoVO();
		sys.findPagingTicket(vo);		
	}
	
	@Test
	public void testFindTicketAlarmInfo() {
		TicketAlarmInfoVO vo = new TicketAlarmInfoVO();
		vo.setId(1);
		sys.findTicketAlarmInfo(vo);		
	}

	private TicketInfoVO getTicketInfoVO() {
		TicketInfoVO vo = new TicketInfoVO();
		vo.setId((long) 1);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		return vo;
	}
	
	
	

}
