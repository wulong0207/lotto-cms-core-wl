package com.hhly.cmscore.persistence.operate.po;

import com.hhly.skeleton.base.util.ObjectUtil;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivitySportRuleVO;

import java.util.Date;

/**
 * @author zhouyang
 * @version 1.0
 * @desc 赛事加奖实体类
 * @date 2017/8/18
 * @company 益彩网络科技公司
 */
public class OperateActivitySportRulePO {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 活动配置主键id
     */
    private Integer activityConfigId;

    /**
     * 彩种子玩法
     */
    private String lotteryChildCode;

    /**
     * 过关方式
     */
    private String lotteryPassType;

    /**
     * 赛事系统编号
     */
    private String systemCode;

    /**
     * 类型   1： 时间，2：日期，3：期数
     */
    private String ruleType;

    /**
     * 类型开始
     */
    private String ruleStart;

    /**
     * 类型结束
     */
    private String ruleEnd;

    /**
     * 加奖方式
     */
    private String passAdd;

    /**
     * 活动状态
     */
    private Short openStatus;

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
     * 更新时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityConfigId() {
        return activityConfigId;
    }

    public void setActivityConfigId(Integer activityConfigId) {
        this.activityConfigId = activityConfigId;
    }

    public String getLotteryChildCode() {
        return lotteryChildCode;
    }

    public void setLotteryChildCode(String lotteryChildCode) {
        this.lotteryChildCode = lotteryChildCode;
    }

    public String getLotteryPassType() {
        return lotteryPassType;
    }

    public void setLotteryPassType(String lotteryPassType) {
        this.lotteryPassType = lotteryPassType;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleStart() {
        return ruleStart;
    }

    public void setRuleStart(String ruleStart) {
        this.ruleStart = ruleStart;
    }

    public String getRuleEnd() {
        return ruleEnd;
    }

    public void setRuleEnd(String ruleEnd) {
        this.ruleEnd = ruleEnd;
    }

    public String getPassAdd() {
        return passAdd;
    }

    public void setPassAdd(String passAdd) {
        this.passAdd = passAdd;
    }

    public Short getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(Short openStatus) {
        this.openStatus = openStatus;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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

    public OperateActivitySportRulePO() {
    }

    public OperateActivitySportRulePO(OperateActivitySportRuleVO vo) {
        this.id = vo.getId();
        this.activityConfigId = vo.getActivityConfigId();
        if (ObjectUtil.isBlank(vo.getSpf())) {
            this.lotteryChildCode = vo.getLotteryChildCode2();
        } else {
            this.lotteryChildCode = vo.getLotteryChildCode();
        }
        this.lotteryPassType = vo.getLotteryPassType();
        this.systemCode = vo.getSystemCode();
        this.ruleType = vo.getRuleType();
        this.ruleStart = vo.getRuleStart();
        this.ruleEnd = vo.getRuleEnd();
        this.passAdd = vo.getPassAdd();
        this.openStatus = vo.getOpenStatus();
        this.createBy = vo.getCreateBy();
        this.modifyBy = vo.getModifyBy();
        this.modifyTime = null;
        this.updateTime = null;
    }
}
