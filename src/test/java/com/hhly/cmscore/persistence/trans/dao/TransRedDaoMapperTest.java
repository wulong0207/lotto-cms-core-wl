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

import com.hhly.cmscore.persistence.trans.dao.TransRedDaoMapper;
import com.hhly.skeleton.cms.transmgr.bo.TransRedBO;
import com.hhly.skeleton.cms.transmgr.bo.TransRedExcelBO;
import com.hhly.skeleton.cms.transmgr.vo.TransRedVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class TransRedDaoMapperTest {

	@Autowired
	private TransRedDaoMapper mapper;
	
	@Test
	public void testFindStatis() {
		Map<String, Object> ret = mapper.findStatis(new TransRedVO());
		System.out.println(ret);
	}

	@Test
	public void testFindTrans() {
		TransRedVO vo = new TransRedVO();
		List<TransRedBO> bos = mapper.findTrans(vo);
		int total = mapper.findTotal(vo);
		assertTrue(bos.size()==total);
	}

	@Test
	public void testFindTotal() {
		TransRedVO vo = new TransRedVO();
		int total = mapper.findTotal(vo);
		System.out.println(total);
	}

	@Test
	public void testFindExcel() {
		TransRedVO vo = new TransRedVO();
		List<TransRedExcelBO> bos = mapper.findExcel(vo);
		int total = mapper.findTotal(vo);
		assertTrue(bos.size()==total);
	}

}
