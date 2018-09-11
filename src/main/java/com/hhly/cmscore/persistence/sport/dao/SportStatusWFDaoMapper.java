package com.hhly.cmscore.persistence.sport.dao;

import com.hhly.cmscore.persistence.sport.po.SportStatusWFPO;

public interface SportStatusWFDaoMapper {

    int insert(SportStatusWFPO record);


    int updateByPrimaryKey(SportStatusWFPO record);
}