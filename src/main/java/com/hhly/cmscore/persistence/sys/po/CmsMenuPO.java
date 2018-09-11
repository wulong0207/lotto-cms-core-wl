package com.hhly.cmscore.persistence.sys.po;

import java.util.Date;

import com.hhly.skeleton.cms.sysmgr.bo.CMSMenuBO;

public class CmsMenuPO {
    private Integer menuId;

    private String menuTitle;

    private Integer parentMenuId;

    private String menuUrl;

    private String menuButton;

    private String menuDesc;

    private Integer orderId;

    private Integer menuLevel;

    private String modifyBy;

    private String createBy;

    private Date modifyTime;

    private Date updateTime;

    private Date createTime;


    public CmsMenuPO() {
    }

    public CmsMenuPO(CMSMenuBO bo) {
        this.menuId = bo.getMenuId();
        this.menuTitle = bo.getMenuTitle();
        this.parentMenuId = bo.getParentMenuId();
        this.menuUrl = bo.getMenuUrl();
        this.menuButton = bo.getMenuButton();
        this.menuDesc = bo.getMenuDesc();
        this.orderId = bo.getOrderId();
        this.menuLevel = bo.getMenuLevel();
        this.modifyBy = bo.getModifyBy();
        this.createBy = bo.getCreateBy();
        this.modifyTime = bo.getModifyTime();
        this.updateTime = bo.getUpdateTime();
        this.createTime = bo.getCreateTime();
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public Integer getParentMenuId() {
        if(parentMenuId==null){
            parentMenuId = 0;
        }
        return parentMenuId;
    }

    public void setParentMenuId(Integer parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuButton() {
        return menuButton;
    }

    public void setMenuButton(String menuButton) {
        this.menuButton = menuButton;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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