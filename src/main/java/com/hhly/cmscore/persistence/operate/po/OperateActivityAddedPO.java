package com.hhly.cmscore.persistence.operate.po;
import java.util.Date;

import com.hhly.skeleton.base.bo.BaseBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityAddedVO;

public class OperateActivityAddedPO extends BaseBO{
    /**
     * 
     */
    private Integer id;

    /**
     * 活动配置主键id
     */
    private Integer activityConfigId;

    /**
     * 子玩法编号
     */
    private String lotteryChildCode;

    /**
     * 活动类型:1期数;2红包
     */
    private Short ruleType;

    /**
     * 活动优惠券表id
     */
    private Integer operateActivityCouponId;

    /**
     * 追号期数
     */
    private Short addNum;

    /**
     * 赠送期数
     */
    private Short giveNum;

    /**
     * 同一用户享受次数
     */
    private Short singleUserNum;

    /**
     * 活动限制次数
     */
    private Integer ruleOfferNum;
    /**
     * 赠送彩期
     */
    private String giveIssue;
    /**
     * 
     */
    private Date modifyTime;

    /**
     * 
     */
    private String modifyBy;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private String createBy;
    
    public OperateActivityAddedPO(OperateActivityAddedVO vo){
    	this.id=vo.getId();
    	this.activityConfigId = vo.getActivityConfigId();
    	this.addNum= vo.getAddNum();
    	this.createBy=vo.getCreateBy();
    	this.modifyBy=vo.getModifyBy();
    	this.giveNum=vo.getGiveNum();
    	this.giveIssue =vo.getGiveIssue();
    	this.lotteryChildCode = vo.getLotteryChildCode();
    	this.operateActivityCouponId=vo.getOperateActivityCouponId();
    	this.ruleOfferNum=vo.getRuleOfferNum();
    	this.ruleType=vo.getRuleType();
    	this.singleUserNum=vo.getSingleUserNum();
    }
    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }
    
    public String getGiveIssue() {
		return giveIssue;
	}
	public void setGiveIssue(String giveIssue) {
		this.giveIssue = giveIssue;
	}
	/**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 活动配置主键id
     * @return activity_config_id 活动配置主键id
     */
    public Integer getActivityConfigId() {
        return activityConfigId;
    }

    /**
     * 活动配置主键id
     * @param activityConfigId 活动配置主键id
     */
    public void setActivityConfigId(Integer activityConfigId) {
        this.activityConfigId = activityConfigId;
    }

    /**
     * 子玩法编号
     * @return lottery_child_code 子玩法编号
     */
    public String getLotteryChildCode() {
        return lotteryChildCode;
    }

    /**
     * 子玩法编号
     * @param lotteryChildCode 子玩法编号
     */
    public void setLotteryChildCode(String lotteryChildCode) {
        this.lotteryChildCode = lotteryChildCode == null ? null : lotteryChildCode.trim();
    }

    /**
     * 活动类型:1期数;2红包
     * @return rule_type 活动类型:1期数;2红包
     */
    public Short getRuleType() {
        return ruleType;
    }

    /**
     * 活动类型:1期数;2红包
     * @param ruleType 活动类型:1期数;2红包
     */
    public void setRuleType(Short ruleType) {
        this.ruleType = ruleType;
    }

    /**
     * 活动优惠券表id
     * @return operate_activity_coupon_id 活动优惠券表id
     */
    public Integer getOperateActivityCouponId() {
        return operateActivityCouponId;
    }

    /**
     * 活动优惠券表id
     * @param operateActivityCouponId 活动优惠券表id
     */
    public void setOperateActivityCouponId(Integer operateActivityCouponId) {
        this.operateActivityCouponId = operateActivityCouponId;
    }

    /**
     * 追号期数
     * @return add_num 追号期数
     */
    public Short getAddNum() {
        return addNum;
    }

    /**
     * 追号期数
     * @param addNum 追号期数
     */
    public void setAddNum(Short addNum) {
        this.addNum = addNum;
    }

    /**
     * 赠送期数
     * @return give_num 赠送期数
     */
    public Short getGiveNum() {
        return giveNum;
    }

    /**
     * 赠送期数
     * @param giveNum 赠送期数
     */
    public void setGiveNum(Short giveNum) {
        this.giveNum = giveNum;
    }

    /**
     * 同一用户享受次数
     * @return single_user_num 同一用户享受次数
     */
    public Short getSingleUserNum() {
        return singleUserNum;
    }

    /**
     * 同一用户享受次数
     * @param singleUserNum 同一用户享受次数
     */
    public void setSingleUserNum(Short singleUserNum) {
        this.singleUserNum = singleUserNum;
    }

    /**
     * 活动限制次数
     * @return rule_offer_num 活动限制次数
     */
    public Integer getRuleOfferNum() {
        return ruleOfferNum;
    }

    /**
     * 活动限制次数
     * @param ruleOfferNum 活动限制次数
     */
    public void setRuleOfferNum(Integer ruleOfferNum) {
        this.ruleOfferNum = ruleOfferNum;
    }

    /**
     * 
     * @return modify_time 
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * @param modifyTime 
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * @return modify_by 
     */
    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * 
     * @param modifyBy 
     */
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    /**
     * 
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return create_by 
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 
     * @param createBy 
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }
}