package com.hhly.cmscore.persistence.operate.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateHelpTypeDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateHelpTypePO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateHelpTypeBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpTypeVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateHelpTypeDaoMapperTest {

	@Autowired
	private OperateHelpTypeDaoMapper mapper;
	
	@Test
	public void testList() {
		List<OperateHelpTypeBO> ret = mapper.list();
		System.out.println(ret);
	}

	@Test
	public void testCount() {
		int count = mapper.count(new OperateHelpTypeVO());
		List<OperateHelpTypeBO> ret = mapper.list();
		Assert.assertTrue(count==ret.size());
	}

	@Test
	public void testMerge() {
		OperateHelpTypeVO vo = new OperateHelpTypeVO();
		vo.setCode("1.1.1");
		vo.setFullName("testByJunit");
		vo.setShortName("tbj");
		vo.setParent(1L);
		vo.setMenu(1);
		vo.setStatus((short)1);
		vo.setIdentifiers("Junit");
		vo.setVirtual((short)1);
		int ret = mapper.merge(new OperateHelpTypePO(vo));
		Assert.assertTrue(ret==1);
	}

	@Test
	public void testFindMaxTypeCode() {
		OperateHelpTypeVO vo = new OperateHelpTypeVO();
		vo.setId(2L);
		String ret = mapper.findMaxTypeCode(vo);
		System.out.println(ret);
	}

	@Test
	public void testFindParents() {
		OperateHelpVO vo = new OperateHelpVO();
		vo.setTypeId(2L);
		List<String> ret = mapper.findParents(vo);
		System.out.println(ret);
	}

	@Test
	public void testUpdateOrder() {
		OperateHelpTypeVO vo = new OperateHelpTypeVO();
		vo.setCode("1.1.1");
		vo.setFullName("testByJunit");
		vo.setShortName("tbj");
		vo.setParent(1L);
		vo.setMenu(1);
		vo.setStatus((short)1);
		vo.setIdentifiers("Junit");
		vo.setVirtual((short)1);
		OperateHelpTypeVO vo2 = new OperateHelpTypeVO();
		vo.setCode("1.1.2");
		vo.setFullName("testByJunit2");
		vo.setShortName("tbj2");
		vo.setParent(2L);
		vo.setMenu(2);
		vo.setStatus((short)2);
		vo.setIdentifiers("Junit");
		vo.setVirtual((short)2);
		List<OperateHelpTypePO> pos = new ArrayList<>();
		pos.add(new OperateHelpTypePO(vo));
		pos.add(new OperateHelpTypePO(vo2));
		int ret = mapper.updateOrder(pos);
		System.out.println(ret);
	}

}
