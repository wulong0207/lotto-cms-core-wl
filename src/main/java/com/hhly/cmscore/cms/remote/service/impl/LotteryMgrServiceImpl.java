package com.hhly.cmscore.cms.remote.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.hhly.cmscore.cms.remote.service.ILotteryMgrService;
import com.hhly.cmscore.cms.remote.service.status.IssueCheckVisitor;
import com.hhly.cmscore.persistence.issue.dao.LotteryIssueDaoMapper;
import com.hhly.cmscore.persistence.issue.po.LotteryIssuePO;
import com.hhly.cmscore.persistence.lottery.dao.LotteryBettingMulDaoMapper;
import com.hhly.cmscore.persistence.lottery.dao.LotteryChildDaoMapper;
import com.hhly.cmscore.persistence.lottery.dao.LotteryLimitMapper;
import com.hhly.cmscore.persistence.lottery.dao.LotteryTypeDaoMapper;
import com.hhly.cmscore.persistence.lottery.dao.LotteryWinningDaoMapper;
import com.hhly.cmscore.persistence.lottery.po.LotteryBettingMulPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryChildPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryLimitInfoPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryLimitPO;
import com.hhly.cmscore.persistence.lottery.po.LotteryTypePO;
import com.hhly.cmscore.persistence.order.dao.OrderInfoDaoMapper;
import com.hhly.persistence.common.Constants;
import com.hhly.persistence.util.DrawCodeUtil;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.common.LotteryEnum;
import com.hhly.skeleton.base.common.LotteryEnum.ConIssue;
import com.hhly.skeleton.base.common.LotteryEnum.IssueLastest;
import com.hhly.skeleton.base.common.LotteryEnum.LotIssueSaleStatus;
import com.hhly.skeleton.base.common.LotteryEnum.Lottery;
import com.hhly.skeleton.base.constants.SymbolConstants;
import com.hhly.skeleton.base.exception.ServiceRuntimeException;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.page.ISimplePage;
import com.hhly.skeleton.base.status.VisitorHandler;
import com.hhly.skeleton.base.util.ObjectUtil;
import com.hhly.skeleton.cms.base.vo.StringVO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryBettingMulBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryChildBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryIssueCmsBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryIssueExcelBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryLimitBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryLimitInfoBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryTypeBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryTypeExcelBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryWinningBO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryBettingMulCmsVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryChildCmsVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryIssueCmsVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryLimitInfoVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryLimitVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryTypeVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryWinningVO;
import com.hhly.skeleton.lotto.base.issue.bo.IssueLottBO;


@Service("lotteryMgrService")
public class LotteryMgrServiceImpl implements ILotteryMgrService {

	@Autowired
	private LotteryTypeDaoMapper lotteryTypeDaoMapper;

	@Autowired
	private LotteryChildDaoMapper lotteryChildDaoMapper;

	@Autowired
	private LotteryBettingMulDaoMapper lotteryBettingMulDaoMapper;

	@Autowired
	private LotteryIssueDaoMapper issueDaoMapper;

	@Autowired
	private OrderInfoDaoMapper orderInfoDaoMapper;
	
	/**
	 * 限号管理的数据接口
	 */
	@Autowired
	private LotteryLimitMapper lotteryLimitMapper;
	/**
	 * 彩种奖项数据接口
	 */
	@Autowired
	private LotteryWinningDaoMapper lotteryWinningDaoMapper;
	
	

	@Autowired
	private IPageService pageService;
	
	@Override
	public PagingBO<LotteryTypeBO> findLotteryType(final LotteryTypeVO vo) {
		return pageService.getPageData(vo, new ISimplePage<LotteryTypeBO>() {

			@Override
			public int getTotal() {
				return lotteryTypeDaoMapper.findTotal(vo);
			}

			@Override
			public List<LotteryTypeBO> getData() {
				return lotteryTypeDaoMapper.find(vo);
			}
		});
	}
	
	

	@Override
	public LotteryTypeBO findSingle(LotteryTypeVO vo) {
		return lotteryTypeDaoMapper.findSingle(vo);
	}

	@Override
	public List<LotteryBettingMulBO> findLotteryDettingMul(StringVO vo) {
		return lotteryBettingMulDaoMapper.findByCode(vo.getStr());
	}

	@Override
	public List<LotteryChildBO> findLotteryChild(StringVO vo) {
		return lotteryChildDaoMapper.findByCode(vo.getStr());
	}

	@Override
	public int updLotteryType(LotteryTypeVO vo) {
		LotteryTypePO po = new LotteryTypePO(vo);
		// 修改彩种(修改前的信息)
		LotteryTypePO updBefore = lotteryTypeDaoMapper.findLotteryTypeByKey(po.getId());
		if(ObjectUtil.isBlank(po.getMinBet())||po.getMinBet()<2){
			po.setMinBet(2);
		}
		int num = lotteryTypeDaoMapper.updLotteryTypeByKey(po);
		// 查询当前期信息
		LotteryIssueCmsBO currIssue = issueDaoMapper.findIssue(updBefore.getLotteryCode(), ConIssue.CURRENT.getValue());

		// 1.修改开售时间，需要修改当前期以后彩期的 开售时间=上期官方截止时间+开售时间
		if (!Objects.equals(po.getSaleTime(), updBefore.getSaleTime())) {
			Assert.notNull(currIssue, "修改开售时间失败，彩种不存在当前期");
			updateSaleTime(po.getLotteryCode(), po.getSaleTime(),
					currIssue.getIssueCode());
		}
		
		// 2.修改购买截止时间
		if (!Objects.equals(updBefore.getBuyEndTime(), po.getBuyEndTime())) {
			Assert.notNull(currIssue, "修改购买截止时间失败，彩种不存在当前期");
			updBuyEndTime(po, currIssue);
		}
		
		// 3.修改检票时间
		if (!Objects.equals(po.getEndCheckTime(), updBefore.getEndCheckTime())) {
			// 修改定时器时间(暂时没做)
			// 修改方案订单的检票时间为 官方截止时间 + 设置的时间
			// 修改订单截止时间；修改当前期和当前期之后期数所有订单的截止时间，订单状态为 待上传、待拆票、拆票中、待出票、出票中、出票失败
			orderInfoDaoMapper.updEndCheckTime(po.getEndCheckTime(),
					po.getLotteryCode(), currIssue.getIssueCode());
		}
		return num;
	}
	private void updBuyEndTime(LotteryTypePO po, LotteryIssueCmsBO currIssue) {
		// 修改定时器时间(暂时没做)
		// 修改彩期 （当前期） ：销售截止时间 = 官方截止时间+设置的值
		issueDaoMapper.updIssueBuyEndTime(po.getBuyEndTime(),
				po.getLotteryCode(), currIssue.getIssueCode());
	}

	/**
	 * 修改开售时间
	 *
	 * @param lotteryCode
	 *            彩种
	 * @param time
	 *            时间（秒）
	 */
	private void updateSaleTime(Integer lotteryCode, int time, String issueCode) {
		// 竞彩足球，篮球，北京单场，胜负过关 不用修改
		boolean needUpdate = Objects.equals(Lottery.FB.getName(),lotteryCode)
				||  Objects.equals(Lottery.BB.getName(),lotteryCode)
				||  Objects.equals(Lottery.SFGG.getName(),lotteryCode)
				||  Objects.equals(Lottery.BJDC.getName(),lotteryCode);
		if (needUpdate) return;
		
		List<LotteryIssuePO> list = issueDaoMapper.findIssueOfficialEndTime(
				lotteryCode, issueCode);
		List<LotteryIssuePO> updateList = new ArrayList<LotteryIssuePO>();
		for (int i = 1; i < list.size(); i++) {
			Integer id = list.get(i).getId();
			Date saleTime = DateUtils.addSeconds(list.get(i - 1)
					.getOfficialEndTime(), time);
			LotteryIssuePO issuePO = new LotteryIssuePO();
			issuePO.setId(id);
			issuePO.setSaleTime(saleTime);
			updateList.add(issuePO);
		}
		if (updateList.size() > 0) {
			issueDaoMapper.updateSaleTime(updateList);
		}
	}
	@Override
	public int addLotteryBettingMul(LotteryBettingMulCmsVO vo) {
		LotteryBettingMulPO po = new LotteryBettingMulPO(vo);
		return lotteryBettingMulDaoMapper.add(po);
	}

	@Override
	public int addLotteryChild(LotteryChildCmsVO vo) {
		LotteryChildPO po = new LotteryChildPO(vo);
		return lotteryChildDaoMapper.add(po);
	}

	@Override
	public int updLotteryBettingMul(LotteryBettingMulCmsVO vo) {
		LotteryBettingMulPO po = new LotteryBettingMulPO(vo);
		return lotteryBettingMulDaoMapper.updByPrimaryKey(po);
	}

	@Override
	public int updLotteryChild(LotteryChildCmsVO vo) {
		LotteryChildPO po = new LotteryChildPO(vo);
		return lotteryChildDaoMapper.updByPrimaryKey(po);
	}

	@Override
	public int delLotteryBettingMul(StringVO vo) {
		List<String> ids = Arrays.asList(vo.getStr().split(SymbolConstants.UNDERLINE));
		return lotteryBettingMulDaoMapper.delByPrimaryKeyList(ids);
	}

	@Override
	public int delLotteryChild(StringVO vo) {
		List<String> ids = Arrays.asList(vo.getStr().split(SymbolConstants.UNDERLINE));
		return lotteryChildDaoMapper.delByPrimaryKeyList(ids);
	}

	@Override
	public int saveLotteryBettingMul(List<LotteryBettingMulCmsVO> list) {
		for (LotteryBettingMulCmsVO vo : list) {
			LotteryBettingMulPO po = new LotteryBettingMulPO(vo);
			if (po.getId() == null) {
				lotteryBettingMulDaoMapper.add(po);
			} else {
				lotteryBettingMulDaoMapper.updByPrimaryKey(po);
			}
		}
		return 1;
	}

	@Override
	public int saveLotteryChild(List<LotteryChildCmsVO> list) {
		for (LotteryChildCmsVO vo : list) {
			LotteryChildPO po = new LotteryChildPO(vo);
			if (po.getId() == null) {
				lotteryChildDaoMapper.add(po);
			} else {
				lotteryChildDaoMapper.updByPrimaryKey(po);
			}
		}
		return 1;
	}

	@Override
	public List<LotteryTypeExcelBO> findLotteryTypeToExcel(LotteryTypeVO vo) {
		return lotteryTypeDaoMapper.findLotteryTypeToExcel(vo);
	}

	@Override
	public int addLotteryType(LotteryTypeVO vo) {
		int count = lotteryTypeDaoMapper.findCountCode(vo.getLotteryCode());
		Assert.isTrue(count == 0, "添加彩种编号已存在");
		LotteryTypePO po = new LotteryTypePO(vo);
		if(ObjectUtil.isBlank(po.getMinBet())||po.getMinBet()<2){
			po.setMinBet(2);
		}
		return lotteryTypeDaoMapper.add(po);
	}

	@Override
	public List<String> findIssueCode(LotteryIssueCmsVO vo) {
		Assert.notNull(vo.getLotteryCode(), "彩种编号不能为空");
		Assert.isTrue(vo.getQryCount() > 0, "查询期数必须大于0");
		if(Objects.equals(vo.getType(),1)){
			return issueDaoMapper.findCutOffIssueCode(vo);
		}
		return issueDaoMapper.findIssueCode(vo);
	}
	
	@Override
	public PagingBO<LotteryIssueCmsBO> findLotteryIssue(final LotteryIssueCmsVO vo) {
		return pageService.getPageData(vo,new ISimplePage<LotteryIssueCmsBO>() {
			@Override
			public int getTotal() {
				return issueDaoMapper.findTotal(vo);
			}
			@Override
			public List<LotteryIssueCmsBO> getData() {
				return issueDaoMapper.find(vo);
			}
		});
	}

	@Override
	public void updOmotAll(int lotteryCode, String issueCode, String drawCode) {
		if(StringUtils.hasText(drawCode)){
			Assert.isTrue(DrawCodeUtil.isCorrect(drawCode, lotteryCode),"开奖号码格式不正确！");
			Map<String,Object> param = new HashMap<>();
			param.put("lotteryCode", lotteryCode);
			param.put("issueCode",  issueCode);
			param.put("drawCode", drawCode);
			try {
				issueDaoMapper.getOmotAll(param);
			} catch (Exception e) {
				throw new ServiceRuntimeException("生成遗漏数据异常",e);
			}
			
		}
	}

	@Override
	public int updLotteryIssue(LotteryIssueCmsVO vo) {
		LotteryIssuePO po = new LotteryIssuePO(vo);

		LotteryIssueCmsBO bo = issueDaoMapper.findIssueDetial(po
				.getId() + "");
		if(!checkLotteryIssueStatus(bo.getSaleStatus(), po.getSaleStatus())){
			throw new ServiceRuntimeException("彩期状态修改方式错误");
		}
		// 开奖号码验证
		if (StringUtils.hasText(po.getDrawCode())) {
			Assert.isTrue(DrawCodeUtil.isCorrect(po.getDrawCode(), bo.getLotteryCode()),"开奖号码格式不正确！");
		}
		// 是否修改当前期标示
		if (!Objects.equals(po.getCurrentIssue(), bo.getCurrentIssue())) {
			//本身不能是当前期
			Assert.isTrue(!Objects.equals(bo.getCurrentIssue(), ConIssue.CURRENT.getValue()), "当前期彩种不能修改为不是当期前");
			
			//本身不能是上一期
			Assert.isTrue((Objects.equals(bo.getCurrentIssue(), ConIssue.LAST_CURRENT.getValue()) && 
					!Objects.equals(po.getCurrentIssue(), ConIssue.NOT_CURRENT.getValue())), "上一期彩种只能修改为已完成");	
			
			if (Objects.equals(po.getCurrentIssue(), ConIssue.CURRENT.getValue())) {
				// 修改为当前期
				if (LotIssueSaleStatus.PRE_SALING.getValue() == po.getSaleStatus()
						|| LotIssueSaleStatus.SALING.getValue() == po.getSaleStatus()) {
					// 能销售（预售中，销售中）
					// 把现有当前期修改为不是当前期
					issueDaoMapper.updCurrentIssue(po.getLotteryCode(), ConIssue.CURRENT.getValue());
				} else {
					// 不能销售
					throw new IllegalArgumentException("本期不能销售，不能改为当前期");
				}
			}
			
			if (Objects.equals(po.getCurrentIssue(), ConIssue.LAST_CURRENT.getValue())) {
				// 修改为当前期
				if (LotIssueSaleStatus.PRE_SALING.getValue() != po.getSaleStatus()
						|| LotIssueSaleStatus.SALING.getValue() != po.getSaleStatus()) {
					// 能销售（预售中，销售中）
					// 把现有上一期修改为不是上一期
					issueDaoMapper.updCurrentIssue(po.getLotteryCode(), ConIssue.LAST_CURRENT.getValue());
				} else {
					// 不能销售
					throw new IllegalArgumentException("销售的彩期，不能改为上一期");
				}
			}
		}
		if (!Objects.equals(po.getIssueLastest(), bo.getIssueLastest())) {
					
			if(Objects.equals(po.getIssueLastest(), IssueLastest.YES.getCode())){
				//修改最新开奖
				if(!ObjectUtil.isBlank(po.getDrawCode())){
					issueDaoMapper.updIssueLastest(po.getLotteryCode());
				}else{
					// 没有彩果的彩期
					throw new IllegalArgumentException("没有开奖信息的彩期, 不能修改为最新开奖");
				}
			}				
		}
		
		//如果是十四场，则同步十四场的draw_code，issue_lastest两个字段的值到任九场
		Lottery lottery = Lottery.getLottery(bo.getLotteryCode());
		if(lottery == Lottery.SFC) {
			issueDaoMapper.updIssueByLotteryName(vo.getDrawCode(),vo.getIssueLastest(),vo.getIssueCode(),Lottery.ZC_NINE.getName());
			issueDaoMapper.updateMinIssueCode(vo.getIssueCode(), Lottery.ZC_NINE.getName());
		}
		
		return issueDaoMapper.updIssueByKey(po);
	}
	
    /**
     * 彩期状态修改验证
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017年3月8日 下午6:28:49
     * @param beforeStatus 修改之间装填
     * @param afterStatus 修改之后的状态
     * @return 验证成功true 失败false
     */
	private boolean checkLotteryIssueStatus(int beforeStatus, int afterStatus) {
		IssueCheckVisitor visitor = new IssueCheckVisitor();
		return VisitorHandler.disboseOrderStatus(beforeStatus, null, afterStatus, visitor);
    }
	
	@Override
	public int addLotteryIssue(LotteryIssueCmsVO vo) {
		LotteryIssuePO po = new LotteryIssuePO(vo);
		int count = issueDaoMapper.findIssueCount(new LotteryIssueCmsVO(po.getLotteryCode(),
				po.getIssueCode()));
		Assert.isTrue(count == 0, "当前彩种该彩期已经存在，不能添加");
		LotteryTypeVO typeVo = new LotteryTypeVO(vo.getLotteryCode());
		LotteryTypeBO bo = lotteryTypeDaoMapper.findSingle(typeVo);
		Assert.notNull(bo, "所添加彩期的彩种不存在");
		po.setLotteryName(bo.getLotteryName());
		if(Objects.equals(ConIssue.CURRENT.getValue(),po.getCurrentIssue())){
			LotteryIssueCmsBO issueBO = issueDaoMapper.findIssue(po.getLotteryCode(), ConIssue.CURRENT.getValue());
			if(issueBO != null){
				throw new ServiceRuntimeException("该彩种已存在当前期，不能添加当前期");
			}
		}
		return issueDaoMapper.addIssue(po);
	}

	@Override
	public List<LotteryIssueExcelBO> findLotteryIssueToExcel(LotteryIssueCmsVO vo) {
		int num = issueDaoMapper.findTotal(vo);
		Assert.isTrue(num <= Constants.EXCEL_NUM,Constants.EXCEL_ERROR_MSG);
		return issueDaoMapper.findIssueToExcel(vo);
	}

	@Override
	public LotteryIssueCmsBO findLotteryIssueDetail(StringVO vo) {
		return issueDaoMapper.findIssueDetial(vo.getStr());
	}

	@Override
	public LotteryIssueCmsBO findIssue(Integer lotteryCode, Short currentIssue) {
		return issueDaoMapper.findIssue(lotteryCode,currentIssue);
	}

	@Override
	public List<LotteryTypeBO> findLotteryTypeDic(StringVO vo) {
		return lotteryTypeDaoMapper.findLotteryTypeDic(vo.getStr());
	}
	
	@Override
	public List<LotteryTypeBO> findLotteryName(List<String> ids) {
		Assert.notNull(ids,"彩种ID不能为空");
		Assert.isTrue(ids.size()>0,"彩种ID不能为空");
		return lotteryTypeDaoMapper.findLotteryName(ids);
	}

	@Override
	public List<LotteryChildBO> findMultipleChild(LotteryChildCmsVO lotteryChildCms) {
		return lotteryChildDaoMapper.findMultipleCms(lotteryChildCms);
	}

    @Override
    public Map<String, String> listChildTypeName(Collection<String> codes){
        List<LotteryChildBO> loadList = lotteryChildDaoMapper.listChildCodeName(codes);
        Map<String, String> map = new HashMap<String, String>();
        for (LotteryChildBO bo : loadList) {
            map.put(String.valueOf(bo.getLotteryChildCode()),bo.getChildName());
        }
        return map;
    }

    @Override
    public List<LotteryIssueCmsBO> listCurrentIssue(String lotteryCategory) {
        return issueDaoMapper.listCurrentIssue(lotteryCategory);
    }

    @Override
    public LotteryIssueCmsBO getLotteryIssueMonitor(int lotteryCode) {
        return issueDaoMapper.getLotteryIssueMonitor(lotteryCode);
    }

    /************************限号管理操作*****************************/
	@Override
	public LotteryLimitBO findSingleLimit(LotteryLimitVO lotteryLimitVO) {
		return lotteryLimitMapper.findSingleLimit(lotteryLimitVO);
	}

	@Override
	public PagingBO<LotteryLimitBO> findPagingLimit(final LotteryLimitVO lotteryLimitVO) {
		return pageService.getPageData(lotteryLimitVO, new ISimplePage<LotteryLimitBO>() {
			@Override
			public int getTotal() {
				return lotteryLimitMapper.findCountLimit(lotteryLimitVO);
			}

			@Override
			public List<LotteryLimitBO> getData() {
				return lotteryLimitMapper.findPagingLimit(lotteryLimitVO);
			}
		});
	}

	@Override
	public int addLimit(LotteryLimitVO lotteryLimitVO) {
		return lotteryLimitMapper.addLimit(new LotteryLimitPO(lotteryLimitVO));
	}

	@Override
	public int updLimit(LotteryLimitVO lotteryLimitVO) {
		return lotteryLimitMapper.updLimit(new LotteryLimitPO(lotteryLimitVO));
	}

	@Override
	public LotteryLimitInfoBO findSingleLimitInfo(LotteryLimitInfoVO lotteryLimitInfoVO) {
		return lotteryLimitMapper.findSingleLimitInfo(lotteryLimitInfoVO); 
	}

	@Override
	public PagingBO<LotteryLimitInfoBO> findPagingLimitInfo(final LotteryLimitInfoVO lotteryLimitInfoVO) {
		return pageService.getPageData(lotteryLimitInfoVO, new ISimplePage<LotteryLimitInfoBO>() {
			@Override
			public int getTotal() {
				return lotteryLimitMapper.findCountLimitInfo(lotteryLimitInfoVO);
			}

			@Override
			public List<LotteryLimitInfoBO> getData() {
				return lotteryLimitMapper.findPagingLimitInfo(lotteryLimitInfoVO);
			}
		});
	}

	@Override
	public int addLimitInfo(LotteryLimitInfoVO lotteryLimitInfoVO) {
		return lotteryLimitMapper.addLimitInfo(new LotteryLimitInfoPO(lotteryLimitInfoVO));
	}

	@Override
	public int updLimitInfo(LotteryLimitInfoVO lotteryLimitInfoVO) {
		return lotteryLimitMapper.updLimitInfo(new LotteryLimitInfoPO(lotteryLimitInfoVO));
	}

	@Override
	public int saveLimitInfo(List<LotteryLimitInfoVO> list) {
		/*for (LotteryLimitInfoVO temp : list) {
			if (temp.getId() == null) {
				lotteryLimitMapper.addLimitInfo(new LotteryLimitInfoPO(temp));
			} else {
				lotteryLimitMapper.updLimitInfo(new LotteryLimitInfoPO(temp));
			}
		}*/
		List<LotteryLimitInfoPO> listPO = new ArrayList<LotteryLimitInfoPO>();
		for (LotteryLimitInfoVO temp : list) {
			listPO.add(new LotteryLimitInfoPO(temp));
		}
		lotteryLimitMapper.saveLimitInfo(listPO);
		return Constants.NUM_1;
	}
	/************************限号管理操作*****************************/
	/************************ 彩种奖项相关 *****************************/
	@Override
	public LotteryWinningBO findSingleLotWinning(LotteryWinningVO lotteryWinningVO) {
		return lotteryWinningDaoMapper.findSingle(lotteryWinningVO);
	}

	@Override
	public List<LotteryWinningBO> findMultipleLotWinning(LotteryWinningVO lotteryWinningVO) {
		return lotteryWinningDaoMapper.findMultiple(lotteryWinningVO);
	}
	/************************ 彩种奖项相关 *****************************/

	@Override
	public int updateAuditDrawCode(LotteryIssueCmsVO vo) {
		//验证开奖号码，状态
		LotteryIssueCmsBO bo = issueDaoMapper.findIssueDetial(vo.getId().toString());
		short status = LotteryEnum.LotIssueSaleStatus.APPROVED.getValue();
		if(!checkLotteryIssueStatus(bo.getSaleStatus(),status)){
			throw new ServiceRuntimeException("彩期状态修改方式错误");
		}
		if(bo.getSaleStatus() == status){
			throw new ServiceRuntimeException("开奖号码已审核");
		}
		if(!Objects.equals(vo.getDrawCode(),bo.getDrawCode())){
			throw new ServiceRuntimeException("审核开奖号码与系统不一致，系统："+bo.getDrawCode());
		}
		//修改掉之前最新开奖
		issueDaoMapper.updIssueLastest(bo.getLotteryCode());
		
		LotteryIssuePO po = new LotteryIssuePO();
		po.setId(vo.getId());
		po.setSaleStatus(status);
		po.setIssueLastest(LotteryEnum.IssueLastest.YES.getCode());
		po.setModifyBy(vo.getModifyBy());
		po.setModifyTime(new Date());
		return issueDaoMapper.updateByKeySelective(po);
	}
	
	/**
	 * 查询彩种信息
	 * @return
	 */
	public List<LotteryTypeBO> findAllLotteryType(){
		return lotteryTypeDaoMapper.findAllLotteryType();
	}

	/**
	 * 查询数字彩和胜负彩
	 * @return
	 */
	public List<LotteryTypeBO> findLFLottery(){
		return lotteryTypeDaoMapper.findLFLottery();
	}
	

	@Override
	public IssueLottBO findIssueByParam(Integer lotteryCode, String issueCode, int issueLastest) {
		return issueDaoMapper.findIssueByParam(lotteryCode, issueCode, issueLastest);
	}



	@Override
	public List<String> cutOffHistoryIssue(Integer lotteryCode, Integer qryCount) {
		return issueDaoMapper.findcutOffHistoryIssue(lotteryCode, qryCount);
	}
}
