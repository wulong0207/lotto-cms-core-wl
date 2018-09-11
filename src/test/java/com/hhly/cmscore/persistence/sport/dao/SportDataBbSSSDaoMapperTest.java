
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

import com.hhly.cmscore.persistence.sport.dao.SportDataBbSSSDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportDataBbSSSPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBbSSSBO;

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
public class SportDataBbSSSDaoMapperTest {
	
	@Autowired
	SportDataBbSSSDaoMapper sportDataBbSSSDaoMapper;

	@Test
	public void testFindByAgainstInfoId() {
		long id = 1l;
		List<SportDataBbSSSBO> list = sportDataBbSSSDaoMapper.findByAgainstInfoId(id);
		for (SportDataBbSSSBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		SportDataBbSSSPO po = new SportDataBbSSSPO();
		po.setSportAgainstInfoId(1l);
		po.setSpBig(new BigDecimal("1"));
		po.setSpSmall(new BigDecimal(1));
		po.setPresetScore(new BigDecimal(1));
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		sportDataBbSSSDaoMapper.insert(po);
		System.out.println(po.getId());
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportDataBbSSSPO po = new SportDataBbSSSPO();
		po.setId(1l);
		po.setSportAgainstInfoId(1l);
		po.setSpBig(new BigDecimal("1"));
		po.setSpSmall(new BigDecimal(1));
		po.setUpdateTime(DateUtil.getNowDate());
		sportDataBbSSSDaoMapper.updateByPrimaryKey(po);
	}

}
