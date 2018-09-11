package com.hhly.cmscore.persistence.ticket.dao;

import java.util.List;
import java.util.Map;

import com.hhly.skeleton.cms.ticketmgr.bo.TicketInfoSingleBO;
import com.hhly.skeleton.lotto.base.order.vo.OrderQueryVo;
import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.cms.remote.service.status.entity.TicketStatusBO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketInfoBO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketInfoVO;

/**
 * @desc 票信息数据接口
 * @author huangb
 * @date 2017年2月20日
 * @company 益彩网络
 * @version v1.0
 */
public interface TicketInfoDaoMapper {

	/**
	 * 查询彩期出票信息，根据出票商进行分组
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017-2-15 上午10:18:53
	 * @param lotteryCode
	 *            彩种
	 * @param issueCode
	 *            彩期
	 * @return
	 */
	List<TicketInfoBO> listTicketInfoChannel(TicketInfoVO vo);

	/**
	 * 查询竞技彩最近需要统计的一期
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017-2-17 下午12:14:50
	 * @param lotteryCode
	 * @return
	 */
	TicketInfoBO getLotteryIssueMonitorSport(@Param("lotteryCode") int lotteryCode);

	/********************* 票管理页面操作 ************************/
	/**
	 * @desc 票管理：分页查询
	 * @author huangb
	 * @date 2017年2月20日
	 * @param ticketInfoVO
	 *            参数对象
	 * @return 票管理：分页查询
	 */
	List<TicketInfoBO> findPagingTicket(TicketInfoVO ticketInfoVO);

	/**
	 * @desc 票管理：分页查询记录数
	 * @author huangb
	 * @date 2017年2月20日
	 * @param ticketInfoVO
	 *            查询对象
	 * @return 票管理：分页查询记录数
	 */
	Map<String, Object> findCountTicket(TicketInfoVO ticketInfoVO);

	/**
	 * @desc 票管理：查询单个
	 * @author huangb
	 * @date 2017年2月20日
	 * @param ticketInfoVO
	 *            查询对象
	 * @return 票管理：查询单个
	 */
	TicketInfoBO findSingleTicket(TicketInfoVO ticketInfoVO);

	/**
	 * @desc 票管理：查询excel导出
	 * @author huangb
	 * @date 2017年2月20日
	 * @param ticketInfoVO
	 *            查询对象
	 * @return 票管理：查询excel导出
	 */
	List<TicketInfoBO> findExcelTicket(TicketInfoVO ticketInfoVO);

	/**
	 * @desc 票管理：修改票信息(包括票状态、回执内容、票图片、票内容、备注)
	 * @author huangb
	 * @date 2017年2月20日
	 * @param ticketInfoVO
	 *            参数对象
	 * @return 票管理：修改票信息(包括票状态、回执内容、票图片、票内容、备注)
	 */
	int updTicket(TicketInfoVO ticketInfoVO);
	/**
	 * 查询票不等于指定状态的数量
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年3月14日 下午2:40:50
	 * @param orderCode 订单编号
	 * @param status 状态
	 * @return
	 */
	int countTicketInfoNotEqual(@Param("orderCode")String orderCode, @Param("status")int status);
	/**
	 * 票状态查询
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年3月20日 下午3:12:28
	 * @param ids
	 * @return
	 */
	List<TicketStatusBO> listTicketStatus(@Param("ids")List<String> ids);
	/**
	 * 批量修改票状态
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年3月20日 下午3:54:08
	 * @param ids 主键 
	 * @param status 状态
	 * @param modifyBy 修改人
	 */
	void updateTicketStatus(@Param("ids")List<Integer> ids, @Param("status")Short status, @Param("modifyBy")String modifyBy);

	/**
	 * 查询出票失败的票
	 * @param orderCode
	 * @param ticketStatus
	 * @return
	 */
	List<TicketInfoSingleBO> queryFailTicketInfo(@Param("orderCode")String orderCode,@Param("ticketStatus")Integer ticketStatus);

	/**
	 * 添加票记录
	 * @param list <TicketInfoBO>
	 * @return ID
	 */
	int addTicketInfoList(@Param("ticketInfoBOs")List<TicketInfoBO> ticketInfoBOs);
    /**
     * 票状态
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017年8月15日 下午4:33:30
     * @param orderCode
     * @param status
     * @return
     */
	int countTicketStatus(@Param("orderCode")String orderCode, @Param("status")int status);

	///////////////////////////////////前端出票明细页面接口////////////////////////////////////////////

	/**
	 * 出票明细，分页接口
	 * @param orderQueryVo
	 * @return
	 */
	List<com.hhly.skeleton.lotto.base.ticket.bo.TicketInfoBO> findTicketList(OrderQueryVo orderQueryVo);

	/**
	 * 出票明细分页接口总数量
	 * @param orderQueryVo
	 * @return
	 */
	int findTicketListCount(OrderQueryVo orderQueryVo);




}