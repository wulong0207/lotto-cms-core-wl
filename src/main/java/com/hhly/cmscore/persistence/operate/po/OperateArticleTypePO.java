package com.hhly.cmscore.persistence.operate.po;

import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleTypeVO;

public class OperateArticleTypePO {
  /**自增长主键ID*/
  private Long id;
  /**栏目编号*/
  private String typeCode;
  /**栏目名称*/
  private String typeFullName;
  /**栏目简称*/
  private String typeShortName;
  /**-1：顶级菜单；关联OPERATE_ARTICLE表的主键ID*/
  private Long typeParent;
  /**1：一级菜单；2：二级菜单；*/
  private Byte typeLevel;
  /**前端使用状态:0：隐藏；1：显示；*/
  private Byte status;
  /**排序ID*/
  private Short orderId;
  /**栏目标识符*/
  private String identifiers;
  /**栏目描述*/
  private String typeDesc;
  /**是否虚拟栏目:0：否，1：是*/
  private Byte virtual;
  
  private Byte rstatus;
  
	public OperateArticleTypePO(OperateArticleTypeVO vo) {
		this.id = vo.getId();
		this.typeCode = vo.getTypeCode();
		this.typeFullName = vo.getTypeFullName();
		this.typeShortName = vo.getTypeShortName();
		this.typeParent = vo.getTypeParent();
		this.typeLevel = vo.getTypeLevel();
		this.status = vo.getStatus();
		this.orderId = vo.getOrderId();
		this.identifiers = vo.getIdentifiers();
		this.typeDesc = vo.getTypeDesc();
		this.virtual = vo.getVirtual();
		this.rstatus = vo.getRstatus();
	}
	public OperateArticleTypePO(Long id, int orderId) {
		this.id = id;
		this.orderId = (short)orderId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getTypeFullName() {
		return typeFullName;
	}
	public void setTypeFullName(String typeFullName) {
		this.typeFullName = typeFullName;
	}
	public String getTypeShortName() {
		return typeShortName;
	}
	public void setTypeShortName(String typeShortName) {
		this.typeShortName = typeShortName;
	}
	public Long getTypeParent() {
		return typeParent;
	}
	public void setTypeParent(Long typeParent) {
		this.typeParent = typeParent;
	}
	public Byte getTypeLevel() {
		return typeLevel;
	}
	public void setTypeLevel(Byte typeLevel) {
		this.typeLevel = typeLevel;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Short getOrderId() {
		return orderId;
	}
	public void setOrderId(Short orderId) {
		this.orderId = orderId;
	}
	public String getIdentifiers() {
		return identifiers;
	}
	public void setIdentifiers(String identifiers) {
		this.identifiers = identifiers;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	public Byte getVirtual() {
		return virtual;
	}
	public void setVirtual(Byte virtual) {
		this.virtual = virtual;
	}
	public Byte getRstatus() {
		return rstatus;
	}
	public void setRstatus(Byte rstatus) {
		this.rstatus = rstatus;
	}
	
	
}