package com.hhly.cmscore.cms.remote.service.status;

import com.hhly.skeleton.base.status.AbstractVisitor;

/**
 * @desc 彩种彩期状态修改检查(彩期状态修改时候)
 * @author jiangwei
 * @date 2017年4月17日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class IssueCheckVisitor extends AbstractVisitor<Boolean,Object,Integer>{
	/**
	 * @see "暂停销售","未开售", "预售中", "销售中" 可以相互切换
	 */
	@Override
	public Boolean visitZero(Object po, Integer update) {
		return update <= 4;
	}
	/**
	 * @see "暂停销售","未开售", "预售中", "销售中" 可以相互切换
	 */
	@Override
	public Boolean visitOne(Object po, Integer update) {
		return update <= 4;
	}
	/**
	 * @see "暂停销售","未开售", "预售中", "销售中" 可以相互切换
	 */
	@Override
	public Boolean visitTwo(Object po, Integer update) {
		return update <= 4;
	}
	/**
	 * @see "暂停销售","未开售", "预售中", "销售中" 可以相互切换
	 */
	@Override
	public Boolean visitThree(Object po, Integer update) {
		return update <= 4;
	}
    /**
     * @see 销售截止 可改为 "销售截止","已审核","已开奖","已派奖"
     */
	@Override
	public Boolean visitFour(Object po, Integer update) {
		return update == 4 || update == 5 || update == 6 || update == 7;
	}
	/**
	 * @see 已开奖 可改为  已开奖，已派奖
	 */
	@Override
	public Boolean visitFive(Object po, Integer update) {
		return update == 5 || update == 6;
	}
    /**
     * @see 已派奖 可以改为 已派奖
     */
	@Override
	public Boolean visitSix(Object po, Integer update) {
		return update == 6;
	}
    /**
     * @see 已审核 可改为 已审核，已开奖，已派奖
     */
	@Override
	public Boolean visitSeven(Object po, Integer update) {
		return update == 5 || update == 6 || update == 7;
	}
	

}
