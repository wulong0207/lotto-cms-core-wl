package com.hhly.cmscore.persistence.ordercopy.po;

import com.hhly.skeleton.lotto.base.ordercopy.vo.OrderFollowedInfoVO;

import java.util.Date;

public class OrderFollowedInfoPO {
    /**
     * 主键
     */
    private Integer id;

    /**
     * m_user_info主键id
     */
    private Integer userId;

    /**
     * 冗余用户昵称
     */
    private String nickName;

    /**
     * 推单表主键id
     */
    private Integer orderIssueId;

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 佣金
     */
    private Float commissionAmount;

    /**
     * 状态，默认0：未出票；1：已出票
     */
    private Integer dataStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 修改用户id(后台操作员ID)
     */
    private String modifyBy;

    /**
     * 更新时间
     */
    private Date updateTime;


    public OrderFollowedInfoPO() {
    }

    public OrderFollowedInfoPO(OrderFollowedInfoVO vo) {
        this.id = vo.getId();
        this.userId = vo.getUserId();
        this.nickName = vo.getNickName();
        this.orderIssueId = vo.getOrderIssueId();
        this.orderCode = vo.getOrderCode();
        this.commissionAmount = vo.getCommissionAmount();
        this.dataStatus = vo.getDataStatus();
        this.createTime = vo.getCreateTime();
        this.modifyTime = vo.getModifyTime();
        this.modifyBy = vo.getModifyBy();
        this.updateTime = vo.getUpdateTime();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getOrderIssueId() {
        return orderIssueId;
    }

    public void setOrderIssueId(Integer orderIssueId) {
        this.orderIssueId = orderIssueId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Float getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(Float commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}