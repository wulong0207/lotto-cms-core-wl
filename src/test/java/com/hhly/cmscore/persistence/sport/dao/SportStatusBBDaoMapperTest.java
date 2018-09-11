
package com.hhly.cmscore.persistence.sport.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.sport.dao.SportStatusBBDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportStatusBBPO;
import com.hhly.skeleton.base.util.DateUtil;

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
public class SportStatusBBDaoMapperTest {

	@Autowired
	SportStatusBBDaoMapper sportStatusBBDaoMapper;
	
	@Test
	@Rollback(true)
	public void testInsert() {
		SportStatusBBPO po = new SportStatusBBPO();
		po.setSportAgainstInfoId(1l);
		po.setStatusScoreWf((short)1);
		po.setStatusBigSmall((short)1);
		po.setStatusWf((short)1);
		po.setStatusLetWf((short)1);
		po.setModifyTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		po.setModifyBy("cheng.chen");
		po.setCreateTime(DateUtil.getNowDate());
		sportStatusBBDaoMapper.insert(po);
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportStatusBBPO po = new SportStatusBBPO();
		po.setId(1l);
		po.setStatusLetWf((short)2);
		sportStatusBBDaoMapper.updateByPrimaryKey(po);
	}

	@Test
	public void testGetBysSportAgainstInfoIds() {
		List<Long> ids = new ArrayList<>();
		ids.add(1l);
		ids.add(2l);
		sportStatusBBDaoMapper.getBysSportAgainstInfoIds(ids);
	}

}
