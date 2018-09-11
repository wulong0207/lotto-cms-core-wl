package com.hhly.cmscore.persistence.customer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.customer.po.LottoCustomerPO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerBO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerExcelBO;
import com.hhly.skeleton.cms.customermgr.vo.LottoCustomerVO;

public interface LottoCustomerDaoMapper {

	List<LottoCustomerBO> find(LottoCustomerVO vo);

	int findTotal(LottoCustomerVO vo);

	List<LottoCustomerExcelBO> findLottoCustomerExcel(LottoCustomerVO vo);

	LottoCustomerBO findLottoCustomerDetail(@Param("id")String id);

	int updateByCms(LottoCustomerPO po);
	
	int updateMsgConfig(LottoCustomerPO po);

	/**
	 * @desc   查找用户id
	 * @author Tony Wang
	 * @create 2017年7月6日
	 * @param vo
	 * @return 
	 */
	List<Integer> findIds(LottoCustomerVO vo);
    /**
     * 修改用户密码
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2018年1月9日 下午12:27:23
     * @param po
     */
	void updLottoCustomerPassword(LottoCustomerPO po);

}
