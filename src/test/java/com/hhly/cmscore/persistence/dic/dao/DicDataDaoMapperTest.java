
package com.hhly.cmscore.persistence.dic.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.dic.dao.DicDataDaoMapper;
import com.hhly.cmscore.persistence.dic.po.DicDataPO;
import com.hhly.skeleton.cms.dicmgr.bo.DicDataBO;
import com.hhly.skeleton.cms.dicmgr.vo.DicDataVO;

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
public class DicDataDaoMapperTest {

	@Autowired
	DicDataDaoMapper dicDataDaoMapper;
	
	@Test
	public void testFind() {
		DicDataVO vo = new DicDataVO();
		vo.setDicCode("0001");
		List<DicDataBO> list = dicDataDaoMapper.find(vo);
		for (DicDataBO bo : list) {
			System.out.println("code : " + bo.getDicCode() + " name : " + bo.getDicName());
		}
	}

	@Test
	public void testFindTotal() {
		DicDataVO vo = new DicDataVO();
		vo.setDicCode("0001");
		int num = dicDataDaoMapper.findTotal(vo);
		System.out.println("num : " + num);
	}

	@Test
	@Rollback(true)
	public void testAdd() {
		DicDataPO po = new DicDataPO();
		po.setDicCode("4");
		po.setDicName("测试");
		po.setRemark("fds");
		int num = dicDataDaoMapper.add(po);
		System.out.println("num : " + num);
	}

	@Test
	@Rollback(true)
	public void testUpdByPrimaryKey() {
		DicDataPO po = new DicDataPO();
		po.setDicCode("4");
		po.setDicName("测试");
		po.setRemark("fds");
		int num = dicDataDaoMapper.updByPrimaryKey(po);
		System.out.println("num : " + num);
	}

}
