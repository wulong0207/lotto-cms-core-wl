package com.hhly.cmscore.cms.remote.service.impl;

import com.hhly.cmscore.cms.remote.service.IAgentService;
import com.hhly.cmscore.persistence.agent.dao.AgentInfoMapper;
import com.hhly.cmscore.persistence.agent.dao.AgentTransLogMapper;
import com.hhly.cmscore.persistence.agent.dao.AgentTransTakenMapper;
import com.hhly.cmscore.persistence.order.dao.OrderInfoDaoMapper;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.page.AbstractStatisticsPage;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.page.ISimplePage;
import com.hhly.skeleton.cms.agent.bo.*;
import com.hhly.skeleton.cms.agent.vo.AgentQueryVO;
import com.hhly.skeleton.cms.agent.vo.AgentTransTakenVO;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Tony Wang
 * @version 1.0
 * @desc  代理系统服务
 * @date 2018/3/9 10:49
 * @company 益彩网络科技有限公司
 */
@Service
public class AgentServiceImpl implements IAgentService {

    @Autowired
    private IPageService pageService;

    @Autowired
    private AgentInfoMapper agentInfoMapper;

    @Autowired
    private OrderInfoDaoMapper orderInfoDaoMapper;

    @Autowired
    private AgentTransTakenMapper agentTransTakenMapper;

    @Autowired
    private AgentTransLogMapper agentTransLogMapper;

    @Override
    public PagingBO<AgentSubMemberBO> pageDirect(AgentQueryVO vo) {
        return pageService.getPageData(vo,new ISimplePage<AgentSubMemberBO>() {
            @Override
            public int getTotal() {
                return agentInfoMapper.countDirect(vo);
            }
            @Override
            public List<AgentSubMemberBO> getData() {
                List<AgentSubMemberBO> infos = agentInfoMapper.findDirect(vo);
                if(!infos.isEmpty()) {
                    List<Integer> userIds = infos.stream().map(directAgent -> directAgent.getMemberUserId()).collect(Collectors.toList());
                    AgentQueryVO orderVO = new AgentQueryVO();
                    String yearAndMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
                    orderVO.setYearMonth(yearAndMonth);
                    orderVO.setUserIds(userIds);
                    List<AgentOrderInfoBO> agentOrderInfo = orderInfoDaoMapper.sumAgentOrderAmount(orderVO);
                    if(!agentOrderInfo.isEmpty()) {
                        Map<Integer, AgentOrderInfoBO> orderInfoMap = agentOrderInfo.stream().collect(Collectors.toMap(o->o.getUserId(),o->o));
                        infos.stream().forEach(agent->{
                            AgentOrderInfoBO order = orderInfoMap.get(agent.getMemberUserId());
                            if(order == null) return;
                            agent.setAccruedOrderAmount(order.getAccruedOrderAmount());
                            agent.setAccruedOrderNum(order.getAccruedOrderNum());
                            agent.setMonthOrderAmount(order.getMonthOrderAmount());
                        });
                    }
                }
                return infos;
            }
        });
    }

    @Override
    public PagingBO<AgentSubMemberBO> pageSub(AgentQueryVO vo) {
        return pageService.getPageData(vo,new ISimplePage<AgentSubMemberBO>() {
            @Override
            public int getTotal() {
                return agentInfoMapper.countSub(vo);
            }
            @Override
            public List<AgentSubMemberBO> getData() {
                List<AgentSubMemberBO> infos = agentInfoMapper.findSub(vo);
                if(!infos.isEmpty()) {
                    List<Integer> pids = infos.stream().map(sub -> sub.getMemberUserId()).collect(Collectors.toList());
                    AgentQueryVO orderVO = new AgentQueryVO();
                    String yearAndMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
                    orderVO.setYearMonth(yearAndMonth);
                    orderVO.setParentIds(pids);
                    List<AgentOrderInfoBO> agentOrderInfo = orderInfoDaoMapper.sumAgentOrderAmount(orderVO);
                    // 如果代理会员名下的有用户下单
                    if(!agentOrderInfo.isEmpty()) {
                        Map<String, AgentOrderInfoBO> orderInfoMap = agentOrderInfo.stream().collect(Collectors.toMap(o->o.getAgentCode(),o->o));
                        infos.stream().forEach(agent->{
                            AgentOrderInfoBO order = orderInfoMap.get(agent.getMemberAgentCode());
                            // 如果此用户没下单
                            if(order == null) return;
                            agent.setAccruedOrderAmount(order.getAccruedOrderAmount());
                            agent.setAccruedOrderNum(order.getAccruedOrderNum());
                            agent.setMonthOrderAmount(order.getMonthOrderAmount());
                        });
                    }
                }
                return infos;
            }
        });
    }

    @Override
    public PagingBO<AgentTransLogBO> pageTrans(AgentQueryVO vo) {
        return pageService.getPageData(vo,new ISimplePage<AgentTransLogBO>() {
            @Override
            public int getTotal() {
                return agentTransLogMapper.count(vo);
            }
            @Override
            public List<AgentTransLogBO> getData() {
                return agentTransLogMapper.find(vo);
            }
        });
    }

    @Override
    public List<AgentTransLogBO> findTransExcel(AgentQueryVO vo) {
        return agentTransLogMapper.find(vo);
    }

    @Override
    public PagingBO<AgentTransTakenVO> pageTaken(AgentTransTakenVO vo) {
        return pageService.getPageData(vo,
            new AbstractStatisticsPage<AgentTransTakenVO>() {
                @Override
                public int getTotal() {
                    this.setSis(agentTransTakenMapper.findStatis(vo));
                    return NumberUtils.toInt(this.getSis().get("total").toString());
                }
                @Override
                public List<AgentTransTakenVO> getData() {
                    return agentTransTakenMapper.find(vo);
                }
                @Override
                public Object getOther() {
                    return getTakenTransSisInfo(this.getSis(), this.getData());
                }
            });
    }

    @Override
    public int countTaken(AgentTransTakenVO vo) {
        return agentTransTakenMapper.count(vo);
    }

    @Override
    public List<AgentTransTakenVO> findTaken(AgentTransTakenVO vo) {
        return agentTransTakenMapper.find(vo);
    }

    @Override
    public List<AgentTransTakenExcelBO> findTakenExcel(AgentTransTakenVO vo) {
        return agentTransTakenMapper.excel(vo);
    }

    @Override
    public Map<String, List<AgentTakenCMBCBankExcelBO>> findTakenBankExcel(AgentTransTakenVO vo) {
        // excel文件名要包含批次号，excel的"注释"列存流水号
        return agentTransTakenMapper.findBankExcel(vo).stream().collect(Collectors.groupingBy(AgentTakenCMBCBankExcelBO::getBatchNum));
    }

    private Object getTakenTransSisInfo(Map<String, Object> sis, List<AgentTransTakenVO> data) {
        Map<String, Object> newSis = new HashMap<>(sis);
        BigDecimal singleExtractAmount = BigDecimal.ZERO;
        BigDecimal singleServiceCharge = BigDecimal.ZERO;
        BigDecimal singleTaxCharge = BigDecimal.ZERO;
        for(AgentTransTakenVO bo : data) {
            singleExtractAmount = singleExtractAmount.add(bo.getExtractAmount());
            singleServiceCharge = singleServiceCharge.add(bo.getServiceCharge());
            singleTaxCharge = singleTaxCharge.add(bo.getTaxCharge());
        }
        newSis.put("singleExtractAmount", singleExtractAmount);
        newSis.put("singleServiceCharge", singleServiceCharge);
        newSis.put("singleTaxCharge", singleTaxCharge);
        newSis.put("queryExtractAmount", sis.get("queryExtractAmount") == null ? "0" : String.valueOf(sis.get("queryExtractAmount")));
        newSis.put("queryServiceCharge",  sis.get("queryServiceCharge") == null ? "0" : String.valueOf(sis.get("queryServiceCharge")));
        newSis.put("queryTaxCharge",  sis.get("queryTaxCharge") == null ? "0" : String.valueOf(sis.get("queryTaxCharge")));
        return newSis;
    }
}
