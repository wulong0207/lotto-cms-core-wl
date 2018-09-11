
package com.hhly.cmscore.persistence.sport.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.sport.dao.SportDataSfWFDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportDataFbWDFPO;
import com.hhly.cmscore.persistence.sport.po.SportDataSfWFPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataFbWDFBO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataSfWFBO;

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
public class SportDataSfWFDaoMapperTest {

	@Autowired
	SportDataSfWFDaoMapper sportDataSfWFDaoMapper;
	
	@Test
	public void testFindByAgainstInfoId() {
		long id = 1l;
		List<SportDataSfWFBO> list = sportDataSfWFDaoMapper.findByAgainstInfoId(id);
		for (SportDataSfWFBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		SportDataSfWFPO po = new SportDataSfWFPO();
		po.setSportAgainstInfoId(1);
		po.setSpFail(new BigDecimal(1));
		po.setSpWin(new BigDecimal(1));
		po.setLetScore(new BigDecimal(1));
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		sportDataSfWFDaoMapper.insert(po);
		System.out.println(po.getId());
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportDataSfWFPO po = new SportDataSfWFPO();
		po.setId(1);
		po.setSportAgainstInfoId(1);
		po.setSpFail(new BigDecimal(1));
		po.setSpWin(new BigDecimal(1));
		po.setLetScore(new BigDecimal(1));
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		int num = sportDataSfWFDaoMapper.updateByPrimaryKey(po);
		System.out.println(num);
	}

}
