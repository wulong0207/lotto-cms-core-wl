package com.hhly.cmscore.persistence.operate.po;

import java.util.Date;

import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpTopVO;

public class OperateHelpTopPO {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 栏目ID
     */
    private Long typeId;

    /**
     * 帮助ID
     */
    private Long helpId;

    /**
     * 置顶标题
     */
    private String title;

    /**
     * 上线时间
     */
    private Date uptime;

    /**
     * 下线时间
     */
    private Date downtime;

    /**
     * 是否置顶:0否;1是
     */
    private Byte isTop;

    
	public OperateHelpTopPO(OperateHelpTopVO vo) {
		//this.id = id;
		this.typeId = vo.getTypeId();
		this.helpId = vo.getHelpId();
		this.title = vo.getTitle();
		this.uptime = vo.getUptime();
		this.downtime = vo.getDowntime();
		this.isTop = vo.getIsTop();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getHelpId() {
		return helpId;
	}

	public void setHelpId(Long helpId) {
		this.helpId = helpId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getUptime() {
		return uptime;
	}

	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}

	public Date getDowntime() {
		return downtime;
	}

	public void setDowntime(Date downtime) {
		this.downtime = downtime;
	}

	public Byte getIsTop() {
		return isTop;
	}

	public void setIsTop(Byte isTop) {
		this.isTop = isTop;
	}
}