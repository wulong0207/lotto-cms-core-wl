package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.operate.po.OperateActivityConfigPO;
import com.hhly.cmscore.persistence.operate.po.OperateActivityPO;
import com.hhly.skeleton.base.bo.DictionaryBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityExcelBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityVO;

public interface OperateActivityDaoMapper {
	/**
	 * 总条数
	 * 
	 * @param vo
	 * @return
	 */
	int findTotal(OperateActivityVO vo);
	/**
	 * 分页查询
	 * 
	 * @param vo
	 * @return
	 */
	List<OperateActivityBO> findList(OperateActivityVO vo);

	/**
	 * 修改
	 * 
	 * @param po
	 * @return
	 */
	int updOperateActivity(OperateActivityPO po);

	/**
	 * 添加
	 * 
	 * @param po
	 * @return
	 */
	int addOperateActivity(OperateActivityPO po);

	/**
	 * 导出excel
	 * 
	 * @param vo
	 * @return
	 */
	List<OperateActivityExcelBO> findExcelActivity(OperateActivityVO vo);
	/**
	 * 查询想起
	 * @param id
	 * @return
	 */
	OperateActivityBO findOperateActivityDetail(@Param("id")int id);
	
	/**
	 * 根据活动ID 查询主键ID
	 * @param activityId
	 * @return
	 */
	List<Integer> findIdByActivityCode(@Param("activityCode")String activityCode);

	/**
	 * 添加活动配置
	 * @param operateActivityConfigPO
	 * @return
	 */
	int addOperateActivityConfig(OperateActivityConfigPO operateActivityConfigPO);
	/**
	 * 查询未过期的活动组成下拉框
	 * @return
	 */
	List<DictionaryBO> findActivityStatusTrue();

}