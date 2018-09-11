package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import com.hhly.cmscore.persistence.operate.po.OperateActivityConfigPO;
import com.hhly.cmscore.persistence.operate.po.OperateActivityRulePO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityRuleBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityRuleVO;

public interface OperateActivityRuleDaoMapper {
 
    int deleteById(Integer id);
    
    int deleteBatch(List<Integer> ruleIds);

    int insert(OperateActivityRulePO po);
    
    int merge(OperateActivityRulePO vo);
    
    int mergeBatch(OperateActivityConfigPO po);

    int updateById(OperateActivityRuleVO vo);
    
    int findTotal(OperateActivityRuleVO vo);
    
    List<OperateActivityRuleBO> findList(OperateActivityRuleVO vo);
    
    OperateActivityRuleBO findDetailById(Integer id);
}