package com.hhly.cmscore.persistence.payment.dao;

import java.util.List;

import com.hhly.cmscore.persistence.payment.po.PayChannelMgrPO;
import com.hhly.skeleton.cms.payment.bo.PayChannelMgrBO;
import com.hhly.skeleton.cms.payment.bo.PayChannelMgrExcelBO;
import com.hhly.skeleton.cms.payment.vo.PayChannelMgrVO;

/**
 * @desc    渠道管理dao
 * @author  Tony Wang
 * @date    2017年12月2日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface PayChannelMgrDaoMapper {

	int count(PayChannelMgrVO vo);

	List<PayChannelMgrBO> find(PayChannelMgrVO vo);

	int merge(PayChannelMgrPO payChannelMgrPO);

	List<PayChannelMgrExcelBO> excel(PayChannelMgrVO vo);
	
}
