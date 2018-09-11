package com.hhly.cmscore.persistence.customer.po;

import com.hhly.skeleton.cms.customermgr.vo.UserIssueVO;

public class UserIssuePO {
    
	private Integer id;
	private Integer status;
	
	
	public UserIssuePO(UserIssueVO vo) {
		this.id = vo.getId();
		this.status = vo.getStatus();
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
	
	@Override
	public String toString() {
		return "UserIssuePO [id=" + id + ", status=" + status + "]";
	}
}