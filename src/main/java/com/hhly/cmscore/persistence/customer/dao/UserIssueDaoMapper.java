package com.hhly.cmscore.persistence.customer.dao;

import java.util.List;

import com.hhly.cmscore.persistence.customer.po.UserIssuePO;
import com.hhly.skeleton.cms.customermgr.bo.UserIssueBO;
import com.hhly.skeleton.cms.customermgr.bo.UserIssueExcelBO;
import com.hhly.skeleton.cms.customermgr.vo.UserIssueVO;

public interface UserIssueDaoMapper {

	int count(UserIssueVO vo);

	List<UserIssueBO> find(UserIssueVO vo);

	int update(UserIssuePO po);

	List<UserIssueExcelBO> excel(UserIssueVO vo);
}
