
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

import com.hhly.cmscore.persistence.jc.dao.JcDataDaoMapper;
import com.hhly.skeleton.lotto.base.sport.bo.JcOldDataBO;
import com.hhly.skeleton.lotto.base.sport.bo.JcOldDataSpBO;
import com.hhly.skeleton.lotto.base.sport.bo.JclqDaoBO;
import com.hhly.skeleton.lotto.base.sport.bo.JclqOrderBO;
import com.hhly.skeleton.lotto.base.sport.bo.JczqDaoBO;
import com.hhly.skeleton.lotto.base.sport.bo.JczqOrderBO;
import com.hhly.skeleton.lotto.base.sport.bo.MatchDataBO;
import com.hhly.skeleton.lotto.base.sport.bo.SportDataBbSSSBO;
import com.hhly.skeleton.lotto.base.sport.bo.SportDataBbWFBO;
import com.hhly.skeleton.lotto.base.sport.bo.SportDataBbWSBO;
import com.hhly.skeleton.lotto.base.sport.bo.SportDataFbWDFBO;
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
public class JcDataDaoMapperTest {

	@Autowired
	JcDataDaoMapper jcDataDaoMapper;
	
	@Test
	public void testFindJczqData() {
		JcParamVO vo = new JcParamVO();
		vo.setLotteryCode("300");
		vo.setMatchType((short)11);
		List<JczqDaoBO> list = jcDataDaoMapper.findJczqData(vo);
		for (JczqDaoBO bo : list) {
			System.out.println("fullscore : " + bo.getFullScore());
		}
	}

	@Test
	public void testFindJcSaleEndDataTotal() {
		JcParamVO vo = new JcParamVO();
		vo.setLotteryCode("300");
		int num = jcDataDaoMapper.findJcSaleEndDataTotal(vo);
		System.out.println("num : " + num);
	}

	@Test
	public void testFindJczqSaleEndData() {
		JcParamVO vo = new JcParamVO();
		vo.setLotteryCode("300");
		vo.setMatchType((short)11);
		List<JczqDaoBO> list = jcDataDaoMapper.findJczqSaleEndData(vo);
		for (JczqDaoBO bo : list) {
			System.out.println("fullscore : " + bo.getFullScore());
		}
	}

	@Test
	public void testFindJczqWdfSpData() {
		long id = 170277l;
		List<SportDataFbWDFBO> list = jcDataDaoMapper.findJczqWdfSpData(id);
		for (SportDataFbWDFBO bo : list) {
			System.out.println("single : " + bo.getSingle());
		}
	}

	@Test
	public void testFindMatchTotal() {
		JcParamVO vo = new JcParamVO();
		vo.setLotteryCode("300");
		List<MatchDataBO> list = jcDataDaoMapper.findMatchTotal(vo);
		for (MatchDataBO bo : list) {
			System.out.println(bo.getMatchName());
		}
	}

	@Test
	public void testFindJczqOrderDataBySystemCode() {
		JcParamVO vo = new JcParamVO();
		vo.setLotteryCode("300");
		vo.setMatchType((short)1);
		vo.setSystemCode("1703234001");
		JczqOrderBO bo = jcDataDaoMapper.findJczqOrderDataBySystemCode(vo);
		System.out.println(bo.getFullScore());
	}

	@Test
	public void testFindJclqData() {
		JcParamVO vo = new JcParamVO();
		vo.setLotteryCode("300");
		vo.setMatchType((short)11);
		List<JclqDaoBO> list = jcDataDaoMapper.findJclqData(vo);
		for (JclqDaoBO bo : list) {
			System.out.println(bo.getFullScore());
		}
	}

	@Test
	public void testFindJclqOrderDataBySystemCode() {
		JcParamVO vo = new JcParamVO();
		vo.setLotteryCode("301");
		vo.setMatchType((short)11);
		vo.setSystemCode("1704027308");
		JclqOrderBO bo = jcDataDaoMapper.findJclqOrderDataBySystemCode(vo);
		if(bo !=null)
		System.out.println(bo.getFullScore());
	}

	@Test
	public void testFindJclqWfSpData() {
		long id = 575843l;
		List<SportDataBbWFBO> list = jcDataDaoMapper.findJclqWfSpData(id);
		for (SportDataBbWFBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	public void testFindJclqWSSpData() {
		long id = 575843l;
		List<SportDataBbWSBO> list = jcDataDaoMapper.findJclqWSSpData(id);
		for (SportDataBbWSBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	public void testFindJclqSssSpData() {
		long id = 575843l;
		List<SportDataBbSSSBO> list = jcDataDaoMapper.findJclqSssSpData(id);
		for (SportDataBbSSSBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	public void testFindJcOldData() {
		String lotteryCode = "303";
		String issueCode = "123";
		List<JcOldDataBO> list = jcDataDaoMapper.findJcOldData(issueCode, lotteryCode);
		for (JcOldDataBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	public void testFindJcOldDataSp() {
		String lotteryCode = "303";
		String issueCode = "123";
		List<JcOldDataSpBO> list = jcDataDaoMapper.findJcOldDataSp(issueCode, lotteryCode);
		for (JcOldDataSpBO bo : list) {
			System.out.println(bo.getSpDraw());
		}
	}

	@Test
	public void testFindJczqOrderDataByIssueCode() {
		JcParamVO vo = new JcParamVO();
		vo.setLotteryCode("301");
		vo.setIssueCode("123456");
		vo.setMatchType((short)11);
		List<JczqOrderBO> list = jcDataDaoMapper.findJczqOrderDataByIssueCode(vo);
		for (JczqOrderBO bo : list) {
			System.out.println(bo.getId());
		}
	}

}
