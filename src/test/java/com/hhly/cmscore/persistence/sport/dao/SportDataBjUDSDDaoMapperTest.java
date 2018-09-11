
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

import com.hhly.cmscore.persistence.sport.dao.SportDataBjUDSDDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportDataBjUDSDPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBjScoreBO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBjUDSDBO;

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
public class SportDataBjUDSDDaoMapperTest {

	@Autowired
	SportDataBjUDSDDaoMapper sportDataBjUDSDDaoMapper;
	
	@Test
	public void testFindByAgainstInfoId() {
		long id = 1l;
		List<SportDataBjUDSDBO> list = sportDataBjUDSDDaoMapper.findByAgainstInfoId(id);
		for (SportDataBjUDSDBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		SportDataBjUDSDPO po = new SportDataBjUDSDPO();
		po.setSportAgainstInfoId(1l);
		po.setSpDownDouble(1.0f);
		po.setSpDownSingle(1.0f);
		po.setSpUpDouble(1.0f);
		po.setSpUpSingle(1.0f);
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		sportDataBjUDSDDaoMapper.insert(po);
		System.out.println(po.getId());
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportDataBjUDSDPO po = new SportDataBjUDSDPO();
		po.setSportAgainstInfoId(1l);
		po.setId(1l);
		po.setSpDownDouble(1.0f);
		po.setSpDownSingle(1.0f);
		po.setSpUpDouble(1.0f);
		po.setSpUpSingle(1.0f);
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		int num = sportDataBjUDSDDaoMapper.updateByPrimaryKey(po);
		System.out.println(num);
	}

}
