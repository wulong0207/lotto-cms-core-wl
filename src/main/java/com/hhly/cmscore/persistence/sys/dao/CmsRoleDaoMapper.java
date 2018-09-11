package com.hhly.cmscore.persistence.sys.dao;

import java.util.List;

import com.hhly.cmscore.persistence.sys.po.CmsRolePO;
import com.hhly.skeleton.cms.sysmgr.bo.CMSRoleBO;
import com.hhly.skeleton.cms.sysmgr.vo.CMSRoleVO;

/**
 * Created by lgs on 2016/11/9.
 * cms角色表Dao Mapper
 */
public interface CmsRoleDaoMapper {
    int insert(CmsRolePO cmsRolePO);

    int findTotalBySelective(CMSRoleVO cmsRoleVO);

    List<CMSRoleBO> findDataBySelective(CMSRoleVO cmsRoleVO);

    List<CMSRoleBO> findRoleName();

    int updateByPrimaryKey(CmsRolePO cmsRolePO);

    int deleteByPrimaryKey(Integer roleId);
}
