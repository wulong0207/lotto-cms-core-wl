package com.hhly.cmscore.persistence.trans.dao;


import com.hhly.skeleton.cms.transmgr.bo.TransRemittingBO;
import com.hhly.skeleton.cms.transmgr.bo.TransRemittingExcelBO;

import java.util.List;

public interface TransRemittingDaoMapper {

    int count(TransRemittingBO vo);

    List<TransRemittingBO> find(TransRemittingBO vo);

    int update(TransRemittingBO vo);

    List<TransRemittingExcelBO> excel(TransRemittingBO vo);
}