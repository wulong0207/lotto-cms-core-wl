package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import com.hhly.cmscore.persistence.operate.po.OperateHelpTypePO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateHelpTypeBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpTypeVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpVO;

public interface OperateHelpTypeDaoMapper {

	List<OperateHelpTypeBO> list();

	int count(OperateHelpTypeVO criteria);

	int merge(OperateHelpTypePO operateHelpTypePO);

	String findMaxTypeCode(OperateHelpTypeVO criteria);

	List<String> findParents(OperateHelpVO vo);

	int updateOrder(List<OperateHelpTypePO> pos);

	OperateHelpTypeBO find(OperateHelpTypeVO criteria);

}
