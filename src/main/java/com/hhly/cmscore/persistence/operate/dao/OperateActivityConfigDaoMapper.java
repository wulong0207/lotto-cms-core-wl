package com.hhly.cmscore.persistence.operate.dao;

import com.hhly.cmscore.persistence.operate.po.OperateActivityConfigPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityConfigBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityConfigVO;

public interface OperateActivityConfigDaoMapper {
   
    int merge(OperateActivityConfigPO po);
    
    OperateActivityConfigBO findDetail(OperateActivityConfigVO vo);
    /***
     * 查询优惠券红包活动信息
     * @param vo
     * @return
     */
    OperateActivityConfigBO findActivityCoupon(OperateActivityConfigVO vo);
    /***
     * 查询抽奖活动信息
     * @param vo
     * @return
     */
    OperateActivityConfigBO findActivityAward(OperateActivityConfigVO vo);
    /***
     * 查询追号送活动信息
     * @param vo
     * @return
     */
    OperateActivityConfigBO findActivityAddCode(OperateActivityConfigVO vo);
    /***
     * 查询冠军竞猜活动信息
     * @param vo
     * @return
     */
    OperateActivityConfigBO findActivityChp(OperateActivityConfigVO vo);
}