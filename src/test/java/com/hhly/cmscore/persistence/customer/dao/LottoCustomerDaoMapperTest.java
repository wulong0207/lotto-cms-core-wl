
package com.hhly.cmscore.persistence.customer.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.customer.dao.LottoCustomerDaoMapper;
import com.hhly.cmscore.persistence.customer.po.LottoCustomerPO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerBO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerExcelBO;
import com.hhly.skeleton.cms.customermgr.vo.LottoCustomerVO;

/**
 * @desc    
 * @author  cheng chen
 * @date    2017年6月2日
 * @company 益彩网络科技公司
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})  
//@Transactional  
//@TransactionConfiguration(transactionManager = "transactionManager")  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false) 
public class LottoCustomerDaoMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	LottoCustomerDaoMapper lottoCustomerDaoMapper;

	@Test
	public  void testFind() {
		LottoCustomerVO vo  = new LottoCustomerVO();
		vo.setAccountName("邮箱623749");
		List<LottoCustomerBO> list = lottoCustomerDaoMapper.find(vo);
		System.out.println("id : " + list.get(0).getId());
	}

	@Test
	public  void testFindTotal() {
		LottoCustomerVO vo  = new LottoCustomerVO();
//		vo.setAccountName("邮箱623749");
		vo.setEmailLogin((short)1);
		int num = lottoCustomerDaoMapper.findTotal(vo);
		System.out.println("num : " + num);
	}

	@Test
	public  void testFindLottoCustomerExcel() {
		LottoCustomerVO vo  = new LottoCustomerVO();
		vo.setEmailLogin((short)1);
		List<LottoCustomerExcelBO> list = lottoCustomerDaoMapper.findLottoCustomerExcel(vo);
		
		System.out.println("size : " + list.size());
		
		for (int i = 0; i < 10; i++) {
			System.out.println("id : " + list.get(i).getId());
		}
	}

	@Test
	public  void testFindLottoCustomerDetail() {
		String id = "1";
		LottoCustomerBO BO = lottoCustomerDaoMapper.findLottoCustomerDetail(id);
		System.out.println("accountName : " + BO.getAccountName() + " password : " + BO.getAccountPassword());
	}

	@Test
	public  void testUpdateByCms() {
		String id = "1";
		LottoCustomerBO BO = lottoCustomerDaoMapper.findLottoCustomerDetail(id);
		LottoCustomerPO po = new LottoCustomerPO();
		po.setId(BO.getId());
		po.setAccountId(BO.getAccountId());
		po.setAccountName(BO.getAccountName());
		po.setCusMobile(BO.getCusMobile());
		po.setCusMail(BO.getCusMail());
		po.setNickName("东南西北");
		po.setSex(BO.getSex());
		po.setActualName(BO.getActualName());
		po.setIdNum(BO.getIdNum());
		po.setHeadUrl(BO.getHeadUrl());
		po.setHeadStatus(BO.getHeadStatus());
		po.setAddress(BO.getAddress());
		po.setModifyBy("test");
		po.setMobileLogin(BO.getMobileLogin());
		po.setEmailLogin(BO.getEmailLogin());
		po.setRemark(BO.getRemark());
		int num = lottoCustomerDaoMapper.updateByCms(po);
		System.out.println("num : " + num);
	}

	@Test
	public  void testUpdateMsgConfig() {
		LottoCustomerPO po = new LottoCustomerPO();
		po.setId(1);
		po.setMsgMob(null);
//		po.setMsgSite(msgSite);
//		po.setMsgApp(msgApp);
//		po.setMsgWechat(msgWechat);
//		po.setMobNotDisturb(mobNotDisturb);
//		po.setAppNotDisturb(appNotDisturb);
		int num = lottoCustomerDaoMapper.updateMsgConfig(po);
		System.out.println("num : " + num);
	}

}
