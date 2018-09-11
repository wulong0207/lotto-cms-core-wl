
package com.hhly.cmscore.persistence.order.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hhly.skeleton.lotto.base.order.bo.*;
import com.hhly.skeleton.lotto.base.order.vo.OrderDetailVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hhly.cmscore.cms.remote.service.status.entity.UpdateStatusBO;
import com.hhly.cmscore.persistence.order.dao.OrderInfoDaoMapper;
import com.hhly.cmscore.persistence.order.po.OrderAddContentPO;
import com.hhly.cmscore.persistence.order.po.OrderDetailPO;
import com.hhly.cmscore.persistence.order.po.OrderInfoPO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderDetailBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoCmsBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoCmsExcelBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoCmsUserExcelBO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderInfoCmsSearchVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderInfoVO;
import com.hhly.skeleton.lotto.base.order.vo.OrderQueryVo;
import com.hhly.skeleton.lotto.base.order.vo.OrderStatisticsQueryVo;
import com.hhly.skeleton.lotto.base.order.vo.UserChaseDetailQueryVO;

/**
 * @desc 彩种测试
 * @author huangb
 * @date 2017年6月6日
 * @company 益彩网络
 * @version v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) 
public class OrderInfoDaoMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	OrderInfoDaoMapper orderInfoDaoMapper;

	@Test
	public void testaddOrder() {
		OrderInfoCmsSearchVO  a = new OrderInfoCmsSearchVO();
		a.setOrderCode("D1706061542120100003");
		List<OrderInfoCmsBO> tt = orderInfoDaoMapper.find(a);
		OrderInfoCmsBO t = tt.get(0);
		OrderInfoPO  s = new OrderInfoPO();
		s.setOrderCode("D1706061542120100333");
		s.setLotteryCode(t.getLotteryCode());
		s.setLotteryName("adfasd");
		s.setLotteryIssue(t.getLotteryIssue());
		s.setUserId(210);
		s.setOrderAmount(t.getOrderAmount());
		s.setMultipleNum(1111);
		s.setBuyType((short)1);
		s.setPayStatus((short)1);
		s.setOrderStatus((short)1);
		s.setWinningStatus((short)1);
		s.setChannelId("1111111111");
		s.setIsDltAdd(t.getIsDltAdd());
		s.setBuyScreen("1111");
		s.setMaxBuyScreen("SDSS");
		s.setEndTicketTime(new Date());
		s.setEndCheckTime(new Date());
		s.setEndSysTime(new Date());
		s.setLotteryChildCode(10001);
		s.setBuyNumber(111);
		int r = orderInfoDaoMapper.addOrder(s);
		System.out.println("返回: " + r);
	}
	@Test
	public void testaddOrderDetail() {
		
		OrderInfoCmsSearchVO a = new OrderInfoCmsSearchVO();
		a.setOrderCode("D1706061542120100003");
		a.setPageIndex(0);
		a.setPageSize(10);
		List<OrderDetailBO> tt = orderInfoDaoMapper.findOrderDetail(a);
		OrderDetailBO t = tt.get(0);
		List<OrderDetailPO>  s = new ArrayList<>();
		OrderDetailPO s1 = new OrderDetailPO();
		s1.setOrderCode("D1706061542120100333");
		s1.setPlanContent(t.getPlanContent());
		s1.setMultiple(t.getMultiple());
		s1.setAmount(t.getAmount());
		s1.setPlayIntro(t.getPlayIntro());
		s1.setCodeWay(t.getCodeWay());
		s1.setContentType(t.getContentType());
		s1.setLotteryChildCode(t.getLotteryChildCode());
		s1.setBuyNumber(11);
		s.add(s1);
		s1 = new OrderAddContentPO();
		s1.setOrderCode("D1706061542120100333");
		s1.setPlanContent(t.getPlanContent());
		s1.setMultiple(t.getMultiple());
		s1.setAmount(t.getAmount());
		s1.setPlayIntro(t.getPlayIntro());
		s1.setCodeWay(t.getCodeWay());
		s1.setContentType(t.getContentType());
		s1.setLotteryChildCode(t.getLotteryChildCode());
		s1.setBuyNumber(22);
		s.add(s1);
		int r = orderInfoDaoMapper.addOrderDetail(s);
	
		System.out.println("返回: " + r);
	}
	
	
	@Test
	public void testfindPagingUserOrderDetail() {
		UserChaseDetailQueryVO s = new UserChaseDetailQueryVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderAddCode("JZ1705271545250100077");
		List<UserNumOrderDetailBO> t = orderInfoDaoMapper.findPagingUserOrderDetail(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindCountUserOrderDetail() {
		UserChaseDetailQueryVO s = new UserChaseDetailQueryVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderAddCode("JZ1705271545250100077");
		int t = orderInfoDaoMapper.findCountUserOrderDetail(s);
		System.out.println("返回: " + t);
	}
	
	@Test
	public void testupdEndCheckTime() {
		Integer endCheckTime = 1;
		Integer lotteryCode = 100;
		String issueCode = "sdfasd";
		int t = orderInfoDaoMapper.updEndCheckTime(endCheckTime, lotteryCode, issueCode);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfind() {
		OrderInfoCmsSearchVO  s = new OrderInfoCmsSearchVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderCode("JZ1705271545250100077");
		s.setLotteryIssue("2016061");
		s.setWinningDetail("啊啊");
		List<OrderInfoCmsBO> t = orderInfoDaoMapper.find(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindTotal() {
		OrderInfoCmsSearchVO  s = new OrderInfoCmsSearchVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderCode("JZ1705271545250100077");
		s.setLotteryIssue("2016061");
		s.setWinningDetail("啊啊");
		Map<String, Object> t = orderInfoDaoMapper.findTotal(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindOrderCodeByDetail() {
		OrderInfoCmsSearchVO s = new OrderInfoCmsSearchVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		List<String> t = orderInfoDaoMapper.findOrderCodeByDetail(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindOrderInfoDetail() {
		String orderCode = "JZ1705271545250100077";
		Object t = orderInfoDaoMapper.findOrderInfoDetail(orderCode);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindOrderDetail() {
		OrderInfoCmsSearchVO  s = new OrderInfoCmsSearchVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderCode("D1706061542120100003");
		List<OrderDetailBO> t = orderInfoDaoMapper.findOrderDetail(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindOrderDetailCount() {
		OrderInfoCmsSearchVO   s = new OrderInfoCmsSearchVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderCode("D1706061542120100003");
		int t = orderInfoDaoMapper.findOrderDetailCount(s);
		System.out.println("返回: " + t);
	}
	
	@Test
	public void testupdOrderInfo() {
		OrderInfoVO  s = new OrderInfoVO();
		s.setModifyBy("sdssd");
		s.setRemark("1111111");
		s.setMaxBuyScreen("111111");
		s.setId(11111111L);
		Object t = orderInfoDaoMapper.updOrderInfo(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testgetOrderInfoExcel() {
		OrderInfoCmsSearchVO  s = new OrderInfoCmsSearchVO();
		s.setOrderCode("D1706061542120100003");
		List<OrderInfoCmsExcelBO> t = orderInfoDaoMapper.getOrderInfoExcel(s);
		System.out.println("返回: " + t);
	}
	
	
	@Test
	public void testgetOrderInfoUserExcel() {
		OrderInfoCmsSearchVO s = new OrderInfoCmsSearchVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderCode("D1706061542120100003");
		List<OrderInfoCmsUserExcelBO> t = orderInfoDaoMapper.getOrderInfoUserExcel(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testupdTicketAndCheckTime() {
	 int t = orderInfoDaoMapper.updTicketAndCheckTime(new HashMap<String, Object>());
		System.out.println("返回: " + t);
	}

	@Test
	public void testfindPagingSendPrize() {
		OrderInfoCmsSearchVO s = new OrderInfoCmsSearchVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderCode("D1706061542120100003");
		List<OrderInfoCmsBO> t = orderInfoDaoMapper.findPagingSendPrize(s);
		System.out.println("返回: " + t);
	}
	
	@Test
	public void testfindCountSendPrize() {
		OrderInfoCmsSearchVO s = new OrderInfoCmsSearchVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderCode("D1706061542120100003");
		Map<String, Object> t = orderInfoDaoMapper.findCountSendPrize(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindExcelSendPrize() {
		OrderInfoCmsSearchVO s = new OrderInfoCmsSearchVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderCode("D1706061542120100003");
		List<OrderInfoCmsBO> t = orderInfoDaoMapper.findExcelSendPrize(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testgetMonitorOrderInfo() {
		int lotteryCode = 100;
		String lotteryIssue = "2016061";
		OrderInfoCmsBO t = orderInfoDaoMapper.getMonitorOrderInfo(lotteryCode, lotteryIssue);
		System.out.println("返回: " + t);
	}
	@Test
	public void testlistOrderInfoStatus() {
		List<String> orderCodes = new  ArrayList<>();
		orderCodes.add("D1706061542120100003");
		 List<UpdateStatusBO> t = orderInfoDaoMapper.listOrderInfoStatus(orderCodes);
		System.out.println("返回: " + t);
	}
	@Test
	public void testqueryOrderListInfo() {
		OrderQueryVo    s = new OrderQueryVo();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderCode("D1706061542120100003");
		List<OrderBaseInfoBO> t = orderInfoDaoMapper.queryOrderListInfo(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testqueryOrderListInfoCount() {
		OrderQueryVo    s = new OrderQueryVo();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderCode("D1706061542120100003");
		 Integer t = orderInfoDaoMapper.queryOrderListInfoCount(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testqueryOrderDetailInfo() {
		String orderCode = "D1706061542120100003";
		Integer userId = 210;
		OrderDetailVO orderDetailVO = new OrderDetailVO();
		orderDetailVO.setOrderCode(orderCode);
		orderDetailVO.setUserId(userId);
		List<OrderDetailInfoBO> t = orderInfoDaoMapper.queryOrderDetailInfo(orderDetailVO);
		System.out.println("返回: " + t);
	}
	
	@Test
	public void testqueryOrderStatisInfo() {
		OrderStatisticsQueryVo    s = new OrderStatisticsQueryVo();
		OrderStatisticsInfoBO t = orderInfoDaoMapper.queryOrderStatisInfo(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testgetOrderInfo() {
		String orderCode = "D1706061542120100003";
		OrderInfoBO t = orderInfoDaoMapper.getOrderInfo(orderCode);
		System.out.println("返回: " + t);
	}
	@Test
	public void testqueryHomeOrderList() {
		OrderQueryVo    s = new OrderQueryVo();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderCode("D1706061542120100003");
		s.setStatus(1);
		List<OrderBaseInfoBO> t = orderInfoDaoMapper.queryHomeOrderList(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void teststatisOrderBetAndWinCount() {
		OrderQueryVo    s = new OrderQueryVo();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderCode("D1706061542120100003");
		s.setStatus(1);
		OrderStatisBO t = orderInfoDaoMapper.statisOrderBetAndWinCount(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testqueryOrderInfo() {
		String orderCode = "D1706061542120100003";
		Integer userId = 210;
		OrderBaseInfoBO t = orderInfoDaoMapper.queryOrderInfo(orderCode, userId);
		System.out.println("返回: " + t);
	}
	@Test
	public void testqueryNoPayOrderList() {
		List<String> orderListCode = new ArrayList<>();
		orderListCode.add("D1706061542120100003");
		Integer userId = 210;
		String lotteryCode = "100";
		String lotteryIssue= "2016006";
		String flag = "sds";
		List<OrderInfoLimitBO> t = orderInfoDaoMapper.queryNoPayOrderList(orderListCode, userId, lotteryCode, lotteryIssue, flag);
		System.out.println("返回: " + t);
	}
	@Test
	public void testqueryNoPayOrderListCount() {
		List<String> orderListCode = new ArrayList<>();
		orderListCode.add("D1706061542120100003");
		Integer userId = 210;
		String lotteryCode = "100";
		String lotteryIssue= "2016006";
		String flag = "sds";
		int t = orderInfoDaoMapper.queryNoPayOrderListCount(orderListCode, userId, lotteryCode, lotteryIssue);
		System.out.println("返回: " + t);
	}
}
