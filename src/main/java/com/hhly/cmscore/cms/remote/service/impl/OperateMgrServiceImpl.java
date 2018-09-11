package com.hhly.cmscore.cms.remote.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;
import com.hhly.cmscore.cms.remote.service.ICustomerMgrService;
import com.hhly.cmscore.cms.remote.service.IOperateMgrService;
import com.hhly.cmscore.cms.remote.service.status.ArticleStatusVisitor;
import com.hhly.cmscore.cms.remote.service.status.HelpArticleStatusVisitor;
import com.hhly.cmscore.persistence.operate.dao.OperateActivityAddedDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateActivityAwardDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateActivityCdkeyDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateActivityChpGuessDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateActivityChpInfoDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateActivityConfigDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateActivityDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateActivityInfoDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateActivityLottoDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateActivityRuleDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateActivitySportRuleDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateAdDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateAdMenuDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateAdTypeDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateArticleDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateArticleTopDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateArticleTypeDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateCouponDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateCouponTempDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateFastDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateFastInfoDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateHelpCorrectDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateHelpDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateHelpTopDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateHelpTypeDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateImgDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateLotteryDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateLotteryInfoDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateMarketChannelDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateMsgInfoDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateRebateUserDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateSoftwareVersionDaoMapper;
import com.hhly.cmscore.persistence.operate.dao.OperateUserAnalysisDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateActivityAddedPO;
import com.hhly.cmscore.persistence.operate.po.OperateActivityAwardPO;
import com.hhly.cmscore.persistence.operate.po.OperateActivityCdkeyPO;
import com.hhly.cmscore.persistence.operate.po.OperateActivityConfigPO;
import com.hhly.cmscore.persistence.operate.po.OperateActivityPO;
import com.hhly.cmscore.persistence.operate.po.OperateActivityRulePO;
import com.hhly.cmscore.persistence.operate.po.OperateActivitySportRulePO;
import com.hhly.cmscore.persistence.operate.po.OperateAdMenuPO;
import com.hhly.cmscore.persistence.operate.po.OperateAdPO;
import com.hhly.cmscore.persistence.operate.po.OperateAdTypePO;
import com.hhly.cmscore.persistence.operate.po.OperateArticlePO;
import com.hhly.cmscore.persistence.operate.po.OperateArticleTopPO;
import com.hhly.cmscore.persistence.operate.po.OperateArticleTypePO;
import com.hhly.cmscore.persistence.operate.po.OperateCouponPO;
import com.hhly.cmscore.persistence.operate.po.OperateCouponTempPO;
import com.hhly.cmscore.persistence.operate.po.OperateFastPO;
import com.hhly.cmscore.persistence.operate.po.OperateHelpCorrectPO;
import com.hhly.cmscore.persistence.operate.po.OperateHelpPO;
import com.hhly.cmscore.persistence.operate.po.OperateHelpTopPO;
import com.hhly.cmscore.persistence.operate.po.OperateHelpTypePO;
import com.hhly.cmscore.persistence.operate.po.OperateLotteryPO;
import com.hhly.cmscore.persistence.operate.po.OperateMarketChannelPO;
import com.hhly.cmscore.persistence.operate.po.OperateMsgConfigPO;
import com.hhly.cmscore.persistence.operate.po.OperateMsgInfoPO;
import com.hhly.cmscore.persistence.operate.po.OperateMsgNewPO;
import com.hhly.cmscore.persistence.operate.po.OperateMsgTemplatePO;
import com.hhly.cmscore.persistence.operate.po.OperateRebateUserPO;
import com.hhly.cmscore.persistence.operate.po.OperateSoftwareVersionPO;
import com.hhly.cmscore.persistence.operate.po.OperateWechatTemplatePO;
import com.hhly.persistence.common.Constants;
import com.hhly.persistence.util.RedisUtil;
import com.hhly.skeleton.base.bo.DictionaryBO;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.bo.ResultBO;
import com.hhly.skeleton.base.common.ActivityEnum.ActivityAddCodeRuleEnum;
import com.hhly.skeleton.base.common.ActivityEnum.ActivityAwardTypeEnum;
import com.hhly.skeleton.base.common.ActivityEnum.ActivityTypeEnum;
import com.hhly.skeleton.base.common.ArticleEnum;
import com.hhly.skeleton.base.common.ChannelEnum;
import com.hhly.skeleton.base.common.ChannelEnum.ChannelTypeEnum;
import com.hhly.skeleton.base.common.DicEnum.MobailPlatFormEnum;
import com.hhly.skeleton.base.common.LotteryEnum;
import com.hhly.skeleton.base.common.OperateCouponEnum.CouponConfigTypeEnum;
import com.hhly.skeleton.base.common.OperateEnum;
import com.hhly.skeleton.base.common.OperateEnum.HelpStatus;
import com.hhly.skeleton.base.common.OperateEnum.RebateHisEnum;
import com.hhly.skeleton.base.common.OperateSoftwareVersionEnum;
import com.hhly.skeleton.base.common.OrderEnum;
import com.hhly.skeleton.base.common.OrderEnum.NumberCode;
import com.hhly.skeleton.base.common.msg.MessageStatus;
import com.hhly.skeleton.base.common.msg.SendStatus;
import com.hhly.skeleton.base.constants.CacheConstants;
import com.hhly.skeleton.base.constants.PayConstants.RedStatusEnum;
import com.hhly.skeleton.base.constants.SymbolConstants;
import com.hhly.skeleton.base.constants.UserConstants;
import com.hhly.skeleton.base.exception.ServiceRuntimeException;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.page.ISimplePage;
import com.hhly.skeleton.base.status.VisitorHandler;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.base.util.ObjectUtil;
import com.hhly.skeleton.base.util.OrderNoUtil;
import com.hhly.skeleton.base.util.StringUtil;
import com.hhly.skeleton.cms.base.vo.StringVO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerBO;
import com.hhly.skeleton.cms.customermgr.vo.LottoCustomerVO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityAddedBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityAwardBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityCdkeyBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityChpGuessBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityChpInfoBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityConfigBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityExcelBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityInfoBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityRechargeBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityRuleBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdMenuBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateAdTypeBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateArticleBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateArticleTypeBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateCouponBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateCouponExcelBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateFastBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateFastInfoBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateHelpBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateHelpCorrectBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateHelpTypeBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateImgBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateLotteryBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateLotteryInfoBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMarketChannelBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMarketChannelExcelBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMsgConfigBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMsgInfoBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMsgLotteryConfigBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMsgNewBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMsgTemplateBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateRebateUserBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateSoftwareVersionBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateUserAnalysisBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateWechatTemplateBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityAddedVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityAwardVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityCdkeyVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityChpGuessVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityConfigVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityLottoVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityRechargeVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityRuleVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivitySportRuleVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdMenuVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdTypeVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleTopVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleTypeVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateCouponVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateFastInfoVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateFastVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpCorrectVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpTopVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpTypeVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateImgVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateLotteryInfoVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateLotteryVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMarketChannelVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgConfigVo;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgInfoVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgLotteryConfigVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgNewVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgTemplateVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateRebateUserVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateSoftwareVersionVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateUserAnalysisVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateWechatTemplateVO;
import com.hhly.skeleton.cms.operatemgr.vo.SportAgainstVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateCouponTempBO;
import com.hhly.skeleton.lotto.base.operate.bo.SportAgainstBO;
import com.hhly.skeleton.lotto.base.operate.vo.OperateCouponTempVO;
import com.hhly.skeleton.user.bo.UserInfoBO;

/**
 * @desc    
 * @author  Tony Wang
 * @date    2017年3月3日
 * @company 益彩网络科技公司
 * @version 1.0
 */
@Service("operateMgrService")
public class OperateMgrServiceImpl implements IOperateMgrService {
	@Autowired
    private OperateMarketChannelDaoMapper marketChannelDaoMapper;
	@Autowired
	private OperateActivityDaoMapper activityDaoMapper;
	@Autowired
	private OperateCouponDaoMapper couponDaoMapper;
	@Autowired
	private OperateAdDaoMapper adDaoMapper;
	@Autowired
	private OperateAdTypeDaoMapper adTypeDaoMapper;
	@Autowired
	private OperateAdMenuDaoMapper adMenuDaoMapper;
	@Autowired
	private OperateLotteryDaoMapper operateLotteryDaoMapper;
	@Autowired
	private OperateLotteryInfoDaoMapper operateLotteryInfoDaoMapper;
	@Autowired
	private OperateFastDaoMapper operateFastDaoMapper;
	@Autowired
	private OperateFastInfoDaoMapper operateFastInfoDaoMapper;
	@Autowired
	private OperateArticleDaoMapper operateArticleDaoMapper;
	@Autowired
	private OperateArticleTypeDaoMapper operateArticleTypeDaoMapper;
	@Autowired
	private OperateArticleTopDaoMapper operateArticleTopDaoMapper;
	@Autowired
	private OperateHelpDaoMapper operateHelpDaoMapper;
	@Autowired
	private OperateHelpTypeDaoMapper operateHelpTypeDaoMapper;
	@Autowired
	private OperateHelpTopDaoMapper operateHelpTopDaoMapper;
	@Autowired
	private OperateHelpCorrectDaoMapper operateHelpCorrectDaoMapper;
	@Autowired
	private OperateSoftwareVersionDaoMapper operateSoftwareVersionDaoMapper;
	@Autowired
	private OperateActivityConfigDaoMapper operateActivityConfigDaoMapper;
	@Autowired
	private OperateActivityRuleDaoMapper operateActivityRuleDaoMapper;
	@Autowired
	private OperateCouponTempDaoMapper operateCouponTempDaoMapper;
	@Autowired
	private OperateActivityLottoDaoMapper operateActivityLottoDaoMapper;
	@Autowired
	private OperateActivityChpGuessDaoMapper operateActivityChpGuessDaoMapper;
	@Autowired
	private OperateActivityChpInfoDaoMapper operateActivityChpInfoDaoMapper;
	@Autowired
	private OperateActivityInfoDaoMapper operateActivityInfoDaoMapper;
	/**
	 * 会员访问信息分析数据接口
	 */
	@Autowired
	private OperateUserAnalysisDaoMapper userAnalysisDaoMapper;
	
	@Autowired
	private IPageService pageService;
	
	@Autowired
	private OperateMsgInfoDaoMapper operateMsgInfoDaoMapper;
	
	@Autowired
	private OperateImgDaoMapper operateImgDaoMapper;

	@Autowired
	private OperateActivitySportRuleDaoMapper operateActivitySportRuleDaoMapper;
	@Autowired
	private OperateRebateUserDaoMapper operateRebateUserDaoMapper;
	@Autowired
	private OperateActivityAwardDaoMapper operateActivityAwardDaoMapper;
	@Autowired
	private OperateActivityAddedDaoMapper operateActivityAddedDaoMapper;
    @Resource
    private OperateActivityCdkeyDaoMapper cdkeyDaoMapper;
	@Autowired
	private RedisUtil redisUtil;
	
	@Value("${before_file_url}")
	private String beforeFileUrl;

	@Autowired
	private ICustomerMgrService customerMgrService;
	
	private final Lock addArticleLock = new ReentrantLock();
	private final Lock addHelpLock = new ReentrantLock();
	
	@Override
	public List<OperateMarketChannelBO> findChannelAllSimple() {
		return marketChannelDaoMapper.findAllSimple();
	}

	@Override
	public PagingBO<OperateMarketChannelBO> findMarketChannel(
			final OperateMarketChannelVO vo) {
		return pageService.getPageData(vo,new ISimplePage<OperateMarketChannelBO>() {
			@Override
			public int getTotal() {
				return marketChannelDaoMapper.findTotal(vo);
			}
			@Override
			public List<OperateMarketChannelBO> getData() {
				return marketChannelDaoMapper.findList(vo);
			}
		});
	}

	@Override
	public List<String> findParentId(StringVO vo) {
		return marketChannelDaoMapper.findParentId(vo.getStr());
	}

	@Override
	public int updOperateMarketChannel(OperateMarketChannelVO vo) {
		OperateMarketChannelPO po =new OperateMarketChannelPO(vo);
		return marketChannelDaoMapper.updOperateMarketChannel(po);
	}

	@Override
	public int addOperateMarketChannel(OperateMarketChannelVO vo) {
		OperateMarketChannelPO po =new OperateMarketChannelPO(vo);
		if(StringUtils.isNotBlank(po.getChannelId())){
			List<Integer> ids = marketChannelDaoMapper.findIdByChannelId(po.getChannelId());
			//渠道ID验证，不能重复
			if(ids.size()>0){
				throw new ServiceRuntimeException("该渠道ID已存在不能添加");
			}
		}else{
			List<String> channelIds = marketChannelDaoMapper.findMaxChannelId();
			int num = 0;
			for (String string : channelIds) {
				try {
					int temp = Integer.parseInt(string);
					if(temp > num){
						num = temp;
					}
				} catch (NumberFormatException e) {
				}
			}
			po.setChannelId(String.valueOf(num+1));
		}
		int ret = marketChannelDaoMapper.addOperateMarketChannel(po);
		// 如果添加渠道成功,新添加的都是叶子结点,若是android渠道则
		OperateSoftwareVersionVO criteria = new OperateSoftwareVersionVO();
		List<OperateSoftwareVersionBO> versions = null;
		if(Objects.equals(po.getTerminalPlatform(), OrderEnum.PlatformType.IOS.getValue())) {
			// 1:ios; 2:android
			criteria.setType((short)1);
			criteria.setChannelId(ChannelEnum.ChannelTypeEnum.IOS.getCode());
			versions = operateSoftwareVersionDaoMapper.find(criteria);
		} else if(Objects.equals(po.getTerminalPlatform(), OrderEnum.PlatformType.ANDROID.getValue())) {
			criteria.setType((short)2);
			criteria.setChannelId(ChannelEnum.ChannelTypeEnum.ANDROID.getCode());
			versions = operateSoftwareVersionDaoMapper.find(criteria);
		}
		if(!org.springframework.util.CollectionUtils.isEmpty(versions)) {
			OperateSoftwareVersionPO versionPO;
			for(OperateSoftwareVersionBO bo : versions) {
				versionPO = new OperateSoftwareVersionPO(bo);
				versionPO.setChannelId(Integer.parseInt(po.getChannelId()));
				operateSoftwareVersionDaoMapper.insert(versionPO);
			}
		}
		return ret;
	}

	@Override
	public List<OperateMarketChannelExcelBO> findExcelMarketChannel(
			OperateMarketChannelVO vo) {
		int num  = marketChannelDaoMapper.findTotal(vo);
		Assert.isTrue(num <= Constants.EXCEL_NUM,Constants.EXCEL_ERROR_MSG);
		return marketChannelDaoMapper.findExcelMarketChannel(vo);
	}

	@Override
	public int countMarketchannel(OperateMarketChannelVO vo) {
		return marketChannelDaoMapper.findTotal(vo);
	}

	@Override
	public int updMarketchannelAppUrl(OperateMarketChannelVO vo) {
		OperateMarketChannelPO po =new OperateMarketChannelPO();
		po.setChannelId(vo.getChannelId());
		po.setAppUrl(vo.getAppUrl());
		Assert.isTrue(StringUtil.hasText(po.getChannelId()) , "更新渠道应用包路径时，渠道id为空");
		return marketChannelDaoMapper.updAppUrl(po);
	}
	
	@Override
	public PagingBO<OperateActivityBO> findActivity(final OperateActivityVO vo) {		
		return pageService.getPageData(vo,new ISimplePage<OperateActivityBO>() {
			@Override
			public int getTotal() {
				return activityDaoMapper.findTotal(vo);
			}
			@Override
			public List<OperateActivityBO> getData() {
				return activityDaoMapper.findList(vo);
			}
		});
	}

	@Override
	public int updOperateActivity(OperateActivityVO vo) {
		OperateActivityPO po = new OperateActivityPO(vo);
		return activityDaoMapper.updOperateActivity(po);
	}

	@Override
	public int addOperateActivity(OperateActivityVO vo) {
		OperateActivityPO po = new OperateActivityPO(vo);
		List<Integer> ids = activityDaoMapper.findIdByActivityCode(po.getActivityCode());
		//活动ID验证，不能重复
		if(ids.size()>0){
			throw new ServiceRuntimeException("该活动ID已存在不能添加");
		}
		return activityDaoMapper.addOperateActivity(po);
	}

	@Override
	public List<OperateActivityExcelBO> findExcelActivity(OperateActivityVO vo) {
		int num = activityDaoMapper.findTotal(vo);
		Assert.isTrue(num <= Constants.EXCEL_NUM,Constants.EXCEL_ERROR_MSG);
		return activityDaoMapper.findExcelActivity(vo);
	}

	@Override
	public OperateActivityBO findOperateActivityDetail(int id) {
		return activityDaoMapper.findOperateActivityDetail(id);
	}


    @Override
    public PagingBO<OperateActivityCdkeyBO> findCdkeyList(final OperateActivityCdkeyVO vo) {
		return pageService.getPageData(vo, new ISimplePage<OperateActivityCdkeyBO>() {

			@Override
			public int getTotal() {
				return cdkeyDaoMapper.findTotal(vo);
			}

			@Override
			public List<OperateActivityCdkeyBO> getData() {
				List<OperateActivityCdkeyBO> list = cdkeyDaoMapper.findCdkeyList(vo);
				for (OperateActivityCdkeyBO cdkeyBO : list) {
					if (!ObjectUtil.isBlank(cdkeyBO.getUserId())) {
						UserInfoBO memberInfo = cdkeyDaoMapper.findMemberInfo(cdkeyBO.getUserId());
						cdkeyBO.setAccountName(memberInfo.getAccount());
						cdkeyBO.setMobile(memberInfo.getMobile());
					}
				}
				return list;
			}

		});
    }

	@Override
	public OperateActivityCdkeyBO findCdkCount(OperateActivityCdkeyVO vo) {
		OperateActivityCdkeyBO bo = new OperateActivityCdkeyBO();
		int total = cdkeyDaoMapper.findTotal(vo);
		vo.setStatus(UserConstants.IS_FALSE);
		int validCdkCount = cdkeyDaoMapper.findValidCdkcount(vo);
		bo.setCdkTotal(total);
		bo.setValidCdkCount(validCdkCount);
		bo.setInvalidCdkCount(total-validCdkCount);
		return bo;
	}

	/**
     * 生成兑换码
     * 先检查此活动已经生成多少个激活码，
     * 1.如果原来的数量小于现在的数量，继续添加现在需求数量-已生成数量
     * 2.如果原来数量大于现在数量，判断新数量必须大于等于已经兑换的数量，其它未兑换的删除
     *
     * @param vo VO
     */
    private void processCdkey(OperateActivityConfigVO vo) {
        List<OperateActivityCdkeyPO> poList = new ArrayList<>();
        //总数量
        OperateActivityCdkeyVO cdkeyVO = OperateActivityCdkeyVO.generatorVO(vo, null);
        int allCount = cdkeyDaoMapper.findValidCdkcount(cdkeyVO);

        List<String> list;
		if (vo.getConfigType().equals((short)3)){
			if (vo.getActivityDayNum() > allCount) {
				list = getRandomCdkeys(vo.getActivityDayNum() - allCount);
				for (String string : list) {
					OperateActivityCdkeyPO cdkeyPO = new OperateActivityCdkeyPO();
					cdkeyPO.setActivityCode(vo.getActivityCode());
					cdkeyPO.setCdkey(string);
					cdkeyPO.setCreateBy(vo.getCreateBy());
					cdkeyPO.setModifyBy(vo.getModifyBy());
					poList.add(cdkeyPO);
				}
				cdkeyDaoMapper.addBatchInsert(poList);
			} else {
				//9<10
				OperateActivityCdkeyVO cdkeyVO1 = OperateActivityCdkeyVO.generatorVO(vo, (short) 1);
				int count1 = cdkeyDaoMapper.findValidCdkcount(cdkeyVO1);//已兑换数量
				if (vo.getActivityDayNum() < count1) {
					//提示已经兑换了多少个，现在只能设置大于等于count1数量
					throw new ServiceRuntimeException("该活动兑换码已兑换【" + count1 + "】个，兑换码使用总次数必须大于等于已兑换数量");
				} else {
					cdkeyDaoMapper.deleteCdkey(allCount - vo.getActivityDayNum());
				}
			}
		} else if (vo.getConfigType().equals((short)4)) {
			if (vo.getActivityDayNum() > allCount) {
				String cdkey = getRandomCdkey();
				for (int i = 0; i < vo.getActivityDayNum()- allCount; i++) {
					OperateActivityCdkeyPO cdkeyPO = new OperateActivityCdkeyPO();
					cdkeyPO.setActivityCode(vo.getActivityCode());
					cdkeyPO.setCdkey(cdkey);
					cdkeyPO.setCreateBy(vo.getCreateBy());
					cdkeyPO.setModifyBy(vo.getModifyBy());
					poList.add(cdkeyPO);
				}
				cdkeyDaoMapper.addBatchInsert(poList);
			} else {
				//9<10
				OperateActivityCdkeyVO cdkeyVO1 = OperateActivityCdkeyVO.generatorVO(vo, (short) 1);
				int count1 = cdkeyDaoMapper.findValidCdkcount(cdkeyVO1);//已兑换数量
				if (vo.getActivityDayNum() < count1) {
					//提示已经兑换了多少个，现在只能设置大于等于count1数量
					throw new ServiceRuntimeException("该活动兑换码已兑换【" + count1 + "】个，兑换码使用总次数必须大于等于已兑换数量");
				} else {
					cdkeyDaoMapper.deleteCdkey(allCount - vo.getActivityDayNum());
				}
			}
		}
    }
    
    public String getRandomCdkey() {
    	boolean exists = true;
		String cdkey = null;
		do {
			cdkey = OrderNoUtil.getOrderNo(NumberCode.CDKEY_COUNPN);
			int count = cdkeyDaoMapper.findCountByCdkey(cdkey);
			exists = count > 0;
		} while (exists);
		return cdkey;
    }
    
    public List<String> getRandomCdkeys(int nums) {
    	Set<String> cdkeySet = new HashSet<>();
    	while(cdkeySet.size()<nums) {
    		int count = nums-cdkeySet.size();
    		if(count > 1000) {
    			count = 1000;
    		}
    		List<String> tempCdkeys = randomCdkey(count);
    		List<String> existCdkeys = cdkeyDaoMapper.findExistCdkeys(tempCdkeys);
    		if(!ObjectUtil.isBlank(existCdkeys)) {
    			tempCdkeys.removeAll(existCdkeys);
    		}
    		cdkeySet.addAll(tempCdkeys);
    	}
    	return new ArrayList<String>(cdkeySet);
    }
    
    private List<String> randomCdkey(int count) {
    	Set<String> cdkeySet = new HashSet<>();
    	while(cdkeySet.size()<count) {
    		cdkeySet.add(OrderNoUtil.getOrderNo(NumberCode.CDKEY_COUNPN));
    	}
    	return new ArrayList<>(cdkeySet);
    }

    /**
     * 活动配置相关dao层操作
	 */
	
	@Override
	public int mergeActivityConfig(OperateActivityConfigVO vo){
		if(Objects.equals(vo.getType(), ActivityTypeEnum.FIRST_RECHARGE.getValue())){
			if(!ObjectUtil.isBlank(vo.getRuleIds())){
				operateCouponTempDaoMapper.deleteBatch(vo.getRuleIds());
			}
			OperateActivityConfigPO po = new OperateActivityConfigPO(vo,new OperateCouponTempVO());
			int num1 = operateActivityConfigDaoMapper.merge(po);
			int num2 = operateCouponTempDaoMapper.mergeBatch(po);
            return num1 + num2;
		}else if (Objects.equals(vo.getType(), ActivityTypeEnum.PRIZE_AWARD.getValue())) {
			OperateActivityConfigPO po = new OperateActivityConfigPO(vo,new OperateActivityRuleVO());
			int num1 = operateActivityConfigDaoMapper.merge(po);
			int num2 = operateActivityAwardDaoMapper.updateOrderIds(vo.getOperateActivityRuleVOList());
			return num1 + num2;
		}  else if (Objects.equals(vo.getType(), ActivityTypeEnum.ADD_CODE.getValue())){
			OperateActivityConfigPO po = new OperateActivityConfigPO(vo,new OperateActivityRuleVO());
			int num1 = operateActivityConfigDaoMapper.merge(po);
			int num2 = operateActivityAddedDaoMapper.updateLotterChildCode(vo.getOperateActivityRuleVOList());
			return num1 + num2;
		}
		else if (Objects.equals(vo.getType(), ActivityTypeEnum.SPECIAL.getValue())) {
			if(!ObjectUtil.isBlank(vo.getRuleIds())){
				operateActivitySportRuleDaoMapper.deleteBatch(vo.getRuleIds());
			}
			OperateActivityConfigPO po = new OperateActivityConfigPO(vo,new OperateActivitySportRuleVO());
			int num1 = operateActivityConfigDaoMapper.merge(po);
			int num2 = operateActivitySportRuleDaoMapper.mergeBatch(po);
			return num1 + num2;
		} else if (Objects.equals(vo.getType(), ActivityTypeEnum.ADD_SINGLE.getValue())) {
			if(!ObjectUtil.isBlank(vo.getRuleIds())){
				operateActivitySportRuleDaoMapper.deleteBatch(vo.getRuleIds());
			}
			OperateActivityConfigPO po = new OperateActivityConfigPO(vo,new OperateActivitySportRuleVO());
			po.setLotteryCode((short)LotteryEnum.Lottery.FB.getName());
			int num1 = operateActivityConfigDaoMapper.merge(po);
			int num2 = operateActivitySportRuleDaoMapper.mergeBatch(po);
			return num1 + num2;
		}else if (Objects.equals(vo.getType(), ActivityTypeEnum.ANNUAL_MEET.getValue())) {
			OperateActivityConfigPO po = new OperateActivityConfigPO(vo);			
			OperateCouponTempPO couponPO = new OperateCouponTempPO(vo.getOperateActivityAddedVO());
			OperateActivityAddedPO addedPo = new OperateActivityAddedPO(vo.getOperateActivityAddedVO());
			int num1 = operateActivityConfigDaoMapper.merge(po);			
			if(vo.getOperateActivityAddedVO().getActivityConfigId()==null){
				couponPO.setConfigId(po.getId());
				addedPo.setActivityConfigId(po.getId());
			}
			int num2 = operateCouponTempDaoMapper.mergeCoupon(couponPO);
			if(vo.getOperateActivityAddedVO().getOperateActivityCouponId()==null)
				addedPo.setOperateActivityCouponId(couponPO.getId());
			int num3 = operateActivityAddedDaoMapper.merge(addedPo);			
			return num1 + num2+num3;
		} else if(Objects.equals(vo.getType(), ActivityTypeEnum.NEW_USER.getValue())) {
			if(!ObjectUtil.isBlank(vo.getRuleIds())){
				operateCouponTempDaoMapper.deleteBatch(vo.getRuleIds());
			}
			if(!ObjectUtil.isBlank(vo.getLottoRuleIds())) {
				operateActivityLottoDaoMapper.deleteBatch(vo.getLottoRuleIds());
			}
			// TODO 新用户活动
			OperateActivityConfigPO po = new OperateActivityConfigPO(vo, new OperateCouponTempVO(),new OperateActivityLottoVO());
			int num1 = operateActivityConfigDaoMapper.merge(po);
			int num2 = 0;
			if(!ObjectUtil.isBlank(po.getOperateActivityRulePOList())) {
				num2 = operateCouponTempDaoMapper.mergeBatch(po);
			}
			int num3 = 0;
			if(!ObjectUtil.isBlank(po.getOperateActivityLottoRulePOList())) {
				num3 = operateActivityLottoDaoMapper.mergeBatch(po);
			}
			return num1 + num2 + num3;
		} else if (Objects.equals(vo.getType(), ActivityTypeEnum.REDEEM_CODE.getValue())) {
			if(!ObjectUtil.isBlank(vo.getRuleIds())){
				operateCouponTempDaoMapper.deleteBatch(vo.getRuleIds());
			}
			OperateActivityConfigPO po = new OperateActivityConfigPO(vo,new OperateCouponTempVO());
			int num1 = operateActivityConfigDaoMapper.merge(po);
			int num2 = operateCouponTempDaoMapper.mergeBatch(po);
			processCdkey(vo);
			return num1 + num2;
		} else if (Objects.equals(vo.getType(), ActivityTypeEnum.RECHARGE.getValue())) {
			OperateActivityConfigPO po = new OperateActivityConfigPO(vo,new OperateCouponTempVO());
			int num1 = operateActivityConfigDaoMapper.merge(po);
			return num1;
		} else if (Objects.equals(vo.getType(), ActivityTypeEnum.CHP_GUEST.getValue())) {
			OperateActivityConfigPO po = new OperateActivityConfigPO(vo,new OperateActivityChpGuessVO());
			int num1 = operateActivityConfigDaoMapper.merge(po);
			int num2 = 0;
			if(!org.springframework.util.CollectionUtils.isEmpty(po.getOperateActivityRulePOList())) {
				List<OperateActivityChpGuessBO> configes = (List<OperateActivityChpGuessBO>)po.getOperateActivityRulePOList();
				configes.stream().forEach(p -> {
					p.setActivityConfigId(po.getId());
					p.setCreateBy(vo.getCreateBy());
					p.setModifyBy(vo.getModifyBy());
				});
				num2 = operateActivityChpGuessDaoMapper.merge(po);
			}
			return num1 + num2;
		} else {
			if(!ObjectUtil.isBlank(vo.getRuleIds())){
				operateActivityRuleDaoMapper.deleteBatch(vo.getRuleIds());
			}
			OperateActivityConfigPO po = new OperateActivityConfigPO(vo,new OperateActivityRuleVO());
			if(po.getIcon()!=null){
				po.setIcon(po.getIcon().replace(beforeFileUrl, ""));
			}
			int num1 = operateActivityConfigDaoMapper.merge(po);
			int num2 = operateActivityRuleDaoMapper.mergeBatch(po);
			return num1 + num2;
		}
	}

	@Override
	public int mergeSportRule(OperateActivitySportRuleVO vo) {
		OperateActivitySportRulePO po = new OperateActivitySportRulePO(vo);
		Integer configId = vo.getActivityConfigId();
		if(configId==null){
			OperateActivityConfigPO cofigPO = new OperateActivityConfigPO();
			cofigPO.setActivityCode(vo.getActivityCode());
			cofigPO.setCreateBy(vo.getCreateBy());
			cofigPO.setModifyBy(vo.getModifyBy());
			operateActivityConfigDaoMapper.merge(cofigPO);
			configId = cofigPO.getId();
			vo.setActivityConfigId(configId);
			po.setActivityConfigId(configId);
		}
		if (ObjectUtil.isBlank(vo.getId())) {
			operateActivitySportRuleDaoMapper.insertSportRule(po);
		} else {
			operateActivitySportRuleDaoMapper.updateSportRule(po);
		}
		return po.getId();
	}


	@Override
	public OperateActivityConfigBO findActivityConfigDetail(OperateActivityConfigVO vo) {
		OperateActivityConfigBO retBO = null;
		ActivityTypeEnum activityTypeEnum = ActivityTypeEnum.getCons(vo.getType());
		if(ObjectUtil.isBlank(activityTypeEnum))
			return retBO;
		switch (activityTypeEnum) {
		case FIRST_RECHARGE:
		case REDEEM_CODE:
			retBO = operateActivityConfigDaoMapper.findActivityCoupon(vo);
			break;
		case ADD_SINGLE:
		case SPECIAL:
			retBO = operateActivitySportRuleDaoMapper.findSportRule(vo);
			break;
		case ADD_CODE:
		case ANNUAL_MEET:
			retBO = operateActivityConfigDaoMapper.findActivityAddCode(vo);
			break;
		case PRIZE_AWARD:
			retBO = operateActivityConfigDaoMapper.findActivityAward(vo);
			List<OperateActivityAwardBO> list = (List<OperateActivityAwardBO>) retBO.getOperateActivityRuleBOList();
			for (OperateActivityAwardBO bo : list) {
				if (!ObjectUtil.isBlank(bo.getAwardImg())) {
					bo.setAwardImg(beforeFileUrl + bo.getAwardImg());
				}
			}
			break;
		case NEW_USER:
			retBO = operateActivityConfigDaoMapper.findActivityCoupon(vo);
			if(retBO != null && retBO.getId() != null) {
				OperateActivityLottoVO lottoVO = new OperateActivityLottoVO();
				lottoVO.setActivityConfigId( retBO.getId());
				retBO.setOperateActivityLottoRuleBOList(operateActivityLottoDaoMapper.findList(lottoVO));
			}
			break;
		case CHP_GUEST:
			retBO = operateActivityConfigDaoMapper.findActivityChp(vo);
			break;
		default:
			retBO = operateActivityConfigDaoMapper.findDetail(vo);
			break;
		}
        if(retBO!=null&&!ObjectUtil.isBlank(retBO.getIcon()))
        	retBO.setIcon(beforeFileUrl+retBO.getIcon());		
		return retBO;
	}

	@Override
	public int addActivityRule(OperateActivityRuleVO vo) {
		OperateActivityRulePO po = new OperateActivityRulePO(vo);
		return operateActivityRuleDaoMapper.insert(po);
	}
	
	@Override
	public int updActivityRule(OperateActivityRuleVO vo) {
		return operateActivityRuleDaoMapper.updateById(vo);
	}
	
	@Override
	public int updateAddCodeIssue(OperateActivityAddedVO vo){
		return operateActivityAddedDaoMapper.updateAddCodeIssue(vo);
	}
	
	@Override
	public int delActivityRule(Integer id) {
		return operateActivityRuleDaoMapper.deleteById(id);
	}

	@Override
	public PagingBO<OperateActivityRuleBO> findActivityRuleList(final OperateActivityRuleVO vo) {
		return pageService.getPageData(vo, new ISimplePage<OperateActivityRuleBO>() {

			@Override
			public int getTotal() {
				return operateActivityRuleDaoMapper.findTotal(vo);
			}

			@Override
			public List<OperateActivityRuleBO> getData() {
				return operateActivityRuleDaoMapper.findList(vo);
			}
		});
	}

	@Override
	public OperateActivityRuleBO findActivityRuleDetail(Integer id) {
		return operateActivityRuleDaoMapper.findDetailById(id);
	}

	@Override
	public PagingBO<OperateCouponBO> findCoupon(final OperateCouponVO vo) {
		return pageService.getPageData(vo,new ISimplePage<OperateCouponBO>() {
			@Override
			public int getTotal() {
				return couponDaoMapper.findTotal(vo);
			}
			@Override
			public List<OperateCouponBO> getData() {
				return couponDaoMapper.findList(vo);
			}
		});
	}

	@Override
	public OperateCouponBO findCouponDetail(StringVO vo) {
		return couponDaoMapper.findCouponDetail(vo.getStr());
	}


	@Override
	public List<OperateCouponExcelBO> finCouponExcel(OperateCouponVO vo) {
		int num = couponDaoMapper.findTotal(vo);
		Assert.isTrue(num <= Constants.EXCEL_NUM,Constants.EXCEL_ERROR_MSG);
		return couponDaoMapper.findExcelCoupon(vo);
	}

	@Override
	public int updOperateCoupon(OperateCouponVO vo) {
		OperateCouponPO po = new OperateCouponPO();
		po.setRedStatus(vo.getRedStatus());
		po.setId(vo.getId());
		return couponDaoMapper.updCouponStatus(po);
	}
	
	/************************** 广告图管理相关  start*****************************/
	@Override
	public PagingBO<OperateAdBO> findOperateAd(final OperateAdVO vo) {
		return pageService.getPageData(vo,new ISimplePage<OperateAdBO>() {
			@Override
			public int getTotal() {
				return adDaoMapper.findTotal(vo);
			}
			@Override
			public List<OperateAdBO> getData() {
				return adDaoMapper.list(vo);
			}
		});
	}
	
	/*
	@Override
	public int mergeOperateAd(OperateAdVO vo) {
		vo.setAdvCode("advCode_test");
		//vo.setPositionCode("positionCode_test");
		OperateAdPO po =new OperateAdPO(vo);
		return adDaoMapper.merge(po);
	} */
	
	/**
	 * 广告图位置编号需求已删除
	 * 发布编号由发布的人员自己输入，代码只做排重的校验
	 * 页面的"全部用户"和"全部渠道"下拉框选项，是按约定以"0"为值代码添加的，不是查表
	 * 2017-4-25 程序不做"默认"广告的唯一性检查，查询时，若有多个默认，则根据需要取一个或多个(滚播图)
	 */
	@Override
	public int addOperateAd(OperateAdVO vo) {
		Assert.isNull(vo.getId(),"添加广告前，已存在主键");
		//Assert.isTrue(vo.getOnlineTime().after(new Date()), "上线时间必须大于当前时间");
		//vo.setAdvCode(nextAdvCode());
		validateOperateAdVO(vo);
		OperateAdPO po =new OperateAdPO(vo);
		int affected1 = adDaoMapper.addAdv(po);
		// 设置主键id
		vo.setId(po.getId());
		// 若通过参数验证，则"全部用户"和"全部渠道"都不为空
		List<OperateAdTypePO> adTypes = vo.getUserTypes().contains(OperateEnum.AD_ALL_USERS) ? 
				 OperateAdTypePO.buildChannelTypes(vo) : OperateAdTypePO.buildUserTypes(vo);
		adTypeDaoMapper.batchAdd(adTypes);
		return affected1;
	}
	
	@Override
	public int udpateOperateAd(OperateAdVO vo) {
		Assert.notNull(vo.getId(),"更新广告时，广告主键为空");
		validateOperateAdVO(vo);
		OperateAdPO po =new OperateAdPO(vo);
		int affected1 = adDaoMapper.udpateAdv(po);
		// 若广告对象和广告渠道选项没有变化，则不用更新中间表
		if(!vo.isAdObjectChange())
			return affected1;
		// 先删除再添加
		// OPERATE_ADV表的id即为OPERATE_ADV_TYPE表的ADV_ID
		OperateAdTypeVO criteria = new OperateAdTypeVO(vo.getId());
		adTypeDaoMapper.delete(criteria);
		// 若通过参数验证，则"全部用户"和"全部渠道"都不为空
		List<OperateAdTypePO> adTypes = vo.getUserTypes().contains(OperateEnum.AD_ALL_USERS) ? 
				 OperateAdTypePO.buildChannelTypes(vo) : OperateAdTypePO.buildUserTypes(vo);
		adTypeDaoMapper.batchAdd(adTypes);
		return affected1;
	}
	
	private void validateOperateAdVO(OperateAdVO vo) {
		Assert.notNull(vo,"广告对象为空");
		Assert.isTrue(vo.getOfflineTime().after(vo.getOnlineTime()), "下线时间必须在上线时间之后");
		// 若是新增广告，则检查唯一性
		if(vo.getId() == null) {
			OperateAdVO criteria = new OperateAdVO();
			criteria.setAdvCode(vo.getAdvCode());
			criteria.setExcludedId(vo.getId());
			Assert.isTrue(adDaoMapper.findTotal(criteria)==0, "发布编号已存在");
		}
		List<Long> userTypes = vo.getUserTypes();
		List<String> channels = vo.getChannels();
		// 广告对像和广告渠道都不能为空
		Assert.isTrue( CollectionUtils.isNotEmpty(userTypes) && CollectionUtils.isNotEmpty(channels), "请选择广告对像或广告渠道");
		/*
		 * 广告对像和广告渠道只能二选一，即若"广告对像"下拉框选中除了"全部用户"的选项，则"全部渠道"下拉框只能选中"全部渠道"
		 * 若选中"全部用户"的选项，则"全部渠道"下拉框自由能选择选项，反之亦然，可同时选中"全部"选项。据此
		 * 1.判断"广告对像"和"全部用户"至有少一个选中"全部"选项
		 * 2.若选中全部选项，则不能再包含其他选项
		 */
		Assert.isTrue( userTypes.contains(OperateEnum.AD_ALL_USERS) || channels.contains(OperateEnum.AD_ALL_CHANNELS), "广告对像和广告渠道只能选择一项");
		if(userTypes.contains(OperateEnum.AD_ALL_USERS))
			Assert.isTrue(userTypes.size()==1,"选择'全部'选项后不能再选择其他选项");
		// 2018-02-06，运营要求，页面全选时，把所有渠道配置的渠道及"全部渠道"选项都选中
		//if(channels.contains(OperateEnum.AD_ALL_CHANNELS))
		//	Assert.isTrue(channels.size()==1,"选择'全部'选项后不能再选择其他选项");
	}
	
	@Override
	public List<OperateAdTypeBO> listAdType(OperateAdTypeVO vo) {
		return adTypeDaoMapper.list(vo);
	}
	
	/**
	 * @desc   广告图页面列表
	 * @author Tony Wang
	 * @create 2017年5月10日
	 * @param vo
	 * @return 
	 */
	@Override
	public PagingBO<OperateAdMenuBO> listAdMenu(final OperateAdMenuVO vo) {
		// 查询OPERATE_ADV_MENU的所有记录，vo除了分页，其他参数暂时没有
		return pageService.getPageData(vo,new ISimplePage<OperateAdMenuBO>() {
			@Override
			public int getTotal() {
				return adMenuDaoMapper.count(vo);
			}
			@Override
			public List<OperateAdMenuBO> getData() {
				return adMenuDaoMapper.list(vo);
			}
		});
	}

	/**
	 * @desc   增加或更新广告图页面
	 * @author Tony Wang
	 * @create 2017年5月10日
	 * @param vo
	 * @return 
	 */
	@Override
	public int mergeAdMenu(OperateAdMenuVO vo) {
		// 同一个广告页面不能重复添加广告位置管理
		if(vo.getId() == null) {
			OperateAdMenuVO criteria = new OperateAdMenuVO();
			criteria.setMenu(vo.getMenu());
			Assert.isTrue(adMenuDaoMapper.count(criteria)==0, "同一个广告页面不能重复添加广告位置管理");
		}
		return adMenuDaoMapper.merge(new OperateAdMenuPO(vo));
	}
	
	/**
	 * @desc   删除广告页面
	 * @author Tony Wang
	 * @create 2017年5月10日
	 * @param vo
	 * @return 
	 */
	@Override
	public int deleteAdMenu(OperateAdMenuVO vo) {
		Assert.isTrue(CollectionUtils.isNotEmpty(vo.getIds()), "没有要删除的记录");
		return adMenuDaoMapper.delete(vo);
	}
	
	/**
	 * @desc   查询广告页面
	 * @author Tony Wang
	 * @create 2017年5月11日
	 * @param vo
	 * @return 
	 */
	@Override
	public List<OperateAdMenuBO> findAdMenus(OperateAdMenuVO vo) {
		return adMenuDaoMapper.list(vo);
	}
	
	@Override
	public String findMaxAdvCode(String today) {
		return adDaoMapper.findMaxAdvCode(today);
	}
//	@Override
//	public List<DictionaryBO> findMenuAsDic(OperateAdMenuVO vo) {
//		DicDataDetailVO dic = new DicDataDetailVO();
//		dic.setDicCode(DicDataEnum.OPERATE_AD_PAGE.getDicCode());
//		menu.getPosition().split(",");
//		StringVO strVO = new StringVO(DicDataEnum.OPERATE_AD_PAGE.getDicCode())
//				List<DicDataDetailBO> menus = dictionaryService.findDetail(strVO);
//		OperateAdMenuBO menu = adService.listMenu(vo).getData().get(0);
//		return DicUtils.toDic(menus, "dicDataValue", String.class, "dicDataName", String.class);
//	}
	/************************** 广告图管理相关  end*****************************/
	
	/************************** 彩种运营管理相关  start*****************************/
	@Override
	public PagingBO<OperateLotteryBO> findOperateLottery(final OperateLotteryVO vo) {
		return pageService.getPageData(vo,new ISimplePage<OperateLotteryBO>() {
			@Override
			public int getTotal() {
				return operateLotteryDaoMapper.findTotal(vo);
			}
			@Override
			public List<OperateLotteryBO> getData() {
				return operateLotteryDaoMapper.list(vo);
			}
		});
	}
	
	@Override
	public List<OperateLotteryInfoBO> findOperateLotteryInfo(OperateLotteryInfoVO vo) {
		return operateLotteryInfoDaoMapper.list(vo);
	}

//	@Override
//	public int mergeOperateLottery(OperateLotteryVO vo) {
//		vo.setReleaseCode("ReleaseCode_test");
//		OperateLotteryPO po =new OperateLotteryPO(vo);
//		int lotteryId = operateLotteryDaoMapper.mergeOperateLottery(po);
//		po.setId((long)lotteryId);
//		int affected = 1;//operateLotteryDaoMapper.mergeOperateLotteryInfo(po);
//		return affected;
//	}
	

	@Override
	public int addOperateLottery(OperateLotteryVO vo) {
		Assert.isNull(vo.getId(), "已存在此方案");
		int tonum = operateLotteryDaoMapper.findTimeRepeatTotal(vo);
		Assert.isTrue(tonum<=0, "数据产生了时间冲突，请检查");
		/*
		 * PC H5 Andorid iOS各端最多只能存在一个发布中的运营方案
		 * 若有数据库中已有发布中的广告，且当前增加的记录不是此记录，则前端不能再添加发布中的运营方案
		 */
		/*byte releasing =  OperateEnum.ReleaseStatus.RELEASING.getValue();
		if(Objects.equals(vo.getStatus(), releasing)) {
			OperateLotteryVO condition = new OperateLotteryVO.Builder()
					.idNotEqual(vo.getId())
					.status(releasing)
					.platform(vo.getPlatform())
					.build();
			int count = operateLotteryDaoMapper.findTotal(condition);
			Assert.isTrue(count==0, "已存在发布中的运营方案");
		}*/
		// 如果运营详情的显示方式:2设定时间下线，则下线时间不为空
		List<OperateLotteryInfoVO> lotteryInfos = vo.getLotteryInfos();
		if(CollectionUtils.isNotEmpty(lotteryInfos)) {
			for(OperateLotteryInfoVO info : lotteryInfos) {
				if(Objects.equals(info.getDisplay(), OperateEnum.LotteryDisplay.OFFLINE.getValue())) {
					Assert.notNull(info.getOfflineTime(), "运营详情的下线时间不能为空");
					Assert.isTrue((new Date()).before(info.getOfflineTime()), "运营详情的下线时间必需大于当前时间");
				}
			}
		}
		/*
		 * 编号为年月日加序号 如：2017050400001，在所有端中保证唯一性
		 */
		//vo.setReleaseCode(nexLotteryReleaseCode());
		OperateLotteryPO po =new OperateLotteryPO(vo);
		int affected1 = operateLotteryDaoMapper.addOperateLottery(po);
		// 调用完addOperateLottery(po)后，mybatis会往po设置id,此id也为LotteryInfoPO的lotteryId
		int affected2 = operateLotteryDaoMapper.mergeOperateLotteryInfo(po);
		return affected1 + affected2;
	}

	@Override
	public int updateOperateLottery(OperateLotteryVO vo) {
		/*
		 * PC H5 Andorid iOS各端最多只能存在一个发布中的运营方案
		 * 若有数据库中已有发布中的广告，且当前更新的记录不是此记录，则前端不能再添加发布中的运营方案
		 */
		/*
		byte releasing =  OperateEnum.ReleaseStatus.RELEASING.getValue();
		if(Objects.equals(vo.getStatus(), releasing)) {
			OperateLotteryVO condition = new OperateLotteryVO.Builder()
					.idNotEqual(vo.getId())
					.status(releasing)
					.platform(vo.getPlatform())
					.build();
			int count = operateLotteryDaoMapper.findTotal(condition);
			Assert.isTrue(count==0, "已经存在发布中的运营方案");
		}*/
		// 如果运营详情的显示方式:2设定时间下线，则下线时间不为空
		int tonum = operateLotteryDaoMapper.findTimeRepeatTotal(vo);
		Assert.isTrue(tonum<=0, "数据产生了时间冲突，请检查");
		List<OperateLotteryInfoVO> lotteryInfos = vo.getLotteryInfos();
		if(CollectionUtils.isNotEmpty(lotteryInfos)) {
			for(OperateLotteryInfoVO info : lotteryInfos) {
				if(Objects.equals(info.getDisplay(), OperateEnum.LotteryDisplay.OFFLINE.getValue())) {
					Assert.notNull(info.getOfflineTime(), "运营详情的下线时间不能为空");
				}
			}
		}
		// ReleaseCode生成后不再更新
		// vo.setReleaseCode("ReleaseCode_upd_test");
		// 如果有详情要删除
		if(CollectionUtils.isNotEmpty(vo.getInfoIds())) {
			operateLotteryInfoDaoMapper.delete(new OperateLotteryInfoVO.Builder().ids(vo.getInfoIds()).build());
		}
		OperateLotteryPO po =new OperateLotteryPO(vo);
		// 如果详情有改变才更新
		int affected1 = operateLotteryDaoMapper.updateOperateLottery(po);
		if(CollectionUtils.isNotEmpty(po.getLotteryInfos())) {
			operateLotteryDaoMapper.mergeOperateLotteryInfo(po);
		}
		return affected1;
	}
	
	@Override
	public int countOperateLottery(OperateLotteryVO vo) {
		return operateLotteryDaoMapper.findTotal(vo);
	}
	
	@Override
	public String findMaxOperateLotteryReleaseCode(String today) {
		return operateLotteryDaoMapper.findMaxReleaseCode(today);
	}
	/************************** 彩种运营管理相关  end*****************************/
	
	/**************************会员访问信息分析相关*****************************/
	@Override
	public PagingBO<OperateUserAnalysisBO> findPagingUserAnalysis(final OperateUserAnalysisVO operateUserAnalysis) {
		conditionConvert(operateUserAnalysis);// 部分条件转换
		return pageService.getPageData(operateUserAnalysis, new ISimplePage<OperateUserAnalysisBO>() {
			@Override
			public int getTotal() {
				return userAnalysisDaoMapper.findCount(operateUserAnalysis);
			}

			@Override
			public List<OperateUserAnalysisBO> getData() {
				return userAnalysisDaoMapper.findPaging(operateUserAnalysis);
			}
		});
	}

	@Override
	public List<OperateUserAnalysisBO> findExcelUserAnalysis(OperateUserAnalysisVO operateUserAnalysis) {
		conditionConvert(operateUserAnalysis);// 部分条件转换
		int num = userAnalysisDaoMapper.findCount(operateUserAnalysis);
		Assert.isTrue(num <= Constants.EXCEL_NUM, Constants.EXCEL_ERROR_MSG);
		return userAnalysisDaoMapper.findExcel(operateUserAnalysis);
	}

	/**
	 * @desc 部分条件转换（如：各种用户查询类型，各种时间查询类型）
	 * @author huangb
	 * @date 2017年2月10日
	 * @param operateUserAnalysis
	 *            参数对象
	 */
	private void conditionConvert(OperateUserAnalysisVO operateUserAnalysis) {
		// 如果指定了是否关联用户表，则不用继续后面的判断
		if (operateUserAnalysis.getJoinUser() != null) {
			return;
		}
		// 是否关联用户表
		if (operateUserAnalysis.getUser() == null) {
			operateUserAnalysis.setJoinUser(false);
			return;
		}
		if (StringUtils.isNotEmpty(operateUserAnalysis.getUser().getNickName())
				|| StringUtils.isNotEmpty(operateUserAnalysis.getUser().getAccountName())
				|| operateUserAnalysis.getUser().getCusMobile() != null
				|| StringUtils.isNotEmpty(operateUserAnalysis.getUser().getActualName())
				|| StringUtils.isNotEmpty(operateUserAnalysis.getUser().getIdNum())
				|| StringUtils.isNotEmpty(operateUserAnalysis.getUser().getCusMail())
				|| operateUserAnalysis.getUser().getId() != null) {
			operateUserAnalysis.setJoinUser(true);
		}
	}
	/**************************会员访问信息分析相关*****************************/

	/************************** 快投模块管理相关  start*****************************/
	@Override
	public PagingBO<OperateFastBO> findOperateFast(final OperateFastVO vo) {
		return pageService.getPageData(vo,new ISimplePage<OperateFastBO>() {
			@Override
			public int getTotal() {
				return operateFastDaoMapper.findTotal(vo);
			}
			@Override
			public List<OperateFastBO> getData() {
				return operateFastDaoMapper.list(vo);
			}
		});
	}
	
	@Override
	public PagingBO<OperateFastInfoBO> findOperateFastInfo(final OperateFastInfoVO vo) {
		return pageService.getPageData(vo,new ISimplePage<OperateFastInfoBO>() {
			@Override
			public int getTotal() {
				return operateFastInfoDaoMapper.findTotal(vo);
			}
			@Override
			public List<OperateFastInfoBO> getData() {
				return operateFastInfoDaoMapper.list(vo);
			}
		});
	}
	

	@Override
	public int addOperateFast(OperateFastVO vo) {
		int tonum = operateFastDaoMapper.findTimeRepeatTotal(vo);
		Assert.isTrue(tonum<=0, "增加的数据产生了时间冲突，请检查");
		vo.setFastCode("FastCode_test");
		OperateFastPO po =new OperateFastPO(vo);
		System.out.println(JSONObject.toJSONString(po));		
		int affected1 = operateFastDaoMapper.addOperateFast(po);
		// 调用完addOperateLottery(po)后，mybatis会往po设置id,此id也为LotteryInfoPO的lotteryId
		int affected2 = operateFastDaoMapper.mergeOperateFastInfo(po);
		return affected1 + affected2;
	}

	@Override
	public int updateOperateFast(OperateFastVO vo) {
		// ReleaseCode生成后不再更新
		// vo.setReleaseCode("ReleaseCode_upd_test");
		// 如果有详情要删除
		int tonum = operateFastDaoMapper.findTimeRepeatTotal(vo);
		Assert.isTrue(tonum<=0, "数据产生了时间冲突，请检查");
		if(CollectionUtils.isNotEmpty(vo.getInfoIds())) {
			operateFastInfoDaoMapper.delete(new OperateFastInfoVO.Builder().ids(vo.getInfoIds()).build());
		}
		OperateFastPO po =new OperateFastPO(vo);
		int affected1 = operateFastDaoMapper.updateOperateFast(po);
		// 如果详情有改变才更新
		if(CollectionUtils.isNotEmpty(po.getFastInfos())) {
			operateFastDaoMapper.mergeOperateFastInfo(po);
		}
		return affected1;
	}
	
	@Override
	public int countOperateFast(OperateFastVO vo) {
		return operateFastDaoMapper.findTotal(vo);
	}
	/************************** 快投模块管理  end*****************************/

	/************************** 文章管理相关  start***************************/
	/**
	 * @desc   新增或更新文章栏目
	 * @author Tony Wang
	 * @create 2017年3月2日
	 * @param vo
	 * @return  
	 */
	@Override
	public int mergeArticleType(OperateArticleTypeVO vo) {
		// 栏目标识符不能包含中文，因为要作为保存文章的路径
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Assert.isTrue(!p.matcher(vo.getIdentifiers()).find(), "栏目标识符不能包含中文");
		// 保证栏目标识符唯一性
		OperateArticleTypeVO criteria = new OperateArticleTypeVO();
		criteria.setIdentifiers(vo.getIdentifiers());
		criteria.setExcludedId(vo.getId());
		int count = operateArticleTypeDaoMapper.count(criteria);
		Assert.isTrue(count == 0,"栏目标识符不能重复");
		int affected;
		// 如果是新增,则设置typeCode,且插入操作要同步
		if(vo.getId() == null) {
			addArticleLock.lock();
			try {
				vo.setTypeCode(nextTypeCode(vo));
				affected = operateArticleTypeDaoMapper.merge(new OperateArticleTypePO(vo));
			} catch (Exception e) {
				throw e;
			} finally {
				addArticleLock.unlock();
			}
		} else {
			affected = operateArticleTypeDaoMapper.merge(new OperateArticleTypePO(vo));
		}
		return affected;
	}
	
	/**
	 * @desc  返回下一个栏目编号
	 * 栏目编号TYPE_CODE规则如下：
	 * 1
	 * 1.1
	 * 1.1.1
	 * 
	 * 2
	 * 2.1
	 * 2.1.1
	 * 
	 * 3
	 * @author Tony Wang
	 * @create 2017年3月31日
	 * @param vo
	 * @return 
	 */
	private String nextTypeCode(OperateArticleTypeVO vo) {
		OperateArticleTypeVO criteria = new OperateArticleTypeVO();
		criteria.setTypeParent(vo.getTypeParent());
		// 查出父栏目编号,若为空则是添加一级栏目
		// 查出同一个父id的下最大的栏目编号,若为null，则此父id下还未添加任何子栏目
		String typeCode = operateArticleTypeDaoMapper.findMaxTypeCode(criteria);
		if(typeCode != null) {
			int index=typeCode.lastIndexOf(SymbolConstants.DOT);
			String last=typeCode.substring(index+1);
			// 最后一部分加1,如1.1.2-》1.1.3
			return typeCode.substring(0, index+1) + (Integer.parseInt(last) + 1);
		}
		// 若此父id下还未添加任何子栏目，则查询父栏目编号
		criteria.setTypeParent(null);
		criteria.setId(vo.getTypeParent());
		typeCode = operateArticleTypeDaoMapper.findMaxTypeCode(criteria);
		// 若父栏目编号不为空，则子栏目编号为"父栏目编号"+".1"，如1.2-》1.2.1
		if(typeCode != null) {
			return typeCode+".1";
		}
		// 若父栏目编号为空，则未添加过任何栏目，所以设置typeCode=“1”
		return "1";
	}
	/**
	 * @desc   查询文章栏目
	 * @author Tony Wang
	 * @create 2017年3月2日
	 * @return  
	 */
	@Override
	public List<OperateArticleTypeBO> listArticleType() {
		return operateArticleTypeDaoMapper.list();
	}
	
	/**
	 * @desc   查询文章栏目
	 * @author Tony Wang
	 * @create 2017年6月5日
	 * @param criteria
	 * @return 
	 */
	@Override
	public OperateArticleTypeBO findArticleType(OperateArticleTypeVO criteria) {
		return operateArticleTypeDaoMapper.find(criteria);
	}
	
	/**
	 * @desc   查询文章
	 * @author Tony Wang
	 * @create 2017年3月2日
	 * @return  
	 */
	@Override
	public PagingBO<OperateArticleBO> listArticle(final OperateArticleVO vo) {
		return pageService.getPageData(vo,new ISimplePage<OperateArticleBO>() {
			@Override
			public int getTotal() {
				return operateArticleDaoMapper.findTotal(vo);
			}
			@Override
			public List<OperateArticleBO> getData() {
				return operateArticleDaoMapper.list(vo);
			}
		});
	}
	
	/**
	 * @desc   增加文章
	 * @author Tony Wang
	 * @create 2017年3月17日
	 * @param vo
	 * @return 
	 * @throws IOException 
	 */
	/*
	 * 2017-05-17 跟产品确认，"封面图片没有显示到正文中"复选框无实际作用，去掉，封面图片只是做超链接用，不显示在正文中
	 */
	@Override
	public int addArticle(OperateArticleVO vo) throws IOException {
		// 文章保存后状态为"编辑中"
		vo.setStatus(ArticleEnum.ArticleStatus.EDITING.getStatus());
		OperateArticlePO article = new OperateArticlePO(vo);
		int affected1 = operateArticleDaoMapper.add(article);
		// 设置文章中间表信息，有在栏目置顶则isTop=1
		if(CollectionUtils.isNotEmpty(vo.getArticleTops())) {
			List<OperateArticleTopPO> articleTops = new ArrayList<>();
			for(OperateArticleTopVO top : vo.getArticleTops()) {
				top.setArticleId(article.getId());
				articleTops.add(new OperateArticleTopPO(top));
			}
			operateArticleTopDaoMapper.add(articleTops);
		}
		return affected1;
	}
	
	/**
	 * @desc   更新文章
	 * @author Tony Wang
	 * @create 2017年4月12日
	 * @param vo
	 * @return 
	 * @throws IOException 
	 */
	@Override
	public int updateArticle(OperateArticleVO vo) throws IOException {
		// 657 审核通过的文章可以修改推送栏目信息，其他信息不能修改；
		OperateArticlePO article = null;
		int affected1 = -1;
		if(Objects.equals(vo.getStatus(), ArticleEnum.ArticleStatus.APPROVE.getStatus())) {
			// 先删除旧的top中间表信息，再保存新的top中间表信息
			article = new OperateArticlePO(vo);
			operateArticleTopDaoMapper.delete(article.getId());
			// 设置文章中间表信息，有在栏目置顶则isTop=1
			if(CollectionUtils.isNotEmpty(vo.getArticleTops())) {
				List<OperateArticleTopPO> articleTops = new ArrayList<>();
				for(OperateArticleTopVO top : vo.getArticleTops()) {
					top.setArticleId(article.getId());
					articleTops.add(new OperateArticleTopPO(top));
				}
				affected1 = operateArticleTopDaoMapper.add(articleTops);
			}
		} else {
			// "被驳回"、"编辑中"的文章更新后为"编辑中"
			vo.setStatus(ArticleEnum.ArticleStatus.EDITING.getStatus());
			article = new OperateArticlePO(vo);
			affected1 = operateArticleDaoMapper.update(article);
			// 先删除旧的top中间表信息，再保存新的top中间表信息
			operateArticleTopDaoMapper.delete(article.getId());
			// 设置文章中间表信息，有在栏目置顶则isTop=1
			if(CollectionUtils.isNotEmpty(vo.getArticleTops())) {
				List<OperateArticleTopPO> articleTops = new ArrayList<>();
				for(OperateArticleTopVO top : vo.getArticleTops()) {
					top.setArticleId(article.getId());
					articleTops.add(new OperateArticleTopPO(top));
				}
				operateArticleTopDaoMapper.add(articleTops);
			}
		}
		return affected1;
	}
	
	/**
	 * @desc   查询文章的所有父栏目名称
	 * @author Tony Wang
	 * @create 2017年5月23日
	 * @param vo
	 * @return 
	 */
	@Override
	public List<String> findArticleParentPaths(OperateArticleVO vo) {
		return operateArticleTypeDaoMapper.findParents(vo);
	}
	
	/**
	 * @desc   查询单篇文章
	 * @author Tony Wang
	 * @create 2017年3月21日
	 * @param vo
	 * @return 
	 */
	@Override
	public OperateArticleBO findSingleArticle(OperateArticleVO vo) {
		return operateArticleDaoMapper.findSingle(vo);
	}
	
	/**
	 * @desc   修改文章状态
	 * @author Tony Wang
	 * @create 2017年4月14日
	 * @param vo
	 * @return 
	 */
	@Override
	public int updateArticleStatus(OperateArticleVO vo) {
		ArticleStatusVisitor articleStatusVisitor = new ArticleStatusVisitor();
		boolean can = VisitorHandler.disboseOrderStatus(vo.getStatus(), vo, vo.getNewStatus(),  articleStatusVisitor);
		// 把新状态值替换旧状态值
		if(can) {
			vo.setStatus(vo.getNewStatus());
			// 如果是"审核通过"操作，则设置vo的"审核人员"字段
			if(Objects.equals(vo.getNewStatus(), ArticleEnum.ArticleStatus.APPROVE.getStatus())) {
				vo.setAuditBy(vo.getOperator());
				// 如果预计发布时间早于当前时间，则把文章状态修改为"已发布"(数据库不保存"已发布",由程序根据发布时间判断)
				//if(vo.getReleaseTime().before(new Date())) 
				//	vo.setStatus(ArticleEnum.ArticleStatus.RELEASE.getStatus());
			}
		}
		return can ? operateArticleDaoMapper.updateStatus(new OperateArticlePO(vo)) : 0;
	}

	/**
	 * @desc   更新文章栏目顺序
	 * @author Tony Wang
	 * @create 2017年4月17日
	 * @param vos
	 * @return 
	 */
	@Override
	public int updateArticleTypeOrder(List<OperateArticleTypeVO> vos) {
		List<OperateArticleTypePO> pos = new ArrayList<>();
		// 以list的下标为order
		for(int i = 0; i < vos.size(); i++) {
			OperateArticleTypePO po = new OperateArticleTypePO(vos.get(i).getId(), i);
			pos.add(po);
		}
		// 返回1
		int ret = operateArticleTypeDaoMapper.updateOrder(pos);
		return ret;
	}
	
	/**
	 * @desc   查询最大的文章编号
	 * @author Tony Wang
	 * @create 2017年5月24日
	 * @param articleIdLike，作like 'xxx%'条件查询
	 * @return 
	 */
	@Override
	public String findMaxArticleId(String articleIdLike) {
		Assert.isTrue(StringUtils.isNotBlank(articleIdLike), "查询最大的文章编号时参数不能为空");
		return operateArticleDaoMapper.findMaxArticleId(articleIdLike);
	}
	
	@Override
	public List<OperateArticleBO> findArticle(OperateArticleVO vo) {
		return operateArticleDaoMapper.list(vo);
	}
	/************************** 文章管理相关  end*****************************/
	
	/************************** 帮助中心管理相关 	start*****************************/
	@Override
	public List<OperateHelpTypeBO> listHelpType() {
		return operateHelpTypeDaoMapper.list();
	}

	@Override
	public PagingBO<OperateHelpBO> listHelp(final OperateHelpVO vo) {
		return pageService.getPageData(vo,new ISimplePage<OperateHelpBO>() {
			@Override
			public int getTotal() {
				return operateHelpDaoMapper.findTotal(vo);
			}
			@Override
			public List<OperateHelpBO> getData() {
				return operateHelpDaoMapper.list(vo);
			}
		});
	}

	@Override
	public int mergeHelpType(OperateHelpTypeVO vo) {
		// 栏目标识符不能包含中文，因为要作为保存文章的路径
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Assert.isTrue(!p.matcher(vo.getIdentifiers()).find(), "栏目标识符不能包含中文");
		// 检查标识符唯一性
		OperateHelpTypeVO criteria = new OperateHelpTypeVO();
		criteria.setIdentifiers(vo.getIdentifiers());
		criteria.setExcludedId(vo.getId());
		int count = operateHelpTypeDaoMapper.count(criteria);
		Assert.isTrue(count == 0,"栏目标识符不能重复");
		// 如果是新增，则设置栏目编号,且要同步
		int affected;
		if(vo.getId() == null) {
			addHelpLock.lock();
			try {
				vo.setCode(nextHelpTypeCode(vo));
				affected = operateHelpTypeDaoMapper.merge(new OperateHelpTypePO(vo));
			} catch (Exception e) {
				throw e;
			} finally {
				addHelpLock.unlock();
			}
		} else {
			affected = operateHelpTypeDaoMapper.merge(new OperateHelpTypePO(vo));
		}
		if(affected>0)
			redisUtil.delKeys(CacheConstants.C_COMM_HELP_CLEAR);
		return affected;
	}

	private String nextHelpTypeCode(OperateHelpTypeVO vo) {
		OperateHelpTypeVO criteria = new OperateHelpTypeVO();
		criteria.setParent(vo.getParent());
		// 查出父栏目编号,若为空则是添加一级栏目
		// 查出同一个父id的下最大的栏目编号,若为null，则此父id下还未添加任何子栏目
		String typeCode = operateHelpTypeDaoMapper.findMaxTypeCode(criteria);
		if(typeCode != null) {
			int index=typeCode.lastIndexOf(SymbolConstants.DOT);
			String last=typeCode.substring(index+1);
			// 最后一部分加1,如1.1.2-》1.1.3
			return typeCode.substring(0, index+1) + (Integer.parseInt(last) + 1);
		}
		// 若此父id下还未添加任何子栏目，则查询父栏目编号
		criteria.setParent(null);
		criteria.setId(vo.getParent());
		typeCode = operateHelpTypeDaoMapper.findMaxTypeCode(criteria);
		// 若父栏目编号不为空，则子栏目编号为"父栏目编号"+".1"，如1.2-》1.2.1
		if(typeCode != null) {
			return typeCode+".1";
		}
		// 若父栏目编号为空，则未添加过任何栏目，所以设置typeCode=“1”
		return "1";
	}
	
	@Override
	public int addHelp(OperateHelpVO vo) throws IOException {
		// 文章保存后为状态为"编辑中"
		vo.setStatus(OperateEnum.HelpStatus.EDITING.getStatus());
		OperateHelpPO help = new OperateHelpPO(vo);
		int affected1 = operateHelpDaoMapper.add(help);
		
		// 设置文章中间表信息，有在栏目置顶则isTop=1
		if(CollectionUtils.isNotEmpty(vo.getHelpTops())) {
			List<OperateHelpTopPO> helpTops = new ArrayList<>();
			for(OperateHelpTopVO top : vo.getHelpTops()) {
				top.setHelpId(help.getId());
				helpTops.add(new OperateHelpTopPO(top));
			}
			operateHelpTopDaoMapper.batchAdd(helpTops);
		}
		if(affected1>0)
			redisUtil.delKeys(CacheConstants.C_COMM_HELP_CLEAR);
		return affected1;
	}
	
	@Override
	public OperateHelpBO findSingleHelp(OperateHelpVO vo) {
		return operateHelpDaoMapper.findSingle(vo);
	}

	@Override
	public int updateHelp(OperateHelpVO vo) throws IOException {
//		// "被驳回"、"编辑中"的文章更新后为"编辑中"
//		vo.setStatus(OperateEnum.HelpStatus.EDITING.getStatus());
//		OperateHelpPO help = new OperateHelpPO(vo);
//		int affected1 = operateHelpDaoMapper.update(help);
//		// 先删除旧的top中间表信息，再保存新的top中间表信息
//		operateHelpTopDaoMapper.delete(help.getId());
//		// 设置文章中间表信息，有在栏目置顶则isTop=1
//		if(CollectionUtils.isNotEmpty(vo.getHelpTops())) {
//			List<OperateHelpTopPO> helpTops = new ArrayList<>();
//			for(OperateHelpTopVO top : vo.getHelpTops()) {
//				top.setHelpId(help.getId());
//				helpTops.add(new OperateHelpTopPO(top));
//			}
//			operateHelpTopDaoMapper.batchAdd(helpTops);
//		}
//		return affected1;
		// 657 审核通过的文章可以修改推送栏目信息，其他信息不能修改；
		OperateHelpPO help = null;
		int affected1 = -1;
		if(Objects.equals(vo.getStatus(), HelpStatus.APPROVE.getStatus())) {
			// 先删除旧的top中间表信息，再保存新的top中间表信息
			help = new OperateHelpPO(vo);
			operateHelpTopDaoMapper.delete(help.getId());
			// 设置文章中间表信息，有在栏目置顶则isTop=1
			if(CollectionUtils.isNotEmpty(vo.getHelpTops())) {
				List<OperateHelpTopPO> helpTops = new ArrayList<>();
				for(OperateHelpTopVO top : vo.getHelpTops()) {
					top.setHelpId(help.getId());
					helpTops.add(new OperateHelpTopPO(top));
				}
				affected1 = operateHelpTopDaoMapper.batchAdd(helpTops);
			}
		} else {
			// "被驳回"、"编辑中"的文章更新后为"编辑中"
			vo.setStatus(HelpStatus.EDITING.getStatus());
			help = new OperateHelpPO(vo);
			affected1 = operateHelpDaoMapper.update(help);
			// 先删除旧的top中间表信息，再保存新的top中间表信息
			operateHelpTopDaoMapper.delete(help.getId());
			// 设置文章中间表信息，有在栏目置顶则isTop=1
			if(CollectionUtils.isNotEmpty(vo.getHelpTops())) {
				List<OperateHelpTopPO> helpTops = new ArrayList<>();
				for(OperateHelpTopVO top : vo.getHelpTops()) {
					top.setHelpId(help.getId());
					helpTops.add(new OperateHelpTopPO(top));
				}
				operateHelpTopDaoMapper.batchAdd(helpTops);
			}
		}
		if(affected1>0)
			redisUtil.delKeys(CacheConstants.C_COMM_HELP_CLEAR);
		return affected1;
	}

	@Override
	public int updateHelpStatus(OperateHelpVO vo) {
		HelpArticleStatusVisitor helpArticleStatusVisitor = new HelpArticleStatusVisitor();
		boolean can = VisitorHandler.disboseOrderStatus(vo.getStatus(), vo, vo.getNewStatus(),  helpArticleStatusVisitor);
		// 把新状态值替换旧状态值
		if(can) {
			vo.setStatus(vo.getNewStatus());
			// 如果是"审核通过"操作，则设置vo的"审核人员"字段
			if(Objects.equals(vo.getNewStatus(), OperateEnum.HelpStatus.APPROVE.getStatus())) {
				vo.setAuditBy(vo.getOperator());
				// 如果预计发布时间早于当前时间，则把文章状态修改为"已发布"
				//if(vo.getReleaseTime().before(new Date())) 
				//	vo.setStatus(ArticleEnum.HelpStatus.RELEASE.getStatus());
			}
		}
		int affected = can ? operateHelpDaoMapper.updateStatus(new OperateHelpPO(vo)) : 0;
		if(affected>0)
			redisUtil.delKeys(CacheConstants.C_COMM_HELP_CLEAR);
		return affected;
	}
	
	@Override
	public int updateHelpTypeOrder(List<OperateHelpTypeVO> vos) {
		List<OperateHelpTypePO> pos = new ArrayList<>();
		// 以list的下标为order
		for(int i = 0; i < vos.size(); i++) {
			OperateHelpTypePO po = new OperateHelpTypePO(vos.get(i).getId(), i);
			pos.add(po);
		}
		// 返回1
		int ret = operateHelpTypeDaoMapper.updateOrder(pos);
		if(ret>0)
			redisUtil.delKeys(CacheConstants.C_COMM_HELP_CLEAR);
		return ret;
	}
	

	@Override
	public List<String> findHelpParentPaths(OperateHelpVO vo) {
		return operateHelpTypeDaoMapper.findParents(vo);
	}

	@Override
	public String findMaxHelpCode(String helpCodeLike) {
		Assert.isTrue(StringUtils.isNotBlank(helpCodeLike), "查询最大帮助文章编号参数不能为空");
		return operateHelpDaoMapper.findMaxHelpCode(helpCodeLike);
	}
	
	@Override
	public OperateHelpTypeBO findHelpType(OperateHelpTypeVO criteria) {
		return operateHelpTypeDaoMapper.find(criteria);
	}
	/************************** 帮助中心管理相关 	 end*****************************/

	public PagingBO<OperateMsgInfoBO> findMsgInfo(final OperateMsgInfoVO vo) {
		return pageService.getPageData(vo,new ISimplePage<OperateMsgInfoBO>() {
			@Override
			public int getTotal() {
				return operateMsgInfoDaoMapper.findTotal(vo);
			}
			@Override
			public List<OperateMsgInfoBO> getData() {
				return operateMsgInfoDaoMapper.findList(vo);
			}
		});
	}

	@Override
	public PagingBO<OperateMsgTemplateBO> findMsgTemplatePage(final OperateMsgTemplateVO vo) {
		return pageService.getPageData(vo,new ISimplePage<OperateMsgTemplateBO>() {
			@Override
			public int getTotal() {
				return operateMsgInfoDaoMapper.findMsgTemplateTotal(vo);
			}
			@Override
			public List<OperateMsgTemplateBO> getData() {
				return operateMsgInfoDaoMapper.findMsgTemplate(vo);
			}
		});
	}

	@Override
	public List<OperateWechatTemplateBO> findWechatTemplate(OperateWechatTemplateVO vo) {
		return operateMsgInfoDaoMapper.findWechatTemplate(vo);
	}

	@Override
	public OperateMsgInfoBO findMsgInfoById(int id) {
		return operateMsgInfoDaoMapper.findMsgInfoById(id);
	}

	@Override
	public OperateMsgTemplateBO findMsgTemplateById(int id) {
		return operateMsgInfoDaoMapper.findMsgTemplateById(id);
	}

	@Override
	public OperateWechatTemplateBO findWechatTemplateById(int id) {
		return operateMsgInfoDaoMapper.findWechatTemplateById(id);
	}

	@Override
	public int addMsgTemplate(OperateMsgTemplateVO vo) {
		OperateMsgTemplatePO po = new OperateMsgTemplatePO(vo);
		return operateMsgInfoDaoMapper.addMsgTemplate(po);
	}

	@Override
	public int addWechatTemplate(OperateWechatTemplateVO vo) {
		OperateWechatTemplatePO po = new OperateWechatTemplatePO(vo);
		return operateMsgInfoDaoMapper.addWechatTemplate(po);
	}

	@Override
	public int updateMsgStatus(List<OperateMsgInfoVO> list) {
		return operateMsgInfoDaoMapper.updateMsgStatus(list);
	}

	@Override
	public int updateMsgTemplate(OperateMsgTemplateVO vo) {
		OperateMsgTemplatePO po = new OperateMsgTemplatePO(vo);
		return operateMsgInfoDaoMapper.updateMsgTemplate(po);
	}

	@Override
	public int updateWechatTemplate(OperateWechatTemplateVO vo) {
		OperateWechatTemplatePO po = new OperateWechatTemplatePO(vo);
		return operateMsgInfoDaoMapper.updateWechatTemplate(po);
	}

	@Override
	public List<OperateMsgConfigBO> findConfigByUserId(int userId) {
		return operateMsgInfoDaoMapper.findConfigByUserId(userId);
	}

	@Override
	public int updateNewMsg(OperateMsgNewVO vo,List<String> userList) {
		OperateMsgNewPO po = new OperateMsgNewPO(vo);
		if(userList == null){
			redisUtil.reset(vo.getMsgBatch(),DateUtil.compareAndGetSeconds(DateUtil.addHour(vo.getPreSendTime(), 5), new Date()));	
		}else{
			redisUtil.addObj(vo.getMsgBatch(),userList,DateUtil.compareAndGetSeconds(DateUtil.addHour(vo.getPreSendTime(), 5), new Date()));
		}
		if(po.getStatus().intValue() == SendStatus.CANCEL_SEND.getCode().intValue()){
			OperateMsgInfoVO msgVO = new OperateMsgInfoVO();
			msgVO.setMsgBatch(po.getMsgBatch());
			msgVO.setStatus(MessageStatus.CANCEL_SEND.getCode());
			List<OperateMsgInfoVO> list = new ArrayList<OperateMsgInfoVO>();
			list.add(msgVO);
			operateMsgInfoDaoMapper.updateBatchMsgStatus(list);//更新批次消息状态为取消发送
		}
		return operateMsgInfoDaoMapper.updateNewMsg(po);
	}

	@Override
	public int addNewMsg(OperateMsgNewVO vo,List<String> userList) {
		OperateMsgNewPO po = new OperateMsgNewPO(vo);
		if(Constants.UPLOAD_USER.equals(vo.getUserType()) || userList != null){
			redisUtil.addObj(vo.getMsgBatch(),userList,DateUtil.compareAndGetSeconds(DateUtil.addHour(vo.getPreSendTime(), 5), new Date()));
		}
		return operateMsgInfoDaoMapper.addNewMsg(po);
	}

	@Override
	public OperateMsgNewBO findNewMsgById(int id) {
		return operateMsgInfoDaoMapper.findNewMsgById(id);
	}

	@Override
	public PagingBO<OperateMsgNewBO> findNewMsg(final OperateMsgNewVO vo) {
		return pageService.getPageData(vo,new ISimplePage<OperateMsgNewBO>() {
			@Override
			public int getTotal() {
				return operateMsgInfoDaoMapper.findNewMsgTotal(vo);
			}
			@Override
			public List<OperateMsgNewBO> getData() {
				return operateMsgInfoDaoMapper.findNewMsgList(vo);
			}
		});
	}

	@Override
	public PagingBO<OperateImgBO> listOperateImg(final OperateImgVO vo) {
		return pageService.getPageData(vo,new ISimplePage<OperateImgBO>() {
			@Override
			public int getTotal() {
				return operateImgDaoMapper.findTotal(vo);
			}
			@Override
			public List<OperateImgBO> getData() {
				return operateImgDaoMapper.findList(vo);
			}
		});
	}

	@Override
	public int addOperateImg(List<OperateImgVO> vos) {
		List<String> images = new ArrayList<>();
		for (OperateImgVO vo : vos) {
			images.add(vo.getName());
		}
		List<String> repeatName = operateImgDaoMapper.findImageByName(images);
		if (CollectionUtils.isNotEmpty(repeatName)) {
			throw new ServiceRuntimeException("图片已存在：" + org.springframework.util.StringUtils
					.collectionToDelimitedString(repeatName, SymbolConstants.COMMA));
		}
		operateImgDaoMapper.addOperateImg(vos);
		return 1;
	}

	@Override
	public int updOperateImg(OperateImgVO vo) {
		return operateImgDaoMapper.updOperateImg(vo);
	}

	@Override
	public List<OperateImgBO> listOperateImgInfo(List<String> id) {
		return operateImgDaoMapper.listOperateImgInfo(id);
	}

	@Override
	public int delOperateImg(List<String> id) {
		return operateImgDaoMapper.delOperateImg(id);
	}

	@Override
	public int updOperateImgMove(OperateImgVO vo) {
		String [] id = org.springframework.util.StringUtils.tokenizeToStringArray(vo.getIds(), SymbolConstants.COMMA);
		return operateImgDaoMapper.updOperateImgMove(Arrays.asList(id),vo.getGroupid(),vo.getModifyBy());
	}
	@Override
	public OperateImgBO getOperateImg(OperateImgVO vo) {
		return operateImgDaoMapper.getOperateImg(vo);
	}

	
	@Override
	public PagingBO<OperateHelpCorrectBO> findOperateCorrectList(final OperateHelpCorrectVO vo) {
		
		return pageService.getPageData(vo, new ISimplePage<OperateHelpCorrectBO>() {

			@Override
			public int getTotal() {
				return operateHelpCorrectDaoMapper.findTotal(vo);
			}

			@Override
			public List<OperateHelpCorrectBO> getData() {
				return operateHelpCorrectDaoMapper.find(vo);
			}
		});
	}

	@Override
	public int updateOperateCorrect(OperateHelpCorrectVO vo) {
		OperateHelpCorrectPO po = new OperateHelpCorrectPO();
		Date date = new Date();
		po.setId(vo.getId());
		po.setStatus(vo.getStatus());
		po.setRemark(vo.getRemark());
		po.setModifyBy(vo.getModifyBy());
		po.setModifyTime(date);
		po.setUpdateTime(date);
		return operateHelpCorrectDaoMapper.updateById(po);
	}

/*
	@Override
	public List<OperateMsgConfigBO> findUserCloseNoticConfig(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteMsgConfByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addMsgConfig(List<OperateMsgConfigVo> vo, Integer userId) {
		// TODO Auto-generated method stub
		
	}*/
	
	@Override
	public List<OperateMsgConfigBO> findUserCloseNoticConfig(Integer userId) {
		return operateMsgInfoDaoMapper.findUserCloseNoticConfig(userId);
	}

	@Override
	public int deleteMsgConfByUserId(Integer userId) {
		return operateMsgInfoDaoMapper.deleteMsgConfByUserId(userId);
	}

	@Override
	public void addMsgConfig(List<OperateMsgConfigVo> vo,Integer userId) {
		
		List<OperateMsgConfigPO> list=new ArrayList<>();
		
		for(OperateMsgConfigVo config:vo){
			OperateMsgConfigPO po=new OperateMsgConfigPO(config);
			po.setUserId(userId);
			list.add(po);
		}
		
		operateMsgInfoDaoMapper.addMsgConfig(list);
		
	}

	@Override
	public List<OperateMsgLotteryConfigBO> findLotteryConfig(Integer userId, Integer type) {
		return operateMsgInfoDaoMapper.findLotteryConfig(userId, type);
	}

	@Override
	public OperateMsgLotteryConfigBO findLotteryConfigById(Integer id) {
		return operateMsgInfoDaoMapper.findLotteryConfigById(id);
	}

	@Override
	public void updateLotteryConfig(OperateMsgLotteryConfigVO vo) {
		operateMsgInfoDaoMapper.updateLotteryConfig(vo);
	}

	@Override
	public void addLotteryConfig(OperateMsgLotteryConfigVO vo) {
		operateMsgInfoDaoMapper.addLotteryConfig(vo);
	}

	//移动端包管理操作 addby cheng.chen to 2017-05-02
	@Override
	public int addSoftwareVersion(OperateSoftwareVersionVO vo) {
		if(Objects.equals(vo.getType(), (short)1)) {
			vo.setChannelId(ChannelEnum.ChannelTypeEnum.IOS.getCode());
		} else if(Objects.equals(vo.getType(), (short)2)) {
			vo.setChannelId(ChannelEnum.ChannelTypeEnum.ANDROID.getCode());
		} else {
			throw new ServiceRuntimeException("添加包版本时即不是android也不是iOS");
		}
		// 如果是添加最新的版本,则把所有版本中，"最新"的设置为"不是最新"
		if(Objects.equals((short)1, vo.getIsnew())) {
			updateIsnew(vo.getIsnew(), vo.getType());
		}
		// 2017-11-07 只能上传官方包,故channelId都是官方id,没有"审核"字段
		// 新添加的版本默认不同步官方，不开启购彩
		List<String> lotteryFunIds = OperateSoftwareVersionEnum.Modul.getLotteryModul();
		String hideStr = StringUtils.join(lotteryFunIds.iterator(), ",");
		vo.setHide(hideStr);
		addLeafSoftwareVersion(vo);
		OperateSoftwareVersionPO po = new OperateSoftwareVersionPO(vo);
		return operateSoftwareVersionDaoMapper.insert(po);
	}

	/**
	 * @desc   添加一个官方版本时，所有第三方渠道都要增加一个对应的版本信息
	 * @author Tony Wang
	 * @create 2017年11月8日
	 * @param vo 
	 */
	private void addLeafSoftwareVersion(OperateSoftwareVersionVO vo) {
		// 如果是上传android包，则设置为本站andoid渠道id,iOS包则设置本站iOS渠道id
		// 1:ios; 2:android
		List<OperateMarketChannelBO> channelLeaves;
		if(Objects.equals(vo.getType(), (short)1)) {
			// 终端平台：1：Web；2：Wap；3：Android；4：IOS
			// 或是iOS包，则所有iOS叶子渠道都要加该版本
			// 查询出所有iOS叶子渠道
			OperateMarketChannelVO criteria = new OperateMarketChannelVO();
			criteria.setTerminalPlatform(OrderEnum.PlatformType.IOS.getValue());
			channelLeaves = marketChannelDaoMapper.findLeaf(criteria);
		} else if(Objects.equals(vo.getType(), (short)2)) {
			// 若android包，则所有android叶子渠道都要加该版本
			// 查询出所有iOS叶子渠道
			OperateMarketChannelVO criteria = new OperateMarketChannelVO();
			criteria.setTerminalPlatform(OrderEnum.PlatformType.ANDROID.getValue());
			channelLeaves = marketChannelDaoMapper.findLeaf(criteria);
		} else {
			throw new ServiceRuntimeException("添加包版本时即不是android也不是iOS");
		}
		// 新传一个包，则对应android,iOS叶子结点加上对应的版本信息
		OperateSoftwareVersionPO androidOrIosPO = new OperateSoftwareVersionPO(vo);
		OperateSoftwareVersionVO criteria = new OperateSoftwareVersionVO();
		criteria.setCode(vo.getCode());
		int iOS = ChannelTypeEnum.IOS.getCode();
		int android = ChannelTypeEnum.ANDROID.getCode();
		for(OperateMarketChannelBO channelLeaf : channelLeaves) {
			// 除了本站iOS或本站android
			int channleId = Integer.parseInt(channelLeaf.getChannelId());
			if(channleId != iOS && channleId != android) {
				criteria.setChannelId(channleId);
				Assert.isTrue(operateSoftwareVersionDaoMapper.findTotal(criteria)<1, "同一渠道存在该版本号，渠道："+channleId+"，版本号："+vo.getCode());
				androidOrIosPO.setChannelId(channleId);
				operateSoftwareVersionDaoMapper.insert(androidOrIosPO);
			}
		}
	}

	@Override
	public PagingBO<OperateSoftwareVersionBO> findSoftwareVersionList(final OperateSoftwareVersionVO vo) {
		return pageService.getPageData(vo, new ISimplePage<OperateSoftwareVersionBO>() {

			@Override
			public int getTotal() {
				return operateSoftwareVersionDaoMapper.findTotal(vo);
			}

			@Override
			public List<OperateSoftwareVersionBO> getData() {
				return operateSoftwareVersionDaoMapper.find(vo);
			}
		});
	}
	
	@Override
	public int countSoftwareVersion(OperateSoftwareVersionVO vo) {
		return operateSoftwareVersionDaoMapper.findTotal(vo);
	}
	
	@Override
	public List<OperateSoftwareVersionBO> findBaseSoftwareVersion(OperateSoftwareVersionVO vo) {
		return operateSoftwareVersionDaoMapper.findBaseSoftwareVersion(vo);
	}
	
	@Override
	public List<OperateSoftwareVersionBO> distinctSoftwareVersionName(OperateSoftwareVersionVO vo) {
		return operateSoftwareVersionDaoMapper.distinctName(vo);
	}
	
	@Override
	public int delSoftwareVersionByIds(StringVO vo) {
		List<String> ids = Arrays.asList(vo.getStr().split(SymbolConstants.UNDERLINE));
		return operateSoftwareVersionDaoMapper.deleteByIds(ids);
	}

	@Override
	public int updSoftwareVersion(OperateSoftwareVersionVO vo) {
		Assert.notNull(vo.getId(), "更新版本包时，版本id为空");
		// 如果是由不是最新变为是最新,则把所有版本中，"最新"的设置为"不是最新"
		if(vo.isChangeIsNew() && Objects.equals((short)1, vo.getIsnew())) {
			updateIsnew(vo.getIsnew(), vo.getType());
		}
		// 若"是否强制更新"或"版本更新说明"或"是否为最新"有变化，则要更新第三方渠道对应的字段
		if(vo.isChangeUpdateOrNewOrDesc()) {
			OperateSoftwareVersionVO criteria = new OperateSoftwareVersionVO();
			criteria.setIsnew(vo.getIsnew());
			criteria.setIsupdate(vo.getIsupdate());
			criteria.setDescribe(vo.getDescribe());
			criteria.setType(vo.getType());
			criteria.setCode(vo.getCode());
			criteria.setModifyBy(vo.getModifyBy());
			OperateSoftwareVersionPO po = new OperateSoftwareVersionPO(criteria);
			operateSoftwareVersionDaoMapper.update(po);
		}
		// 如果有重新上传版本包，则版本号有变化，所以把第三方渠道对的版本信息删除，再添加新的版本信息
		if(vo.isReupload()) {
			OperateSoftwareVersionVO criteria = new OperateSoftwareVersionVO();
			criteria.setCode(vo.getOldCode());
			criteria.setType(vo.getType());
			criteria.setNegativeId(vo.getId());
			//重新上传，购彩功能和"是否同步官方"默认都未开启
			operateSoftwareVersionDaoMapper.delete(criteria);
			List<String> lotteryFunIds = OperateSoftwareVersionEnum.Modul.getLotteryModul();
			String hideStr = StringUtils.join(lotteryFunIds.iterator(), ",");
			vo.setHide(hideStr);
			vo.setSynOfficial(0);
			addLeafSoftwareVersion(vo);
		}
		OperateSoftwareVersionPO po = new OperateSoftwareVersionPO(vo);
		return operateSoftwareVersionDaoMapper.updateById(po);
	}
	
	@Override
	public OperateSoftwareVersionBO findOneSoftwareVersion(OperateSoftwareVersionVO vo) {
		return operateSoftwareVersionDaoMapper.findOne(vo);
	}
	
	@Override
	public int updateIsnew(int isnew, int type) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("newIsnew", OperateSoftwareVersionEnum.Isnew.NO.getValue());
		paramMap.put("type", type);
		paramMap.put("isnew", isnew);
		return operateSoftwareVersionDaoMapper.updateIsnew(paramMap);
	}

	@Override
	public int valiSoftwareVersionCode(int code) {
		return operateSoftwareVersionDaoMapper.valiSoftwareVersionCode(code);
	}

	@Override
	public int updSoftwareVersionSwitch(OperateSoftwareVersionVO vo) {
		OperateSoftwareVersionPO po = new OperateSoftwareVersionPO(vo);
		Assert.notNull(po.getId(), "更新审核开关id为空"+po);
		return operateSoftwareVersionDaoMapper.updSwitch(po);
	}
	

	@Override
	public int updSoftwareVersionSwitchSynOfficial(OperateSoftwareVersionVO vo) {
		//如果是开启同步，则把所有的先关闭
		OperateSoftwareVersionPO po = new OperateSoftwareVersionPO(vo);
		Assert.notNull(po.getId(), "更新审核开关时id为空"+po);
		int closeNum = 0;
		if(Objects.equals(vo.getSynOfficial(), 1)) {
			Assert.notNull(vo.getChannelId(), "开启审核开关时,参数的渠道id为空"+vo);
			OperateSoftwareVersionPO closeSynOfficial = new OperateSoftwareVersionPO();
			closeSynOfficial.setChannelId(vo.getChannelId());
			closeSynOfficial.setSwitchModifyBy(vo.getSwitchModifyBy());
			closeSynOfficial.setSwitchModifyTime(vo.getSwitchModifyTime());
			closeSynOfficial.setSynOfficial(0);
			closeNum = operateSoftwareVersionDaoMapper.updSwitch(closeSynOfficial);
		} 
		int ret = operateSoftwareVersionDaoMapper.updSwitch(po) + closeNum;
		// 清除缓存,现在只有安卓的
		String key = CacheConstants.C_COMM_VERSION_FIND_NEW_VERSION+vo.getChannelId()+MobailPlatFormEnum.ANDROID.getValue();
		redisUtil.delObj(key);
		return ret;
	}
	
	@Override
	public List<OperateSoftwareVersionBO> findNewSoftwareVersion(OperateSoftwareVersionVO vo) {
		List<OperateSoftwareVersionBO> list = operateSoftwareVersionDaoMapper.findNew(vo);
		return list;
	}
	
	@Override
	public List<OperateMsgTemplateBO> findMsgTemplate(OperateMsgTemplateVO vo) {
		return operateMsgInfoDaoMapper.findMsgTemplate(vo);
	}

	@Override
	public OperateMsgNewBO findNewMsgByBatch(String msgBatch) {
		return operateMsgInfoDaoMapper.findNewMsgByBatch(msgBatch);
	}

	@Override
	public int updateNewMsgStatus(int status, Integer id) {
		return operateMsgInfoDaoMapper.updateNewMsgStatus(status, id);
	}

	@Override
	public List<UserInfoBO> findUserInfoByIds(List<Integer> list) {
		return operateMsgInfoDaoMapper.findUserInfoByIds(list);
	}

	@Override
	public int addMsgInfo(List<OperateMsgInfoVO> list) {
		List<OperateMsgInfoPO> pos = new ArrayList<OperateMsgInfoPO>();
		for(OperateMsgInfoVO vo:list){
			OperateMsgInfoPO po = new OperateMsgInfoPO(vo);
			pos.add(po);
		}
		return operateMsgInfoDaoMapper.addMsgInfo(pos);
	}

	@Override
	public OperateMsgConfigBO findUserConfig(Integer userId, Integer typeId) {
		return operateMsgInfoDaoMapper.findUserConfig(userId, typeId);
	}

	@Override
	public int findValidUserInfoCount() {
		return operateMsgInfoDaoMapper.findValidUserInfoCount();
	}

	@Override
	public List<UserInfoBO> findValidUserInfo(Integer begin, Integer end) {
		return operateMsgInfoDaoMapper.findValidUserInfo(begin, end - begin + 1);
	}
	
	/**
	 * 
	 * @Description 获取发送用户名单
	 * @author HouXiangBao289
	 * @param msgBatch
	 * @return
	 */
	public List<String> getSendUserList(String msgBatch){
		return redisUtil.getObj(msgBatch, new ArrayList<String>());
	}

	@Override
	public void cancelSendMsg(List<OperateMsgInfoVO> list) {
		operateMsgInfoDaoMapper.cancelSendMsg(list);// 取消发送
		operateMsgInfoDaoMapper.updateBatchMsgStatus(list);//更新批次消息状态为取消发送
	}

	@Override
	public  PagingBO<SportAgainstBO> findSportAgainstInfo(final SportAgainstVO vo) {
		return pageService.getPageData(vo, new ISimplePage<SportAgainstBO>() {
			@Override
			public int getTotal() {
				return operateActivitySportRuleDaoMapper.findTotal(vo);
			}

			@Override
			public List<SportAgainstBO> getData() {
				return operateActivitySportRuleDaoMapper.findSportAgainstInfo(vo);
			}
		});
	}
	@Override
	public List<OperateMarketChannelBO> listMarketchannel(OperateMarketChannelVO vo) {
		return marketChannelDaoMapper.findList(vo);
	}

	@Override
	public PagingBO<OperateRebateUserBO> findRebateUser(final OperateRebateUserVO vo) {
		return pageService.getPageData(vo,new ISimplePage<OperateRebateUserBO>() {
			@Override
			public int getTotal() {
				return operateRebateUserDaoMapper.findTotal(vo);
			}
			@Override
			public List<OperateRebateUserBO> getData() {
				List<OperateRebateUserBO> list = operateRebateUserDaoMapper.findList(vo);
				for(OperateRebateUserBO bo: list){
					doRebateUser(bo);
				}
				return list;
			}
		});
	}
	@Override
	public int addRebateUser(OperateRebateUserVO vo){
		//查询大客户信息是否存在
		OperateRebateUserBO  userBO = operateRebateUserDaoMapper.findByUser(vo);
		vo.setType(RebateHisEnum.NOW.getKey());
		if(userBO!=null){
			vo.setCooperateTime(userBO.getCooperateTime());
			vo.setSendAmount(userBO.getSendAmount());
		}		
		int num = operateRebateUserDaoMapper.insert(new OperateRebateUserPO(vo));
		if(num>0&&userBO!=null){
			int upnum = operateRebateUserDaoMapper.updateOldUserType(userBO.getId());
			if(upnum<=0)
			throw new ServiceRuntimeException("更新历史数据失败");
		}
		return num;
	}
	@Override
	public OperateRebateUserBO findByUser(Integer userId){
		//查询大客户信息是否存在
		OperateRebateUserVO vo = new OperateRebateUserVO();
		vo.setUserId(userId);
		OperateRebateUserBO bo = operateRebateUserDaoMapper.findByUser(vo);
		doRebateUser(bo);
		return bo;		
	}
	void doRebateUser(OperateRebateUserBO bo){
		if(bo.getNumRule()!=null){
			net.sf.json.JSONObject  numobj = net.sf.json.JSONObject.fromObject(bo.getNumRule());		
			bo.setNumRuleType(numobj.get("status")); 
			bo.setNumRulePro(numobj.get("rebate"));
			bo.setNumLimitLottery(numobj.get("lotteryCode"));
		}				
		if(bo.getHighRule()!=null){
			net.sf.json.JSONObject  highobj = net.sf.json.JSONObject.fromObject(bo.getHighRule());
			bo.setHighRuleType(highobj.get("status")); 
			bo.setHighRulePro(highobj.get("rebate"));
			bo.setHighLimitLottery(highobj.get("lotteryCode"));
		}		
		if(bo.getMatchRule()!=null){
			net.sf.json.JSONObject  matchobj = net.sf.json.JSONObject.fromObject(bo.getMatchRule());
			bo.setMatchRuleType(matchobj.get("status")); 
			bo.setMatchRulePro(matchobj.get("rebate"));
			bo.setMatchLimitLottery(matchobj.get("lotteryCode"));
		}		
		if(bo.getSportRule()!=null){
			net.sf.json.JSONObject  sportobj = net.sf.json.JSONObject.fromObject(bo.getSportRule());
			bo.setSportRuleType(sportobj.get("status")); 
			bo.setSportRulePro(sportobj.get("rebate"));
			bo.setSportLimitLottery(sportobj.get("lotteryCode"));
		}	
	}

	@Override
	public List<OperateRebateUserBO> findUserHisList(Integer userId) {
		OperateRebateUserVO vo = new OperateRebateUserVO();
		vo.setUserId(userId);
		List<OperateRebateUserBO> boList = operateRebateUserDaoMapper.findUserHisList(vo);
		for(OperateRebateUserBO bo: boList){
			doRebateUser(bo);
		}
		return boList;	
	}
	@Override
	public List<DictionaryBO> findActivityStatusTrue(){
		return activityDaoMapper.findActivityStatusTrue();
	}

	@Override
	public OperateActivityAwardBO addPrizeAwardConfig(OperateActivityAwardVO vo) {
		OperateActivityAwardBO retbo = new OperateActivityAwardBO();
		Integer configId = vo.getActivityConfigId();
		if(configId==null){
			OperateActivityConfigPO cofigPO = new OperateActivityConfigPO(vo);
			operateActivityConfigDaoMapper.merge(cofigPO);
			configId = cofigPO.getId();
			vo.setActivityConfigId(configId);
		}
		if(vo.getType()==ActivityAwardTypeEnum.COUPON.getValue()){
			
			OperateCouponTempPO couponPO = new OperateCouponTempPO(vo);
			couponPO.setRedStatus(Short.valueOf(RedStatusEnum.WAITTING_ACTIVATION.getKey()));
			couponPO.setLimitNum(1);
			couponPO.setRedName(vo.getAwardText());
			if(vo.getId()!=null){
				OperateActivityAwardBO awardBO =	operateActivityAwardDaoMapper.selectByPrimaryKey(vo.getId());
				if(awardBO!=null)couponPO.setId(Integer.valueOf(awardBO.getTypeCode()));
			}
			operateCouponTempDaoMapper.mergeBase(couponPO);
			vo.setTypeCode(""+couponPO.getId());
		}		
		
		OperateActivityAwardPO po =new OperateActivityAwardPO(vo);
		operateActivityAwardDaoMapper.merge(po);
		retbo.setActivityConfigId(configId);
		retbo.setId(po.getId());
		return retbo;
	}

	@Override
	public int delPrizeAwardConfig(OperateActivityAwardVO vo) {
	 
		if(vo.getType()==ActivityAwardTypeEnum.COUPON.getValue()){
			OperateActivityAwardBO awardBO =	operateActivityAwardDaoMapper.selectByPrimaryKey(vo.getId());
			List<Integer> ruleIds = new ArrayList<Integer>();
			ruleIds.add(Integer.valueOf(awardBO.getTypeCode()));
			operateCouponTempDaoMapper.deleteBatch(ruleIds);
		}
		int i=operateActivityAwardDaoMapper.deleteByPrimaryKey(vo.getId());
		return i;
	}

	@Override
	public OperateActivityAddedBO addAddCodeConfig(OperateActivityAddedVO vo) {
		OperateActivityAddedBO retbo = new OperateActivityAddedBO();
		Integer configId = vo.getActivityConfigId();
		if(configId==null){
			OperateActivityConfigPO cofigPO = new OperateActivityConfigPO();
			cofigPO.setActivityCode(vo.getActivityCode());
			cofigPO.setCreateBy(vo.getCreateBy());
			cofigPO.setModifyBy(vo.getModifyBy());
			operateActivityConfigDaoMapper.merge(cofigPO);
			configId = cofigPO.getId();
			vo.setActivityConfigId(configId);
		}
		if(vo.getRuleType()==ActivityAddCodeRuleEnum.COUPON.getValue()){
			OperateCouponTempPO couponPO = new OperateCouponTempPO(vo);
			if(vo.getId()!=null){
				OperateActivityAddedBO awardBO =	operateActivityAddedDaoMapper.selectByPrimaryKey(vo.getId());
				if(awardBO!=null)couponPO.setId(awardBO.getOperateActivityCouponId());
			}
			operateCouponTempDaoMapper.mergeCoupon(couponPO);
			vo.setOperateActivityCouponId(couponPO.getId());
		}		
		
		OperateActivityAddedPO po =new OperateActivityAddedPO(vo);
		operateActivityAddedDaoMapper.merge(po);
		retbo.setActivityConfigId(configId);
		retbo.setId(po.getId());
		return retbo;
	}

	@Override
	public int delAddCodeConfig(OperateActivityAddedVO vo) {
	 
		if(vo.getRuleType()==ActivityAddCodeRuleEnum.COUPON.getValue()){
			OperateActivityAddedBO awardBO =	operateActivityAddedDaoMapper.selectByPrimaryKey(vo.getId());
			List<Integer> ruleIds = new ArrayList<Integer>();
			ruleIds.add(awardBO.getOperateActivityCouponId());
			operateCouponTempDaoMapper.deleteBatch(ruleIds);
		}
		int i=operateActivityAddedDaoMapper.deleteByPrimaryKey(vo.getId());
		return i;
	}
//	@Override
//	public int updSoftwareVersionSwitchByChannlId(OperateSoftwareVersionVO vo) {
//		OperateSoftwareVersionPO po = new OperateSoftwareVersionPO(vo);
//		return operateSoftwareVersionDaoMapper.updSwitch(po);
//	}

	@Override
	public List<OperateArticleBO> listArticleRss() {
		return operateArticleDaoMapper.listArticleRss();
	}

	@Override
	public ResultBO<?> updateCouponTemp(OperateCouponTempVO vo) {
		int res = operateCouponTempDaoMapper.update(vo);
		if(res>0){
			return ResultBO.ok();
		}
		return ResultBO.err();
	}

	@Override
	public ResultBO<?> deleteCouponTemp(OperateCouponTempVO vo) {
		int res = operateCouponTempDaoMapper.deleteById(vo.getId());
		if(res>0){
			return ResultBO.ok();
		}
		return ResultBO.err();
	}

	@Override
	public ResultBO<?> insertCouponTemp(OperateCouponTempVO vo) {
		int res = operateCouponTempDaoMapper.insert(new OperateCouponTempPO(vo));
		if(res>0){
			return ResultBO.ok();
		}
		return ResultBO.err();
	}

	@Override
	public ResultBO<List<OperateCouponTempBO>> findCouponTemp(OperateCouponTempVO vo) {
		return ResultBO.ok(operateCouponTempDaoMapper.findList(vo));
	}

	@Override
	public OperateActivityRechargeBO addRechargeConfig(OperateActivityRechargeVO vo) {
		OperateActivityRechargeBO retbo = new OperateActivityRechargeBO();
		Integer configId = vo.getActivityConfigId();
		//插入主表
		if(configId==null){
			OperateActivityConfigPO cofigPO = new OperateActivityConfigPO();
			cofigPO.setActivityCode(vo.getActivityCode());
			cofigPO.setCreateBy(vo.getCreateBy());
			cofigPO.setModifyBy(vo.getModifyBy());
			operateActivityConfigDaoMapper.merge(cofigPO);
			configId = cofigPO.getId();
			vo.setActivityConfigId(configId);
		}
		//插入规则表
		OperateActivityRulePO rulePO  = new OperateActivityRulePO(vo);
		operateActivityRuleDaoMapper.merge(rulePO);
		vo.setId(rulePO.getId());
		//插入红包模板表
		List<OperateCouponTempPO> tempPOList =new ArrayList<OperateCouponTempPO>();
		for(OperateCouponTempVO tempVO:vo.getCouponTemp()){
			OperateCouponTempPO tempPO = new OperateCouponTempPO(tempVO);
			tempPO.setConfigId(vo.getId());
			tempPO.setConfigType(CouponConfigTypeEnum.ACTIVITY_RULE.getValue());
			tempPOList.add(tempPO);
		}
		operateCouponTempDaoMapper.mergeBatchTemp(tempPOList);
		retbo.setActivityConfigId(configId);
		retbo.setId(vo.getId());
		return retbo;
	}

    @Override
    public List<OperateActivityChpGuessBO> findChpTeams(OperateActivityChpGuessBO vo) {
        return operateActivityChpGuessDaoMapper.find(vo);
    }

	@Override
	public PagingBO<OperateActivityChpInfoBO> pageChpUsers(OperateActivityChpInfoBO vo) {
		return pageService.getPageData(vo,new ISimplePage<OperateActivityChpInfoBO>() {
			@Override
			public int getTotal() {
				return operateActivityChpInfoDaoMapper.count(vo);
			}
			@Override
			public List<OperateActivityChpInfoBO> getData() {
				return operateActivityChpInfoDaoMapper.find(vo);
			}
		});
	}

	@Override
	public List<OperateActivityChpInfoBO> findChpUsers(OperateActivityChpInfoBO vo) {
		return operateActivityChpInfoDaoMapper.find(vo);
	}

    /**
     * 添加世界杯冠军竞猜用户
     * @param chpInfoes
     * @return
     */
    @Override
    public int addActivityChpInfo(List<OperateActivityChpInfoBO> chpInfoes) {
        // 1.确保用户昵称与现有用户昵称不重复
        LottoCustomerVO vo = new LottoCustomerVO();
        vo.setType("NICK_NAME");
        List<String> nickNames = chpInfoes.stream().map(c -> c.getNickName()).collect(Collectors.toList());
        vo.setValues(nickNames);
        vo.setPageIndex(0);
        vo.setPageSize(Integer.MAX_VALUE);
        PagingBO<LottoCustomerBO> page = customerMgrService.findLottoCustomer(vo);
        if(page.getTotal()>0) {
            String duplicateNickNames = page.getData().stream().map(user->user.getNickName()).collect(Collectors.joining(",","用户名已存在[","]"));
            throw new ServiceRuntimeException(duplicateNickNames);
        }
        // 2.每上传一次，都把以前的假用户数据删除
        OperateActivityChpInfoBO chpVO = new OperateActivityChpInfoBO();
        // 用户状态，1真实用户，2测试用户
        chpVO.setUserType((short)2);
        List<OperateActivityChpInfoBO> fakeChpInfoes = operateActivityChpInfoDaoMapper.findChpInfo(chpVO);
        if(!fakeChpInfoes.isEmpty()) {
            List<Integer> fakeActivityInfoIds = fakeChpInfoes.stream().map(chp -> chp.getActivityInfoId()).collect(Collectors.toList());
            operateActivityChpInfoDaoMapper.delete(chpVO);
            OperateActivityInfoBO infoDelVO = new OperateActivityInfoBO();
            infoDelVO.setType("id");
            infoDelVO.setValues(fakeActivityInfoIds);
            operateActivityInfoDaoMapper.delete(infoDelVO);
        }
        // 3.向operate_activity_chp_info和operate_activity_info添加世界杯冠军竞猜用户
        List<OperateActivityInfoBO> infoesToAdd = chpInfoes.stream().map(c -> {
            OperateActivityInfoBO info = new OperateActivityInfoBO();
            info.setActivityCode(c.getActivityCode());
            info.setActivityRuleId(c.getActivityRuleId());
            info.setCreateBy(c.getCreateBy());
            info.setCreateTime(c.getCreateTime());
            info.setNickName(c.getNickName());
            // 假用户id为0
            info.setUserId(0);
            return info;
        }).collect(Collectors.toList());
        int num = operateActivityInfoDaoMapper.addBatch(infoesToAdd);
        Map<String,Integer> activityInfoIdMap = infoesToAdd.stream().collect(Collectors.toMap(a->a.getNickName(),a->a.getId()));
        chpInfoes.forEach(c->c.setActivityInfoId(activityInfoIdMap.get(c.getNickName())));
        num += operateActivityChpInfoDaoMapper.addBatch(chpInfoes);
        return num;
    }
}
