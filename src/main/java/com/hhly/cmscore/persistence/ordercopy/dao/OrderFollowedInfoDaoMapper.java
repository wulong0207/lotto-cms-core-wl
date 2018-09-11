package com.hhly.cmscore.persistence.ordercopy.dao;

import java.util.List;

import com.hhly.cmscore.persistence.ordercopy.po.OrderFollowedInfoPO;
import com.hhly.skeleton.lotto.base.ordercopy.bo.FollowedDetailsBO;
import com.hhly.skeleton.lotto.base.ordercopy.bo.OrderFollowedInfoBO;
import com.hhly.skeleton.lotto.base.ordercopy.vo.QueryVO;
import org.apache.ibatis.annotations.Param;


public interface OrderFollowedInfoDaoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(OrderFollowedInfoPO record);

    int insertSelective(OrderFollowedInfoPO record);

    OrderFollowedInfoBO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderFollowedInfoPO record);

    int updateByPrimaryKey(OrderFollowedInfoPO record);
    
    List<FollowedDetailsBO> queryFollowedDetails(QueryVO queryVO);
    int queryFollowedDetailsCount(QueryVO queryVO);

    /**
     * 根据订单编号查询跟单是否存在
     *
     * @param orderCode
     * @return
     */
    int selectCountByOrderCode(@Param("orderCode") String orderCode);

    int selectCountByUserIdAndOrderIssueId(@Param("userId") Integer userId, @Param("orderIssueId") Long orderIssueId);
}