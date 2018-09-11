package com.hhly.cmscore.persistence.sys.dao;

import java.util.List;

import com.hhly.cmscore.persistence.sys.po.CmsUserLogPO;
import com.hhly.skeleton.cms.sysmgr.bo.CmsUserLogBO;
import com.hhly.skeleton.cms.sysmgr.vo.CmsUserLogVO;

/**
 * @desc    用户日志操作
 * @author  Tony Wang
 * @date    2017年5月15日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface CmsUserLogDaoMapper {

	/**
	 * @desc   添加用户日志操作
	 * @author Tony Wang
	 * @create 2017年5月15日
	 * @return 
	 */
	int add(CmsUserLogPO po);

	/**
	 * @desc   查询符合条件的用户日志操作记录数量
	 * @author Tony Wang
	 * @create 2017年5月15日
	 * @param vo
	 * @return 
	 */
	int count(CmsUserLogVO vo);

	/**
	 * @desc   查询符合条件的用户日志操作记录
	 * @author Tony Wang
	 * @create 2017年5月15日
	 * @param vo
	 * @return 
	 */
	List<CmsUserLogBO> list(CmsUserLogVO vo);

	/**
	 * @desc   根据条件查询操作日志
	 * @author Tony Wang
	 * @create 2017年5月26日
	 * @param vo
	 * @return 
	 */
	CmsUserLogBO find(CmsUserLogVO vo);

}
