
package com.hhly.cmscore.persistence.lottery.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
import com.hhly.cmscore.persistence.lottery.dao.LotteryTypeDaoMapper;
import com.hhly.cmscore.persistence.lottery.po.LotteryTypePO;
import com.hhly.skeleton.base.issue.entity.NewTypeBO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerBO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerExcelBO;
import com.hhly.skeleton.cms.customermgr.vo.LottoCustomerVO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryTypeBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryTypeExcelBO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryTypeVO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotteryBO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotteryVO;

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
public class LotteryTypeDaoMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	LotteryTypeDaoMapper lotteryTypeDaoMapper;

	@Test
	public void testFind() {
		LotteryTypeVO vo = new LotteryTypeVO();
		vo.setLotteryCode(100);
		vo.setLotteryName("双色球");
		vo.setLotteryCategory((short) 1);
		vo.setSaleStatus((short) 1);
		List<LotteryTypeBO> list = lotteryTypeDaoMapper.find(vo);
		System.out.println("数量 : " + list.size());
	}

	@Test
	public void testFindTotal() {
		LotteryTypeVO vo = new LotteryTypeVO();
		vo.setLotteryCode(100);
		vo.setLotteryName("双色球");
		vo.setLotteryCategory((short) 1);
		vo.setSaleStatus((short) 1);
		int num = lotteryTypeDaoMapper.findTotal(vo);
		System.out.println("num : " + num);
	}

	@Test
	public  void testFindLotteryTypeToExcel() {
		LotteryTypeVO vo = new LotteryTypeVO();
		vo.setLotteryCode(100);
		vo.setLotteryName("双色球");
		vo.setLotteryCategory((short) 1);
		vo.setSaleStatus((short) 1);
		List<LotteryTypeExcelBO> list = lotteryTypeDaoMapper.findLotteryTypeToExcel(vo);
		System.out.println("数量 : " + list.size());
	}

	@Test
	public  void testFindCountCode() {
		Integer code = 100;
		int t = lotteryTypeDaoMapper.findCountCode(code);
		System.out.println("返回：" +t);
	}

	@Test
	//@Rollback(false)  // 控制事务是否回滚
	public  void testAdd() {
		LotteryTypeVO vo = new LotteryTypeVO();
		vo.setLotteryCode(100);
		vo.setLotteryName("双色球");
		vo.setLotteryCategory((short) 1);
		vo.setSaleStatus((short) 1);
		List<LotteryTypeBO> list = lotteryTypeDaoMapper.find(vo);
		LotteryTypeBO BO = list.get(0);
		LotteryTypePO po = new LotteryTypePO();
		po.setId(BO.getId());
		po.setLotteryCode(BO.getLotteryCode());
		po.setLotteryName(BO.getLotteryName());
		po.setConIssueNum(BO.getConIssueNum());
		po.setStopAddIssue(BO.getStopAddIssue());
		po.setLotteryLogoUrl(BO.getLotteryLogoUrl());
		po.setAdminCategory(BO.getAdminCategory());
		po.setLotteryCategory(BO.getLotteryCategory());
		po.setSaleStatus(BO.getSaleStatus());
		po.setArea(BO.getArea());
		po.setAutoType(BO.getAutoType());
		po.setSynIssue(BO.getSynIssue());
		po.setSaleTime(BO.getSaleTime());
		po.setBuyEndTime(BO.getBuyEndTime());
		po.setSplitMaxNum(BO.getSplitMaxNum());
		po.setEndCheckTime(BO.getEndCheckTime());
		po.setSplitMaxAmount(BO.getSplitMaxAmount());
		po.setCreateBy(BO.getCreateBy());
		po.setRemark(BO.getRemark());
		po.setFormat(BO.getFormat());
		po.setComeOutTime(BO.getComeOutTime());
		int num = lotteryTypeDaoMapper.add(po);
		System.out.println("返回 : " + num);
	}

	@Test
	public  void testFindLotteryTypeByKey() {
		LotteryTypePO po = lotteryTypeDaoMapper.findLotteryTypeByKey(100);
		System.out.println("返回:" + po);
	}

	@Test
	public  void testFindLotteryTypeCheck() {
		LotteryTypePO po = lotteryTypeDaoMapper.findLotteryTypeCheck(100);
		System.out.println("返回:" + po);
	}
	
	@Test
	public  void testFindSingle() {
		LotteryTypeVO t = new LotteryTypeVO();
		t.setId(100);
		LotteryTypeBO po = lotteryTypeDaoMapper.findSingle(t);
		System.out.println("返回:" + po);
	}
	
	@Test
	public  void testFindLotteryTypeDic() {
		String category = "1";
		List<LotteryTypeBO> t = lotteryTypeDaoMapper.findLotteryTypeDic(category);
		System.out.println("返回:" + t.size());
	}
	@Test
	public  void testFindLotteryName() {
		List<String> ids = new ArrayList<>();
		ids.add("100");
		ids.add("102");
		List<LotteryTypeBO> t = lotteryTypeDaoMapper.findLotteryName(ids);
		System.out.println("返回:" + t.size());
	}
	@Test
	public  void testFindSingleFront() {
		LotteryVO t = new  LotteryVO();
		t.setLotteryCode(100);
		LotteryBO tt = lotteryTypeDaoMapper.findSingleFront(t);
		System.out.println("返回:" + tt);
	}
	@Test
	public  void testFindMultipleFront() {
		LotteryVO t = new  LotteryVO();
		t.setLotteryCode(100);
		List<LotteryBO> tt = lotteryTypeDaoMapper.findMultipleFront(t);
		System.out.println("返回:" + tt.size());
	}
	@Test
	public  void testFindTypeUseAddIssue() {
		int lotteryCode = 100;
		NewTypeBO tt = lotteryTypeDaoMapper.findTypeUseAddIssue(lotteryCode);
		System.out.println("返回:" + tt);
	}
	@Test
	public  void testFindAllLotteryType() {
		List<LotteryTypeBO> tt = lotteryTypeDaoMapper.findAllLotteryType();
		System.out.println("返回:" + tt.size());
	}
}
