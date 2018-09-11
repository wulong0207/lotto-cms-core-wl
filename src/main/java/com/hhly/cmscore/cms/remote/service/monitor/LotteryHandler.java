package com.hhly.cmscore.cms.remote.service.monitor;

import java.util.HashMap;
import java.util.Map;

import com.hhly.cmscore.cms.remote.service.ITicketMgrService;
import com.hhly.cmscore.cms.remote.service.monitor.lottery.GeneralLottery;
import com.hhly.cmscore.cms.remote.service.monitor.lottery.SportLottery;
import com.hhly.skeleton.base.common.LotteryEnum;
import com.hhly.skeleton.base.common.LotteryEnum.Lottery;
import com.hhly.skeleton.base.exception.ServiceRuntimeException;

/**
 * @desc 彩种处理类
 * @author jiangwei
 * @date 2017-2-17
 * @company 益彩网络科技公司
 * @version 1.0
 */
/**
 * @desc
 * @author jiangwei
 * @date 2017-2-20
 * @company 益彩网络科技公司
 * @version 1.0
 */
public abstract class LotteryHandler {
    //保存数据处理类,这里使用的是类锁添加数据，不会出现产生指针乱，导致死循环
    private static final Map<Integer,ILottery> map = new HashMap<>();
    /**
     * 重新加载刷新时间
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-20 下午3:01:49
     * @param maintenanceMgrService
     * @param lotteryCode
     */
    public static void loadRefreshTime(ITicketMgrService maintenanceMgrService,int lotteryCode){
         getLottery(maintenanceMgrService, lotteryCode).loadRefreshTime();
    }
    /**
     * 获取彩种刷新处理类
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-20 下午3:02:02
     * @param maintenanceMgrService
     * @param lotteryCode
     * @return
     */
    public static ILottery getLottery(ITicketMgrService maintenanceMgrService
            ,int lotteryCode){
        Lottery lot = LotteryEnum.Lottery.getLottery(lotteryCode);
        if(lot == null){
        	throw new ServiceRuntimeException("不存在该彩种; lotteryCode : " + lotteryCode);
        }
        //采用 双重检查锁（DCL） 对彩种分析策略进行创建
        ILottery iLottery =  map.get(lot.getName());
        if(iLottery == null) {
            synchronized (LotteryHandler.class) {
                if(iLottery == null) {
                    switch (lot) {
                    case FB:
                    case BB:
                    case BJDC:
                    case SFGG:
                        //竞彩不按期号统计
                        iLottery = new SportLottery(maintenanceMgrService, lotteryCode,lot.getDesc());
                        break;
                    default:
                        //期号统计
                        iLottery = new GeneralLottery(maintenanceMgrService, lotteryCode, lot.getDesc());
                        break;
                    }
                    map.put(lot.getName(), iLottery);
                }
            }
        }
        return iLottery;
    }
}
