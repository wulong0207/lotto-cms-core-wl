package com.hhly.cmscore.persistence.ticket.po;

import java.util.Date;

import com.hhly.skeleton.base.util.ObjectUtil;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketMonitorConfigVO;

public class TicketMonitorConfigPO {
    
    private Integer id;

    private Integer lotteryId;

    private String lotteryName;

    /**
     * 未拆方案数
     */
    private Integer noSplit;

    /**
     * 截止未出数
     */
    private Integer noOut;

    /**
     * 未出票金额
     */
    private Integer noOutMoney;

    /**
     * 未送票数
     */
    private Integer noSend;

    /**
     * 已送票数
     */
    private Integer send;

    /**
     * 截止时间
     */
    private Integer endTime;

    /**
     * 出票商票数
     */
    private Integer channelTicketNum;

    /**
     * 出票商金额
     */
    private Integer channelMoney;

    /**
     * 最早送票时间
     */
    private Integer maxSendtime;

    /**
     * refresh_time
     */
    private String refreshTime;
    
    /**
     * 彩期开奖截止前时间
     */
    private Integer beforeIssueEnd;
    
    /**
     * 彩期开奖截止前刷新频率(秒)
     */
    private Integer beforeIssueEndSecond;

    private Short status;
    
    private String createBy;

    private String modifyBy;

    private Date modifyTime;

    private Date updateTime;

    private Date createTime;
    

    public TicketMonitorConfigPO() {
    }

    public TicketMonitorConfigPO(TicketMonitorConfigVO vo) {
        super();
        this.id = vo.getId();
        this.lotteryId = vo.getLotteryId();
        this.lotteryName = vo.getLotteryName();
        this.noSplit = ObjectUtil.isBlank(vo.getNoSplit()) ? 0 : vo.getNoSplit();
        this.noOut = ObjectUtil.isBlank(vo.getNoOut()) ? 0 : vo.getNoOut();
        this.noOutMoney = ObjectUtil.isBlank(vo.getNoOutMoney()) ? 0 : vo.getNoOutMoney();
        this.noSend = ObjectUtil.isBlank(vo.getNoSend()) ? 0 : vo.getNoSend();
        this.send = ObjectUtil.isBlank(vo.getSend()) ? 0 : vo.getSend();
        this.endTime = ObjectUtil.isBlank(vo.getEndTime()) ? 0 : vo.getEndTime();
        this.channelTicketNum = ObjectUtil.isBlank(vo.getChannelTicketNum()) ? 0 : vo.getChannelTicketNum();
        this.channelMoney = ObjectUtil.isBlank(vo.getChannelMoney()) ? 0 : vo.getChannelMoney();
        this.maxSendtime = ObjectUtil.isBlank(vo.getMaxSendtime()) ? 0 : vo.getMaxSendtime();
        this.refreshTime = vo.getRefreshTime();
        this.status = vo.getStatus();
        this.createBy = vo.getCreateBy();
        this.modifyBy = vo.getModifyBy();
        this.modifyTime = vo.getModifyTime();
        this.updateTime = vo.getUpdateTime();
        this.createTime = vo.getCreateTime();
        this.beforeIssueEnd = ObjectUtil.isBlank(vo.getBeforeIssueEnd()) ? 0 : vo.getBeforeIssueEnd();
        this.beforeIssueEndSecond = ObjectUtil.isBlank(vo.getBeforeIssueEndSecond()) ? 0 : vo.getBeforeIssueEndSecond();
    }

    
    public Integer getBeforeIssueEnd() {
        return beforeIssueEnd;
    }

    public void setBeforeIssueEnd(Integer beforeIssueEnd) {
        this.beforeIssueEnd = beforeIssueEnd;
    }

    public Integer getBeforeIssueEndSecond() {
        return beforeIssueEndSecond;
    }

    public void setBeforeIssueEndSecond(Integer beforeIssueEndSecond) {
        this.beforeIssueEndSecond = beforeIssueEndSecond;
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

    public Integer getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(Integer lotteryId) {
        this.lotteryId = lotteryId;
    }

    public String getLotteryName() {
        return lotteryName;
    }

    public void setLotteryName(String lotteryName) {
        this.lotteryName = lotteryName;
    }

    public Integer getNoSplit() {
        return noSplit;
    }

    public void setNoSplit(Integer noSplit) {
        this.noSplit = noSplit;
    }

    public Integer getNoOut() {
        return noOut;
    }

    public void setNoOut(Integer noOut) {
        this.noOut = noOut;
    }

    public Integer getNoOutMoney() {
        return noOutMoney;
    }

    public void setNoOutMoney(Integer noOutMoney) {
        this.noOutMoney = noOutMoney;
    }

    public Integer getNoSend() {
        return noSend;
    }

    public void setNoSend(Integer noSend) {
        this.noSend = noSend;
    }

    public Integer getSend() {
        return send;
    }

    public void setSend(Integer send) {
        this.send = send;
    }

    

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getChannelTicketNum() {
        return channelTicketNum;
    }

    public void setChannelTicketNum(Integer channelTicketNum) {
        this.channelTicketNum = channelTicketNum;
    }

    public Integer getChannelMoney() {
        return channelMoney;
    }

    public void setChannelMoney(Integer channelMoney) {
        this.channelMoney = channelMoney;
    }

    public Integer getMaxSendtime() {
        return maxSendtime;
    }

    public void setMaxSendtime(Integer maxSendtime) {
        this.maxSendtime = maxSendtime;
    }

    

    public String getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(String refreshTime) {
        this.refreshTime = refreshTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}