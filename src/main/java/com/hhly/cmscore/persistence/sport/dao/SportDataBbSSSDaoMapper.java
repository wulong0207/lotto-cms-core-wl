package com.hhly.cmscore.persistence.sport.dao;

import java.util.List;

import com.hhly.cmscore.persistence.sport.po.SportDataBbSSSPO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBbSSSBO;

public interface SportDataBbSSSDaoMapper {

    List<SportDataBbSSSBO> findByAgainstInfoId(Long sportAgainstInfoId);

    int insert(SportDataBbSSSPO record);

    int updateByPrimaryKey(SportDataBbSSSPO record);
}