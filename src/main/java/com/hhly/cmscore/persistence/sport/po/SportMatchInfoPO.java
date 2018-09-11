package com.hhly.cmscore.persistence.sport.po;

import java.util.Date;

import com.hhly.skeleton.cms.sportmgr.vo.SportDataBaseVO;
import com.hhly.skeleton.cms.sportmgr.vo.SportMatchInfoVO;

public class SportMatchInfoPO {
	
	/**
     * id
     */
    private Long id;

    /**
     * 赛事ID
     */
    private Long matchId;

    /**
     * 赛事资料URL，唯一，从第三方获取，例如：一比分。以便链接到一比分的赛事详情页面
     */
    private String matchDataUrl;

    /**
     * 赛事全称
     */
    private String matchFullName;

    /**
     * 赛事简称
     */
    private String matchShortName;

    /**
     * LOGO url地址
     */
    private String logoUrl;

    /**
     * 1：足球赛事；2：篮球赛事；3：网球；4：橄榄球；5：排球；6：羽毛球；7：乒乓球；8：沙滩排球；9：冰球；10：曲棍球；11：手球；12：水球
     */
    private Short matchType;

    /**
     * 颜色
     */
    private String matchColor;

    /**
     * 修改人真实姓名
     */
    private String modifyBy;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否是5大联赛，0否，1是
     */
    private Short fiveLeague;

    /**
     * sp值变化比较
     */
    private String md5Value;

    public SportMatchInfoPO() {
    }

    public SportMatchInfoPO(SportDataBaseVO vo) {
        this.id = vo.getMatchPrimaryId();
        this.matchId=vo.getMatchId();
        this.matchShortName = vo.getMatchShortName();
        this.logoUrl = vo.getLogoUrl();
        this.modifyBy = vo.getModifyBy();
        this.modifyTime = vo.getModifyTime();
        this.updateTime = vo.getModifyTime();
        this.matchDataUrl=vo.getMatchDataUrl();
    }
    
    public SportMatchInfoPO(SportMatchInfoVO vo) {
		this.id = vo.getId();
		this.matchDataUrl = vo.getMatchDataUrl();
		this.matchFullName = vo.getMatchFullName();
		this.matchShortName = vo.getMatchShortName();
		this.logoUrl = vo.getLogoUrl();
		this.matchType = vo.getMatchType();
		this.matchColor = vo.getMatchColor();
		this.fiveLeague = vo.getFiveLeague();
		this.remark = vo.getRemark();
		this.md5Value = vo.getMd5Value();
		this.matchId = 1l;
	}

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 赛事ID
     * @return match_id 赛事ID
     */
    public Long getMatchId() {
        return matchId;
    }

    /**
     * 赛事ID
     * @param matchId 赛事ID
     */
    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    /**
     * 赛事资料URL，唯一，从第三方获取，例如：一比分。以便链接到一比分的赛事详情页面
     * @return match_data_url 赛事资料URL，唯一，从第三方获取，例如：一比分。以便链接到一比分的赛事详情页面
     */
    public String getMatchDataUrl() {
        return matchDataUrl;
    }

    /**
     * 赛事资料URL，唯一，从第三方获取，例如：一比分。以便链接到一比分的赛事详情页面
     * @param matchDataUrl 赛事资料URL，唯一，从第三方获取，例如：一比分。以便链接到一比分的赛事详情页面
     */
    public void setMatchDataUrl(String matchDataUrl) {
        this.matchDataUrl = matchDataUrl == null ? null : matchDataUrl.trim();
    }

    /**
     * 赛事全称
     * @return match_full_name 赛事全称
     */
    public String getMatchFullName() {
        return matchFullName;
    }

    /**
     * 赛事全称
     * @param matchFullName 赛事全称
     */
    public void setMatchFullName(String matchFullName) {
        this.matchFullName = matchFullName == null ? null : matchFullName.trim();
    }

    /**
     * 赛事简称
     * @return match_short_name 赛事简称
     */
    public String getMatchShortName() {
        return matchShortName;
    }

    /**
     * 赛事简称
     * @param matchShortName 赛事简称
     */
    public void setMatchShortName(String matchShortName) {
        this.matchShortName = matchShortName == null ? null : matchShortName.trim();
    }

    /**
     * LOGO url地址
     * @return logo_url LOGO url地址
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * LOGO url地址
     * @param logoUrl LOGO url地址
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    /**
     * 1：足球赛事；2：篮球赛事；3：网球；4：橄榄球；5：排球；6：羽毛球；7：乒乓球；8：沙滩排球；9：冰球；10：曲棍球；11：手球；12：水球
     * @return match_type 1：足球赛事；2：篮球赛事；3：网球；4：橄榄球；5：排球；6：羽毛球；7：乒乓球；8：沙滩排球；9：冰球；10：曲棍球；11：手球；12：水球
     */
    public Short getMatchType() {
        return matchType;
    }

    /**
     * 1：足球赛事；2：篮球赛事；3：网球；4：橄榄球；5：排球；6：羽毛球；7：乒乓球；8：沙滩排球；9：冰球；10：曲棍球；11：手球；12：水球
     * @param matchType 1：足球赛事；2：篮球赛事；3：网球；4：橄榄球；5：排球；6：羽毛球；7：乒乓球；8：沙滩排球；9：冰球；10：曲棍球；11：手球；12：水球
     */
    public void setMatchType(Short matchType) {
        this.matchType = matchType;
    }

    /**
     * 颜色
     * @return match_color 颜色
     */
    public String getMatchColor() {
        return matchColor;
    }

    /**
     * 颜色
     * @param matchColor 颜色
     */
    public void setMatchColor(String matchColor) {
        this.matchColor = matchColor == null ? null : matchColor.trim();
    }

    /**
     * 修改人真实姓名
     * @return modify_by 修改人真实姓名
     */
    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * 修改人真实姓名
     * @param modifyBy 修改人真实姓名
     */
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    /**
     * 修改时间
     * @return modify_time 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 是否是5大联赛，0否，1是
     * @return five_league 是否是5大联赛，0否，1是
     */
    public Short getFiveLeague() {
        return fiveLeague;
    }

    /**
     * 是否是5大联赛，0否，1是
     * @param fiveLeague 是否是5大联赛，0否，1是
     */
    public void setFiveLeague(Short fiveLeague) {
        this.fiveLeague = fiveLeague;
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