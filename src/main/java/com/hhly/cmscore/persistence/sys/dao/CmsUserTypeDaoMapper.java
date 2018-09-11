package com.hhly.cmscore.persistence.sys.dao;

import java.util.List;

import com.hhly.skeleton.cms.sysmgr.bo.CmsUserTypeBO;

/**
 * @desc    用户分类
 * @author  Tony Wang
 * @date    2017年4月21日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface CmsUserTypeDaoMapper {

	/**
	 * @desc   查询所有用户分类
	 * @author Tony Wang
	 * @create 2017年4月21日
	 * @return 
	 */
	List<CmsUserTypeBO> find();

}
