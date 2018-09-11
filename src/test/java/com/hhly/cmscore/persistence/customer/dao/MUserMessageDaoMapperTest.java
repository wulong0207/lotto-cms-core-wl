package com.hhly.cmscore.persistence.customer.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hhly.cmscore.persistence.customerservice.dao.MUserMessageDaoMapper;
import com.hhly.skeleton.cms.customerservice.bo.MUserMessageBO;
import com.hhly.skeleton.cms.customerservice.vo.MUserMessageVO;

/**
 * 客服消息DAO方法测试
* @Description: 
* @author HouXiangBao289
* @date 2017年6月5日 上午10:41:27 
* @version V1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})  
//@Transactional  
//@TransactionConfiguration(transactionManager = "transactionManager")  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false) 
public class MUserMessageDaoMapperTest {
	
	@Autowired
	private MUserMessageDaoMapper mUserMessageDao;
	
	/**
	 * 
	 * @Description 根据条件查询客服消息总记录数 
	 * @author HouXiangBao289
	 */
	@Test
	public void testFindTotal(){
		MUserMessageVO vo = new MUserMessageVO();
		vo.setUserId(99);
		int sum = mUserMessageDao.findTotal(vo);
		System.out.println("【客服消息查询】：total ：" + sum);
	}
	
	/**
	 * 
	 * @Description 根据条件查询客服消息
	 * @author HouXiangBao289
	 */
	@Test
	public void testFind(){
		MUserMessageVO vo = new MUserMessageVO();
		vo.setUserId(99);
		List<MUserMessageBO> list =  mUserMessageDao.find(vo);
		System.out.println("【客服消息查询】 List size：" + list.size());
	}
	
}
