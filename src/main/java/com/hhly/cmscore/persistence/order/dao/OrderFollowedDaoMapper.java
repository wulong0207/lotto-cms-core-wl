package com.hhly.cmscore.persistence.order.dao;

import java.util.List;

import com.hhly.skeleton.cms.ordermgr.bo.OrderFollowedBO;
import com.hhly.skeleton.cms.ordermgr.bo.OrderFollowedExcelBO;
import com.hhly.skeleton.cms.ordermgr.vo.OrderFollowedVO;
import com.hhly.skeleton.cms.recommend.bo.RcmdUserCheckBO;
import com.hhly.skeleton.cms.recommend.vo.RcmdUserCheckVO;

/**
 * @desc    跟单Dao层
 * @author  Tony Wang
 * @date    2017年10月11日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface OrderFollowedDaoMapper {

	/**************************** Used to CMS ******************************/
	int count(OrderFollowedVO vo);

	List<OrderFollowedBO> list(OrderFollowedVO vo);
	
	List<OrderFollowedExcelBO> excel(OrderFollowedVO vo);
	/**************************** Used to CMS ******************************/


	/**************************** Rcmd User Check to CMS ******************************/
	int findRcmdUserCheckCount(RcmdUserCheckVO vo);
	
	List<RcmdUserCheckBO> findRcmdUserCheckList(RcmdUserCheckVO vo);
	
	int setStatus(RcmdUserCheckVO vo);
	
	int addRcmdUser(RcmdUserCheckVO vo);
	/**************************** Rcmd User Check to CMS ******************************/
	
}