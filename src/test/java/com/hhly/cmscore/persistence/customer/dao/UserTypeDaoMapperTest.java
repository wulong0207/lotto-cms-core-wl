
package com.hhly.cmscore.persistence.customer.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.customer.dao.UserTypeDaoMapper;
import com.hhly.cmscore.persistence.customer.po.UserTypePO;
import com.hhly.skeleton.cms.customermgr.bo.UserTypeBO;
import com.hhly.skeleton.cms.customermgr.bo.UserTypeExcelBO;
import com.hhly.skeleton.cms.customermgr.vo.UserTypeVO;

/**
 * @desc    
 * @author  cheng chen
 * @date    2017年6月1日
 * @company 益彩网络科技公司
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager") 
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
public class UserTypeDaoMapperTest {
	
	@Resource
	private UserTypeDaoMapper UserTypeDaoMapper;

	@Test
	@Rollback(true)
//	@Transactional
	public void testInsert() {
		try {
			UserTypePO po = new UserTypePO();
			po.setCode("2010");
			po.setName("名称");
			po.setDescribe("名称");
			po.setRemark("名称");
			po.setCreateBy("cheng.chen");
			po.setModifyTime(new Date());
//			po.setCreateTime(new Date());
			int num = UserTypeDaoMapper.insert(po);
			System.out.println("num : " + num + " id : " + po.getId());			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Rollback(true)
	public void testDeleteByIds() {
		List<String> ids = new ArrayList<>();
		ids.add("36");
		int num = UserTypeDaoMapper.deleteByIds(ids);
		System.out.println("num : " + num);			
	}

	@Test
	public void testFind() {
		UserTypeVO vo = new UserTypeVO();
		vo.setCode("1000");
		List<UserTypeBO> list = UserTypeDaoMapper.find(vo);
		for (UserTypeBO bo : list) {
			System.out.println("id : " + bo.getId());
		}
	}

	@Test
	public void testFindTotal() {
		UserTypeVO vo = new UserTypeVO();
		vo.setCode("1000");
		int num = UserTypeDaoMapper.findTotal(vo);
		System.out.println("num : " + num);		
	}

	@Test
	@Rollback(true)
	public void testUpdateById() {
		UserTypePO po = new UserTypePO();
		po.setId(36);
		po.setRemark("fds");
		int num = UserTypeDaoMapper.updateById(po);
		System.out.println("num : " + num);		
	}

	@Test
	public void testFindBaseUserType() {
		List<UserTypeBO> list = UserTypeDaoMapper.findBaseUserType();
		for (UserTypeBO bo : list) {
			System.out.println("name : " + bo.getName());
		}
	}

	@Test
	public void testFindExcelByTypeId() {
		Integer typeId = 1000;
		List<UserTypeExcelBO> list = UserTypeDaoMapper.findExcelByTypeId(typeId);
		for (UserTypeExcelBO bo : list) {
			System.out.println("userId : " + bo.getUserId());
		}
	}

	@Test
	public void testValiUserTypeCode() {
		String code = "1000";
		int num = UserTypeDaoMapper.valiUserTypeCode(code);
		System.out.println("num : " + num);		
	}

	@Test
	public void testAddTypeToUser() {
		Map<String, String> param = new HashMap<>();
		param.put("typeCode", "1000");
		boolean flag = UserTypeDaoMapper.addTypeToUser(param);
		System.out.println("flag : " + flag);
	}

	
}
