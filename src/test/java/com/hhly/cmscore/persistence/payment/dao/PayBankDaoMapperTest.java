
package com.hhly.cmscore.persistence.payment.dao;

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

import com.hhly.cmscore.persistence.payment.dao.PayBankDaoMapper;
import com.hhly.cmscore.persistence.payment.po.PayBankPO;
import com.hhly.skeleton.cms.payment.bo.PayBankBO;
import com.hhly.skeleton.cms.payment.vo.PayBankVO;

/**
 * @desc    
 * @author  cheng chen
 * @date    2017年6月2日
 * @company 益彩网络科技公司
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager") 
public class PayBankDaoMapperTest {
	
	@Autowired
	private PayBankDaoMapper payBankDaoMapper;

	@Test
	@Rollback(true)
	public void testAdd() {
		PayBankPO po = new PayBankPO();
		po.setName("测试银行");
		po.setCname("测试银行2");
		po.setStatus((short)1);
		po.setPaytype((short)1);
		po.setBlogo("http://test.13322.com");
		po.setSlogo("http://test.13322.com");
		po.setRemark("测试");
		po.setCreateBy("cheng.chen");
		int num = payBankDaoMapper.add(po);
		
		System.out.println("num : " + num + " id : " + po.getId());		
	}
	
	@Test
	public void testFind() {
		String sortType = "1";
		PayBankVO vo = new PayBankVO();
		vo.setSortType(sortType);
		 List<PayBankBO> list = payBankDaoMapper.find(vo);
		 for (PayBankBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	public void testFindById() {
		Integer id = 1;
		PayBankBO bo = payBankDaoMapper.findById(id);
		System.out.println(bo.getId());
	}

	@Test
	@Rollback(true)
	public void testUpdateById() {
		PayBankPO po = new PayBankPO();
		po.setId(1);
		po.setRemark("测试");
		int num = payBankDaoMapper.updateById(po);
		System.out.println(num);
	}

	@Test
	@Rollback(true)
	public void testUpdateList() {
		List<PayBankPO> list = new ArrayList<>();
		PayBankPO po = new PayBankPO();
		po.setId(1);
		po.setRemark("测试");
		list.add(po);
		int num = payBankDaoMapper.updateList(list);
		System.out.println(num);
	}
	
	
}
