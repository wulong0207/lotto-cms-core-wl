package com.hhly.cmscore.cms.remote.service.status;

import org.springframework.util.Assert;

import com.hhly.cmscore.cms.remote.service.ITicketMgrService;
import com.hhly.cmscore.cms.remote.service.status.entity.UpdateStatusBO;
import com.hhly.skeleton.base.common.OrderEnum.OrderStatus;
import com.hhly.skeleton.base.common.TicketEnum.TicketStatus;
import com.hhly.skeleton.base.exception.ServiceRuntimeException;
import com.hhly.skeleton.base.status.AbstractVisitor;

/**
 * @desc 订单状态修改访问
 * @author jiangwei
 * @date 2017年3月14日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class UpdateOrderVisitor extends AbstractVisitor<Boolean,UpdateStatusBO,Integer> {
	/**
	 * 票服务
	 */
	private ITicketMgrService ticketService;
	
	public UpdateOrderVisitor(ITicketMgrService ticketService){
		this.ticketService = ticketService;
	}
	
	/**
	 * @see 待上传
	 */
	@Override
	public Boolean visitOne(UpdateStatusBO po, Integer update) {
		return Boolean.FALSE;
	}

	/**
	 * @see 待拆票
	 */
	@Override
	public Boolean visitTwo(UpdateStatusBO po, Integer update) {
		//可改为出票失败
		return failingTicket(po, update);
	}
	
	/** 
	 * @see 拆票中
	 */
	@Override
	public Boolean visitThree(UpdateStatusBO po, Integer update) {
		//可改为出票失败
		return failingTicket(po, update);
	}
	/** 
	 * @see 待出票
	 */
	@Override
	public Boolean visitFour(UpdateStatusBO po, Integer update) {
		return Boolean.FALSE;
	}

	/**
	 * @see 出票中
	 */
	@Override
	public Boolean visitFive(UpdateStatusBO po, Integer update) {
		if (update.intValue() == OrderStatus.FAILING_TICKET.getValue()) {
			int num = ticketService.countTicketStatus(po.getOrderCode(),TicketStatus.OUT_FAIL.getValue());
			if(num == 0){
				throw new ServiceRuntimeException(po.getOrderCode()+"不存在出票失败的票，不能修改订单出票状态");
			}
			return Boolean.TRUE;
		}
		//可改为出票失败
		return Boolean.FALSE;
	}
	/**
	 * @see 已出票
	 */
	@Override
	public Boolean visitSix(UpdateStatusBO po, Integer update) {
		return Boolean.FALSE;
	}
	/**
	 * @see 出票失败
	 */
	@Override
	public Boolean visitSeven(UpdateStatusBO po, Integer update) {
		return Boolean.FALSE;
	}
	/**
	 * @see 已撤单
	 */
	@Override
	public Boolean visitEight(UpdateStatusBO po, Integer update) {
		return Boolean.FALSE;
	}
	/**
	 * @see 拆票失败
	 */
	@Override
	public Boolean visitNine(UpdateStatusBO po, Integer update) {
		//可改为出票失败
		Boolean fail =  failingTicket(po, update);
		if(fail){
			return fail;
		}
		//待拆票（官方截止销售前）
		if (update.intValue() == OrderStatus.WAITING_SPLIT_TICKET.getValue() 
				&& po.getEndTicketTime().getTime() > System.currentTimeMillis()) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	/**
	 * 修改为出票失败状态
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年3月14日 下午5:20:35
	 * @param po
	 * @param update
	 * @return
	 */
	private Boolean failingTicket(UpdateStatusBO po, Integer update) {
		Assert.notNull(po.getEndTicketTime(),"订单彩期截止销售时间有误！");
		//“出票失败”,订单本站截止销售时间后修改
		if (update.intValue() == OrderStatus.FAILING_TICKET.getValue()
				&& po.getEndTicketTime().getTime() < System.currentTimeMillis()) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
}
