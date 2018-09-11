package com.hhly.cmscore.persistence.trans.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.trans.dao.TransUserDaoMapper;
import com.hhly.skeleton.cms.transmgr.bo.TransUserBO;
import com.hhly.skeleton.cms.transmgr.bo.TransUserExcelBO;
import com.hhly.skeleton.cms.transmgr.vo.TransUserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class TransUserDaoMapperTest {

	@Autowired
	private TransUserDaoMapper mapper;
	
	@Test
	public void testFindTrans() {
		TransUserVO vo = new TransUserVO();
		List<TransUserBO> bos = mapper.findTrans(vo);
		int total = mapper.findTotal(vo);
		assertTrue(bos.size()==total);
	}

	@Test
	public void testFindStatis() {
		Map<String, Object> ret = mapper.findStatis(new TransUserVO());
		System.out.println(ret);
	}

	@Test
	public void testFindTotal() {
		TransUserVO vo = new TransUserVO();
		int total = mapper.findTotal(vo);
		System.out.println(total);
	}

	@Test
	public void testFindExcel() {
		TransUserVO vo = new TransUserVO();
		List<TransUserExcelBO> bos = mapper.findExcel(vo);
		int total = mapper.findTotal(vo);
		assertTrue(bos.size()==total);
	}

}
