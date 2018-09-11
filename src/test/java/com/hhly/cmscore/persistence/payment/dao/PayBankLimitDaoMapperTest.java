
package com.hhly.cmscore.persistence.payment.dao;

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

import com.hhly.cmscore.persistence.payment.dao.PayBankLimitDaoMapper;
import com.hhly.cmscore.persistence.payment.po.PayBankLimitPO;
import com.hhly.skeleton.cms.payment.bo.PayBankLimitBO;


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
public class PayBankLimitDaoMapperTest {

	@Autowired
	PayBankLimitDaoMapper payBankLimitDaoMapper;
	
	@Test
	public void testFind() {
		int bankId = 1;
		List<PayBankLimitBO> list = payBankLimitDaoMapper.find(bankId);
		for (PayBankLimitBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	@Rollback(true)
	public void testSaveList() {
		List<PayBankLimitPO> list = new ArrayList<>();
		PayBankLimitPO po = new PayBankLimitPO();
		po.setBankid(1);
		po.setCardType(1);
		po.setCondition("测试");
		po.setLimitday("测试");
		po.setLimitmonth("测试");
		po.setLimittime("测试");
		po.setRemark("测试");
		list.add(po);
		int num = payBankLimitDaoMapper.saveList(list);
		System.out.println(num);
	}

	@Test
	@Rollback(true)
	public void testUpdateList() {
		List<PayBankLimitPO> list = new ArrayList<>();
		PayBankLimitPO po = new PayBankLimitPO();
		po.setBankid(1);
		po.setCardType(1);
		po.setCondition("测试");
		po.setLimitday("测试");
		po.setLimitmonth("测试");
		po.setLimittime("测试");
		po.setRemark("测试");
		list.add(po);
		int num = payBankLimitDaoMapper.updateList(list);
		System.out.println(num);
	}

}
