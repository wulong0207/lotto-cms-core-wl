package com.hhly.cmscore.cms.remote.service.monitor.entity;

/**
 * @desc 保存刷新时间周期
 * @author jiangwei
 * @date 2017-2-16
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class RefreshTime {
    //周
    private int week;
    //开始时间(当天秒)
    private int start;
    //结束时间(当天秒)
    private int end;
    //属性间隔
    private int time;

    

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    
}
