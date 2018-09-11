package com.hhly.cmscore.persistence.operate.po;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.hhly.skeleton.cms.operatemgr.vo.OperateLotteryInfoVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateLotteryVO;

public class OperateLotteryPO {
	
	/**
	 * 自增长主键ID
	 */
  private Long id;

  /**
   * 发布编号
   */
  private final String releaseCode;

  /**
   * 发布平台:1WEB;2WAP;3ANDROID;4IOS
   */
  private final Byte platform;

  /**
   * 发布状态:0暂停发布;1待发布;2发布中;3发布结束
   */
  private final Byte status;

  /**
   * 备注说明
   */
  private final String lotteryDesc;

  /**
   * 上线时间
   */
  private final String onlineTime;

  /**
   * 下线时间
   */
  private final String offlineTime;

  /**
   * 创建人真实姓名
   */
  private final String createBy;

  /**
   * 修改人真实姓名
   */
  private final String modifyBy;

  /**
   * 上线时间
   */
  private final Short onlineWeek;

  /**
   * 下线时间
   */
  private final Short offlineWeek;
  /**
   * 是否默认
   */
  private final Short isDefault;
  private final List<OperateLotteryInfoPO> lotteryInfos;

  
	public OperateLotteryPO(OperateLotteryVO vo) {
		this.id = vo.getId();
		this.releaseCode = vo.getReleaseCode();
		this.platform = vo.getPlatform();
		this.status = vo.getStatus();
		this.lotteryDesc = vo.getLotteryDesc();
		this.onlineTime = vo.getOnlineTime();
		this.offlineTime = vo.getOfflineTime();
		this.createBy = vo.getCreateBy();
		this.modifyBy = vo.getModifyBy();
		this.onlineWeek =  vo.getOnlineWeek();
		this.offlineWeek =  vo.getOfflineWeek();
		this.isDefault = vo.getIsDefault();
		List<OperateLotteryInfoVO> source = vo.getLotteryInfos();
		if(CollectionUtils.isNotEmpty(source)) {
			OperateLotteryInfoPO lotteryInfo = null;
			List<OperateLotteryInfoPO> lotteryInfos = new ArrayList<>();
			for(int i=0,size=source.size(); i<size; i++){
				lotteryInfo = new OperateLotteryInfoPO(source.get(i).setLotteryId(this.id));
				lotteryInfos.add(lotteryInfo);
			}
			this.lotteryInfos = lotteryInfos;
		} else {
			this.lotteryInfos = Collections.emptyList();
		}
	}


	public Short getIsDefault() {
		return isDefault;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public Long getId() {
		return id;
	}


	public String getReleaseCode() {
		return releaseCode;
	}


	public Byte getPlatform() {
		return platform;
	}


	public Byte getStatus() {
		return status;
	}


	public String getLotteryDesc() {
		return lotteryDesc;
	}


	public Short getOnlineWeek() {
		return onlineWeek;
	}



	public Short getOfflineWeek() {
		return offlineWeek;
	}


	public String getOnlineTime() {
		return onlineTime;
	}

	public String getCreateBy() {
		return createBy;
	}


	public List<OperateLotteryInfoPO> getLotteryInfos() {
		return lotteryInfos;
	}


	public String getOfflineTime() {
		return offlineTime;
	}

}