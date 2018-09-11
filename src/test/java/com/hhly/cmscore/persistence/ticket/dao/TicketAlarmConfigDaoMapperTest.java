
package com.hhly.cmscore.persistence.ticket.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.ticket.dao.TicketAlarmConfigDaoMapper;
import com.hhly.cmscore.persistence.ticket.po.TicketAlarmConfigPO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketAlarmConfigVO;

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
public class TicketAlarmConfigDaoMapperTest {

	@Autowired
	TicketAlarmConfigDaoMapper ticketAlarmConfigDaoMapper;
	
	@Test
	public void testCountPage() {
		TicketAlarmConfigVO vo = new TicketAlarmConfigVO();
		vo.setStatus((short)1);
		ticketAlarmConfigDaoMapper.countPage(vo);
	}

	@Test
	public void testListPage() {
		TicketAlarmConfigVO vo = new TicketAlarmConfigVO();
		vo.setStatus((short)1);
		vo.setPageIndex(0);
		vo.setPageSize(10);
		ticketAlarmConfigDaoMapper.listPage(vo);
	}

	@Test
	@Rollback(true)
	public void testUpdate() {
		TicketAlarmConfigPO po = new TicketAlarmConfigPO();
		po.setId(1);
		po.setAlarmType((short)1);
		po.setAlarmChild((short)2);
		po.setStatus((short)2);
		po.setAlarmLevel((short)1);
		po.setParameter(1l);
		po.setFormat("123");
		po.setCreateBy("cheng.chen");
		po.setModifyBy("cheng.chen");
		ticketAlarmConfigDaoMapper.update(po);
	}

	@Test
	@Rollback(true)
	public void testAdd() {
		TicketAlarmConfigPO po = new TicketAlarmConfigPO();
		po.setAlarmType((short)1);
		po.setAlarmChild((short)2);
		po.setStatus((short)2);
		po.setAlarmLevel((short)1);
		po.setParameter(1l);
		po.setFormat("123");
		po.setCreateBy("cheng.chen");
		po.setModifyBy("cheng.chen");
		ticketAlarmConfigDaoMapper.add(po);
	}

}
