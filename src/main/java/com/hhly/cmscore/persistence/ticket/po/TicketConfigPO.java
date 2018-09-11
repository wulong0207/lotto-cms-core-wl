package com.hhly.cmscore.persistence.ticket.po;

import java.util.Date;

import com.hhly.skeleton.cms.ticketmgr.vo.TicketConfigVO;

public class TicketConfigPO {
	private Integer id;

	private String ticketChannelId;

	private Integer lotteryCode;

	private Short sendStatus;

	private String preBatch;

	private String preTicket;

	private Short sendWeight;

	private Short sendEachBatch;

	private Short threadCount;

	private Short searchAuto;

	private String searchIdent;

	private Short searchMaxTicket;

	private String endSendSpace;

	private String allowSendTime;

	private String stopLottery;
	
	private Integer dealerEndTime;

	private String remark;

	private String createBy;

	private String modifyBy;

	private Date modifyTime;

	private Date updateTime;

	private Date createTime;
	
	private Integer startMoney;
	
	private Integer endMoeny;

	public TicketConfigPO() {
	}

	public TicketConfigPO(TicketConfigVO vo) {
		this.id = vo.getId();
		this.ticketChannelId = vo.getTicketChannelId();
		this.lotteryCode = vo.getLotteryCode();
		this.sendStatus = vo.getSendStatus();
		this.preBatch = vo.getPreBatch();
		this.preTicket = vo.getPreTicket();
		this.sendWeight = vo.getSendWeight();
		this.sendEachBatch = vo.getSendEachBatch();
		this.threadCount = vo.getThreadCount();
		this.searchAuto = vo.getSearchAuto();
		this.searchIdent = vo.getSearchIdent();
		this.searchMaxTicket = vo.getSearchMaxTicket();
		this.endSendSpace = vo.getEndSendSpace();
		this.allowSendTime = vo.getAllowSendTime();
		this.stopLottery = vo.getStopLottery();
		this.remark = vo.getRemark();
		this.createBy = vo.getCreateBy();
		this.modifyBy = vo.getModifyBy();
		this.modifyTime = vo.getModifyTime();
		this.updateTime = vo.getUpdateTime();
		this.createTime = vo.getCreateTime();
		this.dealerEndTime = vo.getDealerEndTime();
		this.startMoney = vo.getStartMoney();
		this.endMoeny = vo.getEndMoeny();
	}

	public Integer getStartMoney() {
		return startMoney;
	}

	public void setStartMoney(Integer startMoney) {
		this.startMoney = startMoney;
	}


	public Integer getEndMoeny() {
		return endMoeny;
	}

	public void setEndMoeny(Integer endMoeny) {
		this.endMoeny = endMoeny;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTicketChannelId() {
		return ticketChannelId;
	}

	public void setTicketChannelId(String ticketChannelId) {
		this.ticketChannelId = ticketChannelId;
	}

	public Integer getLotteryCode() {
		return lotteryCode;
	}

	public void setLotteryCode(Integer lotteryCode) {
		this.lotteryCode = lotteryCode;
	}

	public Short getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(Short sendStatus) {
		this.sendStatus = sendStatus;
	}

	public String getPreBatch() {
		return preBatch;
	}

	public void setPreBatch(String preBatch) {
		this.preBatch = preBatch;
	}

	public String getPreTicket() {
		return preTicket;
	}

	public void setPreTicket(String preTicket) {
		this.preTicket = preTicket;
	}

	public Short getSendWeight() {
		return sendWeight;
	}

	public void setSendWeight(Short sendWeight) {
		this.sendWeight = sendWeight;
	}

	public Short getSendEachBatch() {
		return sendEachBatch;
	}

	public void setSendEachBatch(Short sendEachBatch) {
		this.sendEachBatch = sendEachBatch;
	}

	public Short getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(Short threadCount) {
		this.threadCount = threadCount;
	}

	public Short getSearchAuto() {
		return searchAuto;
	}

	public void setSearchAuto(Short searchAuto) {
		this.searchAuto = searchAuto;
	}

	public String getSearchIdent() {
		return searchIdent;
	}

	public void setSearchIdent(String searchIdent) {
		this.searchIdent = searchIdent;
	}

	public Short getSearchMaxTicket() {
		return searchMaxTicket;
	}

	public void setSearchMaxTicket(Short searchMaxTicket) {
		this.searchMaxTicket = searchMaxTicket;
	}

	public String getAllowSendTime() {
		return allowSendTime;
	}

	public void setAllowSendTime(String allowSendTime) {
		this.allowSendTime = allowSendTime;
	}

	public String getStopLottery() {
		return stopLottery;
	}

	public void setStopLottery(String stopLottery) {
		this.stopLottery = stopLottery;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEndSendSpace() {
		return endSendSpace;
	}

	public void setEndSendSpace(String endSendSpace) {
		this.endSendSpace = endSendSpace;
	}

	/**
	 * @return the dealerEndTime
	 */
	public Integer getDealerEndTime() {
		return dealerEndTime;
	}

	/**
	 * @param dealerEndTime the dealerEndTime to set
	 */
	public void setDealerEndTime(Integer dealerEndTime) {
		this.dealerEndTime = dealerEndTime;
	}

	

}