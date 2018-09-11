package com.hhly.cmscore.persistence.trans.dao;

import java.util.List;

import com.hhly.skeleton.cms.transmgr.bo.TransChannelSettleBO;
import com.hhly.skeleton.cms.transmgr.bo.TransChannelSettleExcelBO;
import com.hhly.skeleton.cms.transmgr.vo.TransChannelSettleVO;

/**
 * 渠道结算管理
 * @author wytong
 * @Version 1.0
 * @CreatDate 2017年1月5日 上午11:53:28
 */
public interface TransChannelSettleDaoMapper {

	/**
	* 查询数据数量
	* @param vo
	* @return
	*/
	int findTotal(TransChannelSettleVO vo);
	
	/**
	* 查询渠道结算流水
	* @param vo
	* @return
	*/
	List<TransChannelSettleBO> findTrans(TransChannelSettleVO vo);
	
	/**
	 * @desc   查询ExcelBO
	 * @author Tony Wang
	 * @create 2017年1月18日
	 * @param  
	 * @return
	 */
	List<TransChannelSettleExcelBO> findExcel(TransChannelSettleVO vo);
}
