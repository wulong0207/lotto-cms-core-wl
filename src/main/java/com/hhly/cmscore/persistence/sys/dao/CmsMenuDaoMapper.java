package com.hhly.cmscore.persistence.sys.dao;


import java.util.List;

import com.hhly.cmscore.persistence.sys.po.CmsMenuPO;
import com.hhly.skeleton.cms.sysmgr.bo.CMSMenuBO;
import com.hhly.skeleton.cms.sysmgr.vo.CMSMenuVO;

public interface CmsMenuDaoMapper {
    List<CMSMenuBO> selectMenuAll();

    int deleteByPrimaryKey(Integer menuId);

    List<CMSMenuBO> findMenuByUserId(Integer userId);

    int insert(CmsMenuPO record);

    int updateByPrimaryKeySelective(CmsMenuPO record);

	/**
	 * @desc   根据条件查找菜单
	 * @author Tony Wang
	 * @create 2017年5月15日
	 * @param vo
	 * @return 
	 */
	CMSMenuBO findMenu(CMSMenuVO vo);

	/**
	 * @desc   根据条件查询菜单
	 * @author Tony Wang
	 * @create 2017年5月26日
	 * @param vo
	 * @return 
	 */
	List<CMSMenuBO> findMenus(CMSMenuVO vo);
}