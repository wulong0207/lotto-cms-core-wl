package com.hhly.cmscore.persistence.lottery.dao;

import java.util.List;

import com.hhly.cmscore.persistence.lottery.po.LotteryLimitInfoPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryLimitPO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryLimitBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryLimitInfoBO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryLimitInfoVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryLimitVO;
import com.hhly.skeleton.lotto.base.lottery.bo.LimitNumberDetailBO;
import com.hhly.skeleton.lotto.base.lottery.bo.LimitNumberInfoBO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotteryVO;

/**
 * @desc 彩种限号的数据接口
 * @author huangb
 * @date 2017年2月14日
 * @company 益彩网络
 * @version v1.0
 */
public interface LotteryLimitMapper {

	/**************************** Used to CMS ******************************/
	/**
	 * @desc 查询唯一的限号记录
	 * @author huangb
	 * @date 2017年2月14日
	 * @param lotteryLimitVO
	 *            参数对象
	 * @return 查询唯一的限号记录
	 */
	LotteryLimitBO findSingleLimit(LotteryLimitVO lotteryLimitVO);

	/**
	 * @desc 查询限号分页列表
	 * @author huangb
	 * @date 2017年2月14日
	 * @param lotteryLimitVO
	 *            参数对象
	 * @return 查询限号分页列表
	 */
	List<LotteryLimitBO> findPagingLimit(LotteryLimitVO lotteryLimitVO);

	/**
	 * @desc 查询限号记录数量
	 * @author huangb
	 * @date 2017年2月14日
	 * @param lotteryLimitVO
	 *            参数对象
	 * @return 查询限号记录数量
	 */
	int findCountLimit(LotteryLimitVO lotteryLimitVO);

	/**
	 * @desc 新增限号
	 * @author huangb
	 * @date 2017年2月14日
	 * @param lotteryLimitPO
	 *            参数对象
	 * @return 新增限号
	 */
	int addLimit(LotteryLimitPO lotteryLimitPO);

	/**
	 * @desc 修改限号
	 * @author huangb
	 * @date 2017年2月14日
	 * @param lotteryLimitPO
	 *            参数对象
	 * @return 修改限号
	 */
	int updLimit(LotteryLimitPO lotteryLimitPO);

	/************************* 以下是限号内容的操作 ***************************/
	/**
	 * @desc 查询唯一的限号内容记录
	 * @author huangb
	 * @date 2017年2月14日
	 * @param lotteryLimitInfoVO
	 *            参数对象
	 * @return 查询唯一的限号内容记录
	 */
	LotteryLimitInfoBO findSingleLimitInfo(LotteryLimitInfoVO lotteryLimitInfoVO);

	/**
	 * @desc 查询限号内容分页列表
	 * @author huangb
	 * @date 2017年2月14日
	 * @param lotteryLimitInfoVO
	 *            参数对象
	 * @return 查询限号内容分页列表
	 */
	List<LotteryLimitInfoBO> findPagingLimitInfo(LotteryLimitInfoVO lotteryLimitInfoVO);

	/**
	 * @desc 查询限号内容记录数量
	 * @author huangb
	 * @date 2017年2月14日
	 * @param lotteryLimitInfoVO
	 *            参数对象
	 * @return 查询限号内容记录数量
	 */
	int findCountLimitInfo(LotteryLimitInfoVO lotteryLimitInfoVO);

	/**
	 * @desc 新增限号内容
	 * @author huangb
	 * @date 2017年2月14日
	 * @param lotteryLimitInfoPO
	 *            参数对象
	 * @return 新增限号
	 */
	int addLimitInfo(LotteryLimitInfoPO lotteryLimitInfoPO);

	/**
	 * @desc 修改限号内容
	 * @author huangb
	 * @date 2017年2月14日
	 * @param lotteryLimitInfoPO
	 *            参数对象
	 * @return 修改限号
	 */
	int updLimitInfo(LotteryLimitInfoPO lotteryLimitInfoPO);

	/**
	 * @desc 保存限号内容（批量操作：包含新增和修改的动作）
	 * @author huangb
	 * @date 2017年2月16日
	 * @param list
	 *            新增或修改的集合列表
	 * @return 保存限号内容（批量操作：包含新增和修改的动作）
	 */
	int saveLimitInfo(List<LotteryLimitInfoPO> list);
	
	

	/**************************** Used to LOTTO ******************************/
	/**
	 * @desc 前端接口：查询单个限号信息(包含对应多个限号内容)
	 * @author huangb
	 * @date 2017年3月6日
	 * @param lotteryVO
	 *            参数对象
	 * @return 前端接口：查询单个限号信息(包含对应多个限号内容)
	 */
	LimitNumberInfoBO findSingleLimitFront(LotteryVO lotteryVO);

	/**
	 * @desc 前端接口：查询多个限号信息(包含对应多个限号内容)
	 * @author huangb
	 * @date 2017年3月6日
	 * @param lotteryVO
	 *            参数对象
	 * @return 前端接口：查询多个限号信息(包含对应多个限号内容)
	 */
	List<LimitNumberInfoBO> findMultipleLimitFront(LotteryVO lotteryVO);

	/**
	 * @desc   查询限号，根据参数只查询特定子玩法的限号信息
	 * @author Tony Wang
	 * @create 2017年3月28日
	 * @param vo
	 * @return 
	 */
	List<LimitNumberDetailBO> findMultipleLimitFrontByChild(LotteryVO vo);
}
