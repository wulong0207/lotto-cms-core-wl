package com.hhly.cmscore.persistence.operate.dao;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateAdDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateAdPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateAdLottoBO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateAdDaoMapperTest {

	@Autowired
	private OperateAdDaoMapper mapper;
	
	@Test
	public void testFindTotal() {
		int total = mapper.findTotal(new OperateAdVO());
		System.out.println(total);
	}
	@Test
	public void testList() {
		List<OperateAdBO> list = mapper.list(new OperateAdVO());
		System.out.println(list.size());
	}
	@Test
	public void testFindHomeOperAd() {
		List<OperateAdLottoBO> list = mapper.findHomeOperAd(new OperateAdVO());
		System.out.println(list.size());
	}
	@Test
	public void testAddAdv() {
		OperateAdVO vo = new OperateAdVO();
		vo.setAdUrl("测试url");
		vo.setAdvCode("111");
		vo.setAdvTitle("测试title");
		vo.setPlatform("1");
		vo.setMenu((short)1);
		vo.setPosition((short)1);
		vo.setOnlineTime(new Date());
		vo.setOfflineTime(new Date());
		vo.setOrderId((short)1);
		vo.setCreateBy("admin");
		vo.setDefaultAd(1);
		int i = mapper.addAdv(new OperateAdPO(vo));
		System.out.println(i);
	}
	@Test
	public void testudpateAdv() {
		OperateAdVO vo = new OperateAdVO();
		vo.setId((long)90);
		vo.setAdUrl("测试url");
		vo.setAdvCode("111");
		vo.setAdvTitle("测试title");
		vo.setPlatform("1");
		vo.setMenu((short)1);
		vo.setPosition((short)1);
		vo.setOnlineTime(new Date());
		vo.setOfflineTime(new Date());
		vo.setOrderId((short)1);
		vo.setCreateBy("admin");
		vo.setDefaultAd(1);
		int i = mapper.udpateAdv(new OperateAdPO(vo));
		System.out.println(i);
	}
	@Test
	public void testFindDefaultAd() {
		OperateAdVO vo = new OperateAdVO();
		vo.setDefaultAd(1);
		List<OperateAdLottoBO> list= mapper.findDefaultAd(vo);
		System.out.println(list.size());
	}
	@Test
	public void testFindMaxAdvCode() {
		String str= mapper.findMaxAdvCode("111");
		System.out.println(str);
	}
	
}
