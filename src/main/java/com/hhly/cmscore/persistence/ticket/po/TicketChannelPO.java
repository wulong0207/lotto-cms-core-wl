package com.hhly.cmscore.persistence.ticket.po;

import java.util.Date;

import com.hhly.skeleton.cms.ticketmgr.vo.TicketChannelVO;
/**
 * 
 * @desc 出票渠道
 * @author jiangwei
 * @date 2017-2-5
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class TicketChannelPO {
    private Integer id;

    private String ticketChannelId;

    private String drawerName;

    private String drawerAccount;

    private String accountPassword;

    private String authCode;

    private String sendUrl;

    private String searchUrl;

    private String searchUrlSpare;

    private String noticeUrl;

    private Integer accountBalance;

    private String modifyBy;

    private Date updateTime;

    private Date createTime;

    private String remark;
    
    private String createBy;
    
    private Short channelStatus;
    
    private Short lotteryStatus;
    
    private Short ticketStatus;
    

    public  TicketChannelPO(TicketChannelVO vo) {
        this.id = vo.getId();
        this.ticketChannelId = vo.getTicketChannelId();
        this.drawerName = vo.getDrawerName();
        this.drawerAccount = vo.getDrawerAccount();
        this.accountPassword = vo.getAccountPassword();
        this.authCode = vo.getAuthCode();
        this.sendUrl = vo.getSendUrl();
        this.searchUrl = vo.getSearchUrl();
        this.searchUrlSpare = vo.getSearchUrlSpare();
        this.noticeUrl = vo.getNoticeUrl();
        this.accountBalance = vo.getAccountBalance();
        this.modifyBy = vo.getModifyBy();
        this.updateTime = vo.getUpdateTime();
        this.createTime = vo.getCreateTime();
        this.remark = vo.getRemark();
        this.createBy = vo.getCreateBy();
        this.channelStatus = vo.getChannelStatus();
        this.lotteryStatus = vo.getLotteryStatus();
        this.ticketStatus = vo.getTicketStatus();
    }

    public TicketChannelPO() {
        
    }

    public Short getChannelStatus() {
		return channelStatus;
	}

	public void setChannelStatus(Short channelStatus) {
		this.channelStatus = channelStatus;
	}

	public Short getLotteryStatus() {
		return lotteryStatus;
	}

	public void setLotteryStatus(Short lotteryStatus) {
		this.lotteryStatus = lotteryStatus;
	}

	public Short getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(Short ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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

    public String getDrawerName() {
        return drawerName;
    }

    public void setDrawerName(String drawerName) {
        this.drawerName = drawerName;
    }

    public String getDrawerAccount() {
        return drawerAccount;
    }

    public void setDrawerAccount(String drawerAccount) {
        this.drawerAccount = drawerAccount;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getSendUrl() {
        return sendUrl;
    }

    public void setSendUrl(String sendUrl) {
        this.sendUrl = sendUrl;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public String getSearchUrlSpare() {
        return searchUrlSpare;
    }

    public void setSearchUrlSpare(String searchUrlSpare) {
        this.searchUrlSpare = searchUrlSpare;
    }

    public String getNoticeUrl() {
        return noticeUrl;
    }

    public void setNoticeUrl(String noticeUrl) {
        this.noticeUrl = noticeUrl;
    }

    public Integer getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    
}