package com.hhly.cmscore.persistence.payment.po;

import com.hhly.skeleton.cms.payment.vo.PayBankVO;

import java.util.Date;

/**
 * @desc 银行支付管理表
 * @author tangxiaobo
 * @date 2017年3月9日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class PayBankPO {

	private Integer id;
	/**
	 * 银行名称
	 */
	private String name;
	/**
	 * 银行简称
	 */
	private String cname;
	/**
	 * 银行状态:0停用,1可用
	 */
	private Short status;
	/**
	 * 支付类型:1银行卡,2第三方支付
	 */
	private Short paytype;
	/**
	 * 银行大Logo
	 */
	private String blogo;
	/**
	 * 银行小Logo
	 */
	private String slogo;
	/**
	 * PC排序
	 */
	private Integer orderPc;
	/**
	 * H5排序
	 */
	private Integer orderH5;
	/**
	 * ANDROID排序
	 */
	private Integer orderAndroid;
	/**
	 * IOS排序
	 */
	private Integer orderIos;
	/**
	 * 备注
	 */
	private String remark;
	private String createBy;
	private String modifyBy;
	private Date modifyTime;
	private Date updateTime;
	private Date createTime;
	private String code;

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

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getPaytype() {
		return paytype;
	}

	public void setPaytype(Short paytype) {
		this.paytype = paytype;
	}

	public String getBlogo() {
		return blogo;
	}

	public void setBlogo(String blogo) {
		this.blogo = blogo;
	}

	public String getSlogo() {
		return slogo;
	}

	public void setSlogo(String slogo) {
		this.slogo = slogo;
	}

	public Integer getOrderPc() {
		return orderPc;
	}

	public void setOrderPc(Integer orderPc) {
		this.orderPc = orderPc;
	}

	public Integer getOrderH5() {
		return orderH5;
	}

	public void setOrderH5(Integer orderH5) {
		this.orderH5 = orderH5;
	}

	public Integer getOrderAndroid() {
		return orderAndroid;
	}

	public void setOrderAndroid(Integer orderAndroid) {
		this.orderAndroid = orderAndroid;
	}

	public Integer getOrderIos() {
		return orderIos;
	}

	public void setOrderIos(Integer orderIos) {
		this.orderIos = orderIos;
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

	public PayBankPO(){
		super();
	}
	
	public PayBankPO(PayBankVO vo) {
		super();

		this.id = vo.getId();
		this.name = vo.getName();
		this.cname = vo.getCname();
		this.status = vo.getStatus();
		this.paytype = vo.getPaytype();
		this.blogo = vo.getBlogo();
		this.slogo = vo.getSlogo();
		this.remark = vo.getRemark();
		this.createBy = vo.getCreateBy();
		this.modifyBy = vo.getModifyBy();

		this.orderPc = vo.getOrderPc();
		this.orderAndroid = vo.getOrderAndroid();
		this.orderH5 = vo.getOrderH5();
		this.orderIos = vo.getOrderIos();
		this.code = vo.getCode();
	}

}
