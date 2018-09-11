package com.hhly.cmscore.persistence.operate.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.operate.po.OperateActivityAddedPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityAddedBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityAddedVO;

public interface OperateActivityAddedDaoMapper {
	OperateActivityAddedBO selectByPrimaryKey(@Param("id")Integer id);
	int insert(OperateActivityAddedPO record);
	int merge(OperateActivityAddedPO record);
    int updateByPrimaryKey(OperateActivityAddedVO record);
    int deleteByPrimaryKey(@Param("id") Integer id);
    int updateLotterChildCode(List<?> list);   
    int updateAddCodeIssue(OperateActivityAddedVO vo);
}