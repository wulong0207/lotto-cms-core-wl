package com.hhly.cmscore.persistence.lottery.po;

import java.util.Date;

import com.hhly.skeleton.base.common.LotteryEnum.LotteryLimitWay;
import com.hhly.skeleton.base.util.StringUtil;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryLimitVO;

/**
 * @desc 彩种限号
 * @author huangb
 * @date 2017年2月14日
 * @company 益彩网络
 * @version v1.0
 */
public class LotteryLimitPO {

	/**
	 * 增长id
	 */
	private Integer id;
	/**
	 * 彩种编码
	 */
	private Integer lotteryCode;
	/**
	 * 状态；；1：启用；2：禁用；3：过期
	 */
	private Short status;
	/**
	 * 限号类型;;1：所有类型；2：全匹配内容限制；3：部分匹配该内容限制
	 */
	private Short limitType;
	/**
	 * 限号彩期开始
	 */
	private String issueStart;
	/**
	 * 限号彩期结束
	 */
	private String issueEnd;
	/**
	 * 限号时间开始
	 */
	private Date timeStart;
	/**
	 * 限号时间结束
	 */
	private Date timeEnd;
	/**
	 * 1：限号彩期；2：限号时间
	 */
	private Short limitWay;
	/**
	 * 创建人姓名
	 */
	private String createBy;
	/**
	 * 修改人姓名
	 */
	private String modifyBy;
	/**
	 * 备注
	 */
	private String remark;

	public LotteryLimitPO() {
	}

	/**
	 * 构造方法
	 * 
	 * @param lotteryLimit
	 *            参数对象
	 */
	public LotteryLimitPO(LotteryLimitVO lotteryLimit) {
		super();
		this.id = lotteryLimit.getId();
		this.lotteryCode = lotteryLimit.getLotteryCode();
		this.status = lotteryLimit.getStatus();
		this.limitType = lotteryLimit.getLimitType();
		this.issueStart = lotteryLimit.getIssueStart();
		this.issueEnd = lotteryLimit.getIssueEnd();
		this.timeStart = lotteryLimit.getTimeStart();
		this.timeEnd = lotteryLimit.getTimeEnd();
		this.limitWay = lotteryLimit.getLimitWay();
		// (限号方式字段目前无用) 限号方式根据限号彩期范围和限号时间范围来判断
		if (this.limitWay == null) {
			if (this.timeStart != null || this.timeEnd != null) {
				this.limitWay = LotteryLimitWay.LIMIT_TIME.getValue();
			}
			if (!StringUtil.isBlank(this.issueStart) || !StringUtil.isBlank(this.issueEnd)) {
				this.limitWay = LotteryLimitWay.LIMIT_ISSUE.getValue();
			}
		}
		this.createBy = lotteryLimit.getCreateBy();
		this.modifyBy = lotteryLimit.getModifyBy();
		this.remark = lotteryLimit.getRemark();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLotteryCode() {
		return lotteryCode;
	}

	public void setLotteryCode(Integer lotteryCode) {
		this.lotteryCode = lotteryCode;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getLimitType() {
		return limitType;
	}

	public void setLimitType(Short limitType) {
		this.limitType = limitType;
	}

	public String getIssueStart() {
		return issueStart;
	}

	public void setIssueStart(String issueStart) {
		this.issueStart = issueStart;
	}

	public String getIssueEnd() {
		return issueEnd;
	}

	public void setIssueEnd(String issueEnd) {
		this.issueEnd = issueEnd;
	}

	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Short getLimitWay() {
		return limitWay;
	}

	public void setLimitWay(Short limitWay) {
		this.limitWay = limitWay;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
