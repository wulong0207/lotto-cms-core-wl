package com.hhly.cmscore.persistence.payment.po;

import com.hhly.skeleton.cms.payment.vo.PayBankLimitVO;

/**
 * @desc 银行支付限额表
 * @author tangxiaobo
 * @date 2017年3月9日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class PayBankLimitPO {
	private Integer id;
	/**
	 * 银行ID
	 */
	private Integer bankid;
	/**
	 * 单笔限额(元)
	 */
	private String limittime;
	/**
	 * 每日限额(元)
	 */
	private String limitday;
	/**
	 * 每月限额(元)
	 */
	private String limitmonth;
	/**
	 * 限额需要满足的条件
	 */
	private String condition;
	/**
	 * 备注
	 */
	private String remark;
	
	private Integer cardType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBankid() {
		return bankid;
	}

	public void setBankid(Integer bankid) {
		this.bankid = bankid;
	}

	public String getLimittime() {
		return limittime;
	}

	public void setLimittime(String limittime) {
		this.limittime = limittime;
	}

	public String getLimitday() {
		return limitday;
	}

	public void setLimitday(String limitday) {
		this.limitday = limitday;
	}

	public String getLimitmonth() {
		return limitmonth;
	}

	public void setLimitmonth(String limitmonth) {
		this.limitmonth = limitmonth;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	
	
	public PayBankLimitPO() {
		super();
	}

	public PayBankLimitPO(PayBankLimitVO vo) {
		super();
		this.id = vo.getId();
		this.bankid = vo.getBankid();
		this.limittime = vo.getLimittime();
		this.limitday = vo.getLimitday();
		this.limitmonth = vo.getLimitmonth();
		this.condition = vo.getCondition();
		this.remark = vo.getRemark();
		this.cardType=vo.getCardType();
	}

}