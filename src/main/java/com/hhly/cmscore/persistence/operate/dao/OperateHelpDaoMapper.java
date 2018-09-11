package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.operate.po.OperateHelpPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateHelpBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpVO;

public interface OperateHelpDaoMapper {
	

	/*********************user to CMS start***********************************/
	int findTotal(OperateHelpVO vo);

	List<OperateHelpBO> list(OperateHelpVO vo);

	int add(OperateHelpPO help);

	OperateHelpBO findSingle(OperateHelpVO vo);

	int update(OperateHelpPO help);

	int updateStatus(OperateHelpPO operateHelpPO);

	String findMaxHelpCode(@Param("helpCodeLike")String helpCodeLike);

	/*********************user to CMS end***********************************/
}
