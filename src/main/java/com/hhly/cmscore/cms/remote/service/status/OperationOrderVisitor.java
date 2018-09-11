package com.hhly.cmscore.cms.remote.service.status;

import com.hhly.cmscore.cms.remote.service.status.entity.UpdateStatusBO;
import com.hhly.cmscore.cms.remote.service.status.operate.IOrderOperation;
import com.hhly.cmscore.cms.remote.service.status.operate.OperationOrderEnum;
import com.hhly.skeleton.base.status.AbstractVisitor;

/**
 * @desc 订单状态操作
 * @author jiangwei
 * @date 2017年3月15日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class OperationOrderVisitor
		extends AbstractVisitor<Boolean, UpdateStatusBO,OperationOrderEnum> {

	private IOrderOperation operation;

	public OperationOrderVisitor(IOrderOperation operation) {
		this.operation = operation;
	}
    
	/**
	 * @see 待上传
	 */
	@Override
	public Boolean visitOne(UpdateStatusBO po, OperationOrderEnum update) {
		return Boolean.FALSE;
	}
	/**
	 * see待拆票
	 */
	@Override
	public Boolean visitTwo(UpdateStatusBO po, OperationOrderEnum update) {
		return Boolean.FALSE;
	}
	
	/** 
	 * @see 拆票中
	 */
	@Override
	public Boolean visitThree(UpdateStatusBO po, OperationOrderEnum update) {
		return Boolean.FALSE;
	}

	/** 
	 * @see 待出票
	 */
	@Override
	public Boolean visitFour(UpdateStatusBO po, OperationOrderEnum update) {
		return Boolean.FALSE;
	}
	/**
	 * @see 出票中
	 */
	@Override
	public Boolean visitFive(UpdateStatusBO po, OperationOrderEnum update) {
		// 出票中订单可以执行检查方案 和 禁止检查方案
		switch (update) {
		case CHECK:
		case FORBID:
			return update.execute(po, operation);
		default:
			break;
		}
		return Boolean.FALSE;
	}
	/**
	 * @see 已出票
	 */
	@Override
	public Boolean visitSix(UpdateStatusBO po, OperationOrderEnum update) {
		return Boolean.FALSE;
	}
	/**
	 * @see 出票失败
	 */
	@Override
	public Boolean visitSeven(UpdateStatusBO po, OperationOrderEnum update) {
		// 出票失败订单可以执行 检查方案 ， 禁止检查方案 和 撤单
		switch (update) {
		case CHECK:
		case FORBID:
		case REVOKE:
			return update.execute(po, operation);
		default:
			break;
		}
		return Boolean.FALSE;
	}
	/**
	 * @see 已撤单
	 */
	@Override
	public Boolean visitEight(UpdateStatusBO po, OperationOrderEnum update) {
		switch (update) {
		case REVOKE:
			return update.execute(po, operation);
		default:
			break;
		}
		return Boolean.FALSE;
	}
	/**
	 * @see 拆票失败
	 */
	@Override
	public Boolean visitNine(UpdateStatusBO po, OperationOrderEnum update) {
		return Boolean.FALSE;
	}
}
