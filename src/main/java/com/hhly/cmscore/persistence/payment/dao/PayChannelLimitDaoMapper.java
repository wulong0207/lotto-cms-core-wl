package com.hhly.cmscore.persistence.payment.dao;

import java.util.List;

import com.hhly.cmscore.persistence.payment.po.PayChannelLimitPO;
import com.hhly.skeleton.cms.payment.bo.PayChannelLimitBO;
import com.hhly.skeleton.cms.payment.vo.PayChannelLimitVO;

/**
 * @desc    渠道限额dao
 * @author  Tony Wang
 * @date    2017年12月2日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface PayChannelLimitDaoMapper {

	int count(PayChannelLimitVO vo);

	List<PayChannelLimitBO> find(PayChannelLimitVO vo);

	int batchMerge(List<PayChannelLimitPO> pos);

	int delete(PayChannelLimitVO vo);

}
