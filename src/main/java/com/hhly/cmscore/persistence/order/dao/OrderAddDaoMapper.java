package com.hhly.cmscore.persistence.order.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.order.po.OrderAddContentPO;
import com.hhly.cmscore.persistence.order.po.OrderAddIssuePO;
import com.hhly.cmscore.persistence.order.po.OrderAddPO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderAddBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderAddContentBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderAddIssueBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderAddUserExcelCmsBO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderAddCmsVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderAddContentVO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderAddIssueVO;
import com.hhly.skeleton.lotto.base.order.bo.OrderAddInfoBO;
import com.hhly.skeleton.lotto.base.order.bo.OrderAddInfoSingleBO;
import com.hhly.skeleton.lotto.base.order.bo.OrderAddedIssueBO;
import com.hhly.skeleton.lotto.base.order.bo.OrderBaseInfoBO;
import com.hhly.skeleton.lotto.base.order.bo.UserChaseDetailBO;
import com.hhly.skeleton.lotto.base.order.bo.UserChaseRefundBO;
import com.hhly.skeleton.lotto.base.order.bo.UserChaseWinningDetailBO;
import com.hhly.skeleton.lotto.base.order.bo.UserNumOrderDetailBO;
import com.hhly.skeleton.lotto.base.order.vo.OrderAddQueryVO;
import com.hhly.skeleton.lotto.base.order.vo.UserChaseDetailQueryVO;

/**
 * @author huangb
 *
 * @Date 2016年12月21日
 *
 * @Desc 追号计划的数据处理
 */
public interface OrderAddDaoMapper {

	/**************************** Used to LOTTO ******************************/

	/**
	 * @param orderAdd
	 *            追号计划
	 * @return
	 * @Desc 添加追号计划
	 */
	int addOrderAdd(OrderAddPO orderAdd);

	/**
	 * @param orderAddContents
	 *            追号计划内容列表
	 * @return
	 * @Desc 添加 追号计划内容列表
	 */
	int addOrderAddContent(List<OrderAddContentPO> orderAddContents);

	/**
	 * @param orderAddIssues
	 *            追号计划期号列表
	 * @return
	 * @Desc 添加追号计划期号列表
	 */
	int addOrderAddIssue(List<OrderAddIssuePO> orderAddIssues);

	/**
	 * @desc 前端接口：用户中心-查询用户追号详情-追号内容详情(分页查列表)
	 * @author huangb
	 * @date 2017年4月11日
	 * @param queryVO
	 *            查询对象
	 * @return 前端接口：用户中心-查询用户追号详情-追号内容详情(分页查列表)
	 */
	List<UserNumOrderDetailBO> findPagingUserChaseContent(UserChaseDetailQueryVO queryVO);

	/**
	 * @desc 前端接口：用户中心-查询用户追号详情-追号内容详情数据条数(一个计划对应的内容数量)
	 * @author huangb
	 * @date 2017年4月11日
	 * @param queryVO
	 *            查询对象
	 * @return 前端接口：用户中心-查询用户追号详情-追号内容详情数据条数(一个计划对应的内容数量)
	 */
	int findCountUserChaseContent(UserChaseDetailQueryVO queryVO);
	
	/**
	 * @desc 前端接口：用户中心-查询用户追号详情-追号期号及中奖信息(分页查列表)
	 * @author huangb
	 * @date 2017年4月11日
	 * @param queryVO
	 *            查询对象
	 * @return 前端接口：用户中心-查询用户追号详情-追号期号及中奖信息(分页查列表)
	 */
	List<UserChaseDetailBO> findPagingUserChaseDetail(UserChaseDetailQueryVO queryVO);

	/**
	 * @desc 前端接口：用户中心-查询用户追号详情-追号期号及中奖信息数据条数(一个计划对应的期号数量)
	 * @author huangb
	 * @date 2017年4月11日
	 * @param queryVO
	 *            查询对象
	 * @return 前端接口：用户中心-查询用户追号详情-追号期号及中奖信息数据条数(一个计划对应的期号数量)
	 */
	int findCountUserChaseDetail(UserChaseDetailQueryVO queryVO);
	
	/**
	 * @desc 前端接口(调用)：用户中心-查询正在执行的追号彩期(按彩期升序，操作时间为空的第一条数据（其实就是追号状态为等待追号的第一条数据）
	 *       就是目标数据)
	 * @author huangb
	 * @date 2017年4月13日
	 * @param queryVO
	 *            查询对象
	 * @return 前端接口(调用)：用户中心-查询正在执行的追号彩期(按彩期升序，操作时间为空的第一条数据（其实就是追号状态为等待追号的第一条数据）
	 *         就是目标数据)
	 */
	String findCurChasingIssue(UserChaseDetailQueryVO queryVO);
	
	
	/**
	 * @desc 前端接口：用户中心-用户终止追号任务 （用户撤单：追号期号中所有等待追号的全撤）<br>
	 *       1.查询指定条件的撤单数据（追号计划和对应追号期信息）,判断是否符合撤单条件
	 * @author huangb
	 * @date 2017年4月24日
	 * @param queryVO
	 *            查询参数（追号编号）
	 * @return 查询指定条件的撤单数据（追号计划和对应追号期信息）,判断是否符合撤单条件
	 */
	int findCountChaseCancel(UserChaseDetailQueryVO queryVO);
	/**
	 * @desc 前端接口：用户中心-用户终止追号任务,查询目标追号计划是否存在，存在则返回部分相关信息(包括编号，用户，是否有活动等);扩展findCountChaseCancel<br>
	 * @author huangb
	 * @date 2017年4月24日
	 * @param queryVO
	 *            查询参数（追号编号）
	 * @return 前端接口：用户中心-用户终止追号任务,查询目标追号计划是否存在，存在则返回部分相关信息(包括编号，用户，是否有活动等)
	 */
	com.hhly.skeleton.lotto.base.order.bo.OrderAddBO findChaseCancel(UserChaseDetailQueryVO queryVO);
	/**
	 * @desc 前端接口：用户中心-用户终止追号任务 （用户撤单：追号期号中所有等待追号的全撤）<br>
	 *       1.退款总额（查询剩余“等待追号”的金额总和）
	 * @author huangb
	 * @date 2017年4月24日
	 * @param queryVO
	 *            查询参数（追号编号、追号期状态）
	 * @return 修改撤单信息：退款总额（查询剩余“等待追号”的金额总和）
	 */
	UserChaseRefundBO findChaseRefundAmount(UserChaseDetailQueryVO queryVO);

	/**
	 * @desc 前端接口：用户中心-用户终止追号任务 （用户撤单：追号期号中所有等待追号的全撤）<br>
	 *       2.用户撤单修改：剩余追号期数明细状态修改为"用户撤单中8"(“等待追号5”-“用户撤单中8”)
	 * @author huangb
	 * @date 2017年4月24日
	 * @param queryVO
	 *            查询参数（追号编号、用户id、追号期状态、新追号期状态）
	 * @return 用户撤单修改：剩余追号期数明细状态修改为"用户撤单中8"(“等待追号5”-“用户撤单中8”)
	 */
	int updChaseIssue(UserChaseDetailQueryVO queryVO);

	/**
	 * @desc 前端接口：用户中心-用户终止追号任务 （用户撤单：追号期号中所有等待追号的全撤）<br>
	 *       3.用户撤单修改：修改追号计划状态为"用户撤单4"("追号中1"-"用户撤单4"),追号结束时间、已追期数同步更新
	 * @author huangb
	 * @date 2017年4月24日
	 * @param chaseInfo
	 *            查询参数（追号编号、用户id、追号状态、新追号状态）
	 * @return 用户撤单修改：修改追号计划状态为"用户撤单4"("追号中1"-"用户撤单4"),追号结束时间、已追期数同步更新
	 */
	int updChaseEnd(UserChaseDetailQueryVO queryVO);
	
	/**
	 * @desc 前端接口：用户中心-查询追号计划中奖金额（税前或税后）的组成明细，追号彩期关联追号订单获取
	 * @author huangb
	 * @date 2017年4月11日
	 * @param queryVO
	 *            查询对象
	 * @return 前端接口：用户中心-查询追号计划中奖金额（税前或税后）的组成明细，追号彩期关联追号订单获取
	 */
	List<UserChaseWinningDetailBO> findUserChaseWinningDetail(UserChaseDetailQueryVO queryVO);

	/**
	 * @desc 前端接口(调用)：用户中心-查询从哪期停止追号
	 * @param queryVO
	 * @return
	 */
	String findStopChasingIssue(UserChaseDetailQueryVO queryVO);

	/**
	 *
	 * 前端接口：追号订单详情追号中最新彩期
	 * @param orderAddCode
	 * @return
	 */
	List<OrderAddedIssueBO> queryOrderAddedIssueList(String orderAddCode);

	/**
	 * @desc   查询符合条件的追号单数
	 * @author Tony Wang
	 * @create 2017年8月14日
	 * @param vo
	 * @return 
	 */
	int count(OrderAddQueryVO vo);
	

	/**
	 * @desc   查询符合条件的追号单
	 * @author Tony Wang
	 * @create 2017年8月29日
	 * @param vo
	 * @return 
	 */
	List<com.hhly.skeleton.lotto.base.order.bo.OrderAddBO> find(OrderAddQueryVO vo);
	
	
	/**************************** Used to CMS ******************************/

	/**
	 * @param orderAddCms
	 *            查询对象
	 * @return 分页查询追号计划信息
	 * @Desc 分页查询追号计划信息
	 */
	List<OrderAddBO> findPagingOrderAdd(OrderAddCmsVO orderAddCms);

	/**
	 * @param orderAddCms
	 *            查询对象
	 * @return 追号计划记录数
	 * @Desc 查询追号计划记录数
	 */
	Map<String, Object> findCountOrderAdd(OrderAddCmsVO orderAddCms);

	/**
	 * @param orderAddCms
	 *            查询对象
	 * @return 查询单个追号计划
	 * @Desc 查询单个追号计划
	 */
	OrderAddBO findSingleOrderAdd(OrderAddCmsVO orderAddCms);

	/**
	 * @desc 导出追号计划信息
	 * @author huangb
	 * @date 2017年1月20日
	 * @param orderAddCms
	 *            查询对象
	 * @return 导出追号计划信息
	 */
	List<OrderAddBO> findExcelOrderAdd(OrderAddCmsVO orderAddCms);
	
	/**
	 * @desc 导出追号计划相关用户信息
	 * @author huangb
	 * @date 2017年1月20日
	 * @param orderAddCms
	 * @return 导出追号计划相关用户信息
	 */
	List<OrderAddUserExcelCmsBO> findExcelOrderAddUser(OrderAddCmsVO orderAddCms);
	
	/**
	 * @param orderAddContent
	 *            查询对象
	 * @return 分页查询追号内容
	 * @Desc 分页查询追号内容
	 */
	List<OrderAddContentBO> findPagingOrderAddContent(OrderAddContentVO orderAddContent);

	/**
	 * @param orderAddContent
	 *            查询对象
	 * @return 追号内容记录数
	 * @Desc 查询追号内容记录数
	 */
	int findCountOrderAddContent(OrderAddContentVO orderAddContent);

	/**
	 * @param orderAddIssue
	 *            查询对象
	 * @return 分页查询追号期数
	 * @Desc 分页查询追号期数
	 */
	List<OrderAddIssueBO> findPagingOrderAddIssue(OrderAddIssueVO orderAddIssue);

	/**
	 * @param orderAddIssue
	 *            查询对象
	 * @return 追号期数记录数
	 * @Desc 查询追号期数记录数
	 */
	int findCountOrderAddIssue(OrderAddIssueVO orderAddIssue);
	
	/**
	 * @desc 修改指定id列表的追号彩期状态(撤单)
	 * @author huangb
	 * @date 2017年1月19日
	 * @param ids 要修改的追号彩期id列表
	 * @return 修改的追号彩期id列表记录数
	 */
	/*int updOrderAddIssueStatusByIds(@Param("ids") List<String> ids);*/
	
	/**
	 * @desc 查询导出的追号彩期
	 * @author huangb
	 * @date 2017年1月20日
	 * @param orderAddIssue
	 *            查询对象
	 * @return 查询导出的追号彩期
	 */
	List<OrderAddIssueBO> findExcelOrderAddIssue(OrderAddIssueVO orderAddIssue);

	/**
	 * 根据订单编号查询追号信息（订单列表使用，主要是已追期数，总期数，追号状态）
	 * @param orderCode
	 * @return
	 */
	OrderAddInfoBO findOrderAddInfo(String orderCode);

	/**
	 * 根据追号单号查询追号订单
	 * @param orderAddCode
	 * @param userId
	 * @return
	 */
	OrderBaseInfoBO queryOrderAddInfo(@Param("orderAddCode")String orderAddCode,@Param("userId")Integer userId);

	/**
	 * 查询追号原因
	 * @param orderAddCode
	 * @param userId
	 * @return
	 */
	OrderAddInfoSingleBO queryOrderAddStopReason(@Param("orderAddCode")String orderAddCode,@Param("userId")Integer userId);

	/**
	 * 批量取消订单
	 * @param addOrderCodes
	 * @param userId
	 */
	void batchCancelAddOrderList(@Param("addOrderCodes")List<String> addOrderCodes,@Param("userId")Integer userId,@Param("payStatus")short payStatus);
	
	/**
	 * 追号计划数字彩最新一期	开奖号码
	 * @param orderAddCode
	 * @return
	 */
	String queryAddOrderDrawCode(@Param("orderAddCode") String orderAddCode);
}