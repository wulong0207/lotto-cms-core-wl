package com.hhly.cmscore.persistence.sport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.sport.po.SportTeamInfoPO;
import com.hhly.skeleton.cms.sportmgr.bo.SportTeamInfoBO;
import com.hhly.skeleton.cms.sportmgr.vo.SportTeamInfoVO;

public interface SportTeamInfoDaoMapper {

	int insert(SportTeamInfoPO po);
	
	int updateById(SportTeamInfoPO po);

	int findTotal(SportTeamInfoVO vo);
	
	List<SportTeamInfoBO> findList(SportTeamInfoVO vo);
	
	List<SportTeamInfoBO> findLikeList(SportTeamInfoVO vo);	
	
	SportTeamInfoBO findById(@Param("id") Integer id);

	int deleteBatch(List<String> ids);
}