package com.hhly.cmscore.persistence.operate.po;

import java.io.Serializable;
import java.util.Date;

import com.hhly.skeleton.cms.operatemgr.bo.OperateSoftwareVersionBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateSoftwareVersionVO;



/**
 * @desc    
 * @author  cheng chen
 * @date    2017年4月21日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class OperateSoftwareVersionPO implements Serializable{

	private static final long serialVersionUID = 8197937953566816643L;

	/**
     * 主键ID
     */
    private Integer id;

    /**
     * 版本号
     */
    private Integer code;
    
	/**
	 * 版本名称
	 */
	private String name; 
	
	/**
	 * 移动端类型; 1:ios; 2:android;
	 */
	private Short type;

    /**
     * 是否最新版本
     */
    private Short isnew;

    /**
     * 是否强制更新
     */
    private Short isupdate;
    
    /**
     * 版本大小
     */
    private String size;

    /**
     * 版本更新说明
     */
    private String describe;

    /**
     * 下载地址
     */
    private String url;
    
    /**
     * 移动端访问地址
     */
    private String appUrl;

    /**
     * 备注
     */
    private String remark;

    /**
     * null
     */
    private String createBy;

    /**
     * null
     */
    private String modifyBy;

    /**
     * null
     */
    private Date createTime;

    /**
     * null
     */
    private Date modifyTime;
    
	/**
	 * 渠道id
	 */
	private Integer channelId;
	
	/**
	 * APP功能隐藏板块，APP前端将不会展示
	 */
	private String hide;

	/**
	 * 购彩板块隐藏区域，如"深圳,广西"
	 */
	private String hideArea;
	
	/**
	 * 审核状态0:审核中;1已通过
	 */
	private Integer status;
	
	/**
	 * 是否与官方同步更新 0：否；1：是
	 */
	private Integer synOfficial;
	
	/**
	 * 审核开关备注
	 */
	private String switchRemark;
	/**
	 * 审核修改人
	 */
	private String switchModifyBy;
	/**
	 * 审核开关修改时间
	 */
	private Date switchModifyTime;
    

    public OperateSoftwareVersionPO(OperateSoftwareVersionVO vo) {
		super();
		this.id = vo.getId();
		this.code = vo.getCode();
		this.name = vo.getName();
		this.type = vo.getType();
		this.isnew = vo.getIsnew();
		this.isupdate = vo.getIsupdate();
		this.size = vo.getSize();
		this.describe = vo.getDescribe();
		this.url = vo.getUrl();
		this.appUrl = vo.getAppUrl();
		this.remark = vo.getRemark();
		this.createBy = vo.getCreateBy();
		this.modifyBy = vo.getModifyBy();
		this.channelId = vo.getChannelId();
		this.status = vo.getStatus();
		this.hide = vo.getHide();
		this.synOfficial = vo.getSynOfficial();
		this.switchRemark = vo.getSwitchRemark();
		this.switchModifyBy = vo.getSwitchModifyBy();
		this.switchModifyTime = vo.getSwitchModifyTime();
		this.hideArea = vo.getHideArea();
	}
    
    public OperateSoftwareVersionPO(OperateSoftwareVersionBO bo) {
    	super();
    	this.id = bo.getId();
    	this.code = bo.getCode();
    	this.name = bo.getName();
    	this.type = bo.getType();
    	this.isnew = bo.getIsnew();
    	this.isupdate = bo.getIsupdate();
    	this.size = bo.getSize();
    	this.describe = bo.getDescribe();
    	this.url = bo.getUrl();
    	this.appUrl = bo.getAppUrl();
    	this.remark = bo.getRemark();
    	this.createBy = bo.getCreateBy();
    	this.modifyBy = bo.getModifyBy();
    	this.channelId = bo.getChannelId();
    	this.status = bo.getStatus();
    	this.hide = bo.getHide();
    	this.synOfficial = bo.getSynOfficial();
    	this.switchRemark = bo.getSwitchRemark();
    	this.switchModifyBy = bo.getSwitchModifyBy();
    	this.switchModifyTime = bo.getSwitchModifyTime();
    }
    

	public OperateSoftwareVersionPO() {
	}

	/**
     * 主键ID
     * @return ID 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 版本号
     * @return CODE 版本号
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 版本号
     * @param code 版本号
     */
    public void setCode(Integer code) {
        this.code = code;
    }
        
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	/**
     * 是否最新版本
     * @return ISNEW 是否最新版本
     */
    public Short getIsnew() {
        return isnew;
    }

    /**
     * 是否最新版本
     * @param isnew 是否最新版本
     */
    public void setIsnew(Short isnew) {
        this.isnew = isnew;
    }

    /**
     * 是否强制更新
     * @return ISUPDATE 是否强制更新
     */
    public Short getIsupdate() {
        return isupdate;
    }

    /**
     * 是否强制更新
     * @param isupdate 是否强制更新
     */
    public void setIsupdate(Short isupdate) {
        this.isupdate = isupdate;
    }
        
    public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	/**
     * 版本更新说明
     * @return DESCRIBE 版本更新说明
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 版本更新说明
     * @param describe 版本更新说明
     */
    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    /**
     * 下载地址
     * @return URL 下载地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 下载地址
     * @param url 下载地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
    
    public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl == null ? null : appUrl.trim();
	}    

    /**
     * 备注
     * @return REMARK 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * null
     * @return CREATE_BY null
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * null
     * @param createBy null
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * null
     * @return MODIFY_BY null
     */
    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * null
     * @param modifyBy null
     */
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * null
     * @return CREATE_TIME null
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * null
     * @param createTime null
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * null
     * @return MODIFY_TIME null
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * null
     * @param modifyTime null
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getHide() {
		return hide;
	}

	public void setHide(String hide) {
		this.hide = hide;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSynOfficial() {
		return synOfficial;
	}

	public void setSynOfficial(Integer synOfficial) {
		this.synOfficial = synOfficial;
	}

	public String getSwitchRemark() {
		return switchRemark;
	}

	public void setSwitchRemark(String switchRemark) {
		this.switchRemark = switchRemark;
	}

	public String getSwitchModifyBy() {
		return switchModifyBy;
	}

	public void setSwitchModifyBy(String switchModifyBy) {
		this.switchModifyBy = switchModifyBy;
	}

	public Date getSwitchModifyTime() {
		return switchModifyTime;
	}

	public void setSwitchModifyTime(Date switchModifyTime) {
		this.switchModifyTime = switchModifyTime;
	}

	public String getHideArea() {
		return hideArea;
	}

	public void setHideArea(String hideArea) {
		this.hideArea = hideArea;
	}

	@Override
	public String toString() {
		return "OperateSoftwareVersionPO [id=" + id + ", hide=" + hide + "]";
	}
    
}