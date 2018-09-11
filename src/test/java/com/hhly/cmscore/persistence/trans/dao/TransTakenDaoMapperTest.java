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

import com.hhly.cmscore.persistence.trans.dao.TransTakenDaoMapper;
import com.hhly.skeleton.cms.transmgr.bo.TransTakenBO;
import com.hhly.skeleton.cms.transmgr.bo.TransTakenExcelBO;
import com.hhly.skeleton.cms.transmgr.vo.TransTakenVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class TransTakenDaoMapperTest {
	
	@Autowired
	private TransTakenDaoMapper mapper;
	
	@Test
	public void testFindStatis() {
		Map<String, Object> ret = mapper.findStatis(new TransTakenVO());
		System.out.println(ret);
	}

	@Test
	public void testFindTrans() {
		TransTakenVO vo = new TransTakenVO();
		List<TransTakenBO> bos = mapper.findTrans(vo);
		int total = mapper.findTotal(vo);
		assertTrue(bos.size()==total);
	}

	@Test
	public void testFindTotal() {
		TransTakenVO vo = new TransTakenVO();
		int total = mapper.findTotal(vo);
		System.out.println(total);
	}

	@Test
	public void testFindExcel() {
		TransTakenVO vo = new TransTakenVO();
		List<TransTakenExcelBO> bos = mapper.findExcel(vo);
		int total = mapper.findTotal(vo);
		assertTrue(bos.size()==total);
	}

//	@Test
//	public void testUpdateStatus() {
//		List<TransTakenPO> pos = new ArrayList<>();
//		TransTakenVO vo = new TransTakenVO();
//		vo.setTransStatus(1);
//		vo.setId(2L);
//		TransTakenVO vo2 = new TransTakenVO();
//		vo2.setTransStatus(2);
//		vo2.setId(3L);
//		pos.add(new TransTakenPO(vo));
//		pos.add(new TransTakenPO(vo2));
//		int ret = mapper.updateStatus(pos);
//		System.out.println(ret);
//	}

}
