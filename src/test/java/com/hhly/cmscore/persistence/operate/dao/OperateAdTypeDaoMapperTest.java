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

import com.hhly.cmscore.persistence.operate.dao.OperateAdTypeDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateAdMenuPO;
import com.hhly.cmscore.persistence.operate.po.OperateAdPO;
import com.hhly.cmscore.persistence.operate.po.OperateAdTypePO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdMenuBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdTypeBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdMenuVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdTypeVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateAdLottoBO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateAdTypeDaoMapperTest {

	@Autowired
	private OperateAdTypeDaoMapper mapper;
	
	@Test
	public void testbatchAdd() {
		List<OperateAdTypePO> pos = new ArrayList<OperateAdTypePO>();
		OperateAdTypePO po1 = new OperateAdTypePO((long)1,(long)1,"1");
		OperateAdTypePO po2 = new OperateAdTypePO((long)2,(long)2,"2");
		pos.add(po1);
		pos.add(po2);
		int total = mapper.batchAdd(pos);
		System.out.println(total);
	}
	@Test
	public void testList() {
		List<OperateAdTypeBO> list = mapper.list(new OperateAdTypeVO());
		System.out.println(list.size());
	}
	@Test
	public void testdelete() {
		OperateAdTypeVO vo = new OperateAdTypeVO();
		vo.setId((long)90);
		List<Integer> ids= new ArrayList<Integer>();
		ids.add(11);
		int i = mapper.delete(vo);
		System.out.println(i);
	}
}
