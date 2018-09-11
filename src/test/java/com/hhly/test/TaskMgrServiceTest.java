package com.hhly.test;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.hhly.cmscore.cms.remote.service.ITaskMgrService;
import com.hhly.persistence.util.HessianUtils;
import com.hhly.skeleton.cms.taskmgr.vo.TaskInfoVO;
import com.hhly.skeleton.cms.taskmgr.vo.TaskVO;

public class TaskMgrServiceTest {
	
	private String url;
	
	private ITaskMgrService sys;
	
	@Before
	public void before() throws MalformedURLException{
	    url = "http://localhost:8081/lotto-cms-core/remote//taskMgrService";
	    sys = HessianUtils.getRemoteService(ITaskMgrService.class, url);
	}
	
	@Test
	public void testFindPaging() {
		TaskVO vo = getTaskVO();
		sys.findPaging(vo);		
	}
	
	@Test
	public void testFindSingle() {
		TaskVO vo = getTaskVO();
		sys.findSingle(vo);		
	}
	
	@Test
	public void testFindMultiple() {
		TaskVO vo = getTaskVO();
		sys.findMultiple(vo);		
	}

	@Test
	public void testFindPagingTaskInfo() {
		TaskInfoVO vo = getTaskInfoVO();
		sys.findPagingTaskInfo(vo);		
	}
		
	@Test
	public void testFindSingleTaskInfo() {
		TaskInfoVO vo = getTaskInfoVO();
		sys.findSingleTaskInfo(vo);		
	}
	
	@Test
	public void testFindMultipleTaskInfo() {
		TaskInfoVO vo = getTaskInfoVO();
		sys.findMultipleTaskInfo(vo);		
	}

	private TaskInfoVO getTaskInfoVO() {
		TaskInfoVO vo = new TaskInfoVO();
		vo.setId((long) 1);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		return vo;
	}
	
	private TaskVO getTaskVO() {
		TaskVO vo = new TaskVO();
		vo.setId(1);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		return vo;
	}
	
	
}
