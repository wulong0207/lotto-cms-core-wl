package com.hhly.test;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.hhly.cmscore.cms.remote.service.IPaymentMgrService;
import com.hhly.persistence.util.HessianUtils;
import com.hhly.skeleton.cms.payment.vo.PayBankVO;
import com.hhly.skeleton.cms.payment.vo.PayChannelLimitVO;
import com.hhly.skeleton.cms.payment.vo.PayChannelMgrVO;
import com.hhly.skeleton.cms.payment.vo.PayChannelVO;

public class PaymentMgrServiceTest {
	
	private String url;
	
	private IPaymentMgrService sys;
	
	 @Before
	 public void before() throws MalformedURLException{
	    url = "http://localhost:8081/lotto-cms-core/remote//paymentMgrSercice";
	    sys = HessianUtils.getRemoteService(IPaymentMgrService.class, url);
	 }

	 @Test
	 public void testFindBank() {
		 PayBankVO vo = new PayBankVO();
		 vo.setId(1);
		 sys.findBank(vo);		 
	 }
	 
	 @Test
	 public void testFindChannel() {
		 PayChannelVO vo = getPayChannelVO();
		 sys.findChannel(vo);		 
	 }

	private PayChannelVO getPayChannelVO() {
		PayChannelVO vo = new PayChannelVO();
		 vo.setId(1);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		return vo;
	}	 
	 
	 @Test
	 public void testFindPayBankById() {		 
		 sys.findPayBankById(1);		 
	 }
	 	 
	 @Test
	 public void testFindBankLimit() {		 
		 sys.findBankLimit(1);		 
	 }	 
	 
	 @Test
	 public void testPageChannelMgrInfo() {	
		 PayChannelMgrVO vo = getPayChannelMgrVO();
		 sys.pageChannelMgrInfo(vo);		 
	 }
	 
	 @Test
	 public void testPageChannelLimitInfo() {	
		 PayChannelLimitVO vo = new PayChannelLimitVO();
		 vo.setId(1);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 sys.pageChannelLimitInfo(vo);		 
	 }
	 	 
	 @Test
	 public void testFindChannelMgrInfo() {	
		 PayChannelMgrVO vo = getPayChannelMgrVO();
		 sys.findChannelMgrInfo(vo);		 
	 }
	 
	 @Test
	 public void testPageChannelBankInfo() {	
		 PayChannelVO vo = getPayChannelVO();
		 sys.pageChannelBankInfo(vo);		 
	 }
	 
	 

	 private PayChannelMgrVO getPayChannelMgrVO() {
		 PayChannelMgrVO vo = new PayChannelMgrVO();
		 vo.setId(1);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 return vo;
	 }
	 
	 

}
