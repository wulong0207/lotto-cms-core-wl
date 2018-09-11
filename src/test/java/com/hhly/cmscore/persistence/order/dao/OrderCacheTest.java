
package com.hhly.cmscore.persistence.order.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hhly.persistence.util.RedisUtil;
import com.hhly.skeleton.base.constants.CacheConstants;
import com.hhly.skeleton.base.constants.SymbolConstants;

/**
 * @desc 彩种测试
 * @author huangb
 * @date 2017年6月6日
 * @company 益彩网络
 * @version v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) 
public class OrderCacheTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	RedisUtil redisUtil;

	@Test
	public void testAdd() {
		redisUtil.delKeys(CacheConstants.S_COMM_ORDER_NO_PAY_COUNT + SymbolConstants.STAR + SymbolConstants.UNDERLINE +300);
	}
	
}
