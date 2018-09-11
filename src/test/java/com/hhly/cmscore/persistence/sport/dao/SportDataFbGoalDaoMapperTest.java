
package com.hhly.cmscore.persistence.sport.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.sport.dao.SportDataFbGoalDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportDataBjWDFPO;
import com.hhly.cmscore.persistence.sport.po.SportDataFbGoalPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBjWDFBO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataFbGoalBO;

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
public class SportDataFbGoalDaoMapperTest {

	@Autowired
	SportDataFbGoalDaoMapper sportDataFbGoalDaoMapper;
	
	@Test
	public void testFindByAgainstInfoId() {
		long id = 1l;
		List<SportDataFbGoalBO> list = sportDataFbGoalDaoMapper.findByAgainstInfoId(id);
		for (SportDataFbGoalBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		SportDataFbGoalPO po = new SportDataFbGoalPO();
		po.setSportAgainstInfoId(1l);
		po.setSp0Goal(1.0f);
		po.setSp1Goal(1.0f);
		po.setSp2Goal(1.0f);
		po.setSp3Goal(1.0f);
		po.setSp4Goal(1.0f);
		po.setSp5Goal(1.0f);
		po.setSp6Goal(1.0f);
		po.setSp7Goal(1.0f);
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		sportDataFbGoalDaoMapper.insert(po);
		System.out.println(po.getId());
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportDataFbGoalPO po = new SportDataFbGoalPO();
		po.setId(1l);
		po.setSportAgainstInfoId(1l);
		po.setSp0Goal(1.0f);
		po.setSp1Goal(1.0f);
		po.setSp2Goal(1.0f);
		po.setSp3Goal(1.0f);
		po.setSp4Goal(1.0f);
		po.setSp5Goal(1.0f);
		po.setSp6Goal(1.0f);
		po.setSp7Goal(1.0f);
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		int num = sportDataFbGoalDaoMapper.updateByPrimaryKey(po);
		System.out.println(num);
	}

}
