package com.hhly.cmscore.persistence.ticket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.ticket.po.TicketConfigPO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketConfigBO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketConfigVO;

/**
 * 出票渠道配置
 * @desc
 * @author jiangwei
 * @date 2017-2-6
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface TicketConfigDaoMapper {

    int countPage(TicketConfigVO vo);

    List<TicketConfigBO> listPage(TicketConfigVO vo);

    int update(TicketConfigPO vo);

    int add(TicketConfigPO vo);
    /**
     * 出票监控获取出票渠道信息
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017年8月21日 下午3:42:27
     * @param channelId
     * @param lotteryCode
     * @return
     */
    TicketConfigBO getTicketConfig(@Param("channelId")String channelId,@Param("lotteryCode")Integer lotteryCode);
    
}