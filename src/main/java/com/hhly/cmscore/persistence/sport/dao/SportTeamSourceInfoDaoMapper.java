package com.hhly.cmscore.persistence.sport.dao;

import java.util.List;

import com.hhly.cmscore.persistence.sport.po.SportTeamSourceInfoPO;
import com.hhly.skeleton.cms.sportmgr.bo.SportTeamSourceInfoBO;
import com.hhly.skeleton.cms.sportmgr.vo.SportTeamSourceInfoVO;

public interface SportTeamSourceInfoDaoMapper {

	List<SportTeamSourceInfoBO> findList(SportTeamSourceInfoVO vo);
	
	int findTotal(SportTeamSourceInfoVO vo);
	
    int updateById(SportTeamSourceInfoPO po);
    
    int removeBind(Integer id);
    
    void deleteBatch(List<String> id);    
}