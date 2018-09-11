
package com.hhly.cmscore.persistence.sport.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.sport.dao.SportDrawBBDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportDrawBBPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.sportmgr.bo.SportBBDataExcelBO;
import com.hhly.skeleton.cms.sportmgr.bo.SportBBLotteryInfoBO;
import com.hhly.skeleton.cms.sportmgr.vo.SMGLotteryParamVO;

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
public class SportDrawBBDaoMapperTest {

	@Autowired
	SportDrawBBDaoMapper sportDrawBBDaoMapper;
	
	@Test
	public void testFindBBData() {
		SMGLotteryParamVO vo = new SMGLotteryParamVO();
		vo.setLotteryCode(300);
		vo.setPageIndex(0);
		vo.setPageSize(10);
		List<SportBBLotteryInfoBO> list = sportDrawBBDaoMapper.findBBData(vo);
	}

	@Test
	public void testFindBBDataCount() {
		SMGLotteryParamVO vo = new SMGLotteryParamVO();
		vo.setLotteryCode(300);
		sportDrawBBDaoMapper.findBBDataCount(vo);
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		SportDrawBBPO po = new SportDrawBBPO();
		po.setSportAgainstInfoId(1l);
		po.setFirstScore("1");
		po.setSecondScore("2");
		po.setThirdScore("2");
		po.setFourthScore("4");
		po.setOutTimeScore("5");
		po.setFullScore("6");
		po.setFullWf((short)1);
		po.setLetWf("1");
		po.setSizeScore("2");
		po.setWinScore("1");
		po.setDrawTime(DateUtil.getNowDate());
		po.setModifyBy("cheng.chen");
		po.setCreateTime(DateUtil.getNowDate());
		po.setModifyTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		sportDrawBBDaoMapper.insert(po);
	   System.out.println(po.getId());
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportDrawBBPO po = new SportDrawBBPO();
		po.setId(1l);
		po.setFirstScore("1");
		po.setSecondScore("2");
		po.setThirdScore("2");
		po.setFourthScore("4");
		po.setOutTimeScore("5");
		po.setFullScore("6");
		po.setFullWf((short)1);
		po.setLetWf("1");
		po.setSizeScore("2");
		po.setWinScore("1");
		po.setDrawTime(DateUtil.getNowDate());
		po.setModifyBy("cheng.chen");
		po.setCreateTime(DateUtil.getNowDate());
		po.setModifyTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		int num = sportDrawBBDaoMapper.updateByPrimaryKey(po);
		System.out.println(num);
	}

	@Test
	public void testFindAllList() {
		SMGLotteryParamVO vo = new SMGLotteryParamVO();
		vo.setLotteryCode(300);
		List<SportBBDataExcelBO> list = sportDrawBBDaoMapper.findAllList(vo);
	}

}
