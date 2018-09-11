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

import com.hhly.cmscore.persistence.trans.dao.TransRechargeDaoMapper;
import com.hhly.skeleton.cms.transmgr.bo.TransRechargeBO;
import com.hhly.skeleton.cms.transmgr.bo.TransRechargeExcelBO;
import com.hhly.skeleton.cms.transmgr.vo.TransRechargeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class TransRechargeDaoMapperTest {

	@Autowired
	private TransRechargeDaoMapper mapper;
	
	@Test
	public void testFindStatis() {
		Map<String, Object> ret = mapper.findStatis(new TransRechargeVO());
		System.out.println(ret);
	}

	@Test
	public void testFindTrans() {
		TransRechargeVO vo = new TransRechargeVO();
		List<TransRechargeBO> bos = mapper.findTrans(vo);
		int total = mapper.findTotal(vo);
		assertTrue(bos.size()==total);
	}

	@Test
	public void testFindTotal() {
		TransRechargeVO vo = new TransRechargeVO();
		int total = mapper.findTotal(vo);
		System.out.println(total);
	}

	@Test
	public void testFindExcel() {
		TransRechargeVO vo = new TransRechargeVO();
		List<TransRechargeExcelBO> bos = mapper.findExcel(vo);
		int total = mapper.findTotal(vo);
		assertTrue(bos.size()==total);
	}

	@Test
	public void testResupply() {
	}

}
