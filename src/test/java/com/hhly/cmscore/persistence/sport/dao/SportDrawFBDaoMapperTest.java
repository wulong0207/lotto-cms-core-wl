
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

import com.hhly.cmscore.persistence.sport.dao.SportDrawFBDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportDrawFBPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.sportmgr.bo.SportFBDataExcelBO;
import com.hhly.skeleton.cms.sportmgr.bo.SportFBLotteryInfoBO;
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
public class SportDrawFBDaoMapperTest {
	
	@Autowired
	SportDrawFBDaoMapper sportDrawFBDaoMapper;

	@Test
	public void testFindCountFBData() {
		SMGLotteryParamVO vo = new SMGLotteryParamVO();
		vo.setLotteryCode(300);
		int num = sportDrawFBDaoMapper.findCountFBData(vo);
		System.out.println(num);
	}

	@Test
	public void testFindFBData() {
		SMGLotteryParamVO vo = new SMGLotteryParamVO();
		vo.setLotteryCode(300);
		vo.setPageIndex(0);
		vo.setPageSize(10);
		List<SportFBLotteryInfoBO> list = sportDrawFBDaoMapper.findFBData(vo);
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		SportDrawFBPO po = new SportDrawFBPO();
		po.setSportAgainstInfoId(1l);
		po.setFullScore("1");
		po.setFullSpf((short)1);
		po.setGoalNum((short)1);
		po.setHalfScore("1");
		po.setHfWdf("2");
		po.setLetNum((short)1);
		po.setLetSpf((short)1);
		po.setScore("2");
		po.setDrawTime(DateUtil.getNowDate());
		po.setModifyBy("cheng.chen");
		po.setCreateTime(DateUtil.getNowDate());
		po.setModifyTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		sportDrawFBDaoMapper.insert(po);
		System.out.println(po.getId());
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportDrawFBPO po = new SportDrawFBPO();
		po.setId(1l);;
		po.setSportAgainstInfoId(1l);
		po.setFullScore("1");
		po.setFullSpf((short)1);
		po.setGoalNum((short)1);
		po.setHalfScore("1");
		po.setHfWdf("2");
		po.setLetNum((short)1);
		po.setLetSpf((short)1);
		po.setScore("2");
		po.setDrawTime(DateUtil.getNowDate());
		po.setModifyBy("cheng.chen");
		po.setCreateTime(DateUtil.getNowDate());
		po.setModifyTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		int num = sportDrawFBDaoMapper.updateByPrimaryKey(po);
		System.out.println(num);		
	}

	@Test
	public void testFindAllList() {
		SMGLotteryParamVO vo = new SMGLotteryParamVO();
		vo.setLotteryCode(300);
		List<SportFBDataExcelBO> list = sportDrawFBDaoMapper.findAllList(vo);
	}

}
