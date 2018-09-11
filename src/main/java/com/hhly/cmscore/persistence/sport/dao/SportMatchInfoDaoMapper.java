package com.hhly.cmscore.persistence.sport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.sport.po.SportMatchInfoPO;
import com.hhly.skeleton.cms.sportmgr.bo.SportMatchInfoBO;
import com.hhly.skeleton.cms.sportmgr.vo.SportMatchInfoVO;

public interface SportMatchInfoDaoMapper {

	int insert(SportMatchInfoPO po);

	int updateById(SportMatchInfoPO po);

	int findTotal(SportMatchInfoVO vo);
	
	List<SportMatchInfoBO> findList(SportMatchInfoVO vo);
	
	List<SportMatchInfoBO> findLikeList(SportMatchInfoVO vo);	

	SportMatchInfoBO findSingle(@Param("id") Integer id);

	int deleteBatch(List<String> id);
}