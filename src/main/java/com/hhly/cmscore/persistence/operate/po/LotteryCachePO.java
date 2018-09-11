package com.hhly.cmscore.persistence.operate.po;

import java.io.Serializable;
import java.util.Date;

public class LotteryCachePO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Short id;

    private Byte cacheGroup;

    private String name;

    private String cacheKey;

    private Boolean cacheType;

    private String remark;

    private Date updateTime;

    private Date createTime;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Byte getCacheGroup() {
        return cacheGroup;
    }

    public void setCacheGroup(Byte cacheGroup) {
        this.cacheGroup = cacheGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey == null ? null : cacheKey.trim();
    }

    public Boolean getCacheType() {
        return cacheType;
    }

    public void setCacheType(Boolean cacheType) {
        this.cacheType = cacheType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
