package com.hhly.cmscore.persistence.ticket.po;

import java.util.Date;

import com.hhly.skeleton.cms.ticketmgr.vo.TicketMonitorCommonVO;


public class TicketMonitorCommonPO {
    private Integer id;

    private Integer parameter;

    private String remark;
    
    private String createBy;

    private String modifyBy;

    private Date modifyTime;

    private Date updateTime;

    private Date createTime;
    
    

    public TicketMonitorCommonPO() {
    }

    public  TicketMonitorCommonPO(TicketMonitorCommonVO vo) {
        super();
        this.id = vo.getId();
        this.parameter = vo.getParameter();
        this.remark = vo.getRemark();
        this.createBy = vo.getCreateBy();
        this.modifyBy = vo.getModifyBy();
        this.modifyTime = vo.getModifyTime();
        this.updateTime = vo.getUpdateTime();
        this.createTime = vo.getCreateTime();
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParameter() {
        return parameter;
    }

    public void setParameter(Integer parameter) {
        this.parameter = parameter;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

   
}