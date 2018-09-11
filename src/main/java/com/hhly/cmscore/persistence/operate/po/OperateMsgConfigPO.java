package com.hhly.cmscore.persistence.operate.po;

import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgConfigVo;

public class OperateMsgConfigPO {

	private Integer id;
	private Integer templateId;
	private Integer userId;
	private Integer mob;
	private Integer site;
	private Integer app;
	private Integer wechat;
	
	
	public OperateMsgConfigPO(OperateMsgConfigVo vo) {
		this.templateId = vo.getTemplateId();
		this.mob = vo.getMob();
		this.site = vo.getSite();
		this.app = vo.getApp();
		this.wechat = vo.getWechat();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getMob() {
		return mob;
	}
	public void setMob(Integer mob) {
		this.mob = mob;
	}
	public Integer getSite() {
		return site;
	}
	public void setSite(Integer site) {
		this.site = site;
	}
	public Integer getApp() {
		return app;
	}
	public void setApp(Integer app) {
		this.app = app;
	}
	public Integer getWechat() {
		return wechat;
	}
	public void setWechat(Integer wechat) {
		this.wechat = wechat;
	}
	
}
