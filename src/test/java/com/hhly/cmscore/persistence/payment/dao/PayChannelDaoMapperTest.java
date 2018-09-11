
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

import com.hhly.cmscore.persistence.payment.dao.PayChannelDaoMapper;
import com.hhly.cmscore.persistence.payment.po.PayChannelPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.payment.bo.PayChannelBO;
import com.hhly.skeleton.cms.payment.vo.PayChannelVO;

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
public class PayChannelDaoMapperTest {

	@Autowired
	PayChannelDaoMapper payChannelDaoMapper;
	
	@Test
	public void testFind() {
		int bankId = 1;
		short type = 1;
		PayChannelVO vo = new PayChannelVO();
		vo.setBankid(bankId);
		vo.setType(type);
		List<PayChannelBO> list = payChannelDaoMapper.find(vo);
		for (PayChannelBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	@Rollback(true)
	public void testSaveList() {
		List<PayChannelPO> list = new ArrayList<>();
		PayChannelPO po = new PayChannelPO();
		po.setName("测试");
		po.setBankid(1);
		po.setType((short)1);
		po.setCardtype(1);
		po.setAvailable((short)1);
		po.setPause((short)1);
		po.setBegintime(DateUtil.convertStrToDate("2017-08-01"));
		po.setEndtime(DateUtil.convertStrToDate("2017-08-31"));
		po.setCreateBy("cheng.chen");
		po.setCode("123");
		list.add(po);
		int num = payChannelDaoMapper.saveList(list);
		System.out.println(num);
	}

	@Test
	@Rollback(true)
	public void testUpdateList() {
		List<PayChannelPO> list = new ArrayList<>();
		PayChannelPO po = new PayChannelPO();
		po.setId(1);
		po.setName("测试");
		po.setBankid(1);
		po.setType((short)1);
		po.setCardtype(1);
		po.setAvailable((short)1);
		po.setPause((short)1);
		po.setBegintime(DateUtil.convertStrToDate("2017-08-01"));
		po.setEndtime(DateUtil.convertStrToDate("2017-08-31"));
		po.setModifyBy("cheng.chen");
		po.setCode("123");
		list.add(po);
		int num = payChannelDaoMapper.updateList(list);
		System.out.println(num);
	}

}
