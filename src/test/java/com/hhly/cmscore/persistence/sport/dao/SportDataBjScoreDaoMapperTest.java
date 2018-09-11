
package com.hhly.cmscore.persistence.sport.dao;

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

import com.hhly.cmscore.persistence.sport.dao.SportDataBjScoreDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportDataBjHfWDFPO;
import com.hhly.cmscore.persistence.sport.po.SportDataBjScorePO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBjHfWDFBO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBjScoreBO;

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
public class SportDataBjScoreDaoMapperTest {

	@Autowired
	SportDataBjScoreDaoMapper sportDataBjScoreDaoMapper;
	
	@Test
	public void testFindByAgainstInfoId() {
		long id = 1l;
		List<SportDataBjScoreBO> list = sportDataBjScoreDaoMapper.findByAgainstInfoId(id);
		for (SportDataBjScoreBO bo : list) {
			System.out.println(bo.getId());
		}
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		SportDataBjScorePO po = new SportDataBjScorePO();
		po.setSportAgainstInfoId(1l);
		po.setSp00(1.0f);
		po.setSp01(1.0f);
		po.setSp02(1.0f);
		po.setSp03(1.0f);
		po.setSp04(1.0f);
		po.setSp10(1.0f);
		po.setSp11(1.0f);
		po.setSp12(1.0f);
		po.setSp13(1.0f);
		po.setSp14(1.0f);
		po.setSp20(1.0f);
		po.setSp21(1.0f);
		po.setSp22(1.0f);
		po.setSp23(1.0f);
		po.setSp24(1.0f);
		po.setSp30(1.0f);
		po.setSp31(1.0f);
		po.setSp32(1.0f);
		po.setSp33(1.0f);
		po.setSp40(1.0f);
		po.setSp41(1.0f);
		po.setSp42(1.0f);
		po.setSpWOther(1.0f);
		po.setSpDOther(1.0f);
		po.setSpFOther(1.0f);
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		sportDataBjScoreDaoMapper.insert(po);
		System.out.println(po.getId());
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportDataBjScorePO po = new SportDataBjScorePO();
		po.setSportAgainstInfoId(1l);
		po.setSp00(1.0f);
		po.setSp01(1.0f);
		po.setSp02(1.0f);
		po.setSp03(1.0f);
		po.setSp04(1.0f);
		po.setSp10(1.0f);
		po.setSp12(1.0f);
		po.setSp13(1.0f);
		po.setSp14(1.0f);
		po.setSp20(1.0f);
		po.setSp21(1.0f);
		po.setSp22(1.0f);
		po.setSp23(1.0f);
		po.setSp24(1.0f);
		po.setSp30(1.0f);
		po.setSp31(1.0f);
		po.setSp32(1.0f);
		po.setSp33(1.0f);
		po.setSp40(1.0f);
		po.setSp41(1.0f);
		po.setSp42(1.0f);
		po.setCreateTime(DateUtil.getNowDate());
		po.setReleaseTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		int num = sportDataBjScoreDaoMapper.updateByPrimaryKey(po);
		System.out.println(num);
	}

}
