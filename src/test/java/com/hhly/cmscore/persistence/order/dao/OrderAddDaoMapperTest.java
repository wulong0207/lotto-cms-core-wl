
package com.hhly.cmscore.persistence.order.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.customer.po.LottoCustomerPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryBettingMulPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryChildPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryTypePO;
import com.hhly.cmscore.persistence.order.dao.OrderAddDaoMapper;
import com.hhly.cmscore.persistence.order.po.OrderAddContentPO;
import com.hhly.cmscore.persistence.order.po.OrderAddIssuePO;
import com.hhly.cmscore.persistence.order.po.OrderAddPO;
import com.hhly.skeleton.base.issue.entity.NewTypeBO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerBO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerExcelBO;
import com.hhly.skeleton.cms.customermgr.vo.LottoCustomerVO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryBettingMulBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryChildBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryTypeBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryTypeExcelBO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryChildCmsVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryTypeVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityVO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderAddBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderAddContentBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderAddIssueBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderAddUserExcelCmsBO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderAddCmsVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderAddContentVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderAddIssueVO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotBettingMulBO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotChildBO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotteryBO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotChildVO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotteryBettingMulVO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotteryVO;
import com.hhly.skeleton.lotto.base.order.bo.OrderAddInfoBO;
import com.hhly.skeleton.lotto.base.order.bo.OrderAddInfoSingleBO;
import com.hhly.skeleton.lotto.base.order.bo.OrderBaseInfoBO;
import com.hhly.skeleton.lotto.base.order.bo.UserChaseDetailBO;
import com.hhly.skeleton.lotto.base.order.bo.UserChaseRefundBO;
import com.hhly.skeleton.lotto.base.order.bo.UserChaseWinningDetailBO;
import com.hhly.skeleton.lotto.base.order.bo.UserNumOrderDetailBO;
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
public class OrderAddDaoMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	OrderAddDaoMapper orderAddDaoMapper;

	@Test
	public void testAdd() {
		OrderAddCmsVO a = new OrderAddCmsVO();
		a.setOrderAddCode("JZ1705271545250100077");
		OrderAddBO t = orderAddDaoMapper.findSingleOrderAdd(a);
		OrderAddPO  s = new OrderAddPO();
		s.setOrderAddCode(t.getOrderAddCode());
		s.setLotteryCode(t.getLotteryCode());
		s.setIssueCode(t.getIssueCode());
		s.setUserId(t.getUserId());
		s.setChannelId(t.getChannelId());
		s.setAddAmount(t.getAddAmount());
		s.setMultipleNum(t.getMultipleNum());
		s.setAddType(t.getAddType());
		s.setAddCount(t.getAddCount());
		s.setStopType(t.getStopType());
		s.setStopCondition(t.getStopCondition());
		s.setIsDltAdd(t.getIsDltAdd());
		s.setIssueAmount(t.getIssueAmount());
		s.setPayEndTime(new Date());
		s.setContainCurIssue((short) 1);
		int r = orderAddDaoMapper.addOrderAdd(s);
		System.out.println("返回: " + r);
	}
	
	@Test
	public void testAddOrderAddContent() {
		OrderAddContentVO a = new OrderAddContentVO();
		a.setOrderAddCode("JZ1705271545250100077");
		a.setPageIndex(0);
		a.setPageSize(10);
		List<OrderAddContentBO> tt = orderAddDaoMapper.findPagingOrderAddContent(a);
		OrderAddContentBO t = tt.get(0);
		List<OrderAddContentPO>  s = new ArrayList<>();
		OrderAddContentPO s1 = new OrderAddContentPO();
		s1.setOrderAddCode(t.getOrderAddCode());
		s1.setPlanContent(t.getPlanContent());
		s1.setMultiple(t.getMultiple());
		s1.setAmount(t.getAmount());
		s1.setPlayIntro(t.getPlayIntro());
		s1.setCodeWay(t.getCodeWay());
		s1.setContentType(t.getContentType());
		s1.setLotteryChildCode(t.getLotteryChildCode());
		s1.setBuyNumber(t.getBuyNumber());
		s.add(s1);
		s1 = new OrderAddContentPO();
		s1.setOrderAddCode(t.getOrderAddCode());
		s1.setPlanContent(t.getPlanContent());
		s1.setMultiple(t.getMultiple());
		s1.setAmount(t.getAmount());
		s1.setPlayIntro(t.getPlayIntro());
		s1.setCodeWay(t.getCodeWay());
		s1.setContentType(t.getContentType());
		s1.setLotteryChildCode(t.getLotteryChildCode());
		s1.setBuyNumber(t.getBuyNumber());
		s.add(s1);
		int r = orderAddDaoMapper.addOrderAddContent(s);
		System.out.println("返回: " + r);
	}
	
	@Test
	public void testAddOrderAddIssue() {
		OrderAddIssueVO  a = new OrderAddIssueVO();
		a.setOrderAddCode("JZ1705271545250100077");
		a.setPageIndex(0);
		a.setPageSize(10);
		List<OrderAddIssueBO> tt = orderAddDaoMapper.findPagingOrderAddIssue(a);
		OrderAddIssueBO t = tt.get(0);
		List<OrderAddIssuePO>  s = new ArrayList<>();
		OrderAddIssuePO s1 = new OrderAddIssuePO();
		s1.setOrderAddCode(t.getOrderAddCode());
		s1.setIssueCode(t.getIssueCode()+"1");
		s1.setBuyAmount(t.getBuyAmount());
		s1.setMultiple(t.getMultiple());
		s1.setFlag(1);
		s.add(s1);
		s1 = new OrderAddIssuePO();
		s1.setOrderAddCode(t.getOrderAddCode());
		s1.setIssueCode(t.getIssueCode()+"2");
		s1.setBuyAmount(t.getBuyAmount());
		s1.setMultiple(t.getMultiple());
		s1.setFlag(1);
		s.add(s1);
		int r = orderAddDaoMapper.addOrderAddIssue(s);
		System.out.println("返回: " + r);
	}
	
	@Test
	public void testfindPagingUserChaseContent() {
		UserChaseDetailQueryVO s = new UserChaseDetailQueryVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderAddCode("JZ1705271545250100077");
		List<UserNumOrderDetailBO> t = orderAddDaoMapper.findPagingUserChaseContent(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindCountUserChaseContent() {
		UserChaseDetailQueryVO s = new UserChaseDetailQueryVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderAddCode("JZ1705271545250100077");
		int t = orderAddDaoMapper.findCountUserChaseContent(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindPagingUserChaseDetail() {
		UserChaseDetailQueryVO s = new UserChaseDetailQueryVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderAddCode("JZ1705271545250100077");
		List<UserChaseDetailBO> t = orderAddDaoMapper.findPagingUserChaseDetail(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindCountUserChaseDetail() {
		UserChaseDetailQueryVO s = new UserChaseDetailQueryVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderAddCode("JZ1705271545250100077");
		int t = orderAddDaoMapper.findCountUserChaseDetail(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindCurChasingIssue() {
		UserChaseDetailQueryVO s = new UserChaseDetailQueryVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderAddCode("JZ1705271545250100077");
		String t = orderAddDaoMapper.findCurChasingIssue(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindCountChaseCancel() {
		UserChaseDetailQueryVO s = new UserChaseDetailQueryVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderAddCode("JZ1705271545250100077");
		s.setUserId(678);
		int t = orderAddDaoMapper.findCountChaseCancel(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindChaseRefundAmount() {
		UserChaseDetailQueryVO s = new UserChaseDetailQueryVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setUserId(678);
		s.setOrderAddCode("JZ1705271545250100077");
		s.setAddStatus((short) 5);
		UserChaseRefundBO t = orderAddDaoMapper.findChaseRefundAmount(s);
		System.out.println("返回: " + t.getRefundAmount());
	}
	@Test
	public void testupdChaseIssue() {
		UserChaseDetailQueryVO  s = new UserChaseDetailQueryVO();
		s.setUserId(678);
		s.setNewAddStatus((short) 2);
		s.setOrderAddCode("JZ1705271545250100077");
		s.setAddStatus((short) 5);
		int t = orderAddDaoMapper.updChaseIssue(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testupdChaseEnd() {
		UserChaseDetailQueryVO  s = new UserChaseDetailQueryVO();
		s.setUserId(678);
		s.setNewAddStatus((short) 2);
		s.setOrderAddCode("JZ1705271545250100077");
		s.setAddStatus((short) 5);
		int t = orderAddDaoMapper.updChaseEnd(s);
		System.out.println("返回: " + t);
	}
	
	@Test
	public void testfindUserChaseWinningDetail() {
		UserChaseDetailQueryVO s = new UserChaseDetailQueryVO();
		s.setOrderAddCode("JZ1705271545250100077");
		 List<UserChaseWinningDetailBO> t = orderAddDaoMapper.findUserChaseWinningDetail(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindStopChasingIssue() {
		UserChaseDetailQueryVO s = new UserChaseDetailQueryVO();
		s.setOrderAddCode("JZ1705271545250100077");
		String t = orderAddDaoMapper.findStopChasingIssue(s);
		System.out.println("返回: " + t);
	}
	
	
	@Test
	public void testfindPagingOrderAdd() {
		OrderAddCmsVO s = new OrderAddCmsVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setLotteryCode(100);
		s.setIssueCode("2016061");
		OperateActivityVO activity = new OperateActivityVO();
		activity.setActivityName("啊啊啊啊");
		s.setActivity(activity);
		List<OrderAddBO> t = orderAddDaoMapper.findPagingOrderAdd(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindCountOrderAdd() {
		OrderAddCmsVO s = new OrderAddCmsVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setLotteryCode(100);
		s.setIssueCode("2016061");
		OperateActivityVO activity = new OperateActivityVO();
		activity.setActivityName("啊啊啊啊");
		s.setActivity(activity);
	Map<String, Object> t = orderAddDaoMapper.findCountOrderAdd(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindSingleOrderAdd() {
		OrderAddCmsVO s = new OrderAddCmsVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setLotteryCode(100);
		s.setIssueCode("2016061");
		OperateActivityVO activity = new OperateActivityVO();
		activity.setActivityName("啊啊啊啊");
		s.setActivity(activity);
		OrderAddBO t = orderAddDaoMapper.findSingleOrderAdd(s);
		System.out.println("返回: " + t);
	}
	
	@Test
	public void testfindExcelOrderAdd() {
		OrderAddCmsVO s = new OrderAddCmsVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setLotteryCode(100);
		s.setIssueCode("2016061");
		OperateActivityVO activity = new OperateActivityVO();
		activity.setActivityName("啊啊啊啊");
		s.setActivity(activity);
		List<OrderAddBO> t = orderAddDaoMapper.findExcelOrderAdd(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindExcelOrderAddUser() {
		OrderAddCmsVO s = new OrderAddCmsVO();
		s.setPageIndex(0);
		s.setPageSize(3);
		s.setLotteryCode(100);
		List<OrderAddUserExcelCmsBO> t = orderAddDaoMapper.findExcelOrderAddUser(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindPagingOrderAddContent() {
		OrderAddContentVO  s = new OrderAddContentVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderAddCode("JZ1705271545250100077");
		List<OrderAddContentBO> t = orderAddDaoMapper.findPagingOrderAddContent(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindCountOrderAddContent() {
		OrderAddContentVO  s = new OrderAddContentVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderAddCode("JZ1705271545250100077");
		 int t = orderAddDaoMapper.findCountOrderAddContent(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindPagingOrderAddIssue() {
		OrderAddIssueVO   s = new OrderAddIssueVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderAddCode("JZ1705271545250100077");
		 List<OrderAddIssueBO> t = orderAddDaoMapper.findPagingOrderAddIssue(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindCountOrderAddIssue() {
		OrderAddIssueVO   s = new OrderAddIssueVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderAddCode("JZ1705271545250100077");
		 List<OrderAddIssueBO> t = orderAddDaoMapper.findPagingOrderAddIssue(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testfindExcelOrderAddIssue() {
		OrderAddIssueVO   s = new OrderAddIssueVO();
		s.setPageIndex(0);
		s.setPageSize(10);
		s.setOrderAddCode("JZ1705271545250100077");
		 List<OrderAddIssueBO> t = orderAddDaoMapper.findExcelOrderAddIssue(s);
		System.out.println("返回: " + t);
	}
	
	@Test
	public void testfindOrderAddInfo() {
		OrderAddInfoBO t = orderAddDaoMapper.findOrderAddInfo("JZ1705271545250100077");
		System.out.println("返回: " + t);
	}
	@Test
	public void testqueryOrderAddInfo() {
		OrderBaseInfoBO t = orderAddDaoMapper.queryOrderAddInfo("JZ1705271545250100077",678);
		System.out.println("返回: " + t);
	}
	@Test
	public void testqueryOrderAddStopReason() {
		OrderAddInfoSingleBO t = orderAddDaoMapper.queryOrderAddStopReason("JZ1705271545250100077",678);
		System.out.println("返回: " + t);
	}
	@Test
	public void testbatchCancelAddOrderList() {
		List<String> s1 = new ArrayList<>();
		s1.add("JZ1705271545250100077");
		orderAddDaoMapper.batchCancelAddOrderList(s1,678,(short)5);
	}
}
