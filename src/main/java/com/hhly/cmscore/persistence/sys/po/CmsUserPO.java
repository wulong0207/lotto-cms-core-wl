package com.hhly.cmscore.persistence.sys.po;

import java.util.Date;

import com.hhly.skeleton.cms.sysmgr.vo.CMSUserVO;

public class CmsUserPO {
	private Integer userId;

	private String userName;

	private Integer depart;

	private String userMobile;

	private Integer userStatus;

	private String userPassword;

	private String userRealName;

	private String userEmail;

	private Integer cmsRoleId;

	private Date lastLoginTime;

	private Date modifyTime;

	private String modifyBy;

	private String createBy;

	private Date updateTime;

	private Date createTime;

	private String remark;

	private String userCname;
	private String headUrl;
	
	private Integer monthLoginCount;
    private String lastLoginIp;
    private Date thisLoginTime;
    private String thisLoginIP;

	public CmsUserPO() {
	}

	public CmsUserPO(CMSUserVO vo) {
		this.userId = vo.getUserId();
		this.userName = vo.getUserName();
		this.depart = vo.getDepart();
		this.userMobile = vo.getUserMobile();
		this.userStatus = vo.getUserStatus();
		this.userPassword = vo.getUserPassword();
		this.userRealName = vo.getUserRealName();
		this.userEmail = vo.getUserEmail();
		this.cmsRoleId = vo.getCmsRoleId();
		this.lastLoginTime = vo.getLastLoginTime();
		this.modifyTime = vo.getModifyTime();
		this.modifyBy = vo.getModifyBy();
		this.createBy = vo.getCreateBy();
		this.updateTime = vo.getUpdateTime();
		this.createTime = vo.getCreateTime();
		this.remark = vo.getRemark();
		this.userCname=vo.getUserCname();
		this.headUrl=vo.getHeadUrl();
		
		this.monthLoginCount=vo.getMonthLoginCount();
		this.lastLoginIp=vo.getLastLoginIp();
		this.thisLoginTime=vo.getThisLoginTime();
		this.thisLoginIP=vo.getThisLoginIP();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getDepart() {
		return depart;
	}

	public void setDepart(Integer depart) {
		this.depart = depart;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getCmsRoleId() {
		return cmsRoleId;
	}

	public void setCmsRoleId(Integer cmsRoleId) {
		this.cmsRoleId = cmsRoleId;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUserCname() {
		return userCname;
	}

	public void setUserCname(String userCname) {
		this.userCname = userCname;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public Integer getMonthLoginCount() {
		return monthLoginCount;
	}

	public void setMonthLoginCount(Integer monthLoginCount) {
		this.monthLoginCount = monthLoginCount;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Date getThisLoginTime() {
		return thisLoginTime;
	}

	public void setThisLoginTime(Date thisLoginTime) {
		this.thisLoginTime = thisLoginTime;
	}

	public String getThisLoginIP() {
		return thisLoginIP;
	}

	public void setThisLoginIP(String thisLoginIP) {
		this.thisLoginIP = thisLoginIP;
	}

}