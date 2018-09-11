package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.operate.po.OperateActivityAwardPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityAwardBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityAwardVO;

public interface OperateActivityAwardDaoMapper {
	OperateActivityAwardBO selectByPrimaryKey(@Param("id")Integer id);
	int insert(OperateActivityAwardPO record);
	int merge(OperateActivityAwardPO record);
    int updateByPrimaryKey(OperateActivityAwardVO record);
    int updateOrderIds(List<?> list);
    int deleteByPrimaryKey(@Param("id") Integer id);
    int findTotal(OperateActivityAwardVO record);
}