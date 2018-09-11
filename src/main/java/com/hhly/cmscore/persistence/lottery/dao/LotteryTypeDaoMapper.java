package com.hhly.cmscore.persistence.lottery.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.lottery.po.LotteryTypePO;
import com.hhly.skeleton.base.issue.entity.NewTypeBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryTypeBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryTypeExcelBO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryTypeVO;
import com.hhly.skeleton.lotto.base.lottery.bo.LotteryBO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotteryVO;

/**
 * @desc 彩种相关的数据接口
 * @author huangb
 * @date 2017年3月2日
 * @company 益彩网络
 * @version v1.0
 */
public interface LotteryTypeDaoMapper {

	/**************************** Used to CMS ********************************/
	/**
	 * 分页查询
	 * 
	 * @param vo
	 * @return
	 */
	List<LotteryTypeBO> find(LotteryTypeVO vo);

	/**
	 * 分页查询总条数
	 * 
	 * @param vo
	 * @return
	 */
	int findTotal(LotteryTypeVO vo);

	/**
	 * 修改彩期（彩种编号，彩种名不能修改）
	 * 
	 * @param po
	 * @return
	 */
	int updLotteryTypeByKey(LotteryTypePO po);

	List<LotteryTypeExcelBO> findLotteryTypeToExcel(LotteryTypeVO vo);

	/**
	 * 查询改彩种是否存在
	 * 
	 * @param code
	 * @return
	 */
	int findCountCode(@Param("code") Integer code);

	int add(LotteryTypePO po);

	LotteryTypePO findLotteryTypeByKey(@Param("id") Integer lotteryId);

	/**
	 * 查询信息检查彩种信息变化
	 * 
	 * @param lotteryId
	 * @return
	 */
	LotteryTypePO findLotteryTypeCheck(@Param("id") Integer lotteryId);

	/**
	 * @param lotteryTypeVO
	 *            参数对象
	 * @return 单个查询对象
	 * @desc 查询唯一的数据记录
	 */
	LotteryTypeBO findSingle(LotteryTypeVO lotteryTypeVO);

	/**
	 * 根据彩种类型查询彩期名和编码
	 * 
	 * @param category
	 * @return
	 */
	List<LotteryTypeBO> findLotteryTypeDic(@Param("lotteryCategory") String category);
	/**
	 * 根据彩种ID彩种名称
	 * 
	 * @param ids
	 * @return
	 */
	List<LotteryTypeBO> findLotteryName(@Param("ids") List<String> ids);

	/**************************** Used to LOTTO ******************************/
	/**
	 * @desc 前端接口：查询单个彩种信息
	 * @author huangb
	 * @date 2017年3月6日
	 * @param lotteryVO
	 *            参数对象
	 * @return 前端接口：查询单个彩种信息
	 */
	LotteryBO findSingleFront(LotteryVO lotteryVO);
	/**
	 * 查询所有大彩种信息
	 * @author longguoyou
	 * @date 2017年3月22日
	 * @param lotteryVO
	 * @return
	 */
	List<LotteryBO> findMultipleFront(LotteryVO lotteryVO);
    /**
     * 查询彩种信息用于生成彩期
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017年3月8日 下午3:40:44
     * @param lotteryCode
     * @return
     */
	NewTypeBO findTypeUseAddIssue(@Param("lotteryCode")int lotteryCode);
	
	/**
	 * 查询彩种信息
	 * @return
	 */
	List<LotteryTypeBO> findAllLotteryType();
	
	/**
	 * 查询数字彩和胜负彩信息
	 * @return
	 */
	List<LotteryTypeBO> findLFLottery();
	
	/**
	 * 查询彩种下拉或筛选彩种集合
	 * @return
	 * @date 2017年9月23日上午10:43:51
	 * @author cheng.chen
	 */
	List<LotteryBO> queryLotterySelectList(LotteryVO vo);
}