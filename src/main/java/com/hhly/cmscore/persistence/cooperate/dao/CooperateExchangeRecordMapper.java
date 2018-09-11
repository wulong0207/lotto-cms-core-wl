package com.hhly.cmscore.persistence.cooperate.dao;

import com.hhly.cmscore.persistence.cooperate.po.CooperateExchangeRecordPO;
import com.hhly.skeleton.cms.cooperate.bo.CooperateExchangeRecordBO;
import com.hhly.skeleton.cms.cooperate.vo.CooperateExchangeRecordVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CooperateExchangeRecordMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(CooperateExchangeRecordVO record);

    int insertSelective(CooperateExchangeRecordVO record);

    CooperateExchangeRecordBO selectByPrimaryKey(Integer id);

    List<CooperateExchangeRecordBO> selectExchangeRecordList(CooperateExchangeRecordVO vo);

    int selectCount(CooperateExchangeRecordVO vo);

    int updateByPrimaryKeySelective(CooperateExchangeRecordPO record);

    int updateByPrimaryKey(CooperateExchangeRecordPO record);

    int insertList(List<CooperateExchangeRecordVO> vo);


    List<CooperateExchangeRecordBO> selectOverTimeCdKey();

    List<CooperateExchangeRecordPO> selectOverTimeSerNumber();

    int updateOverTimeSerNumber(List<CooperateExchangeRecordPO> list);

    double findTotalByChannelId(@Param("channelId") String channelId);
}