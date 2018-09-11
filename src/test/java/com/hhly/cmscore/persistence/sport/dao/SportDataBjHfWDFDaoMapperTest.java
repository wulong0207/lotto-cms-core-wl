
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

import com.hhly.cmscore.persistence.sport.dao.SportDataBjHfWDFDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportDataBjHfWDFPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBjGoalBO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBjHfWDFBO;

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
public class SportDataBjHfWDFDaoMapperTest {

	@Autowired
	SportDataBjHfWDFDaoMapper sportDataBjHfWDFDaoMapper;
	
	@Test
	public void testFindByAgainstInfoId() {
		long id = 1l;
		List<SportDataBjHfWDFBO> list = sportDataBjHfWDFDaoMapper.findByAgainstInfoId(id);
		for (SportDataBjHfWDFBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		SportDataBjHfWDFPO po = new SportDataBjHfWDFPO();
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
		sportDataBjHfWDFDaoMapper.insert(po);
		System.out.println(po.getId());
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportDataBjHfWDFPO po = new SportDataBjHfWDFPO();
		po.setId(1l);
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
		int num = sportDataBjHfWDFDaoMapper.insert(po);
		System.out.println(num);
	}

}
