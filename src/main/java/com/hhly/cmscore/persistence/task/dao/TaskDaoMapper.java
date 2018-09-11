package com.hhly.cmscore.persistence.task.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.task.po.TaskInfoPO;
import com.hhly.cmscore.persistence.task.po.TaskPO;
import com.hhly.skeleton.cms.taskmgr.bo.TaskBO;
import com.hhly.skeleton.cms.taskmgr.bo.TaskInfoBO;
import com.hhly.skeleton.cms.taskmgr.vo.TaskInfoVO;
import com.hhly.skeleton.cms.taskmgr.vo.TaskVO;

/**
 * @author huangb
 *
 * @Date 2017年1月4日
 *
 * @Desc 调度任务数据接口
 */
public interface TaskDaoMapper {

	/**
	 * @param taskVO
	 *            参数对象
	 * @return 单个查询对象
	 * @desc 查询唯一的数据记录
	 */
	TaskBO findSingle(TaskVO taskVO);

	/**
	 * @param taskVO
	 *            参数对象
	 * @return 多个查询对象（列表）
	 * @desc 查询多条数据记录（列表）
	 */
	List<TaskBO> findMultiple(TaskVO taskVO);

	/**
	 * @param taskVO
	 *            参数对象
	 * @return 查询分页列表
	 * @desc 查询分页列表
	 */
	List<TaskBO> findPaging(TaskVO taskVO);

	/**
	 * @param taskVO
	 *            查询参数
	 * @return 记录数
	 * @Desc 查询记录数量
	 */
	int findCount(TaskVO taskVO);

	/**
	 * @param taskPO
	 *            参数
	 * @return 新增结果
	 * @Desc 新增调度任务
	 */
	int addTask(TaskPO taskPO);

	/**
	 * @param taskPO
	 *            参数
	 * @return 修改结果
	 * @Desc 修改调度任务
	 */
	int updTask(TaskPO taskPO);

	/**
	 * @param ids
	 *            参数
	 * @return 删除结果
	 * @Desc 删除调度任务
	 */
	int delTaskByIds(@Param("ids") List<String> ids);

	/************************* 以下是任务记录表的操作 ***************************/
	/**
	 * @param taskInfoVO
	 *            参数对象
	 * @return 单个查询对象
	 * @desc 查询唯一的数据记录
	 */
	TaskInfoBO findSingleTaskInfo(TaskInfoVO taskInfoVO);

	/**
	 * @param taskInfoVO
	 *            参数对象
	 * @return 多个查询对象（列表）
	 * @desc 查询多条数据记录（列表）
	 */
	List<TaskInfoBO> findMultipleTaskInfo(TaskInfoVO taskInfoVO);

	/**
	 * @param taskInfoVO
	 *            参数对象
	 * @return 查询分页列表
	 * @desc 查询分页列表
	 */
	List<TaskInfoBO> findPagingTaskInfo(TaskInfoVO taskInfoVO);

	/**
	 * @param taskInfoVO
	 *            查询参数
	 * @return 记录数
	 * @Desc 查询记录数量
	 */
	int findCountTaskInfo(TaskInfoVO taskInfoVO);

	/**
	 * @param taskInfoPO
	 *            参数
	 * @return 新增结果
	 * @Desc 新增调度任务执行记录
	 */
	int addTaskInfo(TaskInfoPO taskInfoPO);

	/**
	 * @param taskInfoPO
	 *            参数
	 * @return 修改结果
	 * @Desc 修改调度任务执行记录
	 */
	int updTaskInfo(TaskInfoPO taskInfoPO);
}
