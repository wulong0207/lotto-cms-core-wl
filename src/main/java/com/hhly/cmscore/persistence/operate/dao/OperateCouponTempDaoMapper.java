package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import com.hhly.cmscore.persistence.operate.po.OperateActivityConfigPO;
import com.hhly.cmscore.persistence.operate.po.OperateCouponTempPO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateCouponTempBO;
import com.hhly.skeleton.lotto.base.operate.vo.OperateCouponTempVO;

public interface OperateCouponTempDaoMapper {   
    int deleteBatch(List<Integer> ruleIds);
    
    int deleteById(Integer ruleId);

    int insert(OperateCouponTempPO po);
    
    int update(OperateCouponTempVO vo); 
    
    int mergeBase(OperateCouponTempPO po);    
    int mergeBatch(OperateActivityConfigPO po);
    
    int mergeBatchTemp(List<OperateCouponTempPO> po);
    int mergeCoupon(OperateCouponTempPO po); 

     int findTotal(OperateCouponTempVO vo);
    
    List<OperateCouponTempBO> findList(OperateCouponTempVO vo);
    
    OperateCouponTempBO findDetailById(Integer id);
}