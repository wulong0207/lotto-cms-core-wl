package com.hhly.cmscore.persistence.operate.dao;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.cms.remote.service.IOperateMgrService;
import com.hhly.cmscore.persistence.operate.po.OperateCouponPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateCouponBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateCouponExcelBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateCouponVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateCouponDaoMapperTest {

	@Autowired
	private OperateCouponDaoMapper mapper;
	@Autowired
	private IOperateMgrService iOperateMgrService;
		
	@Test
	public void testfindTotal() {
		int total = mapper.findTotal(new OperateCouponVO());
		System.out.println(total);
	}
	@Test
	public void testfindList() {
		List<OperateCouponBO> list = mapper.findList(new OperateCouponVO());
		System.out.println(list.size());
	}
	@Test
	public void testfindCouponDetail() {
		OperateCouponBO operateCouponBO = mapper.findCouponDetail("xxx");
		System.out.println(operateCouponBO);
	}
	@Test
	public void testfindExcelCoupon() {
		List<OperateCouponExcelBO> list = mapper.findExcelCoupon(new OperateCouponVO());
		System.out.println(list.size());
	}
	@Test
	public void testupdCouponStatus() {
		OperateCouponVO vo = new OperateCouponVO();
		vo.setId(1);
		vo.setRedCode("xx1");
		vo.setRedCategory((short)1);
		vo.setOperateLotteryId("12");
		vo.setRedOverdueTime(new Date());
		vo.setRedType((short)1);
		vo.setRedName("11");
		vo.setRedValue(1d);
		vo.setRedBalance(1d);
		vo.setEctivityDay((short)1);
		vo.setUpdateTime(new Date());
		vo.setCreateTime(new Date());
		int i = mapper.updCouponStatus(new OperateCouponPO(vo));
		System.out.println(1);
	}
}
