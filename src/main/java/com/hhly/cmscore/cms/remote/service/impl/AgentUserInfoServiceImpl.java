package com.hhly.cmscore.cms.remote.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.cmscore.cms.remote.service.IAgentUserInfoService;
import com.hhly.cmscore.persistence.agent.dao.AgentUserInfoMapper;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.bo.ResultBO;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.page.ISimplePage;
import com.hhly.skeleton.cms.agent.bo.AgentInfoBO;
import com.hhly.skeleton.cms.agent.bo.AgentRebateBo;
import com.hhly.skeleton.cms.agent.vo.AgentRebateConfigHistoryVO;
import com.hhly.skeleton.cms.agent.vo.AgentRebateConfigVO;
import com.hhly.skeleton.cms.agent.vo.AgentSetVO;

@Service(value = "agentUserInfoService")
public class AgentUserInfoServiceImpl implements IAgentUserInfoService {
	
	@Autowired
	private IPageService pageService;
	@Autowired
	private AgentUserInfoMapper agentUserInfoMapper;

	@Override
	public PagingBO<AgentSetVO> getUserList(final AgentSetVO vo) {

		return pageService.getPageData(vo, new ISimplePage<AgentSetVO>() {
			@Override
			public int getTotal() {
				return agentUserInfoMapper.getTotal(vo);
			}

			@Override
			public List<AgentSetVO> getData() {
				return agentUserInfoMapper.getAgentUserInfoList(vo);
			}
		});
	}

	@Override
	public List<AgentSetVO> getUserInfo(String accountName) {
		
		return agentUserInfoMapper.getUserInfo(accountName);
	}

	@Override
	public ResultBO<?> updateAgent(AgentSetVO vo) {
		Integer updateAgent = agentUserInfoMapper.updateAgent(vo);
		if(updateAgent>0){
			return ResultBO.ok(updateAgent);
		}
		return ResultBO.err();
	}

	@Override
	public List<AgentRebateConfigVO> getAgentRebateConfigs(AgentSetVO vo) {
		List<AgentRebateConfigVO> agentRebateConfigs = agentUserInfoMapper.getAgentRebateConfigs(vo);
		sortConfig(agentRebateConfigs);
		return agentRebateConfigs;
	}
	
	@Override
	public List<AgentRebateConfigHistoryVO> getAgentRebateHistory(AgentSetVO vo) {
		//根据agentId获取所有的rebateId
		Map<String,Object> map = new HashMap<>();
		map.put("agentId", vo.getAgentId());
		//flag 为true 表示指查找最近一条
		map.put("flag", false);
		List<AgentRebateBo> rebateIds = agentUserInfoMapper.getRebateIdByAgentId(map);
		if(rebateIds==null || rebateIds.size()<=0){
			return null;
		}
		//根据rebateId分别获取对应的记录
		List<AgentRebateConfigHistoryVO> history = new ArrayList<>();
		for (int i = 0; i < rebateIds.size(); i++) {
			AgentRebateConfigHistoryVO vob = new AgentRebateConfigHistoryVO();
			List<AgentRebateConfigVO> agentRebateHistory = agentUserInfoMapper.getAgentRebateHistory(rebateIds.get(i).getId());
			sortConfig(agentRebateHistory);
			vob.setConfigCreateTime(rebateIds.get(i).getCreateTime());
			vob.setConfigs(agentRebateHistory);
			history.add(vob);
		}
		return history;
	}

	@Override
	public ResultBO<Object> addConfig(AgentRebateConfigVO[] lists) {
		//在主表插入一条记录，把lists插入从表中
		agentUserInfoMapper.insertAgentRebate(lists[0]);
		Map<String,Object> map = new HashMap<>();
		map.put("agentId", lists[0].getAgentId());
		//flag 为true 表示指查找最近一条
		map.put("flag", true);
		int rebateId = agentUserInfoMapper.getRebateIdByAgentId(map).get(0).getId();
		for (int i = 0; i < lists.length; i++) {
			lists[i].setConfigId(rebateId);
		}
		int success = agentUserInfoMapper.insertAgentRebateConfigs(Arrays.asList(lists));
		if(success>0){
			return ResultBO.ok(success);
		}
		return ResultBO.err(-1);
	}

	@Override
	public List<AgentRebateConfigVO> getDefaultAgentRebateConfigs() {
		Map<String,Object> map = new HashMap<>();
		map.put("agentId", 0);
		//flag 为true 表示指查找最近一条
		map.put("flag", true);
		List<AgentRebateBo> rebate = agentUserInfoMapper.getRebateIdByAgentId(map);

		List<AgentRebateConfigVO> agentRebateHistory = agentUserInfoMapper.getAgentRebateHistory(rebate.get(0).getId());
		sortConfig(agentRebateHistory);
		return agentRebateHistory;
	}

	@Override
	public ResultBO<?> addDefaultConfigs(AgentRebateConfigVO[] lists) {
		if(lists.length>0){
			//1.更新agent_rebate
			agentUserInfoMapper.updateDefaultAgentRebate(lists[0]);
			//2.先删除后更新config的数据
			Map<String,Object> map = new HashMap<>();
			map.put("agentId", 0);
			//flag 为true 表示指查找最近一条
			map.put("flag", true);
			int rebateId = agentUserInfoMapper.getRebateIdByAgentId(map).get(0).getId();
			for (int i = 0; i < lists.length; i++) {
				lists[i].setConfigId(rebateId);
			}
			agentUserInfoMapper.deleteAllDefaultRebateConfig(rebateId);
			int count = agentUserInfoMapper.insertAgentRebateConfigs(Arrays.asList(lists));
			return ResultBO.ok(count);
		}
		return ResultBO.err(-1);
	}
	
	
	@Override
	public ResultBO<?> applyAllAgents(AgentRebateConfigVO[] lists) {
		//找到所有人的代理人 agent_info   启用状态下的  1表示启用
		if(lists==null || lists.length<=0){
			return ResultBO.err();
		}
		
		AgentInfoBO info = new AgentInfoBO(1);
		List<AgentInfoBO> allAgents = agentUserInfoMapper.getAllAgents(info);
		//agent_rebate 默认的返佣  agent_id = 0
		List<AgentRebateConfigVO> rebateConfigList = agentUserInfoMapper.getAgentRebateConfigs(new AgentSetVO(0));
		if(rebateConfigList==null || rebateConfigList.size()<1){
			return ResultBO.err();
		}
		//给买个代理人添加一条返佣
		for (AgentInfoBO agentInfoBO : allAgents) {
			Integer agentId = agentInfoBO.getId();
			AgentRebateConfigVO rebateBO = new AgentRebateConfigVO(agentId,new Date(),0,lists[0].getCreateBy(),lists[0].getUpdateBy(),new Date());
			agentUserInfoMapper.insertAgentRebate(rebateBO);
			for (int i = 0; i < rebateConfigList.size(); i++) {
				rebateConfigList.get(i).setConfigId(rebateBO.getId());
			}
			agentUserInfoMapper.insertAgentRebateConfigs(rebateConfigList);
		}
		return ResultBO.ok();
	}
	
	

	
	private void sortConfig(List<AgentRebateConfigVO> agentRebateHistory){
		if(agentRebateHistory==null || agentRebateHistory.size()==0){
			return;
		}
		int direct = 0,agent=0;
		for (AgentRebateConfigVO agentRebateConfigVO : agentRebateHistory) {
			if(agentRebateConfigVO.getDirectRatio()==null){
				direct++;
			}
			if(agentRebateConfigVO.getAgentRatio()==null){
				agent++;
			}
		}
		if(direct>=agent){
			agentRebateHistory.sort(new Comparator<AgentRebateConfigVO>() {
				@Override
				public int compare(AgentRebateConfigVO o1, AgentRebateConfigVO o2) {
					//以agent_ratio排序
					if(o1.getAgentRatio()==null){
						return -1;
					}
					if(o2.getAgentRatio()==null){
						return 1;
					}
					return o1.getAgentRatio()-o2.getAgentRatio()>=0?1:-1;
				}
			});
		}else{
			agentRebateHistory.sort(new Comparator<AgentRebateConfigVO>() {
				@Override
				public int compare(AgentRebateConfigVO o1, AgentRebateConfigVO o2) {
					//以direct_ration排序
					if(o1.getAgentRatio()==null){
						return -1;
					}
					if(o2.getDirectRatio()==null){
						return 1;
					}
					return o1.getDirectRatio()-o2.getDirectRatio()>=0?1:-1;
				}
			});
		}
	}


}
