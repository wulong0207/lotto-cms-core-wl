package com.hhly.cmscore.cms.remote.service.status.operate;

import com.hhly.cmscore.cms.remote.service.status.entity.UpdateStatusBO;

/**
 * @desc 订单状态相关操作
 * @author jiangwei
 * @date 2017年3月15日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface IOrderOperation {
	 
     /**
      * 检查方案
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017年3月15日 下午12:29:32
     * @param orderCode
     */
    void ckeckOrder(UpdateStatusBO po);
    /**
     * 禁止检查方案
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017年3月15日 下午12:29:32
     * @param orderCode
     */
     void forbidCkeckOrder(UpdateStatusBO po);
     /**
      * 撤单
      * @author jiangwei
      * @Version 1.0
      * @CreatDate 2017年3月15日 下午12:29:32
      * @param orderCode
      */
     void revoke(UpdateStatusBO po);
}
