package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.operate.po.OperateArticleTypePO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateArticleTypeBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleTypeVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateArticleBaseBO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateArticleLottBO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateArticleTypeLottBO;
import com.hhly.skeleton.lotto.base.operate.vo.OperateArticleLottVO;

/**
 * @desc    文章栏目Dao
 * @author  Tony Wang
 * @date    2017年3月2日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface OperateArticleTypeDaoMapper {

	/**
	 * @desc   新增或更新文章栏目
	 * @author Tony Wang
	 * @create 2017年3月2日
	 * @param operateArticleTypePO
	 * @return  
	 */
	int merge(OperateArticleTypePO operateArticleTypePO);

	/**
	 * @desc   查询文章栏目
	 * @author Tony Wang
	 * @create 2017年3月2日
	 * @return  
	 */
	List<OperateArticleTypeBO> list();
	
	/**
	 * @desc   查询文章栏目
	 * @author Tony Wang
	 * @create 2017年6月5日
	 * @param criteria
	 * @return 
	 */
	OperateArticleTypeBO find(OperateArticleTypeVO criteria);
	
	/**
	 * 根据栏目查询子栏目信息 
	 * @return
	 */
	List<OperateArticleTypeLottBO> findListByFaType(@Param("typeCode") String typeCode);

	/**
	 * @desc   查询最大栏目编号
	 * @author Tony Wang
	 * @create 2017年3月31日
	 * @param vo
	 * @return 
	 */
	String findMaxTypeCode(OperateArticleTypeVO vo);

	/**
	 * @desc   查询符合条件的记录数
	 * @author Tony Wang
	 * @create 2017年4月1日
	 * @param vo
	 * @return 
	 */
	int count(OperateArticleTypeVO vo);

	/**
	 * @desc   更新栏目排序
	 * @author Tony Wang
	 * @create 2017年4月17日
	 * @param pos
	 * @return 
	 */
	int updateOrder(List<OperateArticleTypePO> pos);

	/**
	 * @desc   查询所有父栏目名称，包含文章所属栏目
	 * @author Tony Wang
	 * @create 2017年4月18日
	 * @param vo
	 * @return 
	 */
	List<String> findParents(OperateArticleVO vo);
	
	/**
	 * 查询资讯所有的栏目信息
	 * @return
	 */
	List<OperateArticleBaseBO> findNewsTypeList();
	
	/**
	 * 查询资讯所有的栏目层级关系
	 * @return
	 */
	List<OperateArticleLottBO> findNewTypeRelatList(OperateArticleLottVO artVo);
}
