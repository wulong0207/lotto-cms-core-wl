
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

import com.hhly.cmscore.persistence.sport.dao.SportStatusBJDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportStatusBJPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.sportmgr.bo.SportStatusBJBO;

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
public class SportStatusBJDaoMapperTest {

	@Autowired
	SportStatusBJDaoMapper sportStatusBJDaoMapper;
	
	@Test
	@Rollback(true)
	public void testInsert() {
		SportStatusBJPO po = new SportStatusBJPO();
		po.setSportAgainstInfoId(1l);
		po.setStatusGoal((short)1);
		po.setStatusHfWdf((short)1);
		po.setStatusLetWdf((short)1);
		po.setStatusScore((short)1);
		po.setStatusUdSd((short)1);
		po.setModifyTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		po.setModifyBy("cheng.chen");
		po.setCreateTime(DateUtil.getNowDate());
		sportStatusBJDaoMapper.insert(po);
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportStatusBJPO po = new SportStatusBJPO();
		po.setId(1l);
		po.setStatusUdSd((short)2);
		sportStatusBJDaoMapper.updateByPrimaryKey(po);
	}

	@Test
	public void testGetBysSportAgainstInfoIds() {
		List<Long> ids = new ArrayList<>();
		ids.add(1l);
		ids.add(2l);
		List<SportStatusBJBO> list = sportStatusBJDaoMapper.getBysSportAgainstInfoIds(ids);
	}

}
