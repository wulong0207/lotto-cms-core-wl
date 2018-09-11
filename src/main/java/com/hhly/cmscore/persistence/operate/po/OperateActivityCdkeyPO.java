package com.hhly.cmscore.persistence.operate.po;

import java.util.Date;

/**
 * 兑换码
 */
public class OperateActivityCdkeyPO {
    /**
     * 自增长ID
     */
    private Integer id;

    /**
     * 活动ID
     */
    private String activityCode;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 兑换码
     */
    private String cdkey;

    /**
     * 状态:0未兑换,1已兑换
     */
    private Short status;

    /**
     * 兑换时间
     */
    private Date exchangeTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人姓名
     */
    private String createBy;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 创建人姓名
     */
    private String modifyBy;

    /**
     * 备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCdkey() {
        return cdkey;
    }

    public void setCdkey(String cdkey) {
        this.cdkey = cdkey == null ? null : cdkey.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
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
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getExchangeTime() {
        return exchangeTime;
    }

    public void setExchangeTime(Date exchangeTime) {
        this.exchangeTime = exchangeTime;
    }
}