package com.hhly.cmscore.cms.remote.service.status.entity;

import java.util.Date;

/**
 * @desc 修改票状态
 * @author jiangwei
 * @date 2017年3月20日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class TicketStatusBO {
	//订单主键
	private int id;
	//票状态
	private int ticketStatus;
	//截止检票时间
	private Date endTicketTime;
	//批次号
	private String batchNum;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(int ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public Date getEndTicketTime() {
		return endTicketTime;
	}
	public void setEndTicketTime(Date endTicketTime) {
		this.endTicketTime = endTicketTime;
	}
	/**
	 * @return the batchNum
	 */
	public String getBatchNum() {
		return batchNum;
	}
	/**
	 * @param batchNum the batchNum to set
	 */
	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}
	
	
}
