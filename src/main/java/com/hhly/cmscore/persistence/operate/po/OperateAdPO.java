package com.hhly.cmscore.persistence.operate.po;

import java.util.Date;

import com.hhly.skeleton.cms.operatemgr.vo.OperateAdVO;

public class OperateAdPO {

	private Long id;
	private String advCode;
	private String advTitle;
	private String platform;
	private Short menu;
	private Short position;
	private String positionInfo;
	private Short status;
	private Short target;
	private String url;
	private String img;
	private Date onlineTime;
	private Date offlineTime;
	private Short orderId;
	private String remark;
	private String createBy;
	private String modifyBy;
	private Integer lotteryCode;
	/**
	 * 是否默认 0：否，1：是
	 */
	private Integer defaultAd;
	/**
	 * 广告可见次数:1每次刷新;2每小时;3每天;4每周;5可见一次
	 */
	private final Byte display;

	public OperateAdPO(OperateAdVO vo) {
		this.id = vo.getId();
		this.advCode = vo.getAdvCode();
		this.advTitle = vo.getAdvTitle();
		this.platform = vo.getPlatform();
		this.menu = vo.getMenu();
		this.position = vo.getPosition();
		// this.positionCode = vo.getPositionCode();
		this.positionInfo = vo.getPositionInfo();
		this.status = vo.getStatus();
		this.target = vo.getTarget();
		this.url = vo.getAdUrl();
		this.img = vo.getImg();
		this.onlineTime = vo.getOnlineTime();
		this.offlineTime = vo.getOfflineTime();
		this.orderId = vo.getOrderId();
		this.remark = vo.getRemark();
		this.createBy = vo.getCreateBy();
		this.modifyBy = vo.getModifyBy();
		this.display = vo.getDisplay();
		this.defaultAd = vo.getDefaultAd();
		this.lotteryCode = vo.getLotteryCode();
	}

	public Integer getLotteryCode() {
		return lotteryCode;
	}

	public void setLotteryCode(Integer lotteryCode) {
		this.lotteryCode = lotteryCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdvCode() {
		return advCode;
	}

	public void setAdvCode(String advCode) {
		this.advCode = advCode;
	}

	public String getAdvTitle() {
		return advTitle;
	}

	public void setAdvTitle(String advTitle) {
		this.advTitle = advTitle;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Short getMenu() {
		return menu;
	}

	public void setMenu(Short menu) {
		this.menu = menu;
	}

	public Short getPosition() {
		return position;
	}

	public void setPosition(Short position) {
		this.position = position;
	}

	public String getPositionInfo() {
		return positionInfo;
	}

	public void setPositionInfo(String positionInfo) {
		this.positionInfo = positionInfo;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getTarget() {
		return target;
	}

	public void setTarget(Short target) {
		this.target = target;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(Date onlineTime) {
		this.onlineTime = onlineTime;
	}

	public Date getOfflineTime() {
		return offlineTime;
	}

	public void setOfflineTime(Date offlineTime) {
		this.offlineTime = offlineTime;
	}

	public Short getOrderId() {
		return orderId;
	}

	public void setOrderId(Short orderId) {
		this.orderId = orderId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Byte getDisplay() {
		return display;
	}

	public Integer getDefaultAd() {
		return defaultAd;
	}

	public void setDefaultAd(Integer defaultAd) {
		this.defaultAd = defaultAd;
	}
	
}