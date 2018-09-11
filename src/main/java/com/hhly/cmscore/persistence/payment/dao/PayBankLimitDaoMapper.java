package com.hhly.cmscore.persistence.payment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.payment.po.PayBankLimitPO;
import com.hhly.skeleton.cms.payment.bo.PayBankLimitBO;
import com.hhly.skeleton.cms.payment.vo.PayBankLimitVO;

/**
 * @desc 支付银行卡限制说明表操作
 * @author tangxiaobo
 * @date 2017年3月9日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface PayBankLimitDaoMapper {

	/**
	 * @author tangxiaobo
	 * @Version 1.0
	 * @CreatDate 2017年3月9日 下午4:00:10
	 * @param bankId 银行id
	 * @return 银行限额列表
	 */
	List<PayBankLimitBO> find(@Param("bankId") Integer bankId);

	int saveList(@Param("po") List<PayBankLimitPO> po);

	int updateList(@Param("po") List<PayBankLimitPO> po);

	int delete(PayBankLimitVO vo);
}