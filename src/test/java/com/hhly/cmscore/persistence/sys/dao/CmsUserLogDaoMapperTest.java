
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

import com.hhly.cmscore.persistence.sys.dao.CmsUserLogDaoMapper;
import com.hhly.cmscore.persistence.sys.po.CmsUserLogPO;
import com.hhly.skeleton.cms.sysmgr.vo.CmsUserLogVO;

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
public class CmsUserLogDaoMapperTest {

	@Autowired
	CmsUserLogDaoMapper cmsUserLogDaoMapper;
	
	@Test
	@Rollback(true)
	public void testAdd() {
		CmsUserLogPO po = new CmsUserLogPO();
		po.setInContent("123");
		po.setOutContent("123");
		po.setTypeName("123");
		po.setUserName("123");
		po.setDetails("123");
		cmsUserLogDaoMapper.add(po);
	}

	@Test
	public void testCount() {
		CmsUserLogVO vo = new CmsUserLogVO();
		vo.setUserName("123");
		cmsUserLogDaoMapper.count(vo);
	}

	@Test
	public void testList() {
		CmsUserLogVO vo = new CmsUserLogVO();
		vo.setUserName("123");
		vo.setPageIndex(0);
		vo.setPageSize(10);
		cmsUserLogDaoMapper.list(vo);
	}

	@Test
	public void testFind() {
		CmsUserLogVO vo = new CmsUserLogVO();
		vo.setUserName("123");
		vo.setPageIndex(0);
		vo.setPageSize(10);
		cmsUserLogDaoMapper.find(vo);
	}

}
