package com.hhly.cmscore.persistence.trans.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.trans.dao.TransChannelSettleDaoMapper;
import com.hhly.skeleton.cms.transmgr.bo.TransChannelSettleBO;
import com.hhly.skeleton.cms.transmgr.bo.TransChannelSettleExcelBO;
import com.hhly.skeleton.cms.transmgr.vo.TransChannelSettleVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class TransChannelSettleDaoMapperTest {

	@Autowired
	private TransChannelSettleDaoMapper mapper;
	
	@Test
	public void testFindTotal() {
		int total = mapper.findTotal(new TransChannelSettleVO());
		System.out.println(total);
	}

	@Test
	public void testFindTrans() {
		TransChannelSettleVO vo = new TransChannelSettleVO();
		List<TransChannelSettleBO> bos = mapper.findTrans(vo);
		int total = mapper.findTotal(vo);
		assertTrue(bos.size()==total);
	}

	@Test
	public void testFindExcel() {
		TransChannelSettleVO vo = new TransChannelSettleVO();
		List<TransChannelSettleExcelBO> bos = mapper.findExcel(vo);
		int total = mapper.findTotal(vo);
		assertTrue(bos.size()==total);
	}

}
