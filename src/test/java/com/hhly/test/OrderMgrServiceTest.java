package com.hhly.test;

import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.hhly.cmscore.cms.remote.service.IOrderMgrService;
import com.hhly.persistence.util.HessianUtils;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.common.OrderEnum.NumberCode;
import com.hhly.skeleton.cms.base.vo.StringVO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoCmsBO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderAddCmsVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderAddContentVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderAddIssueVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderFollowedVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderInfoCmsSearchVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderIssueVO;

public class OrderMgrServiceTest {
	private String url;
	
	private IOrderMgrService sys;
	
	OrderInfoCmsSearchVO vo = new OrderInfoCmsSearchVO();	
	
	OrderAddCmsVO orderAddCms = new OrderAddCmsVO();

    @Before
	public void before() throws MalformedURLException{
    	url = "http://localhost:8081/lotto-cms-core/remote/orderMgrService";
    	sys = HessianUtils.getRemoteService(IOrderMgrService.class, url);
    }
    
    @Test
    public void orderNo(){
    	Set<String> str = new HashSet<String>();
    	Random random = new Random();
    	int length =  NumberCode.values().length;
    	for (int i = 1; i < 2000; i++) {
    		int num = random.nextInt(length);
    		//System.out.println(num);
    		String code = ""/*sys.getOrderNo(NumberCode.values()[num].name())*/;
    		str.add(code);
    		System.out.println(code);
    		if(str.size()!=i){
    			System.out.println("重复了");
    			break;
    		}
		}
    	
    }
    
    @Test
    public void testFindOrderInfo() {   	
    	setOrderInfoCmsSearchVO();
    	sys.findOrderInfo(vo);
    }

    
    @Test
    public void testFindOrderInfoDetail() {
    	StringVO vo = new StringVO();
    	vo.setStr("D17082216300217200076");   	
    	sys.findOrderInfoDetail(vo);
    }
    
    @Test
    public void testFindOrderDetail() {
    	setOrderInfoCmsSearchVO();   	
    	sys.findOrderDetail(vo);
    }
    
    public void testFindSingleOrderAdd() {
    	setOrderAddCms();
    	sys.findSingleOrderAdd(orderAddCms);
    }
    
    @Test
    public void testFindPagingOrderAdd() {
    	setOrderAddCms();
    	sys.findPagingOrderAdd(orderAddCms);    	
    }
    
    @Test
    public void testFindExcelOrderAdd() {
    	setOrderAddCms();
    	sys.findExcelOrderAdd(orderAddCms);
    }
    
    @Test
    public void testFindExcelOrderAddUser() {
    	setOrderAddCms();
    	sys.findExcelOrderAddUser(orderAddCms);
    }

    @Test
    public void testFindPagingOrderAddContent() {   	
    	OrderAddContentVO orderAddContent = new OrderAddContentVO();
    	orderAddContent.setPageIndex(0);
    	orderAddContent.setPageSize(30);
    	sys.findPagingOrderAddContent(orderAddContent);
    	
    }
    
    @Test
    public void testFindPagingOrderAddIssue() {   	
    	OrderAddIssueVO orderAddIssue = new OrderAddIssueVO();
    	orderAddIssue.setIssueCode("2017147");
    	orderAddIssue.setPageIndex(0);
    	orderAddIssue.setPageSize(30);
    	sys.findPagingOrderAddIssue(orderAddIssue);
    }
    
    @Test
    public void testFindPagingSendPrize() {
    	setOrderInfoCmsSearchVO();
    	sys.findPagingSendPrize(vo);
    }
    
    @Test
    public void testListOrderIssue() {
    	OrderIssueVO vo = new OrderIssueVO();
    	vo.setLotteryCode(100);
    	vo.setLotteryIssue("2017147");
    	vo.setJoinOrder(true);
    	vo.setJoinUser(true);
    	vo.setJoinUserIssue(true);
    	vo.setPageIndex(0);
    	vo.setPageSize(30);
    	sys.listOrderIssue(vo);
    }
    
    @Test
    public void testListOrderFollowed() {
    	OrderFollowedVO vo = new OrderFollowedVO();
    	vo.setJoinOrder(true);
    	vo.setJoinUser(true);
    	vo.setPageIndex(0);
    	vo.setPageSize(30);   
    	sys.listOrderFollowed(vo);
    	
    }
    
	private void setOrderAddCms() {
		orderAddCms.setLotteryCode(100);
    	orderAddCms.setIssueCode("2017147");
    	orderAddCms.setPageIndex(0);
    	orderAddCms.setPageSize(30);
    	orderAddCms.setTimeType(1);
	}
	
	private void setOrderInfoCmsSearchVO() {
		vo.setLotteryCode("100");
		vo.setLotteryIssue("2017147");
		vo.setPageIndex(0);
		vo.setPageSize(30);
		vo.setTimeType("0");
	}
}