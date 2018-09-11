package com.hhly.cmscore.cms.remote.service.impl;

import com.hhly.cmscore.cms.remote.service.IPaymentMgrService;
import com.hhly.cmscore.persistence.payment.dao.*;
import com.hhly.cmscore.persistence.payment.po.*;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.page.ISimplePage;
import com.hhly.skeleton.cms.payment.bo.*;
import com.hhly.skeleton.cms.payment.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc 支付管理接口实现类
 * @author tangxiaobo
 * @date 2017年3月9日
 * @company 益彩网络科技公司
 * @version 1.0
 */
@Service("paymentMgrService")
public class PaymentMgrServiceImpl implements IPaymentMgrService {
	@Autowired
	private PayBankDaoMapper payBankDaoMapper;
	@Autowired
	private PayChannelDaoMapper payChannelDaoMapper;
	@Autowired
	private PayBankLimitDaoMapper payBankLimitDaoMapper;
	@Autowired
	private PayChannelMgrDaoMapper payChannelMgrDaoMapper;
	@Autowired
	private PayChannelLimitDaoMapper payChannelLimitDaoMapper;
	@Autowired
	private PayBankCardDaoMapper payBankCardDaoMapper;
	@Autowired
	private IPageService pageService;

	@Override
	public List<PayBankBO> findBank(PayBankVO vo) {
		return payBankDaoMapper.find(vo);
	}

	@Override
	public List<PayChannelBO> findChannel(PayChannelVO vo) {
		return payChannelDaoMapper.find(vo);
	}

	@Override
	public int addBank(PayBankVO vo) {
		validatePayBank(vo);
		PayBankPO po=new PayBankPO(vo);
		return payBankDaoMapper.add(po);
	}

	/**
	 * @desc   验证银行名称及简称是唯一
	 * @author Tony Wang
	 * @create 2017年7月8日
	 * @param vo 
	 */
	private void validatePayBank(PayBankVO vo) {
		PayBankVO criteria = new PayBankVO();
		criteria.setExcludeId(vo.getId());
		criteria.setName(vo.getName());
		criteria.setCname(vo.getCname());
		List<PayBankBO> banks = payBankDaoMapper.find(criteria);
		Assert.isTrue(CollectionUtils.isEmpty(banks), "银行名称或简称已存在");
	}

	@Override
	public PayBankBO findPayBankById(Integer id) {
		return payBankDaoMapper.findById(id);
	}

	@Override
	public int updateBankById(PayBankVO vo) {
		validatePayBank(vo);
		PayBankPO po=new PayBankPO(vo);
		return payBankDaoMapper.updateById(po);
	}

	@Override
	public int saveOrUpdateChannelList(List<PayChannelVO> list) {
			List<PayChannelPO> addList=new ArrayList<PayChannelPO>();
			List<PayChannelPO> updateList=new ArrayList<PayChannelPO>();
			
			for(PayChannelVO vo:list){
				
				PayChannelPO po=new PayChannelPO(vo);
				if(po.getId()==null){
					addList.add(po);
				}else{
					updateList.add(po);
				}
				
			}
			
			if(addList.size()>0){
				payChannelDaoMapper.saveList(addList);
			}
			
			if(updateList.size()>0){
				payChannelDaoMapper.updateList(updateList);
			}
			
			return 1;
		
	}

	@Override
	public List<PayBankLimitBO> findBankLimit(Integer bankId) {
		return payBankLimitDaoMapper.find(bankId);
	}

	@Override
	public int saveOrUpdateBankLimitList(List<PayBankLimitVO> list) {
		
		List<PayBankLimitPO> addList=new ArrayList<PayBankLimitPO>();
		List<PayBankLimitPO> updateList=new ArrayList<PayBankLimitPO>();
		
			for(PayBankLimitVO vo:list){
				
				PayBankLimitPO po=new PayBankLimitPO(vo);
				
				if(po.getId()==null){
					addList.add(po);
				}else{
					updateList.add(po);
				}
				
			}
			
			if(addList.size()>0){
				payBankLimitDaoMapper.saveList(addList);
			}
			
			if(updateList.size()>0){
				payBankLimitDaoMapper.updateList(updateList);
			}
			
			return 1;
	}

	@Override
	public int updateBankList(List<PayBankVO> list) {
		
		List<PayBankPO> poList=new ArrayList<>();
		
		for(PayBankVO vo:list){
			
			PayBankPO po=new PayBankPO(vo);
			poList.add(po);
		}
		
		payBankDaoMapper.updateList(poList);
		return 1;
	}

	/**
	 * @desc   删除支付渠道
	 * @author Tony Wang
	 * @create 2017年6月27日
	 * @param vo
	 * @return 
	 */
	@Override
	public int deleteChannel(PayChannelVO vo) {
		Assert.isTrue(vo.getId() != null || vo.getIds() != null, "请至少选择一条记录");
		return payChannelDaoMapper.delete(vo);
	}

	/**
	 * @desc   删除付款金额超限说明
	 * @author Tony Wang
	 * @create 2017年6月27日
	 * @param vo
	 * @return 
	 */
	@Override
	public int deleteBankLimit(PayBankLimitVO vo) {
		Assert.isTrue(vo.getId() != null || vo.getIds() != null, "请至少选择一条记录");
		return payBankLimitDaoMapper.delete(vo);
	}

	@Override
	public PagingBO<PayChannelMgrBO> pageChannelMgrInfo(final PayChannelMgrVO vo) {
		return pageService.getPageData(vo, new ISimplePage<PayChannelMgrBO>() {
			@Override
			public int getTotal() {
				return payChannelMgrDaoMapper.count(vo);
			}
			@Override
			public List<PayChannelMgrBO> getData() {
				return payChannelMgrDaoMapper.find(vo);
			}
		});
	}

	@Override
	public PagingBO<PayChannelLimitBO> pageChannelLimitInfo(final PayChannelLimitVO vo) {
		return pageService.getPageData(vo, new ISimplePage<PayChannelLimitBO>() {
			@Override
			public int getTotal() {
				return payChannelLimitDaoMapper.count(vo);
			}
			@Override
			public List<PayChannelLimitBO> getData() {
				return payChannelLimitDaoMapper.find(vo);
			}
		});
	}

	@Override
	public int mergeChannelMgrInfo(PayChannelMgrVO vo) {
		// 把渠道配置信息
		PayChannelMgrPO po = new PayChannelMgrPO(vo);
		int affected = payChannelMgrDaoMapper.merge(po);
		// 如果是更新，则把渠道配置信息同步到pay_channel表中
		if(po.getId() != null) {
			PayChannelPO channelPO = new PayChannelPO();
			channelPO.setPayChannelMgrId(po.getId());
			channelPO.setOrderId(po.getOrderId());
			channelPO.setRate(po.getRate());
			channelPO.setPc(po.getPc());
			channelPO.setH5(po.getH5());
			channelPO.setAndroid(po.getAndroid());
			channelPO.setIos(po.getIos());
			channelPO.setAvailable(po.getAvailable());
			channelPO.setPause(po.getPause());
			channelPO.setBegintime(po.getBeginTime());
			channelPO.setEndtime(po.getEndTime());
			payChannelDaoMapper.update(channelPO);
		}
		return affected;
		// 银行配置和付款金额超限分开保存，这里只保存渠道的主信息
		// 如果有要删除的渠道与银行的关系
		/*
		Integer[] ids = vo.getPayChannelDeleteIds();
		if(ids != null && ids.length > 0) {
			PayChannelVO cvo = new PayChannelVO();
			cvo.setIds(ids);
			int ret = payChannelDaoMapper.delete(cvo);
			affected += ret;
		}
		// 如果有要删除的渠道与限额的关系
		ids = vo.getPayChannelLimitDeleteIds();
		if(ids != null && ids.length > 0) {
			PayChannelLimitVO lvo = new PayChannelLimitVO();
			lvo.setIds(ids);
			int ret = payChannelLimitDaoMapper.delete(lvo);
			affected += ret;
		}
		// 如果有配置渠道与银行的关系
		if(!CollectionUtils.isEmpty(vo.getBankChannels())) {
			List<PayChannelPO> pos = PayChannelPO.newInstanceList(vo.getBankChannels());
			int ret = payChannelDaoMapper.batchMerge(pos);
			affected += ret;
		}
		// 如果有配置渠道与限额的关系
		if(!CollectionUtils.isEmpty(vo.getLimits())) {
			List<PayChannelLimitPO> pos = PayChannelLimitPO.newInstanceList(vo.getLimits());
			int ret = payChannelLimitDaoMapper.batchMerge(pos);
			affected += ret;
		}
		// 
		*/
	}

	@Override
	public List<PayChannelMgrBO> findChannelMgrInfo(PayChannelMgrVO vo) {
		return payChannelMgrDaoMapper.find(vo);
	}

	@Override
	public List<PayChannelMgrExcelBO> findChannelMgrExcelInfo(PayChannelMgrVO vo) {
		return payChannelMgrDaoMapper.excel(vo);
	}
	
	@Override
	public PagingBO<PayChannelBO> pageChannelBankInfo(final PayChannelVO vo) {
		return pageService.getPageData(vo, new ISimplePage<PayChannelBO>() {
			@Override
			public int getTotal() {
				return payChannelDaoMapper.count(vo);
			}
			@Override
			public List<PayChannelBO> getData() {
				return payChannelDaoMapper.find(vo);
			}
		});
	}

	@Override
	public int batchMergeChannelBankInfo(List<PayChannelVO> vos) {
		List<PayChannelPO> pos = PayChannelPO.newInstanceList(vos);
		return payChannelDaoMapper.batchMerge(pos);
	}

	@Override
	public int batchMergeChannelLimitInfo(List<PayChannelLimitVO> vos) {
		List<PayChannelLimitPO> pos = PayChannelLimitPO.newInstanceList(vos);
		return payChannelLimitDaoMapper.batchMerge(pos);
	}

	@Override
	public int deleteChannelLimitInfo(PayChannelLimitVO vo) {
		return payChannelLimitDaoMapper.delete(vo);
	}

	@Override
	public PagingBO<PayBankCardVO> pageBankCard(final PayBankCardVO vo) {
		return pageService.getPageData(vo, new ISimplePage<PayBankCardVO>() {
			@Override
			public int getTotal() {
				return payBankCardDaoMapper.count(vo);
			}
			@Override
			public List<PayBankCardVO> getData() {
				return payBankCardDaoMapper.find(vo);
			}
		});
	}

	@Override
	public int updateBankCard(PayBankCardVO vo) {
		return payBankCardDaoMapper.update(vo);
	}

	@Override
	public int batchUpdateBankCard(List<PayBankCardVO> vos) {
		return payBankCardDaoMapper.batchUpdate(vos);
	}
}
