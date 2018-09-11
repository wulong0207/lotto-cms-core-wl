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

import com.hhly.cmscore.persistence.operate.dao.OperateFastInfoDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateAdMenuPO;
import com.hhly.cmscore.persistence.operate.po.OperateAdPO;
import com.hhly.cmscore.persistence.operate.po.OperateAdTypePO;
import com.hhly.cmscore.persistence.operate.po.OperateFastPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdMenuBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdTypeBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateFastBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateFastInfoBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdMenuVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdTypeVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateCouponVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateFastInfoVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateFastInfoVO.Builder;
import com.hhly.skeleton.cms.operatemgr.vo.OperateFastVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateAdLottoBO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateFastLottBO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateFastInfoDaoMapperTest {

	@Autowired
	private OperateFastInfoDaoMapper mapper;
	
	@Test
	public void testfindTotal() {
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(2l);
		Builder bu = new Builder();
		bu.ids(ids);
		int total = mapper.findTotal(new OperateFastInfoVO(bu));
		System.out.println(total);
	}
	@Test
	public void testList() {
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(2l);
		Builder bu = new Builder();
		bu.ids(ids);
		List<OperateFastInfoBO> list = mapper.list(new OperateFastInfoVO(bu));
		System.out.println(list.size());
	}
	@Test
	public void testdelete() {
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(2l);
		Builder bu = new Builder();
		bu.ids(ids);
		int i = mapper.delete(new OperateFastInfoVO(bu));
		System.out.println(i);
	}
	

	@Test
	public void testfindOperFastInfo() {
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
		
		List<com.hhly.skeleton.lotto.base.operate.bo.OperateFastBO> listBO = mapper.findOperFastInfo(vo);
		System.out.println(listBO.size());
	}
}
