package com.hhly.cmscore.persistence.operate.dao;

import com.hhly.cmscore.persistence.operate.po.OperateActivityConfigPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityChpGuessBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OperateActivityChpGuessDaoMapper {


    List<OperateActivityChpGuessBO> find(OperateActivityChpGuessBO vo);

    int merge(OperateActivityConfigPO po);
}