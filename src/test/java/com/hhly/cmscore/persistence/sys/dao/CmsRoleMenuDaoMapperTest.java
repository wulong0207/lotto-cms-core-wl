
package com.hhly.cmscore.persistence.sys.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.sys.dao.CmsRoleMenuDaoMapper;
import com.hhly.cmscore.persistence.sys.po.CmsRoleMenuPO;

/**
 * @desc    
 * @author  cheng chen
 * @date    2017年6月6日
 * @company 益彩网络科技公司
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager") 
public class CmsRoleMenuDaoMapperTest {
	
	@Autowired
	CmsRoleMenuDaoMapper cmsRoleMenuDaoMapper;
	
	@Test
	@Rollback(true)
	public void testDeleteByPrimaryKey() {
		CmsRoleMenuPO po = new CmsRoleMenuPO();
		po.setRoleId(1);
		cmsRoleMenuDaoMapper.deleteByPrimaryKey(po);
	}

	@Test
	public void testFindAuthorityByRoleId() {
		int id = 1;
		cmsRoleMenuDaoMapper.findAuthorityByRoleId(id);
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		CmsRoleMenuPO po = new CmsRoleMenuPO();
		po.setMenuId(1);
		po.setRoleId(1);
		po.setRoleMenuId(1);
		po.setMenuButton("213");
		cmsRoleMenuDaoMapper.insert(po);
	}

}
