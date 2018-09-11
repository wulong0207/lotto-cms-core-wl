package com.hhly.cmscore.persistence.order.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.cms.remote.service.status.entity.UpdateStatusBO;
import com.hhly.cmscore.persistence.order.po.OrderDetailPO;
import com.hhly.cmscore.persistence.order.po.OrderInfoPO;
import com.hhly.skeleton.cms.agent.bo.AgentOrderInfoBO;
import com.hhly.skeleton.cms.agent.vo.AgentQueryVO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderDetailBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderGroupBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderGroupContentBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderGroupContentExcelBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoCmsBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoCmsExcelBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoCmsUserExcelBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoDetailCmsBO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderGroupVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderInfoCmsSearchVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderInfoVO;
import com.hhly.skeleton.lotto.base.order.bo.OrderBaseInfoBO;
import com.hhly.skeleton.lotto.base.order.bo.OrderDetailInfoBO;
import com.hhly.skeleton.lotto.base.order.bo.OrderInfoBO;
import com.hhly.skeleton.lotto.base.order.bo.OrderInfoDetailLimitBO;
import com.hhly.skeleton.lotto.base.order.bo.OrderInfoLimitBO;
import com.hhly.skeleton.lotto.base.order.bo.OrderStatisBO;
import com.hhly.skeleton.lotto.base.order.bo.OrderStatisticsInfoBO;
import com.hhly.skeleton.lotto.base.order.bo.UserNumOrderDetailBO;
import com.hhly.skeleton.lotto.base.order.bo.UserSportOrderDetailBO;
import com.hhly.skeleton.lotto.base.order.bo.UserWinInfoBO;
import com.hhly.skeleton.lotto.base.order.bo.WinBO;
import com.hhly.skeleton.lotto.base.order.vo.ActivityOrderQueryInfoVO;
import com.hhly.skeleton.lotto.base.order.vo.OrderDetailVO;
import com.hhly.skeleton.lotto.base.order.vo.OrderInfoQueryVO;
import com.hhly.skeleton.lotto.base.order.vo.OrderQueryVo;
import com.hhly.skeleton.lotto.base.order.vo.OrderStatisticsQueryVo;
import com.hhly.skeleton.lotto.base.order.vo.UserNumOrderDetailQueryVO;
import com.hhly.skeleton.lotto.base.order.vo.UserSportOrderDetailQueryVO;
import com.hhly.skeleton.lotto.base.order.vo.WinVO;

/**
 * @author huangb
 *
 * @Date 2016年11月30日
 *
 * @Desc 订单处理数据接口
 */
public interface OrderInfoDaoMapper {
	
	/**************************** Used to LOTTO ******************************/
	
	/**
	 * @param orderInfo
	 *            订单信息
	 * @return
	 * @throws Exception
	 * @Desc 添加订单信息
	 */
	int addOrder(OrderInfoPO orderInfo);

	/**
	 * @param orderDetails
	 *            订单明细
	 * @return
	 * @throws Exception
	 * @Desc 添加订单明细
	 */
	int addOrderDetail(@Param("list")List<OrderDetailPO> orderDetails);

	int addSingleOrderDetail(OrderDetailPO orderDetail);

	/**
	 * @desc 前端接口：用户中心-查询用户方案明细列表(分页查询-一个方案对应多个明细)
	 * @author huangb
	 * @date 2017年4月11日
	 * @param queryVO
	 *            查询对象
	 * @return 前端接口：用户中心-查询用户方案明细列表(分页查询-一个方案对应多个明细)
	 */
	List<UserNumOrderDetailBO> findPagingUserOrderDetail(UserNumOrderDetailQueryVO queryVO);
	
	/**
	 * @desc 前端接口：用户中心-查询用户方案明细列表数量(一个方案对应的明细数量)
	 * @author huangb
	 * @date 2017年4月11日
	 * @param queryVO
	 *            查询对象
	 * @return 前端接口：用户中心-查询用户方案明细列表数量(一个方案对应的明细数量)
	 */
	int findCountUserOrderDetail(UserNumOrderDetailQueryVO queryVO);
	
	/**
	 * 前端接口: 用户中心- 查询用户竞技彩方案明细列表数据
	 * @param queryVO
	 * @return
	 * @date 2017年7月21日下午5:54:46
	 * @author cheng.chen
	 */
	int findCountUserSportOrderDetail(UserSportOrderDetailQueryVO queryVO);
	
	
	/**
	 * @desc 前端接口：用户中心-查询用户竞技彩方案明细列表(分页查询-一个方案对应多个明细)
	 * @param queryVO
	 * @return
	 * @date 2017年7月21日下午5:54:46
	 * @author cheng.chen
	 */
	List<UserSportOrderDetailBO> findPagingUserSportOrderDetail(UserSportOrderDetailQueryVO queryVO);
	
	/**
	 * @desc   查询中信息
	 * @author Tony Wang
	 * @create 2017年8月12日
	 * @param win
	 * @return 
	 */
	List<WinBO> findWinInfo(WinVO win);
	
	
	/**************************** Used to CMS ******************************/
	/**
	 * 修改检票时间
	 * 
	 * @param endCheckTime
	 * @param lotteryCode
	 * @param issueCode
	 * @return
	 */
	int updEndCheckTime(@Param("endCheckTime") Integer endCheckTime, @Param("lotteryCode") Integer lotteryCode,
			@Param("issueCode") String issueCode);

	/**
	 * 分页查询
	 * @param vo
	 * @return
	 */
	List<OrderInfoCmsBO> find(OrderInfoCmsSearchVO vo);
    
	/**
	 * 分页查询总条数
	 * @param vo
	 * @return
	 */
	Map<String, Object> findTotal(OrderInfoCmsSearchVO vo);
    /**
     * 通过订单详情查询订单编号，
     * @param vo
     * @return
     */
	List<String> findOrderCodeByDetail(OrderInfoCmsSearchVO vo);
    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
	OrderInfoDetailCmsBO findOrderInfoDetail(@Param("orderCode")String orderCode);
	/**
	 * 
	 * @param vo
	 * @return
	 */
	List<OrderDetailBO> findOrderDetail(OrderInfoCmsSearchVO vo);
	/**
	 * 
	 * @param vo
	 * @return
	 */
	int findOrderDetailCount(OrderInfoCmsSearchVO vo);
    /**
     * 修改订单状态
     * @param vo
     * @return
     */
	int updOrderInfo(OrderInfoVO vo);
    /**
     * 导出数据导excel
     * @param vo
     * @return
     */
	List<OrderInfoCmsExcelBO> getOrderInfoExcel(OrderInfoCmsSearchVO vo);
	/**
     * 导出订单用户数据
     * @param vo
     * @return
     */
	List<OrderInfoCmsUserExcelBO> getOrderInfoUserExcel(OrderInfoCmsSearchVO vo);

	/** use to CMS 线程重启功能 **/
	int updTicketAndCheckTime(Map<String, Object> param);
	
	/****************************** 派奖管理相关接口 *********************************/
	/**
	 * @desc 分页查询
	 * @author huangb
	 * @date 2017年2月11日
	 * @param orderInfoCmsSearch
	 *            参数对象
	 * @return 分页查询列表
	 */
	List<OrderInfoCmsBO> findPagingSendPrize(OrderInfoCmsSearchVO orderInfoCmsSearch);

	/**
	 * @desc 分页查询记录数
	 * @author huangb
	 * @date 2017年2月11日
	 * @param orderInfoCmsSearch
	 *            参数对象
	 * @return 分页查询记录数
	 */
	Map<String, Object> findCountSendPrize(OrderInfoCmsSearchVO orderInfoCmsSearch);

	/**
	 * @desc excel导出查询
	 * @author huangb
	 * @date 2017年2月11日
	 * @param orderInfoCmsSearch
	 *            参数对象
	 * @return excel导出查询列表
	 */
	List<OrderInfoCmsBO> findExcelSendPrize(OrderInfoCmsSearchVO orderInfoCmsSearch);
	/****************************** 派奖管理相关接口 *********************************/
    /**
     * 监控出票订单统计
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-20 下午3:48:30
     * @param lotteryCode
     * @param lotteryIssue
     * @return
     */
    OrderInfoCmsBO getMonitorOrderInfo(@Param("lotteryCode")int lotteryCode, @Param("lotteryIssue")String lotteryIssue);
    /**
     * 查询订单状态
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017年3月13日 下午5:36:44
     * @param orderCodes
     * @return
     */
	List<UpdateStatusBO> listOrderInfoStatus(@Param("orderCodes")List<String> orderCodes);
    /**
     * 批量修改订单状态
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017年3月14日 下午3:23:28
     * @param ids
     * @param orderStatus
     * @return
     */
	int updateOrderStatus(@Param("ids")List<Integer> ids,@Param("orderStatus")Short orderStatus,@Param("modifyBy")String modifyBy);
    /*******************************订单列表，详情相关接口*****************/
	/**
	 * 查询订单列表
	 * @param orderQueryVo
	 * @return
	 */
	List<OrderBaseInfoBO> queryOrderListInfo(OrderQueryVo orderQueryVo);

	/**
	 * 抄单列表
	 *
	 * @param orderQueryVo
	 * @return
	 */
	List<OrderBaseInfoBO> querySingleCopyOrderList(OrderQueryVo orderQueryVo);

	/**
	 * 查询用户下载文件url
	 * @param orderCode 订单编号
	 * @return
	 */
	String queryUserDownloadFileUrl(String orderCode);

	/**
	 * 查询订单列表总数
	 * @param orderQueryVo
	 * @return
	 */
	Integer queryOrderListInfoCount(OrderQueryVo orderQueryVo);

	/**
	 * 抄单列表条数
	 *
	 * @param orderQueryVo
	 * @return
	 */
	Integer querySingleCopyOrderListCount(OrderQueryVo orderQueryVo);
	/**
	 * 修改订单检票状态
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年3月16日 下午2:19:44
	 * @param id
	 * @param status
	 * @param modifyBy
	 * @return
	 */
	int updateCheckTicket(@Param("id")int id,@Param("status")int status,@Param("modifyBy")String modifyBy);

	/**
	 * 修改订单状态
	 * @param payStatus
	 * @param orderCode
	 * @param userId
	 */
	void updateSingleOrderStatus(@Param("payStatus")Integer payStatus,@Param("orderCode")String orderCode,@Param("userId")Integer userId);

	/**
	 * 查询订单详情
	 * @param orderDetailVO
	 * @return
	 */
	List<OrderDetailInfoBO> queryOrderDetailInfo(OrderDetailVO orderDetailVO);

	/**
	 * 查询单式上传订单详情
	 * @param orderDetailVO
	 * @return
	 */
	List<OrderDetailInfoBO> querySingleUploadDetailInfo(OrderDetailVO orderDetailVO);

	/**
	 * 查询订单统计信息
	 * @param orderStatisticsQueryVo
	 * @return
	 */
	OrderStatisticsInfoBO queryOrderStatisInfo(OrderStatisticsQueryVo orderStatisticsQueryVo);
	/**
	 * 
	 * @Description: 根据订单编号查询订单信息表
	 * @param orderCode 订单编号
	 * @return
	 * @author wuLong
	 * @date 2017年3月27日 下午4:22:07
	 */
	OrderInfoBO getOrderInfo(@Param("orderCode")String orderCode);

	/**
	 * 用户首页订单（最多显示八条）
	 * @param orderQueryVo
	 * @return
	 */
	List<OrderBaseInfoBO> queryHomeOrderList(OrderQueryVo orderQueryVo);

	/**
	 * 用户首页，统计最近七天投注次数和中奖次数
	 * @param orderQueryVo
	 * @return
	 */
	OrderStatisBO statisOrderBetAndWinCount(OrderQueryVo orderQueryVo);

	/**
	 * 用户首页，统计最近七天追号计划投注次数
	 * @param userId
	 * @return
	 */
	Integer statisAddOrderBetAndWinCount(Integer userId);


	/**
	 * 
	 * @Description: 通过订单状态和彩种id集合查询订单基本信息和订单详情信息
	 * @param orderStatus 订单状态 
	 * @param lotteryCodes 彩种id集合
	 * @param payStatus 支付状态
	 * @return List OrderInfoBO
	 * @author wuLong
	 * @date 2017年4月5日 下午2:42:16
	 */
	List<OrderInfoBO> getOrderInfoList(@Param("orderStatus") Integer orderStatus,@Param("payStatus") Integer payStatus,@Param("lotteryCodes")List<Integer> lotteryCodes);


	/**
	 * 根据订单号查询订单
	 * @param orderCode
	 * @param userId
	 * @return
	 */
	OrderBaseInfoBO queryOrderInfo(@Param("orderCode")String orderCode,@Param("userId")Integer userId);


	/**
	 * 抄单查询订单基本信息
	 *
	 * @param orderCode
	 * @param userId
	 * @return
	 */
	OrderBaseInfoBO queryOrderCopyInfo(@Param("orderCode") String orderCode, @Param("userId") Integer userId);

	/**
	 * 查询未支付的订单详情
	 * @param orderListCode 查询OrderCode列表
	 * @param userId 用户ID
	 * @param lotteryCode 彩种编号
	 * @param lotteryIssue 彩期编号
	 * @param flag 是否需要判断彩期参数 1：是
	 * @return
	 */
	List<OrderInfoLimitBO> queryNoPayOrderList(@Param("orderCodes")List<String> orderListCode,@Param("userId")Integer userId, @Param("lotteryCode")String lotteryCode,@Param("lotteryIssue")String lotteryIssue,@Param("flag")String flag);
	
	/**
	 * 查询未支付的订单总数
	 * @param orderListCode 查询OrderCode列表
	 * @param userId 用户ID
	 * @param lotteryCode 彩种编号
	 * @param lotteryIssue 彩期编号
	 * @return
	 */
	int queryNoPayOrderListCount(@Param("orderCodes")List<String> orderListCode,@Param("userId")Integer userId, @Param("lotteryCode")String lotteryCode, @Param("lotteryIssue")String lotteryIssue);

	/**
	 * 批量取消订单
	 * @param orderListCode
	 * @param userId
	 */
	void batchCancelOrderList(@Param("orderCodes")List<String> orderListCode,@Param("userId")Integer userId,@Param("payStatus")short payStatus);
	
	/**
	 * 
	 * @author longguoyou
	 * @date 2017年4月28日
	 * @param listDetailOrderCode
	 * @return
	 */
	List<OrderInfoDetailLimitBO> queryListFromOrderDetail(@Param("orderCodes")List<String> listDetailOrderCode);
	
	/**
	 * 
	 * @author longguoyou
	 * @date 2017年4月28日
	 * @param listAddedContentOrderCode
	 * @return
	 */
	List<OrderInfoDetailLimitBO> queryListFromOrderAddedContent(@Param("orderCodes")List<String> listAddedContentOrderCode);

	/**
	 * 根据订单编号集合查询订单
	 * @param orderCodeList
	 * @param addCodeList
	 * @param userId
	 * @return
	 */
	List<OrderBaseInfoBO> queryOrderListForOrderCodes(@Param("orderCodeList")List<String> orderCodeList,@Param("addCodeList")List<String> addCodeList,@Param("userId")Integer userId);
	
	/**
	 * 修改撤销理由到订单备注
	 * @param param
	 * @return
	 * @date 2017年6月11日上午11:06:11
	 * @author cheng.chen
	 */
	int updCancelOrderRemark(Map<String, String > param);

	/**
	 * 查询活动参与数量
	 * @param activityOrderQueryInfoVO
	 * @return
	 */
	Integer queryJoinActivityOrderCount(ActivityOrderQueryInfoVO activityOrderQueryInfoVO);

	/**
	 * @desc   查询符合条件的订单数
	 * @author Tony Wang
	 * @create 2017年8月15日
	 * @param vo
	 * @return
	 */
	int count(OrderInfoQueryVO vo);

	/**
	 * 查询当前用户未支付的活动订单编号
	 * @param activityOrderQueryInfoVO
	 * @return
	 */
	List<String> queryNoPayActivityOrderNo(ActivityOrderQueryInfoVO activityOrderQueryInfoVO);


	/**
	 * 抄单更新订单类别
	 *
	 * @param vo
	 * @return
	 */
	int updOrderType(com.hhly.skeleton.lotto.base.order.vo.OrderInfoVO vo);

	/**
	 * 用户中奖轮播信息
	 * @return
	 */
	List<UserWinInfoBO> queryUserWinInfo();

	/**
	 * 统计代理用户有本月投注金额、累计投注金额、累计投注次数
	 * @return
	 * @param orderVO
	 */
	List<AgentOrderInfoBO> sumAgentOrderAmount(AgentQueryVO orderVO);
	
	
	/******************************* 合买接口  start ************************************/
	/**
	 * 
	 * @Description 查询合买订单列表 
	 * @author HouXiangBao289
	 * @param vo
	 * @return
	 */
	List<OrderGroupBO> findGroup(OrderGroupVO vo);
	int findGroupTotal(OrderGroupVO vo);
	
	/**
	 * 
	 * @Description 查询合买认购列表 
	 * @author HouXiangBao289
	 * @param userName
	 * @return
	 */
	List<OrderGroupContentBO> findGroupContent(OrderGroupVO vo);
	int findGroupContentTotal(OrderGroupVO vo);

	/**
	 * 
	 * @Description 查询合买订单
	 * @author HouXiangBao289
	 * @param id
	 * @return
	 */
	OrderGroupBO findGroupById(Integer id);

	/**
	 * 
	 * @Description 合买截止时间和说明更新
	 * @author HouXiangBao289
	 * @param vo
	 * @return
	 */
	int update(OrderGroupVO vo);

	/**
	 * 
	 * @Description 导出数据
	 * @author HouXiangBao289
	 * @param vo
	 * @return
	 */
	List<OrderGroupContentExcelBO> excelGroupContent(OrderGroupVO vo);
    /**
     * 获取中奖信息
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2018年5月30日 上午9:14:05
     * @param orderInfoCmsSearch
     * @return
     */
	List<OrderInfoCmsBO> findAwardInfo(OrderInfoCmsSearchVO orderInfoCmsSearch);
}