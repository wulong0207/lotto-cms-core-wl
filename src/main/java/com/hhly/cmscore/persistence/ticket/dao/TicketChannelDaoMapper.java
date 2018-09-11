package com.hhly.cmscore.persistence.ticket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.ticket.po.TicketChannelPO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketChannelBO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketChannelVO;

/**
 * 
 * @desc 出票渠道
 * @author jiangwei
 * @date 2017-2-5
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface TicketChannelDaoMapper {

    int countPage(TicketChannelVO vo);

    List<TicketChannelBO> listPage(TicketChannelVO vo);

    List<String> listDrawerName();

    int update(TicketChannelPO po);

    int add(TicketChannelPO po);

    List<TicketChannelBO> listDrawerIdName();
    
    TicketChannelBO findById(int id);
    /**
     * 获取彩种能送票的渠道
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2018年7月28日 上午11:13:23
     * @param lotteryCode
     * @return
     */
	List<TicketChannelBO> listDrawerIdNameSending(@Param("lotteryCode")String lotteryCode);
   
}