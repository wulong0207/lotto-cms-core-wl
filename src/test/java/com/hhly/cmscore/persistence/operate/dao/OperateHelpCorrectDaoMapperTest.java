package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateHelpCorrectDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateHelpCorrectPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateHelpCorrectBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpCorrectVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateHelpCorrectDaoMapperTest {

	@Autowired
	private OperateHelpCorrectDaoMapper mapper;
	
	@Test
	public void testFind() {
		OperateHelpCorrectVO vo = new OperateHelpCorrectVO();
		List<OperateHelpCorrectBO> ret = mapper.find(vo);
		System.out.println(ret);
	}

	@Test
	public void testFindTotal() {
		OperateHelpCorrectVO vo = new OperateHelpCorrectVO();
		int ret = mapper.findTotal(vo);
		System.out.println(ret);
	}

	@Test
	public void testUpdateById() {
		OperateHelpCorrectPO po = new OperateHelpCorrectPO();
		po.setSources("junitTest");
		po.setId(1);
		int ret = mapper.updateById(po);
		System.out.println(ret);
	}

}
