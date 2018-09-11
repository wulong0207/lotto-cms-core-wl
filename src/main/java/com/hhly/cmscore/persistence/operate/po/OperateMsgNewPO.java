package com.hhly.cmscore.persistence.operate.po;

import java.util.Date;

import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgNewVO;

/**
 *	@Desc	   发送新信息
 *	@Author  HouXB
 *	@Date    2017年3月3日 下午12:26:07
 *  @Company 益彩网络科技公司
 *  @Version 1.0.0
 */
public class OperateMsgNewPO{
    
	private Integer id;
	
	private Integer status;
	
	private Integer mobStatus;
	
	private Integer siteStatus;
	
	private Integer appStatus;
	
	private Integer wechatStatus;
	
	private String mobTitle;
	
	private String mobContent;
	
	private String siteTitle;
	
	private String siteContent;
	
	private String appTitle;
	
	private String appContent;
	
	private String remark;

    private String createBy;

    private String modifyBy;
    
    private Date updateTime;
    
    private Integer wechatId;
    
    private String wechatTitle;

    private String headerCon;

    private String footerCon;
    
    private Integer msgType;
    
    private Integer templateId;
    private String msgBatch;
    private String userType;
    private Date preSendTime;
    private String sendReason;
    
    private String appFields;
    private String wechatFields;
    
    private Integer toLotteryCode;
	private String activityUrl;

	public Integer getToLotteryCode() {
		return toLotteryCode;
	}

	public void setToLotteryCode(Integer toLotteryCode) {
		this.toLotteryCode = toLotteryCode;
	}

	public String getActivityUrl() {
		return activityUrl;
	}

	public void setActivityUrl(String activityUrl) {
		this.activityUrl = activityUrl;
	}
    
	public String getWechatFields() {
		return wechatFields;
	}

	public void setWechatFields(String wechatFields) {
		this.wechatFields = wechatFields;
	}

	public String getAppFields() {
		return appFields;
	}

	public void setAppFields(String appFields) {
		this.appFields = appFields;
	}
    
	public OperateMsgNewPO(){
	    	
	}
	
	
    
    public Integer getMsgType() {
		return msgType;
	}



	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}



	public OperateMsgNewPO(OperateMsgNewVO vo){
    	this.id = vo.getId();
    	this.status = vo.getStatus();
    	this.mobStatus = vo.getMobStatus();
    	this.siteStatus = vo.getSiteStatus();
    	this.appStatus = vo.getAppStatus();
    	this.wechatStatus = vo.getWechatStatus();
    	this.mobTitle = vo.getMobTitle();
    	this.mobContent = vo.getMobContent();
    	this.siteTitle = vo.getSiteTitle();
    	this.siteContent = vo.getSiteContent();
    	this.appTitle = vo.getAppTitle();
    	this.appContent = vo.getAppContent();
    	this.remark = vo.getRemark();
        this.createBy = vo.getCreateBy();
        this.modifyBy = vo.getModifyBy();
        this.updateTime = vo.getUpdateTime();
        this.wechatId = vo.getWechatId();
        this.wechatTitle = vo.getWechatTitle();
        this.headerCon = vo.getHeaderCon();
        this.footerCon = vo.getFooterCon();
        this.templateId = vo.getTemplateId();
        this.msgBatch = vo.getMsgBatch();
        this.msgType = vo.getMsgType();
        this.preSendTime = vo.getPreSendTime();
        this.sendReason = vo.getSendReason();
        this.appFields = vo.getAppFields();
        this.wechatFields = vo.getWechatFields();
        this.activityUrl = vo.getActivityUrl();
        this.toLotteryCode = vo.getToLotteryCode();
    }

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public String getMsgBatch() {
		return msgBatch;
	}

	public void setMsgBatch(String msgBatch) {
		this.msgBatch = msgBatch;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Date getPreSendTime() {
		return preSendTime;
	}

	public void setPreSendTime(Date preSendTime) {
		this.preSendTime = preSendTime;
	}

	public String getSendReason() {
		return sendReason;
	}

	public void setSendReason(String sendReason) {
		this.sendReason = sendReason;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getMobStatus() {
		return mobStatus;
	}

	public void setMobStatus(Integer mobStatus) {
		this.mobStatus = mobStatus;
	}

	public Integer getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(Integer siteStatus) {
		this.siteStatus = siteStatus;
	}

	public Integer getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(Integer appStatus) {
		this.appStatus = appStatus;
	}

	public Integer getWechatStatus() {
		return wechatStatus;
	}

	public void setWechatStatus(Integer wechatStatus) {
		this.wechatStatus = wechatStatus;
	}

	public String getMobTitle() {
		return mobTitle;
	}

	public void setMobTitle(String mobTitle) {
		this.mobTitle = mobTitle;
	}

	public String getMobContent() {
		return mobContent;
	}

	public void setMobContent(String mobContent) {
		this.mobContent = mobContent;
	}

	public String getSiteTitle() {
		return siteTitle;
	}

	public void setSiteTitle(String siteTitle) {
		this.siteTitle = siteTitle;
	}

	public String getSiteContent() {
		return siteContent;
	}

	public void setSiteContent(String siteContent) {
		this.siteContent = siteContent;
	}

	public String getAppTitle() {
		return appTitle;
	}

	public void setAppTitle(String appTitle) {
		this.appTitle = appTitle;
	}

	public String getAppContent() {
		return appContent;
	}

	public void setAppContent(String appContent) {
		this.appContent = appContent;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getWechatId() {
		return wechatId;
	}

	public void setWechatId(Integer wechatId) {
		this.wechatId = wechatId;
	}

	public String getWechatTitle() {
		return wechatTitle;
	}

	public void setWechatTitle(String wechatTitle) {
		this.wechatTitle = wechatTitle;
	}

	public String getHeaderCon() {
		return headerCon;
	}

	public void setHeaderCon(String headerCon) {
		this.headerCon = headerCon;
	}

	public String getFooterCon() {
		return footerCon;
	}

	public void setFooterCon(String footerCon) {
		this.footerCon = footerCon;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}