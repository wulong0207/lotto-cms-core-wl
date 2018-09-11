package com.hhly.cmscore.persistence.cooperate.po;

import java.util.Date;

public class CooperateExchangeRecordPO {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 交易类型,1,资金充值，2，兑换
     */
    private Boolean payClass;

    /**
     * 渠道余额。
     */
    private Float channelBalance;

    /**
     * 流水号
     */
    private String serialNumber;

    /**
     * 兑换码id
     */
    private Integer cdkeyId;

    /**
     * 兑换渠道
     */
    private Integer channelId;

    /**
     * 兑换时间
     */
    private Date exchangeRecordTime;

    /**
     * 兑换过期时间
     */
    private Date exchangeOverTime;

    /**
     * 兑换订单编号
     */
    private String orderCode;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String modifyBy;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 备注,用于记录出票失败，或者兑换码过期等信息
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPayClass() {
        return payClass;
    }

    public void setPayClass(Boolean payClass) {
        this.payClass = payClass;
    }

    public Float getChannelBalance() {
        return channelBalance;
    }

    public void setChannelBalance(Float channelBalance) {
        this.channelBalance = channelBalance;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public Integer getCdkeyId() {
        return cdkeyId;
    }

    public void setCdkeyId(Integer cdkeyId) {
        this.cdkeyId = cdkeyId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Date getExchangeRecordTime() {
        return exchangeRecordTime;
    }

    public void setExchangeRecordTime(Date exchangeRecordTime) {
        this.exchangeRecordTime = exchangeRecordTime;
    }

    public Date getExchangeOverTime() {
        return exchangeOverTime;
    }

    public void setExchangeOverTime(Date exchangeOverTime) {
        this.exchangeOverTime = exchangeOverTime;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}