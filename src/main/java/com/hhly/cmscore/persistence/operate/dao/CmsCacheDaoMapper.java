package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import com.hhly.cmscore.persistence.operate.po.CmsCachePO;
import com.hhly.skeleton.cms.operatemgr.bo.CmsCacheBO;
import com.hhly.skeleton.cms.operatemgr.vo.CmsCacheVO;


public interface CmsCacheDaoMapper {

    int insertCache(CmsCachePO po);
    
    List<CmsCacheBO> findCacheListByPage(CmsCacheVO vo);
    
    int findCacheTotal(CmsCacheVO vo);
    
    int delCacheById(Integer id);
    
    List<CmsCacheBO> findCache(CmsCacheVO vo);
    
    int updateCache(CmsCachePO po);
}