package com.hhly.cmscore.cms.remote.service.status.operate;

import com.hhly.cmscore.cms.remote.service.status.entity.UpdateStatusBO;
import com.hhly.cmscore.persistence.order.dao.OrderInfoDaoMapper;
import com.hhly.skeleton.base.exception.ServiceRuntimeException;

public class OrderOperattion implements IOrderOperation {
	
	private OrderInfoDaoMapper orderInfoDaoMapper;
	
	private  String modifyBy;
	
	public OrderOperattion(OrderInfoDaoMapper orderInfoDaoMapper,String modifyBy){
		this.orderInfoDaoMapper = orderInfoDaoMapper;
		this.modifyBy = modifyBy;
	}
	@Override
	public void ckeckOrder(UpdateStatusBO po) {
		if(po.getCheckTicket() == 1){
			System.out.println("执行检票操作订单："+po.getOrderCode());
			throw new ServiceRuntimeException("执行检票操作订单，但是该流程还未实现");
		}
	}

	@Override
	public void forbidCkeckOrder(UpdateStatusBO po) {
		//如果订单是检票状态修改订单状态为不能检票
		if(po.getCheckTicket() == 1){
			orderInfoDaoMapper.updateCheckTicket(po.getId(),0,modifyBy);
		}
		throw new ServiceRuntimeException("不检票逻辑未实现");
	}
	@Override
	public void revoke(UpdateStatusBO po) {
		System.out.println("执行撤单操作："+po.getOrderCode());
		throw new ServiceRuntimeException("执行撤单操作，但是该流程还未实现");
	}
}
