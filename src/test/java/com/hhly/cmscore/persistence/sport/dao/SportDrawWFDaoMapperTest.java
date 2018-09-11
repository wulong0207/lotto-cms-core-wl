
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

import com.hhly.cmscore.persistence.sport.dao.SportDrawWFDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportDrawWFPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.sportmgr.bo.SportWFLotteryInfoBO;
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
public class SportDrawWFDaoMapperTest {
	
	@Autowired
	SportDrawWFDaoMapper sportDrawWFDaoMapper;
	
	@Test
	public void testFindCountWFData() {
		SMGLotteryParamVO vo = new SMGLotteryParamVO();
		vo.setLotteryCode(306);
		int num = sportDrawWFDaoMapper.findCountWFData(vo);
		System.out.println(num);
	}

	@Test
	public void testFindWFData() {
		SMGLotteryParamVO vo = new SMGLotteryParamVO();
		vo.setLotteryCode(306);
		vo.setPageIndex(0);
		vo.setPageSize(10);
		List<SportWFLotteryInfoBO> list = sportDrawWFDaoMapper.findWFData(vo);
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		SportDrawWFPO po = new SportDrawWFPO();
		po.setSportAgainstInfoId(1l);
		po.setLetNum(1d);
		po.setLetSf((short)1);
		po.setFullScore("2");
		po.setSpLetWf(2.0);
		po.setModifyBy("cheng.chen");
		po.setDrawTime(DateUtil.getNowDate());
		po.setCreateTime(DateUtil.getNowDate());
		po.setModifyTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		sportDrawWFDaoMapper.insert(po);
	}

	@Test
	public void testUpdateByPrimaryKey() {
		SportDrawWFPO po = new SportDrawWFPO();
		po.setId(1l);
		po.setSportAgainstInfoId(1l);
		po.setLetNum(1d);
		po.setLetSf((short)1);
		po.setFullScore("2");
		po.setSpLetWf(2.0);
		po.setModifyBy("cheng.chen");
		sportDrawWFDaoMapper.updateByPrimaryKey(po);
	}

	@Test
	public void testFindAllList() {
		SMGLotteryParamVO vo = new SMGLotteryParamVO();
		vo.setLotteryCode(306);
		sportDrawWFDaoMapper.findAllList(vo);
	}

}
