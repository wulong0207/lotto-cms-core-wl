package com.hhly.cmscore.persistence.operate.dao;

import com.hhly.cmscore.persistence.operate.po.OperateActivityConfigPO;
import com.hhly.cmscore.persistence.operate.po.OperateActivitySportRulePO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityConfigBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivitySportRuleBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityConfigVO;
import com.hhly.skeleton.cms.operatemgr.vo.SportAgainstVO;
import com.hhly.skeleton.lotto.base.operate.bo.SportAgainstBO;

import java.util.List;

/**
 * @author zhouyang
 * @version 1.0
 * @desc 赛事加奖活动mapper接口
 * @date 2017/8/16
 * @company 益彩网络科技公司
 */
public interface OperateActivitySportRuleDaoMapper {

    /**
     * 查询正在开售中的单关胜负彩或让分胜负彩集合
     * @return
     */
    List<SportAgainstBO> findSportAgainstInfo(SportAgainstVO vo);

    /**
     * 查询当前彩种的总记录
     * @param vo
     * @return
     */
    int findTotal(SportAgainstVO vo);

    /**
     * 查询赛事加奖活动详情
     * @param vo
     * @return
     */
    OperateActivityConfigBO findSportRule(OperateActivityConfigVO vo);

    /**
     * 保存赛事加奖活动信息
     * @param po
     * @return
     */
    int mergeBatch(OperateActivityConfigPO po);

    /**
     * 添加配置赛事 - 单关加奖
     * @param po
     * @return
     */
    int insertSportRule(OperateActivitySportRulePO po);

    /**
     * 修改活动配置
     * @param po
     * @return
     */
    int updateSportRule(OperateActivitySportRulePO po);

    /**
     * 删除赛事信息
     * @param ruleIds
     * @return
     */
    int deleteBatch(List<Integer> ruleIds);

    /**
     *
     * @return
     */
    List<OperateActivitySportRuleBO> findSportRuleList(Integer activityConfigId);

}
