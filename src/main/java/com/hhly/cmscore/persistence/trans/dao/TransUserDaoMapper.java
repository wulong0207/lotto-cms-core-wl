package com.hhly.cmscore.persistence.trans.dao;

import java.util.List;
import java.util.Map;

import com.hhly.skeleton.cms.transmgr.bo.TransUserBO;
import com.hhly.skeleton.cms.transmgr.bo.TransUserExcelBO;
import com.hhly.skeleton.cms.transmgr.vo.TransUserVO;
import org.apache.ibatis.annotations.Param;

/**
 * 用户流水管理
 * @author wytong
 * @Version 1.0
 * @CreatDate 2017年1月5日 上午11:53:28
 */
public interface TransUserDaoMapper {

	/**
	 * 查询用户流水
	 * @param vo
	 * @return
	 */
	List<TransUserBO> findTrans(TransUserVO vo);

	/**
	 * 查询用户流水统计数据
	 * @param vo
	 * @return
	 */
	Map<String, Object> findStatis(TransUserVO vo);

	/**
	 * @desc   查询记录数量
	 * @author Tony Wang
	 * @create 2017年1月18日
	 * @param  
	 * @return
	 */
	int findTotal(TransUserVO vo);

	/**
	 * @desc   查询ExcelBO
	 * @author Tony Wang
	 * @create 2017年1月18日
	 * @param  
	 * @return
	 */
	List<TransUserExcelBO> findExcel(TransUserVO vo);

	/**
	 * 根据渠道id购彩查询交易成功流水总额
	 *
	 * @param channelId
	 * @return
	 */
	double findTransAmountTotalByChannelId(@Param("channelId") String channelId);
}
