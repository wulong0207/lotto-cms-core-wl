package com.hhly.cmscore.persistence.sys.dao;

import java.util.List;

import com.hhly.cmscore.persistence.sys.po.CmsUserPO;
import com.hhly.skeleton.cms.sysmgr.bo.CMSUserBO;
import com.hhly.skeleton.cms.sysmgr.bo.CMSUserLoginBO;
import com.hhly.skeleton.cms.sysmgr.bo.CmsUserTypeBO;
import com.hhly.skeleton.cms.sysmgr.vo.CMSUserVO;

/**
 * Created by lgs on 2016/11/9.
 * cms用户表Dao Mapper
 */
public interface CmsUserDaoMapper {

    Integer findTotalBySelective(CMSUserVO vo);

    List<CMSUserBO> findDataBySelective(CMSUserVO vo);

    String findUserName(CMSUserVO vo);

    CMSUserLoginBO findUser(CMSUserVO vo);

    Integer findCount(CMSUserVO vo);

    Integer insert(CmsUserPO po);

    Integer updateByPrimaryKeySelective(CmsUserPO po);

    Integer deleteByPrimaryKey(Integer userId);

    Integer updateUserLastLoginTime(CmsUserPO po);

    Integer updatePwd(CmsUserPO po);

	List<CmsUserTypeBO> findUserType();
}
