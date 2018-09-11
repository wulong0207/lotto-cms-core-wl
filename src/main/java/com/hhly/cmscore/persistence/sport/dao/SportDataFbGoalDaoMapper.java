package com.hhly.cmscore.persistence.sport.dao;


import java.util.List;

import com.hhly.cmscore.persistence.sport.po.SportDataFbGoalPO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataFbGoalBO;

public interface SportDataFbGoalDaoMapper {

    List<SportDataFbGoalBO> findByAgainstInfoId(Long sportAgainstInfoId);

    int insert(SportDataFbGoalPO record);

    int updateByPrimaryKey(SportDataFbGoalPO record);
}