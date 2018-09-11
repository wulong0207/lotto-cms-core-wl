package com.hhly.cmscore.persistence.operate.po;

import java.util.Date;

import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleVO;

/**
 * @desc    文章PO
 * @author  Tony Wang
 * @date    2017年3月17日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class OperateArticlePO {
	/**自增长主键ID*/
	private Long id;
	/**文章编号*/
	private String articleId;
	/**文章标题*/
	private String articleTitle;
	/**文章内容*/
	private String articleContent;
	/**栏目ID*/
	private Long typeId;
	/**栏目名称*/
	private String typeName;
	/**文章状态:0被驳回;1编辑中;2待审核;3审核通过,4已发布*/
	private Integer status;
	/**PC端:0不显示;1显示*/
	private Byte web;
	/**H5端:0不显示;1显示*/
	private Byte wap;
	/**android端:0不显示;1显示*/
	private Byte android;
	/**ios端:0不显示;1显示*/
	private Byte ios;
	/**排序ID*/
	private Integer orderId;
	/**文章来源*/
	private String articleFrom;
	/**文章来源链接*/
	private String fromUrl;
	/**文章本地链接*/
	private String articleUrl;
	/**封面图片*/
	private String articleImg;
	/**封面图片创建时间*/
	private Date articleImgCreateTime;
	/**封面图片显示:0不显示;1显示
	private Byte articleImgDisplay;*/
	/**摘要*/
	private String articleSummary;
	/**标签*/
	private String articleLabel;
	/**阅读数量*/
	private Long click;
	/**创建人*/
	private String createBy;
	/**修改人*/
	private String modifyBy;
	/**审核人*/
	private String auditBy;
	/**更新时间，保存为html时有用
	private Date updateTime;*/
	/**发布时间*/
	private Date releaseTime;
	/**审核时间，保存为html时有用*/
	private Date auditTime;
	/**创建时间，保存为html时有用*/
	private Date createTime;
	/**修改时间*/
	private Date modifyTime;
	/**
	 * 栏目编号
	 */
	private String typeCode;
	/**
	 * 创建人id
	 */
	private Long creatorId;
	
	public OperateArticlePO(OperateArticleVO vo) {
		this.id = vo.getId();
		this.articleId = vo.getArticleId();
		this.articleTitle = vo.getArticleTitle();
		this.articleContent = vo.getArticleContent();
		this.typeId = vo.getTypeId();
		this.typeName = vo.getTypeName();
		this.status = vo.getStatus();
		this.web = vo.getWeb();
		this.wap = vo.getWap();
		this.android = vo.getAndroid();
		this.ios = vo.getIos();
		this.orderId = vo.getOrderId();
		this.articleFrom = vo.getArticleFrom();
		this.fromUrl = vo.getFromUrl();
		this.articleUrl = vo.getArticleUrl();
		this.articleImg = vo.getArticleImg();
		this.articleImgCreateTime = vo.getArticleImgCreateTime();
		this.articleSummary = vo.getArticleSummary();
		this.articleLabel = vo.getArticleLabel();
		this.click = vo.getClick();
		this.createBy = vo.getCreateBy();
		this.modifyBy = vo.getModifyBy();
		this.auditBy = vo.getAuditBy();
		this.releaseTime = vo.getReleaseTime();
		this.auditTime = vo.getAuditTime();
		this.createTime = vo.getCreateTime();
		this.modifyTime = vo.getModifyTime();
		this.typeCode = vo.getTypeCode();
		this.creatorId = vo.getCreatorId();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Byte getWeb() {
		return web;
	}

	public void setWeb(Byte web) {
		this.web = web;
	}

	public Byte getWap() {
		return wap;
	}

	public void setWap(Byte wap) {
		this.wap = wap;
	}

	public Byte getAndroid() {
		return android;
	}

	public void setAndroid(Byte android) {
		this.android = android;
	}

	public Byte getIos() {
		return ios;
	}

	public void setIos(Byte ios) {
		this.ios = ios;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getArticleFrom() {
		return articleFrom;
	}

	public void setArticleFrom(String articleFrom) {
		this.articleFrom = articleFrom;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	public String getArticleImg() {
		return articleImg;
	}

	public void setArticleImg(String articleImg) {
		this.articleImg = articleImg;
	}

	public Date getArticleImgCreateTime() {
		return articleImgCreateTime;
	}

	public void setArticleImgCreateTime(Date articleImgCreateTime) {
		this.articleImgCreateTime = articleImgCreateTime;
	}

	public String getArticleSummary() {
		return articleSummary;
	}

	public void setArticleSummary(String articleSummary) {
		this.articleSummary = articleSummary;
	}

	public String getArticleLabel() {
		return articleLabel;
	}

	public void setArticleLabel(String articleLabel) {
		this.articleLabel = articleLabel;
	}

	public Long getClick() {
		return click;
	}

	public void setClick(Long click) {
		this.click = click;
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

	public String getAuditBy() {
		return auditBy;
	}

	public void setAuditBy(String auditBy) {
		this.auditBy = auditBy;
	}

	public String getFromUrl() {
		return fromUrl;
	}

	public void setFromUrl(String fromUrl) {
		this.fromUrl = fromUrl;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
}