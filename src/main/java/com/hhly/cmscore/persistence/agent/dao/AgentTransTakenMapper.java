package com.hhly.cmscore.persistence.agent.dao;

import com.hhly.skeleton.cms.agent.bo.AgentTakenCMBCBankExcelBO;
import com.hhly.skeleton.cms.agent.bo.AgentTransTakenExcelBO;
import com.hhly.skeleton.cms.agent.vo.AgentTransTakenVO;

import java.util.List;
import java.util.Map;

/**
 * @author Tony Wang
 * @version 1.0
 * @desc
 * @date 2018/3/9 10:57
 * @company 益彩网络科技有限公司
 */
public interface AgentTransTakenMapper {

    List<AgentTransTakenVO> find(AgentTransTakenVO vo);

    Map<String,Object> findStatis(AgentTransTakenVO vo);

    int count(AgentTransTakenVO vo);

    List<AgentTransTakenExcelBO> excel(AgentTransTakenVO vo);

    List<AgentTakenCMBCBankExcelBO> findBankExcel(AgentTransTakenVO vo);
}
