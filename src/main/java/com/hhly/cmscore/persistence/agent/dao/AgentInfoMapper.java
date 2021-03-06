package com.hhly.cmscore.persistence.agent.dao;

import com.hhly.skeleton.cms.agent.bo.AgentSubMemberBO;
import com.hhly.skeleton.cms.agent.vo.AgentQueryVO;

import java.util.List;

/**
 * @author Tony Wang
 * @version 1.0
 * @desc
 * @date 2018/3/9 10:57
 * @company 益彩网络科技有限公司
 */
public interface AgentInfoMapper {

    int countDirect(AgentQueryVO vo);

    List<AgentSubMemberBO> findDirect(AgentQueryVO vo);

    int countSub(AgentQueryVO vo);

    List<AgentSubMemberBO> findSub(AgentQueryVO vo);
}
