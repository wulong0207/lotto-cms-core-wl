package com.hhly.cmscore.cms.remote.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.cmscore.cms.remote.service.ITaskMgrService;
import com.hhly.cmscore.persistence.task.dao.TaskDaoMapper;
import com.hhly.cmscore.persistence.task.po.TaskInfoPO;
import com.hhly.cmscore.persistence.task.po.TaskPO;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.bo.ResultBO;
import com.hhly.skeleton.base.constants.SymbolConstants;
import com.hhly.skeleton.base.exception.ServiceRuntimeException;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.page.ISimplePage;
import com.hhly.skeleton.cms.taskmgr.bo.TaskBO;
import com.hhly.skeleton.cms.taskmgr.bo.TaskInfoBO;
import com.hhly.skeleton.cms.taskmgr.vo.TaskInfoVO;
import com.hhly.skeleton.cms.taskmgr.vo.TaskVO;

/**
 * @author huangb
 *
 * @Date 2017年1月4日
 *
 * @Desc 调度任务服务
 */
@Service("taskMgrService")
public class TaskMgrServiceImpl implements ITaskMgrService {

	@Autowired
	private TaskDaoMapper taskDaoMapper;

	@Autowired
	private IPageService pageService;

	@Override
	public PagingBO<TaskBO> findPaging(final TaskVO vo) {

		return pageService.getPageData(vo, new ISimplePage<TaskBO>() {
			@Override
			public int getTotal() {
				return taskDaoMapper.findCount(vo);
			}

			@Override
			public List<TaskBO> getData() {
				return taskDaoMapper.findPaging(vo);
			}
		});
	}

	@Override
	public TaskBO findSingle(TaskVO taskVO) {
		return taskDaoMapper.findSingle(taskVO);
	}

	@Override
	public List<TaskBO> findMultiple(TaskVO taskVO) {
		return taskDaoMapper.findMultiple(taskVO);
	}

	@Override
	public ResultBO<Integer> addTask(TaskVO taskVO) {
		if(StringUtils.isNotBlank(taskVO.getJobId())){
			TaskVO vo = new TaskVO();
			vo.setJobId(taskVO.getJobId());
			TaskBO bo = findSingle(vo);
			if(bo != null){
				throw new ServiceRuntimeException("任务编号已经存在不能！");
			}
		}
		// 执行insert后会返回自增长值
		TaskPO target = new TaskPO(taskVO);
		taskDaoMapper.addTask(target);
		// 生成任务id并设置（因为任务入库后还得纳入到调度计划，所以任务的id必须作为任务标识返回）
		return ResultBO.ok(target.getId());
	}
	@Override
	public int updTask(TaskVO taskVO) {
		TaskVO vo = new TaskVO();
		vo.setId(taskVO.getId());
		TaskBO bo = findSingle(vo);
		if(StringUtils.isBlank(bo.getJobId()) 
				|| bo.getJobId().equals(taskVO.getJobId())){
			return taskDaoMapper.updTask(new TaskPO(taskVO));
		}else{
			throw new ServiceRuntimeException("任务编号不能修改");
		}
	}

	@Override
	public int delTaskByIds(String ids) {
		return taskDaoMapper.delTaskByIds(Arrays.asList(ids.split(SymbolConstants.COMMA)));
	}

	/************************* 以下是任务记录表的操作 ***************************/

	@Override
	public PagingBO<TaskInfoBO> findPagingTaskInfo(final TaskInfoVO taskInfoVO) {

		return pageService.getPageData(taskInfoVO, new ISimplePage<TaskInfoBO>() {
			@Override
			public int getTotal() {
				return taskDaoMapper.findCountTaskInfo(taskInfoVO);
			}

			@Override
			public List<TaskInfoBO> getData() {
				return taskDaoMapper.findPagingTaskInfo(taskInfoVO);
			}
		});
	}

	@Override
	public TaskInfoBO findSingleTaskInfo(TaskInfoVO taskInfoVO) {
		return taskDaoMapper.findSingleTaskInfo(taskInfoVO);
	}

	@Override
	public List<TaskInfoBO> findMultipleTaskInfo(TaskInfoVO taskInfoVO) {
		return taskDaoMapper.findMultipleTaskInfo(taskInfoVO);
	}

	@Override
	public ResultBO<Long> addTaskInfo(TaskInfoVO taskInfoVO) {
		TaskInfoPO target = new TaskInfoPO(taskInfoVO);
		taskDaoMapper.addTaskInfo(target);
		// 生成任务执行id并设置（因为任务执行id会作为参数传递给具体执行业务体，所以这里单独生成，方便传递）
		return ResultBO.ok(target.getId());
	}

	@Override
	public int updTaskInfo(TaskInfoVO taskInfoVO) {
		return taskDaoMapper.updTaskInfo(new TaskInfoPO(taskInfoVO));
	}

}
