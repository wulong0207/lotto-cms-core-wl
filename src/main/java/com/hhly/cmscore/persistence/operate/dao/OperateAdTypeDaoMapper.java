package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import com.hhly.cmscore.persistence.operate.po.OperateAdTypePO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdTypeBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdTypeVO;

public interface OperateAdTypeDaoMapper {

	/**
	 * @desc   批量添加
	 * @author Tony Wang
	 * @create 2017年4月21日
	 * @param pos 
	 * @return 
	 */
	int batchAdd(List<OperateAdTypePO> pos);

	/**
	 * @desc   删除
	 * @author Tony Wang
	 * @create 2017年4月21日
	 * @param criteria
	 * @return 
	 */
	int delete(OperateAdTypeVO criteria);

	/**
	 * @desc   查询
	 * @author Tony Wang
	 * @create 2017年4月25日
	 * @param vo
	 * @return 
	 */
	List<OperateAdTypeBO> list(OperateAdTypeVO vo);

}
