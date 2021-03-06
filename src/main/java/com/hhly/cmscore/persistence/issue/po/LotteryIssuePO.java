package com.hhly.cmscore.persistence.issue.po;

import java.util.Date;

import com.hhly.skeleton.cms.lotterymgr.vo.LotteryIssueCmsVO;




public class LotteryIssuePO {
	private Integer id;
	
    private Integer lotteryCode;

    private String issueCode;

    private String lotteryName;

    private Short currentIssue;

    private Short saleStatus;

    private Date officialEndTime;
    
    private Date officialStartTime;

    private Date lotteryTime;

    private Date saleTime;

    private Date saleEndTime;

    private Long salesAmount;

    private Long jackpotAmount;

    private String drawCode;
    
    private String drawCodeTest;

    private String drawDetail;

    private String createBy;

    private String modifyBy;

    private Date modifyTime;

    private Date updateTime;

    private Date createTime;

    private String remark;
    
    private Integer issueLastest;
    
    public LotteryIssuePO() {
    	super();
	}
    
	public LotteryIssuePO(LotteryIssueCmsVO vo) {
		super();
		this.id = vo.getId();
		this.lotteryCode = vo.getLotteryCode();
		this.issueCode = vo.getIssueCode();
		this.lotteryName = vo.getLotteryName();
		this.currentIssue = vo.getCurrentIssue();
		this.saleStatus = vo.getSaleStatus();
		this.officialEndTime = vo.getOfficialEndTime();
		this.lotteryTime = vo.getLotteryTime();
		this.saleTime = vo.getSaleTime();
		this.saleEndTime = vo.getSaleEndTime();
		this.salesAmount = vo.getSalesAmount();
		this.jackpotAmount = vo.getJackpotAmount();
		this.drawCode = vo.getDrawCode();
		this.drawDetail = vo.getDrawDetail();
		this.createBy = vo.getCreateBy();
		this.modifyBy = vo.getModifyBy();
		this.remark = vo.getRemark();
		this.issueLastest = vo.getIssueLastest();
		this.drawCodeTest = vo.getDrawCodeTest();
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

    public String getIssueCode() {
		return issueCode;
	}

	public void setIssueCode(String issueCode) {
		this.issueCode = issueCode;
	}

	public String getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}

	public Short getCurrentIssue() {
		return currentIssue;
	}

	public void setCurrentIssue(Short currentIssue) {
		this.currentIssue = currentIssue;
	}

	public Short getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(Short saleStatus) {
		this.saleStatus = saleStatus;
	}

	public Date getOfficialEndTime() {
		return officialEndTime;
	}

	public void setOfficialEndTime(Date officialEndTime) {
		this.officialEndTime = officialEndTime;
	}

	public Date getLotteryTime() {
		return lotteryTime;
	}

	public void setLotteryTime(Date lotteryTime) {
		this.lotteryTime = lotteryTime;
	}

	public Date getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}

	public Date getSaleEndTime() {
		return saleEndTime;
	}

	public void setSaleEndTime(Date saleEndTime) {
		this.saleEndTime = saleEndTime;
	}

	public Long getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(Long salesAmount) {
		this.salesAmount = salesAmount;
	}

	public Long getJackpotAmount() {
		return jackpotAmount;
	}

	public void setJackpotAmount(Long jackpotAmount) {
		this.jackpotAmount = jackpotAmount;
	}

	public String getDrawCode() {
		return drawCode;
	}

	public void setDrawCode(String drawCode) {
		this.drawCode = drawCode;
	}

	public String getDrawDetail() {
		return drawDetail;
	}

	public void setDrawDetail(String drawDetail) {
		this.drawDetail = drawDetail;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getOfficialStartTime() {
		return officialStartTime;
	}

	public void setOfficialStartTime(Date officialStartTime) {
		this.officialStartTime = officialStartTime;
	}

	public Integer getIssueLastest() {
		return issueLastest;
	}

	public void setIssueLastest(Integer issueLastest) {
		this.issueLastest = issueLastest;
	}

	/**
	 * @return the drawCodeTest
	 */
	public String getDrawCodeTest() {
		return drawCodeTest;
	}

	/**
	 * @param drawCodeTest the drawCodeTest to set
	 */
	public void setDrawCodeTest(String drawCodeTest) {
		this.drawCodeTest = drawCodeTest;
	}
}