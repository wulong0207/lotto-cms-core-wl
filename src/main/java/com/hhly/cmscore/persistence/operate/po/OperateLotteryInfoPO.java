package com.hhly.cmscore.persistence.operate.po;

import java.util.Date;

import com.hhly.skeleton.cms.operatemgr.vo.OperateLotteryInfoVO;

public class OperateLotteryInfoPO {
	/**
	 * 自增长主键ID
	 */
	private final Long id;

	/**
	 * 栏目ID,关联operateLottery的id
	 */
	private final Long lotteryId;

	/**
	 * 彩种ID
	 */
	private final Integer typeId;

	// /**
	// * 彩种名称
	// */
	// private String typeName;

	/**
	 * 彩种类型ID:1：数字彩；2：高频彩；3：竞技彩
	 */
	private final Byte categoryId;

	// /**
	// * 彩种类型名称
	// */
	// private String categoryName;

	/**
	 * 彩种别名
	 */
	private final String typeAlias;

	/**
	 * 彩种链接
	 */
	private final String typeUrl;

	/**
	 * 是否显示:0否;1是;2设定时间下线
	 */
	private final Byte display;

	/**
	 * 下线时间
	 */
	private final Date offlineTime;

	/**
	 * 运营图标:0无;1新;2热;3加奖;4其他
	 */
	private final Byte icon;

	/**
	 * 打开方式:0:_blank;1:_self;
	 */
	private final Byte target;

	/**
	 * 运营文案
	 */
	private final String typeKey;

	/**
	 * 文案链接
	 */
	private final String typeKeyUrl;

	/**
	 * 排序
	 */
	private final Integer orderId;

	/**
	 * 颜色
	 */
	private String color;
	/**
	 * 彩种运营url
	 */
	private final String url;

	/**
	 * 子玩法
	 */
	private Integer lotteryChildCode;
	
	/**
	 * 彩种描述
	 */
	private String lotteryDescribe;

	public OperateLotteryInfoPO(OperateLotteryInfoVO lotteryInfo) {
		this.id = lotteryInfo.getId();
		this.lotteryId = lotteryInfo.getLotteryId();
		this.typeId = lotteryInfo.getTypeId();
		this.categoryId = lotteryInfo.getCategoryId();
		this.typeAlias = lotteryInfo.getTypeAlias();
		this.typeUrl = lotteryInfo.getTypeUrl();
		this.display = lotteryInfo.getDisplay();
		this.offlineTime = lotteryInfo.getOfflineTime();
		this.icon = lotteryInfo.getIcon();
		this.target = lotteryInfo.getTarget();
		this.typeKey = lotteryInfo.getTypeKey();
		this.typeKeyUrl = lotteryInfo.getTypeKeyUrl();
		this.orderId = lotteryInfo.getOrderId();
		this.color = lotteryInfo.getColor();
		this.url = lotteryInfo.getUrl();
		this.lotteryChildCode = lotteryInfo.getLotteryChildCode();
		this.lotteryDescribe = lotteryInfo.getLotteryDescribe();
	}

	public Long getId() {
		return id;
	}

	public Long getLotteryId() {
		return lotteryId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public Byte getCategoryId() {
		return categoryId;
	}

	public String getTypeAlias() {
		return typeAlias;
	}

	public String getTypeUrl() {
		return typeUrl;
	}

	public Byte getDisplay() {
		return display;
	}

	public Date getOfflineTime() {
		return offlineTime;
	}

	public Byte getIcon() {
		return icon;
	}

	public Byte getTarget() {
		return target;
	}

	public String getTypeKey() {
		return typeKey;
	}

	public String getTypeKeyUrl() {
		return typeKeyUrl;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getUrl() {
		return url;
	}

	public Integer getLotteryChildCode() {
		return lotteryChildCode;
	}

	public String getLotteryDescribe() {
		return lotteryDescribe;
	}

	public void setLotteryDescribe(String lotteryDescribe) {
		this.lotteryDescribe = lotteryDescribe;
	}

	public void setLotteryChildCode(Integer lotteryChildCode) {
		this.lotteryChildCode = lotteryChildCode;
	}

}