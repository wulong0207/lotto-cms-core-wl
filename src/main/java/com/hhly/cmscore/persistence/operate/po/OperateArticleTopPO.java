package com.hhly.cmscore.persistence.operate.po;

import java.util.Date;

import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleTopVO;

/**
 * @desc    文章置顶
 * @author  Tony Wang
 * @date    2017年3月17日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class OperateArticleTopPO {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 栏目ID
     */
    private Long typeId;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 置顶标题
     */
    private String title;

    /**
     * 置顶颜色
     */
    private String color;

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

    
	public OperateArticleTopPO(OperateArticleTopVO top) {
		this.id = null;
		this.typeId = top.getTypeId();
		this.articleId = top.getArticleId();
		this.title = top.getTitle();
		this.color = top.getColor();
		this.uptime = top.getUptime();
		this.downtime = top.getDowntime();
		this.isTop = top.getIsTop();
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

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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