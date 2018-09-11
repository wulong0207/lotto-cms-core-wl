package com.hhly.cmscore.persistence.customer.po;

import java.util.Date;

import com.hhly.skeleton.cms.customermgr.vo.UserIssueLevelVO;

public class UserIssueLevelPO {
    
	private Integer id;
	private Integer userIssueInfoId;
	private Integer lotteryCode;
	private Integer level;
	private Date createTime;
	private String modifyBy;
	private Date modifyTime;
	private Date updateTime;
	
	
	public UserIssueLevelPO(UserIssueLevelVO vo) {
		this.id = vo.getId();
		this.userIssueInfoId = vo.getUserIssueInfoId();
		this.lotteryCode = vo.getLotteryCode();
		this.level = vo.getLevel();
		this.createTime = vo.getCreateTime();
		this.modifyBy = vo.getModifyBy();
		this.modifyTime = vo.getModifyTime();
		this.updateTime = vo.getUpdateTime();
	}
	
	public Integer getLotteryCode() {
		return lotteryCode;
	}
	public void setLotteryCode(Integer lotteryCode) {
		this.lotteryCode = lotteryCode;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getUserIssueInfoId() {
		return userIssueInfoId;
	}

	public void setUserIssueInfoId(Integer userIssueInfoId) {
		this.userIssueInfoId = userIssueInfoId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "UserIssueLevelPO [userIssueInfoId=" + userIssueInfoId + ", lotteryCode=" + lotteryCode + ", level="
				+ level + "]";
	}

	
	
}