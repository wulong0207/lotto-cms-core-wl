package com.hhly.test;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.hhly.cmscore.cms.remote.service.ICustomerMgrService;
import com.hhly.persistence.util.HessianUtils;
import com.hhly.skeleton.cms.base.vo.StringVO;
import com.hhly.skeleton.cms.customermgr.vo.LottoCustomerVO;
import com.hhly.skeleton.cms.customermgr.vo.UserIssueLevelVO;
import com.hhly.skeleton.cms.customermgr.vo.UserIssueVO;
import com.hhly.skeleton.cms.customermgr.vo.UserTypeVO;
import com.hhly.skeleton.cms.customermgr.vo.UserWinningStatisticsVO;

public class CustomerMgrServiceTest {
	
	private String url;
	
	private ICustomerMgrService sys; 
	
	@Before
	public void before() throws MalformedURLException{
    	url = "http://localhost:8081/lotto-cms-core/remote/customerMgrService";
    	sys = HessianUtils.getRemoteService(ICustomerMgrService.class, url);
    }
	
	
	@Test
	public void testFindLottoCustomer() {
		LottoCustomerVO vo = new LottoCustomerVO();
		vo.setId(1);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		sys.findLottoCustomer(vo);
	}
	
	
	@Test
	public void testFindLottoCustomerDetail() {
		StringVO vo = new StringVO();
		vo.setStr("1");
		sys.findLottoCustomerDetail(vo);
	}
	
	@Test
	public void testListUserWinningStatistics() {
		UserWinningStatisticsVO vo = new UserWinningStatisticsVO();
		vo.setIdNum("1");
		vo.setPageIndex(0);
		vo.setPageSize(30);
		sys.listUserWinningStatistics(vo);
	}
	
	@Test
	public void testFindUserTypeList() {
		UserTypeVO vo = new UserTypeVO();
		vo.setId(1);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		sys.findUserTypeList(vo);
	}
	
	@Test
	public void testFindBaseUserType() {
		sys.findBaseUserType();
	}
		
	@Test
	public void testFindIds() {
		LottoCustomerVO vo = new LottoCustomerVO();
		vo.setId(1);
		sys.findIds(vo);
	}
	
	@Test
	public void testPageUserIssue() {
		UserIssueVO vo = getUserIssueVO();
		sys.pageUserIssue(vo);
	}


	private UserIssueVO getUserIssueVO() {
		UserIssueVO vo = new UserIssueVO();
		vo.setId(1);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		return vo;
	}
	
	@Test
	public void testFindUserIssue() {
		UserIssueVO vo = getUserIssueVO();
		sys.findUserIssue(vo);
	}
	
	@Test
	public void testFindOneUserIssueLevel() {
		UserIssueLevelVO vo = new UserIssueLevelVO();
		vo.setLotteryCode(100);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		sys.findOneUserIssueLevel(vo);
	}
	

}
