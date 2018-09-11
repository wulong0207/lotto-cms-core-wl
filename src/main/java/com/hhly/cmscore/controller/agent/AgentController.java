package com.hhly.cmscore.controller.agent;

import com.hhly.cmscore.cms.remote.service.IAgentService;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.cms.agent.bo.AgentSubMemberBO;
import com.hhly.skeleton.cms.agent.bo.AgentTakenCMBCBankExcelBO;
import com.hhly.skeleton.cms.agent.bo.AgentTransLogBO;
import com.hhly.skeleton.cms.agent.bo.AgentTransTakenExcelBO;
import com.hhly.skeleton.cms.agent.vo.AgentQueryVO;
import com.hhly.skeleton.cms.agent.vo.AgentTransTakenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Tony Wang
 * @version 1.0
 * @desc
 * @date 2018/3/9 9:39
 * @company 益彩网络科技有限公司
 */
@RestController
@RequestMapping("agent")
public class AgentController {

    @Autowired
    private IAgentService agentService;

    @RequestMapping(value="direct/page", method = RequestMethod.POST)
    public PagingBO<AgentSubMemberBO> pageDirect(@RequestBody AgentQueryVO vo) {
        return agentService.pageDirect(vo);
    }

    @RequestMapping(value="sub/page", method = RequestMethod.POST)
    public PagingBO<AgentSubMemberBO> pageSub(@RequestBody AgentQueryVO vo) {
        return agentService.pageSub(vo);
    }

    @RequestMapping(value="trans/page", method = RequestMethod.POST)
    public PagingBO<AgentTransLogBO> pageTrans(@RequestBody AgentQueryVO vo) {
        return agentService.pageTrans(vo);
    }

    @RequestMapping(value="trans/excel", method = RequestMethod.POST)
    public List<AgentTransLogBO> findTakenExcel(@RequestBody AgentQueryVO vo) {
        return agentService.findTransExcel(vo);
    }

    @RequestMapping(value="taken/page", method = RequestMethod.POST)
    public PagingBO<AgentTransTakenVO> pageTrans(@RequestBody AgentTransTakenVO vo) {
        return agentService.pageTaken(vo);
    }

    @RequestMapping(value="taken/find", method = RequestMethod.POST)
    public List<AgentTransTakenVO> findTaken(@RequestBody AgentTransTakenVO vo) {
        return agentService.findTaken(vo);
    }

    @RequestMapping(value="taken/count", method = RequestMethod.POST)
    public int countTaken(@RequestBody AgentTransTakenVO vo) {
        return agentService.countTaken(vo);
    }

    @RequestMapping(value="taken/excel", method = RequestMethod.POST)
    public List<AgentTransTakenExcelBO> findTakenExcel(@RequestBody AgentTransTakenVO vo) {
        return agentService.findTakenExcel(vo);
    }

    @RequestMapping(value="taken/bank/excel", method = RequestMethod.POST)
    public Map<String, List<AgentTakenCMBCBankExcelBO>> findTakenBankExcel(@RequestBody AgentTransTakenVO vo) {
        return agentService.findTakenBankExcel(vo);
    }
}
