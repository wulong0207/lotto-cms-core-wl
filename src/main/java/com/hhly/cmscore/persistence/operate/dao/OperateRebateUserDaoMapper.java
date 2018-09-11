package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import com.hhly.cmscore.persistence.operate.po.OperateRebateUserPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateRebateUserBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateRebateUserVO;

public interface OperateRebateUserDaoMapper {
    int insert(OperateRebateUserPO record);

    int updateByPrimaryKey(OperateRebateUserVO record);
    
    int findTotal(OperateRebateUserVO record);
    List<OperateRebateUserBO> findList(OperateRebateUserVO record);
    //查询时间最近的大客户信息
    OperateRebateUserBO findByUser(OperateRebateUserVO record);
    int updateOldUserType(int id);
    List<OperateRebateUserBO> findUserHisList(OperateRebateUserVO vo);
}