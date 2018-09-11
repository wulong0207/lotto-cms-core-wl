
package com.hhly.cmscore.persistence.dic.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.dic.dao.DicDataDetailDaoMapper;
import com.hhly.cmscore.persistence.dic.po.DicDataDetailPO;
import com.hhly.skeleton.cms.dicmgr.bo.DicDataDetailBO;
import com.hhly.skeleton.cms.dicmgr.vo.DicDataDetailVO;

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
public class DicDataDetailDaoMapperTest {
	
	@Autowired
	DicDataDetailDaoMapper dicDataDetailDaoMapper;

	@Test
	public void testFindByCode() {
		String code = "0001";
		List<DicDataDetailBO> list = dicDataDetailDaoMapper.findByCode(code);
		for (DicDataDetailBO bo : list) {
			System.out.println("dicCode : " + bo.getDicCode() + " dicName : " + bo.getDicDataName());
		}
	}

	@Test
	@Rollback(true)
	public void testDelByPrimaryKey() {
		int id = 6;
		int num = dicDataDetailDaoMapper.delByPrimaryKey(id);
		System.out.println("num : " + num);
	}

	@Test
	@Rollback(true)
	public void testUpdByPrimaryKey() {
		DicDataDetailPO po = new DicDataDetailPO();
		po.setId(6);
		po.setDicCode("123");
		po.setDicDataName("测试");
		po.setDicDataValue("4");
		po.setIsFixed((short) 1);
		po.setStatus((short) 1);
		po.setOrderBy((short) 1);
		int num = dicDataDetailDaoMapper.updByPrimaryKey(po);
		System.out.println("num : " + num);
	}

	@Test
	@Rollback(true)
	public void testAdd() {
		DicDataDetailPO po = new DicDataDetailPO();
		po.setDicCode("4");
		po.setDicDataName("测试");
		po.setDicDataValue("1");
		po.setIsFixed((short) 1);
		po.setStatus((short) 1);
		po.setOrderBy((short) 1);
		int num = dicDataDetailDaoMapper.add(po);
		System.out.println("num : " + num + " id " + po.getId());
	}

	@Test
	@Rollback(true)
	public void testDelByPrimaryKeyList() {
		List<String> ids = new ArrayList<>();
		ids.add("6");
		int num = dicDataDetailDaoMapper.delByPrimaryKeyList(ids);
		System.out.println("num : " + num);
	}

	@Test
	public void testFindSimple() {
		String code = "101";
		List<DicDataDetailBO> list = dicDataDetailDaoMapper.findSimple(code);
		for (DicDataDetailBO bo : list) {
			System.out.println("dicCode : " + bo.getDicCode() + " dicName : " + bo.getDicDataName());
		}
	}

	@Test
	public void testFindSingle() {
		DicDataDetailVO vo = new DicDataDetailVO();
		vo.setDicCode("0001");
		DicDataDetailBO bo  = dicDataDetailDaoMapper.findSingle(vo);
		System.out.println("dicCode : " + bo.getDicCode() + " dicName : " + bo.getDicDataName());
	}

	@Test
	public void testFindMultiple() {
		DicDataDetailVO vo = new DicDataDetailVO();
		vo.setDicCode("0001");
		List<DicDataDetailBO> list = dicDataDetailDaoMapper.findMultiple(vo);
		for (DicDataDetailBO bo : list) {
			System.out.println("dicCode : " + bo.getDicCode() + " dicName : " + bo.getDicDataName());
		}
	}

	@Test
	public void testGetdataDetailCode() {
		String id = "6";
		String data = dicDataDetailDaoMapper.getdataDetailCode(id);
		System.out.println("data : " + data);
	}

}
