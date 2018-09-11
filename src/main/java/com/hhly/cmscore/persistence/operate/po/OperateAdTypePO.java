package com.hhly.cmscore.persistence.operate.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hhly.skeleton.cms.operatemgr.vo.OperateAdVO;

public class OperateAdTypePO {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 对象类型:1广告对象;2渠道对象，此字段 已删除
     */
    //private Integer type;

    /**
     * 用户类型:关联表M_TYPE
     */
    private Long mTypeId;

    /**
     * 广告ID
     */
    private Long advId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 市场渠道对象:关联OPERATE_MARKET_CHANNEL的channel_id，类型为varchar(20)
     */
    private String channelId;

    
	public OperateAdTypePO(Long mTypeId, Long advId, String channelId) {
		super();
		this.mTypeId = mTypeId;
		this.advId = advId;
		this.channelId = channelId;
	}

//	public static List<OperateAdTypePO> build(Set<Long> adTypes, int type) {
//		List<OperateAdTypePO> pos = new ArrayList<>();
//		for(OperateAdTypeVO vo : operateAdTypes) {
//			vo.setType(type);
//			pos.add(new OperateAdTypePO(vo));
//		}
//		return pos;
//	}

	/**
	 * @desc   构造多个OperateAdTypePO，如果选中"全部渠道"，调用此方法
	 * @author Tony Wang
	 * @create 2017年4月24日
	 * @param vo
	 * @return 
	 */
	public static List<OperateAdTypePO> buildUserTypes(OperateAdVO vo) {
		List<OperateAdTypePO> pos = new ArrayList<>();
		for(Long userTypeId : vo.getUserTypes()) {
			// OPERATE_ADV表的id即为OPERATE_ADV_TYPE表的ADV_ID
			pos.add(new OperateAdTypePO(userTypeId,vo.getId(),vo.getChannels().get(0)));
		}
		return pos;
	}
	
	/**
	 * @desc   构造多个OperateAdTypePO，如果选中"全部用户"，调用此方法
	 * @author Tony Wang
	 * @create 2017年4月24日
	 * @param vo
	 * @return 
	 */
	public static List<OperateAdTypePO> buildChannelTypes(OperateAdVO vo) {
		List<OperateAdTypePO> pos = new ArrayList<>();
		for(String channelId : vo.getChannels()) {
			// OPERATE_ADV表的id即为OPERATE_ADV_TYPE表的ADV_ID
			pos.add(new OperateAdTypePO(vo.getUserTypes().get(0),vo.getId(),channelId));
		}
		return pos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getmTypeId() {
		return mTypeId;
	}

	public void setmTypeId(Long mTypeId) {
		this.mTypeId = mTypeId;
	}

	public Long getAdvId() {
		return advId;
	}

	public void setAdvId(Long advId) {
		this.advId = advId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
}