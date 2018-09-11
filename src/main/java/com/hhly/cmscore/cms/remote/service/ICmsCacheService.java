package com.hhly.cmscore.cms.remote.service;

import java.util.List;

import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.cms.operatemgr.bo.LotteryCacheBO;
import com.hhly.skeleton.cms.operatemgr.vo.LotteryCacheVO;
import com.hhly.skeleton.lotto.base.sport.bo.SPMessageBO;


/**
 * @desc CMS缓存管理
 * @author YiJian
 * @date 2017年6月28日 下午2:50:18
 * @company 深圳益彩网络科技有限公司
 * @version v1.0
 */
public interface ICmsCacheService {
	
	/**
	 * 分页查询
	 * @param vo
	 * @return
	 */
	PagingBO<LotteryCacheBO> findCacheListByPage(LotteryCacheVO vo);

	/**
	 * 添加缓存
	 * @param po
	 * @return
	 */
	int insertCache(LotteryCacheVO vo);

	/**
	 * 删除缓存
	 * @param ids
	 * @return
	 */
	int delCacheById(short id);
	
	/**
	 * 查询缓存
	 * @param vo
	 * @return
	 */
	List<LotteryCacheBO> findCache(LotteryCacheVO vo);
	
	
	/**
	 * 修改缓存
	 * @param po
	 * @return
	 */
	int updateCache(LotteryCacheVO vo);
	
	void clearCache(String cacheKey);
	

	List<SPMessageBO> findMessage(Integer min,Integer max);
	
	int findCount();
}
