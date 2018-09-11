package com.hhly.cmscore.persistence.operate.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateImgDaoMapper;
import com.hhly.skeleton.cms.operatemgr.bo.OperateImgBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateImgVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateImgDaoMapperTest {

	@Autowired
	private OperateImgDaoMapper mapper;
	
	@Test
	public void testFindTotal() {
		int ret = mapper.findTotal(new OperateImgVO());
		System.out.println(ret);
	}

	@Test
	public void testFindList() {
		OperateImgVO vo = new OperateImgVO();
		List<OperateImgBO> ret = mapper.findList(vo);
		int count = mapper.findTotal(new OperateImgVO());
		Assert.assertTrue(ret.size()==count);
	}

	@Test
	public void testAddOperateImg() {
		List<OperateImgVO> vos = new ArrayList<>();
		OperateImgVO vo = new OperateImgVO();
		vo.setName("junit_name");
		vo.setGroupid(1);
		vo.setUrl("urlJunit");
		vo.setResolution("1*junit");
		vo.setSizes("junit-size");
		vo.setCreateBy("junit");
		vos.add(vo);
		OperateImgVO vo2 = new OperateImgVO();
		vo2.setName("junit_name2");
		vo2.setGroupid(2);
		vo2.setUrl("urlJunit2");
		vo2.setResolution("1*junit");
		vo2.setSizes("junit-size");
		vo2.setCreateBy("junit");
		vos.add(vo);
		vos.add(vo2);
		mapper.addOperateImg(vos);
	}

	@Test
	public void testUpdOperateImg() {
		OperateImgVO vo = new OperateImgVO();
		vo.setId(1);
		int ret = mapper.updOperateImg(vo);
		System.out.println(ret);
	}

	@Test
	public void testListOperateImgInfo() {
		List<String> ids = Arrays.asList("1","2");
		List<OperateImgBO> ret = mapper.listOperateImgInfo(ids);
		System.out.println(ret);
	}

	@Test
	public void testDelOperateImg() {
		List<String> ids = Arrays.asList("1","2");
		int ret = mapper.delOperateImg(ids);
		System.out.println(ret);
	}

	@Test
	public void testUpdOperateImgMove() {
		List<String> ids = Arrays.asList("1","2");
		int ret = mapper.updOperateImgMove(ids, 1,"junit");
		System.out.println(ret);
	}

	@Test
	public void testGetOperateImg() {
		OperateImgVO vo = new OperateImgVO();
		vo.setId(1);
		vo.setName("junit");
		OperateImgBO ret = mapper.getOperateImg(vo);
		System.out.println(ret);
	}

}
