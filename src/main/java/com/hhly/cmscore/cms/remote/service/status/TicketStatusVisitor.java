package com.hhly.cmscore.cms.remote.service.status;

import java.util.Objects;

import com.hhly.cmscore.cms.remote.service.status.entity.TicketStatusBO;
import com.hhly.skeleton.base.common.TicketEnum.TicketStatus;
import com.hhly.skeleton.base.status.AbstractVisitor;

/**
 * @desc 票状态修改
 * @author jiangwei
 * @date 2017年3月20日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class TicketStatusVisitor extends AbstractVisitor<Boolean, TicketStatusBO, Integer> {
	/**
	 * @see 出票失败
	 */
	@Override
	public Boolean visitNegativeTwo(TicketStatusBO po, Integer update) {
		if (Objects.equals(update, TicketStatus.OUT_TICKET.getValue())) {
			// 可修改为“已出票”
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * @see 送票失败
	 */
	@Override
	public Boolean visitNegativeOne(TicketStatusBO po, Integer update) {
		if (Objects.equals(update, TicketStatus.OUT_FAIL.getValue())) {
			// 可修改为“出票失败”
			return Boolean.TRUE;
		} else if (Objects.equals(update, TicketStatus.OUT_TICKET.getValue())) {
			// 可修改为“已出票”
			return Boolean.TRUE;
		} else if (Objects.equals(update, TicketStatus.SEND_TICKET.getValue())) {
			// 可修改为“已送票”
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * @see 不出票
	 */
	@Override
	public Boolean visitZero(TicketStatusBO po, Integer update) {
		return Boolean.FALSE;
	}

	/**
	 * @see 待分配
	 */
	@Override
	public Boolean visitOne(TicketStatusBO po, Integer update) {
		// 可修改为“出票失败”节点：官方截止销售时间
		if (Objects.equals(update, TicketStatus.OUT_FAIL.getValue())) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * @see 已分配
	 */
	@Override
	public Boolean visitTwo(TicketStatusBO po, Integer update) {
		// 可修改为“出票失败”节点：官方截止销售时间
		if (Objects.equals(update, TicketStatus.OUT_FAIL.getValue())) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * @see 已送票
	 */
	@Override
	public Boolean visitThree(TicketStatusBO po, Integer update) {
		// 可修改为“出票失败”
		if (Objects.equals(update, TicketStatus.OUT_FAIL.getValue())) {
			return Boolean.TRUE;
		} else if (Objects.equals(update, TicketStatus.OUT_TICKET.getValue())) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * @see 已出票
	 */
	@Override
	public Boolean visitFour(TicketStatusBO po, Integer update) {
		return Boolean.FALSE;
	}

}
