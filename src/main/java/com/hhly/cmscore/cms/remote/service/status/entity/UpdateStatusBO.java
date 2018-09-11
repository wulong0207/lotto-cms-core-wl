package com.hhly.cmscore.cms.remote.service.status.entity;

import java.util.Date;

public class UpdateStatusBO {
	//订单主键
	private int id;
	//订单编号
	private String orderCode;
	//订单状态
	private int orderStatus;
	//订单截止出票时间
	private Date endTicketTime;
	//是否可以检票 0 不可以，1可以
	private int checkTicket;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getEndTicketTime() {
		return endTicketTime;
	}

	public void setEndTicketTime(Date endTicketTime) {
		this.endTicketTime = endTicketTime;
	}

	public int getCheckTicket() {
		return checkTicket;
	}

	public void setCheckTicket(int checkTicket) {
		this.checkTicket = checkTicket;
	}



}
