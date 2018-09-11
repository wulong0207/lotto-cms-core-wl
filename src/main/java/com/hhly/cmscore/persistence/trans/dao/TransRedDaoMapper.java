package com.hhly.cmscore.persistence.trans.dao;

import java.util.List;
import java.util.Map;

import com.hhly.skeleton.cms.transmgr.bo.TransRedBO;
import com.hhly.skeleton.cms.transmgr.bo.TransRedExcelBO;
import com.hhly.skeleton.cms.transmgr.vo.TransRedVO;

/**
 * 红包流水管理
 * @author wytong
 * @Version 1.0
 * @CreatDate 2017年1月5日 上午11:53:28
 */
public interface TransRedDaoMapper {

	/**
	* 查询红包流水统计数据
	* @param vo
	* @return
	*/
	Map<String, Object> findStatis(TransRedVO vo);
	
	/**
	* 查询红包流水
	* @param vo
	* @return
	*/
	List<TransRedBO> findTrans(TransRedVO vo);
	/**
	 * @desc   查询记录数量
	 * @author Tony Wang
	 * @create 2017年1月18日
	 * @param  
	 * @return
	 */
	int findTotal(TransRedVO vo);

	/**
	 * @desc   查询ExcelBO
	 * @author Tony Wang
	 * @create 2017年1月18日
	 * @param  
	 * @return
	 */
	List<TransRedExcelBO> findExcel(TransRedVO vo);
}
