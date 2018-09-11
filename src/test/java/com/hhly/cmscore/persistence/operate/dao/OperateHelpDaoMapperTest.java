package com.hhly.cmscore.persistence.operate.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateHelpDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateHelpPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateHelpBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateHelpDaoMapperTest {

	@Autowired
	private OperateHelpDaoMapper mapper;

	@Test
	public void testFindTotal() {
		OperateHelpVO vo = new OperateHelpVO();
		int ret = mapper.findTotal(vo);
		System.out.println(ret);
	}

	@Test
	public void testList() {
		OperateHelpVO vo = new OperateHelpVO();
		List<OperateHelpBO> ret = mapper.list(vo);
		int count = mapper.findTotal(vo);
		Assert.assertTrue(ret.size()==count);
	}

	@Test
	public void testAdd() {
		OperateHelpVO vo = new OperateHelpVO();
		vo.setCode("junitTestArticleId");
		vo.setTitle("junit测试新增文章");
		vo.setContent("<p>junit测试新增文章</p>");
		vo.setTypeId(2L);
		vo.setTypeName("网站公告");
		vo.setStatus(1);
		vo.setOrderId(0);
		vo.setUrl("stackoverflow");
		vo.setHelpUrl("https://stackoverflow.com/questions/18656089/japanese-characters-escape-and-decoding-in-js");
		vo.setSummary("北京时间5月29日，意甲联赛结束了第38轮的争夺，2016-17赛季落下帷幕。尤文图斯再次蝉联联赛冠军，实现6连冠霸业；罗马成为联赛亚军，那不勒斯最终排名第3。");
		vo.setLabel("意甲联赛,第38轮,争夺");
		vo.setClick(666L);
		vo.setCreateBy("junit测试");
		vo.setModifyBy("junit测试Modify");
		vo.setReleaseTime(new Date());
		OperateHelpPO po = new OperateHelpPO(vo);
		int ret = mapper.add(po);
		Assert.assertTrue(ret==1);
	}

	@Test
	public void testFindSingle() {
		OperateHelpBO ret = mapper.findSingle(new OperateHelpVO());
		System.out.println(ret);
	}

	@Test
	public void testUpdate() {
		OperateHelpVO vo = new OperateHelpVO();
		vo.setId(23L);
		vo.setCode("junitTestArticleId");
		vo.setTitle("junit测试新增文章");
		vo.setContent("<p>junit测试新增文章</p>");
		vo.setTypeId(2L);
		vo.setTypeName("网站公告");
		vo.setStatus(1);
		vo.setOrderId(0);
		vo.setUrl("stackoverflow");
		vo.setHelpUrl("https://stackoverflow.com/questions/18656089/japanese-characters-escape-and-decoding-in-js");
		vo.setSummary("北京时间5月29日，意甲联赛结束了第38轮的争夺，2016-17赛季落下帷幕。尤文图斯再次蝉联联赛冠军，实现6连冠霸业；罗马成为联赛亚军，那不勒斯最终排名第3。");
		vo.setLabel("意甲联赛,第38轮,争夺");
		vo.setClick(666L);
		vo.setCreateBy("junit测试");
		vo.setModifyBy("junit测试Modify");
		vo.setReleaseTime(new Date());
		OperateHelpPO po = new OperateHelpPO(vo);
		int ret = mapper.update(po);
		System.out.println(ret);
	}

	@Test
	public void testUpdateStatus() {
		OperateHelpVO vo = new OperateHelpVO();
		vo.setId(23L);
		vo.setStatus(1);
		vo.setModifyBy("junit测试Modify");
		OperateHelpPO po = new OperateHelpPO(vo);
		int ret = mapper.updateStatus(po);
		System.out.println(ret);
	}

	@Test
	public void testFindMaxHelpCode() {
		String ret = mapper.findMaxHelpCode("20170605");
		System.out.println(ret);
	}

}
