
package com.hhly.cmscore.persistence.trend.dao;

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
import com.hhly.cmscore.persistence.lottery.po.LotteryBettingMulPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryChildPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryTypePO;
import com.hhly.cmscore.persistence.trend.num.dao.DltTrendDaoMapper;
import com.hhly.cmscore.persistence.trend.num.dao.SsqTrendDaoMapper;
import com.hhly.cmscore.persistence.trend.num.dao.TrendDaoMapper;
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
import com.hhly.skeleton.lotto.base.lottery.bo.LotBettingMulBO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotChildBO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotteryBO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotChildVO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotteryBettingMulVO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotteryVO;
import com.hhly.skeleton.lotto.base.trend.bo.TrendBaseBO;

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
public class TrendDaoMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Resource(name="ssqTrendDaoMapper")
	TrendDaoMapper ssqTrendDaoMapper;

	@Test
	public void testFindMaxTrendFront() {
		TrendBaseBO t = ssqTrendDaoMapper.findMaxTrendFront();
		System.out.println("返回: " + t);
	} 
	
	@Test
	public void testFindSingleFront() {
		LotteryVO s = new LotteryVO();
		s.setIssueCode("2017061");
		TrendBaseBO t = ssqTrendDaoMapper.findSingleFront(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testFindTrendRangeFront() {
		LotteryVO s = new LotteryVO();
		s.setIssueCode("2017061");
		s.setQryCount(50);
		List<TrendBaseBO> t = ssqTrendDaoMapper.findTrendRangeFront(s);
		System.out.println("返回: " + t);
	}
	
}
