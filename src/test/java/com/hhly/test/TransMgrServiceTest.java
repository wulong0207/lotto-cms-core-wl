package com.hhly.test;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.hhly.cmscore.cms.remote.service.ITransMgrService;
import com.hhly.persistence.util.HessianUtils;
import com.hhly.skeleton.cms.transmgr.vo.TransChannelSettleVO;
import com.hhly.skeleton.cms.transmgr.vo.TransRechargeVO;
import com.hhly.skeleton.cms.transmgr.vo.TransRedVO;
import com.hhly.skeleton.cms.transmgr.vo.TransTakenVO;
import com.hhly.skeleton.cms.transmgr.vo.TransUserVO;

public class TransMgrServiceTest {
	
	private String url;
	
	private ITransMgrService sys;	
	
	@Before
	public void before() throws MalformedURLException{
	    url = "http://localhost:8081/lotto-cms-core/remote//transMgrService";
	    sys = HessianUtils.getRemoteService(ITransMgrService.class, url);
	}
	
	@Test
	public void testFindUserTrans() {
		TransUserVO vo = new TransUserVO();
		vo.setLotteryCode(100);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		sys.findUserTrans(vo);		
	}
	
	@Test
	public void testFindRedTrans() {
		TransRedVO vo = new TransRedVO();
		vo.setLotteryCode(100);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		sys.findRedTrans(vo);		
	}
	
	@Test
	public void testFindRechargeTrans() {
		TransRechargeVO vo = new TransRechargeVO();
		vo.setPayType(2);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		sys.findRechargeTrans(vo);		
	}
	
	@Test
	public void testFindTakenTrans() {
		TransTakenVO vo = getTransTakenVO();
		sys.findTakenTrans(vo);		
	}
	
	@Test
	public void testFindChannelSettleTrans() {
		TransChannelSettleVO vo = new TransChannelSettleVO();
		vo.setChannelId((long) 1);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		sys.findChannelSettleTrans(vo);		
	}
	
	@Test
	public void testFindTransTakenBatchNums() {
		TransTakenVO vo = getTransTakenVO();
		sys.findTransTakenBatchNums(vo);		
	}

	
	@Test
	public void testFindTakenTransNoPaging() {
		TransTakenVO vo = getTransTakenVO();
		sys.findTakenTransNoPaging(vo);		
	}
		
	private TransTakenVO getTransTakenVO() {
		TransTakenVO vo = new TransTakenVO();
		vo.setId((long) 1);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		return vo;
	}	
	
}
