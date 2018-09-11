package com.hhly.cmscore.persistence.operate.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateMarketChannelDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateMarketChannelPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMarketChannelBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMarketChannelExcelBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMarketChannelVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateMarketChannelDaoMapperTest {

	@Autowired
	private OperateMarketChannelDaoMapper mapper;
	
	@Test
	public void testFindAllSimple() {
		List<OperateMarketChannelBO> ret = mapper.findAllSimple();
		System.out.println(ret);
	}

	@Test
	public void testFindTotal() {
		OperateMarketChannelVO vo = new OperateMarketChannelVO();
		int ret = mapper.findTotal(vo);
		System.out.println(ret);
	}

	@Test
	public void testFindList() {
		OperateMarketChannelVO vo = new OperateMarketChannelVO();
		List<OperateMarketChannelBO> ret = mapper.findList(vo);
		System.out.println(ret);
	}

	@Test
	public void testFindParentId() {
		List<String> ret = mapper.findParentId("1");
		System.out.println(ret);
	}

	@Test
	public void testUpdOperateMarketChannel() {
		OperateMarketChannelPO po = new OperateMarketChannelPO();
		po.setChannelId("333");
		po.setChannelName("channelV");
		po.setTerminalPlatform((short)1);
		po.setParentChannelId("asdfasdf");
		po.setGrade((short)2);
		po.setSettlementType((short)1);
		po.setResourceUrl("http://ll");
		po.setSettlementRate(2.2);
		po.setCoopEndTime(new Date());
		po.setCoopStartTime(new Date());
		po.setChannelStatus((short)1);
		po.setId(5);
		int ret = mapper.updOperateMarketChannel(po);
		System.out.println(ret);
	}

	@Test
	public void testAddOperateMarketChannel() {
		OperateMarketChannelPO po = new OperateMarketChannelPO();
		po.setChannelId("333");
		po.setChannelName("channelV");
		po.setTerminalPlatform((short)1);
		po.setParentChannelId("asdfasdf");
		po.setGrade((short)2);
		po.setSettlementType((short)1);
		po.setResourceUrl("http://ll");
		po.setSettlementRate(2.2);
		po.setCoopEndTime(new Date());
		po.setCoopStartTime(new Date());
		po.setChannelStatus((short)1);
		int ret = mapper.addOperateMarketChannel(po);
		System.out.println(ret);
	}

	@Test
	public void testFindIdByChannelId() {
		List<Integer> ret = mapper.findIdByChannelId("1");
		System.out.println(ret);
	}

	@Test
	public void testFindExcelMarketChannel() {
		OperateMarketChannelVO vo = new OperateMarketChannelVO();
		List<OperateMarketChannelExcelBO> ret = mapper.findExcelMarketChannel(vo);
		System.out.println(ret);
	}

}
