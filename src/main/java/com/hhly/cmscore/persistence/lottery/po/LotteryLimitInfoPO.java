package com.hhly.cmscore.persistence.lottery.po;

import com.hhly.skeleton.cms.lotterymgr.vo.LotteryLimitInfoVO;

/**
 * @desc 彩种限号内容
 * @author huangb
 * @date 2017年2月14日
 * @company 益彩网络
 * @version v1.0
 */
public class LotteryLimitInfoPO {
	/**
	 * 增长ID
	 */
	private Integer id;
	/**
	 * 限号表关联id
	 */
	private Integer limitId;
	/**
	 * 限号内容
	 */
	private String limitContent;
	/**
	 * 状态；；0：禁用；1：启用
	 */
	private Short status;
	/**
	 * 彩种子玩法关联id
	 */
	private Integer lotteryChildCode;

	public LotteryLimitInfoPO() {
	}

	/**
	 * 构造方法
	 * 
	 * @param lotteryLimitInfo
	 *            参数对象
	 */
	public LotteryLimitInfoPO(LotteryLimitInfoVO lotteryLimitInfo) {
		super();
		this.id = lotteryLimitInfo.getId();
		this.limitId = lotteryLimitInfo.getLimitId();
		this.limitContent = lotteryLimitInfo.getLimitContent();
		this.status = lotteryLimitInfo.getStatus();
		this.lotteryChildCode = lotteryLimitInfo.getLotteryChildCode();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLimitId() {
		return limitId;
	}

	public void setLimitId(Integer limitId) {
		this.limitId = limitId;
	}

	public String getLimitContent() {
		return limitContent;
	}

	public void setLimitContent(String limitContent) {
		this.limitContent = limitContent;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Integer getLotteryChildCode() {
		return lotteryChildCode;
	}

	public void setLotteryChildCode(Integer lotteryChildCode) {
		this.lotteryChildCode = lotteryChildCode;
	}

}
