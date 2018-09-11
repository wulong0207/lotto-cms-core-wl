package com.hhly.cmscore.persistence.sys.po;


import java.util.Date;

import com.hhly.skeleton.cms.sysmgr.vo.CMSRoleMenuVO;

public class CmsRoleMenuPO {
    private Integer roleMenuId;

    private Integer roleId;

    private Integer menuId;

    private String menuButton;

    private Date updateTime;

    private Date createTime;

    public CmsRoleMenuPO() {
    }

    public CmsRoleMenuPO(CMSRoleMenuVO vo) {
        this.roleMenuId = vo.getRoleMenuId();
        this.roleId = vo.getRoleId();
        this.menuId = vo.getMenuId();
        this.menuButton = vo.getMenuButton();
    }

    public Integer getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(Integer roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuButton() {
        return menuButton;
    }

    public void setMenuButton(String menuButton) {
        this.menuButton = menuButton;
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