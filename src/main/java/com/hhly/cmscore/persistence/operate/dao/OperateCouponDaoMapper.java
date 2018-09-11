package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.operate.po.OperateCouponPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateCouponBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateCouponExcelBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateCouponVO;

/**
 * 
 * @author jiangwei
 * @Version 1.0
 * @CreatDate 2017-1-15 下午4:03:18
 * @Desc 优惠券操作类
 */
public interface OperateCouponDaoMapper {
    
	int findTotal(OperateCouponVO vo);
	
	List<OperateCouponBO> findList(OperateCouponVO vo);
	
	OperateCouponBO findCouponDetail(@Param("redCode")String redCode);

	List<OperateCouponExcelBO> findExcelCoupon(OperateCouponVO vo);

	int updCouponStatus(OperateCouponPO po);
	 
}