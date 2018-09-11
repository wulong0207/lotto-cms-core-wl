package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import com.hhly.cmscore.persistence.operate.po.OperateFastPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateFastBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateFastVO;

/**
 * @desc    快投模块管理
 * @author  lidecheng
 * @date    2017年2月23日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface OperateFastDaoMapper {

	int findTotal(OperateFastVO vo);

	List<OperateFastBO> list(OperateFastVO vo);	
	int mergeOperateFastInfo(OperateFastPO po);

	int addOperateFast(OperateFastPO po);

	int updateOperateFast(OperateFastPO po);
	/**
	 * 查询数据是否冲突
	 * @param vo
	 * @return
	 */
	int findTimeRepeatTotal(OperateFastVO vo);
}
