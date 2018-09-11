package com.hhly.cmscore.persistence.operate.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateArticleTopDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateArticleTopPO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleTopVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateArticleTopDaoMapperTest {

	@Autowired
	private OperateArticleTopDaoMapper mapper;
	
	@Test
	public void testAdd() {
		List<OperateArticleTopPO> pos = new ArrayList<>();
		OperateArticleTopVO vo = new OperateArticleTopVO();
		vo.setTypeId(1L);
		vo.setArticleId(100L);
		vo.setTitle("Junit_title");
		vo.setColor("#ffffff");
		vo.setUptime(new Date());
		vo.setDowntime(new Date());
		vo.setIsTop((byte)1);
		OperateArticleTopVO vo2 = new OperateArticleTopVO();
		vo2.setTypeId(2L);
		vo2.setArticleId(200L);
		vo2.setTitle("Junit_title2");
		vo2.setColor("#ffffff");
		vo2.setUptime(new Date());
		vo2.setDowntime(new Date());
		vo2.setIsTop((byte)1);
		pos.add(new OperateArticleTopPO(vo));
		pos.add(new OperateArticleTopPO(vo2));
		int ret = mapper.add(pos);
		System.out.println(ret);
	}

	@Test
	public void testUpdate() {
		List<OperateArticleTopPO> pos = new ArrayList<>();
		OperateArticleTopVO vo = new OperateArticleTopVO();
		vo.setId(694L);
		vo.setTypeId(1L);
		vo.setArticleId(100L);
		vo.setTitle("Junit_title");
		vo.setColor("#ffffff");
		vo.setUptime(new Date());
		vo.setDowntime(new Date());
		vo.setIsTop((byte)1);
		OperateArticleTopVO vo2 = new OperateArticleTopVO();
		vo2.setId(693L);
		vo2.setTypeId(2L);
		vo2.setArticleId(200L);
		vo2.setTitle("Junit_title2");
		vo2.setColor("#ffffff");
		vo2.setUptime(new Date());
		vo2.setDowntime(new Date());
		vo2.setIsTop((byte)1);
		pos.add(new OperateArticleTopPO(vo));
		pos.add(new OperateArticleTopPO(vo2));
		int ret = mapper.update(pos);
		System.out.println(ret);
	}

	@Test
	public void testDelete() {
		int ret = mapper.delete(253L);
		System.out.println(ret);
	}

}
