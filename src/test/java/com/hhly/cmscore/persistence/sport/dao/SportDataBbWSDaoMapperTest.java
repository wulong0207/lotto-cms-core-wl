
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

import com.hhly.cmscore.persistence.sport.dao.SportDataBbWSDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportDataBbWFPO;
import com.hhly.cmscore.persistence.sport.po.SportDataBbWSPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBbWFBO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBbWSBO;

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
public class SportDataBbWSDaoMapperTest {
	
	@Autowired
	SportDataBbWSDaoMapper sportDataBbWSDaoMapper;
	
	@Test
	public void testFindByAgainstInfoId() {
		long id = 1l;
		List<SportDataBbWSBO> list = sportDataBbWSDaoMapper.findByAgainstInfoId(id);
		for (SportDataBbWSBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		SportDataBbWSPO po = new SportDataBbWSPO();
		po.setSportAgainstInfoId(1l);
		po.setSpWin15(new BigDecimal(1));
		po.setSpFail15(new BigDecimal(1));
		po.setSpWin26(new BigDecimal(1));
		po.setSpFail26(new BigDecimal(11));
		po.setSpWin610(new BigDecimal(1));
		po.setSpFail610(new BigDecimal(1));
		po.setSpWin1115(new BigDecimal(1));
		po.setSpFail1115(new BigDecimal(1));
		po.setSpWin1620(new BigDecimal(1));
		po.setSpFail1620(new BigDecimal(1));
		po.setSpWin2125(new BigDecimal(1));
		po.setSpFail2125(new BigDecimal(1));
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		int num = sportDataBbWSDaoMapper.insert(po);
		System.out.println(num);
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportDataBbWSPO po = new SportDataBbWSPO();
		po.setId(1l);
		po.setSportAgainstInfoId(1l);
		po.setSpWin15(new BigDecimal(1));
		po.setSpFail15(new BigDecimal(1));
		po.setSpWin26(new BigDecimal(1));
		po.setSpFail26(new BigDecimal(11));
		po.setSpWin610(new BigDecimal(1));
		po.setSpFail610(new BigDecimal(1));
		po.setSpWin1115(new BigDecimal(1));
		po.setSpFail1115(new BigDecimal(1));
		po.setSpWin1620(new BigDecimal(1));
		po.setSpFail1620(new BigDecimal(1));
		po.setSpWin2125(new BigDecimal(1));
		po.setSpFail2125(new BigDecimal(1));
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		int num = sportDataBbWSDaoMapper.updateByPrimaryKey(po);
		System.out.println(num);
	}

}
