package com.hhly.cmscore.persistence.sport.po;

import java.util.Date;

import com.hhly.skeleton.cms.sportmgr.vo.SportTeamInfoVO;

public class SportTeamInfoPO {
	/**
     * 自增长主键
     */
    private Long id;

    /**
     * 球队ID
     */
    private Long teamId;

    /**
     * 球队类型:1足球;2篮球
     */
    private Short teamType;

    /**
     * 球队资料URL，唯一，第三方的球队ID。例如：一比分。以便链接到一比分的球队详情页面
     */
    private String teamDataUrl;

    /**
     * 球队全称
     */
    private String teamFullName;

    /**
     * 球队简称
     */
    private String teamShortName;

    /**
     * 球队排名ID
     */
    private String teamOrder;

    /**
     * LOGO URL地址
     */
    private String logoUrl;

    /**
     * 
     */
    private Date modifyTime;

    /**
     * 
     */
    private String modifyBy;

    /**
     * 
     */
    private String createBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     */
    private String remark;

    /**
     * sp值变化比较
     */
    private String md5Value;
    
    public SportTeamInfoPO() {
    }

    public SportTeamInfoPO(Long id,Long sportTeamInfoId, String teamDataUrl, String teamFullName, String teamShortName, String teamOrder, String logoUrl, Date modifyTime, String modifyBy, String createBy, Date updateTime, Date createTime, String remark) {
        this.id = id;
        this.teamId=sportTeamInfoId;
        this.teamDataUrl = teamDataUrl;
        this.teamFullName = teamFullName;
        this.teamShortName = teamShortName;
        this.teamOrder = teamOrder;
        this.logoUrl = logoUrl;
        this.modifyTime = modifyTime;
        this.modifyBy = modifyBy;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.remark = remark;
    }
    
    public SportTeamInfoPO(SportTeamInfoVO vo){
        this.id = vo.getId();
        this.teamType = vo.getTeamType();
        this.teamDataUrl = vo.getTeamDataUrl();
        this.teamFullName = vo.getTeamFullName();
        this.teamShortName = vo.getTeamShortName();
        this.teamOrder = vo.getTeamOrder();
        this.logoUrl = vo.getLogoUrl();
        this.modifyBy = vo.getModifyBy();
        this.createBy = vo.getCreateBy();
        this.remark = vo.getRemark(); 
        this.md5Value = vo.getMd5Value();
        this.teamId=1l;
    }

    /**
     * 自增长主键
     * @return id 自增长主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 自增长主键
     * @param id 自增长主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 球队ID
     * @return team_id 球队ID
     */
    public Long getTeamId() {
        return teamId;
    }

    /**
     * 球队ID
     * @param teamId 球队ID
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /**
     * 球队类型:1足球;2篮球
     * @return team_type 球队类型:1足球;2篮球
     */
    public Short getTeamType() {
        return teamType;
    }

    /**
     * 球队类型:1足球;2篮球
     * @param teamType 球队类型:1足球;2篮球
     */
    public void setTeamType(Short teamType) {
        this.teamType = teamType;
    }

    /**
     * 球队资料URL，唯一，第三方的球队ID。例如：一比分。以便链接到一比分的球队详情页面
     * @return team_data_url 球队资料URL，唯一，第三方的球队ID。例如：一比分。以便链接到一比分的球队详情页面
     */
    public String getTeamDataUrl() {
        return teamDataUrl;
    }

    /**
     * 球队资料URL，唯一，第三方的球队ID。例如：一比分。以便链接到一比分的球队详情页面
     * @param teamDataUrl 球队资料URL，唯一，第三方的球队ID。例如：一比分。以便链接到一比分的球队详情页面
     */
    public void setTeamDataUrl(String teamDataUrl) {
        this.teamDataUrl = teamDataUrl == null ? null : teamDataUrl.trim();
    }

    /**
     * 球队全称
     * @return team_full_name 球队全称
     */
    public String getTeamFullName() {
        return teamFullName;
    }

    /**
     * 球队全称
     * @param teamFullName 球队全称
     */
    public void setTeamFullName(String teamFullName) {
        this.teamFullName = teamFullName == null ? null : teamFullName.trim();
    }

    /**
     * 球队简称
     * @return team_short_name 球队简称
     */
    public String getTeamShortName() {
        return teamShortName;
    }

    /**
     * 球队简称
     * @param teamShortName 球队简称
     */
    public void setTeamShortName(String teamShortName) {
        this.teamShortName = teamShortName == null ? null : teamShortName.trim();
    }

    /**
     * 球队排名ID
     * @return team_order 球队排名ID
     */
    public String getTeamOrder() {
        return teamOrder;
    }

    /**
     * 球队排名ID
     * @param teamOrder 球队排名ID
     */
    public void setTeamOrder(String teamOrder) {
        this.teamOrder = teamOrder == null ? null : teamOrder.trim();
    }

    /**
     * LOGO URL地址
     * @return logo_url LOGO URL地址
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * LOGO URL地址
     * @param logoUrl LOGO URL地址
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    /**
     * 
     * @return modify_time 
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * @param modifyTime 
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * @return modify_by 
     */
    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * 
     * @param modifyBy 
     */
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    /**
     * 
     * @return create_by 
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 
     * @param createBy 
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 更新时间
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return remark 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 
     * @param remark 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * sp值变化比较
     * @return md5_value sp值变化比较
     */
    public String getMd5Value() {
        return md5Value;
    }

    /**
     * sp值变化比较
     * @param md5Value sp值变化比较
     */
    public void setMd5Value(String md5Value) {
        this.md5Value = md5Value == null ? null : md5Value.trim();
    }
}