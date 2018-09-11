package com.hhly.cmscore.persistence.trend.high.dao;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.trend.high.dao.K3DaoMapper;
import com.hhly.skeleton.lotto.base.trend.high.bo.HighOmitBaseBO;
import com.hhly.skeleton.lotto.base.trend.vo.high.HighLotteryVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class Jsk3OmitDaoMapperTest {

	@Autowired
	private K3DaoMapper mapper;
	
	@Test
	public void testFindOmitRecent() {
		HighLotteryVO vo = new HighLotteryVO();
		vo.setLotteryCode(233);
		vo.setQryCount(10);
		List<HighOmitBaseBO> ret = mapper.findRecentOmit(vo);
		System.out.println(ret);
	}

	@Test
	public void testFindOmitResult() {
		HighLotteryVO vo = new HighLotteryVO();
		vo.setLotteryCode(233);
		vo.setOmitTypes(Arrays.asList(1,2,3));
		List<HighOmitBaseBO> ret = mapper.findResultOmit(vo);
		System.out.println(ret);
	}

}
