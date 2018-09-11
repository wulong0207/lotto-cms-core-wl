package com.hhly.cmscore.persistence.cooperate.dao;


import com.hhly.cmscore.persistence.cooperate.po.CooperateCdkeyPO;
import com.hhly.skeleton.cms.cooperate.bo.CooperateCdKeyLotteryNumBO;
import com.hhly.skeleton.cms.cooperate.bo.CooperateCdKeyLotteryRecodeListBO;
import com.hhly.skeleton.cms.cooperate.bo.CooperateCdkeyBO;
import com.hhly.skeleton.cms.cooperate.bo.CooperateExchangeRecordBO;
import com.hhly.skeleton.cms.cooperate.vo.CooperateCdkeyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CooperateCdkeyMapper {

    int selectCount(CooperateCdkeyVO vo);

    int deleteByPrimaryKey(Integer id);

    int insert(CooperateCdkeyPO record);

    int insertSelective(CooperateCdkeyPO record);

    CooperateCdkeyBO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CooperateCdkeyPO record);

    int updateByPrimaryKey(CooperateCdkeyPO record);

    int insertList(List<CooperateCdkeyVO> list);

    List<CooperateCdKeyLotteryNumBO> findLotteryNum(CooperateCdkeyVO vo);

    List<CooperateCdKeyLotteryRecodeListBO> findLotteryRecodeList(CooperateCdkeyVO vo);

    int findLotteryRecodeCount(CooperateCdkeyVO vo);

    CooperateCdkeyBO findBaseResultByMyKey(@Param("myCdkey") String myCdkey);

    int findBaseResultByLotteryKey(@Param("lottoCdkey") String lottoCdkey);

    List<CooperateCdkeyBO> findBaseResult(CooperateCdkeyVO vo);

    int updateExchangeChannel(CooperateCdkeyBO bo);

    int updateOverTimeCdKey(List<CooperateExchangeRecordBO> list);
}