
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

import com.hhly.cmscore.persistence.sys.dao.CmsUserMenuDaoMapper;
import com.hhly.cmscore.persistence.sys.po.CmsUserMenuPO;
import com.hhly.skeleton.cms.sysmgr.vo.CMSUserVO;

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
public class CmsUserMenuDaoMapperTest {

	@Autowired
	CmsUserMenuDaoMapper cmsUserMenuDaoMapper;
	
	@Test
	public void testFindUserAuthTree() {
		CMSUserVO vo = new CMSUserVO();
		vo.setUserId(1);
		vo.setCmsRoleId(1);
		cmsUserMenuDaoMapper.findUserAuthTree(vo);
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		CmsUserMenuPO po = new CmsUserMenuPO();
		po.setUserId(1);
		po.setMenuId(1);
		po.setUserAuth("123");
		cmsUserMenuDaoMapper.insert(po);
	}

	@Test
	@Rollback(true)
	public void testDeleteByPrimaryKey() {
		CmsUserMenuPO po = new CmsUserMenuPO();
		po.setUserId(1);
		cmsUserMenuDaoMapper.deleteByPrimaryKey(po);
	}

}
