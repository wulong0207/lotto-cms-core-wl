package com.hhly.cmscore.persistence.sys.dao;

import java.util.List;

import com.hhly.cmscore.persistence.sys.po.CmsRoleMenuPO;
import com.hhly.skeleton.cms.sysmgr.bo.CMSRoleMenuBO;

public interface CmsRoleMenuDaoMapper {

    int deleteByPrimaryKey(CmsRoleMenuPO po);

    List<CMSRoleMenuBO> findAuthorityByRoleId(Integer roleId);

    int insert(CmsRoleMenuPO po);
}