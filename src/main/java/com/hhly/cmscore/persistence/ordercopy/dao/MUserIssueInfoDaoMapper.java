package com.hhly.cmscore.persistence.ordercopy.dao;

import java.util.List;

import com.hhly.cmscore.persistence.ordercopy.po.MUserIssueInfoPO;
import com.hhly.skeleton.lotto.base.ordercopy.bo.CommissionBO;
import com.hhly.skeleton.lotto.base.ordercopy.bo.MUserIssueCountPrizeBO;
import com.hhly.skeleton.lotto.base.ordercopy.bo.MUserIssueInfoBO;
import com.hhly.skeleton.lotto.base.ordercopy.bo.QueryUserIssueInfoBO;
import com.hhly.skeleton.lotto.base.ordercopy.vo.MUserIssueInfoVO;
import com.hhly.skeleton.lotto.base.ordercopy.vo.QueryVO;

public interface MUserIssueInfoDaoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MUserIssueInfoPO record);

    Integer findUserIssueInfoCountByUserId(Long userId);

    MUserIssueInfoBO findUserIssueInfoByUserId(Long userId);
    
    List<QueryUserIssueInfoBO> selectByCondition(QueryVO queryVO);
    int selectByConditionCount(QueryVO queryVO);

    int insertSelective(MUserIssueInfoPO record);

    MUserIssueInfoBO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MUserIssueInfoPO record);

    int updateByPrimaryKey(MUserIssueInfoPO record);
    
    List<CommissionBO> queryCommission(QueryVO queryVO);
    int queryCommissionCount(QueryVO queryVO);
    
    List<CommissionBO> queryCommissionDetails(QueryVO queryVO);
    int queryCommissionDetailsCount(QueryVO queryVO);

    List<MUserIssueCountPrizeBO> selectIssueUserPrizeOrder(MUserIssueInfoVO vo);

    List<MUserIssueCountPrizeBO> selectIssueUserNotPrizeOrder(MUserIssueInfoVO vo);
}