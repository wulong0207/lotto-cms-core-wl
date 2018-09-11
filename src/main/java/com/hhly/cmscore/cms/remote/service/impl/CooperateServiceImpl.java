package com.hhly.cmscore.cms.remote.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.hhly.cmscore.persistence.cooperate.po.CooperateExchangeRecordPO;
import com.hhly.cmscore.persistence.trans.dao.TransUserDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.hhly.cmscore.cms.remote.service.ICooperateService;
import com.hhly.cmscore.persistence.cooperate.dao.CooperateAgencyDaoMapper;
import com.hhly.cmscore.persistence.cooperate.dao.CooperateCdkeyMapper;
import com.hhly.cmscore.persistence.cooperate.dao.CooperateChannelDaoMapper;
import com.hhly.cmscore.persistence.cooperate.dao.CooperateExchangeRecordMapper;
import com.hhly.cmscore.persistence.cooperate.dao.CooperateLotteryMapper;
import com.hhly.cmscore.persistence.cooperate.po.CooperateAgencyPO;
import com.hhly.cmscore.persistence.cooperate.po.CooperateChannelPO;
import com.hhly.cmscore.persistence.cooperate.po.CooperateLotteryPO;
import com.hhly.skeleton.base.bo.DictionaryBO;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.common.CoOperateEnum;
import com.hhly.skeleton.base.common.LotteryEnum;
import com.hhly.skeleton.base.common.OrderEnum;
import com.hhly.skeleton.base.constants.CacheConstants;
import com.hhly.skeleton.base.constants.Constants;
import com.hhly.skeleton.base.exception.ResultJsonException;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.page.ISimplePage;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.base.util.EncryptUtil;
import com.hhly.skeleton.base.util.MathUtil;
import com.hhly.skeleton.base.util.NumberUtil;
import com.hhly.skeleton.base.util.ObjectUtil;
import com.hhly.skeleton.base.util.OrderNoUtil;
import com.hhly.skeleton.cms.cooperate.bo.CooperateAgencyBO;
import com.hhly.skeleton.cms.cooperate.bo.CooperateCdKeyLotteryNumBO;
import com.hhly.skeleton.cms.cooperate.bo.CooperateCdKeyLotteryRecodeListBO;
import com.hhly.skeleton.cms.cooperate.bo.CooperateCdkeyBO;
import com.hhly.skeleton.cms.cooperate.bo.CooperateChannelBO;
import com.hhly.skeleton.cms.cooperate.bo.CooperateExchangeRecordBO;
import com.hhly.skeleton.cms.cooperate.bo.CooperateLotteryBO;
import com.hhly.skeleton.cms.cooperate.vo.CooperateAgencyVO;
import com.hhly.skeleton.cms.cooperate.vo.CooperateCdkeyVO;
import com.hhly.skeleton.cms.cooperate.vo.CooperateChannelVO;
import com.hhly.skeleton.cms.cooperate.vo.CooperateExchangeRecordVO;
import com.hhly.skeleton.cms.cooperate.vo.CooperateLotteryVO;
import com.hhly.skeleton.lotto.base.cooperate.bo.CoOperateCdkeyQueueBO;
import com.hhly.skeleton.lotto.base.cooperate.vo.CoOperateCdkeyVO;

/**
 * @author lgs on
 * @version 1.0
 * @desc 积分兑换实现类
 * @date 2018/3/7.
 * @company 益彩网络科技有限公司
 */
@Service("iCooperateService")
public class CooperateServiceImpl implements ICooperateService {

	@Autowired
	private CooperateChannelDaoMapper cooperateChannelDaoMapper;

	@Autowired
	private CooperateCdkeyMapper cooperateCdkeyMapper;

	@Autowired
	private CooperateExchangeRecordMapper cooperateExchangeRecordMapper;

	@Autowired
	private CooperateLotteryMapper cooperateLotteryMapper;

	@Autowired
	private CooperateAgencyDaoMapper cooperateAgencyDaoMapper;

	@Autowired
	private IPageService pageService;

	@Autowired
	private RedisTemplate<String, CoOperateCdkeyQueueBO> redisTemplate;

    @Autowired
    private TransUserDaoMapper transUserDaoMapper;

	/**
	 * @param cooperateChannelVO
	 *            参数对象
	 * @return 查询分页列表
	 * @desc 查询渠道分页列表
	 * @author lgs
	 * @date 2017年2月8日
	 */
	@Override
	public PagingBO<CooperateChannelBO> findPaging(final CooperateChannelVO cooperateChannelVO) {
		return pageService.getPageData(cooperateChannelVO, new ISimplePage<CooperateChannelBO>() {

			/**
			 * 分页总行数
			 *
			 * @return
			 */
			@Override
			public int getTotal() {
				return cooperateChannelDaoMapper.findCount(cooperateChannelVO);
			}

			/**
			 * 分页数据
			 *
			 * @return
			 */
			@Override
			public List<CooperateChannelBO> getData() {
                List<CooperateChannelBO> list = cooperateChannelDaoMapper.findCooperateChannelBOList(cooperateChannelVO);
//                list.forEach(v -> {
//                    if (v.getType() == 4 || v.getType() == 3) {
//                        double total = transUserDaoMapper.findTransAmountTotalByChannelId(v.getMarketChannelId());
//                        double money = cooperateExchangeRecordMapper.findTotalByChannelId(v.getMarketChannelId());
//                        v.setBalance(0 - total + money);
//                    }
//                });
                return list;
            }
		});
	}

	/**
	 * @param vo
	 *            参数对象
	 * @return 查询分页列表
	 * @desc 查询渠道彩种分页列表
	 * @author lgs
	 * @date 2017年2月8日
	 */
	@Override
	public PagingBO<CooperateLotteryBO> findCooperateLotteryPagingBO(final CooperateLotteryVO vo) {
		return pageService.getPageData(vo, new ISimplePage<CooperateLotteryBO>() {

			/**
			 * 分页总行数
			 *
			 * @return
			 */
			@Override
			public int getTotal() {
				return cooperateLotteryMapper.count(vo);
			}

			/**
			 * 分页数据
			 *
			 * @return
			 */
			@Override
			public List<CooperateLotteryBO> getData() {
				if (ObjectUtil.isBlank(vo.getChannelId())) {
					vo.setChannelId("-1");
				}
				return cooperateLotteryMapper.findCooperateLotteryList(vo);
			}
		});

	}

	/**
	 * 保存商户彩种信息
	 *
	 * @param vo
	 * @return
	 */
	@Override
	public int saveCooperateLottery(CooperateLotteryVO vo) {
		int total = cooperateLotteryMapper.count(vo);
		if (total > 0) {
			vo.setLotteryCode(null);
			return cooperateLotteryMapper.updateByPrimaryKeySelective(new CooperateLotteryPO(vo));
		} else {
			return cooperateLotteryMapper.insert(new CooperateLotteryPO(vo));
		}
	}

	/**
	 * 删除商户彩种
	 *
	 * @param vo
	 * @return
	 */
	@Override
	public int delCooperateLottery(CooperateLotteryVO vo) {
		return cooperateLotteryMapper.deleteByPrimaryKey(vo.getId());
	}

	/**
	 * 保存渠道信息
	 *
	 * @param vo
	 * @return
	 */
	@Override
	public int saveCooperateChannel(CooperateChannelVO vo) throws NoSuchAlgorithmException {
		int total = cooperateChannelDaoMapper.findCount(vo);
		if (total > 0) {
			if (vo.getId() == null) {
				throw new ResultJsonException("渠道已经存在");
			}
			return cooperateChannelDaoMapper.updateByPrimaryKeySelective(new CooperateChannelPO(vo));
		} else {
			vo.setKey(EncryptUtil.getRandomString(Constants.NUM_24));
			vo.setBalance(0d);
			String rcode = EncryptUtil.getSalt();
			vo.setPassword(EncryptUtil.createDefaultPassword(rcode));
			vo.setRcode(rcode);
			return cooperateChannelDaoMapper.insert(new CooperateChannelPO(vo));
		}
	}

	/**
	 * 保存渠道信息
	 *
	 * @param vo
	 * @return
	 */
	@Override
	public int delCooperateChannel(CooperateChannelVO vo) {
		cooperateLotteryMapper.deleteByChannelId(vo.getMarketChannelId());
		return cooperateChannelDaoMapper.deleteByPrimaryKey(vo.getId());
	}

	/**
	 * @param vo
	 *            参数对象
	 * @return 查询分页列表
	 * @desc 查询流水分页列表
	 * @author lgs
	 * @date 2017年2月8日
	 */
	@Override
	public PagingBO<CooperateExchangeRecordBO> findCooperateExchangeRecordPagingBO(final CooperateExchangeRecordVO vo) {
		return pageService.getPageData(vo, new ISimplePage<CooperateExchangeRecordBO>() {

			/**
			 * 分页总行数
			 *
			 * @return
			 */
			@Override
			public int getTotal() {
				return cooperateExchangeRecordMapper.selectCount(vo);
			}

			/**
			 * 分页数据
			 *
			 * @return
			 */
			@Override
			public List<CooperateExchangeRecordBO> getData() {
				List<CooperateExchangeRecordBO> list = cooperateExchangeRecordMapper.selectExchangeRecordList(vo);

				return list;
			}
		});
	}

	/**
	 * 查询流水导出信息
	 *
	 * @param vo
	 * @return
	 */
	@Override
	public List<CooperateExchangeRecordBO> findCooperateExchangeRecordBOList(CooperateExchangeRecordVO vo) {
		return cooperateExchangeRecordMapper.selectExchangeRecordList(vo);
	}

	/***
	 * 查询可用渠道
	 * 
	 * @return
	 */
	@Override
	public List<DictionaryBO> selectChannelNameDictBO() {
		return cooperateChannelDaoMapper.selectChannelNameDictBO();
	}

	/**
	 * 查询渠道彩种信息
	 *
	 * @param vo
	 * @return
	 */
	@Override
	public List<DictionaryBO> findCooperateLotteryListByChannelId(CooperateLotteryVO vo) {
		return cooperateLotteryMapper.findCooperateLotteryListByChannelId(vo);
	}

	/**
	 * 新增流水充值记录
	 *
	 * @param vo
	 * @return
	 */
	@Override
	public int saveCooperateExchangeRecord(CooperateExchangeRecordVO vo) {
		int result = 0;
		CooperateChannelBO cooperateChannelBO = cooperateChannelDaoMapper.selectByMarketChannelId(vo.getChannelId());

		if (cooperateChannelBO.getCooperateEndTime() != null && cooperateChannelBO.getCooperateEndTime().getTime() < new Date().getTime()) {
			throw new ResultJsonException("渠道结束已经到期，无法继续充值");
		}

		if (cooperateChannelBO.getIsStop() != null && cooperateChannelBO.getIsStop().equals(0)) {
			throw new ResultJsonException("渠道禁止使用，无法继续充值");
		}

		// 等于1为兑换 2充值
		if (vo.getPayClass().equals(2)) {
			vo.setSerialType((int) CoOperateEnum.SerialTypeEnum.COOPERATE_SERIAL.getValue());
			Double money = NumberUtil.sum(cooperateChannelBO.getBalance(), vo.getPayAmount());
			vo.setChannelBalance(money);
			vo.setSerialNumber(OrderNoUtil.getOrderNo(OrderEnum.NumberCode.RUNNING_WATER_IN));
			vo.setOrderInfo("资金充值-余额");
			vo.setPayClass(1); // CMS充值方式全部为充值流水
			result = cooperateExchangeRecordMapper.insertSelective(vo);
			CooperateChannelVO cooperateChannelVO = new CooperateChannelVO();
			cooperateChannelVO.setId(cooperateChannelBO.getId());
			cooperateChannelVO.setBalance(NumberUtil.sum(cooperateChannelBO.getBalance(), vo.getPayAmount()));
			result = cooperateChannelDaoMapper.updateBalance(cooperateChannelVO);
		} else if (vo.getPayClass().equals(1)) {
			if (!cooperateChannelBO.getSettlementType().equals((int) CoOperateEnum.SettlementType.STOCK.getValue())) {
				throw new ResultJsonException("彩种库存扣款方式才能充值彩种");
			}
			vo.setPayClass(1); // CMS充值方式全部为充值流水
			vo.setSerialType(Integer.valueOf(CoOperateEnum.SerialTypeEnum.COOPERATE_SERIAL.getValue())); // 这里只有商户流水
			vo.setChannelBalance(cooperateChannelBO.getBalance());

			// 查询渠道彩种信息 用于计算每张彩票兑换需要多少钱
			CooperateLotteryVO cooperateLotteryVO = new CooperateLotteryVO();
			cooperateLotteryVO.setLotteryCode(vo.getLotteryCode());
			cooperateLotteryVO.setChannelId(vo.getChannelId());
			CooperateLotteryBO cooperateLotteryBO = cooperateLotteryMapper.selective(cooperateLotteryVO);
			// 计算一共需要多少钱
			Double money = MathUtil.mul(cooperateLotteryBO.getExchangeBalance().doubleValue(), vo.getPayAmount());
			vo.setSerialNumber(OrderNoUtil.getOrderNo(OrderEnum.NumberCode.RUNNING_WATER_OUT));
			vo.setOrderInfo("资金充值-彩种-" + LotteryEnum.Lottery.getLottery(Integer.valueOf(vo.getLotteryCode())).getDesc());

			CooperateCdkeyVO cooperateCdkeyVO = new CooperateCdkeyVO();
			cooperateCdkeyVO.setLotteryCode(vo.getLotteryCode());
			cooperateCdkeyVO.setChannelId(vo.getChannelId());
			cooperateCdkeyVO.setPageSize(vo.getPayAmount().intValue());
			List<CoOperateCdkeyQueueBO> cdkeyList = findCdkeyList(cooperateCdkeyVO.getPageSize());
			try{
				if (cdkeyList.size() < vo.getPayAmount()) {
					throw new ResultJsonException("彩种本站库存不足");
				}
				// 保存消费了多少钱
				vo.setPayAmount(money);
				result = cooperateExchangeRecordMapper.insertSelective(vo);
				// cdkey 分配渠道归属 以及生成本站兑换码
	
				cdkeyList.forEach(v -> {
					CooperateCdkeyBO cdkeyBO = new CooperateCdkeyBO();
					cdkeyBO.setId(v.getId());
					cdkeyBO.setMyCdkey(getMyKey());
					cdkeyBO.setLotteryCode(vo.getLotteryCode());
					cooperateCdkeyMapper.updateExchangeChannel(cdkeyBO);
				});
	
				List<CooperateExchangeRecordVO> cooperateExchangeRecordVOS = new ArrayList<>();

				cdkeyList.forEach(v -> {
					CooperateExchangeRecordVO cooperateExchangeRecordVO = new CooperateExchangeRecordVO();
					cooperateExchangeRecordVO.setChannelBalance(cooperateChannelBO.getBalance());
					cooperateExchangeRecordVO.setSerialType(Integer.valueOf(CoOperateEnum.SerialTypeEnum.CDKEY_SERIAL.getValue()));
					cooperateExchangeRecordVO.setCdkeyId(v.getId());
					cooperateExchangeRecordVO.setPayClass(vo.getPayClass());
					cooperateExchangeRecordVO.setOrderInfo("待兑换");
					cooperateExchangeRecordVO.setExchangeOverTime(DateUtil.addDay(new Date(), 90));
					cooperateExchangeRecordVO.setPayAmount(cooperateLotteryBO.getExchangeBalance());
					cooperateExchangeRecordVO.setChannelId(vo.getChannelId());
					cooperateExchangeRecordVO.setCreateBy(vo.getCreateBy());
					cooperateExchangeRecordVO.setModifyBy(vo.getModifyBy());
					cooperateExchangeRecordVOS.add(cooperateExchangeRecordVO);
				});
				cooperateExchangeRecordMapper.insertList(cooperateExchangeRecordVOS);
			}catch(Exception e) {
				//回滚Cdkey队列
				if(!ObjectUtil.isBlank(cdkeyList)) {
					redisTemplate.opsForList().leftPushAll(CacheConstants.C_CORE_COOPERATE_CDKEY_QUEUE, cdkeyList);
				}
				throw e;
			}
		}

		return result;
	}

	public String getMyKey() {
		String resutl = "";
		resutl = OrderNoUtil.getOrderNo(OrderEnum.NumberCode.CDKEY_INTEGRAL);
		CooperateCdkeyBO bo = cooperateCdkeyMapper.findBaseResultByMyKey(resutl);
		if (bo == null) {
			return resutl;
		}
		return getMyKey();
	}

	/**
	 * 新增cdkey库存
	 *
	 * @param vos
	 * @return
	 */
	@Override
	public int saveCooperateCdKeyList(List<CooperateCdkeyVO> vos) {
		for (CooperateCdkeyVO vo : vos) {
			int count = cooperateCdkeyMapper.findBaseResultByLotteryKey(vo.getLottoCdkey());
			if (count > 0) {
				throw new ResultJsonException(vo.getLottoCdkey() + "数据库已经存在，请删除在再导入");
			}
		}
		int result = cooperateCdkeyMapper.insertList(vos);
		if(result > 0) {
			List<CoOperateCdkeyQueueBO> cdkeyQueueBOList = new ArrayList<>(vos.size());
			vos.forEach(vo -> {
				CoOperateCdkeyQueueBO cdkeyQueueBO = new CoOperateCdkeyQueueBO();
				cdkeyQueueBO.setId(vo.getId());
				cdkeyQueueBO.setOverTime(vo.getOverTime());
				cdkeyQueueBOList.add(cdkeyQueueBO);
			});
			redisTemplate.opsForList().rightPushAll(CacheConstants.C_CORE_COOPERATE_CDKEY_QUEUE, cdkeyQueueBOList);
		}
		return result;
	}

	/**
	 * 查询渠道彩种数量
	 *
	 * @param vo
	 * @return
	 */
	@Override
	public List<CooperateCdKeyLotteryNumBO> findCooperateCdKeyLotteryNumBOList(CooperateCdkeyVO vo) {
		return cooperateCdkeyMapper.findLotteryNum(vo);
	}

	/**
	 * @param vo
	 *            参数对象
	 * @return 查询分页列表
	 * @desc 查询彩种流水详情
	 * @author lgs
	 * @date 2017年2月8日
	 */
	@Override
	public PagingBO<CooperateCdKeyLotteryRecodeListBO> findCooperateCdKeyLotteryRecodeListBOPagingBO(CooperateCdkeyVO vo) {
		return pageService.getPageData(vo, new ISimplePage<CooperateCdKeyLotteryRecodeListBO>() {

			/**
			 * 分页总行数
			 *
			 * @return
			 */
			@Override
			public int getTotal() {
				return cooperateCdkeyMapper.findLotteryRecodeCount(vo);
			}

			/**
			 * 分页数据
			 *
			 * @return
			 */
			@Override
			public List<CooperateCdKeyLotteryRecodeListBO> getData() {
				return cooperateCdkeyMapper.findLotteryRecodeList(vo);
			}
		});
	}

	/**
	 * 查询渠道信息
	 *
	 * @param channelId
	 * @return
	 */
	@Override
	public CooperateChannelBO selectByChannelId(String channelId) {
		return cooperateChannelDaoMapper.selectByChannelId(channelId);
	}

	/**
	 * 根据渠道查询 中介商户代理渠道
	 *
	 * @param vo
	 * @return
	 */
	@Override
	public PagingBO<CooperateAgencyBO> findCooperateAgencyBOByChannelId(CooperateAgencyVO vo) {
		return pageService.getPageData(vo, new ISimplePage<CooperateAgencyBO>() {

			/**
			 * 分页总行数
			 *
			 * @return
			 */
			@Override
			public int getTotal() {
				return cooperateAgencyDaoMapper.count(vo);
			}

			/**
			 * 分页数据
			 *
			 * @return
			 */
			@Override
			public List<CooperateAgencyBO> getData() {
				return cooperateAgencyDaoMapper.findListByChannelId(vo);
			}
		});
	}

	/**
	 * 保存中介商户代理渠道
	 *
	 * @param vo
	 * @return
	 */
	@Override
	public int saveChildChannel(CooperateAgencyVO vo) {
		int total = cooperateAgencyDaoMapper.count(vo);
		if (total > 0) {
			vo.setChannelId(null);
			return cooperateAgencyDaoMapper.updateByPrimaryKeySelective(new CooperateAgencyPO(vo));
		} else {
			return cooperateAgencyDaoMapper.insert(new CooperateAgencyPO(vo));
		}
	}

	/**
	 * 删除中介商户代理渠道
	 *
	 * @param vo
	 * @return
	 */
	@Override
	public int delChildChannel(CooperateAgencyVO vo) {
		return cooperateAgencyDaoMapper.deleteByPrimaryKey(vo.getId());
	}

	/**
	 * 重置password
	 *
	 * @param vo
	 * @return
	 */
	@Override
	public int resetPassword(CooperateChannelVO vo) {
		return cooperateChannelDaoMapper.updatePassword(new CooperateChannelPO(vo));
	}

	@Override
	public List<CooperateCdKeyLotteryRecodeListBO> findLotteryRecodeList(CooperateCdkeyVO vo) {
		return cooperateCdkeyMapper.findLotteryRecodeList(vo);
	}

	/**
	 * 更新已结束合作时间的渠道状态
	 *
	 * @return
	 */
	@Override
	public int updateStop() {
		CooperateChannelVO vo = new CooperateChannelVO();
		vo.setIsOver(1);
		List<CooperateChannelBO> bos = cooperateChannelDaoMapper.findCooperateChannelBOList(vo);
		if (bos.size() > 0) {
			return cooperateChannelDaoMapper.updateStop(bos);
		}
		return 0;
	}

	/**
	 * 取出指定数量兑换码
	 * 
	 * @param vo
	 * @return
	 */
	private List<CoOperateCdkeyQueueBO> findCdkeyList(int num) {
		String key = CacheConstants.C_CORE_COOPERATE_CDKEY_QUEUE;
		Long length = redisTemplate.opsForList().size(key);
		if (length < num) {
			return Collections.emptyList();
		}
		Date nowTime = new Date();
		List<CoOperateCdkeyQueueBO> cdkeyList = new ArrayList<>();
		while (cdkeyList.size() < num && redisTemplate.opsForList().size(key) > 0) {
			int range = num - cdkeyList.size();
			List<CoOperateCdkeyQueueBO> eachCdkeyList = redisTemplate.opsForList().range(key, 0, range - 1);
			eachCdkeyList.forEach(cdkey -> {
				if (cdkey.getOverTime() == null || cdkey.getOverTime().after(nowTime)) {
					cdkeyList.add(cdkey);
				}
			});
			redisTemplate.opsForList().trim(key, range, -1);
		}
		if (cdkeyList.size() != num) {
			// 还原已取出兑换码
			if (cdkeyList.size() > 0) {
				redisTemplate.opsForList().leftPushAll(CacheConstants.C_CORE_COOPERATE_CDKEY_QUEUE, cdkeyList);
			}
			return Collections.emptyList();
		}
		return cdkeyList;
	}

	/**
	 * 更新过期兑换码
	 *
	 * @return
	 */
	@Override
	public int updateOverTimeCdKey() {
		List<CooperateExchangeRecordBO> list = cooperateExchangeRecordMapper.selectOverTimeCdKey();

		if(!list.isEmpty()){
			cooperateCdkeyMapper.updateOverTimeCdKey(list);
			List<CooperateCdkeyVO> vos = new ArrayList<>();

			list.forEach(temp->{
				CooperateCdkeyVO vo = new CooperateCdkeyVO();
				vo.setTicketChannel(temp.getChannelId());
				vo.setLottoCdkey(temp.getCdKey());
				vo.setStauts(2);
				vo.setOverTime(temp.getExchangeOverTime());
				vo.setModifyBy("过期兑换码重新使用");
				vo.setCreateBy("过期兑换码重新使用");
				vos.add(vo);
			});
			int result = cooperateCdkeyMapper.insertList(vos);

			if(result > 0) {
				List<CoOperateCdkeyQueueBO> cdkeyQueueBOList = new ArrayList<>(vos.size());
				vos.forEach(vo -> {
					CoOperateCdkeyQueueBO cdkeyQueueBO = new CoOperateCdkeyQueueBO();
					cdkeyQueueBO.setId(vo.getId());
					cdkeyQueueBO.setOverTime(vo.getOverTime());
					cdkeyQueueBOList.add(cdkeyQueueBO);
				});
				redisTemplate.opsForList().rightPushAll(CacheConstants.C_CORE_COOPERATE_CDKEY_QUEUE, cdkeyQueueBOList);
			}
		}



		List<CooperateExchangeRecordPO> cooperateExchangeRecordPOS = cooperateExchangeRecordMapper.selectOverTimeSerNumber();

		if(!cooperateExchangeRecordPOS.isEmpty()){
			cooperateExchangeRecordMapper.updateOverTimeSerNumber(cooperateExchangeRecordPOS);
		}

		return 1;
	}
}
