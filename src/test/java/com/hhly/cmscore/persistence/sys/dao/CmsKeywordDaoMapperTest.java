
package com.hhly.cmscore.persistence.sys.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.sys.dao.CmsKeywordDaoMapper;
import com.hhly.cmscore.persistence.sys.po.CmsKeywordPO;
import com.hhly.skeleton.cms.sysmgr.vo.CmsKeywordVO;

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
public class CmsKeywordDaoMapperTest {

	@Autowired
	CmsKeywordDaoMapper cmsKeywordDaoMapper;
	
	@Test
	@Rollback(true)
	public void testAddList() {
		List<CmsKeywordPO> list = new ArrayList<>();
		CmsKeywordPO po = new CmsKeywordPO();
		po.setKeyword("123");
		po.setGrade((short)1);
		po.setReplaced("123");
		po.setStatus((short)1);
		po.setCreateBy("cheng.chen");
		po.setModifyBy("cheng.chen");
		list.add(po);
		int num = cmsKeywordDaoMapper.addList(list);
	}

	@Test
	public void testFindTotal() {
		CmsKeywordVO vo = new CmsKeywordVO();
		vo.setKeyword("123");
		cmsKeywordDaoMapper.findTotal(vo);
	}

	@Test
	public void testFind() {
		CmsKeywordVO vo = new CmsKeywordVO();
		vo.setKeyword("123");
		vo.setPageIndex(0);
		vo.setPageSize(10);
		cmsKeywordDaoMapper.find(vo);
	}

	@Test
	@Rollback(true)
	public void testUpdateList() {
		List<CmsKeywordPO> list = new ArrayList<>();
		CmsKeywordPO po = new CmsKeywordPO();
		po.setId(1);
		po.setKeyword("123");
		list.add(po);
		cmsKeywordDaoMapper.updateList(list);
	}

	@Test
	public void testExcelList() {
		CmsKeywordVO vo = new CmsKeywordVO();
		vo.setKeyword("123");
		vo.setPageIndex(0);
		vo.setPageSize(10);
		cmsKeywordDaoMapper.excelList(vo);
	}

}
