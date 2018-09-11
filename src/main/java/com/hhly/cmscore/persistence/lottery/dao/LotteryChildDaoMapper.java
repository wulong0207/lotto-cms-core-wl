package com.hhly.cmscore.persistence.lottery.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.lottery.po.LotteryChildPO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryChildBO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryChildCmsVO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotChildBO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotChildVO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotteryVO;

public interface LotteryChildDaoMapper {

	/**************************** Used to CMS ******************************/
	List<LotteryChildBO> findByCode(@Param("code") String code);

	int add(LotteryChildPO po);

	int updByPrimaryKey(LotteryChildPO po);

	int delByPrimaryKeyList(@Param("ids") List<String> ids);

	/**
	 * @desc 查询多条数据记录（列表）(CMS用)
	 * @author huangb
	 * @date 2017年1月19日
	 * @param lotteryChildCmsVO
	 *            参数对象
	 * @return 多个查询对象（列表）
	 */
	List<LotteryChildBO> findMultipleCms(LotteryChildCmsVO lotteryChildCmsVO);

	/**
	 * 查询子玩法
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017-2-6 下午6:17:10
	 * @param loadCode
	 * @return
	 */
	List<LotteryChildBO> listChildCodeName(@Param("codes") Collection<String> loadCode);

	/**************************** Used to LOTTO ******************************/

	/**
	 * @desc 前端接口：查询单条子玩法配置
	 * @author huangb
	 * @date 2017年3月7日
	 * @param lotChildVO
	 *            参数对象
	 * @return 前端接口：查询单条子玩法配置
	 */
	LotChildBO findSingleFront(LotChildVO lotChildVO);

	/**
	 * @desc 前端接口：查询多条子玩法配置
	 * @author huangb
	 * @date 2017年3月7日
	 * @param lotteryVO
	 *            参数对象
	 * @return 前端接口：查询多条子玩法配置
	 */
	List<LotChildBO> findMultipleFront(LotteryVO lotteryVO);

	/**
	 * @desc   查询符合条件的子玩法记录数
	 * @author Tony Wang
	 * @create 2017年4月10日
	 * @param vo
	 * @return 
	 */
	int count(LotChildVO vo);
}