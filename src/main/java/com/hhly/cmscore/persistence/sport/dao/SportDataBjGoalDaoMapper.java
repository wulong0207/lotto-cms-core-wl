package com.hhly.cmscore.persistence.sport.dao;

import java.util.List;

import com.hhly.cmscore.persistence.sport.po.SportDataBjGoalPO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBjGoalBO;

public interface SportDataBjGoalDaoMapper {

    List<SportDataBjGoalBO> findByAgainstInfoId(Long sportAgainstInfoId);

    int insert(SportDataBjGoalPO record);

    int updateByPrimaryKey(SportDataBjGoalPO record);
}