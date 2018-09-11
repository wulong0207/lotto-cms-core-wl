
package com.hhly.cmscore.persistence.jc.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.jc.dao.MatchDataDaoMapper;
import com.hhly.skeleton.lotto.base.sport.bo.MatchDataBO;
import com.hhly.skeleton.lotto.base.sport.vo.JcParamVO;

/**
 * @desc    
 * @author  cheng chen
 * @date    2017年6月5日
 * @company 益彩网络科技公司
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager") 
public class MatchDataDaoMapperTest {
	
	@Autowired
	MatchDataDaoMapper matchDataDaoMapper;

	@Test
	public void testFindMatchData() {
		JcParamVO vo = new JcParamVO();
		vo.setLotteryCode("300");
//		vo.setIssueCode(issueCode);
		vo.setMatchType((short)11);
		List<MatchDataBO> list = matchDataDaoMapper.findMatchData(vo);
		for (MatchDataBO bo : list) {
			System.out.println(bo.getId());
		}
	}

}
