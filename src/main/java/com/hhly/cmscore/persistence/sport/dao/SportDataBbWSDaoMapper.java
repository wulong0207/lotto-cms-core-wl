package com.hhly.cmscore.persistence.sport.dao;

import java.util.List;

import com.hhly.cmscore.persistence.sport.po.SportDataBbWSPO;
import com.hhly.skeleton.cms.sportmgr.bo.SportDataBbWSBO;

public interface SportDataBbWSDaoMapper {

    List<SportDataBbWSBO> findByAgainstInfoId(Long sportAgainstInfoId);

    int insert(SportDataBbWSPO record);

    int updateByPrimaryKey(SportDataBbWSPO record);
}