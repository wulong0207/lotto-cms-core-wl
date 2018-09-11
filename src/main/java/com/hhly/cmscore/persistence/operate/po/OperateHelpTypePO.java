package com.hhly.cmscore.persistence.operate.po;

import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpTypeVO;

public class OperateHelpTypePO {
    /**
     * 自增长主键ID
     */
    private Long id;

    /**
     * 栏目编号
     */
    private String code;

    /**
     * 栏目名称
     */
    private String fullName;

    /**
     * 栏目简称
     */
    private String shortName;

    /**
     * -1：顶级菜单；关联主键ID
     */
    private Long parent;

    /**
     * 1：一级菜单；2：二级菜单；
     */
    private Integer menu;

    /**
     * 前端使用状态:0：隐藏；1：显示；
     */
    private Short status;

    /**
     * 排序ID
     */
    private Integer orderId;

    /**
     * 栏目标识符
     */
    private String identifiers;

    /**
     * 栏目描述
     */
    private String descriptor;

    /**
     * 是否虚拟栏目:0：否，1：是
     */
    private Short virtual;

    
	public OperateHelpTypePO(OperateHelpTypeVO vo) {
		this.id = vo.getId();
		this.code = vo.getCode();
		this.fullName = vo.getFullName();
		this.shortName = vo.getShortName();
		this.parent = vo.getParent();
		this.menu = vo.getMenu();
		this.status = vo.getStatus();
		this.orderId = vo.getOrderId();
		this.identifiers = vo.getIdentifiers();
		this.descriptor = vo.getDescriptor();
		this.virtual = vo.getVirtual();
	}

	public OperateHelpTypePO(Long id, int orderId) {
		this.id = id;
		this.orderId = orderId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public Integer getMenu() {
		return menu;
	}

	public void setMenu(Integer menu) {
		this.menu = menu;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(String identifiers) {
		this.identifiers = identifiers;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public Short getVirtual() {
		return virtual;
	}

	public void setVirtual(Short virtual) {
		this.virtual = virtual;
	}
}