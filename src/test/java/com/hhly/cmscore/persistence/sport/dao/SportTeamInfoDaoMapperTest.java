
package com.hhly.cmscore.persistence.sport.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.sport.po.SportTeamInfoPO;

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
public class SportTeamInfoDaoMapperTest {

	@Autowired
	SportTeamInfoDaoMapper  sportTeamInfoDaoMapper;
	
	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportTeamInfoPO po = new SportTeamInfoPO();
		po.setId(1l);
		po.setRemark("fdsf");
		sportTeamInfoDaoMapper.updateById(po);
	}

}
