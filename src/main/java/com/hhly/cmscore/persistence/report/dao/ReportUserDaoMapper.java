package com.hhly.cmscore.persistence.report.dao;

import java.util.List;

import com.hhly.skeleton.cms.report.bo.ReportUserBO;
import com.hhly.skeleton.cms.report.vo.ReportSearchVO;

/**
 * @desc    用户数据Dao
 * @author  Tony Wang
 * @date    2017年9月1日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface ReportUserDaoMapper {

	List<ReportUserBO> find(ReportSearchVO vo);

	ReportUserBO overview(ReportSearchVO vo);
}
