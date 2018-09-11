package com.hhly.cmscore.persistence.operate.po;

import java.util.Date;

import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityVO;

public class OperateActivityPO {
	
    private Integer id;

    private String activityCode;

    private String activityName;

    private Short activityType;

    private Date activityStartTime;

    private Date activityEndTime;

    private String activityUrl;

    private Short activityStatus;

    private Long uvCount;

    private Long pvCount;

    private Integer partNum;

    private Integer prizeGetNum;

    private Double totalCost;

    private Double costPaid;

    private String channelId;

    private String activityDes;

    private Date modifyTime;

    private String modifyBy;

    private String createBy;

    private Date updateTime;

    private Date createTime;

    private Object remark;

	public OperateActivityPO() {
	}

	public OperateActivityPO(OperateActivityVO vo) {
		super();
		this.id = vo.getId();
		this.activityCode = vo.getActivityCode();
		this.activityName = vo.getActivityName();
		this.activityType = vo.getActivityType();
		this.activityStartTime = vo.getActivityStartTime();
		this.activityEndTime = vo.getActivityEndTime();
		this.activityUrl = vo.getActivityUrl();
		this.activityStatus = vo.getActivityStatus();
		this.uvCount = vo.getUvCount();
		this.pvCount = vo.getPvCount();
		this.partNum = vo.getPartNum();
		this.prizeGetNum = vo.getPrizeGetNum();
		this.totalCost = vo.getTotalCost();
		this.costPaid = vo.getCostPaid();
		this.channelId = vo.getChannelId();
		this.activityDes = vo.getActivityDes();
		this.modifyTime = vo.getModifyTime();
		this.modifyBy = vo.getModifyBy();
		this.createBy = vo.getCreateBy();
		this.updateTime = vo.getUpdateTime();
		this.createTime = vo.getCreateTime();
		this.remark = vo.getRemark();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Short getActivityType() {
		return activityType;
	}

	public void setActivityType(Short activityType) {
		this.activityType = activityType;
	}

	public Date getActivityStartTime() {
		return activityStartTime;
	}

	public void setActivityStartTime(Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}

	public Date getActivityEndTime() {
		return activityEndTime;
	}

	public void setActivityEndTime(Date activityEndTime) {
		this.activityEndTime = activityEndTime;
	}

	public String getActivityUrl() {
		return activityUrl;
	}

	public void setActivityUrl(String activityUrl) {
		this.activityUrl = activityUrl;
	}

	public Short getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(Short activityStatus) {
		this.activityStatus = activityStatus;
	}

	public Long getUvCount() {
		return uvCount;
	}

	public void setUvCount(Long uvCount) {
		this.uvCount = uvCount;
	}

	public Long getPvCount() {
		return pvCount;
	}

	public void setPvCount(Long pvCount) {
		this.pvCount = pvCount;
	}

	public Integer getPartNum() {
		return partNum;
	}

	public void setPartNum(Integer partNum) {
		this.partNum = partNum;
	}

	public Integer getPrizeGetNum() {
		return prizeGetNum;
	}

	public void setPrizeGetNum(Integer prizeGetNum) {
		this.prizeGetNum = prizeGetNum;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Double getCostPaid() {
		return costPaid;
	}

	public void setCostPaid(Double costPaid) {
		this.costPaid = costPaid;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getActivityDes() {
		return activityDes;
	}

	public void setActivityDes(String activityDes) {
		this.activityDes = activityDes;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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

	public Object getRemark() {
		return remark;
	}

	public void setRemark(Object remark) {
		this.remark = remark;
	}

    
}