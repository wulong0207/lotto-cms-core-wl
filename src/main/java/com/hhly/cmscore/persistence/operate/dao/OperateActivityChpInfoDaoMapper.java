package com.hhly.cmscore.persistence.operate.dao;

import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityChpInfoBO;

import java.util.List;

public interface OperateActivityChpInfoDaoMapper {

    int count(OperateActivityChpInfoBO vo);

    List<OperateActivityChpInfoBO> find(OperateActivityChpInfoBO vo);

    List<OperateActivityChpInfoBO> findChpInfo(OperateActivityChpInfoBO vo);

    int delete(OperateActivityChpInfoBO chpVO);

    int addBatch(List<OperateActivityChpInfoBO> vos);
}