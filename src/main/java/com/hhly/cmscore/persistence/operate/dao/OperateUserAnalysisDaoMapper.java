package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import com.hhly.skeleton.cms.operatemgr.bo.OperateUserAnalysisBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateUserAnalysisVO;

/**
 * @desc 会员访问信息分析
 * @author huangb
 * @date 2017年2月10日
 * @company 益彩网络
 * @version v1.0
 */
public interface OperateUserAnalysisDaoMapper {

	/**
	 * @desc 查询分页列表
	 * @author huangb
	 * @date 2017年2月10日
	 * @param operateUserAnalysis
	 *            参数对象
	 * @return 查询分页列表
	 */
	List<OperateUserAnalysisBO> findPaging(OperateUserAnalysisVO operateUserAnalysis);

	/**
	 * @desc 查询记录数量
	 * @author huangb
	 * @date 2017年2月10日
	 * @param operateUserAnalysis
	 *            查询参数
	 * @return 记录数
	 */
	int findCount(OperateUserAnalysisVO operateUserAnalysis);

	/**
	 * @desc 查询excel导出的数据
	 * @author huangb
	 * @date 2017年2月10日
	 * @param operateUserAnalysis
	 *            查询参数
	 * @return excel导出的数据
	 */
	List<OperateUserAnalysisBO> findExcel(OperateUserAnalysisVO operateUserAnalysis);

}