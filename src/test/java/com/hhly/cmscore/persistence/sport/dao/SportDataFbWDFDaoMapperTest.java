
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

import com.hhly.cmscore.persistence.sport.dao.SportDataFbWDFDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportDataFbScorePO;
import com.hhly.cmscore.persistence.sport.po.SportDataFbWDFPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataFbScoreBO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataFbWDFBO;

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
public class SportDataFbWDFDaoMapperTest {

	@Autowired
	SportDataFbWDFDaoMapper sportDataFbWDFDaoMapper;
	
	@Test
	public void testFindByAgainstInfoId() {
		long id = 1l;
		List<SportDataFbWDFBO> list = sportDataFbWDFDaoMapper.findByAgainstInfoId(id);
		for (SportDataFbWDFBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		SportDataFbWDFPO po = new SportDataFbWDFPO();
		po.setSportAgainstInfoId(1l);
		po.setSpDraw(1.0f);
		po.setSpFail(1.0f);
		po.setSpWin(1.0f);
		po.setSpType((short)1);
		po.setLetNum((short)1);
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		sportDataFbWDFDaoMapper.insert(po);
		System.out.println(po.getId());
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportDataFbWDFPO po = new SportDataFbWDFPO();
		po.setId(1l);
		po.setSportAgainstInfoId(1l);
		po.setSpDraw(1.0f);
		po.setSpFail(1.0f);
		po.setSpWin(1.0f);
		po.setSpType((short)1);
		po.setLetNum((short)1);
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		int num = sportDataFbWDFDaoMapper.updateByPrimaryKey(po);
		System.out.println(num);
	}
}
