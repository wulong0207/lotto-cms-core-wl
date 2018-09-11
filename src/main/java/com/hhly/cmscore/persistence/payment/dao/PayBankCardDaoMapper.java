package com.hhly.cmscore.persistence.payment.dao;

import com.hhly.skeleton.cms.payment.vo.PayBankCardVO;

import java.util.List;

/**
 * @desc    渠道管理dao
 * @author  Tony Wang
 * @date    2017年12月2日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface PayBankCardDaoMapper {

	int count(PayBankCardVO vo);

	List<PayBankCardVO> find(PayBankCardVO vo);

    int batchUpdate(List<PayBankCardVO> vos);

	int update(PayBankCardVO vo);
}
