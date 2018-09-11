package com.hhly.cmscore.persistence.agent.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hhly.skeleton.cms.agent.bo.AgentInfoBO;
import com.hhly.skeleton.cms.agent.bo.AgentRebateBo;
import com.hhly.skeleton.cms.agent.vo.AgentRebateConfigVO;
import com.hhly.skeleton.cms.agent.vo.AgentSetVO;

public interface AgentUserInfoMapper {
	
	int getTotal(AgentSetVO vo);
	
	List<AgentSetVO> getAgentUserInfoList(AgentSetVO vo);
	
	List<AgentSetVO> getUserInfo(@Param("accountName")String accountName);
	
	int updateAgent(AgentSetVO vo);
	
	List<AgentRebateConfigVO> getAgentRebateConfigs(AgentSetVO vo);
	
	List<AgentRebateConfigVO> getAgentRebateHistory(Integer rebateId);
	
	int insertAgentRebate(AgentRebateConfigVO vo);
	
	int insertAgentRebateConfigs(List<AgentRebateConfigVO> list);
	
	List<AgentRebateBo> getRebateIdByAgentId(Map<String,Object> map);

	int updateDefaultAgentRebate(AgentRebateConfigVO vo);

	void deleteAllDefaultRebateConfig(Integer rebateId);
	
	List<AgentInfoBO> getAllAgents(AgentInfoBO bo);
	
	
 }
