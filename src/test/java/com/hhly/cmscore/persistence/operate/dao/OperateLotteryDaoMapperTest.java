package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateLotteryDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateLotteryPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateLotteryBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateLotteryVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateLotteryDaoMapperTest {

	@Autowired
	private OperateLotteryDaoMapper mapper;
	
	@Test
	public void testFindTotal() {
		OperateLotteryVO vo = new OperateLotteryVO.Builder().build();
		int ret = mapper.findTotal(vo);
		System.out.println(ret);
	}

	@Test
	public void testList() {
		OperateLotteryVO vo = new OperateLotteryVO.Builder().build();
		int ret = mapper.findTotal(vo);
		List<OperateLotteryBO> ret2 = mapper.list(vo);
		Assert.assertTrue(ret==ret2.size());
	}

	@Test
	public void testMergeOperateLotteryInfo() {
//		OperateLotteryVO vo = new OperateLotteryVO.Builder()
//				.id(1L)
//				.platform((byte)1)
//				.status((byte)1)
//				.build();
//		List<OperateLotteryInfoVO> lotteryInfos = new ArrayList<>();
//		OperateLotteryInfoVO info = new OperateLotteryInfoVO.Builder().ids(Arrays.asList(1L,2L)).build();
//		lotteryInfos.add(info);
//		vo.setLotteryInfos(lotteryInfos);
//		OperateLotteryPO po = new OperateLotteryPO(vo);
//		int ret = mapper.mergeOperateLotteryInfo(po);
//		System.out.println(ret);
	}

	@Test
	public void testAddOperateLottery() {
//		OperateLotteryVO vo = new OperateLotteryVO.Builder()
//		.id(1L)
//		.platform((byte)1)
//		.status((byte)1)
//		.build();
//		OperateLotteryPO po = new OperateLotteryPO(vo);
//		int ret = mapper.addOperateLottery(po);
//		System.out.println(ret);
	}

	@Test
	public void testUpdateOperateLottery() {
		OperateLotteryVO vo = new OperateLotteryVO.Builder()
		.id(1L)
		.platform((byte)1)
		.status((byte)1)
		.build();
		OperateLotteryPO po = new OperateLotteryPO(vo);
		int ret = mapper.updateOperateLottery(po);
		System.out.println(ret);
	}

	@Test
	public void testFindMaxReleaseCode() {
		String ret = mapper.findMaxReleaseCode("2017");
		System.out.println(ret);
	}

	@Test
	public void testFindTimeRepeatTotal() {
		OperateLotteryVO vo = new OperateLotteryVO.Builder().build();
		int ret = mapper.findTimeRepeatTotal(vo);
		System.out.println(ret);
	}
}
