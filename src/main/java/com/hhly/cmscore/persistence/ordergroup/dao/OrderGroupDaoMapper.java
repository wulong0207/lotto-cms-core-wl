package com.hhly.cmscore.persistence.ordergroup.dao;

import org.springframework.stereotype.Repository;

import com.hhly.skeleton.cms.ordermgr.vo.OrderGroupVO;

@Repository
public interface OrderGroupDaoMapper {
	
	
	void updateRecommand(OrderGroupVO vo);
	void top(OrderGroupVO vo);

}
