package com.hhly.cmscore.persistence.operate.po;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityChpGuessBO;
import com.hhly.skeleton.cms.operatemgr.vo.*;
import org.apache.commons.collections.CollectionUtils;

import com.hhly.skeleton.base.common.ActivityEnum;
import com.hhly.skeleton.base.common.OperateCouponEnum.CouponConfigTypeEnum;
import com.hhly.skeleton.lotto.base.operate.vo.OperateCouponTempVO;

import net.sf.json.JSONObject;

public class OperateActivityConfigPO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 活动编码
     */
    private String activityCode;

    /**
     * 彩种编码
     */
    private Short lotteryCode;

    /**
     * 单个方案返奖上限
     */
    private Double singleOrderMoney;

    /**
     * 单个用户彩金上限
     */
    private Double singleUserRedMoney;

    /**
     * 单个用户返奖上限
     */
    private Double singleUserMoney;

    /**
     * 单个用户单日返奖上限
     */
    private Double singleUserDayMoney;

    /**
     * 同一真实名称享受人数
     */
    private Short realUserNum;
    
    /**
     * 同一手机号码参与次数
     */
    private Short mobileNum;

    /**
     * 用户类型(1所有,2发起人, 3合买人等)
     */
    private Short userType;
    
    /**
     *  赠送类型,1优惠券;2彩票，兑换码类型 3一码一用 4一码多用
     */
    private Short configType;

    /**
     * 返利用户类型, 1:返所有用户;2:返发起人
     */
    private Short rebateUserType;

    /**
     * 合买订单是否参与(0:不参与; 1:参与)
     */
    private Short isFollowOrder;

    /**
     * 保底订单是否参与(0:不参与; 1:参与)
     */
    private Short isCareOrder;

    /**
     * 是否手机(0:否;1:是)
     */
    private Short isMobile;

    /**
     * 是否真实用户(0:否;1:是)
     */
    private Short isRealUser;

    /**
     * 分期次数1为全送，大于1分月
     */
    private Short installment;

    /**
     * 分期额度(分月值大于等于2时输入，用#号分隔)
     */
    private String installmentMoney;

    /**
     * 优惠次数
     */
    private Short offerNum;

    /**
     * 优惠金额
     */
    private Double offerMoney;

    /**
     * 平台0全部,1WEB;2WAP;3ANDROID;4IOS 多个平台逗号分隔
     */
    private String platfrom;

    /**
     * 是否有效(0:否;1:是)
     */
    private Short status;

    /**
     * 创建人姓名
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人姓名
     */
    private String modifyBy;

    /**
     * 更新时间(程序应用更新时,修改此时间)
     */
    private Date modifyTime;

    /**
     * 修改时间(人为修改时:修改此时间)
     */
    private Date updateTime;

    /**
     * 活动访问url
     */
    private String url;
    /***
     * 最小充值金额
     */
    private Double minRechargeMoney;
    /**
     * 活动每日配送次数上限
     */
    private Integer activityDayNum;
    /**
     * 是否大乐透追加
     */
    private Short isDltAdd;
    /**
     * 是否允许用户撤单
     */
    private Short isCancel;
    /**
     * 中奖是否参与
     */
    private Short isAward;
    /**
     * 是否必须活动页参与(0:否;1:是)
     */
    private Short isActivityPage;
    /**
	 * 图标样式
	 */
    private String  icon;
    /**
	 *移动端图标跳转链接
	 */
    private String  mobileIconUrl;
    /**
	 * pc端图标跳转链接
	 */
    private String  pcIconUrl;
    /**
     * 公共规则
     */
    private List<?> operateActivityRulePOList;
    

    private List<?> operateActivitySportRulePOList;

    /**
     * 彩票相关配置
     */
    private List<?> operateActivityLottoRulePOList;
    public OperateActivityConfigPO(){
    	
    }
    public OperateActivityConfigPO(OperateActivityConfigVO vo, OperateActivitySportRuleVO sportRuleVO) {
        this.id = vo.getId();
        this.activityCode = vo.getActivityCode();
        this.lotteryCode = vo.getLotteryCode();
        this.singleOrderMoney = vo.getSingleOrderMoney();
        this.singleUserRedMoney = vo.getSingleUserRedMoney();
        this.singleUserMoney = vo.getSingleUserMoney();
        this.singleUserDayMoney = vo.getSingleUserDayMoney();
        this.realUserNum = vo.getRealUserNum();
        this.userType = vo.getUserType();
        this.rebateUserType = vo.getRebateUserType();
        this.isFollowOrder = vo.getIsFollowOrder();
        this.isCareOrder = vo.getIsCareOrder();
        this.isMobile = vo.getIsMobile();
        this.isRealUser = vo.getIsRealUser();
        this.installment = vo.getInstallment();
        this.installmentMoney = vo.getInstallmentMoney();
        this.offerNum = vo.getOfferNum();
        this.offerMoney = vo.getOfferMoney();
        this.platfrom = vo.getPlatfrom();
        this.status = vo.getStatus();
        this.createBy = vo.getCreateBy();
        this.modifyBy = vo.getModifyBy();
        this.url = vo.getUrl();
        this.minRechargeMoney = vo.getMinRechargeMoney();
        this.activityDayNum = vo.getActivityDayNum();
        List<?> list = vo.getOperateActivitySportRuleVOList();
        if(CollectionUtils.isNotEmpty(list)) {
            List<OperateActivitySportRulePO> poList = new ArrayList<OperateActivitySportRulePO>();
            for (Object object : list) {
                JSONObject jsonObj=JSONObject.fromObject(object);
                OperateActivitySportRuleVO operateActivitySportRuleVO =(OperateActivitySportRuleVO) jsonObj.toBean(jsonObj,OperateActivitySportRuleVO.class);
                if (vo.getType().equals(ActivityEnum.ActivityTypeEnum.SPECIAL.getValue())) {
                    operateActivitySportRuleVO.setSpf(null);
                    operateActivitySportRuleVO.setRfspf(null);
                }
                OperateActivitySportRulePO operateActivitySportRulePO = new OperateActivitySportRulePO(operateActivitySportRuleVO);
                operateActivitySportRulePO.setActivityConfigId(this.id);
                operateActivitySportRulePO.setCreateBy(this.createBy);
                operateActivitySportRulePO.setModifyBy(this.modifyBy);
                poList.add(operateActivitySportRulePO);
            }
            this.operateActivitySportRulePOList = poList;
        } else {
            this.operateActivitySportRulePOList = Collections.emptyList();
        }
    }
 
    public OperateActivityConfigPO(OperateActivityConfigVO vo,OperateActivityRuleVO ruleVo) {
    	this.id = vo.getId();
		this.activityCode = vo.getActivityCode();
		this.configType = vo.getConfigType();
		this.lotteryCode = vo.getLotteryCode();
		this.singleOrderMoney = vo.getSingleOrderMoney();
		this.singleUserRedMoney = vo.getSingleUserRedMoney();
		this.singleUserMoney = vo.getSingleUserMoney();
		this.singleUserDayMoney = vo.getSingleUserDayMoney();
		this.realUserNum = vo.getRealUserNum();
		this.userType = vo.getUserType();
        this.rebateUserType = vo.getRebateUserType();
		this.isFollowOrder = vo.getIsFollowOrder();
		this.isCareOrder = vo.getIsCareOrder();
		this.isMobile = vo.getIsMobile();
		this.isRealUser = vo.getIsRealUser();
		this.installment = vo.getInstallment();
		this.installmentMoney = vo.getInstallmentMoney();
		this.offerNum = vo.getOfferNum();
		this.offerMoney = vo.getOfferMoney();
		this.platfrom = vo.getPlatfrom();
		this.status = vo.getStatus();
		this.createBy = vo.getCreateBy();
		this.modifyBy = vo.getModifyBy();
		this.url = vo.getUrl();
		this.activityDayNum = vo.getActivityDayNum();
		this.isAward =vo.getIsAward();
		this.isDltAdd=vo.getIsDltAdd();
		this.isCancel=vo.getIsCancel();
		this.icon=vo.getIcon();
		this.mobileIconUrl=vo.getMobileIconUrl();
		this.pcIconUrl=vo.getPcIconUrl();
		List<?> list = vo.getOperateActivityRuleVOList();
		if(CollectionUtils.isNotEmpty(list)) {
			List<OperateActivityRulePO> poList = new ArrayList<OperateActivityRulePO>();
			for (Object object : list) {
				JSONObject jsonObj=JSONObject.fromObject(object);  
				OperateActivityRuleVO operateActivityRuleVO =(OperateActivityRuleVO) jsonObj.toBean(jsonObj,OperateActivityRuleVO.class);								
				OperateActivityRulePO operateActivityRulePO = new OperateActivityRulePO(operateActivityRuleVO);
				operateActivityRulePO.setActivityConfigId(this.id);
				operateActivityRulePO.setCreateBy(this.createBy);
				operateActivityRulePO.setModifyBy(this.modifyBy);
				poList.add(operateActivityRulePO);
			}
			this.operateActivityRulePOList = poList;
		} else {
			this.operateActivityRulePOList = Collections.emptyList();
		}		
	}
    public OperateActivityConfigPO(OperateActivityConfigVO vo,OperateCouponTempVO ruleVo) {
    	this.id = vo.getId();
		this.activityCode = vo.getActivityCode();
		this.lotteryCode = vo.getLotteryCode();
		this.singleOrderMoney = vo.getSingleOrderMoney();
		this.singleUserRedMoney = vo.getSingleUserRedMoney();
		this.singleUserMoney = vo.getSingleUserMoney();
		this.singleUserDayMoney = vo.getSingleUserDayMoney();
		this.realUserNum = vo.getRealUserNum();
		this.userType = vo.getUserType();
        this.configType = vo.getConfigType();
        this.rebateUserType = vo.getRebateUserType();
		this.isFollowOrder = vo.getIsFollowOrder();
		this.isCareOrder = vo.getIsCareOrder();
		this.isMobile = vo.getIsMobile();
		this.isRealUser = vo.getIsRealUser();
		this.installment = vo.getInstallment();
		this.installmentMoney = vo.getInstallmentMoney();
		this.offerNum = vo.getOfferNum();
		this.offerMoney = vo.getOfferMoney();
		this.platfrom = vo.getPlatfrom();
		this.status = vo.getStatus();
		this.createBy = vo.getCreateBy();
		this.modifyBy = vo.getModifyBy();
		this.url = vo.getUrl();
		this.minRechargeMoney = vo.getMinRechargeMoney();
		this.activityDayNum = vo.getActivityDayNum();
		this.isActivityPage=vo.getIsActivityPage();
		this.mobileNum = vo.getMobileNum();
		List<?> list = vo.getOperateActivityRuleVOList();
		if(CollectionUtils.isNotEmpty(list)) {
			List<OperateCouponTempPO> poList = new ArrayList<OperateCouponTempPO>();
			for (Object object : list) {
				JSONObject jsonObj=JSONObject.fromObject(object);  
				OperateCouponTempVO operateActivityRuleVO =(OperateCouponTempVO) jsonObj.toBean(jsonObj,OperateCouponTempVO.class);								
				OperateCouponTempPO operateActivityRulePO = new OperateCouponTempPO(operateActivityRuleVO);
				operateActivityRulePO.setConfigId(this.id);
				operateActivityRulePO.setCreateBy(this.createBy);
				operateActivityRulePO.setModifyBy(this.modifyBy);
				operateActivityRulePO.setConfigType(CouponConfigTypeEnum.ACTIVITY.getValue());
				poList.add(operateActivityRulePO);
			}
			this.operateActivityRulePOList = poList;
		} else {
			this.operateActivityRulePOList = Collections.emptyList();
		}		
	}
    
    public OperateActivityConfigPO(OperateActivityConfigVO vo,OperateCouponTempVO couponRuleVo, OperateActivityLottoVO lottoRuleVo) {
    	this.id = vo.getId();
		this.activityCode = vo.getActivityCode();
		this.userType = vo.getUserType();
		this.realUserNum = vo.getRealUserNum();
		this.mobileNum = vo.getMobileNum();
		this.offerNum = vo.getOfferNum();
		this.singleUserMoney = vo.getSingleUserMoney();
		this.activityDayNum = vo.getActivityDayNum();
		this.configType = vo.getConfigType();
		this.isRealUser = vo.getIsRealUser();
		this.createBy = vo.getCreateBy();
		this.modifyBy = vo.getModifyBy();
		List<?> couponRuleList = vo.getOperateActivityRuleVOList();
		if(CollectionUtils.isNotEmpty(couponRuleList)) {
			List<OperateCouponTempPO> poList = new ArrayList<OperateCouponTempPO>();
			for (Object object : couponRuleList) {
				JSONObject jsonObj=JSONObject.fromObject(object);  
				OperateCouponTempVO operateActivityRuleVO =(OperateCouponTempVO) jsonObj.toBean(jsonObj,OperateCouponTempVO.class);								
				OperateCouponTempPO operateActivityRulePO = new OperateCouponTempPO(operateActivityRuleVO);
				operateActivityRulePO.setConfigId(this.id);
				operateActivityRulePO.setConfigType(CouponConfigTypeEnum.ACTIVITY.getValue());
				operateActivityRulePO.setCreateBy(this.createBy);
				operateActivityRulePO.setModifyBy(this.modifyBy);
				poList.add(operateActivityRulePO);
			}
			this.operateActivityRulePOList = poList;
		} else {
			this.operateActivityRulePOList = Collections.emptyList();
		}
		List<?> lottoRuleList = vo.getOperateActivityLottoRuleVOList();
		if(CollectionUtils.isNotEmpty(lottoRuleList)) {
			List<OperateActivityLottoPO> poList = new ArrayList<OperateActivityLottoPO>();
			for (Object object : lottoRuleList) {
				JSONObject jsonObj=JSONObject.fromObject(object);  
				OperateActivityLottoVO operateActivityRuleVO =(OperateActivityLottoVO) jsonObj.toBean(jsonObj,OperateActivityLottoVO.class);								
				OperateActivityLottoPO operateActivityRulePO = new OperateActivityLottoPO(operateActivityRuleVO);
				operateActivityRulePO.setActivityConfigId(this.id);
				operateActivityRulePO.setCreateBy(this.createBy);
				operateActivityRulePO.setModifyBy(this.modifyBy);
				poList.add(operateActivityRulePO);
			}
			this.operateActivityLottoRulePOList = poList;
		} else {
			this.operateActivityLottoRulePOList = Collections.emptyList();
		}		
	}
    public OperateActivityConfigPO(OperateActivityAwardVO vo) {
		this.activityCode = vo.getActivityCode();
		this.createBy = vo.getCreateBy();
		this.modifyBy = vo.getModifyBy();		
	}
    public OperateActivityConfigPO(OperateActivityConfigVO vo) {
    	this.lotteryCode=vo.getLotteryCode();
		this.activityCode = vo.getActivityCode();
		this.createBy = vo.getCreateBy();
		this.modifyBy = vo.getModifyBy();	
		this.id = vo.getId();
		this.isCancel= vo.getIsCancel();
	}

    public OperateActivityConfigPO(OperateActivityConfigVO vo, OperateActivityChpGuessVO operateActivityChpGuessVO) {
        this.id = vo.getId();
        this.activityCode = vo.getActivityCode();
        this.realUserNum = vo.getRealUserNum();
        this.isRealUser = vo.getIsRealUser();
        this.isMobile = vo.getIsMobile();
        this.createBy = vo.getCreateBy();
        this.modifyBy = vo.getModifyBy();
        List<?> couponRuleList = vo.getOperateActivityRuleVOList();
        if(CollectionUtils.isNotEmpty(couponRuleList)) {
            List<OperateActivityChpGuessBO> poList = new ArrayList<>();
            for (Object object : couponRuleList) {
                JSONObject jsonObj=JSONObject.fromObject(object);
                OperateActivityChpGuessBO operateActivityRuleVO =(OperateActivityChpGuessBO) jsonObj.toBean(jsonObj,OperateActivityChpGuessBO.class);
                operateActivityRuleVO.setActivityConfigId(this.id);
                poList.add(operateActivityRuleVO);
            }
            this.operateActivityRulePOList = poList;
        } else {
            this.operateActivityRulePOList = Collections.emptyList();
        }
    }

    /**
     * 主键id
     * @return id 主键id
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * 主键id
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityDayNum() {
		return activityDayNum;
	}
	public void setActivityDayNum(Integer activityDayNum) {
		this.activityDayNum = activityDayNum;
	}
	/**
     * 活动编码
     * @return activity_code 活动编码
     */
    public String getActivityCode() {
        return activityCode;
    }

    /**
     * 活动编码
     * @param activityCode 活动编码
     */
    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode == null ? null : activityCode.trim();
    }

    /**
     * 彩种编码
     * @return lottery_code 彩种编码
     */
    public Short getLotteryCode() {
        return lotteryCode;
    }

    /**
     * 彩种编码
     * @param lotteryCode 彩种编码
     */
    public void setLotteryCode(Short lotteryCode) {
        this.lotteryCode = lotteryCode;
    }

    /**
     * 单个方案返奖上限
     * @return single_order_money 单个方案返奖上限
     */
    public Double getSingleOrderMoney() {
        return singleOrderMoney;
    }

    /**
     * 单个方案返奖上限
     * @param singleOrderMoney 单个方案返奖上限
     */
    public void setSingleOrderMoney(Double singleOrderMoney) {
        this.singleOrderMoney = singleOrderMoney;
    }

    /**
     * 单个用户彩金上限
     * @return single_user_red_money 单个用户彩金上限
     */
    public Double getSingleUserRedMoney() {
        return singleUserRedMoney;
    }

    /**
     * 单个用户彩金上限
     * @param singleUserRedMoney 单个用户彩金上限
     */
    public void setSingleUserRedMoney(Double singleUserRedMoney) {
        this.singleUserRedMoney = singleUserRedMoney;
    }

    /**
     * 单个用户返奖上限
     * @return single_user_money 单个用户返奖上限
     */
    public Double getSingleUserMoney() {
        return singleUserMoney;
    }

    /**
     * 单个用户返奖上限
     * @param singleUserMoney 单个用户返奖上限
     */
    public void setSingleUserMoney(Double singleUserMoney) {
        this.singleUserMoney = singleUserMoney;
    }

    /**
     * 单个用户单日返奖上限
     * @return single_user_day_money 单个用户单日返奖上限
     */
    public Double getSingleUserDayMoney() {
        return singleUserDayMoney;
    }

    /**
     * 单个用户单日返奖上限
     * @param singleUserDayMoney 单个用户单日返奖上限
     */
    public void setSingleUserDayMoney(Double singleUserDayMoney) {
        this.singleUserDayMoney = singleUserDayMoney;
    }

    /**
     * 同一真实名称享受人数
     * @return real_user_num 同一真实名称享受人数
     */
    public Short getRealUserNum() {
        return realUserNum;
    }

    /**
     * 同一真实名称享受人数
     * @param realUserNum 同一真实名称享受人数
     */
    public void setRealUserNum(Short realUserNum) {
        this.realUserNum = realUserNum;
    }
    
    public Short getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(Short mobileNum) {
		this.mobileNum = mobileNum;
	}
	/**
     * 用户类型(1所有,2发起人, 3合买人等)
     * @return user_type 用户类型(1所有,2发起人, 3合买人等)
     */
    public Short getUserType() {
        return userType;
    }

    /**
     * 用户类型(1所有,2发起人, 3合买人等)
     * @param userType 用户类型(1所有,2发起人, 3合买人等)
     */
    public void setUserType(Short userType) {
        this.userType = userType;
    }
    
    public Short getConfigType() {
		return configType;
	}
	public void setConfigType(Short configType) {
		this.configType = configType;
	}
	public Short getRebateUserType() {
        return rebateUserType;
    }

    public void setRebateUserType(Short rebateUserType) {
        this.rebateUserType = rebateUserType;
    }

    /**
     * 合买订单是否参与(0:不参与; 1:参与)
     * @return is_follow_order 合买订单是否参与(0:不参与; 1:参与)
     */
    public Short getIsFollowOrder() {
        return isFollowOrder;
    }

    /**
     * 合买订单是否参与(0:不参与; 1:参与)
     * @param isFollowOrder 合买订单是否参与(0:不参与; 1:参与)
     */
    public void setIsFollowOrder(Short isFollowOrder) {
        this.isFollowOrder = isFollowOrder;
    }

    /**
     * 保底订单是否参与(0:不参与; 1:参与)
     * @return is_care_order 保底订单是否参与(0:不参与; 1:参与)
     */
    public Short getIsCareOrder() {
        return isCareOrder;
    }

    /**
     * 保底订单是否参与(0:不参与; 1:参与)
     * @param isCareOrder 保底订单是否参与(0:不参与; 1:参与)
     */
    public void setIsCareOrder(Short isCareOrder) {
        this.isCareOrder = isCareOrder;
    }

    /**
     * 是否手机(0:否;1:是)
     * @return is_mobile 是否手机(0:否;1:是)
     */
    public Short getIsMobile() {
        return isMobile;
    }

    /**
     * 是否手机(0:否;1:是)
     * @param isMobile 是否手机(0:否;1:是)
     */
    public void setIsMobile(Short isMobile) {
        this.isMobile = isMobile;
    }

    /**
     * 是否真实用户(0:否;1:是)
     * @return Is_real_user 是否真实用户(0:否;1:是)
     */
    public Short getIsRealUser() {
        return isRealUser;
    }

    /**
     * 是否真实用户(0:否;1:是)
     * @param isRealUser 是否真实用户(0:否;1:是)
     */
    public void setIsRealUser(Short isRealUser) {
        this.isRealUser = isRealUser;
    }

    /**
     * 分期次数1为全送，大于1分月
     * @return installment 分期次数1为全送，大于1分月
     */
    public Short getInstallment() {
        return installment;
    }

    /**
     * 分期次数1为全送，大于1分月
     * @param installment 分期次数1为全送，大于1分月
     */
    public void setInstallment(Short installment) {
        this.installment = installment;
    }

    /**
     * 分期额度(分月值大于等于2时输入，用#号分隔)
     * @return installment_money 分期额度(分月值大于等于2时输入，用#号分隔)
     */
    public String getInstallmentMoney() {
        return installmentMoney;
    }

    /**
     * 分期额度(分月值大于等于2时输入，用#号分隔)
     * @param installmentMoney 分期额度(分月值大于等于2时输入，用#号分隔)
     */
    public void setInstallmentMoney(String installmentMoney) {
        this.installmentMoney = installmentMoney == null ? null : installmentMoney.trim();
    }

    /**
     * 优惠次数
     * @return offer_num 优惠次数
     */
    public Short getOfferNum() {
        return offerNum;
    }

    /**
     * 优惠次数
     * @param offerNum 优惠次数
     */
    public void setOfferNum(Short offerNum) {
        this.offerNum = offerNum;
    }

    /**
     * 优惠金额
     * @return offer_money 优惠金额
     */
    public Double getOfferMoney() {
        return offerMoney;
    }

    /**
     * 优惠金额
     * @param offerMoney 优惠金额
     */
    public void setOfferMoney(Double offerMoney) {
        this.offerMoney = offerMoney;
    }

    /**
     * 平台0全部,1WEB;2WAP;3ANDROID;4IOS 多个平台逗号分隔
     * @return platfrom 平台0全部,1WEB;2WAP;3ANDROID;4IOS 多个平台逗号分隔
     */
    public String getPlatfrom() {
        return platfrom;
    }

    /**
     * 平台0全部,1WEB;2WAP;3ANDROID;4IOS 多个平台逗号分隔
     * @param platfrom 平台0全部,1WEB;2WAP;3ANDROID;4IOS 多个平台逗号分隔
     */
    public void setPlatfrom(String platfrom) {
        this.platfrom = platfrom == null ? null : platfrom.trim();
    }

    /**
     * 是否有效(0:否;1:是)
     * @return status 是否有效(0:否;1:是)
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 是否有效(0:否;1:是)
     * @param status 是否有效(0:否;1:是)
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 创建人姓名
     * @return create_by 创建人姓名
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建人姓名
     * @param createBy 创建人姓名
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人姓名
     * @return modify_by 修改人姓名
     */
    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * 修改人姓名
     * @param modifyBy 修改人姓名
     */
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    /**
     * 更新时间(程序应用更新时,修改此时间)
     * @return modify_time 更新时间(程序应用更新时,修改此时间)
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 更新时间(程序应用更新时,修改此时间)
     * @param modifyTime 更新时间(程序应用更新时,修改此时间)
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 修改时间(人为修改时:修改此时间)
     * @return update_time 修改时间(人为修改时:修改此时间)
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间(人为修改时:修改此时间)
     * @param updateTime 修改时间(人为修改时:修改此时间)
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 活动访问url
     * @return url 活动访问url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 活动访问url
     * @param url 活动访问url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

	public List<?> getOperateActivityRulePOList() {
		return operateActivityRulePOList;
	}

	public void setOperateActivityRulePOList(List<?> operateActivityRulePOList) {
		this.operateActivityRulePOList = operateActivityRulePOList;
	}
	
	public List<?> getOperateActivityLottoRulePOList() {
		return operateActivityLottoRulePOList;
	}
	public void setOperateActivityLottoRulePOList(List<?> operateActivityLottoRulePOList) {
		this.operateActivityLottoRulePOList = operateActivityLottoRulePOList;
	}
	public Double getMinRechargeMoney() {
		return minRechargeMoney;
	}
	public void setMinRechargeMoney(Double minRechargeMoney) {
		this.minRechargeMoney = minRechargeMoney;
	}
	public Short getIsDltAdd() {
		return isDltAdd;
	}
	public void setIsDltAdd(Short isDltAdd) {
		this.isDltAdd = isDltAdd;
	}
	public Short getIsCancel() {
		return isCancel;
	}
	public void setIsCancel(Short isCancel) {
		this.isCancel = isCancel;
	}
	public Short getIsAward() {
		return isAward;
	}
	public void setIsAward(Short isAward) {
		this.isAward = isAward;
	}
	public Short getIsActivityPage() {
		return isActivityPage;
	}
	public void setIsActivityPage(Short isActivityPage) {
		this.isActivityPage = isActivityPage;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getMobileIconUrl() {
		return mobileIconUrl;
	}
	public void setMobileIconUrl(String mobileIconUrl) {
		this.mobileIconUrl = mobileIconUrl;
	}
	public String getPcIconUrl() {
		return pcIconUrl;
	}
	public void setPcIconUrl(String pcIconUrl) {
		this.pcIconUrl = pcIconUrl;
	}
	
}