package com.hhly.cmscore.persistence.operate.dao;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateLotteryInfoDaoMapper;
import com.hhly.skeleton.cms.operatemgr.bo.OperateLotteryInfoBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateLotteryInfoVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateLotteryBO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateLotteryDetailBO;
import com.hhly.skeleton.lotto.base.operate.vo.OperateLotteryLottVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateLotteryInfoDaoMapperTest {

	@Autowired
	private  OperateLotteryInfoDaoMapper mapper;
	
	@Test
	public void testFindTotal() {
		OperateLotteryInfoVO vo = new OperateLotteryInfoVO.Builder().build();
		int ret = mapper.findTotal(vo);
		System.out.println(ret);
	}

	@Test
	public void testList() {
		OperateLotteryInfoVO vo = new OperateLotteryInfoVO.Builder().build();
		int ret = mapper.findTotal(vo);
		List<OperateLotteryInfoBO> ret2 = mapper.list(vo);
		Assert.assertTrue(ret==ret2.size());
	}

	@Test
	public void testDelete() {
		OperateLotteryInfoVO vo = new OperateLotteryInfoVO.Builder().ids(Arrays.asList(405L,404L)).build();
		int ret = mapper.delete(vo);
		System.out.println(ret);
	}

	@Test
	public void testFindPCHomeOperLottery() {
		OperateLotteryLottVO vo = new OperateLotteryLottVO();
		List<OperateLotteryBO> ret = mapper.findPCHomeOperLottery(vo);
		System.out.println(ret);
	}

}
