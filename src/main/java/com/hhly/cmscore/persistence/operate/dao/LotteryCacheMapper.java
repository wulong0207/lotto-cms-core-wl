package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.operate.po.LotteryCachePO;
import com.hhly.skeleton.cms.operatemgr.bo.LotteryCacheBO;
import com.hhly.skeleton.cms.operatemgr.vo.LotteryCacheVO;
import com.hhly.skeleton.lotto.base.sport.bo.SPMessageBO;

public interface LotteryCacheMapper {

    int deleteByPrimaryKey(Short id);

    int insert(LotteryCachePO record);

    int insertSelective(LotteryCachePO record);

    LotteryCachePO selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(LotteryCachePO record);

    int updateByPrimaryKey(LotteryCachePO record);
    
    int findCacheTotal(LotteryCacheVO vo);

	List<LotteryCacheBO> findCacheListByPage(LotteryCacheVO vo);
	
	List<LotteryCacheBO> findCache(LotteryCacheVO vo) ;
	
	List<SPMessageBO> findMessage(@Param("min")Integer min,@Param("max")Integer max);
	
	int findCount();
}