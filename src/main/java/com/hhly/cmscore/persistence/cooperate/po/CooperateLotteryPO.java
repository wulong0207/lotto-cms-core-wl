package com.hhly.cmscore.persistence.cooperate.po;

import com.hhly.skeleton.cms.cooperate.vo.CooperateLotteryVO;

import java.util.Date;

public class CooperateLotteryPO {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 合作商户渠道id
     */
    private String channelId;

    /**
     * 彩种编号
     */
    private String lotteryCode;

    /**
     * 面额
     */
    private Float denomination;

    /**
     * 兑换金额
     */
    private Float exchangeBalance;

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

    public CooperateLotteryPO() {
    }

    public CooperateLotteryPO(CooperateLotteryVO vo) {
        this.id = vo.getId();
        this.channelId = vo.getChannelId();
        this.lotteryCode = vo.getLotteryCode();
        this.denomination = vo.getDenomination();
        this.exchangeBalance = vo.getExchangeBalance();
        this.createBy = vo.getCreateBy();
        this.modifyBy = vo.getModifyBy();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getLotteryCode() {
        return lotteryCode;
    }

    public void setLotteryCode(String lotteryCode) {
        this.lotteryCode = lotteryCode;
    }

    public Float getDenomination() {
        return denomination;
    }

    public void setDenomination(Float denomination) {
        this.denomination = denomination;
    }

    public Float getExchangeBalance() {
        return exchangeBalance;
    }

    public void setExchangeBalance(Float exchangeBalance) {
        this.exchangeBalance = exchangeBalance;
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
}