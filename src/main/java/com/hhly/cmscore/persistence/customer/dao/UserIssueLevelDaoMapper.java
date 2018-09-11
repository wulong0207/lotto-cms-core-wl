package com.hhly.cmscore.persistence.customer.dao;

import java.util.List;

import com.hhly.cmscore.persistence.customer.po.UserIssueLevelPO;
import com.hhly.skeleton.cms.customermgr.bo.UserIssueLevelBO;
import com.hhly.skeleton.cms.customermgr.vo.UserIssueLevelVO;

public interface UserIssueLevelDaoMapper {

	int merge(UserIssueLevelPO po);

	UserIssueLevelBO findOne(UserIssueLevelVO vo);

	List<UserIssueLevelBO> find(UserIssueLevelVO vo);

	List<Integer> findDistinctUserId(UserIssueLevelVO vo);
}
