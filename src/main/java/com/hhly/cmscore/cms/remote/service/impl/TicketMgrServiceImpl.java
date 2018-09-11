package com.hhly.cmscore.cms.remote.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.cmscore.cms.remote.service.ILotteryMgrService;
import com.hhly.cmscore.cms.remote.service.IOrderMgrService;
import com.hhly.cmscore.cms.remote.service.ITicketMgrService;
import com.hhly.cmscore.cms.remote.service.monitor.ILottery;
import com.hhly.cmscore.cms.remote.service.monitor.LotteryHandler;
import com.hhly.cmscore.cms.remote.service.status.TicketOperateVisitor;
import com.hhly.cmscore.cms.remote.service.status.TicketStatusVisitor;
import com.hhly.cmscore.cms.remote.service.status.entity.TicketStatusBO;
import com.hhly.cmscore.persistence.ticket.dao.TicketAlarmConfigDaoMapper;
import com.hhly.cmscore.persistence.ticket.dao.TicketAlarmInfoDaoMapper;
import com.hhly.cmscore.persistence.ticket.dao.TicketChannelDaoMapper;
import com.hhly.cmscore.persistence.ticket.dao.TicketConfigDaoMapper;
import com.hhly.cmscore.persistence.ticket.dao.TicketInfoDaoMapper;
import com.hhly.cmscore.persistence.ticket.dao.TicketMonitorCommonDaoMapper;
import com.hhly.cmscore.persistence.ticket.dao.TicketMonitorConfigDaoMapper;
import com.hhly.cmscore.persistence.ticket.po.TicketAlarmConfigPO;
import com.hhly.cmscore.persistence.ticket.po.TicketAlarmInfoPO;
import com.hhly.cmscore.persistence.ticket.po.TicketChannelPO;
import com.hhly.cmscore.persistence.ticket.po.TicketConfigPO;
import com.hhly.cmscore.persistence.ticket.po.TicketMonitorCommonPO;
import com.hhly.cmscore.persistence.ticket.po.TicketMonitorConfigPO;
import com.hhly.persistence.common.Constants;
import com.hhly.persistence.util.DESUtil;
import com.hhly.redis.annotation.DeleteThroughAssignCache;
import com.hhly.redis.annotation.ParameterValueKeyProvider;
import com.hhly.redis.annotation.ReadThroughAssignCache;
import com.hhly.redis.annotation.RedisCacheType;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.bo.ResultBO;
import com.hhly.skeleton.base.constants.CacheConstants;
import com.hhly.skeleton.base.constants.SymbolConstants;
import com.hhly.skeleton.base.exception.Assert;
import com.hhly.skeleton.base.exception.ServiceRuntimeException;
import com.hhly.skeleton.base.page.AbstractStatisticsPage;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.page.ISimplePage;
import com.hhly.skeleton.base.status.VisitorHandler;
import com.hhly.skeleton.base.util.NumberUtil;
import com.hhly.skeleton.base.util.ObjectUtil;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryIssueCmsBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderInfoCmsBO;
import com.hhly.skeleton.cms.ticketmgr.bo.OrderTicketMonitorBO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketAlarmConfigBO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketAlarmInfoBO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketChannelBO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketConfigBO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketInfoBO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketMonitorCommonBO;
import com.hhly.skeleton.cms.ticketmgr.bo.TicketMonitorConfigBO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketAlarmConfigVO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketAlarmInfoVO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketChannelVO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketConfigVO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketInfoStatusVO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketInfoVO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketMonitorCommonVO;
import com.hhly.skeleton.cms.ticketmgr.vo.TicketMonitorConfigVO;

@Service("ticketMgrService")
public class TicketMgrServiceImpl implements ITicketMgrService {
    
    @Autowired
    private IPageService pageService;
    @Autowired
    private ILotteryMgrService lotteryMgrService;
    @Autowired
    private IOrderMgrService orderMgrService;
    @Autowired
    private TicketChannelDaoMapper ticketChannelDaoMapper;
    @Autowired
    private TicketConfigDaoMapper ticketConfigDaoMapper;
    @Autowired
    private TicketAlarmConfigDaoMapper alarmConfigDaoMapper;   
    @Autowired
    private TicketAlarmInfoDaoMapper alarmInfoDaoMapper;
    @Autowired
    private TicketMonitorConfigDaoMapper monitorConfigDaoMapper;
    @Autowired
    private TicketMonitorCommonDaoMapper monitorCommonDaoMapper;
    /**
     * 票信息数据接口
     */
    @Autowired
    private TicketInfoDaoMapper ticketInfoDaoMapper;
    
    @Override
    public PagingBO<TicketChannelBO> listTicketChannel(
            final TicketChannelVO vo) {
        return pageService.getPageData(vo, new ISimplePage<TicketChannelBO>() {

            @Override
            public int getTotal() {
                return ticketChannelDaoMapper.countPage(vo);
            }

            @Override
            public List<TicketChannelBO> getData() {
                return ticketChannelDaoMapper.listPage(vo);
            }
        });
    }

    @Override
    public List<String> listDrawerName() {
        return ticketChannelDaoMapper.listDrawerName();
    }

	@Override
    public int updOrderTicketChannel(TicketChannelVO vo) {
        TicketChannelPO po = new TicketChannelPO(vo);
        TicketChannelBO bo = ticketChannelDaoMapper.findById(po.getId());
        Assert.notNull(bo);
        if(!Objects.equals(po.getAccountPassword(), bo.getAccountPassword())){
        	 po.setAccountPassword(DESUtil.encrypt(po.getAccountPassword()));
        }
        return ticketChannelDaoMapper.update(po);
    }

    @Override
    public int addOrderTicketChannel(TicketChannelVO vo) {
        TicketChannelVO countVO = new TicketChannelVO();
        countVO.setTicketChannelId(vo.getTicketChannelId());
        int num = ticketChannelDaoMapper.countPage(countVO);
        if (num > 0) {
            throw new ServiceRuntimeException(ResultBO.getMsg("30401"));
        }
        TicketChannelPO po = new TicketChannelPO(vo);
        po.setAccountPassword(DESUtil.encrypt(po.getAccountPassword()));
        return ticketChannelDaoMapper.add(po);
    }

    @Override
    public int addTicketConfig(TicketConfigVO vo) {
        TicketConfigPO po = new TicketConfigPO(vo);
        return ticketConfigDaoMapper.add(po);
    }

    @Override
    public int updTicketConfig(TicketConfigVO vo) {
        TicketConfigPO po = new TicketConfigPO(vo);
        String key = getChannelConfigKey(po.getTicketChannelId(),po.getLotteryCode());
        ((TicketMgrServiceImpl)AopContext.currentProxy()).deleteRedisTicketConfig(key);
        return ticketConfigDaoMapper.update(po);
    }

    @Override
    public PagingBO<TicketConfigBO> listTicketConfig(final TicketConfigVO vo) {
        return pageService.getPageData(vo, new ISimplePage<TicketConfigBO>() {

            @Override
            public int getTotal() {
                return ticketConfigDaoMapper.countPage(vo);
            }

            @Override
            public List<TicketConfigBO> getData() {
                List<TicketConfigBO> list = ticketConfigDaoMapper.listPage(vo);
                Collection<String> set = getChildCode(list);
                setChildCodeName(list, set);	
                return list;
            }

           
        });
    }
    
    /**
     * 获取所有子玩法code
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-15 上午8:59:26
     * @param list
     * @return
     */
    private Collection<String> getChildCode(List<TicketConfigBO> list) {
        StringBuilder builder = new StringBuilder();
        // 获取子玩法ID
        for (TicketConfigBO bo : list) {
            if(StringUtils.isBlank(bo.getStopLottery())){
                continue;
            }
            builder.append(SymbolConstants.COMMA);
            builder.append(bo.getStopLottery());
        }
        // 查询子玩法名称
        Set<String> set = new HashSet<String>();
        String childCodes[] = org.springframework.util.StringUtils
                .tokenizeToStringArray(builder.toString(), SymbolConstants.COMMA);
        for (String code : childCodes) {
            set.add(code);
        }
        return set;
    }
    
    /**
     * 设置子玩法的名称
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017-2-15 上午8:59:39
     * @param list
     * @param set
     */
    private void setChildCodeName(List<TicketConfigBO> list,
            Collection<String> set) {
    	if(CollectionUtils.isEmpty(set)){
    		return;
    	}
        Map<String, String> map = lotteryMgrService
                .listChildTypeName(set);
        // 替换子玩法id
        for (TicketConfigBO bo : list) {
            if (StringUtils.isBlank(bo.getStopLottery())) {
                break;
            }
            String codes[] = bo.getStopLottery().split(SymbolConstants.COMMA);
            StringBuilder sb = new StringBuilder();
            for (String code : codes) {
                sb.append(map.get(code));
                sb.append("<br/>");
            }
            bo.setStopLotteryName(sb.toString());
        }
    }
    
    @Override
    public List<TicketChannelBO> listDrawerIdName(String lotteryCode) {
    	if(StringUtils.isEmpty(lotteryCode)){
    		return ticketChannelDaoMapper.listDrawerIdName();	
    	}else{
    		return ticketChannelDaoMapper.listDrawerIdNameSending(lotteryCode);
    	}
        
    }

    @Override
    public PagingBO<TicketAlarmInfoBO> listTicketAlarmInfo(final TicketAlarmInfoVO vo) {
        return pageService.getPageData(vo, new ISimplePage<TicketAlarmInfoBO>() {

            @Override
            public int getTotal() {
                return alarmInfoDaoMapper.countPage(vo);
            }

            @Override
            public List<TicketAlarmInfoBO> getData() {
                return alarmInfoDaoMapper.listPage(vo);
            }
        });
    }

    @Override
    public PagingBO<TicketAlarmConfigBO> listTicketAlarmConfig(
            final TicketAlarmConfigVO vo) {
        return pageService.getPageData(vo, new ISimplePage<TicketAlarmConfigBO>() {

            @Override
            public int getTotal() {
                return alarmConfigDaoMapper.countPage(vo);
            }

            @Override
            public List<TicketAlarmConfigBO> getData() {
                return alarmConfigDaoMapper.listPage(vo);
            }
        });
    }

    @Override
    public int updTicketAlarmConfig(TicketAlarmConfigVO vo) {
        TicketAlarmConfigPO po =  new TicketAlarmConfigPO(vo);
        return alarmConfigDaoMapper.update(po);
    }

    @Override
    public int addTicketAlarmConfig(TicketAlarmConfigVO vo) {
        TicketAlarmConfigPO po =  new TicketAlarmConfigPO(vo);
        return alarmConfigDaoMapper.add(po);
    }

    @Override
    public int updTicketAlarmInfoStatus(TicketAlarmInfoVO vo) {
        return alarmInfoDaoMapper.updTicketAlarmInfoStatus(vo);
    }

    @Override
    public PagingBO<TicketMonitorConfigBO> listTicketMonitorConfig(
            final TicketMonitorConfigVO vo) {
        return pageService.getPageData(vo, new ISimplePage<TicketMonitorConfigBO>() {

            @Override
            public int getTotal() {
                return monitorConfigDaoMapper.countPage(vo);
            }

            @Override
            public List<TicketMonitorConfigBO> getData() {
                return monitorConfigDaoMapper.listPage(vo);
            }
        });
    }

    @Override
    public int updTicketMonitorConfig(TicketMonitorConfigVO vo) {
        TicketMonitorConfigPO po = new TicketMonitorConfigPO(vo);
        int num =  monitorConfigDaoMapper.update(po);
        if(num == 1){
        	LotteryHandler.loadRefreshTime(this,po.getLotteryId());
        }
        return num;
    }

    @Override
    public int addTicketMonitorConfig(TicketMonitorConfigVO vo) {
        TicketMonitorConfigPO po = new TicketMonitorConfigPO(vo);
        TicketMonitorConfigVO configVO = new TicketMonitorConfigVO();
        configVO.setLotteryId(po.getLotteryId());
        int count = monitorConfigDaoMapper.countPage(vo);
        if (count > 0) {
            throw new ServiceRuntimeException("该彩种已存在配置");
        }
        int num = monitorConfigDaoMapper.add(po);
        LotteryHandler.loadRefreshTime(this,po.getLotteryId());
        return num;
    }
    
    @Override
	public List<String> queryLotteryMonitorConfig(Integer lotteryCategory) {
		return monitorConfigDaoMapper.queryLotteryMonitorConfig(lotteryCategory);
	}

	@Override
    public List<TicketMonitorCommonBO> listTicketMonitorCommon() {
        return monitorCommonDaoMapper.list();
    }

    @Override
    public int updTicketMonitorCommon(List<TicketMonitorCommonVO> list) {
        List<TicketMonitorCommonPO> pos= new ArrayList<TicketMonitorCommonPO>(list.size());
        for (TicketMonitorCommonVO vo : list) {
            TicketMonitorCommonPO po= new TicketMonitorCommonPO(vo);
            pos.add(po);
        }
        return monitorCommonDaoMapper.update(pos);
    }
    
    @Override
    public OrderTicketMonitorBO getTicketMonitor(int lotteryCode){
    	ILottery lottery = LotteryHandler.getLottery(this, lotteryCode);
        return lottery.getData();
    }

    @ReadThroughAssignCache(namespace=CacheConstants.TICKET_CONFIG_MONITOR,cacheType=RedisCacheType.String,valueclass=TicketConfigBO.class,expireTime=60*60*12)
    @Override
    public TicketConfigBO getTicketConfig(@ParameterValueKeyProvider String key,String channelId,Integer lotteryCode){
        return ticketConfigDaoMapper.getTicketConfig(channelId,lotteryCode);
    }
    
    @DeleteThroughAssignCache(namespace=CacheConstants.TICKET_CONFIG_MONITOR,cacheType=RedisCacheType.String)
    public void deleteRedisTicketConfig(@ParameterValueKeyProvider String key){
        
    }
    
    @Override
    public String getChannelConfigKey(String channelId,Integer lotteryCode){
        return (channelId+SymbolConstants.UNDERLINE+lotteryCode);
    }

    @Override
    public TicketMonitorConfigBO getRefreshTime(int lotteryCode) {
        return monitorConfigDaoMapper.getRefreshTime(lotteryCode);
    }

    @Override
    public LotteryIssueCmsBO getLotteryIssueMonitor(int lotteryCode) {
        return lotteryMgrService.getLotteryIssueMonitor(lotteryCode);
    }

    @Override
    public List<TicketInfoBO> listOrderTicketChannel(TicketInfoVO vo) {
        return ticketInfoDaoMapper.listTicketInfoChannel(vo);
    }

    @Override
    public TicketInfoBO getLotteryIssueMonitorSport(int lotteryCode) {
        return ticketInfoDaoMapper.getLotteryIssueMonitorSport(lotteryCode);
    }

    @Override
    public OrderInfoCmsBO getMonitorOrderInfo(int lotteryCode,
            String lotteryIssue) {
        return orderMgrService.getMonitorOrderInfo(lotteryCode,lotteryIssue);
    }

    /*************************************** 票管理操作 **********************************************/
	@Override
	public PagingBO<TicketInfoBO> findPagingTicket(final TicketInfoVO ticketInfoVO) {
		conditionConvert(ticketInfoVO);// 部分条件转换
		return pageService.getPageData(ticketInfoVO, new AbstractStatisticsPage<TicketInfoBO>() {

			@Override
			public int getTotal() {
				this.setSis(ticketInfoDaoMapper.findCountTicket(ticketInfoVO));
				return Integer.parseInt(this.getSis().get("count").toString());
			}

			@Override
			public List<TicketInfoBO> getData() {
				this.setDataList(ticketInfoDaoMapper.findPagingTicket(ticketInfoVO));
				return this.getDataList();
			}

			@Override
			public Object getOther() {
				List<TicketInfoBO> data = Integer.parseInt(this.getSis().get("count").toString()) > Constants.NUM_0 ? this.getDataList()
						: Collections.<TicketInfoBO> emptyList();
				return getSisInfoTicket(this.getSis(), data);
			}
		});
	}

	@Override
	public TicketInfoBO findSingleTicket(TicketInfoVO ticketInfoVO) {
		return ticketInfoDaoMapper.findSingleTicket(ticketInfoVO);
	}

	@Override
	public List<TicketInfoBO> findExcelTicket(TicketInfoVO ticketInfoVO) {
		conditionConvert(ticketInfoVO);// 部分条件转换
		//取消导出条数限制
//		Map<String, Object> sis = ticketInfoDaoMapper.findCountTicket(ticketInfoVO);
//		int num = NumberUtils.toInt(sis.get("count").toString());
//		Assert.isTrue(num <= Constants.EXCEL_NUM, Constants.EXCEL_ERROR_MSG);
		return ticketInfoDaoMapper.findExcelTicket(ticketInfoVO);
	}

	@Override
	public int updTicket(TicketInfoVO ticketInfoVO) {
		return ticketInfoDaoMapper.updTicket(ticketInfoVO);
	}
	
	/**
	 * @desc 条件转换
	 * @author huangb
	 * @date 2017年2月21日
	 * @param ticketInfoVO 票查询参数
	 */
	private void conditionConvert(TicketInfoVO ticketInfoVO) {
		// 时间查询类型
		if (ticketInfoVO.getTimeType() != null) {
			switch (ticketInfoVO.getTimeType()) {
			case Constants.NUM_1:
				ticketInfoVO.setTimeTypeField("ti.create_time");
				break;
			case Constants.NUM_2:
				ticketInfoVO.setTimeTypeField("ti.end_ticket_time");
				break;
			case Constants.NUM_3:
				ticketInfoVO.setTimeTypeField("ti.send_channel_time");
				break;
			case Constants.NUM_4:
				ticketInfoVO.setTimeTypeField("ti.come_out_time");
				break;
			case Constants.NUM_5:
				ticketInfoVO.setTimeTypeField("ti.receipt_time");
				break;
			case Constants.NUM_6:
				ticketInfoVO.setTimeTypeField("ti.lottery_time");
				break;
			case Constants.NUM_7:
				ticketInfoVO.setTimeTypeField("ti.send_time");
				break;
			default:
				ticketInfoVO.setTimeTypeField("ti.create_time"); // 不存在则默认创建时间
			}
		}
		// 如果指定了是否关联用户表，则不用继续后面的判断
		if (ticketInfoVO.getJoinUser() != null) {
			return;
		}
		// 是否关联用户表
		if (ticketInfoVO.getUser() == null) {
			ticketInfoVO.setJoinUser(false);
			return;
		}
		if (StringUtils.isNotEmpty(ticketInfoVO.getUser().getNickName())
				|| StringUtils.isNotEmpty(ticketInfoVO.getUser().getAccountName())
				|| ticketInfoVO.getUser().getCusMobile() != null
				|| StringUtils.isNotEmpty(ticketInfoVO.getUser().getActualName())
				|| StringUtils.isNotEmpty(ticketInfoVO.getUser().getIdNum())
				|| StringUtils.isNotEmpty(ticketInfoVO.getUser().getCusMail())
				|| ticketInfoVO.getUser().getId() != null) {
			ticketInfoVO.setJoinUser(true);
		}
	}
	/**
	 * @desc 票信息统计数据
	 * @author huangb
	 * @date 2017年2月21日
	 * @param sis 统计结果(按条件查询的统计结果)
	 * @param list 单页数据
	 * @return 票信息统计数据
	 */
	private String[] getSisInfoTicket(Map<String, Object> sis, List<TicketInfoBO> list) {
		String[] sisInfo = new String[8];
		double totalTicketMoney = 0;
		double totalPreBonus = 0;
		double totalAftBonus = 0;
		double totalAddedBonus = 0;
		// 单页统计
		if (list != null && !list.isEmpty()) {
			for (TicketInfoBO temp : list) {
				if (temp.getTicketMoney() != null) {
					totalTicketMoney = NumberUtil.sum(totalTicketMoney, temp.getTicketMoney());
				}
				if (temp.getPreBonus() != null) {
					totalPreBonus = NumberUtil.sum(totalPreBonus, temp.getPreBonus());
				}
				if (temp.getAftBonus() != null) {
					totalAftBonus = NumberUtil.sum(totalAftBonus, temp.getAftBonus());
				}
				if (temp.getAddedBonus() != null) {
					totalAddedBonus = NumberUtil.sum(totalAddedBonus, temp.getAddedBonus());
				}
			}
		}
		sisInfo[0] = String.valueOf(totalTicketMoney);
		sisInfo[1] = String.valueOf(totalPreBonus);
		sisInfo[2] = String.valueOf(totalAftBonus);
		sisInfo[3] = String.valueOf(totalAddedBonus);

		// 条件统计
		sisInfo[4] = sis.get("totalTicketMoney") == null ? "0" : String.valueOf(sis.get("totalTicketMoney"));
		sisInfo[5] = sis.get("totalPreBonus") == null ? "0" : String.valueOf(sis.get("totalPreBonus"));
		sisInfo[6] = sis.get("totalAftBonus") == null ? "0" : String.valueOf(sis.get("totalAftBonus"));
		sisInfo[7] = sis.get("totalAddedBonus") == null ? "0" : String.valueOf(sis.get("totalAddedBonus"));

		return sisInfo;
	}
	/*************************************** 票管理操作 **********************************************/

	@Override
	public int countTicketInfoNotEqual(String orderCode, int status) {
		return ticketInfoDaoMapper.countTicketInfoNotEqual(orderCode,status);
	}

	@Override
	public String updateTicketStatus(TicketInfoStatusVO vo) {
		List<TicketStatusBO> bos = checkTicket(vo.getId());
		TicketStatusVisitor visitor = new TicketStatusVisitor();
		List<Integer> ids = new ArrayList<>();
		for (TicketStatusBO ticketStatusBO : bos) {
			Boolean can = VisitorHandler.disboseOrderStatus(ticketStatusBO.getTicketStatus(), ticketStatusBO,
					(int) vo.getStatus(), visitor);
			if (can) {
				ids.add(ticketStatusBO.getId());
			}
		}
		if (ids.size() > 0) {
			ticketInfoDaoMapper.updateTicketStatus(ids, vo.getStatus(), vo.getModifyBy());
		}
		return String.valueOf(ids.size());
	}

	/**
	 * 检查票并且获取票信息
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年3月20日 下午3:17:16
	 * @param id
	 * @return
	 */
	private List<TicketStatusBO> checkTicket(String id) {
		String[] ids = org.springframework.util.StringUtils.tokenizeToStringArray(id, SymbolConstants.COMMA);
		if (ObjectUtil.isBlank(ids)) {
			throw new ServiceRuntimeException("票不能空");
		}
		List<TicketStatusBO> list = ticketInfoDaoMapper.listTicketStatus(Arrays.asList(ids));
		if (list.size() != ids.length) {
			throw new ServiceRuntimeException("修改票与系统票不匹配");
		}
		return list;
	}

	@Override
	public void uploadTicketNo(String ticketType, String ticketNo) {
		throw new ServiceRuntimeException("上传票号具体业务未实现");
	}

	@Override
	public String updateTicketOperate(String operate, String id,String modifyBy) {
		List<TicketStatusBO> bos = checkTicket(id);
		TicketOperateVisitor visitor = new TicketOperateVisitor();
		Set<String> set = new HashSet<>();
		for (TicketStatusBO bo : bos) {
			Boolean can = VisitorHandler.disboseOrderStatus(bo.getTicketStatus(), bo, operate, visitor);
			if(!can){
				throw new ServiceRuntimeException("本地票号（"+bo.getId()+"）不能执行该操作,请重新选择");
			}
			set.add(bo.getBatchNum());
		}
		return org.springframework.util.StringUtils.collectionToDelimitedString(set,SymbolConstants.COMMA);
	}

	@Override
	public int addTicketAlarmInfo(TicketAlarmInfoVO vo) {
		TicketAlarmInfoPO po = new TicketAlarmInfoPO(vo);
		alarmInfoDaoMapper.addTicketAlarmInfo(po);
		return po.getId();
	}

	@Override
	public int countTicketStatus(String orderCode, int status) {
		return ticketInfoDaoMapper.countTicketStatus(orderCode,status);
	}

	@Override
	public List<TicketAlarmInfoBO> findTicketAlarmInfo(TicketAlarmInfoVO vo) {
		return alarmInfoDaoMapper.listPage(vo);
	}
}
