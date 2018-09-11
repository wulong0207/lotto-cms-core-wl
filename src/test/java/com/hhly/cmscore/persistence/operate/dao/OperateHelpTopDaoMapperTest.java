package com.hhly.cmscore.persistence.operate.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateHelpTopDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateHelpTopPO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpTopVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateHelpTopDaoMapperTest {
	
	@Autowired
	private OperateHelpTopDaoMapper mapper;
	
	@Test
	public void testBatchAdd() {
		List<OperateHelpTopPO> pos = new ArrayList<>();
		OperateHelpTopVO vo = new OperateHelpTopVO();
		vo.setTypeId(1L);
		vo.setHelpId(1L);
		vo.setTitle("Junit_title");
		vo.setUptime(new Date());
		vo.setDowntime(new Date());
		vo.setIsTop((byte)1);
		OperateHelpTopVO vo2 = new OperateHelpTopVO();
		vo2.setTypeId(2L);
		vo2.setHelpId(2L);
		vo2.setTitle("Junit_title2");
		vo2.setUptime(new Date());
		vo2.setDowntime(new Date());
		vo2.setIsTop((byte)1);
		pos.add(new OperateHelpTopPO(vo));
		pos.add(new OperateHelpTopPO(vo2));
		int ret = mapper.batchAdd(pos);
		Assert.assertTrue(ret==2);
	}

	@Test
	public void testDelete() {
		int ret = mapper.delete(6L);
		System.out.println(ret);
	}

}
