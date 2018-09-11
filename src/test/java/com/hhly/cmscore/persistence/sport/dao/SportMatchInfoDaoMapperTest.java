
package com.hhly.cmscore.persistence.sport.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.sport.po.SportMatchInfoPO;
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
public class SportMatchInfoDaoMapperTest {

	@Autowired
	SportMatchInfoDaoMapper sportMatchInfoDaoMapper;
	
	@Test
	@Rollback(true)
	public void testInsert() {
		//xml 没有配置matchid值  加上即可
		SportMatchInfoPO po = new SportMatchInfoPO();
		po.setLogoUrl("1");
		po.setMatchDataUrl("2");
		po.setMatchId(10000l);
		po.setMatchType((short)1);
		po.setMatchFullName("test");
		po.setMatchShortName("te");
		po.setModifyBy("cheng.chen");
		po.setModifyTime(DateUtil.getNowDate());
		po.setRemark("123");
		po.setUpdateTime(DateUtil.getNowDate());
		po.setCreateTime(DateUtil.getNowDate());
		sportMatchInfoDaoMapper.insert(po);
		System.out.println(po.getId());
	}

	@Test
	@Rollback(true)
	public void testUpdateById() {
		SportMatchInfoPO po = new SportMatchInfoPO();
		po.setId(1l);
		po.setLogoUrl("1");
		po.setMatchDataUrl("2");
		po.setMatchId(1l);
		po.setMatchType((short)1);
		po.setMatchFullName("test");
		po.setMatchShortName("te");
		po.setModifyBy("cheng.chen");
		po.setModifyTime(DateUtil.getNowDate());
		po.setRemark("123");
		po.setUpdateTime(DateUtil.getNowDate());
		int num = sportMatchInfoDaoMapper.updateById(po);
	}

}
