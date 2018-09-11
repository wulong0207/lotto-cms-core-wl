package com.hhly.cmscore.persistence.lottery.po;

import java.util.Date;

import com.hhly.skeleton.cms.lotterymgr.vo.LotteryChildCmsVO;



public class LotteryChildPO {
    private Integer id;

    private Integer lotteryChildCode;

    private Integer lotteryCode;

    private String childName;

    private Short saleStatus;

    private Date updateTime;

    private Date createTime;

   
    public LotteryChildPO() {
    	
    }
    public LotteryChildPO(LotteryChildCmsVO vo) {
		super();
		this.id = vo.getId();
		this.lotteryChildCode = vo.getLotteryChildCode();
		this.lotteryCode = vo.getLotteryCode();
		this.childName = vo.getChildName();
		this.saleStatus = vo.getSaleStatus();
	}

	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

    

    public Integer getLotteryChildCode() {
        return lotteryChildCode;
    }
    public void setLotteryChildCode(Integer lotteryChildCode) {
        this.lotteryChildCode = lotteryChildCode;
    }
    public Integer getLotteryCode() {
        return lotteryCode;
    }
    public void setLotteryCode(Integer lotteryCode) {
        this.lotteryCode = lotteryCode;
    }
    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName == null ? null : childName.trim();
    }

    public Short getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Short saleStatus) {
        this.saleStatus = saleStatus;
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