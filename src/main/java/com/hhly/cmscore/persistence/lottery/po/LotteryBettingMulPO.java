package com.hhly.cmscore.persistence.lottery.po;

import java.util.Date;

import com.hhly.skeleton.cms.lotterymgr.vo.LotteryBettingMulCmsVO;



public class LotteryBettingMulPO {
    private Integer id;

    private Integer lotteryCode;

    private Integer bettindNum;

    private Integer multipleNum;

    private Integer endTime;

    private Date updateTime;

    private Date createTime;
    
    public LotteryBettingMulPO() {}

    public LotteryBettingMulPO(LotteryBettingMulCmsVO vo) {
		super();
		this.id = vo.getId();
		this.lotteryCode = vo.getLotteryCode();
		this.bettindNum = vo.getBettindNum();
		this.multipleNum = vo.getMultipleNum();
		this.endTime = vo.getEndTime();
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

    public Integer getBettindNum() {
        return bettindNum;
    }

    public void setBettindNum(Integer bettindNum) {
        this.bettindNum = bettindNum;
    }

    public Integer getMultipleNum() {
        return multipleNum;
    }

    public void setMultipleNum(Integer multipleNum) {
        this.multipleNum = multipleNum;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
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
}