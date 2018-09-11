package com.hhly.cmscore.persistence.trans.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hhly.skeleton.cms.transmgr.bo.TransRechargeBO;
import com.hhly.skeleton.cms.transmgr.bo.TransRechargeExcelBO;
import com.hhly.skeleton.cms.transmgr.vo.TransRechargeVO;

/**
 * 充值流水管理
 * @author wytong
 * @Version 1.0
 * @CreatDate 2017年1月5日 上午11:53:28
 */
public interface TransRechargeDaoMapper {

	/**
	* 查询充值流水统计数据
	* @param vo
	* @return
	*/
	Map<String, Object> findStatis(TransRechargeVO vo);
	
	/**
	* 查询充值流水
	* @param vo
	* @return
	*/
	List<TransRechargeBO> findTrans(TransRechargeVO vo);
	
	/**
	 * @desc   查询记录数量
	 * @author Tony Wang
	 * @create 2017年1月18日
	 * @param  
	 * @return
	 */
	int findTotal(TransRechargeVO vo);

	/**
	 * @desc   查询ExcelBO
	 * @author Tony Wang
	 * @create 2017年1月18日
	 * @param  
	 * @return
	 */
	List<TransRechargeExcelBO> findExcel(TransRechargeVO vo);

	/**
	 * @desc   充值补单
	 * @author Tony Wang
	 * @create 2017年1月20日
	 * @param ids
	 * @param userName 
	 * @return  
	 */
	Integer resupply(@Param("ids") List<Long> ids,@Param("userName") String userName);
}
