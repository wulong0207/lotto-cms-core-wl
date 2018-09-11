package com.hhly.cmscore.persistence.sport.dao;

import java.util.List;

import com.hhly.cmscore.persistence.sport.po.SportMatchSourceInfoPO;
import com.hhly.skeleton.cms.sportmgr.bo.SportMatchSourceInfoBO;
import com.hhly.skeleton.cms.sportmgr.vo.SportMatchSourceInfoVO;

public interface SportMatchSourceInfoDaoMapper {
	
	
	int findTotal(SportMatchSourceInfoVO vo);
	
	List<SportMatchSourceInfoBO> findList(SportMatchSourceInfoVO vo);
	
    int updateById(SportMatchSourceInfoPO po);
    
    int removeBind(Integer id);
    
    void deleteBatch(List<String> id);

}