
package com.hhly.cmscore.persistence.ticket.dao;

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

import com.hhly.cmscore.persistence.ticket.dao.TicketMonitorCommonDaoMapper;
import com.hhly.cmscore.persistence.ticket.po.TicketMonitorCommonPO;

/**
 * @desc    
 * @author  cheng chen
 * @date    2017年6月6日
 * @company 益彩网络科技公司
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager")
public class TicketMonitorCommonDaoMapperTest {

	@Autowired
	TicketMonitorCommonDaoMapper ticketMonitorCommonDaoMapper;
	
	@Test
	public void testList() {
		ticketMonitorCommonDaoMapper.list();
	}

	@Test
	@Rollback(true)
	public void testUpdate() {
		List<TicketMonitorCommonPO> list = new ArrayList<>();
		TicketMonitorCommonPO po = new TicketMonitorCommonPO();
		po.setId(1);
		po.setParameter(1);
		po.setModifyBy("cheng.chen");
		po.setRemark("123");
		list.add(po);
		ticketMonitorCommonDaoMapper.update(list);
	}

}
