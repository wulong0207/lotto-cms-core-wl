package com.hhly.cmscore.persistence.cooperate.dao;

import com.hhly.cmscore.persistence.cooperate.po.CooperateLotteryPO;
import com.hhly.skeleton.base.bo.DictionaryBO;
import com.hhly.skeleton.cms.cooperate.bo.CooperateLotteryBO;
import com.hhly.skeleton.cms.cooperate.vo.CooperateLotteryVO;

import java.util.List;

public interface CooperateLotteryMapper {

    int count(CooperateLotteryVO vo);

    List<CooperateLotteryBO> findCooperateLotteryList(CooperateLotteryVO vo);

    int deleteByPrimaryKey(Integer id);

    int deleteByChannelId(String id);

    int insert(CooperateLotteryPO record);

    int insertSelective(CooperateLotteryPO record);

    CooperateLotteryBO selectByPrimaryKey(Integer id);

    List<DictionaryBO> findCooperateLotteryListByChannelId(CooperateLotteryVO vo);

    int updateByPrimaryKeySelective(CooperateLotteryPO record);

    int updateByPrimaryKey(CooperateLotteryPO record);

    CooperateLotteryBO selective(CooperateLotteryVO vo);
}