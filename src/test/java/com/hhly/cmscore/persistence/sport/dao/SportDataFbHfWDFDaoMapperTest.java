
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

import com.hhly.cmscore.persistence.sport.dao.SportDataFbHfWDFDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportDataFbGoalPO;
import com.hhly.cmscore.persistence.sport.po.SportDataFbHfWDFPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataFbGoalBO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataFbHfWDFBO;

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
public class SportDataFbHfWDFDaoMapperTest {

	@Autowired
	SportDataFbHfWDFDaoMapper sportDataFbHfWDFDaoMapper;
	
	@Test
	public void testFindByAgainstInfoId() {
		long id = 1l;
		List<SportDataFbHfWDFBO> list = sportDataFbHfWDFDaoMapper.findByAgainstInfoId(id);
		for (SportDataFbHfWDFBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		SportDataFbHfWDFPO po = new SportDataFbHfWDFPO();
		po.setSportAgainstInfoId(1l);
		po.setSpDD(1.0f);
		po.setSpDF(1.0f);
		po.setSpDW(1.0f);
		po.setSpFD(1.0f);
		po.setSpFF(1.0f);
		po.setSpFW(1.0f);
		po.setSpWD(1.0f);
		po.setSpWF(1.01f);
		po.setSpWW(1.0f);
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		sportDataFbHfWDFDaoMapper.insert(po);
		System.out.println(po.getId());
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportDataFbHfWDFPO po = new SportDataFbHfWDFPO();
		po.setId(1l);
		po.setSportAgainstInfoId(1l);
		po.setSportAgainstInfoId(1l);
		po.setSpDD(1.0f);
		po.setSpDF(1.0f);
		po.setSpDW(1.0f);
		po.setSpFD(1.0f);
		po.setSpFF(1.0f);
		po.setSpFW(1.0f);
		po.setSpWD(1.0f);
		po.setSpWF(1.01f);
		po.setSpWW(1.0f);
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		int num = sportDataFbHfWDFDaoMapper.updateByPrimaryKey(po);
		System.out.println(num);
	}

}
