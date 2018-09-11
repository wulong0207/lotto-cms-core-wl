package com.hhly.cmscore.persistence.payment.po;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hhly.skeleton.cms.payment.vo.PayChannelLimitVO;

/**
 * @desc    支付渠道限额管理PO
 * @author  Tony Wang
 * @date    2017年12月2日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class PayChannelLimitPO {

	private Integer id;

	private Integer payChannelMgrId;

	private Double limittime;

	private Double limitday;

	private Double limitmonth;

	private Integer payType;

	private Integer cardType;

	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPayChannelMgrId() {
		return payChannelMgrId;
	}

	public void setPayChannelMgrId(Integer payChannelMgrId) {
		this.payChannelMgrId = payChannelMgrId;
	}

	public Double getLimittime() {
		return limittime;
	}

	public void setLimittime(Double limittime) {
		this.limittime = limittime;
	}

	public Double getLimitday() {
		return limitday;
	}

	public void setLimitday(Double limitday) {
		this.limitday = limitday;
	}

	public Double getLimitmonth() {
		return limitmonth;
	}

	public void setLimitmonth(Double limitmonth) {
		this.limitmonth = limitmonth;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	public PayChannelLimitPO(PayChannelLimitVO vo) {
		this.id = vo.getId();
		this.payChannelMgrId = vo.getPayChannelMgrId();
		this.limittime = vo.getLimittime();
		this.limitday = vo.getLimitday();
		this.limitmonth = vo.getLimitmonth();
		this.payType = vo.getPayType();
		this.cardType = vo.getCardType();
		this.remark = vo.getRemark();
	}

	public static List<PayChannelLimitPO> newInstanceList(List<PayChannelLimitVO> vos) {
		List<PayChannelLimitPO> pos;
		if(vos == null || vos.size()==0)
			pos = Collections.<PayChannelLimitPO>emptyList();
		else {
			pos = new ArrayList<>();
			for(PayChannelLimitVO vo : vos)
				pos.add(new PayChannelLimitPO(vo));
		}
		return pos;
	}

}
