
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

import com.hhly.cmscore.persistence.sys.dao.CmsMenuDaoMapper;
import com.hhly.cmscore.persistence.sys.po.CmsMenuPO;
import com.hhly.skeleton.cms.sysmgr.bo.CMSMenuBO;
import com.hhly.skeleton.cms.sysmgr.vo.CMSMenuVO;

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
public class CmsMenuDaoMapperTest {
	
	@Autowired
	CmsMenuDaoMapper cmsMenuDaoMapper;

	@Test
	public void testSelectMenuAll() {
		cmsMenuDaoMapper.selectMenuAll();
	}

	@Test
	@Rollback(true)
	public void testDeleteByPrimaryKey() {
		int id = 1;
		cmsMenuDaoMapper.deleteByPrimaryKey(id);
	}

	@Test
	public void testFindMenuByUserId() {
		int id = 1;
		cmsMenuDaoMapper.findMenuByUserId(id);
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		CmsMenuPO po = new CmsMenuPO();
		po.setMenuLevel(1);
		po.setMenuButton("1");
		po.setMenuTitle("fds");
		po.setMenuUrl("dsf/url");
		po.setMenuDesc("fds");
		po.setOrderId(1);
		po.setCreateBy("cheng.chen");
		po.setModifyBy("cheng.chen");
		cmsMenuDaoMapper.insert(po);
		System.out.println(po.getMenuId());
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKeySelective() {
		CmsMenuPO po = new CmsMenuPO();
		po.setMenuId(1);
		po.setMenuTitle("fds");
		cmsMenuDaoMapper.updateByPrimaryKeySelective(po);
	}

	@Test
	public void testFindMenu() {
		CMSMenuVO vo = new CMSMenuVO();
		vo.setMenuUrl("123");
		CMSMenuBO bo = cmsMenuDaoMapper.findMenu(vo);
	}

	@Test
	public void testFindMenus() {
		CMSMenuVO vo = new CMSMenuVO();
		vo.setMenuUrl("123");
		cmsMenuDaoMapper.findMenus(vo);
	}

}
