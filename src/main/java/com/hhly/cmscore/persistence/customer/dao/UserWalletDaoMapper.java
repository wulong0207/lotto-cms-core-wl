package com.hhly.cmscore.persistence.customer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hhly.skeleton.cms.customermgr.bo.UserWalletBO;
import com.hhly.skeleton.cms.customermgr.vo.UserWalletVO;

/**
 * @desc 用户钱包数据接口
 * @author huangb
 * @date 2017年2月8日
 * @company 益彩网络
 * @version v1.0
 */
public interface UserWalletDaoMapper {

	/**
	 * @desc 查询分页列表
	 * @author huangb
	 * @date 2017年2月8日
	 * @param userWalletVO
	 *            参数对象
	 * @return 查询分页列表
	 */
	List<UserWalletBO> findPaging(UserWalletVO userWalletVO);

	/**
	 * @desc 查询记录数量
	 * @author huangb
	 * @date 2017年2月8日
	 * @param userWalletVO
	 *            查询参数
	 * @return 记录数及各金额统计信息
	 */
	Map<String, Object> findCount(UserWalletVO userWalletVO);

	/**
	 * @desc 修改钱包状态（如：批量启用、批量禁用）
	 * @author huangb
	 * @date 2017年2月8日
	 * @param ids
	 *            钱包id列表
	 * @param status
	 *            状态值
	 * @return 修改钱包状态
	 */
	int updWalletStatusByIds(@Param("ids") List<String> ids, @Param("status") Short status);

	/**
	 * @desc 查询excel导出的用户钱包数据
	 * @author huangb
	 * @date 2017年2月9日
	 * @param userWalletVO
	 *            查询参数
	 * @return excel导出的用户钱包数据
	 */
	List<UserWalletBO> findExcel(UserWalletVO userWalletVO);

}
