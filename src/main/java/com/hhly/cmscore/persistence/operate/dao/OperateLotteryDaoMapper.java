package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.operate.po.OperateLotteryPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateLotteryBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateLotteryVO;

/**
 * @desc    彩种运营管理
 * @author  Tony Wang
 * @date    2017年2月17日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface OperateLotteryDaoMapper {

	int findTotal(OperateLotteryVO vo);

	List<OperateLotteryBO> list(OperateLotteryVO vo);

	int mergeOperateLotteryInfo(OperateLotteryPO po);

	int addOperateLottery(OperateLotteryPO po);

	int updateOperateLottery(OperateLotteryPO po);

	String findMaxReleaseCode(@Param("releaseCodeLike")String releaseCodeLike);
	/**
	 * 查询数据是否冲突
	 * @param vo
	 * @return
	 */
	int findTimeRepeatTotal(OperateLotteryVO vo);

}
