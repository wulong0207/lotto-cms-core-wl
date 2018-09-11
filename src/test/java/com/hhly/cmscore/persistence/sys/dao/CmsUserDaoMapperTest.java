
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

import com.hhly.cmscore.persistence.sys.dao.CmsUserDaoMapper;
import com.hhly.cmscore.persistence.sys.po.CmsUserPO;
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
public class CmsUserDaoMapperTest {

	@Autowired
	CmsUserDaoMapper cmsUserDaoMapper;
	
	
	@Test
	public void testFindTotalBySelective() {
		CMSUserVO vo = new CMSUserVO();
		vo.setUserStatus(1);
		cmsUserDaoMapper.findTotalBySelective(vo);
	}

	@Test
	public void testFindDataBySelective() {
		CMSUserVO vo = new CMSUserVO();
		vo.setRoleId(1);
		vo.setPageIndex(0);
		vo.setPageSize(10);
		cmsUserDaoMapper.findDataBySelective(vo);
	}

	@Test
	public void testFindUserName() {
		CMSUserVO vo = new CMSUserVO();
		vo.setRoleId(1);
		cmsUserDaoMapper.findUserName(vo);
	}

	@Test
	public void testFindUser() {
		CMSUserVO vo = new CMSUserVO();
		vo.setRoleId(1);
		cmsUserDaoMapper.findUser(vo);
	}

	@Test
	public void testFindCount() {
		CMSUserVO vo = new CMSUserVO();
		vo.setRoleId(1);
		cmsUserDaoMapper.findCount(vo);
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		CmsUserPO po = new CmsUserPO();
		po.setUserName("fdsf");
		po.setDepart(1);
		po.setUserMobile("fds");
		po.setUserStatus(1);
		po.setUserPassword("123");
		po.setUserRealName("123");
		po.setUserEmail("sdf");
		po.setCmsRoleId(1);
		po.setCreateBy("cheng.chen");
		po.setRemark("123");
		po.setUserCname("123");
		po.setHeadUrl("123");
		cmsUserDaoMapper.insert(po);
		System.out.println(po.getUserId());
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKeySelective() {
		CmsUserPO po = new CmsUserPO();
		po.setUserId(1);
		po.setRemark("test");
		cmsUserDaoMapper.updateByPrimaryKeySelective(po);
	}

	@Test
	@Rollback(true)
	public void testDeleteByPrimaryKey() {
		int id = 1;
		cmsUserDaoMapper.deleteByPrimaryKey(id);
	}

	@Test
	@Rollback(true)
	public void testUpdateUserLastLoginTime() {
		CmsUserPO po = new CmsUserPO();
		po.setUserId(1);
		po.setThisLoginIP("192.168.0.1");
		po.setMonthLoginCount(1);
		cmsUserDaoMapper.updateUserLastLoginTime(po);
	}

	@Test
	@Rollback(true)
	public void testUpdatePwd() {
		CmsUserPO po = new CmsUserPO();
		po.setUserId(1);
		po.setUserPassword("123456");
		cmsUserDaoMapper.updatePwd(po);
	}

	/**
	 * 该方法没有mybatis 实现sql findUserType
	 * 
	 * @date 2017年6月6日上午10:51:31
	 * @author cheng.chen
	 */
	@Test
	public void testFindUserType() {
		fail("Not yet implemented");
	}

}
