package com.hhly.cmscore.persistence.order.dao;

import com.hhly.cmscore.persistence.order.po.OrderFlowInfoPO;
import com.hhly.skeleton.lotto.base.order.bo.OrderFlowInfoBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author yuanshangbing
 * @version 1.0
 * @desc 订单流程
 * @date 2017/4/15 16:39
 * @company 益彩网络科技公司
 */
public interface OrderFlowInfoMapper {

	void insertOrderFlowInfo(OrderFlowInfoPO orderFlowInfoPO);

	/**
	 * 查询订单流程信息
	 * @param orderCode
	 * @param userId
	 * @return
	 */
	List<OrderFlowInfoBO> queryOrderFlowInfoList(@Param("orderCode")String orderCode,@Param("userId")Integer userId);


} 
