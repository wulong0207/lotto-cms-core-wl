package com.hhly.cmscore.persistence.cooperate.dao;

import com.hhly.cmscore.persistence.cooperate.po.CooperateChannelPO;
import com.hhly.skeleton.base.bo.DictionaryBO;
import com.hhly.skeleton.cms.cooperate.bo.CooperateChannelBO;
import com.hhly.skeleton.cms.cooperate.vo.CooperateChannelVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CooperateChannelDaoMapper {

    int findCount(CooperateChannelVO vo);

    List<DictionaryBO> selectChannelNameDictBO();

    List<CooperateChannelBO> findCooperateChannelBOList(CooperateChannelVO vo);

    int deleteByPrimaryKey(Integer id);

    int insert(CooperateChannelPO record);

    int insertSelective(CooperateChannelPO record);

    CooperateChannelBO selectByPrimaryKey(Integer id);

    CooperateChannelBO selectByMarketChannelId(@Param("marketChannelId") String marketChannelId);

    CooperateChannelBO selectByChannelId(@Param("marketChannelId") String marketChannelId);

    int updateByPrimaryKeySelective(CooperateChannelPO record);

    int updateByPrimaryKey(CooperateChannelPO record);

    int updatePassword(CooperateChannelPO record);

    int updateBalance(CooperateChannelVO vo);

    int updateStop(List<CooperateChannelBO> bos);
}