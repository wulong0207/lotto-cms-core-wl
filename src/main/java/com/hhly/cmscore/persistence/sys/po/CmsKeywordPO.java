package com.hhly.cmscore.persistence.sys.po;

import java.util.Date;

import com.hhly.skeleton.cms.sysmgr.vo.CmsKeywordVO;

public class CmsKeywordPO {
	private Integer id;
	/*
	 * 敏感词
	 */
	private String keyword;
	/*
	 * 敏感级别:1:一般;2危险
	 */
	private Short grade;
	/*
	 * 状态:0禁用;1启用
	 */
	private Short status;
	/*
	 * 替换内容
	 */
	private String replaced;

	private Object createBy;

	private Object modifyBy;

	private Date modifyTime;

	private Date updateTime;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword == null ? null : keyword.trim();
	}

	public Short getGrade() {
		return grade;
	}

	public void setGrade(Short grade) {
		this.grade = grade;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getReplaced() {
		return replaced;
	}

	public void setReplaced(String replaced) {
		this.replaced = replaced == null ? null : replaced.trim();
	}

	public Object getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Object createBy) {
		this.createBy = createBy;
	}

	public Object getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Object modifyBy) {
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public CmsKeywordPO() {
		super();
	}

	public CmsKeywordPO(CmsKeywordVO vo) {
		this.id = vo.getId();
		this.keyword = vo.getKeyword();
		this.grade = vo.getGrade();
		this.status = vo.getStatus();
		this.replaced = vo.getReplaced();
		this.createBy = vo.getCreateBy();
		this.modifyBy = vo.getModifyBy();
		this.modifyTime = vo.getModifyTime();
		this.updateTime = vo.getUpdateTime();
		this.createTime = vo.getCreateTime();
	}
	
}