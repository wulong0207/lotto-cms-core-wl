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

import com.hhly.cmscore.persistence.operate.dao.OperateFastDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateAdMenuPO;
import com.hhly.cmscore.persistence.operate.po.OperateAdPO;
import com.hhly.cmscore.persistence.operate.po.OperateAdTypePO;
import com.hhly.cmscore.persistence.operate.po.OperateFastPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdMenuBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdTypeBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateFastBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdMenuVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdTypeVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateCouponVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateFastInfoVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateFastInfoVO.Builder;
import com.hhly.skeleton.cms.operatemgr.vo.OperateFastVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateAdLottoBO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateFastDaoMapperTest {

	@Autowired
	private OperateFastDaoMapper mapper;
	
	@Test
	public void testfindTotal() {
		int total = mapper.findTotal(new OperateFastVO());
		System.out.println(total);
	}
	@Test
	public void testList() {
		List<OperateFastBO> list = mapper.list(new OperateFastVO());
		System.out.println(list.size());
	}
	@Test
	public void testmergeOperateFastInfo() {
		OperateFastVO vo = new OperateFastVO();
		vo.setId((long)11);
		vo.setFastCode("11");
		vo.setPlatform((short)1);
		vo.setPosition((short)1);
		vo.setStatus((short)1);
		vo.setOnlineTime("xx");
		vo.setOfflineTime("xx");
		vo.setCreateBy("xx");
		vo.setModifyBy("xx");
		List<OperateFastInfoVO> list  =new ArrayList<OperateFastInfoVO>();
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(2l);
		Builder bu = new Builder();
		bu.ids(ids);
		OperateFastInfoVO fastVo = new OperateFastInfoVO(bu);
		fastVo.setTypeId(1);
		fastVo.setFastId((long)1);
		fastVo.setCategoryId((byte)1);
		fastVo.setMultiple(1);
		list.add(fastVo);
		vo.setFastInfos(list);
		
		int i = mapper.mergeOperateFastInfo(new OperateFastPO(vo));
		System.out.println(i);
	}
	@Test
	public void testaddOperateFast() {
		OperateFastVO vo = new OperateFastVO();
		vo.setId((long)11);
		vo.setFastCode("11");
		vo.setPlatform((short)1);
		vo.setPosition((short)1);
		vo.setStatus((short)1);
		vo.setOnlineTime("xx");
		vo.setOfflineTime("xx");
		vo.setCreateBy("xx");
		vo.setModifyBy("xx");
		int i = mapper.addOperateFast(new OperateFastPO(vo));
		System.out.println(i);
	}
	@Test
	public void testupdateOperateFast() {
		OperateFastVO vo = new OperateFastVO();
		vo.setId((long)11);
		vo.setFastCode("11");
		vo.setPlatform((short)1);
		vo.setPosition((short)1);
		vo.setStatus((short)1);
		vo.setOnlineTime("xx");
		vo.setOfflineTime("xx");
		vo.setCreateBy("xx");
		vo.setModifyBy("xx");
		int i = mapper.updateOperateFast(new OperateFastPO(vo));
		System.out.println(i);
	}
	@Test
	public void testfindTimeRepeatTotal() {
		OperateFastVO vo = new OperateFastVO();
		vo.setId((long)11);
		vo.setFastCode("11");
		vo.setPlatform((short)1);
		vo.setPosition((short)1);
		vo.setStatus((short)1);
		vo.setOnlineTime("xx");
		vo.setOfflineTime("xx");
		vo.setCreateBy("xx");
		vo.setModifyBy("xx");
		int i = mapper.findTimeRepeatTotal(vo);
		System.out.println(i);
	}
}
