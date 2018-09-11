package com.hhly.cmscore.persistence.sys.dao;



import java.util.List;

import com.hhly.cmscore.persistence.sys.po.CmsUserMenuPO;
import com.hhly.skeleton.cms.sysmgr.bo.CMSUserAuthTreeBO;
import com.hhly.skeleton.cms.sysmgr.vo.CMSUserVO;

public interface CmsUserMenuDaoMapper {
    List<CMSUserAuthTreeBO> findUserAuthTree(CMSUserVO vo);

    Integer insert(CmsUserMenuPO po);

    Integer deleteByPrimaryKey(CmsUserMenuPO po);
}