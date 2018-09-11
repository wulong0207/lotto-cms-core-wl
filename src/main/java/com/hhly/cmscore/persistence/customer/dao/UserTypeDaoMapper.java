package com.hhly.cmscore.persistence.customer.dao;

import java.util.List;
import java.util.Map;

import com.hhly.cmscore.persistence.customer.po.UserTypePO;
import com.hhly.skeleton.cms.customermgr.bo.UserTypeBO;
import com.hhly.skeleton.cms.customermgr.bo.UserTypeExcelBO;
import com.hhly.skeleton.cms.customermgr.vo.UserTypeVO;

public interface UserTypeDaoMapper {

	int insert(UserTypePO po);
	
	int deleteByIds(List<String> ids);
	
	List<UserTypeBO> find(UserTypeVO vo);
	
	int findTotal(UserTypeVO vo);
	
	int updateById(UserTypePO po);
	
	List<UserTypeBO> findBaseUserType();
	
	List<UserTypeExcelBO> findExcelByTypeId(Integer typeId);
	
	/**
	 * 验证用户类型编码唯一
	 * @param code 类别编码
	 * @return
	 */
	int valiUserTypeCode(String code);

	/**
	 * 会员类型绑定会员id关系
	 * @param param
	 * @return
	 */
	boolean addTypeToUser(Map<String, String> param);
}