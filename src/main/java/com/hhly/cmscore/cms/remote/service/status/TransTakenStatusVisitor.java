package com.hhly.cmscore.cms.remote.service.status;

import java.util.Objects;

import com.hhly.skeleton.base.common.TransEnum.TakenStatus;
import com.hhly.skeleton.base.status.AbstractVisitor;
import com.hhly.skeleton.cms.transmgr.vo.TransTakenVO;

public class TransTakenStatusVisitor extends AbstractVisitor<Boolean, TransTakenVO, Integer> {

	// 1审核通过; 2审核不通过; 3银行处理成功; 4银行处理失败; 5已到帐;6待审核;7银行处理中
	/*
	 * 提款共有7种状态：
	 * 1审核通过 :			(通过：N 驳回:N 处理提款:Y 已处理提款:N)
	 * 2审核不通过：		(通过：N 驳回:N 处理提款:N 已处理提款:N)
	 * 3银行处理成功：		(通过：N 驳回:N 处理提款:N 已处理提款:N)
	 * 4银行处理失败:		(通过：N 驳回:N 处理提款:N 已处理提款:N)
	 * 5已到帐:			(通过：N 驳回:N 处理提款:N 已处理提款:N)
	 * 6待审核:			(通过：Y 驳回:Y 处理提款:N 已处理提款:N)
	 * 7银行处理中:			(通过：N 驳回:N 处理提款:N 已处理提款:Y)
	 */
	/*
	 * 1）用户发起提款请求时即冻结该笔资金
	 * 2）只有针对待审核的请求进行审核
	 * 3）审核后标识订单交易状态为审核通过或审核不通过，审核不通过需标注失败原因
	 */
	@Override
	public Boolean visitOne(TransTakenVO po, Integer update) {
		return Objects.equals(update, TakenStatus.BANK_PROCESSING.getValue());
	}

	@Override
	public Boolean visitTwo(TransTakenVO po, Integer update) {
		return false;
	}

	@Override
	public Boolean visitThree(TransTakenVO po, Integer update) {
		return false;
	}

	@Override
	public Boolean visitFour(TransTakenVO po, Integer update) {
		return false;
	}

	@Override
	public Boolean visitFive(TransTakenVO po, Integer update) {
		return false;
	}

	@Override
	public Boolean visitSix(TransTakenVO po, Integer update) {
		return (Objects.equals(update, TakenStatus.PASS.getValue())
				||Objects.equals(update, TakenStatus.REJECT.getValue()));
	}

	@Override
	public Boolean visitSeven(TransTakenVO po, Integer update) {
		return (Objects.equals(update, TakenStatus.BANK_SUCCESS.getValue())
				||Objects.equals(update, TakenStatus.BANK_FAIL.getValue()));
	}
}
