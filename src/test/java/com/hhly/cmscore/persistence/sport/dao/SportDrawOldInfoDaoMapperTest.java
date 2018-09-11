
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

import com.hhly.cmscore.persistence.sport.dao.SportDrawOldInfoDaoMapper;
import com.hhly.cmscore.persistence.sport.po.SportDrawOldInfoPO;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataFbOldExcelBo;
import com.hhly.skeleton.cms.sportmgr.bo.SportOldLotteryInfoBO;
import com.hhly.skeleton.cms.sportmgr.vo.SMGLotteryParamVO;

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
public class SportDrawOldInfoDaoMapperTest {

	@Autowired
	SportDrawOldInfoDaoMapper sportDrawOldInfoDaoMapper;
	
	@Test
	@Rollback(true)
	public void testDeleteByPrimaryKey() {
		long id = 1l;
		int num = sportDrawOldInfoDaoMapper.deleteByPrimaryKey(id);
		System.out.println(num);
	}

	@Test
	@Rollback(true)
	public void testInsert() {
		SportDrawOldInfoPO po = new SportDrawOldInfoPO();
		po.setSportAgainstInfoId(1l);
		po.setFourGoal("1");
		po.setHalfScore("1");
		po.setFourteenWdf(1l);
		po.setHalfScore("1");
		po.setCount(1);
		po.setSixHfWdf("1");
		po.setModifyBy("cheng.chen");
		po.setDrawTime(DateUtil.getNowDate());
		po.setCreateTime(DateUtil.getNowDate());
		po.setModifyTime(DateUtil.getNowDate());
		po.setUpdateTime(DateUtil.getNowDate());
		int num = sportDrawOldInfoDaoMapper.insert(po);
		System.out.println(po.getId());
	}

	@Test
	public void testCountByParamVO() {
		SMGLotteryParamVO vo = new SMGLotteryParamVO();
		vo.setLotteryCode(300);
		int num = sportDrawOldInfoDaoMapper.countByParamVO(vo);
		System.out.println(num);
	}

	@Test
	public void testSelectByParamVO() {
		SMGLotteryParamVO vo = new SMGLotteryParamVO();
		vo.setLotteryCode(300);
		vo.setPageIndex(0);
		vo.setPageSize(10);
		List<SportOldLotteryInfoBO> list = sportDrawOldInfoDaoMapper.selectByParamVO(vo);
	}

	@Test
	@Rollback(true)
	public void testUpdateByPrimaryKey() {
		SportDrawOldInfoPO po = new SportDrawOldInfoPO();
		po.setId(1l);
		po.setFourGoal("4");
		int num = sportDrawOldInfoDaoMapper.updateByPrimaryKey(po);
	}

	@Test
	public void testFindAllList() {
		SMGLotteryParamVO vo = new SMGLotteryParamVO();
		vo.setLotteryCode(300);
		List<SportDataFbOldExcelBo> list = sportDrawOldInfoDaoMapper.findAllList(vo);
	}

}
