package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import com.hhly.cmscore.persistence.operate.po.OperateArticleTopPO;

/**
 * @desc    文章置顶
 * @author  Tony Wang
 * @date    2017年3月17日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface OperateArticleTopDaoMapper {

	/**
	 * @desc   新增文章置顶表
	 * @author Tony Wang
	 * @create 2017年3月17日
	 * @param articleTops
	 * @return 
	 */
	int add(List<OperateArticleTopPO> articleTops);

	/**
	 * @desc   更新文章置顶表
	 * @author Tony Wang
	 * @create 2017年4月12日
	 * @param articleTops
	 * @return 
	 */
	int update(List<OperateArticleTopPO> articleTops);

	/**
	 * @desc    删除某篇文章的所有中间表信息
	 * @author Tony Wang
	 * @create 2017年4月13日
	 * @param id 
	 */
	int delete(Long articleId);

}
