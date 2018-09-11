package com.hhly.cmscore.persistence.cooperate.dao;

import com.hhly.cmscore.persistence.cooperate.po.CooperateAgencyPO;
import com.hhly.skeleton.cms.cooperate.bo.CooperateAgencyBO;
import com.hhly.skeleton.cms.cooperate.vo.CooperateAgencyVO;

import java.util.List;


public interface CooperateAgencyDaoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CooperateAgencyPO record);

    int insertSelective(CooperateAgencyPO record);

    int count(CooperateAgencyVO vo);

    List<CooperateAgencyBO> findListByChannelId(CooperateAgencyVO vo);

    CooperateAgencyPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CooperateAgencyPO record);

    int updateByPrimaryKey(CooperateAgencyPO record);
}