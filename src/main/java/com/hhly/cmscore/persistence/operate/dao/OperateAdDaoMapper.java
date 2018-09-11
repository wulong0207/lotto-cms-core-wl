package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.operate.po.OperateAdPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateAdLottoBO;

/**
 * @desc    广告图管理
 * @author  Tony Wang
 * @date    2017年2月8日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface OperateAdDaoMapper {

	int findTotal(OperateAdVO vo);

	List<OperateAdBO> list(OperateAdVO vo);

	//int merge(OperateAdPO po);
	
	/**
	 * 查询广告信息返回给前台页面
	 * @param platform
	 * @return
	 */
	List<OperateAdLottoBO> findHomeOperAd(OperateAdVO vo);

	/**
	 * @desc   增加广告表记录
	 * @author Tony Wang
	 * @create 2017年4月6日
	 * @param po
	 * @return 
	 */
	int addAdv(OperateAdPO po);

	/**
	 * @desc   更新广告表记录
	 * @author Tony Wang
	 * @create 2017年4月6日
	 * @param po
	 * @return 
	 */
	int udpateAdv(OperateAdPO po);

	/**
	 * @desc   按用户广告对象添加广告用户表记录
	 * @author Tony Wang
	 * @create 2017年4月6日
	 * @param po
	 * @return 
	 
	int addAdvUserWithType(OperateAdPO po);*/

	/**
	 * @desc   按上传用户id添加广告用户表记录
	 * @author Tony Wang
	 * @create 2017年4月6日
	 * @param po
	 * @return 
	 
	int addAdvUserWithUserId(OperateAdPO po);*/

	/**
	 * @desc   按用户广告对象更新广告用户表记录
	 * @author Tony Wang
	 * @create 2017年4月6日
	 * @param po
	 * @return 
	 
	int udpateAdvUserWithType(OperateAdPO po);*/


	/**
	 * @desc   按上传用户id更新广告用户表记录
	 * @author Tony Wang
	 * @create 2017年4月6日
	 * @param po
	 * @return 
	 
	int udpateAdvUserWithUserId(OperateAdPO po);*/
	
	/**
	 * 查询默认广告信息
	 * @return
	 */
	List<OperateAdLottoBO> findDefaultAd(OperateAdVO vo);

	String findMaxAdvCode(@Param("advCodeLike")String advCodeLike);

}
