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

import com.hhly.cmscore.persistence.operate.dao.OperateAdMenuDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateAdMenuPO;
import com.hhly.cmscore.persistence.operate.po.OperateAdPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdMenuBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdMenuVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateAdLottoBO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateAdMenuDaoMapperTest {

	@Autowired
	private OperateAdMenuDaoMapper mapper;
	
	@Test
	public void testcount() {
		int total = mapper.count(new OperateAdMenuVO());
		System.out.println(total);
	}
	@Test
	public void testList() {
		List<OperateAdMenuBO> list = mapper.list(new OperateAdMenuVO());
		System.out.println(list.size());
	}
	@Test
	public void testmerge() {
		OperateAdMenuVO vo = new OperateAdMenuVO();
		vo.setId((long)90);
		vo.setCreateBy("admin");
		vo.setMenu(1);
		vo.setPosition(""+1);
		int i = mapper.merge(new OperateAdMenuPO(vo));
		System.out.println(i);
	}
	@Test
	public void testdelete() {
		OperateAdMenuVO vo = new OperateAdMenuVO();
		vo.setId((long)90);
		List<Integer> ids= new ArrayList<Integer>();
		ids.add(11);
		vo.setIds(ids);
		vo.setCreateBy("admin");
		vo.setMenu(1);
		vo.setPosition(""+1);
		int i = mapper.delete(vo);
		System.out.println(i);
	}
}
