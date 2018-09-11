package com.hhly.cmscore.persistence.ticket.po;

import java.util.Date;

import com.hhly.skeleton.cms.ticketmgr.vo.TicketAlarmInfoVO;

public class TicketAlarmInfoPO {
    private Integer id;

    private Integer typeId;

    private Short alarmType;

    private Short alarmChild;

    private Short alarmLevel;

    private Short status;

    private String alarmInfo;

    private String remark;

    private String dealBy;

    private Date alarmTime;

    private Date dealTime;

    public TicketAlarmInfoPO() {
        
    }

    public TicketAlarmInfoPO(TicketAlarmInfoVO vo) {
        this.id = vo.getId();
        this.typeId = vo.getTypeId();
        this.alarmType = vo.getAlarmType();
        this.alarmChild = vo.getAlarmChild();
        this.alarmLevel = vo.getAlarmLevel();
        this.status = vo.getStatus();
        this.alarmInfo = vo.getAlarmInfo();
        this.remark = vo.getRemark();
        this.dealBy = vo.getDealBy();
        this.alarmTime = vo.getAlarmTime();
        this.dealTime = vo.getDealTime();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Short getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(Short alarmType) {
        this.alarmType = alarmType;
    }

    public Short getAlarmChild() {
        return alarmChild;
    }

    public void setAlarmChild(Short alarmChild) {
        this.alarmChild = alarmChild;
    }

    public Short getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(Short alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getAlarmInfo() {
        return alarmInfo;
    }

    public void setAlarmInfo(String alarmInfo) {
        this.alarmInfo = alarmInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDealBy() {
        return dealBy;
    }

    public void setDealBy(String dealBy) {
        this.dealBy = dealBy;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    
}