package com.hhly.cmscore.persistence.payment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.payment.po.PayBankPO;
import com.hhly.skeleton.cms.payment.bo.PayBankBO;
import com.hhly.skeleton.cms.payment.vo.PayBankVO;

/**
 * @desc 支付银行操作
 * @author tangxiaobo
 * @date 2017年3月9日
 * @company 益彩网络科技公司
 * @version 1.0
 */
/**
 * @desc
 * @author tangxiaobo
 * @date 2017年3月9日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface PayBankDaoMapper {
	
	/**
	 * @author tangxiaobo
	 * @Version 1.0
	 * @CreatDate 2017年3月9日 下午3:53:37
	 * @param vo
	 * @return 支付银行列表
	 */
	List<PayBankBO> find(PayBankVO vo);
	
	int add(PayBankPO po);
	
	PayBankBO findById(@Param("id")Integer id);
	
	int updateById(PayBankPO po);
	
	int updateList(@Param("po")List<PayBankPO> po);
}
