package com.hhly.cmscore.persistence.operate.po;

import com.hhly.skeleton.cms.operatemgr.vo.OperateFastInfoVO;

public class OperateFastInfoPO {
	/**
	 * 自增长主键ID
	 */
  private  Long id;

  /**
   * 栏目ID,关联operateFast的id
   */
  private  Long fastId;

  /**
   * 彩种ID
   */
  private  Integer typeId;


  /**
   * 彩种类型ID:1：数字彩；2：高频彩；3：竞技彩
   */
  private  Byte categoryId;

  /**
   * 页签别名
   */
  private String fastAlias;

  /**
   * 页签链接
   */
  private String fastUrl;

  /**
   * 默认选中:0否;1是
   */
  private Byte fastSelected;
	
  /**
   * 默认倍数
   */
  private Integer multiple;

  /**
   * 运营图标:0无;1新;2热;3加奖;4其他
   */
  private  Byte icon;

  /**
   * 打开方式:0:_blank;1:_self;
   */
  private  Byte target;

  /**
   * 运营文案
   */
  private  String typeKey;

  /**
   * 文案链接
   */
  private  String typeKeyUrl;
  
  /**
   * 排序
   */
  private  Integer orderId;

  
	public OperateFastInfoPO(OperateFastInfoVO lotteryInfo) {
		this.id = lotteryInfo.getId();
		this.fastId = lotteryInfo.getFastId();
		this.typeId = lotteryInfo.getTypeId();
		this.fastAlias = lotteryInfo.getFastAlias();
		this.fastUrl = lotteryInfo.getFastUrl();
		this.fastSelected = lotteryInfo.getFastSelected();
		this.multiple = lotteryInfo.getMultiple();
		this.categoryId = lotteryInfo.getCategoryId();
		this.icon = lotteryInfo.getIcon();
		this.target = lotteryInfo.getTarget();
		this.typeKey = lotteryInfo.getTypeKey();
		this.typeKeyUrl = lotteryInfo.getTypeKeyUrl();
		this.orderId = lotteryInfo.getOrderId();
	}

	public String getFastAlias() {
		return fastAlias;
	}

	public void setFastAlias(String fastAlias) {
		this.fastAlias = fastAlias;
	}

	public String getFastUrl() {
		return fastUrl;
	}

	public void setFastUrl(String fastUrl) {
		this.fastUrl = fastUrl;
	}

	public Byte getFastSelected() {
		return fastSelected;
	}

	public void setFastSelected(Byte fastSelected) {
		this.fastSelected = fastSelected;
	}

	public Integer getMultiple() {
		return multiple;
	}

	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}

	public Long getFastId() {
		return fastId;
	}

	public Long getId() {
		return id;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public Byte getCategoryId() {
		return categoryId;
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

}