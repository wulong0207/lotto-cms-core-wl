
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
import com.hhly.cmscore.persistence.lottery.dao.LotteryBettingMulDaoMapper;
import com.hhly.cmscore.persistence.lottery.po.LotteryBettingMulPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryTypePO;
import com.hhly.skeleton.base.issue.entity.NewTypeBO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerBO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerExcelBO;
import com.hhly.skeleton.cms.customermgr.vo.LottoCustomerVO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryBettingMulBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryTypeBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryTypeExcelBO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryTypeVO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotBettingMulBO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotteryBO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotteryBettingMulVO;
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
public class LotteryBettingMulDaoMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	LotteryBettingMulDaoMapper lotteryBettingMulDaoMapper;

	@Test
	public void testFindByCode() {
		String code = "100";
		List<LotteryBettingMulBO> list = lotteryBettingMulDaoMapper.findByCode(code);
		System.out.println("返回: " + list.size());
	}
	
	@Test
	public void testAdd() {
		String code = "100";
		List<LotteryBettingMulBO> list = lotteryBettingMulDaoMapper.findByCode(code);
		LotteryBettingMulBO t = list.get(0);
		LotteryBettingMulPO s = new LotteryBettingMulPO();
		s.setLotteryCode(t.getLotteryCode());
		s.setBettindNum(t.getBettindNum());
		s.setMultipleNum(t.getMultipleNum());
		s.setEndTime(t.getEndTime());
		int r = lotteryBettingMulDaoMapper.add(s);
		System.out.println("返回: " + r);
	}
	@Test
	public void testUpdByPrimaryKey() {
		String code = "100";
		List<LotteryBettingMulBO> list = lotteryBettingMulDaoMapper.findByCode(code);
		LotteryBettingMulBO t = list.get(0);
		LotteryBettingMulPO s = new LotteryBettingMulPO();
		s.setLotteryCode(t.getLotteryCode());
		s.setBettindNum(t.getBettindNum());
		s.setMultipleNum(t.getMultipleNum());
		s.setEndTime(t.getEndTime());
		int r = lotteryBettingMulDaoMapper.updByPrimaryKey(s);
		System.out.println("返回: " + r);
	}
	@Test
	public void testDelByPrimaryKeyList() {
		List<String> ids = new ArrayList<>();
		ids.add("10000");
		ids.add("10200");
		int r = lotteryBettingMulDaoMapper.delByPrimaryKeyList(ids);
		System.out.println("返回: " + r);
	}
	@Test
	public void testFindSingle() {
		LotteryBettingMulVO s = new LotteryBettingMulVO();
		s.setLotteryCode(100);
		LotteryBettingMulBO t = lotteryBettingMulDaoMapper.findSingle(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testFindMinEndTime() {
		LotteryBettingMulVO s = new LotteryBettingMulVO();
		s.setLotteryCode(100);
		Long t = lotteryBettingMulDaoMapper.findMinEndTime(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testFindMultipleFront() {
		LotteryVO s = new LotteryVO();
		s.setLotteryCode(100);
		List<LotBettingMulBO> t = lotteryBettingMulDaoMapper.findMultipleFront(s);
		System.out.println("返回: " + t);
	}
}
