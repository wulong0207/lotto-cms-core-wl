package com.hhly.cmscore.persistence.payment.po;

import com.hhly.skeleton.cms.payment.vo.PayChannelVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @desc 银行支付渠道表
 * @author tangxiaobo
 * @date 2017年3月9日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class PayChannelPO {

	private Integer id;
	/**
	 * 渠道名称
	 */
	private String name;
	/**
	 * 银行ID
	 */
	private Integer bankid;
	/**
	 * 渠道支付类型:1网银支付;2快捷支付,3第三方支付
	 */
	private Short type;
	/**
	 * 卡类型:1储蓄卡;2信用卡,3第三方支付
	 */
	private Integer cardtype;
	/**
	 * 是否可用:0不可用;1可用
	 */
	private Short available;
	/**
	 * 是否暂停:0不可用;1可用
	 */
	private Short pause;
	/**
	 * 暂停开始时间
	 */
	private Date begintime;
	/**
	 * 暂停结束时间
	 */
	private Date endtime;
	/**
	 * PC平台
	 */
	private Short pc;
	/**
	 * H5平台
	 */
	private Short h5;
	/**
	 * ANDROID平台
	 */
	private Short android;
	/**
	 * IOS平台
	 */
	private Short ios;
	private Short wechat;
	/**
	 * 排序
	 */
	private Integer orderId;
	private String createBy;
	private String modifyBy;
	private Date modifyTime;
	private Date updateTime;
	private Date createTime;
	
	private String code;
	
	private Double rate;
	
	/**
	 * 是否收费
	 */
	private Integer charge;
	
	private Integer payChannelMgrId;
	
	/**
	 * app调用:1调用sdk，0调用h5
	 */
	private Integer appInvokeType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBankid() {
		return bankid;
	}

	public void setBankid(Integer bankid) {
		this.bankid = bankid;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public Integer getCardtype() {
		return cardtype;
	}

	public void setCardtype(Integer cardtype) {
		this.cardtype = cardtype;
	}

	public Short getAvailable() {
		return available;
	}

	public void setAvailable(Short available) {
		this.available = available;
	}

	public Short getPause() {
		return pause;
	}

	public void setPause(Short pause) {
		this.pause = pause;
	}

	public Date getBegintime() {
		return begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Short getPc() {
		return pc;
	}

	public void setPc(Short pc) {
		this.pc = pc;
	}

	public Short getH5() {
		return h5;
	}

	public void setH5(Short h5) {
		this.h5 = h5;
	}

	public Short getAndroid() {
		return android;
	}

	public void setAndroid(Short android) {
		this.android = android;
	}

	public Short getIos() {
		return ios;
	}

	public void setIos(Short ios) {
		this.ios = ios;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public PayChannelPO() {
		super();
	}

	public PayChannelPO(PayChannelVO vo) {
		super();
		this.id = vo.getId();
		this.name = vo.getName();
		this.bankid = vo.getBankid();
		this.type = vo.getType();
		this.orderId = vo.getOrderId();
		this.available = vo.getAvailable();
		this.pause = vo.getPause();
		this.begintime = vo.getBegintime();
		this.endtime = vo.getEndtime();
		this.pc = vo.getPc();
		this.h5 = vo.getH5();
		this.android = vo.getAndroid();
		this.ios = vo.getIos();
		this.wechat = vo.getWechat();
		this.createBy = vo.getCreateBy();
		this.createTime = vo.getCreateTime();
		this.modifyBy = vo.getModifyBy();
		this.modifyTime = vo.getModifyTime();
		this.cardtype = vo.getCardtype();
		this.code=vo.getCode();
		this.rate=vo.getRate();
		this.charge=vo.getCharge();
		this.payChannelMgrId=vo.getPayChannelMgrId();
		this.appInvokeType=vo.getAppInvokeType();
	}

	public static List<PayChannelPO> newInstanceList(List<PayChannelVO> bankChannels) {
		List<PayChannelPO> pos;
		if(bankChannels == null || bankChannels.size()==0)
			pos = Collections.<PayChannelPO>emptyList();
		else {
			pos = new ArrayList<>();
			for(PayChannelVO vo : bankChannels)
				pos.add(new PayChannelPO(vo));
		}
		return pos;
	}
	
	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Integer getCharge() {
		return charge;
	}

	public void setCharge(Integer charge) {
		this.charge = charge;
	}

	public Integer getPayChannelMgrId() {
		return payChannelMgrId;
	}

	public void setPayChannelMgrId(Integer payChannelMgrId) {
		this.payChannelMgrId = payChannelMgrId;
	}

	public Integer getAppInvokeType() {
		return appInvokeType;
	}

	public void setAppInvokeType(Integer appInvokeType) {
		this.appInvokeType = appInvokeType;
	}

	public Short getWechat() {
		return wechat;
	}

	public void setWechat(Short wechat) {
		this.wechat = wechat;
	}

	@Override
	public String toString() {
		return "PayChannelPO [id=" + id + ", name=" + name + ", bankid=" + bankid + ", type=" + type + ", cardtype="
				+ cardtype + ", available=" + available + ", pause=" + pause + ", begintime=" + begintime + ", endtime="
				+ endtime + ", pc=" + pc + ", h5=" + h5 + ", android=" + android + ", ios=" + ios + ", orderId="
				+ orderId + ", createBy=" + createBy + ", modifyBy=" + modifyBy + ", modifyTime=" + modifyTime
				+ ", updateTime=" + updateTime + ", createTime=" + createTime + "]";
	}
}
