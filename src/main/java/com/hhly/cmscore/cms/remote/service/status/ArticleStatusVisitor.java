package com.hhly.cmscore.cms.remote.service.status;

import java.util.Objects;

import com.hhly.skeleton.base.common.ArticleEnum;
import com.hhly.skeleton.base.status.AbstractVisitor;
import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleVO;

public class ArticleStatusVisitor extends AbstractVisitor<Boolean, OperateArticleVO, Integer> {

	/*
	 * 2017-4-26与产品讨论如下：
	 * 1.文章共有5种状态：
	 * 0被驳回 :文章被驳回后，可再次编辑，保存后为"编辑中"，点击"提交审核"按钮后，为待审核	(提交审核：N 驳回:N 审核通过:N)
	 * 1编辑中：添加文章保存后，处于此状态，文章可再次编辑							(提交审核：Y 驳回:N 审核通过:N)
	 * 2待审核：点击"提交审核"按钮后，则是待审核,文章不可再编辑						(提交审核：N 驳回:Y 审核通过:Y)
	 * 3审核通过:														(提交审核：N 驳回:Y 审核通过:N)
	 * 4已发布:数据库不会存此状态，程序根据发布时间及状态值来判断展示给前端				(提交审核：N 驳回:Y 审核通过:N)
	 * 
	 * 2.对文章有3种操作：提交审核 驳回、审核通过(删除"发布"操作)
	 */
	// 0被驳回;
	@Override
	public Boolean visitZero(OperateArticleVO vo, Integer update) {
		// "被驳回"状态的文章 提交审核：N 驳回:N 审核通过:N
		return false;
	}

	// 1编辑中;
	@Override
	public Boolean visitOne(OperateArticleVO vo, Integer update) {
		// "编辑中"状态的文章 提交审核：Y 驳回:N 审核通过:N
		return Objects.equals(update, ArticleEnum.ArticleStatus.WAIT_APPROVE.getStatus());
	}

	// 2待审核;
	@Override
	public Boolean visitTwo(OperateArticleVO vo, Integer update) {
		// "待审核"状态的文章 提交审核：N 驳回:Y 审核通过:Y
		return Objects.equals(update, ArticleEnum.ArticleStatus.APPROVE.getStatus()) || 
				Objects.equals(update, ArticleEnum.ArticleStatus.REJECT.getStatus());
	}

	// 3审核通过  此状态需求删除
	@Override
	public Boolean visitThree(OperateArticleVO vo, Integer update) {
		 return Objects.equals(update, ArticleEnum.ArticleStatus.REJECT.getStatus());
	}

	// 4已发布
	@Override
	public Boolean visitFour(OperateArticleVO vo, Integer update) {
		// "已发布"状态的文章 提交审核：N 驳回:Y 审核通过:N
		return Objects.equals(update, ArticleEnum.ArticleStatus.REJECT.getStatus());
	}
}
