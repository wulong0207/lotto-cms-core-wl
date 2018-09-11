
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

import com.hhly.cmscore.persistence.sport.dao.SportDataBjWDFDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportDataBjUDSDPO;
import com.hhly.cmscore.persistence.sport.po.SportDataBjWDFPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBjUDSDBO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBjWDFBO;

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
public class SportDataBjWDFDaoMapperTest {

	@Autowired
	SportDataBjWDFDaoMapper sportDataBjWDFDaoMapper;
	
	@Test
	public void testFindByAgainstInfoId() {
		long id = 1l;
		List<SportDataBjWDFBO> list = sportDataBjWDFDaoMapper.findByAgainstInfoId(id);
		for (SportDataBjWDFBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		SportDataBjWDFPO po = new SportDataBjWDFPO();
		po.setSportAgainstInfoId(1l);
		po.setSpDraw(1.0f);
		po.setSpFail(1.0f);
		po.setSpWin(1.0f);
		po.setLetNum((short)1);
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		sportDataBjWDFDaoMapper.insert(po);
		System.out.println(po.getId());
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportDataBjWDFPO po = new SportDataBjWDFPO();
		po.setId(1l);
		po.setSportAgainstInfoId(1l);
		po.setSpDraw(1.0f);
		po.setSpFail(1.0f);
		po.setSpWin(1.0f);
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		int num = sportDataBjWDFDaoMapper.updateByPrimaryKey(po);
		System.out.println(num);
	}

}
