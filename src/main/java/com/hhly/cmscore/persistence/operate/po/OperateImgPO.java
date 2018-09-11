package com.hhly.cmscore.persistence.operate.po;

import java.util.Date;

public class OperateImgPO {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 分组ID:0未分组;1广告图;2球队Logo
     */
    private Integer groupid;

    /**
     * 目录路径
     */
    private String dir;

    /**
     * 分辨率
     */
    private String resolution;

    /**
     * 大小
     */
    private String sizes;

    /**
     * null
     */
    private String modifyBy;

    /**
     * null
     */
    private Date modifyTime;

    /**
     * null
     */
    private String createBy;

    /**
     * null
     */
    private Date updateTime;

    /**
     * null
     */
    private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
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

   
}