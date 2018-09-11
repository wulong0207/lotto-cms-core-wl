package com.hhly.cmscore.persistence.operate.dao;

import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityInfoBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperateActivityInfoDaoMapper {
    int delete(OperateActivityInfoBO vo);

    int addBatch(List<OperateActivityInfoBO> infoesToAdd);
}