package com.hhly.cmscore.persistence.customer.dao;

import java.util.List;

import com.hhly.skeleton.cms.customermgr.bo.UserWinningStatisticsBO;
import com.hhly.skeleton.cms.customermgr.bo.UserWinningStatisticsExcelBO;
import com.hhly.skeleton.cms.customermgr.vo.UserWinningStatisticsVO;

public interface UserWinningStatisticsDaoMapper {

	int findTotal(UserWinningStatisticsVO vo);

	List<UserWinningStatisticsBO> find(UserWinningStatisticsVO vo);

	List<UserWinningStatisticsExcelBO> findUserWinningStatisticsExcel(UserWinningStatisticsVO vo);
}