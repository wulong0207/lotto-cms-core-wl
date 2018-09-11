package com.hhly.cmscore.persistence.operate.po;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.hhly.skeleton.cms.operatemgr.vo.OperateFastInfoVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateFastVO;

public class OperateFastPO {
	
	/**
	 * 自增长主键ID
	 */
  private Long id;

  /**
   * 发布编号
   */
  private  String fastCode;

  /**
   * 发布平台:1WEB;2WAP;3ANDROID;4IOS
   */
  private  Short platform;
  
  /**
   * 模块页面:1.主站Web首页
   */
  private  Short position;

  /**
   * 发布状态:0暂停发布;1待发布;2发布中;3发布结束
   */
  private  Short status;

  /**
   * 备注说明
   */
  private  String fastDesc;

  /**
   * 上线时间
   */
  private  String onlineTime;

  /**
   * 下线时间
   */
  private  String offlineTime;
  /**
   * 上线时间
   */
  private Short onlineWeek;

  /**
   * 下线时间
   */
  private Short offlineWeek;
  /**
   * 创建人真实姓名
   */
  private  String createBy;

  /**
   * 修改人真实姓名
   */
  private  String modifyBy;
  
  private Short isDefault;
  private  List<OperateFastInfoPO> fastInfos;

  
	public OperateFastPO(OperateFastVO vo) {
		this.id = vo.getId();
		this.fastCode = vo.getFastCode();
		this.platform = vo.getPlatform();
		this.position = vo.getPosition();
		this.status = vo.getStatus();
		this.fastDesc = vo.getFastDesc();
		this.onlineTime = vo.getOnlineTime();
		this.offlineTime = vo.getOfflineTime();
		this.createBy = vo.getCreateBy();
		this.modifyBy = vo.getModifyBy();
		this.onlineWeek =  vo.getOnlineWeek();
		this.offlineWeek =  vo.getOfflineWeek();
		this.isDefault = vo.getIsDefault();
		List<OperateFastInfoVO> source = vo.getFastInfos();
		if(CollectionUtils.isNotEmpty(source)) {
			OperateFastInfoPO fastInfo = null;
			List<OperateFastInfoPO> fastInfos = new ArrayList<>();
			for(int i=0,size=source.size(); i<size; i++){
				fastInfo = new OperateFastInfoPO(source.get(i).setFastId(vo.getId()));
				fastInfos.add(fastInfo);
			}
			this.fastInfos = fastInfos;
		} else {
			this.fastInfos = Collections.emptyList();
		}
	}


	public Short getIsDefault() {
		return isDefault;
	}


	public void setIsDefault(Short isDefault) {
		this.isDefault = isDefault;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFastCode() {
		return fastCode;
	}


	public void setFastCode(String fastCode) {
		this.fastCode = fastCode;
	}


	public Short getPlatform() {
		return platform;
	}


	public void setPlatform(Short platform) {
		this.platform = platform;
	}


	public Short getPosition() {
		return position;
	}


	public void setPosition(Short position) {
		this.position = position;
	}


	public Short getStatus() {
		return status;
	}


	public void setStatus(Short status) {
		this.status = status;
	}


	public String getFastDesc() {
		return fastDesc;
	}


	public void setFastDesc(String fastDesc) {
		this.fastDesc = fastDesc;
	}


	public String getOnlineTime() {
		return onlineTime;
	}


	public void setOnlineTime(String onlineTime) {
		this.onlineTime = onlineTime;
	}


	public String getOfflineTime() {
		return offlineTime;
	}


	public void setOfflineTime(String offlineTime) {
		this.offlineTime = offlineTime;
	}


	public String getCreateBy() {
		return createBy;
	}


	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}


	public String getModifyBy() {
		return modifyBy;
	}


	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}


	public List<OperateFastInfoPO> getFastInfos() {
		return fastInfos;
	}


	public void setFastInfos(List<OperateFastInfoPO> fastInfos) {
		this.fastInfos = fastInfos;
	}


	public Short getOnlineWeek() {
		return onlineWeek;
	}


	public void setOnlineWeek(Short onlineWeek) {
		this.onlineWeek = onlineWeek;
	}


	public Short getOfflineWeek() {
		return offlineWeek;
	}


	public void setOfflineWeek(Short offlineWeek) {
		this.offlineWeek = offlineWeek;
	}	
}