package com.hhly.cmscore.persistence.operate.po;

import com.hhly.skeleton.cms.operatemgr.vo.OperateWechatTemplateVO;

/**
 *	@Desc    微信公众号模板信息
 *	@Author  HouXB
 *	@Date    2017年3月3日 下午12:25:36
 *  @Company 益彩网络科技公司
 *  @Version 1.0.0
 */
public class OperateWechatTemplatePO{
    
	private Integer id;

	private String typeName;
	
	private Integer status;
	
	private String headerColor;
	
	private String footerColor;
	
	private String title;
	
	private String color;
	
	public OperateWechatTemplatePO(){
		
	}
	
	public OperateWechatTemplatePO(OperateWechatTemplateVO vo){
		this.id = vo.getId();
		this.typeName = vo.getTypeName();
		this.status = vo.getStatus();
		this.headerColor = vo.getHeaderColor();
		this.footerColor = vo.getFooterColor();
		this.title = vo.getTitle();
		this.color = vo.getColor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getHeaderColor() {
		return headerColor;
	}

	public void setHeaderColor(String headerColor) {
		this.headerColor = headerColor;
	}

	public String getFooterColor() {
		return footerColor;
	}

	public void setFooterColor(String footerColor) {
		this.footerColor = footerColor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}