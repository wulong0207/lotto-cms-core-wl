package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import com.hhly.cmscore.persistence.operate.po.OperateAdMenuPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdMenuBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdMenuVO;

public interface OperateAdMenuDaoMapper {

	int count(OperateAdMenuVO vo);

	List<OperateAdMenuBO> list(OperateAdMenuVO vo);

	int merge(OperateAdMenuPO po);

	int delete(OperateAdMenuVO vo);
}
