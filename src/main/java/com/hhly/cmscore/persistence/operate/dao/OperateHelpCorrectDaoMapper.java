package com.hhly.cmscore.persistence.operate.dao;


import java.util.List;

import com.hhly.cmscore.persistence.operate.po.OperateHelpCorrectPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateHelpCorrectBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpCorrectVO;

/**
 * @desc
 * @author cheng chen
 * @date 2017年4月21日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface OperateHelpCorrectDaoMapper {
	
	/**
	 * 分页查询
	 * @param vo
	 * @return
	 */
	List<OperateHelpCorrectBO> find(OperateHelpCorrectVO vo);
	
	/**
	 * 分页查询总条数
	 * 
	 * @param vo
	 * @return
	 */
	int findTotal(OperateHelpCorrectVO vo);

	/**
	 * 对象条件修改
	 * @param po
	 * @return
	 */
    int updateById(OperateHelpCorrectPO po);

}