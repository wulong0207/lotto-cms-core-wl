package com.hhly.cmscore.persistence.operate.po;

import java.util.Date;

/**
 * @desc cms 缓存管理
 * @author YiJian
 * @date 2017年6月28日 上午10:57:55
 * @company 深圳益彩网络科技有限公司
 * @version v1.0
 */
public class CmsCachePO {
	
	/**
     * 主键ID
     */
	private Integer id;

    /**
     * 缓存类型：取字典表数据
     */
    private Short type;

    /**
     * 缓存名称
     */
    private String name;
    
    /**
     * 缓存KEY
     */
    private String cKey;
    
    /**
     * 状态 0：未启用；1：启用 
     */
    private Short status;
    
    private String remark;
    
    private Date updateTime;

    private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcKey() {
		return cKey;
	}

	public void setcKey(String cKey) {
		this.cKey = cKey;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
