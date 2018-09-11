
package com.hhly.cmscore.persistence.task.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.customer.po.LottoCustomerPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryBettingMulPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryChildPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryTypePO;
import com.hhly.cmscore.persistence.task.dao.TaskDaoMapper;
import com.hhly.cmscore.persistence.task.po.TaskInfoPO;
import com.hhly.cmscore.persistence.task.po.TaskPO;
import com.hhly.skeleton.base.issue.entity.NewTypeBO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerBO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerExcelBO;
import com.hhly.skeleton.cms.customermgr.vo.LottoCustomerVO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryBettingMulBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryChildBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryTypeBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryTypeExcelBO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryChildCmsVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryTypeVO;
import com.hhly.skeleton.cms.taskmgr.bo.TaskBO;
import com.hhly.skeleton.cms.taskmgr.bo.TaskInfoBO;
import com.hhly.skeleton.cms.taskmgr.vo.TaskInfoVO;
import com.hhly.skeleton.cms.taskmgr.vo.TaskVO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotBettingMulBO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotChildBO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotteryBO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotChildVO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotteryBettingMulVO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotteryVO;

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
public class TaskDaoMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	TaskDaoMapper taskDaoMapper;

	@Test
	public void testFindSingle() {
		TaskVO s = new TaskVO();
		s.setId(1);
		TaskBO t = taskDaoMapper.findSingle(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testFindMultiple() {
		TaskVO s = new TaskVO();
		s.setId(1);
		List<TaskBO>  t = taskDaoMapper.findMultiple(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testFindPaging() {
		TaskVO s = new TaskVO();
		s.setId(1);
		s.setPageIndex(0);
		s.setPageSize(10);
		List<TaskBO>  t = taskDaoMapper.findPaging(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testAddTask() {
		TaskVO a = new TaskVO();
		a.setId(1);
		TaskBO t = taskDaoMapper.findSingle(a);
		TaskPO s = new TaskPO();
		s.setJobName(t.getJobName());
		s.setJobManualUrl(t.getJobManualUrl());
		s.setJobCronExpression(t.getJobCronExpression());
		s.setJobGroup(t.getJobGroup());
		s.setJobStatus(t.getJobStatus());
		s.setJobAutorun(t.getJobAutorun());
		s.setParamKey1(t.getParamKey1());
		s.setParamValue1(t.getParamValue1());
		s.setModifyBy(t.getModifyBy());
		s.setCreateBy(t.getCreateBy());
		s.setRemark(t.getRemark());
		s.setRestartRun(t.getRestartRun());
		s.setJobWay(t.getJobWay());
		s.setJobId(t.getJobId());
		int r = taskDaoMapper.addTask(s);
		System.out.println("返回: " + r);
	}
	@Test
	public void testUpdTask() {
		TaskVO a = new TaskVO();
		a.setId(1);
		TaskBO t = taskDaoMapper.findSingle(a);
		TaskPO s = new TaskPO();
		s.setJobName(t.getJobName());
		s.setJobManualUrl(t.getJobManualUrl());
		s.setJobCronExpression(t.getJobCronExpression());
		s.setJobGroup(t.getJobGroup());
		s.setJobStatus(t.getJobStatus());
		s.setJobAutorun(t.getJobAutorun());
		s.setParamKey1(t.getParamKey1());
		s.setParamValue1(t.getParamValue1());
		s.setModifyBy(t.getModifyBy());
		s.setCreateBy(t.getCreateBy());
		s.setRemark(t.getRemark());
		s.setRestartRun(t.getRestartRun());
		s.setJobWay(t.getJobWay());
		s.setJobId(t.getJobId());
		int r = taskDaoMapper.updTask(s);
		System.out.println("返回: " + r);
	}
	
	@Test
	public void testDelTaskByIds() {
		List<String> ids = new ArrayList<>();
		ids.add("10000");
		ids.add("10200");
		int r = taskDaoMapper.delTaskByIds(ids);
		System.out.println("返回: " + r);
	}
	@Test
	public void testFindSingleTaskInfo() {
		TaskInfoVO s = new TaskInfoVO();
		s.setId(100L);
		TaskInfoBO t = taskDaoMapper.findSingleTaskInfo(s);
		System.out.println("返回: " + t);
	}
	@Test
	public void testFindPagingTaskInfo() {
		TaskInfoVO s = new TaskInfoVO();
		s.setId(100L);
		s.setPageIndex(0);
		s.setPageSize(10);
		List<TaskInfoBO> t = taskDaoMapper.findPagingTaskInfo(s);
		System.out.println("返回: " + t);
	}
	
	@Test
	public void testAddTaskInfo() {
		TaskInfoVO a = new TaskInfoVO();
		a.setId(1346925L);
		TaskInfoBO t = taskDaoMapper.findSingleTaskInfo(a);
		TaskInfoPO s = new TaskInfoPO();
		s.setTimedTaskId(t.getTimedTaskId());
		s.setRunTime(t.getRunTime());
		s.setRunWay(t.getRunWay());
		s.setStatus(t.getStatus());
		s.setStartTime(t.getStartTime());
		s.setEndTime(t.getEndTime());
		s.setSpendTime(t.getSpendTime());
		s.setResult(t.getResult());
		s.setRemark(t.getRemark());
		
		int r = taskDaoMapper.addTaskInfo(s);
		System.out.println("返回: " + r);
	}
	@Test
	public void testUpdTaskInfo() {
		TaskInfoVO a = new TaskInfoVO();
		a.setId(1346925L);
		TaskInfoBO t = taskDaoMapper.findSingleTaskInfo(a);
		TaskInfoPO s = new TaskInfoPO();
		s.setTimedTaskId(t.getTimedTaskId());
		s.setRunTime(t.getRunTime());
		s.setRunWay(t.getRunWay());
		s.setStatus(t.getStatus());
		s.setStartTime(t.getStartTime());
		s.setEndTime(t.getEndTime());
		s.setSpendTime(t.getSpendTime());
		s.setResult(t.getResult());
		s.setRemark(t.getRemark());
		
		int r = taskDaoMapper.updTaskInfo(s);
		System.out.println("返回: " + r);
	}
	
}
