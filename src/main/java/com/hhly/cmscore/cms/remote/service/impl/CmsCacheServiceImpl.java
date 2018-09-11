package com.hhly.cmscore.cms.remote.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.cmscore.cms.remote.service.ICmsCacheService;
import com.hhly.cmscore.persistence.operate.dao.LotteryCacheMapper;
import com.hhly.cmscore.persistence.operate.po.LotteryCachePO;
import com.hhly.persistence.util.RedisUtil;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.page.ISimplePage;
import com.hhly.skeleton.cms.operatemgr.bo.LotteryCacheBO;
import com.hhly.skeleton.cms.operatemgr.vo.LotteryCacheVO;
import com.hhly.skeleton.lotto.base.sport.bo.SPMessageBO;


@Service("cmsCacheService")
public class CmsCacheServiceImpl implements ICmsCacheService {

	@Autowired
	private IPageService pageService;
	
	@Autowired
	private LotteryCacheMapper lotteryCacheMapper;
	
	@Resource
	private RedisUtil redisUtil;
	
	@Override
	public PagingBO<LotteryCacheBO> findCacheListByPage(final LotteryCacheVO vo) {
		return pageService.getPageData(vo,new ISimplePage<LotteryCacheBO>() {
			@Override
			public int getTotal() {
				return lotteryCacheMapper.findCacheTotal(vo);
			}
			@Override
			public List<LotteryCacheBO> getData() {
				List<LotteryCacheBO> caches = lotteryCacheMapper.findCacheListByPage(vo);
				return caches;
			}
		});
	}


	@Override
	public int insertCache(LotteryCacheVO vo) {
		LotteryCachePO cachePO = new LotteryCachePO();
		cachePO.setName(vo.getName());
		cachePO.setCacheGroup(vo.getCacheGroup());
		cachePO.setCacheKey(vo.getCacheKey());
		cachePO.setRemark(vo.getRemark());
		cachePO.setCacheType(vo.getCacheType());
		return lotteryCacheMapper.insert(cachePO);
	}

	@Override
	public int delCacheById(short id) {
		return lotteryCacheMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<LotteryCacheBO> findCache(LotteryCacheVO vo) {
		return lotteryCacheMapper.findCache(vo);
	}

	@Override
	public int updateCache(LotteryCacheVO vo) {
		LotteryCachePO cachePO = new LotteryCachePO();
		cachePO.setId(vo.getId());
		cachePO.setName(vo.getName());
		cachePO.setCacheGroup(vo.getCacheGroup());
		cachePO.setCacheKey(vo.getCacheKey());
		cachePO.setRemark(vo.getRemark());
		cachePO.setCacheType(vo.getCacheType());
		return lotteryCacheMapper.updateByPrimaryKeySelective(cachePO);
	}

	@Override
	public void clearCache(String cacheKey) {
		redisUtil.delKeys(cacheKey);
	}


	@Override
	public List<SPMessageBO> findMessage(Integer min,Integer max) {
		return lotteryCacheMapper.findMessage(min,max);
	}


	@Override
	public int findCount() {
		return lotteryCacheMapper.findCount();
	}

}
