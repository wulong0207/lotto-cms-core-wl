
package com.hhly.cmscore.persistence.customer.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.customer.dao.UserWalletDaoMapper;
import com.hhly.skeleton.cms.customermgr.bo.UserWalletBO;
import com.hhly.skeleton.cms.customermgr.vo.UserWalletVO;

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
public class UserWalletDaoMapperTest {

	@Autowired
	UserWalletDaoMapper userWalletDaoMapper;
	
	@Test
	public void testFindPaging() {
		UserWalletVO vo = new UserWalletVO();
		vo.setId(1l);
		vo.setPageIndex(0);
		vo.setPageSize(10);
		List<UserWalletBO> list = userWalletDaoMapper.findPaging(vo);
		for (UserWalletBO bo : list) {
			System.out.println("20 : " + bo.getTop20Balance() + "80 : " + bo.getTop80Balance());
		}
	}

	@Test
	public void testFindCount() {
		UserWalletVO vo = new UserWalletVO();
		vo.setId(1l);
		Map<String, Object> map = userWalletDaoMapper.findCount(vo);
		
		for (String key : map.keySet()) {
			System.out.println("key : " + key + "value : " + map.get(key));
		}
	}

	@Test
	@Rollback(true)
	public void testUpdWalletStatusByIds() {
		List<String> ids = new ArrayList<>();
		ids.add("1");
		short status = 0;
		int num = userWalletDaoMapper.updWalletStatusByIds(ids, status);
		System.out.println("num : " + num);
	}

	@Test
	public void testFindExcel() {
		UserWalletVO vo = new UserWalletVO();
		vo.setStatus((short)1);
		List<UserWalletBO> list = userWalletDaoMapper.findExcel(vo);
		for (UserWalletBO bo : list) {
			System.out.println("20 : " + bo.getTop20Balance() + "80 : " + bo.getTop80Balance());
		}
	}

}
