package com.hhly.cmscore.persistence.ordergroup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hhly.skeleton.cms.ordermgr.bo.GroupUserBO;
import com.hhly.skeleton.cms.ordermgr.bo.GroupUserExcelBO;
import com.hhly.skeleton.cms.ordermgr.vo.GroupUserVO;

@Repository
public interface GroupUserDaoMapper {
	
	List<GroupUserBO> findGroupUser(GroupUserVO vo);
	
	List<GroupUserExcelBO> exprotGroupUserExcel(GroupUserVO vo);
	
	int findGroupUserTotal(GroupUserVO vo);
	
	void updateRecommand(GroupUserVO vo);
	
	void updateUserFlag(GroupUserVO vo);

}
