package com.hhly.cmscore.cms.remote.service.status.operate;

import com.hhly.cmscore.cms.remote.service.status.entity.UpdateStatusBO;

/**
 * @desc 订单执行操作
 * @author jiangwei
 * @date 2017年3月15日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public enum OperationOrderEnum {

	/**
	 * 检查方案
	 */
	CHECK {
		public boolean execute(UpdateStatusBO po, IOrderOperation operation) {
			operation.ckeckOrder(po);
			return true;
		}
	},
	/**
	 * 禁止检查方案
	 */
	FORBID {
		public boolean execute(UpdateStatusBO po, IOrderOperation operation) {
			operation.forbidCkeckOrder(po);
			return true;
		}
	},
	/**
	 * 撤单
	 */
	REVOKE {
		public boolean execute(UpdateStatusBO po, IOrderOperation operation) {
			operation.revoke(po);
			return true;
		}
	};
	public abstract boolean execute(UpdateStatusBO po, IOrderOperation operation);

}
