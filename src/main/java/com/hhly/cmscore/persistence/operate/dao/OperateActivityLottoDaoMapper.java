package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import com.hhly.cmscore.persistence.operate.po.OperateActivityConfigPO;
import com.hhly.cmscore.persistence.operate.po.OperateCouponTempPO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityLottoVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateCouponTempBO;
import com.hhly.skeleton.lotto.base.operate.vo.OperateCouponTempVO;

public interface OperateActivityLottoDaoMapper {   
    int deleteBatch(List<Integer> ruleIds);

    int insert(OperateCouponTempPO po);
    int mergeBatch(OperateActivityConfigPO po);

    List<OperateCouponTempBO> findList(OperateActivityLottoVO vo);
    
}