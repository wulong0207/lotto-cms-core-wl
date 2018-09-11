package com.hhly.cmscore.persistence.sport.dao;

import java.util.List;

import com.hhly.cmscore.persistence.sport.po.SportDataSfWFPO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataSfWFBO;

public interface SportDataSfWFDaoMapper {

    List<SportDataSfWFBO> findByAgainstInfoId(Long sportAgainstInfoId);

    int insert(SportDataSfWFPO record);

    int updateByPrimaryKey(SportDataSfWFPO record);
}