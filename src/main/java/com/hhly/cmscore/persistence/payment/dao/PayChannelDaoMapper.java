package com.hhly.cmscore.persistence.payment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.payment.po.PayChannelPO;
import com.hhly.skeleton.cms.payment.bo.PayChannelBO;
import com.hhly.skeleton.cms.payment.vo.PayChannelVO;

/**
 * @desc 支付渠道表操作
 * @author tangxiaobo
 * @date 2017年3月9日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface PayChannelDaoMapper {

	/**
	 * @author tangxiaobo
	 * @Version 1.0
	 * @CreatDate 2017年3月9日 下午4:03:30
	 * @param bankId 银行id
	 * @param type 渠道支付类型
	 * @return
	 */
	List<PayChannelBO> find(PayChannelVO vo);
	
	int saveList(@Param("po")List<PayChannelPO> po);
	
	int updateList(@Param("po")List<PayChannelPO> po);

	/**
	 * @desc   删除支付渠道
	 * @author Tony Wang
	 * @create 2017年6月27日
	 * @param vo
	 * @return 
	 */
	int delete(PayChannelVO vo);

	int batchMerge(List<PayChannelPO> bankChannels);

	int count(PayChannelVO vo);

	int update(PayChannelPO po);
}
