package com.hhly.cmscore.persistence.lottery.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.lottery.po.LotteryBettingMulPO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryBettingMulBO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotBettingMulBO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotteryBettingMulVO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotteryVO;

public interface LotteryBettingMulDaoMapper {

	/**************************** Used to CMS ******************************/
	List<LotteryBettingMulBO> findByCode(@Param("code") String code);

	int add(LotteryBettingMulPO po);

	int updByPrimaryKey(LotteryBettingMulPO po);

	int delByPrimaryKeyList(@Param("ids") List<String> ids);

	/**
	 * 根据条件查询一条配置记录，如 1.根据彩种和倒计时，查询最接近的倍数注数配置对象 2.根据彩种查询最大的配置
	 * 
	 * @param lotteryBettingMulVO
	 * @return
	 */
	LotteryBettingMulBO findSingle(LotteryBettingMulVO lotteryBettingMulVO);

	/**
	 * 查询注数和倍数截配置中最小截止时间
	 * 
	 * @param lotteryBettingMulVO
	 * @return
	 */
	Long findMinEndTime(LotteryBettingMulVO lotteryBettingMulVO);

	
	
	/**************************** Used to LOTTO ******************************/
	/**
	 * @desc 前端接口：查询多条彩种注、倍数配置
	 * @author huangb
	 * @date 2017年3月7日
	 * @param lotteryVO
	 *            参数对象
	 * @return 前端接口：查询多条彩种注、倍数配置
	 */
	List<LotBettingMulBO> findMultipleFront(LotteryVO lotteryVO);
	

}