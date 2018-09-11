package com.hhly.cmscore.persistence.trans.dao;

import java.util.List;
import java.util.Map;

import com.hhly.skeleton.cms.transmgr.bo.TransTakenBO;
import com.hhly.skeleton.cms.transmgr.bo.TransTakenCMBCBankExcelBO;
import com.hhly.skeleton.cms.transmgr.bo.TransTakenExcelBO;
import com.hhly.skeleton.cms.transmgr.vo.TransTakenVO;

/**
 * 提款流水管理
 * @author wytong
 * @Version 1.0
 * @CreatDate 2017年1月5日 上午11:53:28
 */
public interface TransTakenDaoMapper {

	/**
	* 查询充值流水统计数据
	* @param vo
	* @return
	*/
	Map<String, Object> findStatis(TransTakenVO vo);
	
	/**
	* 查询充值流水
	* @param vo
	* @return
	*/
	List<TransTakenBO> findTrans(TransTakenVO vo);
	
	/**
	 * @desc   查询记录数量
	 * @author Tony Wang
	 * @create 2017年1月18日
	 * @param  
	 * @return
	 */
	int findTotal(TransTakenVO vo);

	/**
	 * @desc   查询ExcelBO
	 * @author Tony Wang
	 * @create 2017年1月18日
	 * @param  
	 * @return
	 */
	List<TransTakenExcelBO> findExcel(TransTakenVO vo);
	
	/**
	 * @desc   查询针对银行的ExcelBO
	 * @author Tony Wang
	 * @create 2017年8月3日
	 * @param vo
	 * @return 
	 */
	//@SelectProvider(type = TransTakenDaoProvider.class,method="findBankExcel")
	//@MapKey("batchNum")
	//Map<String, ArrayList<TransTakenBankExcelBO>> findBankExcel(TransTakenVO vo);
	List<TransTakenCMBCBankExcelBO> findBankExcel(TransTakenVO vo);

	/**
	 * @desc   更新提款记录状态(可能会同时更新操作人员信息)
	 * @author Tony Wang
	 * @create 2017年5月22日
	 * @param pos
	 * @return 
	 */
//	int updateStatus(List<TransTakenPO> pos);

	/**
	 * @desc   查询批次号
	 * @author Tony Wang
	 * @create 2017年8月4日
	 * @param vo
	 * @return 
	 */
	List<String> findBatchNums(TransTakenVO vo);

	
	/**
	 * @desc   查询提款申请记录
	 * @author Tony Wang
	 * @create 2017年8月4日
	 * @param vo
	 * @return 
	 */
	List<TransTakenBO> findTransNoPaging(TransTakenVO vo);

	int updateCreateBy(String actualName, Integer userId);
}
