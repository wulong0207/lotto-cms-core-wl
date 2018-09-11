package com.hhly.cmscore.persistence.sport.dao;

import java.util.List;

import com.hhly.cmscore.persistence.sport.po.SportDataFbHfWDFPO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataFbHfWDFBO;

public interface SportDataFbHfWDFDaoMapper {

    List<SportDataFbHfWDFBO> findByAgainstInfoId(Long sportAgainstInfoId);

    int insert(SportDataFbHfWDFPO record);

    int updateByPrimaryKey(SportDataFbHfWDFPO record);
}