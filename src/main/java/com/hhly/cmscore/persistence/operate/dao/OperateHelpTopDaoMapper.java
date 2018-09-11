package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import com.hhly.cmscore.persistence.operate.po.OperateHelpTopPO;

public interface OperateHelpTopDaoMapper {


	int batchAdd(List<OperateHelpTopPO> helpTops);

	int delete(Long helpId);


}
