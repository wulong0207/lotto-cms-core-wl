
package com.hhly.cmscore.persistence.customer.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.customer.dao.UserWinningStatisticsDaoMapper;
import com.hhly.skeleton.cms.customermgr.bo.UserWinningStatisticsBO;
import com.hhly.skeleton.cms.customermgr.bo.UserWinningStatisticsExcelBO;
import com.hhly.skeleton.cms.customermgr.vo.UserWinningStatisticsVO;

/**
 * @desc    
 * @author  cheng chen
 * @date    2017年6月5日
 * @company 益彩网络科技公司
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager") 
public class UserWinningStatisticsDaoMapperTest {

	@Autowired
	UserWinningStatisticsDaoMapper userWinningStatisticsDaoMapper;
	
	@Test
	public void testFindTotal() {
		UserWinningStatisticsVO vo = new UserWinningStatisticsVO();
		vo.setPageIndex(0);
		vo.setPageSize(10);
		int num = userWinningStatisticsDaoMapper.findTotal(vo);
		System.out.println("num : " + num);
	}

	@Test
	public void testFind() {
		UserWinningStatisticsVO vo = new UserWinningStatisticsVO();
		vo.setPageIndex(0);
		vo.setPageSize(10);
		List<UserWinningStatisticsBO> list = userWinningStatisticsDaoMapper.find(vo);
		for (UserWinningStatisticsBO bo : list) {
			System.out.println("LotteryName : " + bo.getLotteryName() + " nickName : " + bo.getNickName());
		}
	}

	@Test
	public void testFindUserWinningStatisticsExcel() {
		UserWinningStatisticsVO vo = new UserWinningStatisticsVO();
		vo.setPageIndex(0);
		vo.setPageSize(10);
		List<UserWinningStatisticsExcelBO> list = userWinningStatisticsDaoMapper.
				findUserWinningStatisticsExcel(vo);
		for (UserWinningStatisticsExcelBO bo : list) {
			System.out.println("id : " + bo.getId() + " LotteryName : " + bo.getLotteryName());
		}
	}
}
