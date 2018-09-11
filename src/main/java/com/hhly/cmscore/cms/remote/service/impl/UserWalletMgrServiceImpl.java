package com.hhly.cmscore.cms.remote.service.impl;

import com.hhly.cmscore.cms.remote.service.IUserWalletMgrService;
import com.hhly.cmscore.persistence.customer.dao.UserWalletDaoMapper;
import com.hhly.persistence.common.Constants;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.constants.SymbolConstants;
import com.hhly.skeleton.base.page.AbstractStatisticsPage;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.util.NumberUtil;
import com.hhly.skeleton.cms.customermgr.bo.UserWalletBO;
import com.hhly.skeleton.cms.customermgr.vo.UserWalletVO;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @desc 会员钱包管理接口实现
 * @author huangb
 * @date 2017年2月8日
 * @company 益彩网络
 * @version v1.0
 */
@Service("userWalletMgrService")
public class UserWalletMgrServiceImpl implements IUserWalletMgrService {
	/**
	 * 会员钱包管理数据接口
	 */
	@Autowired
	private UserWalletDaoMapper userWalletDaoMapper;
	/**
	 * 分页服务
	 */
	@Autowired
	private IPageService pageService;

	@Override
	public PagingBO<UserWalletBO> findPaging(final UserWalletVO userWalletVO) {
		conditionConvert(userWalletVO);// 部分条件转换
		return pageService.getPageData(userWalletVO, new AbstractStatisticsPage<UserWalletBO>() {
			@Override
			public int getTotal() {
				this.setSis(userWalletDaoMapper.findCount(userWalletVO));
				return Integer.parseInt(this.getSis().get("count").toString());
			}

			@Override
			public List<UserWalletBO> getData() {
				this.setDataList(userWalletDaoMapper.findPaging(userWalletVO));
				return this.getDataList();
			}

			@Override
			public Object getOther() {
				List<UserWalletBO> data = Integer.parseInt(this.getSis().get("count").toString()) > Constants.NUM_0 ? this.getDataList()
						: Collections.<UserWalletBO> emptyList();
				return getSisInfoWallet(this.getSis(), data);
			}
		});
	}

	@Override
	public int updWalletStatusByIds(String ids, Short status) {
		return userWalletDaoMapper.updWalletStatusByIds(Arrays.asList(ids.split(SymbolConstants.COMMA)), status);
	}

	/**
	 * @desc 部分条件转换（如：各种用户查询类型，各种时间查询类型）
	 * @author huangb
	 * @date 2017年2月8日
	 * @param userWalletVO
	 *            参数对象
	 */
	private void conditionConvert(UserWalletVO userWalletVO) {
		// 如果指定了是否关联用户表，则不用继续后面的判断
		if(userWalletVO.getJoinUser() != null) {
			return ;
		}
		// 是否关联用户表
		if (userWalletVO.getUser() == null) {
			userWalletVO.setJoinUser(false);
		} else {
			if (StringUtils.isNotEmpty(userWalletVO.getUser().getNickName())
					|| StringUtils.isNotEmpty(userWalletVO.getUser().getAccountName())
					|| userWalletVO.getUser().getCusMobile() != null
					|| StringUtils.isNotEmpty(userWalletVO.getUser().getActualName())
					|| StringUtils.isNotEmpty(userWalletVO.getUser().getIdNum())) {
				userWalletVO.setJoinUser(true);
			}
		}
	}

	/**
	 * @desc 用户钱包的统计信息
	 * @author huangb
	 * @date 2017年2月8日
	 * @param sis
	 *            统计结果(按条件查询的统计结果)
	 * @param list
	 *            单页数据
	 * @return 用户钱包的统计信息
	 */
	private String[] getSisInfoWallet(Map<String, Object> sis, List<UserWalletBO> list) {

		String[] sisInfo = new String[12];
		double totalCash = 0;
		double totalWinning = 0;
		double totalTop80 = 0;
		double totalTop20 = 0;
		double totalEffRed = 0;
		double totalReadyRed = 0;
		// 单页统计
		if (list != null && !list.isEmpty()) {
			for (UserWalletBO temp : list) {
				if (temp.getTotalCashBalance() != null) {
					totalCash = NumberUtil.sum(totalCash, temp.getTotalCashBalance());
				}
				if (temp.getWinningBalance() != null) {
					totalWinning = NumberUtil.sum(totalWinning, temp.getWinningBalance());
				}
				if (temp.getTop80Balance() != null) {
					totalTop80 = NumberUtil.sum(totalTop80, temp.getTop80Balance());
				}
				if (temp.getTop20Balance() != null) {
					totalTop20 = NumberUtil.sum(totalTop20, temp.getTop20Balance());
				}
				if (temp.getEffRedBalance() != null) {
					totalEffRed = NumberUtil.sum(totalEffRed, temp.getEffRedBalance());
				}
				if (temp.getReadyRedBalance() != null) {
					totalReadyRed = NumberUtil.sum(totalReadyRed, temp.getReadyRedBalance());
				}
			}
		}
		sisInfo[0] = String.valueOf(totalCash);
		sisInfo[1] = String.valueOf(totalWinning);
		sisInfo[2] = String.valueOf(totalTop80);
		sisInfo[3] = String.valueOf(totalTop20);
		sisInfo[4] = String.valueOf(totalEffRed);
		sisInfo[5] = String.valueOf(totalReadyRed);

		// 条件统计
		sisInfo[6] = sis.get("totalCash") == null ? "0" : String.valueOf(sis.get("totalCash"));
		sisInfo[7] = sis.get("totalWinning") == null ? "0" : String.valueOf(sis.get("totalWinning"));
		sisInfo[8] = sis.get("totalTop80") == null ? "0" : String.valueOf(sis.get("totalTop80"));
		sisInfo[9] = sis.get("totalTop20") == null ? "0" : String.valueOf(sis.get("totalTop20"));
		sisInfo[10] = sis.get("totalEffRed") == null ? "0" : String.valueOf(sis.get("totalEffRed"));
		sisInfo[11] = sis.get("totalReadyRed") == null ? "0" : String.valueOf(sis.get(	"totalReadyRed"));

		return sisInfo;
	}

	@Override
	public List<UserWalletBO> findExcel(UserWalletVO userWalletVO) {
		conditionConvert(userWalletVO);// 部分条件转换
		Map<String, Object> sis = userWalletDaoMapper.findCount(userWalletVO);
		int num = NumberUtils.toInt(sis.get("count").toString());
		Assert.isTrue(num <= Constants.EXCEL_NUM, Constants.EXCEL_ERROR_MSG);
		return userWalletDaoMapper.findExcel(userWalletVO);
	}
}
