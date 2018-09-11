package com.hhly.cmscore.cms.remote.service;

import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.cms.agent.bo.AgentSubMemberBO;
import com.hhly.skeleton.cms.agent.bo.AgentTakenCMBCBankExcelBO;
import com.hhly.skeleton.cms.agent.bo.AgentTransLogBO;
import com.hhly.skeleton.cms.agent.bo.AgentTransTakenExcelBO;
import com.hhly.skeleton.cms.agent.vo.AgentQueryVO;
import com.hhly.skeleton.cms.agent.vo.AgentTransTakenVO;

import java.util.List;
import java.util.Map;

/**
 * @author Tony Wang
 * @version 1.0
 * @desc    代理系统服务
 * @date 2018/3/9 10:47
 * @company 益彩网络科技有限公司
 */
public interface IAgentService {

    /**
     * 分页查询直属代理用户
     * @param vo
     * @return
     */
    PagingBO<AgentSubMemberBO> pageDirect(AgentQueryVO vo);

    /**
     * 分页查询下级代理
     * @param vo
     * @return
     */
    PagingBO<AgentSubMemberBO> pageSub(AgentQueryVO vo);

    /**
     * 分页查询代理钱包流水
     * @param vo
     * @return
     */
    PagingBO<AgentTransLogBO> pageTrans(AgentQueryVO vo);

    /**
     * 查询钱包流水(导出excel用)
     * @param vo
     * @return
     */
    List<AgentTransLogBO> findTransExcel(AgentQueryVO vo);

    /**
     * 分页查询代理提现记录
     * @param vo
     * @return
     */
    PagingBO<AgentTransTakenVO> pageTaken(AgentTransTakenVO vo);

    /**
     * 查询符合条件的代理提现记录数量
     * @param vo
     * @return
     */
    int countTaken(AgentTransTakenVO vo);

    /**
     * 查询代理提现记录
     * @param vo
     * @return
     */
    List<AgentTransTakenVO> findTaken(AgentTransTakenVO vo);

    /**
     * 查询代理提现记录(导出excel用)
     * @param vo
     * @return
     */
    List<AgentTransTakenExcelBO> findTakenExcel(AgentTransTakenVO vo);

    /**
     * 导出提款银行excel
     * @param vo
     * @return
     */
    Map<String,List<AgentTakenCMBCBankExcelBO>> findTakenBankExcel(AgentTransTakenVO vo);
}
