package com.hhly.cmscore.persistence.operate.dao;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateActivityDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateActivityPO;
import com.hhly.cmscore.persistence.operate.po.OperateAdPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityExcelBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateAdLottoBO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateActivityDaoMapperTest {

	@Autowired
	private OperateActivityDaoMapper mapper;
	
	@Test
	public void testFindTotal() {
		int total = mapper.findTotal(new OperateActivityVO());
		System.out.println(total);
	}
	@Test
	public void testFindList() {
		OperateActivityVO vo = new OperateActivityVO();
		vo.setPageIndex(1);
		vo.setPageSize(10);
		List<OperateActivityBO> list = mapper.findList(vo);
		System.out.println(list.size());
	}
	@Test
	public void testUpdOperateActivity() {
		OperateActivityVO vo = new OperateActivityVO();
		vo.setActivityDes("测试");
		vo.setId(11);
		vo.setActivityCode("111");
		vo.setActivityName("name");
		vo.setActivityType((short)1);
		vo.setActivityStartTime(new Date());
		vo.setActivityEndTime(new Date());
		vo.setActivityStatus((short)1);
		vo.setChannelId("11");
		vo.setUpdateTime(new Date());
		vo.setCreateTime(new Date());
		int i = mapper.updOperateActivity(new OperateActivityPO(vo));
		System.out.println(i);
	}
	@Test
	public void testAddOperateActivity() {
		OperateActivityVO vo = new OperateActivityVO();
		vo.setActivityDes("测试");
		vo.setId(11);
		vo.setActivityCode("111");
		vo.setActivityName("name");
		vo.setActivityType((short)1);
		vo.setActivityStartTime(new Date());
		vo.setActivityEndTime(new Date());
		vo.setActivityStatus((short)1);
		vo.setChannelId("11");
		vo.setUpdateTime(new Date());
		vo.setCreateTime(new Date());
		int i = mapper.addOperateActivity(new OperateActivityPO(vo));
		System.out.println(i);
	}
	@Test
	public void testfindExcelActivity(){
		List<OperateActivityExcelBO> list = mapper.findExcelActivity(new OperateActivityVO());
		System.out.println(list.size());
	}
	@Test
	public void testfindOperateActivityDetail(){
		OperateActivityBO bo = mapper.findOperateActivityDetail(11);
		System.out.println(bo);
	}
	@Test
	public void testfindIdByActivityCode(){
		List<Integer> list = mapper.findIdByActivityCode("111");
		System.out.println(list.size());
	}
}
