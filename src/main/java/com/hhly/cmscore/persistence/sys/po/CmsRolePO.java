package com.hhly.cmscore.persistence.sys.po;


import java.util.Date;

import com.hhly.skeleton.cms.sysmgr.vo.CMSRoleVO;

public class CmsRolePO {
    private Integer roleId;

    private String roleName;

    private Integer depart;

    private String roleDesc;

    private Integer roleStatus;

    private Integer roleMenuId;

    private Date modifyTime;

    private String modifyBy;

    private String createBy;

    private Date updateTime;

    private Date createTime;

    private String remark;

    public CmsRolePO() {
    }

    public CmsRolePO(CMSRoleVO vo) {
        this.roleId = vo.getRoleId();
        this.roleName = vo.getRoleName();
        this.depart = vo.getDepart();
        this.roleDesc = vo.getRoleDesc();
        this.roleStatus = vo.getRoleStatus();
        this.modifyBy = vo.getModifyBy();
        this.createBy = vo.getCreateBy();
        this.remark = vo.getRemark();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getDepart() {
        return depart;
    }

    public void setDepart(Integer depart) {
        this.depart = depart;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    public Integer getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(Integer roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}