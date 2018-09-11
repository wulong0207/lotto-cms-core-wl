package com.hhly.cmscore.persistence.order.dao;

import java.util.List;

import com.hhly.cmscore.persistence.order.po.OrderIssuePO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderIssueBO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderIssueVO;

/**
 * @desc    发单Dao层
 * @author  Tony Wang
 * @date    2017年10月11日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface OrderIssueDaoMapper {

	/**************************** Used to CMS ******************************/
	int count(OrderIssueVO vo);

	List<OrderIssueBO> list(OrderIssueVO vo);
	
	int update(OrderIssuePO po);
	/**************************** Used to CMS ******************************/

	
}