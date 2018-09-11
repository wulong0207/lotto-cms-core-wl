package com.hhly.cmscore.cms.remote.service.status;

import com.hhly.cmscore.cms.remote.service.status.entity.TicketStatusBO;
import com.hhly.skeleton.base.status.AbstractVisitor;

/**
 * @desc 票操作
 * @author jiangwei
 * @date 2017年3月21日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class TicketOperateVisitor extends AbstractVisitor<Boolean, TicketStatusBO,String> {
	/**
	 * 重新送票
	 */
    private  final String UPDATE_SEND = "3";
    /**
     * 重查出票
     */
    private  final String UPDATE_OUT = "4";
    /**
     * 切换出票商
     */
    private  final String UPDATE_DEALER = "5";
    
	/**
	 * @see 出票失败
	 */
	@Override
	public Boolean visitNegativeTwo(TicketStatusBO po, String update) {
		if(UPDATE_OUT.equals(update)
				&& po.getEndTicketTime().getTime() > System.currentTimeMillis()){
			return Boolean.TRUE;
		}else if(UPDATE_DEALER.equals(update)
				&& po.getEndTicketTime().getTime() > System.currentTimeMillis()){
			return Boolean.TRUE;
		}else if(UPDATE_SEND.equals(update)
				&& po.getEndTicketTime().getTime() > System.currentTimeMillis()){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * @see 送票失败
	 */
	@Override
	public Boolean visitNegativeOne(TicketStatusBO po, String update) {
		if(UPDATE_DEALER.equals(update)
				&& po.getEndTicketTime().getTime() > System.currentTimeMillis()){
			return Boolean.TRUE;
		}else if(UPDATE_SEND.equals(update)
				&& po.getEndTicketTime().getTime() > System.currentTimeMillis()){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * @see 不出票
	 */
	@Override
	public Boolean visitZero(TicketStatusBO po, String update) {
		return Boolean.FALSE;
	}

	/**
	 * @see 待分配
	 */
	@Override
	public Boolean visitOne(TicketStatusBO po, String update) {
		if(UPDATE_SEND.equals(update)
				&& po.getEndTicketTime().getTime() > System.currentTimeMillis()){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * @see 已分配
	 */
	@Override
	public Boolean visitTwo(TicketStatusBO po, String update) {
		if(UPDATE_DEALER.equals(update)
				&& po.getEndTicketTime().getTime() > System.currentTimeMillis()){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * @see 已送票
	 */
	@Override
	public Boolean visitThree(TicketStatusBO po, String update) {
		if(UPDATE_OUT.equals(update)
				&& po.getEndTicketTime().getTime() > System.currentTimeMillis()){
			return Boolean.TRUE;
		}else if(UPDATE_DEALER.equals(update)
				&& po.getEndTicketTime().getTime() > System.currentTimeMillis()){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * @see 已出票
	 */
	@Override
	public Boolean visitFour(TicketStatusBO po, String update) {
		return Boolean.FALSE;
	}

}
