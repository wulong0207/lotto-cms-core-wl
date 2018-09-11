
package com.hhly.cmscore.persistence.lottery.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
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
import com.hhly.cmscore.persistence.lottery.dao.LotteryLimitMapper;
import com.hhly.cmscore.persistence.lottery.po.LotteryBettingMulPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryChildPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryLimitInfoPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryLimitPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryTypePO;
import com.hhly.skeleton.base.issue.entity.NewTypeBO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerBO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerExcelBO;
import com.hhly.skeleton.cms.customermgr.vo.LottoCustomerVO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryBettingMulBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryChildBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryLimitBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryLimitInfoBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryTypeBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryTypeExcelBO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryChildCmsVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryLimitInfoVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryLimitVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryTypeVO;
import com.hhly.skeleton.lotto.base.lottery.bo.LimitNumberDetailBO;
import com.hhly.skeleton.lotto.base.lottery.bo.LimitNumberInfoBO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotBettingMulBO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotChildBO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotteryBO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotChildVO;
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
public class LotteryLimitMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	LotteryLimitMapper lotteryLimitMapper;

	@Test
	public void testFindByCode() {
		LotteryLimitVO s = new LotteryLimitVO();
		s.setId(111);
		LotteryLimitBO t = lotteryLimitMapper.findSingleLimit(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testFindPagingLimit() {
		LotteryLimitVO s = new LotteryLimitVO();
		s.setId(111);
		s.setPageIndex(0);
		s.setPageSize(10);
		List<LotteryLimitBO> t = lotteryLimitMapper.findPagingLimit(s);
		System.out.println("返回: " + t);
	}
	
	@Test
	public void testFindCountLimit() {
		LotteryLimitVO s = new LotteryLimitVO();
		s.setId(111);
		 int t = lotteryLimitMapper.findCountLimit(s);
		System.out.println("返回: " + t);
	}
	
	@Test
	public void testAddLimit() {
		LotteryLimitVO a = new LotteryLimitVO();
		a.setLotteryCode(100);
		LotteryLimitBO t = lotteryLimitMapper.findSingleLimit(a);
		LotteryLimitPO  s = new LotteryLimitPO();
		s.setLotteryCode(t.getLotteryCode());
		s.setStatus(t.getStatus());
		s.setLimitType(t.getLimitType());
		s.setIssueStart(t.getIssueStart());
		s.setIssueEnd(t.getIssueEnd());
		s.setTimeStart(t.getTimeStart());
		s.setTimeEnd(t.getTimeEnd());
		s.setLimitWay(t.getLimitWay());
		s.setCreateBy(t.getCreateBy());
		s.setModifyBy(t.getModifyBy());
		s.setRemark(t.getRemark());
		int r = lotteryLimitMapper.addLimit(s);
		System.out.println("返回: " + r);
	}
	@Test
	public void testUpdLimit() {
		LotteryLimitVO a = new LotteryLimitVO();
		a.setLotteryCode(100);
		LotteryLimitBO t = lotteryLimitMapper.findSingleLimit(a);
		LotteryLimitPO  s = new LotteryLimitPO();
		s.setLotteryCode(t.getLotteryCode());
		s.setStatus(t.getStatus());
		s.setLimitType(t.getLimitType());
		s.setIssueStart(t.getIssueStart());
		s.setIssueEnd(t.getIssueEnd());
		s.setTimeStart(t.getTimeStart());
		s.setTimeEnd(t.getTimeEnd());
		s.setLimitWay(t.getLimitWay());
		s.setCreateBy(t.getCreateBy());
		s.setModifyBy(t.getModifyBy());
		s.setRemark(t.getRemark());
		int r = lotteryLimitMapper.updLimit(s);
		System.out.println("返回: " + r);
	}
	
	@Test
	public void testFindSingleLimitInfo() {
		LotteryLimitInfoVO s = new LotteryLimitInfoVO();
		s.setId(7);
		LotteryLimitInfoBO t = lotteryLimitMapper.findSingleLimitInfo(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testFindPagingLimitInfo() {
		LotteryLimitInfoVO s = new LotteryLimitInfoVO();
		s.setId(7);
		s.setPageIndex(0);
		s.setPageSize(10);
		List<LotteryLimitInfoBO>  t = lotteryLimitMapper.findPagingLimitInfo(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testFindCountLimitInfo() {
		LotteryLimitInfoVO s = new LotteryLimitInfoVO();
		s.setId(7);
		s.setPageIndex(0);
		s.setPageSize(10);
		int t = lotteryLimitMapper.findCountLimitInfo(s);
		System.out.println("返回: " + t);
	}
	
	@Test
	public void testAddLimitInfo() {
		LotteryLimitInfoVO a = new LotteryLimitInfoVO();
		a.setId(7);
		LotteryLimitInfoBO t = lotteryLimitMapper.findSingleLimitInfo(a);
		LotteryLimitInfoPO s= new LotteryLimitInfoPO();
		s.setLimitId(t.getLimitId());
		s.setStatus(t.getStatus());
		s.setLimitContent(t.getLimitContent());
		s.setStatus(t.getStatus());
		s.setLotteryChildCode(t.getLotteryChildCode());
		int r = lotteryLimitMapper.addLimitInfo(s);
		System.out.println("返回: " + r);
	}
	
	@Test
	public void testUpdLimitInfo() {
		LotteryLimitInfoVO a = new LotteryLimitInfoVO();
		a.setId(7);
		LotteryLimitInfoBO t = lotteryLimitMapper.findSingleLimitInfo(a);
		LotteryLimitInfoPO s= new LotteryLimitInfoPO();
		s.setLimitId(t.getLimitId());
		s.setStatus(t.getStatus());
		s.setLimitContent(t.getLimitContent());
		s.setStatus(t.getStatus());
		s.setLotteryChildCode(t.getLotteryChildCode());
		int r = lotteryLimitMapper.updLimitInfo(s);
		System.out.println("返回: " + r);
	}
	@Test
	public void testSaveLimitInfo() {
		LotteryLimitInfoVO a = new LotteryLimitInfoVO();
		a.setId(7);
		LotteryLimitInfoBO t = lotteryLimitMapper.findSingleLimitInfo(a);
		LotteryLimitInfoPO s= new LotteryLimitInfoPO();
		s.setLimitId(t.getLimitId());
		s.setStatus(t.getStatus());
		s.setLimitContent(t.getLimitContent());
		s.setStatus(t.getStatus());
		s.setLotteryChildCode(t.getLotteryChildCode());
		List<LotteryLimitInfoPO> ss = new ArrayList<>();
		ss.add(s);
		int r = lotteryLimitMapper.saveLimitInfo(ss);
		System.out.println("返回: " + r);
	}
	
	@Test
	public void testFindSingleLimitFront() {
		LotteryVO  s = new LotteryVO();
		s.setLotteryCode(100);
		LimitNumberInfoBO t = lotteryLimitMapper.findSingleLimitFront(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testFindMultipleLimitFront() {
		LotteryVO  s = new LotteryVO();
		s.setLotteryCode(100);
		 List<LimitNumberInfoBO> t = lotteryLimitMapper.findMultipleLimitFront(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testFindMultipleLimitFrontByChild() {
		LotteryVO  s = new LotteryVO();
		s.setLotteryCode(100);
		  List<LimitNumberDetailBO> t = lotteryLimitMapper.findMultipleLimitFrontByChild(s);
		System.out.println("返回: " + t);
	}
}
