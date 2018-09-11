
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

import com.hhly.cmscore.persistence.sys.dao.CmsRoleDaoMapper;
import com.hhly.cmscore.persistence.sys.po.CmsRolePO;
import com.hhly.skeleton.cms.sysmgr.vo.CMSRoleVO;

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
public class CmsRoleDaoMapperTest {

	@Autowired
	CmsRoleDaoMapper cmsRoleDaoMapper;
	
	@Test
	@Rollback(true)
	public void testInsert() {
		CmsRolePO po = new CmsRolePO();
		po.setRoleMenuId(1);
		po.setRoleName("123");
		po.setRoleStatus(1);
		po.setRoleDesc("213");
		po.setRemark("123");
		po.setDepart(1);
		po.setCreateBy("cheng.chen");
		po.setModifyBy("cheng.chen");
		cmsRoleDaoMapper.insert(po);
	}

	@Test
	
	public void testFindTotalBySelective() {
		CMSRoleVO vo = new CMSRoleVO();
		vo.setRoleStatus(1);
		cmsRoleDaoMapper.findTotalBySelective(vo);
	}

	@Test
	public void testFindDataBySelective() {
		CMSRoleVO vo = new CMSRoleVO();
		vo.setRoleStatus(1);
		vo.setPageIndex(0);
		vo.setPageSize(10);
		cmsRoleDaoMapper.findDataBySelective(vo);
	}

	@Test
	public void testFindRoleName() {
		cmsRoleDaoMapper.findRoleName();
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		CmsRolePO po = new CmsRolePO();
		po.setRoleId(1);;
		po.setRoleStatus(1);
		cmsRoleDaoMapper.updateByPrimaryKey(po);
	}

	@Test
	@Rollback(true)
	public void testDeleteByPrimaryKey() {
		cmsRoleDaoMapper.deleteByPrimaryKey(1);
	}

}
