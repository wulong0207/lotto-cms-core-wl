package com.hhly.cmscore.cms.remote.service.impl;

import com.hhly.cmscore.cms.remote.service.ITransMgrService;
import com.hhly.cmscore.persistence.trans.dao.*;
import com.hhly.persistence.common.Constants;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.common.TransEnum;
import com.hhly.skeleton.base.page.AbstractStatisticsPage;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.page.ISimplePage;
import com.hhly.skeleton.base.util.NumberUtil;
import com.hhly.skeleton.cms.transmgr.bo.*;
import com.hhly.skeleton.cms.transmgr.vo.*;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author wytong
 * @Version 1.0
 * @CreatDate 2017年1月5日 上午11:25:47
 */
@Service("transMgrService")
public class TransMgrServiceImpl implements ITransMgrService {

	@Autowired
	private TransUserDaoMapper transUserDaoMapper;
	@Autowired
	private TransRedDaoMapper transRedDaoMapper;
	@Autowired
	private TransRechargeDaoMapper transRechargeDaoMapper;
	@Autowired
	private TransTakenDaoMapper transTakenDaoMapper;
	@Autowired
	private TransChannelSettleDaoMapper transChannelSettleDaoMapper;
	@Autowired
	private TransRemittingDaoMapper transRemittingDaoMapper;
	
	@Autowired
	private IPageService pageService;
	@Value("${uploadURL}")
	private String uploadURL;
	
	/**
	 * 同步充值补单操作
	 */
	private final Object controlRechargeResupply = new Object();
	
	@Override
	public PagingBO<TransUserBO> findUserTrans(final TransUserVO vo) {
		return pageService.getPageData(vo,
			new AbstractStatisticsPage<TransUserBO>() {
				@Override
				public int getTotal() {
					this.setSis(transUserDaoMapper.findStatis(vo));
					return NumberUtils.toInt(this.getSis().get("total").toString());
				}
				@Override
				public List<TransUserBO> getData() {
					return transUserDaoMapper.findTrans(vo);
				}
				@Override
				public Object getOther() {
					return getUserTransSisInfo(this.getSis(), this.getData());
				}
			});
	}

	@Override
	public PagingBO<TransRedBO> findRedTrans(final TransRedVO vo) {
		return pageService.getPageData(vo,
			new AbstractStatisticsPage<TransRedBO>() {
				@Override
				public int getTotal() {
					this.setSis(transRedDaoMapper.findStatis(vo));
					return NumberUtils.toInt(this.getSis().get("total").toString());
				}
				@Override
				public List<TransRedBO> getData() {
					return transRedDaoMapper.findTrans(vo);
				}
				@Override
				public Object getOther() {
					return getRedTransSisInfo(this.getSis(), this.getData());
				}
			});
	}
	
	@Override
	public PagingBO<TransRechargeBO> findRechargeTrans(final TransRechargeVO vo) {
		return pageService.getPageData(vo,
			new AbstractStatisticsPage<TransRechargeBO>() {
				@Override
				public int getTotal() {
					this.setSis(transRechargeDaoMapper.findStatis(vo));
					return NumberUtils.toInt(this.getSis().get("total").toString());
				}
				@Override
				public List<TransRechargeBO> getData() {
					List<TransRechargeBO> recharges = transRechargeDaoMapper.findTrans(vo);
					for(TransRechargeBO recharge : recharges)
						recharge.setOrderCode(splitOrderCode(recharge.getOrderCode()));
					return recharges;
				}
				@Override
				public Object getOther() {
					return getRechargeTransSisInfo(this.getSis(), this.getData());
				}
			});
	}

	private String splitOrderCode(String orderCode) {
		if(!StringUtils.hasText(orderCode))
			return orderCode;
		StringBuilder finalOrderCode = new StringBuilder();
		for(String orderCodeTuple : orderCode.split(";")) {
			finalOrderCode.append(orderCodeTuple.split(",")[0]).append(",");
		}
		return finalOrderCode.substring(0,finalOrderCode.length()-1);
		// D17102516241617200069,1;D17102516242417300080,1;D17102516245917300081,1;
		// 拆分订单号，去掉购买类型
	}

	@Override
	public PagingBO<TransTakenBO> findTakenTrans(final TransTakenVO vo) {
		return pageService.getPageData(vo,
			new AbstractStatisticsPage<TransTakenBO>() {
				@Override
				public int getTotal() {
					this.setSis(transTakenDaoMapper.findStatis(vo));
					return NumberUtils.toInt(this.getSis().get("total").toString());
				}
				@Override
				public List<TransTakenBO> getData() {
					return transTakenDaoMapper.findTrans(vo);
				}
				@Override
				public Object getOther() {
					return getTakenTransSisInfo(this.getSis(), this.getData());
				}
			});
	}
	
	@Override
	public PagingBO<TransChannelSettleBO> findChannelSettleTrans(final TransChannelSettleVO vo) {
		return pageService.getPageData(vo,
			new ISimplePage<TransChannelSettleBO>() {
				@Override
				public int getTotal() {
					return transChannelSettleDaoMapper.findTotal(vo);
				}
				@Override
				public List<TransChannelSettleBO> getData() {
					return transChannelSettleDaoMapper.findTrans(vo);
				}
			});
	}
	
	private Object getTakenTransSisInfo(Map<String, Object> sis, List<TransTakenBO> data) {
		Map<String, Object> newSis = new HashMap<>(sis);
		double singleExtractAmount = 0.0;
		double singleServiceCharge = 0.0;
		for(TransTakenBO bo : data) {
			singleExtractAmount =NumberUtil.sum(singleExtractAmount, bo.getExtractAmount());
			singleServiceCharge =NumberUtil.sum(singleServiceCharge, bo.getServiceCharge());
		}
		newSis.put("singleExtractAmount", singleExtractAmount);
		newSis.put("singleServiceCharge", singleServiceCharge);
		newSis.put("queryExtractAmount", sis.get("queryExtractAmount") == null ? "0" : String.valueOf(sis.get("queryExtractAmount")));
		newSis.put("queryServiceCharge",  sis.get("queryServiceCharge") == null ? "0" : String.valueOf(sis.get("queryServiceCharge")));
		return newSis;
	}
	
	private Object getRechargeTransSisInfo(Map<String, Object> sis, List<TransRechargeBO> data) {
		Map<String, Object> newSis = new HashMap<>(sis);
		double singleRechargeAmount = 0.0;
		double singleServiceCharge = 0.0;
		for(TransRechargeBO bo : data) {
			singleRechargeAmount =NumberUtil.sum(singleRechargeAmount, bo.getRechargeAmount());
			singleServiceCharge =NumberUtil.sum(singleServiceCharge, bo.getServiceCharge());
		}
		newSis.put("singleRechargeAmount", singleRechargeAmount);
		newSis.put("singleServiceCharge", singleServiceCharge);
		newSis.put("queryRechargeAmount", sis.get("queryRechargeAmount") == null ? "0" : String.valueOf(sis.get("queryRechargeAmount")));
		newSis.put("queryArrivalAmount",  sis.get("queryArrivalAmount") == null ? "0" : String.valueOf(sis.get("queryArrivalAmount")));
		return newSis;
	}

	private Map<String,Object> getRedTransSisInfo(Map<String, Object> sis, List<TransRedBO> data) {
		Map<String, Object> newSis = new HashMap<>(sis);
		double singleTransAmount = 0.0;
		double singleAftTransAmount = 0.0;
		for(TransRedBO bo : data) {
			singleTransAmount =NumberUtil.sum(singleTransAmount, bo.getTransAmount());
			singleAftTransAmount =NumberUtil.sum(singleAftTransAmount, bo.getAftTransAmount());
		}
		newSis.put("singleTransAmount", singleTransAmount);
		newSis.put("singleAftTransAmount", singleAftTransAmount);
		
		newSis.put("queryTransAmount", sis.get("queryTransAmount") == null ? "0" : String.valueOf(sis.get("queryTransAmount")));
		newSis.put("queryAftTransAmount",  sis.get("queryAftTransAmount") == null ? "0" : String.valueOf(sis.get("queryAftTransAmount")));
		
		return newSis;
	}

	private Map<String,Object> getUserTransSisInfo(Map<String, Object> sis, List<TransUserBO> data) {
		Map<String, Object> newSis = new HashMap<>(sis);
		double singleTransAmount = 0.0;
		double singleCashAmount = 0.0;
		double singleRedTransAmount = 0.0;
		double singleServiceCharge = 0.0;
		for(TransUserBO bo : data) {
			singleTransAmount =NumberUtil.sum(singleTransAmount, bo.getTransAmount());
			singleCashAmount =NumberUtil.sum(singleCashAmount, bo.getCashAmount());
			singleRedTransAmount =NumberUtil.sum(singleRedTransAmount, bo.getRedTransAmount());
			singleServiceCharge =NumberUtil.sum(singleServiceCharge, bo.getServiceCharge());
		}
		newSis.put("singleTransAmount", singleTransAmount);
		newSis.put("singleCashAmount", singleCashAmount);
		newSis.put("singleRedTransAmount", singleRedTransAmount);
		newSis.put("singleServiceCharge", singleServiceCharge);
		
		newSis.put("querySumTransAmount", sis.get("querySumTransAmount") == null ? "0" : String.valueOf(sis.get("querySumTransAmount")));
		newSis.put("querySumCashAmount",  sis.get("querySumCashAmount") == null ? "0" : String.valueOf(sis.get("querySumCashAmount")));
		newSis.put("querySumRedAmount",  sis.get("querySumRedAmount") == null ? "0" : String.valueOf(sis.get("querySumRedAmount")));
		newSis.put("querySumServiceCharge",  sis.get("querySumServiceCharge") == null ? "0" : String.valueOf(sis.get("querySumServiceCharge")));
		
		return newSis;
	}

	@Override
	public List<TransUserExcelBO> getTransUserExcel(TransUserVO vo) {
		int num = transUserDaoMapper.findTotal(vo);
		Assert.isTrue(num <= Constants.EXCEL_NUM,Constants.EXCEL_ERROR_MSG);
		return transUserDaoMapper.findExcel(vo);
	}

	@Override
	public List<TransRedExcelBO> getTransRedExcel(TransRedVO vo) {
		int num = transRedDaoMapper.findTotal(vo);
		Assert.isTrue(num <= Constants.EXCEL_NUM,Constants.EXCEL_ERROR_MSG);
		return transRedDaoMapper.findExcel(vo);
	}

	@Override
	public List<TransRechargeExcelBO> getTransRechargeExcel(TransRechargeVO vo) {
		int num = transRechargeDaoMapper.findTotal(vo);
		Assert.isTrue(num <= Constants.EXCEL_NUM,Constants.EXCEL_ERROR_MSG);
		List<TransRechargeExcelBO> recharges = transRechargeDaoMapper.findExcel(vo);
		for(TransRechargeExcelBO recharge : recharges)
			recharge.setOrderCode(splitOrderCode(recharge.getOrderCode()));
		return recharges;
	}

	@Override
	public List<TransTakenExcelBO> getTransTakenExcel(TransTakenVO vo) {
		int num = transTakenDaoMapper.findTotal(vo);
		Assert.isTrue(num <= Constants.EXCEL_NUM,Constants.EXCEL_ERROR_MSG);
		return transTakenDaoMapper.findExcel(vo);
	}

	@Override
	public Map<String, List<TransTakenCMBCBankExcelBO>> getTransTakenBankExcel(TransTakenVO vo) {
		// excel文件名要包含批次号，excel时的"注释"列存流水号
		List<TransTakenCMBCBankExcelBO> takens = transTakenDaoMapper.findBankExcel(vo);
		ConcurrentHashMap<String, List<TransTakenCMBCBankExcelBO>> map = new ConcurrentHashMap<>();
		if(!CollectionUtils.isEmpty(takens)) {
			for(TransTakenCMBCBankExcelBO taken : takens) {
				map.putIfAbsent(taken.getBatchNum(), new ArrayList<TransTakenCMBCBankExcelBO>());
				map.get(taken.getBatchNum()).add(taken);
			}
		}
		return map;
	}
	
	@Override
	public List<TransChannelSettleExcelBO> getTransChannelSettleExcel(TransChannelSettleVO vo) {
		int num = transChannelSettleDaoMapper.findTotal(vo);
		Assert.isTrue(num <= Constants.EXCEL_NUM,Constants.EXCEL_ERROR_MSG);
		return transChannelSettleDaoMapper.findExcel(vo);
	}

//	@Override
//	public Integer resupply(List<Long> ids, String userName) {
//		Integer affected = transRechargeDaoMapper.resupply(ids, userName);
//		Assert.notNull(affected, "用户充值补单失败");
//		Assert.isTrue(affected > 0, "用户充值补单失败："+affected);
//		// TODO 增加用户余额
//		return affected;
//	}

	@Override
	public int resupply(TransRechargeVO vo) {
		/*
		 * 1）只有状态为订单关闭或交易失败的充值记录，才能进行补单
		 * 2）补单时必须校验充值请求的状态，防止重复补单
		 * 3）补单时必须查询第三方交易状态，第三方平台未收到充值款项的，不能进行补单
		 * 4）补单时选择交易关闭的订单，带入会员昵称且不让修改，财务操作补单时校验充值金额订单原有信息是否一致，不一致则不与补单。
		 * 5）补单后产生一条对应补单记录流水并更新钱包余额
		 */
		Assert.isTrue(Objects.equals(vo.getTransStatus(), TransEnum.RechargeStatus.CLOSE.getValue()), "只有状态处交易关闭的充值记录，才能进行补单");
		// 查询补单记录，防止同一条"交易关闭"的记录重复补单
		synchronized (controlRechargeResupply) {
			TransRechargeVO criteria = new TransRechargeVO();
			criteria.setTransRechargeCode(vo.getTransRechargeCode());
			criteria.setTransStatus(vo.getTransStatus());
			criteria.setRechargeAmount(vo.getRechargeAmount());
			Assert.isTrue(transRechargeDaoMapper.findTotal(criteria) == 0, "此充值已经有补单或补单");
			// TODO 确认用户id和昵称存在此为此交易的用户
		}
		return 0;
	}

//	/**
//	 * @desc   更新提款记录状态(可能会同时更新操作人员信息)
//	 * @author Tony Wang
//	 * @create 2017年5月22日
//	 * @param vos
//	 * @return 
//	 */
//	@Override
//	public int updateTakenStatus(List<TransTakenVO> vos) {
//		TransTakenStatusVisitor transTakenStatusVisitor;
//		List<TransTakenPO> pos = new ArrayList<>();
//		for(TransTakenVO vo : vos) {
//			transTakenStatusVisitor = new TransTakenStatusVisitor();
//			boolean can = VisitorHandler.disboseOrderStatus(vo.getTransStatus(), vo, vo.getNewTransStatus(),  transTakenStatusVisitor);
//			Assert.isTrue(can, "操作非法");
//			// 把新状态值替换旧状态值
//			vo.setTransStatus(vo.getNewTransStatus());
//			// 如果是"审核通过"操作，则设置vo的"审核人员"字段
////			if(Objects.equals(vo.getNewStatus(), ArticleEnum.ArticleStatus.APPROVE.getStatus())) {
////				vo.setAuditBy(vo.getOperator());
//			pos.add(new TransTakenPO(vo));
//		}
//		// foreach update会返回-1，所以取相反数
//		return transTakenDaoMapper.updateStatus(pos);
//	}

	@Override
	public List<String> findTransTakenBatchNums(TransTakenVO vo) {
		return transTakenDaoMapper.findBatchNums(vo);
	}

	@Override
	public List<TransTakenBO> findTakenTransNoPaging(TransTakenVO vo) {
		return transTakenDaoMapper.findTransNoPaging(vo);
	}

	@Override
	public int countTransTaken(TransTakenVO vo) {
		return transTakenDaoMapper.findTotal(vo);
	}

	@Override
	public int updateTakenCreateBy(String actualName, Integer userId) {
		return transTakenDaoMapper.updateCreateBy(actualName, userId);
	}

	@Override
	public PagingBO<TransRemittingBO> pageTransRemitting(TransRemittingBO vo) {
		return pageService.getPageData(vo,
				new ISimplePage<TransRemittingBO>() {
					@Override
					public int getTotal() {
						return transRemittingDaoMapper.count(vo);
					}
					@Override
					public List<TransRemittingBO> getData() {
						List<TransRemittingBO> rems = transRemittingDaoMapper.find(vo);
						if(!CollectionUtils.isEmpty(rems))
							rems.forEach(r-> r.setScreenshot(uploadURL+r.getScreenshot()));
						return rems;
					}
				});
	}

	@Override
	public List<TransRemittingExcelBO> excelTransRemitting(TransRemittingBO vo) {
		return transRemittingDaoMapper.excel(vo);
	}

	@Override
	public int updateTransRemitting(TransRemittingBO vo) {
		return transRemittingDaoMapper.update(vo);
	}
}
