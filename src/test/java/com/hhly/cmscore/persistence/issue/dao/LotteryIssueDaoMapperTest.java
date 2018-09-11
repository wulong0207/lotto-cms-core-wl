
package com.hhly.cmscore.persistence.issue.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
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

import com.hhly.cmscore.persistence.issue.dao.LotteryIssueDaoMapper;
import com.hhly.cmscore.persistence.issue.po.LotteryIssuePO;
import com.hhly.skeleton.base.common.LotteryEnum.ConIssue;
import com.hhly.skeleton.base.issue.entity.NewIssueBO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryIssueCmsBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryIssueExcelBO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryIssueCmsVO;
import com.hhly.skeleton.lotto.base.issue.bo.IssueBO;
import com.hhly.skeleton.lotto.base.issue.bo.IssueDrawBO;
import com.hhly.skeleton.lotto.base.issue.bo.IssueLottBO;
import com.hhly.skeleton.lotto.base.issue.bo.IssueLottJCBO;
import com.hhly.skeleton.lotto.base.issue.bo.IssueOfficialTimeBO;
import com.hhly.skeleton.lotto.base.issue.bo.CurrentAndPreIssueBO;
import com.hhly.skeleton.lotto.base.issue.vo.LottoIssueVO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotteryVO;

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
public class LotteryIssueDaoMapperTest {

	@Autowired
	LotteryIssueDaoMapper lotteryIssueDaoMapper;
	
	@Test
	public void testFindIssueCode() {
		LotteryIssueCmsVO vo = new LotteryIssueCmsVO();
		vo.setCurrentIssue((short)1);
		List<String> list = lotteryIssueDaoMapper.findIssueCode(vo);
		for (String code : list) {
			System.out.println("code : " + code);
		}
	}

	@Test
	public void testFind() {
		LotteryIssueCmsVO vo = new LotteryIssueCmsVO();
		vo.setCurrentIssue((short)1);
		List<LotteryIssueCmsBO> list = lotteryIssueDaoMapper.find(vo);
		for (LotteryIssueCmsBO bo : list) {
			System.out.println("issueCode : " + bo.getIssueCode());
		}
	}

	@Test
	public void testFindTotal() {
		LotteryIssueCmsVO vo = new LotteryIssueCmsVO();
		vo.setCurrentIssue((short)1);
		int num = lotteryIssueDaoMapper.findTotal(vo);
		System.out.println("num : " + num);
	}

	@Test
	@Rollback(true)
	public void testUpdIssueByKey() {
		LotteryIssuePO po = new LotteryIssuePO();
		po.setId(22795);
		po.setLotteryCode(100);
		po.setIssueCode("20171514");
		po.setLotteryName("测试");
		po.setCurrentIssue((short)1);
		po.setSaleStatus((short)1);
		po.setOfficialEndTime(DateUtil.convertStrToDate("2017-08-01"));
		po.setLotteryTime(DateUtil.getNowDate());
		po.setSaleTime(DateUtil.convertStrToDate("2017-08-01"));
		po.setSaleEndTime(DateUtil.convertStrToDate("2017-08-31"));
		po.setSalesAmount(500l);
		po.setJackpotAmount(900l);
		po.setDrawCode("");
		po.setDrawDetail("");
		po.setCreateBy("cheng.chen");
		po.setRemark("测试");
		po.setIssueLastest(1);
		int num = lotteryIssueDaoMapper.updIssueByKey(po);
		System.out.println("num : " + num);
	}

	@Test
	@Rollback(true)
	public void testAddIssue() {
		LotteryIssuePO po = new LotteryIssuePO();
		po.setLotteryCode(100);
		po.setIssueCode("20171514");
		po.setLotteryName("测试");
		po.setCurrentIssue((short)1);
		po.setSaleStatus((short)1);
		po.setOfficialEndTime(DateUtil.convertStrToDate("2017-08-01"));
		po.setLotteryTime(DateUtil.getNowDate());
		po.setSaleTime(DateUtil.convertStrToDate("2017-08-01"));
		po.setSaleEndTime(DateUtil.convertStrToDate("2017-08-31"));
		po.setSalesAmount(500l);
		po.setJackpotAmount(900l);
		po.setDrawCode("");
		po.setDrawDetail("");
		po.setCreateBy("cheng.chen");
		po.setRemark("测试");
		po.setIssueLastest(1);
		int num = lotteryIssueDaoMapper.addIssue(po);
		System.out.println("num : " + num + " id " + po.getId());
	}

	@Test
	public void testFindIssueToExcel() {
		LotteryIssueCmsVO vo = new LotteryIssueCmsVO();
		vo.setCurrentIssue((short)1);
		List<LotteryIssueExcelBO> list = lotteryIssueDaoMapper.findIssueToExcel(vo);
		for (LotteryIssueExcelBO bo : list) {
			System.out.println("issueCode : " + bo.getIssueCode());
		}
	}

	@Test
	public void testFindIssueDetial() {
		String id = "22796";
		LotteryIssueCmsBO bo = lotteryIssueDaoMapper.findIssueDetial(id);
		System.out.println("issueCode : " + bo.getIssueCode() + " lotteryName : " + bo.getLotteryName());
	}

	@Test
	public void testFindIssueCount() {
		LotteryIssueCmsVO vo = new LotteryIssueCmsVO();
		vo.setCurrentIssue((short)1);
		int num = lotteryIssueDaoMapper.findIssueCount(vo);
		System.out.println("num : " + num);
	}

	@Test
	public void testFindIssue() {
		int lotteryCode = 100;
		short curr = 1;
		LotteryIssueCmsBO bo = lotteryIssueDaoMapper.findIssue(lotteryCode, curr);
		System.out.println("issueCode : " + bo.getIssueCode() + " lotteryName : " + bo.getLotteryName());
	}

	@Test
	public void testFindIssueCurrentList() {
		List<Integer> codes = new ArrayList<>();
		codes.add(100);
		codes.add(101);
		List<LotteryIssuePO> list = lotteryIssueDaoMapper.findIssueCurrentList(codes);
		for (LotteryIssuePO po : list) {
			System.out.println("issueCode : " + po.getIssueCode() + " lotteryName : " + po.getLotteryName());
		}
	}

	@Test
	@Rollback(true)
	public void testUpdIssueBuyEndTime() {
		int buyEndTime = 600;
		int lotteryCode = 100;
		String issueCode = "2016060";
		int num = lotteryIssueDaoMapper.updIssueBuyEndTime(buyEndTime, lotteryCode, issueCode);
		System.out.println("num : " + num);
	}

	@Test
	public void testFindIssueOfficialEndTime() {
		int lotteryCode = 100;
		String issueCode = "2016060";
		List<LotteryIssuePO> list = lotteryIssueDaoMapper.findIssueOfficialEndTime(lotteryCode, issueCode);
		for (LotteryIssuePO po : list) {
			System.out.println("issueCode : " + po.getIssueCode() + " lotteryName : " + po.getLotteryName());
		}
	}

	@Test
	@Rollback(true)
	public void testUpdateByKeySelective() {
		LotteryIssuePO po = new LotteryIssuePO();
		po.setId(22795);
		po.setRemark("测试");
		int num = lotteryIssueDaoMapper.updateByKeySelective(po);
		System.out.println("num : " + num);
	}

	@Test
	@Rollback(true)
	public void testUpdateSaleTime() {
		List<LotteryIssuePO> list = new ArrayList<>();
		LotteryIssuePO po = new LotteryIssuePO();
		po.setId(22800);
		list.add(po);
		LotteryIssuePO po1 = new LotteryIssuePO();
		po1.setId(22801);
		list.add(po1);
		int num = lotteryIssueDaoMapper.updateSaleTime(list);
		System.out.println("num : " + num);
	}

	@Test
	public void testFindIssueCountCurrent() {
		int lotteryCode = 100;
		int num = lotteryIssueDaoMapper.findIssueCountCurrent(lotteryCode);
		System.out.println("num : " + num);
	}

	@Test
	@Rollback(true)
	public void testUpdCurrentIssue() {
		int lotteryCode = 100;
		int num = lotteryIssueDaoMapper.updCurrentIssue(lotteryCode, ConIssue.CURRENT.getValue());
		System.out.println("num : " + num);
	}

	
	/**
	 * 方法参数有问题, 缺少参数 partIssueCode 该sql无用
	 * @date 2017年6月5日下午2:32:58
	 * @author cheng.chen
	 */
	@Test
	public void testFindSaledNum() {
//		LotteryIssueCmsVO vo = new LotteryIssueCmsVO();
//		vo.setLotteryCode(lotteryCode);
//		lotteryIssueDaoMapper.findSaledNum(vo);
		fail("Not yet implemented");
	}

	@Test
	public void testListCurrentIssue() {
		String lotteryCategory = "1";
		List<LotteryIssueCmsBO> list = lotteryIssueDaoMapper.listCurrentIssue(lotteryCategory);
		for (LotteryIssueCmsBO bo : list) {
			System.out.println("lotteryCode : " + bo.getLotteryCode() + " lotteryName " + bo.getLotteryName());
		}
	}

	@Test
	public void testGetLotteryIssueMonitor() {
		int lotteryCode = 100;
		LotteryIssueCmsBO bo = lotteryIssueDaoMapper.getLotteryIssueMonitor(lotteryCode);
		System.out.println("lotteryCode : " + bo.getLotteryCode() + " lotteryName " + bo.getLotteryName());
	}

	@Test
	public void testFindSingleFront() {
		LotteryVO vo = new LotteryVO();
		vo.setLotteryCode(100);
		IssueBO bo = lotteryIssueDaoMapper.findSingleFront(vo);
		System.out.println("lotteryCode : " + bo.getLotteryCode() + " IssueCode " + bo.getIssueCode());
	}

	@Test
	public void testFindMultipleFront() {
		LotteryVO vo = new LotteryVO();
		vo.setLotteryCode(100);
		List<IssueBO> list = lotteryIssueDaoMapper.findMultipleFront(vo);
		for (IssueBO bo : list) {
			System.out.println("lotteryCode : " + bo.getLotteryCode() + " IssueCode " + bo.getIssueCode());
		}
	}

	@Test
	public void testFindLatestDrawIssue() {
		LotteryVO vo = new LotteryVO();
		vo.setLotteryCode(100);
		IssueDrawBO bo = lotteryIssueDaoMapper.findLatestDrawIssue(vo);
		System.out.println("DrawCode : " + bo.getDrawCode() + " IssueCode " + bo.getIssueCode());
	}

	@Test
	public void testFindRecentDrawIssue() {
		LotteryVO vo = new LotteryVO();
		vo.setLotteryCode(100);
		vo.setQryCount(10);
		List<IssueDrawBO> list = lotteryIssueDaoMapper.findRecentDrawIssue(vo);
		for (IssueDrawBO bo : list) {
			System.out.println("DrawCode : " + bo.getDrawCode() + " IssueCode " + bo.getIssueCode());
		}
	}

	@Test
	public void testFindLotteryIssue() {
		int lotteryCode = 300;
		String issueCode = "170412";
		NewIssueBO bo = lotteryIssueDaoMapper.findLotteryIssue(lotteryCode, issueCode);
		System.out.println("lotteryCode : " + bo.getLotteryCode() + " IssueCode " + bo.getIssueCode());
	}

	@Test
	public void testFindfindHomeDrawLott() {
		List<IssueLottBO> list = lotteryIssueDaoMapper.findfindHomeDrawLott();
		for (IssueLottBO bo : list) {
			System.out.println("lotteryCode : " + bo.getLotteryCode() + " IssueCode " + bo.getIssueCode());
		}
	}

	@Test
	public void testFindNewsHomeDraw() {
		IssueLottBO bo = lotteryIssueDaoMapper.findNewsHomeDraw();
		System.out.println("DrawCode : " + bo.getDrawCode() + " IssueCode " + bo.getIssueCode());
	}

	@Test
	public void testFindDrawNameToday() {
		List<IssueLottBO> list = lotteryIssueDaoMapper.findDrawNameToday();
		for (IssueLottBO bo : list) {
			System.out.println("lotteryCode : " + bo.getLotteryCode() + " IssueCode " + bo.getIssueCode());
		}
	}

	@Test
	public void testFindIssueByCode() {
		int lotteryCode = 300;
		List<IssueLottJCBO> list = lotteryIssueDaoMapper.findIssueByCode(lotteryCode);
		for (IssueLottJCBO bo : list) {
			System.out.println("DrawCode : " + bo.getDrawCode() + " IssueCode " + bo.getIssueCode());
		}
	}

	@Test
	public void testFindIssueListByCodeTotal() {
		LottoIssueVO vo = new LottoIssueVO();
		vo.setLotteryCode(100);
		int num = lotteryIssueDaoMapper.findIssueListByCodeTotal(vo);
		System.out.println("num : " + num);
	}

	@Test
	public void testFindIssueListByCode() {
		LottoIssueVO vo = new LottoIssueVO();
		vo.setLotteryCode(300);
		vo.setPageIndex(0);
		vo.setPageSize(10);
		List<IssueLottJCBO> list = lotteryIssueDaoMapper.findIssueListByCode(vo);
		for (IssueLottJCBO bo : list) {
			System.out.println("DrawCode : " + bo.getDrawCode() + " IssueCode " + bo.getIssueCode());
		}
	}

	@Test
	public void testFindAfterFiveIssueListByCode() {
		LottoIssueVO vo = new LottoIssueVO();
		vo.setLotteryCode(300);
		vo.setPageIndex(0);
		vo.setPageSize(10);
		List<IssueLottJCBO> list = lotteryIssueDaoMapper.findAfterFiveIssueListByCode(vo);
		for (IssueLottJCBO bo : list) {
			System.out.println("DrawCode : " + bo.getDrawCode() + " IssueCode " + bo.getIssueCode());
		}
	}

	@Test
	public void testFindNumOfficialTime() {
		LotteryVO vo = new LotteryVO();
		vo.setLotteryCode(300);
		IssueOfficialTimeBO bo = lotteryIssueDaoMapper.findNumOfficialTime(vo);
		System.out.println("startTime : " + bo.getOfficialStartTimeStr() + "endTime : " + bo.getOfficialEndTimeStr());
	}

	@Test
	public void testFindHighOfficialTime() {
		LotteryVO vo = new LotteryVO();
		vo.setLotteryCode(300);
		IssueOfficialTimeBO bo = lotteryIssueDaoMapper.findHighOfficialTime(vo);
		System.out.println("startTime : " + bo.getOfficialStartTimeStr() + "endTime : " + bo.getOfficialEndTimeStr());
	}

	@Test
	public void testFindSportOfficialTime() {
		LotteryVO vo = new LotteryVO();
		vo.setLotteryCode(300);
		List<IssueOfficialTimeBO> list = lotteryIssueDaoMapper.findSportOfficialTime(vo);
		for (IssueOfficialTimeBO bo : list) {
			System.out.println("startTime : " + bo.getOfficialStartTimeStr() + "endTime : " + bo.getOfficialEndTimeStr());
		}
	}

	@Test
	public void testFindIssueAndPreIssueByCode() {
		int lotteryCode = 100;
		CurrentAndPreIssueBO bo = lotteryIssueDaoMapper.findIssueAndPreIssueByCode(lotteryCode);
		System.out.println("lotteryCode : " + bo.getLotteryCode() + " lotteryName " + bo.getLotteryName());
	}

	@Test
	public void testFindIssueAndPreIssueByCodeList() {
		List<Integer> codes = new ArrayList<>();
		codes.add(100);
		codes.add(101);
		List<CurrentAndPreIssueBO> list = lotteryIssueDaoMapper.findIssueAndPreIssueByCodeList(codes);
		for (CurrentAndPreIssueBO bo : list) {
			System.out.println("lotteryCode : " + bo.getLotteryCode() + " lotteryName " + bo.getLotteryName());
		}
	}

	/**
	 * UP_OMIT_ALL 存储过程还没更改完
	 * 
	 * @date 2017年6月5日下午3:09:02
	 * @author cheng.chen
	 */
	@Test
	@Rollback(true)
	public void testGetOmotAll() {
//		Map<String, Object> param = new HashMap<>();
//		param.put("lotteryCode", 100);
//		param.put("issueCode", 22801);
//		param.put("drawCode", "26,19,23,22,12,07|11");
//		lotteryIssueDaoMapper.getOmotAll(param);
	}

	@Test
	@Rollback(true)
	public void testUpdIssueLastest() {
		Integer lotteryCode = 100;
		int num = lotteryIssueDaoMapper.updIssueLastest(lotteryCode);
		System.out.println("num : " + num);
	}

}
