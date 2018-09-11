
package com.hhly.cmscore.persistence.customerservice.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.customerservice.dao.MUserMessageDaoMapper;
import com.hhly.skeleton.cms.customerservice.bo.MUserMessageBO;
import com.hhly.skeleton.cms.customerservice.vo.MUserMessageVO;

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
public class MUserMessageDaoMapperTest {

	@Autowired
	MUserMessageDaoMapper mUserMessageDaoMapper;
	
	@Test
	public void testFindTotal() {
		MUserMessageVO vo = new MUserMessageVO();
		vo.setStatus((short) 1);
		int num = mUserMessageDaoMapper.findTotal(vo);
		System.out.println("num : " + num);
	}

	@Test
	public void testFind() {
		MUserMessageVO vo = new MUserMessageVO();
		vo.setStatus((short) 1);
		List<MUserMessageBO> list = mUserMessageDaoMapper.find(vo);
		for (MUserMessageBO bo : list) {
			System.out.println("code : " + bo.getCode() +" account : " + bo.getAccount());
		}
	}

}
