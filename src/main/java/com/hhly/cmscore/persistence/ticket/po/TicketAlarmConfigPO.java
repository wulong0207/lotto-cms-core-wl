package com.hhly.cmscore.persistence.ticket.po;

import java.util.Date;

import com.hhly.skeleton.cms.ticketmgr.vo.TicketAlarmConfigVO;

public class TicketAlarmConfigPO {
    private Integer id;

    private Short alarmType;

    private Short alarmChild;

    private Short status;

    private Short alarmLevel;

    private Long parameter;

    private String format;

    private String createBy;

    private String modifyBy;

    private Date modifyTime;

    private Date updateTime;

    private Date createTime;

    public TicketAlarmConfigPO() {
    }

    public TicketAlarmConfigPO(TicketAlarmConfigVO vo) {
        this.id = vo.getId();
        this.alarmType = vo.getAlarmType();
        this.alarmChild = vo.getAlarmChild();
        this.status = vo.getStatus();
        this.alarmLevel = vo.getAlarmLevel();
        this.parameter = vo.getParameter();
        this.format = vo.getFormat();
        this.createBy = vo.getCreateBy();
        this.modifyBy = vo.getModifyBy();
        this.modifyTime = vo.getModifyTime();
        this.updateTime = vo.getUpdateTime();
        this.createTime = vo.getCreateTime();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(Short alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    public Long getParameter() {
        return parameter;
    }

    public void setParameter(Long parameter) {
        this.parameter = parameter;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
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

   
}