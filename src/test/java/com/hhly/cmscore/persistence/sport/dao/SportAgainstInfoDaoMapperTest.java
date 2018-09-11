
package com.hhly.cmscore.persistence.sport.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.sport.dao.SportAgainstInfoDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportAgainstInfoPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.lotto.base.sport.bo.JcMathSPBO;
import com.hhly.skeleton.lotto.base.sport.bo.JcMathWinSPBO;
import com.hhly.skeleton.lotto.base.sport.bo.SportAgainstInfoBO;

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
public class SportAgainstInfoDaoMapperTest {

	@Autowired
	SportAgainstInfoDaoMapper sportAgainstInfoDaoMapper;
	
	@Test
	@Rollback(true)
	public void testDeleteByPrimaryKey() {
		long id = 1l;
		int num = sportAgainstInfoDaoMapper.deleteByPrimaryKey(id);
		System.out.println(num);
	}

	/**
	 * 方法无法实现, 缺少字段 sportTeamInfoId
	 * 
	 * @date 2017年6月5日下午4:50:44
	 * @author cheng.chen
	 */
	@Test
	@Rollback(true)
	public void testInsert() {
//		SportAgainstInfoPO po = new SportAgainstInfoPO();
//		po.setLotteryCode(300);
//		po.setSportMatchInfoId(15l);
//		//缺少字段 sportTeamInfoId
////		po.sportTeamInfoId
//		po.setMatchAnalysisUrl("http://test");
//		po.setMatchInfoUrl("http://test");
//		po.setIsRecommend((short)1);
//		po.setMatchLabelColor("123");
//		po.setOfficialMatchCode("123");
//		po.setSystemCode("123");
//		po.setMatchStatus((short)1);
//		po.setOfficialId("1");
//		po.setStartTime(DateUtil.convertStrToDate("2017-08-04"));
//		po.setSaleEndTime(DateUtil.convertStrToDate("2017-08-03"));
//		po.setIsNeutral((short)1);
//		po.setStadium("123");
//		po.setWeather("123");
//		po.setCreateBy("cheng.chen");
//		po.setCreateTime(DateUtil.getNowDate());
//		po.setRemark("fsdf");
//		int num = sportAgainstInfoDaoMapper.insert(po);
//		System.out.println(num);
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportAgainstInfoPO po = new SportAgainstInfoPO();
		po.setId(1l);
		po.setRemark("测试");
		int num = sportAgainstInfoDaoMapper.updateByPrimaryKey(po);
		System.out.println(num);
	}

	@Test
	public void testFindSportAgainstInfoBySystemCode() {
		int lotteryCode = 300;
		String systemCode = "123";
		List<SportAgainstInfoBO> list = sportAgainstInfoDaoMapper.findSportAgainstInfoBySystemCode(systemCode, lotteryCode);
		for (SportAgainstInfoBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	public void testFindSportAgainstInfoBySystemCodeS() {
		int lotteryCode = 300;
		List<String> systemCodes = new ArrayList<>();
		systemCodes.add("1");
		systemCodes.add("2");
		List<SportAgainstInfoBO> list = sportAgainstInfoDaoMapper.findSportAgainstInfoBySystemCodeS(systemCodes, lotteryCode);
		for (SportAgainstInfoBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	public void testFindSportMatchBBSPInfo() {
		int lotteryCode = 300;
		String issueCode = "123";
		List<JcMathSPBO> list = sportAgainstInfoDaoMapper.findSportMatchBBSPInfo(lotteryCode, issueCode,null);
		for (JcMathSPBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	public void testFindSportMatchFBSPInfo() {
		int lotteryCode = 300;
		String issueCode = "123";
		List<JcMathSPBO> list = sportAgainstInfoDaoMapper.findSportMatchFBSPInfo(lotteryCode, issueCode,null);
		for (JcMathSPBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	public void testQuerySportMatchInfo() {
		int lotteryCode = 300;
		String issueCode = "123";
		String systemCode = "123";
		SportAgainstInfoBO bo = sportAgainstInfoDaoMapper.querySportMatchInfo(lotteryCode, issueCode, systemCode);
		if(bo != null)
		System.out.println(bo.getId());
	}

	@Test
	public void testFindSportFBMatchDCZSInfo() {
		int lotteryCode = 300;
		String issueCode = "123";
		Date date = DateUtil.getNowDate();
		JcMathWinSPBO bo = sportAgainstInfoDaoMapper.findSportFBMatchDCZSInfo(lotteryCode, issueCode, date, "1709074002");
		if(bo != null)
		System.out.println(bo.getId());
	}

	@Test
	@Rollback(true)
	public void testUpdCheckScore() {
		Map<String, String> param = new HashMap<>();
		param.put("modifyBy", "cheng.chen");
		param.put("lotteryCode", "300");
		param.put("drawTable", "sport_draw_fb");
		sportAgainstInfoDaoMapper.updCheckScore(param);
	}

}
