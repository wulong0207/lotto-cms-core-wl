package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateUserAnalysisDaoMapper;
import com.hhly.skeleton.cms.operatemgr.bo.OperateUserAnalysisBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateUserAnalysisVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateUserAnalysisDaoMapperTest {

	@Autowired
	private OperateUserAnalysisDaoMapper mapper;
	
	@Test
	public void testFindPaging() {
		OperateUserAnalysisVO vo = new OperateUserAnalysisVO();
		List<OperateUserAnalysisBO> ret = mapper.findPaging(vo);
		int count = mapper.findCount(vo);
		Assert.assertTrue(ret.size()==count);
	}

	@Test
	public void testFindCount() {
		OperateUserAnalysisVO vo = new OperateUserAnalysisVO();
		int ret = mapper.findCount(vo);
		System.out.println(ret);
	}

	@Test
	public void testFindExcel() {
		OperateUserAnalysisVO vo = new OperateUserAnalysisVO();
		List<OperateUserAnalysisBO> ret = mapper.findExcel(vo);
		int count = mapper.findCount(vo);
		Assert.assertTrue(ret.size()==count);
	}

}
