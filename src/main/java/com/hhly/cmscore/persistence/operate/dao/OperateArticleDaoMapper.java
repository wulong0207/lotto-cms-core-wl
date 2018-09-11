package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.operate.po.OperateArticlePO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateArticleBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleVO;
import com.hhly.skeleton.cms.sysmgr.bo.CMSUserBO;
import com.hhly.skeleton.lotto.base.operate.bo.ClickBO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateArticleBaseBO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateArticleLottBO;
import com.hhly.skeleton.lotto.base.operate.vo.OperateArticleLottVO;

/**
 * @desc    文章管理
 * @author  Tony Wang
 * @date    2017年3月3日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface OperateArticleDaoMapper {

	/**
	 * @desc   查询符合条件的记录数
	 * @author Tony Wang
	 * @create 2017年3月3日
	 * @param vo
	 * @return 
	 */
	int findTotal(OperateArticleVO vo);

	/**
	 * @desc   查询符合条件的文章
	 * @author Tony Wang
	 * @create 2017年3月3日
	 * @param vo
	 * @return 
	 */
	List<OperateArticleBO> list(OperateArticleVO vo);

	/**
	 * @desc   增加或更新文章
	 * @author Tony Wang
	 * @create 2017年3月6日
	 * @param po
	 * @return 
	 
	int merge(OperateArticlePO po);*/

	/**
	 * @desc   增加文章
	 * @author Tony Wang
	 * @create 2017年3月6日
	 * @param po
	 * @return 
	 */
	int add(OperateArticlePO po);
	
	/**
	 * @desc   更新文章
	 * @author Tony Wang
	 * @create 2017年4月12日
	 * @param article
	 * @return 
	 */
	int update(OperateArticlePO article);
	
	/**
	 * @desc   查询单篇文章
	 * @author Tony Wang
	 * @create 2017年3月21日
	 * @param operateArticleVO
	 * @return 
	 */
	OperateArticleBO findSingle(OperateArticleVO vo);
	

	/**
	 * @desc   更新文章信息(状态或审核人)
	 * @author Tony Wang
	 * @create 2017年4月14日
	 * @param vo
	 * @return 
	 */
	int updateStatus(OperateArticlePO po);
	
	/**
	 * 根据类型查询新闻资讯详细信息
	 * @param articleVO
	 * @return
	 */
	List<OperateArticleLottBO> findArticleByTop(OperateArticleLottVO articleVO);
	
	/**
	 * 查询最新的资讯信息
	 * @param articleVO
	 * @return
	 */
	List<OperateArticleLottBO> findNewArticle(OperateArticleLottVO articleVO);
	
	/**
	 * 查询新闻资讯详细信息
	 * @param articleVO
	 * @return
	 */
	OperateArticleLottBO findArticle(OperateArticleLottVO articleVO);
	
	/**
	 * pc主页根据多个栏目查询资讯基本信息
	 * @param voList
	 * @return
	 */
	List<OperateArticleBaseBO> findArticleByTypeList(List<OperateArticleLottVO> voList);
	
	/**
	 * 根据多个栏目查询资讯信息
	 * @param voList
	 * @return
	 */
	List<OperateArticleLottBO> findNewsByTypeList(List<OperateArticleLottVO> voList);
	
	/**
	 * 更新点击量
	 */
	int updateClick(OperateArticleLottVO id); 
	
	/**
	 * 批量更新点击量
	 */
	int updateClickList(List<ClickBO> list); 
	/**
	 * 根据栏目类型查询该栏目下的创建用户信息
	 */
	List<CMSUserBO> findUserByArtType(OperateArticleLottVO vo);
	
	/**
	 * 查询专栏下的每个专家的资讯信息
	 * @param vo
	 * @return
	 */
	List<OperateArticleBaseBO> findArticleByUserList(List<OperateArticleLottVO> vo);
	
	

	/**
	 * 查询关键字相同情况下的资讯信息
	 * @param vo
	 * @return
	 */
	List<OperateArticleLottBO> findArticleLabel(OperateArticleLottVO vo);

	/**
	 * @desc   查询最大编号
	 * @author Tony Wang
	 * @create 2017年4月27日
	 * @param articleIdLike
	 * @return 
	 */
	String findMaxArticleId(@Param("articleIdLike") String articleIdLike);
	
	/**
	 * 查询侧边栏资讯头条信息 ，查询规则查当前节点和子节点下创建的信息
	 */
	List<OperateArticleLottBO> findSidebarNews(OperateArticleLottVO vo);
	/**
	 * 查询发布时间大于一周前的点击信息
	 * @return
	 */
	List<ClickBO> findClick();
    /**
     * 获取Rss更新文章
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2018年2月27日 上午10:23:06
     * @return
     */
	List<OperateArticleBO> listArticleRss();
}
