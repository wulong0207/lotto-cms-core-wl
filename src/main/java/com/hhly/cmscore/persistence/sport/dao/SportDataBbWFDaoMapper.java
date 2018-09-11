package com.hhly.cmscore.persistence.sport.dao;

import java.util.List;

import com.hhly.cmscore.persistence.sport.po.SportDataBbWFPO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBbWFBO;

public interface SportDataBbWFDaoMapper {

    List<SportDataBbWFBO> findByAgainstInfoId(Long sportAgainstInfoId);

    int insert(SportDataBbWFPO record);

    int updateByPrimaryKey(SportDataBbWFPO record);
}