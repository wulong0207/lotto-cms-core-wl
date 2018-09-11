package com.hhly.cmscore.cms.remote.service.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.hhly.cmscore.cms.remote.service.IOrderMgrService;
import com.hhly.cmscore.cms.remote.service.ITicketMgrService;
import com.hhly.cmscore.cms.remote.service.status.OperationOrderVisitor;
import com.hhly.cmscore.cms.remote.service.status.UpdateOrderVisitor;
import com.hhly.cmscore.cms.remote.service.status.entity.UpdateStatusBO;
import com.hhly.cmscore.cms.remote.service.status.operate.IOrderOperation;
import com.hhly.cmscore.cms.remote.service.status.operate.OperationOrderEnum;
import com.hhly.cmscore.cms.remote.service.status.operate.OrderOperattion;
import com.hhly.cmscore.persistence.customer.dao.UserIssueLevelDaoMapper;
import com.hhly.cmscore.persistence.order.dao.OrderAddDaoMapper;
import com.hhly.cmscore.persistence.order.dao.OrderFollowedDaoMapper;
import com.hhly.cmscore.persistence.order.dao.OrderInfoDaoMapper;
import com.hhly.cmscore.persistence.order.dao.OrderIssueDaoMapper;
import com.hhly.cmscore.persistence.order.po.OrderIssuePO;
import com.hhly.cmscore.persistence.ordergroup.dao.GroupUserDaoMapper;
import com.hhly.cmscore.persistence.ordergroup.dao.OrderGroupDaoMapper;
import com.hhly.cmscore.rabbitmq.provider.impl.SendMessage;
import com.hhly.persistence.common.Constants;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.bo.ResultBO;
import com.hhly.skeleton.base.common.LotteryEnum.Lottery;
import com.hhly.skeleton.base.common.OrderEnum.OrderStatus;
import com.hhly.skeleton.base.constants.SymbolConstants;
import com.hhly.skeleton.base.exception.ServiceRuntimeException;
import com.hhly.skeleton.base.page.AbstractStatisticsPage;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.page.ISimplePage;
import com.hhly.skeleton.base.status.VisitorHandler;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.base.util.HttpUtil;
import com.hhly.skeleton.base.util.JsonUtil;
import com.hhly.skeleton.base.util.NumberUtil;
import com.hhly.skeleton.base.util.ObjectUtil;
import com.hhly.skeleton.base.util.StringUtil;
import com.hhly.skeleton.cms.base.vo.StringVO;
import com.hhly.skeleton.cms.customermgr.bo.UserIssueLevelBO;
import com.hhly.skeleton.cms.customermgr.vo.UserIssueLevelVO;
import com.hhly.skeleton.cms.ordermgr.bo.GroupUserBO;
import com.hhly.skeleton.cms.ordermgr.bo.GroupUserExcelBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderAddBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderAddContentBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderAddIssueBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderAddUserExcelCmsBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderDetailBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderFollowedBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderFollowedExcelBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderGroupBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderGroupContentBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderGroupContentExcelBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoCmsBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoCmsExcelBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoCmsUserExcelBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoDetailCmsBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderIssueBO;
import com.hhly.skeleton.cms.ordermgr.vo.GroupUserVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderAddCmsVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderAddContentVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderAddIssueVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderFollowedVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderGroupVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderInfoCmsSearchVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderInfoVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderIssueVO;
import com.hhly.skeleton.cms.recommend.bo.RcmdUserCheckBO;
import com.hhly.skeleton.cms.recommend.vo.RcmdUserCheckVO;

@Service("orderMgrService")
public class OrderMgrServiceImpl implements IOrderMgrService {
	
	@Value("${lotto_task_url}")
	private String lottoTaskUrl;
	@Autowired
	private OrderInfoDaoMapper orderInfoDaoMapper;
	/**
	 * 追号计划数据接口
	 */
	@Autowired
	private OrderAddDaoMapper orderAddDaoMapper;
	
	/**
	 * 发单Dao
	 */
	@Autowired
	private OrderIssueDaoMapper orderIssueDaoMapper;
	
	/**
	 * 跟单Dao
	 */
	@Autowired
	private OrderFollowedDaoMapper orderFollowedDaoMapper;
	
	@Autowired
	private UserIssueLevelDaoMapper userIssueLevelDaoMapper;
	
	@Autowired
	private OrderGroupDaoMapper orderGroupMapper;
	
	@Autowired
	private GroupUserDaoMapper groupUserDapMapper;
	
	@Autowired
	private IPageService pageService;
	
	@Autowired
	private ITicketMgrService ticketService;
	
	@Autowired
	private SendMessage sendMessage;

	@Override
	public PagingBO<OrderInfoCmsBO> findOrderInfo(final OrderInfoCmsSearchVO vo) {
		conditionConvert(vo);
		return pageService.getPageData(vo, new AbstractStatisticsPage<OrderInfoCmsBO>() {
			@Override
			public int getTotal() {
				this.setSis(orderInfoDaoMapper.findTotal(vo));
				return NumberUtils.toInt(this.getSis().get("count").toString());
			}

			@Override
			public List<OrderInfoCmsBO> getData() {
				this.setDataList(orderInfoDaoMapper.find(vo));
				return this.getDataList();
			}

			@Override
			public Object getOther() {
				return getSisInfo(this.getSis(), this.getData());
			}
		});
	}

	/**
	 * 查询信息统计
	 * 
	 * @param sisType
	 *            统计类型
	 * @param sis
	 *            统计结果
	 * @param list
	 *            单页数据
	 * @return 数组 0：订单金额，1：税前金额，2：税后金额
	 */
	private String[] getSisInfo(Map<String, Object> sis, List<OrderInfoCmsBO> list) {
		String[] sisInfo = new String[10];
		int orderAmount = 0;
		double aftBonus = 0.0;
		double preBonus = 0.0;
		double addedBonus = 0.0;
		double websiteBonus = 0.0;
		// 单页统计
		for (OrderInfoCmsBO lbo : list) {
			orderAmount += lbo.getOrderAmount();
			if (lbo.getAftBonus() != null) {
				aftBonus = NumberUtil.sum(aftBonus, lbo.getAftBonus());
			}
			if (lbo.getPreBonus() != null) {
				preBonus = NumberUtil.sum(preBonus, lbo.getPreBonus());
			}
			if (lbo.getAddedBonus() != null) {
				addedBonus = NumberUtil.sum(addedBonus, lbo.getAddedBonus());
			}
			if (lbo.getWebsiteBonus() != null) {
				websiteBonus = NumberUtil.sum(websiteBonus, lbo.getWebsiteBonus());
			}
		}
		sisInfo[0] = String.valueOf(orderAmount);
		sisInfo[1] = String.valueOf(preBonus);
		sisInfo[2] = String.valueOf(aftBonus);
		sisInfo[3] = String.valueOf(addedBonus);
		sisInfo[8] = String.valueOf(websiteBonus);

		// 条件统计
		sisInfo[4] = sis.get("orderAmount") == null ? "0" : String.valueOf(sis.get("orderAmount"));
		sisInfo[5] = sis.get("preBonus") == null ? "0.0" : sis.get("preBonus").toString();
		sisInfo[6] = sis.get("aftBonus") == null ? "0.0" : sis.get("aftBonus").toString();
		sisInfo[7] = sis.get("addedbonus") == null ? "0.0" : sis.get("addedbonus").toString();
		sisInfo[9] = sis.get("websiteBonus") == null ? "0.0" : sis.get("websiteBonus").toString();

		return sisInfo;
	}

	/**
	 * 查询条件转换
	 * 
	 * @param vo
	 * @return
	 */
	private void conditionConvert(OrderInfoCmsSearchVO vo) {
		// 时间类型参数转换
		switch (vo.getTimeType()) {
		case "0":
			vo.setTimeType("oi.buy_time");
			break;
		case "1":
			vo.setTimeType("oi.come_out_time");
			break;
		case "3":
			vo.setTimeType("oi.end_ticket_time");
			break;
		case "4":
			vo.setTimeType("oi.LOTTERY_TIME");
			break;
		case "5":
			vo.setTimeType("oi.SEND_TIME");
			break;
		default:
			throw new IllegalArgumentException("参数时间类型错误");
		}
		if (StringUtils.isNotEmpty(vo.getAccountName()) || StringUtils.isNotEmpty(vo.getCusMobile())
				|| StringUtils.isNotEmpty(vo.getNickName())||StringUtils.isNotEmpty(vo.getRegisterChannelId())) {
			vo.setJoinUser("1");
		} else {
			vo.setJoinUser(null);
		}
		// 只有大乐透才有追加
		if (!Objects.equals(String.valueOf(Lottery.DLT.getName()),vo.getLotteryCode())) {
			vo.setDltAdd(null);
		}
		// 需要查询订单详情记录
//		if (vo.getCodeWay() != null || vo.getContentType() != null ) {
//			List<String> orderCodes = orderInfoDaoMapper.findOrderCodeByDetail(vo);
//			if (orderCodes.size() > 0) {
//				vo.setOrderCodes(orderCodes);
//			}
//		}
	}

	@Override
	public OrderInfoDetailCmsBO findOrderInfoDetail(StringVO vo) {
		return orderInfoDaoMapper.findOrderInfoDetail(vo.getStr());
	}

	@Override
	public PagingBO<OrderDetailBO> findOrderDetail(final OrderInfoCmsSearchVO vo) {
		return pageService.getPageData(vo, new ISimplePage<OrderDetailBO>() {
			@Override
			public int getTotal() {
				return orderInfoDaoMapper.findOrderDetailCount(vo);
			}

			@Override
			public List<OrderDetailBO> getData() {
				return orderInfoDaoMapper.findOrderDetail(vo);
			}
		});

	}

	@Override
	public int updOrderInfo(OrderInfoVO vo) {
		return orderInfoDaoMapper.updOrderInfo(vo);
	}

	@Override
	public List<OrderInfoCmsExcelBO> getOrderInfoExcel(OrderInfoCmsSearchVO vo) {
		conditionConvert(vo);
		//去掉导出条数限制
//		Map<String, Object> sis = orderInfoDaoMapper.findTotal(vo);
//		int num = NumberUtils.toInt(sis.get("count").toString());		
//		Assert.isTrue(num <= Constants.EXCEL_NUM, Constants.EXCEL_ERROR_MSG);
		return orderInfoDaoMapper.getOrderInfoExcel(vo);
	}

	@Override
	public List<OrderInfoCmsUserExcelBO> getOrderInfoUserExcel(OrderInfoCmsSearchVO vo) {
		conditionConvert(vo);
		Map<String, Object> sis = orderInfoDaoMapper.findTotal(vo);
		int num = NumberUtils.toInt(sis.get("count").toString());
		Assert.isTrue(num <= Constants.EXCEL_NUM, Constants.EXCEL_ERROR_MSG);
		return orderInfoDaoMapper.getOrderInfoUserExcel(vo);
	}

	/*@Override
	public String getOrderNo(String name) {
		// 验证
		NumberCode num = Enum.valueOf(NumberCode.class, name);
		Map<String, String> param = new HashMap<String, String>();
		param.put("code", num.getCode());
		param.put("out", "");
		orderInfoDaoMapper.getOrderNo(param);
		return param.get("out");
	}*/

	/*************************************** 追号计划相关 **********************************************/
	@Override
	public PagingBO<OrderAddBO> findPagingOrderAdd(final OrderAddCmsVO orderAddCms) {
		conditionConvert(orderAddCms);// 部分条件转换
		return pageService.getPageData(orderAddCms, new AbstractStatisticsPage<OrderAddBO>() {
			@Override
			public int getTotal() {
				this.setSis(orderAddDaoMapper.findCountOrderAdd(orderAddCms));
				return Integer.parseInt(this.getSis().get("count").toString());
			}

			@Override
			public List<OrderAddBO> getData() {
				this.setDataList(orderAddDaoMapper.findPagingOrderAdd(orderAddCms));
				return this.getDataList();
			}

			@Override
			public Object getOther() {
				List<OrderAddBO> data = Integer.parseInt(this.getSis().get("count").toString()) > Constants.NUM_0 ? this.getDataList()
						: Collections.<OrderAddBO> emptyList();
				return getSisInfoOrderAdd(this.getSis(), data);
			}
		});
	}

	@Override
	public OrderAddBO findSingleOrderAdd(OrderAddCmsVO orderAddCms) {
		return orderAddDaoMapper.findSingleOrderAdd(orderAddCms);
	}

	@Override
	public List<OrderAddBO> findExcelOrderAdd(OrderAddCmsVO orderAddCms) {
		conditionConvert(orderAddCms);// 部分条件转换
		Map<String, Object> sis = orderAddDaoMapper.findCountOrderAdd(orderAddCms);
		int num = NumberUtils.toInt(sis.get("count").toString());
		Assert.isTrue(num <= Constants.EXCEL_NUM, Constants.EXCEL_ERROR_MSG);
		return orderAddDaoMapper.findExcelOrderAdd(orderAddCms);
	}
	
	@Override
	public List<OrderAddUserExcelCmsBO> findExcelOrderAddUser(OrderAddCmsVO orderAddCms) {
		conditionConvert(orderAddCms);// 部分条件转换
		Map<String, Object> sis = orderAddDaoMapper.findCountOrderAdd(orderAddCms);
		int num = NumberUtils.toInt(sis.get("count").toString());
		Assert.isTrue(num <= Constants.EXCEL_NUM, Constants.EXCEL_ERROR_MSG);
		return orderAddDaoMapper.findExcelOrderAddUser(orderAddCms);
	}

	@Override
	public PagingBO<OrderAddContentBO> findPagingOrderAddContent(final OrderAddContentVO orderAddContent) {
		return pageService.getPageData(orderAddContent, new ISimplePage<OrderAddContentBO>() {

			@Override
			public int getTotal() {
				return orderAddDaoMapper.findCountOrderAddContent(orderAddContent);
			}

			@Override
			public List<OrderAddContentBO> getData() {
				return orderAddDaoMapper.findPagingOrderAddContent(orderAddContent);
			}
		});
	}

	@Override
	public PagingBO<OrderAddIssueBO> findPagingOrderAddIssue(final OrderAddIssueVO orderAddIssue) {
		return pageService.getPageData(orderAddIssue, new ISimplePage<OrderAddIssueBO>() {

			@Override
			public int getTotal() {
				return orderAddDaoMapper.findCountOrderAddIssue(orderAddIssue);
			}

			@Override
			public List<OrderAddIssueBO> getData() {
				return orderAddDaoMapper.findPagingOrderAddIssue(orderAddIssue);
			}
		});
	}

	/**
	 * @param orderAddCms
	 *            追号对象参数
	 * @Desc 条件转换
	 */
	private void conditionConvert(OrderAddCmsVO orderAddCms) {
		// 时间查询类型
		if (orderAddCms.getTimeType() != null) {
			switch (orderAddCms.getTimeType()) {
			case Constants.NUM_1:
				orderAddCms.setTimeTypeField("oa.buy_time");
				break;
			case Constants.NUM_2:
				orderAddCms.setTimeTypeField("oa.end_time");
				break;
			default:
				orderAddCms.setTimeTypeField("oa.buy_time"); // 不存在则默认购买时间
			}
		}
		// 如果指定了是否关联用户表，则不用继续后面的判断
		if (orderAddCms.getJoinUser() != null) {
			return;
		}
		// 是否关联用户表
		if (orderAddCms.getUser() == null) {
			orderAddCms.setJoinUser(false);
			return;
		}
		if (StringUtils.isNotEmpty(orderAddCms.getUser().getNickName())
				|| StringUtils.isNotEmpty(orderAddCms.getUser().getAccountName())
				|| orderAddCms.getUser().getCusMobile() != null
				|| StringUtils.isNotEmpty(orderAddCms.getUser().getActualName())
				|| StringUtils.isNotEmpty(orderAddCms.getUser().getIdNum())
				|| StringUtils.isNotEmpty(orderAddCms.getUser().getCusMail())
				|| orderAddCms.getUser().getId() != null) {
			orderAddCms.setJoinUser(true);
		}
	}
	/**
	 * @param sis 统计结果(按条件查询的统计结果)
	 * @param list 单页数据
	 * @return 追号计划的统计信息
	 * @Desc 封装追号计划的统计信息
	 */
	private String[] getSisInfoOrderAdd(Map<String, Object> sis, List<OrderAddBO> list) {
		String[] sisInfo = new String[6];
		double totalAddAmount = 0;
		double totalPreBonus = 0;
		double totalAftBonus = 0;
		// 单页统计
		if (list != null && !list.isEmpty()) {
			for (OrderAddBO temp : list) {
				if (temp.getAddAmount() != null) {
					totalAddAmount = NumberUtil.sum(totalAddAmount, temp.getAddAmount());
				}
				if (temp.getPreBonus() != null) {
					totalPreBonus = NumberUtil.sum(totalPreBonus, temp.getPreBonus());
				}
				if (temp.getAftBonus() != null) {
					totalAftBonus = NumberUtil.sum(totalAftBonus, temp.getAftBonus());
				}
			}
		}
		sisInfo[0] = String.valueOf(totalAddAmount);
		sisInfo[1] = String.valueOf(totalPreBonus);
		sisInfo[2] = String.valueOf(totalAftBonus);

		// 条件统计
		sisInfo[3] = sis.get("totalAddAmount") == null ? "0" : String.valueOf(sis.get("totalAddAmount"));
		sisInfo[4] = sis.get("totalPreBonus") == null ? "0" : String.valueOf(sis.get("totalPreBonus"));
		sisInfo[5] = sis.get("totalAftBonus") == null ? "0" : String.valueOf(sis.get("totalAftBonus"));

		return sisInfo;
	}

	/*@Override
	public int updOrderAddIssueStatusByIds(String ids) {
		return orderAddDaoMapper.updOrderAddIssueStatusByIds(Arrays.asList(ids.split(SymbolConstants.COMMA)));
	}*/

	@Override
	public List<OrderAddIssueBO> findExcelOrderAddIssue(OrderAddIssueVO orderAddIssue) {
		int num = orderAddDaoMapper.findCountOrderAddIssue(orderAddIssue);
		Assert.isTrue(num <= Constants.EXCEL_NUM, Constants.EXCEL_ERROR_MSG);
		return orderAddDaoMapper.findExcelOrderAddIssue(orderAddIssue);
	}
	/****************************** 派奖管理相关接口 *********************************/
	@Override
	public PagingBO<OrderInfoCmsBO> findPagingSendPrize(final OrderInfoCmsSearchVO orderInfoCmsSearch) {
		conditionConvertSendPrize(orderInfoCmsSearch);// 部分条件转换
		return pageService.getPageData(orderInfoCmsSearch, new AbstractStatisticsPage<OrderInfoCmsBO>() {
			@Override
			public int getTotal() {
				this.setSis(orderInfoDaoMapper.findCountSendPrize(orderInfoCmsSearch));
				return Integer.parseInt(this.getSis().get("count").toString());
			}
			@Override
			public List<OrderInfoCmsBO> getData() {
				this.setDataList(orderInfoDaoMapper.findPagingSendPrize(orderInfoCmsSearch));
				return this.getDataList();
			}
			@Override
			public Object getOther() {
				List<OrderInfoCmsBO> data = Integer.parseInt(this.getSis().get("count").toString()) > Constants.NUM_0 ? this.getDataList()
						: Collections.<OrderInfoCmsBO> emptyList();
				return getSisInfoSendPrize(this.getSis(), data);
			}
		});
	}

	@Override
	public List<OrderInfoCmsBO> findExcelSendPrize(OrderInfoCmsSearchVO orderInfoCmsSearch) {
		conditionConvertSendPrize(orderInfoCmsSearch);// 部分条件转换
		Map<String, Object> sis = orderInfoDaoMapper.findCountSendPrize(orderInfoCmsSearch);
		int num = NumberUtils.toInt(sis.get("count").toString());
		Assert.isTrue(num <= Constants.EXCEL_NUM, Constants.EXCEL_ERROR_MSG);
		return orderInfoDaoMapper.findExcelSendPrize(orderInfoCmsSearch);
	}

	/**
	 * @desc 部分条件转换（如：各种用户查询类型，各种时间查询类型）
	 * @author huangb
	 * @date 2017年2月12日
	 * @param orderInfoCmsSearch  参数对象
	 */
	private void conditionConvertSendPrize(OrderInfoCmsSearchVO orderInfoCmsSearch) {
		// 时间类型查询参数转换(0-购买时间,1-出票时间,3-截止出票时间,4-开奖时间,5-派奖时间)
		if (!StringUtil.isBlank(orderInfoCmsSearch.getTimeType())) {
			switch (Integer.valueOf(orderInfoCmsSearch.getTimeType())) {
			case Constants.NUM_0:
				orderInfoCmsSearch.setTimeType("oi.buy_time");
				break;
			case Constants.NUM_1:
				orderInfoCmsSearch.setTimeType("oi.come_out_time");
				break;
			case Constants.NUM_3:
				orderInfoCmsSearch.setTimeType("oi.end_ticket_time");
				break;
			case Constants.NUM_4:
				orderInfoCmsSearch.setTimeType("oi.LOTTERY_TIME");
				break;
			case Constants.NUM_5:
				orderInfoCmsSearch.setTimeType("oi.SEND_TIME");
				break;
			default:
				throw new IllegalArgumentException("参数时间类型错误");
			}
		}
	}
	
	/**
	 * @desc 派奖查询的统计信息
	 * @author huangb
	 * @date 2017年2月12日
	 * @param sis 统计结果(按条件查询的统计结果)
	 * @param list 单页数据
	 * @return 派奖查询的统计信息
	 */
	private String[] getSisInfoSendPrize(Map<String, Object> sis, List<OrderInfoCmsBO> list) {

		String[] sisInfo = new String[12];
		double totalOrderAmount = 0;
		double totalPreBonus = 0;
		double totalAftBonus = 0;
		double totalSendBonus = 0;
		double totalAddedBonus = 0;
		double totalWebsiteBonus = 0;
		// 单页统计
		if (list != null && !list.isEmpty()) {
			for (OrderInfoCmsBO temp : list) {
				if (temp.getOrderAmount() != null) {
					totalOrderAmount = NumberUtil.sum(totalOrderAmount, temp.getOrderAmount());
				}
				if (temp.getPreBonus() != null) {
					totalPreBonus = NumberUtil.sum(totalPreBonus, temp.getPreBonus());
				}
				if (temp.getAftBonus() != null) {
					totalAftBonus = NumberUtil.sum(totalAftBonus, temp.getAftBonus());
				}
				if (temp.getSendBonus() != null) {
					totalSendBonus = NumberUtil.sum(totalSendBonus, temp.getSendBonus());
				}
				if (temp.getAddedBonus() != null) {
					totalAddedBonus = NumberUtil.sum(totalAddedBonus, temp.getAddedBonus());
				}
				if (temp.getWebsiteBonus() != null) {
					totalWebsiteBonus = NumberUtil.sum(totalWebsiteBonus, temp.getWebsiteBonus());
				}
			}
		}
		sisInfo[0] = String.valueOf(totalOrderAmount);
		sisInfo[1] = String.valueOf(totalPreBonus);
		sisInfo[2] = String.valueOf(totalAftBonus);
		sisInfo[3] = String.valueOf(totalSendBonus);
		sisInfo[8] = String.valueOf(totalAddedBonus);
		sisInfo[9] = String.valueOf(totalWebsiteBonus);

		// 条件统计
		sisInfo[4] = sis.get("totalOrderAmount") == null ? "0" : String.valueOf(sis.get("totalOrderAmount"));
		sisInfo[5] = sis.get("totalPreBonus") == null ? "0" : String.valueOf(sis.get("totalPreBonus"));
		sisInfo[6] = sis.get("totalAftBonus") == null ? "0" : String.valueOf(sis.get("totalAftBonus"));
		sisInfo[7] = sis.get("totalSendBonus") == null ? "0" : String.valueOf(sis.get("totalSendBonus"));
		sisInfo[10] = sis.get("totalAddedBonus") == null ? "0" : String.valueOf(sis.get("totalAddedBonus"));
		sisInfo[11] = sis.get("totalWebsiteBonus") == null ? "0" : String.valueOf(sis.get("totalWebsiteBonus"));

		return sisInfo;
	}
	/****************************** 派奖管理相关接口 *********************************/

    @Override
    public OrderInfoCmsBO getMonitorOrderInfo(int lotteryCode,
            String lotteryIssue) {
        return orderInfoDaoMapper.getMonitorOrderInfo(lotteryCode,lotteryIssue);
    }

	@Override
	public int updateOrderStatus(OrderInfoVO vo) {
		List<UpdateStatusBO> pos = checkOrderCode(vo.getOrderCode());
		//判断可以修改状态的订单
		List<Integer> ids = new ArrayList<>();
		UpdateOrderVisitor visitor = new UpdateOrderVisitor(ticketService);
		List<String> orders = new ArrayList<>();
		for (UpdateStatusBO po : pos) {
			Boolean can = VisitorHandler.disboseOrderStatus(po.getOrderStatus(),po,vo.getOrderStatus().intValue(), visitor);
			if(can){
				ids.add(po.getId());
				if(vo.getOrderStatus().shortValue() == OrderStatus.FAILING_TICKET.getValue()){
				   orders.add(po.getOrderCode());
				}
			}
		}
		if(ids.size() > 0){
			sendMessage.sendOutTicketFail(orders);
			return orderInfoDaoMapper.updateOrderStatus(ids,vo.getOrderStatus(),vo.getModifyBy());
		}
		return 0;
	}
	/**
	 * 检查订单是否正确
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年3月15日 下午4:46:55
	 * @param orders 用“，”号隔开
	 * @return
	 */
	private List<UpdateStatusBO> checkOrderCode(String orders) {
		//拆分订单
		String [] orderCodes = org.springframework.util.StringUtils.tokenizeToStringArray(orders, SymbolConstants.COMMA);
		if(ObjectUtil.isBlank(orderCodes)){
			throw new ServiceRuntimeException("订单不能空");
		}
		//查询订单数
		List<UpdateStatusBO> pos =  orderInfoDaoMapper.listOrderInfoStatus(Arrays.asList(orderCodes));
		if(pos.size() != orderCodes.length){
			throw new ServiceRuntimeException("修改订单与系统订单不匹配");
		}
		return pos;
	}

	@Override
	public String updateOrderOperate(OrderInfoVO vo) {
		OperationOrderEnum oe = OperationOrderEnum.values()[vo.getOperate()];	
		Assert.notNull(oe,"订单操作类型错误");
		List<UpdateStatusBO> pos = checkOrderCode(vo.getOrderCode());
		IOrderOperation operation = new OrderOperattion(orderInfoDaoMapper,vo.getModifyBy());
		OperationOrderVisitor visitor = new OperationOrderVisitor(operation);
		for (UpdateStatusBO po : pos) {
			VisitorHandler.disboseOrderStatus(po.getOrderStatus(),po,oe, visitor);
		}
		return SymbolConstants.ENPTY_STRING;
	}

	@Override
	public int updTicketAndCheckTime(Map<String, Object> param) {
		return orderInfoDaoMapper.updTicketAndCheckTime(param);
	}

	@Override
	public int updCancelOrderRemark(String orderCode, String remark) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("orderCode", orderCode);
		param.put("remark", remark);		
		return orderInfoDaoMapper.updCancelOrderRemark(param);
	}

	/****************************** 发单、抄单管理相关接口 *********************************/
	@Override
	public PagingBO<OrderIssueBO> pageOrderIssue(final OrderIssueVO vo) {
		// 最新发布的在最前面
		vo.setSortField("orderInfo.buy_time");
		vo.setSortOrder("desc");
		// 因为datagrid要显示彩种、用户昵称，所以一定要join表order_info、m_user_info
		vo.setJoinOrder(true);
		vo.setJoinUserIssue(true);
		vo.setJoinUser(true);
		// 如果有按'跟单编号查询'，则联order_followed_info
		if(StringUtil.hasText(vo.getFollowOrderCode())) {
			vo.setJoinOrderFollowedInfo(true);
		}
		return pageService.getPageData(vo, new ISimplePage<OrderIssueBO>() {
			@Override
			public int getTotal() {
				return orderIssueDaoMapper.count(vo);
			}
			@Override
			public List<OrderIssueBO> getData() {
				return processUserIssueLevel(orderIssueDaoMapper.list(vo));
			}
		});
	}

	private List<OrderIssueBO> processUserIssueLevel(List<OrderIssueBO> orders) {
		// 处理用户标识
		// 2017-10-11 跟刘琼确定，只要m_user_issue_level表中1条或以上的"专家"记录，则为专家，否则为"用户"
		// 中奖金额是税后的
		// 需要查询level的用户
		Set<Integer> userIssueIds = new HashSet<>();
		for(OrderIssueBO order : orders) {
			userIssueIds.add(order.getUserIssueId());
		}
		UserIssueLevelVO vo = new UserIssueLevelVO();
		vo.setUserIssueInfoIds(userIssueIds);
		// 0：普通用户,1:专家
		vo.setLevel(1);
		List<UserIssueLevelBO> userLevels = userIssueLevelDaoMapper.find(vo);
		Set<Integer> professorIds = new HashSet<>();
		// order_issue_info表的user_issue_id即为发单用户表(m_user_issue_info)的主键ID
		// m_user_issue_level的user_issue_info_id即为m_user_issue_info的id
		for(UserIssueLevelBO userLevel : userLevels) {
			professorIds.add(userLevel.getUserIssueInfoId());
		}
		for(OrderIssueBO order : orders) {
			// 用户等级,0：普通用户,1:专家
			order.setLevel(professorIds.contains(order.getUserIssueId()) ? 1 : 0);
		}
		return orders;
	}
	
	@Override
	public List<OrderIssueBO> listOrderIssue(OrderIssueVO vo) {
		return orderIssueDaoMapper.list(vo);
	}

	@Override
	public int updateOrderIssue(OrderIssueVO vo) {
		Date now = new Date();
		vo.setModifyTime(now);
		vo.setUpdateTime(now);
		OrderIssuePO po = new OrderIssuePO(vo);
		Assert.notNull(po.getId(), "========》更新发单信息时id为空，参数为"+po);
		return orderIssueDaoMapper.update(po);
	}

	@Override
	public List<OrderFollowedBO> listOrderFollowed(OrderFollowedVO vo) {
		return orderFollowedDaoMapper.list(vo);
	}
	
	@Override
	public List<OrderFollowedExcelBO> listOrderFollowedExcel(OrderFollowedVO vo) {
		return orderFollowedDaoMapper.excel(vo);
	}

	@Override
	public PagingBO<OrderFollowedBO> pageOrderFollowed(final OrderFollowedVO vo) {
		// 因为datagrid要用户账户、税前奖金，所以一定要join表order_info、m_user_info
		vo.setJoinOrder(true);
		vo.setJoinUser(true);
		return pageService.getPageData(vo, new ISimplePage<OrderFollowedBO>() {
			@Override
			public int getTotal() {
				return orderFollowedDaoMapper.count(vo);
			}
			@Override
			public List<OrderFollowedBO> getData() {
				return orderFollowedDaoMapper.list(vo);
			}
		});
	}
	/****************************** 发单、抄单管理相关接口 *********************************/
	
	
	/****************************** 合买接口 *********************************/
	@Override
	public PagingBO<OrderGroupBO> findGroup(final OrderGroupVO vo) {
		return pageService.getPageData(vo, new ISimplePage<OrderGroupBO>(){
			@Override
			public int getTotal() {
				return orderInfoDaoMapper.findGroupTotal(vo);
			}
			@Override
			public List<OrderGroupBO> getData() {
				return orderInfoDaoMapper.findGroup(vo);
			}
		});
	}

	@Override
	public PagingBO<OrderGroupContentBO> findGroupContent(final OrderGroupVO vo) {
		return pageService.getPageData(vo, new ISimplePage<OrderGroupContentBO>() {
			@Override
			public int getTotal() {
				return orderInfoDaoMapper.findGroupContentTotal(vo);
			}
			@Override
			public List<OrderGroupContentBO> getData() {
				return orderInfoDaoMapper.findGroupContent(vo);
			}
		});
	}

	@Override
	public OrderGroupBO findGroupById(Integer id) {
		return orderInfoDaoMapper.findGroupById(id);
	}

	@Override
	public int update(OrderGroupVO vo) {
		return orderInfoDaoMapper.update(vo);
	}

	@Override
	public List<OrderGroupContentExcelBO> findGroupUserExcel(OrderGroupVO vo) {
		return orderInfoDaoMapper.excelGroupContent(vo);
	}

	@Override
	public ResultBO<?> recommand(OrderGroupVO vo) {
		try {
			orderGroupMapper.updateRecommand(vo);
		} catch (Exception e) {
			return ResultBO.err(e.getMessage());
		}
		return ResultBO.ok();
	}

	@Override
	public ResultBO<?> top(OrderGroupVO vo) {
		try {
			orderGroupMapper.top(vo);
		} catch (Exception e) {
			return ResultBO.err(e.getMessage());
		}
		return ResultBO.ok();
	}


	//手动触发保底动作
	@Override
	public ResultBO<?> siteGuarantee(Integer groupId) {
		if(groupId!=null){
			Map<String,String> paramMap = new HashMap<>();
			paramMap.put("groupId", groupId+"");
			String result=null;
			try {
				String siteGuaranteeUrl = lottoTaskUrl+"order/siteGuarantee";
				result = HttpUtil.doPost(siteGuaranteeUrl, paramMap);
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
				return ResultBO.err("45111");
			}
			ResultBO<?> resultBO = (ResultBO<?>) JsonUtil.json2Object(result, ResultBO.class);
			return resultBO;
		}else{
			return ResultBO.err("40441");
		}
		
	}
	
	@Override
	public String getAwardInfo(OrderInfoCmsSearchVO orderInfoCmsSearch) {
		int lotteryCode = Integer.parseInt(orderInfoCmsSearch.getLotteryCode());
		if(isSport(lotteryCode)){
			orderInfoCmsSearch.setIssues(getIssue());
		}
		List<OrderInfoCmsBO> orders = orderInfoDaoMapper.findAwardInfo(orderInfoCmsSearch);
		for (OrderInfoCmsBO orderInfoCmsBO : orders) {
			if(orderInfoCmsBO == null){
				continue;
			}
			double addMoney = 0;
			if(orderInfoCmsBO.getAddedBonus() != null){
				addMoney += orderInfoCmsBO.getAddedBonus();
			}
			if(orderInfoCmsBO.getWebsiteBonus() != null){
				addMoney += orderInfoCmsBO.getWebsiteBonus();
			}
			if(orderInfoCmsBO.getAftBonus() == null){
				continue;
			}
			if(addMoney/orderInfoCmsBO.getAftBonus() > 0.3){
				return "1";
			}
			if(addMoney + orderInfoCmsBO.getAftBonus() > 10000){
				return "1";
			}
		}
		return "0";
	}
	
	public static  boolean isSport(int lotteryCode){
		return lotteryCode == Lottery.FB.getName() || lotteryCode == Lottery.BB.getName();
	}
	
	private List<String> getIssue() {
		Date now = new Date();
		List<String> issue = new ArrayList<>();
		for (int i = 0; i > -10; i--) {
			issue.add(DateUtil.convertDateToStr(DateUtil.addDay(now, i), DateUtil.FORMAT_YYMMDD));
		}
		return issue;
	}

	@Override
	public PagingBO<GroupUserBO> findGroupUser(GroupUserVO vo) {
		return pageService.getPageData(vo, new ISimplePage<GroupUserBO>() {
			@Override
			public int getTotal() {
				return groupUserDapMapper.findGroupUserTotal(vo);
			}
			@Override
			public List<GroupUserBO> getData() {
				return groupUserDapMapper.findGroupUser(vo);
			}
		});
	}

	@Override
	public List<GroupUserExcelBO> exprotGroupUserExcel(GroupUserVO vo) {
		return groupUserDapMapper.exprotGroupUserExcel(vo);
	}

	@Override
	public void updateRecommand(GroupUserVO vo) {
		groupUserDapMapper.updateRecommand(vo);
	}

	@Override
	public void updateUserFlag(GroupUserVO vo) {
		groupUserDapMapper.updateUserFlag(vo);
	}

	@Override
	public PagingBO<RcmdUserCheckBO> findRcmdUserCheckList(RcmdUserCheckVO vo) {
		return pageService.getPageData(vo, new ISimplePage<RcmdUserCheckBO>() {
			@Override
			public int getTotal() {
				return orderFollowedDaoMapper.findRcmdUserCheckCount(vo);
			}
			@Override
			public List<RcmdUserCheckBO> getData() {
				return orderFollowedDaoMapper.findRcmdUserCheckList(vo);
			}
		});
	}

	@Override
	public int setStatus(RcmdUserCheckVO vo) {
		return orderFollowedDaoMapper.setStatus(vo);
	}

	@Override
	public int addRcmdUser(RcmdUserCheckVO vo) {
		return orderFollowedDaoMapper.addRcmdUser(vo);
	}
}
