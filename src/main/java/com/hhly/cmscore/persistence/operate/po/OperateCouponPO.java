package com.hhly.cmscore.persistence.operate.po;

import java.util.Calendar;
import java.util.Date;

import com.hhly.skeleton.base.common.OperateCouponEnum.RedStatusEnum;
import com.hhly.skeleton.base.constants.PayConstants.RedCategoryEnum;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.base.util.ObjectUtil;
import com.hhly.skeleton.cms.operatemgr.vo.OperateCouponVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateCouponTempBO;
import com.hhly.skeleton.lotto.base.operate.vo.OperateCouponTempVO;

public class OperateCouponPO {
    private Integer id;

    private String redCode;

    private Short redCategory;

    private String activityCode;

    private String operateLotteryId;

    private Date activeEndTime;

    private Date obtainTime;

    private Date redOverdueTime;

    private Date useTime;

    private Short redType;

    private String redName;

    private Double redValue;

    private Double redBalance;

    private Integer minSpendAmount;

    private Integer userId;

    private Short ectivityDay;

    private String channelId;

    private String redLabel;

    private Short redStatus;

    private String limitPlatform;

    private String limitLottery;

    private String useRule;

    private String redRemark;

    private Date modifyTime;

    private String modifyBy;

    private String createBy;

    private Date updateTime;

    private Date createTime;

    private String remark;
    
    private Short redSource;
    
    /**
     * 限制红包彩种子玩法
     */
    private String limitLotteryChild;

    /**
     * 限制竞技彩种的过关方式
     */
    private String limitLotteryChildType; 
    
    /**
     * 随机红包类型
     */
    private Short randomRedType;

    public OperateCouponPO(){
    	
    }
	public OperateCouponPO(OperateCouponVO vo) {
		super();
		this.id = vo.getId();
		this.redCode = vo.getRedCode();
		this.redCategory = vo.getRedCategory();
		this.activityCode = vo.getActivityCode();
		this.operateLotteryId = vo.getOperateLotteryId();
		this.activeEndTime = vo.getActiveEndTime();
		this.obtainTime = vo.getObtainTime();
		this.redOverdueTime = vo.getRedOverdueTime();
		this.useTime = vo.getUseTime();
		this.redType = vo.getRedType();
		this.redName = vo.getRedName();
		this.redValue = vo.getRedValue();
		this.redBalance = vo.getRedBalance();
		this.minSpendAmount = vo.getMinSpendAmount();
		this.userId = vo.getUserId();
		this.ectivityDay = vo.getEctivityDay();
		this.channelId = vo.getChannelId();
		this.redLabel = vo.getRedLabel();
		this.redStatus = vo.getRedStatus();
		this.limitPlatform = vo.getLimitPlatform();
		this.limitLottery = vo.getLimitLottery();
		this.useRule = vo.getUseRule();
		this.redRemark = vo.getRedRemark();
		this.modifyTime = vo.getModifyTime();
		this.modifyBy = vo.getModifyBy();
		this.createBy = vo.getCreateBy();
		this.updateTime = vo.getUpdateTime();
		this.createTime = vo.getCreateTime();
		this.remark = vo.getRemark();
		this.redSource = vo.getRedSource();
		this.limitLotteryChild = vo.getLimitLotteryChild();
		this.limitLotteryChildType = vo.getLimitLotteryChildType();
		this.randomRedType = vo.getRandomRedType();
	}
	public OperateCouponPO(OperateCouponTempVO vo,String redCode) {
		this.redType = vo.getRedType();
		this.redName = vo.getRedName();
		this.redStatus = vo.getRedStatus();
		this.redValue = vo.getRedValue();
		this.minSpendAmount = vo.getMinSpendAmount()==null?null:vo.getMinSpendAmount().intValue();
		this.ectivityDay = vo.getEctivityDay();
	 	this.redCode = redCode;
	 	this.redCategory = RedCategoryEnum.VIRTUAL.getKey();
	 	this.redBalance = vo.getRedValue();
		if(ObjectUtil.isBlank(vo.getOperateLotteryId())){
			this.operateLotteryId= com.hhly.skeleton.base.constants.Constants.getActivityLotteryId();
		}else{
			this.operateLotteryId=vo.getOperateLotteryId();
		}
		if(vo.getRedStatus() == (short)RedStatusEnum.WAIT_ACTIVATION.getValue()){
			Calendar cal = Calendar.getInstance();
			cal.setTime(DateUtil.getDateDit(new Date(), vo.getActiveEndTime()));
			cal.set(Calendar.HOUR_OF_DAY, 10);
			cal.set(Calendar.MINUTE, 00);
			cal.set(Calendar.SECOND, 00);
			this.activeEndTime=cal.getTime();
			if(vo.getActiveEndTime()!=null&&vo.getEctivityDay()!=null){
				this.redOverdueTime=DateUtil.getDayEnd(DateUtil.getDateDit(DateUtil.getDateDit(new Date(), vo.getEctivityDay()),vo.getActiveEndTime()));
			}
		}else{
			if(vo.getEctivityDay()!=null&&vo.getEctivityDay()!=0){
				this.redOverdueTime=DateUtil.getDayEnd(DateUtil.getDateDit(new Date(), vo.getEctivityDay()));
			}
		}
		this.limitPlatform = vo.getLimitPlatform();
		this.limitLotteryChildType = vo.getLimitLotteryChildType();
		this.redLabel = vo.getRedLabel();
		this.operateLotteryId = vo.getOperateLotteryId();
		this.channelId = vo.getChannelId();
		this.limitLottery = vo.getLimitLottery();
		this.limitLotteryChild = vo.getLimitLotteryChild();
	}

	
	public OperateCouponPO(OperateCouponTempBO vo,String redCode) {
		this.redType = vo.getRedType();
		this.redName = vo.getRedName();
		this.redStatus = vo.getRedStatus();
		this.redValue = vo.getRedValue();
		this.minSpendAmount = vo.getMinSpendAmount()==null?null:vo.getMinSpendAmount().intValue();
		this.ectivityDay = vo.getEctivityDay();
	 	this.redCode = redCode;
	 	this.redCategory = RedCategoryEnum.VIRTUAL.getKey();
	 	this.redBalance = vo.getRedValue();
		if(ObjectUtil.isBlank(vo.getOperateLotteryId())){
			this.operateLotteryId= com.hhly.skeleton.base.constants.Constants.getActivityLotteryId();
		}else{
			this.operateLotteryId=vo.getOperateLotteryId();
		}
		if(vo.getRedStatus() == (short)RedStatusEnum.WAIT_ACTIVATION.getValue()){
			Calendar cal = Calendar.getInstance();
			cal.setTime(DateUtil.getDateDit(new Date(), vo.getActiveEndTime()));
			cal.set(Calendar.HOUR_OF_DAY, 10);
			cal.set(Calendar.MINUTE, 00);
			cal.set(Calendar.SECOND, 00);
			this.activeEndTime=cal.getTime();
			if(vo.getActiveEndTime()!=null&&vo.getEctivityDay()!=null){
				this.redOverdueTime=DateUtil.getDayEnd(DateUtil.getDateDit(DateUtil.getDateDit(new Date(), vo.getEctivityDay()),vo.getActiveEndTime()));
			}
		}else{
			if(vo.getEctivityDay()!=null&&vo.getEctivityDay()!=0){
				this.redOverdueTime=DateUtil.getDayEnd(DateUtil.getDateDit(new Date(), vo.getEctivityDay()));
			}
		}
		this.limitPlatform = vo.getLimitPlatform();
		this.limitLotteryChildType = vo.getLimitLotteryChildType();
		this.redLabel = vo.getRedLabel();
		this.operateLotteryId = vo.getOperateLotteryId();
		this.channelId = vo.getChannelId();
		this.limitLottery = vo.getLimitLottery();
		this.limitLotteryChild = vo.getLimitLotteryChild();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRedCode() {
		return redCode;
	}

	public void setRedCode(String redCode) {
		this.redCode = redCode;
	}

	public Short getRedCategory() {
		return redCategory;
	}

	public void setRedCategory(Short redCategory) {
		this.redCategory = redCategory;
	}

	public String getActivityCode() {
		return activityCode;
	}
	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}
	public String getOperateLotteryId() {
		return operateLotteryId;
	}

	public void setOperateLotteryId(String operateLotteryId) {
		this.operateLotteryId = operateLotteryId;
	}

	public Date getActiveEndTime() {
		return activeEndTime;
	}

	public void setActiveEndTime(Date activeEndTime) {
		this.activeEndTime = activeEndTime;
	}

	public Date getObtainTime() {
		return obtainTime;
	}

	public void setObtainTime(Date obtainTime) {
		this.obtainTime = obtainTime;
	}

	public Date getRedOverdueTime() {
		return redOverdueTime;
	}

	public void setRedOverdueTime(Date redOverdueTime) {
		this.redOverdueTime = redOverdueTime;
	}

	public Date getUseTime() {
		return useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	public Short getRedType() {
		return redType;
	}

	public void setRedType(Short redType) {
		this.redType = redType;
	}

	public String getRedName() {
		return redName;
	}

	public void setRedName(String redName) {
		this.redName = redName;
	}

	public Double getRedValue() {
		return redValue;
	}

	public void setRedValue(Double redValue) {
		this.redValue = redValue;
	}

	public Double getRedBalance() {
		return redBalance;
	}

	public void setRedBalance(Double redBalance) {
		this.redBalance = redBalance;
	}

	public Integer getMinSpendAmount() {
		return minSpendAmount;
	}

	public void setMinSpendAmount(Integer minSpendAmount) {
		this.minSpendAmount = minSpendAmount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Short getEctivityDay() {
		return ectivityDay;
	}

	public void setEctivityDay(Short ectivityDay) {
		this.ectivityDay = ectivityDay;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getRedLabel() {
		return redLabel;
	}

	public void setRedLabel(String redLabel) {
		this.redLabel = redLabel;
	}

	public Short getRedStatus() {
		return redStatus;
	}

	public void setRedStatus(Short redStatus) {
		this.redStatus = redStatus;
	}

	public String getLimitPlatform() {
		return limitPlatform;
	}

	public void setLimitPlatform(String limitPlatform) {
		this.limitPlatform = limitPlatform;
	}

	public String getLimitLottery() {
		return limitLottery;
	}

	public void setLimitLottery(String limitLottery) {
		this.limitLottery = limitLottery;
	}

	public String getUseRule() {
		return useRule;
	}

	public void setUseRule(String useRule) {
		this.useRule = useRule;
	}

	public String getRedRemark() {
		return redRemark;
	}

	public void setRedRemark(String redRemark) {
		this.redRemark = redRemark;
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
		this.modifyBy = modifyBy;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Short getRedSource() {
		return redSource;
	}
	public void setRedSource(Short redSource) {
		this.redSource = redSource;
	}
	
	public String getLimitLotteryChild() {
		return limitLotteryChild;
	}
	
	public void setLimitLotteryChild(String limitLotteryChild) {
		this.limitLotteryChild = limitLotteryChild;
	}
	
	public String getLimitLotteryChildType() {
		return limitLotteryChildType;
	}
	
	public void setLimitLotteryChildType(String limitLotteryChildType) {
		this.limitLotteryChildType = limitLotteryChildType;
	}
	public Short getRandomRedType() {
		return randomRedType;
	}
	public void setRandomRedType(Short randomRedType) {
		this.randomRedType = randomRedType;
	}
}