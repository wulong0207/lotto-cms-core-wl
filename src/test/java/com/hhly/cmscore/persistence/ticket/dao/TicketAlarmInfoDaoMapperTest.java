
package com.hhly.cmscore.persistence.ticket.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

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
public class TicketAlarmInfoDaoMapperTest {

	@Test
	public void testCountPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testListPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdTicketAlarmInfoStatus() {
		fail("Not yet implemented");
	}

}
