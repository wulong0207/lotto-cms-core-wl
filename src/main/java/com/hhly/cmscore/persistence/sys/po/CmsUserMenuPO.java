package com.hhly.cmscore.persistence.sys.po;


import java.util.Date;

import com.hhly.skeleton.cms.sysmgr.vo.CMSUserMenuVO;

public class CmsUserMenuPO {
    private Integer userMenuId;

    private Integer userId;

    private Integer menuId;

    private String userAuth;

    private Date updateTime;

    private Date createTime;

    public CmsUserMenuPO() {
    }

    public CmsUserMenuPO(CMSUserMenuVO vo) {
        this.userMenuId = vo.getUserMenuId();
        this.userId = vo.getUserId();
        this.menuId = vo.getMenuId();
        this.userAuth = vo.getUserAuth();
        this.updateTime = vo.getUpdateTime();
        this.createTime = vo.getCreateTime();
    }

    public Integer getUserMenuId() {
        return userMenuId;
    }

    public void setUserMenuId(Integer userMenuId) {
        this.userMenuId = userMenuId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
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

    public String getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(String userAuth) {
        this.userAuth = userAuth;
    }
}