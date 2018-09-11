package com.hhly.cmscore.cms.remote.service;

import java.util.List;

import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.bo.ResultBO;
import com.hhly.skeleton.cms.agent.vo.AgentRebateConfigHistoryVO;
import com.hhly.skeleton.cms.agent.vo.AgentRebateConfigVO;
import com.hhly.skeleton.cms.agent.vo.AgentSetVO;

public interface IAgentUserInfoService {
	
	PagingBO<AgentSetVO> getUserList(AgentSetVO vo);
	
	List<AgentSetVO> getUserInfo(String accountName);
	
	ResultBO<?> updateAgent(AgentSetVO vo);
	
	//返佣设置
	List<AgentRebateConfigVO> getAgentRebateConfigs(AgentSetVO vo);
	//变更历史
	List<AgentRebateConfigHistoryVO> getAgentRebateHistory(AgentSetVO vo);
	
	ResultBO<Object> addConfig(AgentRebateConfigVO[] lists);
	
	List<AgentRebateConfigVO> getDefaultAgentRebateConfigs();
	
	ResultBO<?> addDefaultConfigs(AgentRebateConfigVO[] lists);
	
	/**
	 * 将默认返佣配置设置为所有人代理的实际返佣配置
	 * @desc 
	 * @create 2018年6月27日
	 * @param lists
	 * @return ResultBO<Object>
	 */
	ResultBO<?> applyAllAgents(AgentRebateConfigVO[] lists);
}
