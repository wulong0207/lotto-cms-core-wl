package com.hhly.cmscore.persistence.payment.po;

import java.util.Date;

import com.hhly.skeleton.cms.payment.vo.PayChannelMgrVO;

/**
 * @desc    支付渠道管理PO
 * @author  Tony Wang
 * @date    2017年12月2日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class PayChannelMgrPO {

	private Integer id;

    private String name;

    private String code;

    private Integer orderId;

    private Double minPay;

    private Double maxPay;

    private Double rate;

    private Short pc;

    private Short h5;

    private Short android;

    private Short ios;

    private Short available;

    private Short pause;

    private Date beginTime;

    private Date endTime;

    private String createBy;

    private Date createTime;

    private String modifyBy;

    private Date modifyTime;

    private String remark;

	public PayChannelMgrPO(PayChannelMgrVO vo) {
		this.id = vo.getId();
		this.name = vo.getName();
		this.code = vo.getCode();
		this.orderId = vo.getOrderId();
		this.minPay = vo.getMinPay();
		this.maxPay = vo.getMaxPay();
		this.rate = vo.getRate();
		this.pc = vo.getPc();
		this.h5 = vo.getH5();
		this.android = vo.getAndroid();
		this.ios = vo.getIos();
		this.available = vo.getAvailable();
		this.pause = vo.getPause();
		this.beginTime = vo.getBeginTime();
		this.endTime = vo.getEndTime();
		this.createBy = vo.getCreateBy();
		this.createTime = vo.getCreateTime();
		this.modifyBy = vo.getModifyBy();
		this.modifyTime = vo.getModifyTime();
		this.remark = vo.getRemark();
	}

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Double getMinPay() {
		return minPay;
	}

	public void setMinPay(Double minPay) {
		this.minPay = minPay;
	}

	public Double getMaxPay() {
		return maxPay;
	}

	public void setMaxPay(Double maxPay) {
		this.maxPay = maxPay;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
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

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
