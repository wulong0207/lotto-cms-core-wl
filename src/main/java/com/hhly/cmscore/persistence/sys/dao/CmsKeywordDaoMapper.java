package com.hhly.cmscore.persistence.sys.dao;

import java.util.List;

import com.hhly.cmscore.persistence.sys.po.CmsKeywordPO;
import com.hhly.skeleton.cms.sysmgr.bo.CmsKeywordBO;
import com.hhly.skeleton.cms.sysmgr.vo.CmsKeywordVO;
import com.hhly.skeleton.user.bo.KeywordBO;

public interface CmsKeywordDaoMapper {
	
	int addList(List<CmsKeywordPO> list);

    int findTotal(CmsKeywordVO vo);

    List<KeywordBO> queryKeywordInfo();

    List<CmsKeywordBO> find(CmsKeywordVO vo);
    
    int updateList(List<CmsKeywordPO> list);
    
    List<CmsKeywordBO> excelList(CmsKeywordVO vo);

}