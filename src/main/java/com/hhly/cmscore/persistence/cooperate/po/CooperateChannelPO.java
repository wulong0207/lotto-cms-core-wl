package com.hhly.cmscore.persistence.cooperate.po;

import com.hhly.skeleton.cms.cooperate.vo.CooperateChannelVO;

import java.util.Date;

public class CooperateChannelPO {
	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 商户渠道名称
	 */
	private String cooperateName;

	/**
	 * 账户余额
	 */
	private Double balance;

	/**
	 * 单笔充值限额
	 */
	private Double singleRechargeAmount;

	/**
	 * 充值类型
	 */
	private Short rechargeType;

	/**
	 * 商户渠道id
	 */
	private String marketChannelId;

	/**
	 * 出票渠道;1,福彩积分兑换;2,体彩积分兑换
	 */
	private String ticketChannel;

	/**
	 * 操作时间
	 */
	private Date actionTime;

	/**
	 * 合作开始时间
	 */
	private Date cooperateBeginTime;

	/**
	 * 合作结束时间
	 */
	private Date cooperateEndTime;

	/**
	 * 是否启动，0,启动;1,停止
	 */
	private Integer isStop;

	/**
	 * 创建人
	 */
	private String createBy;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改人
	 */
	private String modifyBy;

	/**
	 * 修改时间
	 */
	private Date modifyTime;

	/**
	 * 渠道密码
	 */
	private String key;

	/**
	 * 结算类型
	 */
	private Integer settlementType;

	/**
	 * 商户类型
	 */
	private Integer type;

	/**
	 * 登录密码
	 */
	private String password;

	/**
	 * 盐值
	 */
	private String rcode;

	public CooperateChannelPO() {
	}

	public CooperateChannelPO(CooperateChannelVO vo) {
		this.id = vo.getId();
		this.cooperateName = vo.getCooperateName();
		this.balance = vo.getBalance();
		this.singleRechargeAmount = vo.getSingleRechargeAmount();
		this.rechargeType = vo.getRechargeType();
		this.marketChannelId = vo.getMarketChannelId();
		this.ticketChannel = vo.getTicketChannel();
		this.actionTime = vo.getActionTime();
		this.cooperateBeginTime = vo.getCooperateBeginTime();
		this.cooperateEndTime = vo.getCooperateEndTime();
		this.key = vo.getKey();
		this.settlementType = vo.getSettlementType();
		this.isStop = vo.getIsStop();
		this.type = vo.getType();
		this.password = vo.getPassword();
		this.createBy = vo.getCreateBy();
		this.modifyBy = vo.getModifyBy();
		this.rcode = vo.getRcode();
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSettlementType() {
		return settlementType;
	}

	public void setSettlementType(Integer settlementType) {
		this.settlementType = settlementType;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMarketChannelId() {
		return marketChannelId;
	}

	public void setMarketChannelId(String marketChannelId) {
		this.marketChannelId = marketChannelId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCooperateName() {
		return cooperateName;
	}

	public void setCooperateName(String cooperateName) {
		this.cooperateName = cooperateName == null ? null : cooperateName.trim();
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getSingleRechargeAmount() {
		return singleRechargeAmount;
	}

	public void setSingleRechargeAmount(Double singleRechargeAmount) {
		this.singleRechargeAmount = singleRechargeAmount;
	}

	public Short getRechargeType() {
		return rechargeType;
	}

	public void setRechargeType(Short rechargeType) {
		this.rechargeType = rechargeType;
	}

	public String getTicketChannel() {
		return ticketChannel;
	}

	public void setTicketChannel(String ticketChannel) {
		this.ticketChannel = ticketChannel == null ? null : ticketChannel.trim();
	}

	public Date getActionTime() {
		return actionTime;
	}

	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}

	public Date getCooperateBeginTime() {
		return cooperateBeginTime;
	}

	public void setCooperateBeginTime(Date cooperateBeginTime) {
		this.cooperateBeginTime = cooperateBeginTime;
	}

	public Date getCooperateEndTime() {
		return cooperateEndTime;
	}

	public void setCooperateEndTime(Date cooperateEndTime) {
		this.cooperateEndTime = cooperateEndTime;
	}

	public Integer getIsStop() {
		return isStop;
	}

	public void setIsStop(Integer isStop) {
		this.isStop = isStop;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy == null ? null : modifyBy.trim();
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}