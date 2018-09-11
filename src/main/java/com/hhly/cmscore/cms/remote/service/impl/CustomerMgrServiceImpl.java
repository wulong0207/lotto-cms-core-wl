package com.hhly.cmscore.cms.remote.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.hhly.cmscore.cms.remote.service.ICustomerMgrService;
import com.hhly.cmscore.persistence.customer.dao.LottoCustomerDaoMapper;
import com.hhly.cmscore.persistence.customer.dao.UserIssueDaoMapper;
import com.hhly.cmscore.persistence.customer.dao.UserIssueLevelDaoMapper;
import com.hhly.cmscore.persistence.customer.dao.UserTypeDaoMapper;
import com.hhly.cmscore.persistence.customer.dao.UserWinningStatisticsDaoMapper;
import com.hhly.cmscore.persistence.customer.po.LottoCustomerPO;
import com.hhly.cmscore.persistence.customer.po.UserIssueLevelPO;
import com.hhly.cmscore.persistence.customer.po.UserIssuePO;
import com.hhly.cmscore.persistence.customer.po.UserTypePO;
import com.hhly.cmscore.persistence.customerservice.dao.MUserMessageDaoMapper;
import com.hhly.persistence.common.Constants;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.constants.SymbolConstants;
import com.hhly.skeleton.base.exception.ServiceRuntimeException;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.page.ISimplePage;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.cms.base.vo.StringVO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerBO;
import com.hhly.skeleton.cms.customermgr.bo.LottoCustomerExcelBO;
import com.hhly.skeleton.cms.customermgr.bo.UserIssueBO;
import com.hhly.skeleton.cms.customermgr.bo.UserIssueExcelBO;
import com.hhly.skeleton.cms.customermgr.bo.UserIssueLevelBO;
import com.hhly.skeleton.cms.customermgr.bo.UserTypeBO;
import com.hhly.skeleton.cms.customermgr.bo.UserTypeExcelBO;
import com.hhly.skeleton.cms.customermgr.bo.UserWinningStatisticsBO;
import com.hhly.skeleton.cms.customermgr.bo.UserWinningStatisticsExcelBO;
import com.hhly.skeleton.cms.customermgr.vo.LottoCustomerVO;
import com.hhly.skeleton.cms.customermgr.vo.UserIssueLevelVO;
import com.hhly.skeleton.cms.customermgr.vo.UserIssueVO;
import com.hhly.skeleton.cms.customermgr.vo.UserTypeVO;
import com.hhly.skeleton.cms.customermgr.vo.UserWinningStatisticsVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgUserConfigVo;
@Service("customerMgrService")
public class CustomerMgrServiceImpl implements ICustomerMgrService {
	
	@Autowired
    private LottoCustomerDaoMapper customerDaoMapper;
	
	@Autowired
	private UserWinningStatisticsDaoMapper userWinningStatisticsDaoMapper;
	
	@Autowired
	private UserTypeDaoMapper userTypeDaoMapper;
	
	@Autowired
    private UserIssueDaoMapper userIssueDaoMapper;
	
	@Autowired
	private UserIssueLevelDaoMapper userIssueLevelDaoMapper;
	
	@Autowired
	private MUserMessageDaoMapper  userMessageDaoMapper;
	
	@Autowired
	private IPageService pageService;


	@Value("${before_file_url}")
	private String beforeFileUrl;
	
	@Override
	public PagingBO<LottoCustomerBO> findLottoCustomer(final LottoCustomerVO vo) {
		return pageService.getPageData(vo,new ISimplePage<LottoCustomerBO>() {
			@Override
			public int getTotal() {
				return customerDaoMapper.findTotal(vo);
			}
			@Override
			public List<LottoCustomerBO> getData() {
				List<LottoCustomerBO> customers = customerDaoMapper.find(vo);
				if(!CollectionUtils.isEmpty(customers)) {
					for(LottoCustomerBO customer : customers) {
						if(StringUtils.hasText(customer.getHeadUrl())) {
							customer.setHeadUrl(beforeFileUrl + customer.getHeadUrl());
						}
					}
				}
				return customers;
			}
		});
	}

	@Override
	public List<LottoCustomerExcelBO> findLottoCustomerExcel(LottoCustomerVO vo) {
		int num = customerDaoMapper.findTotal(vo);
		Assert.isTrue(num <= Constants.EXCEL_NUM,Constants.EXCEL_ERROR_MSG);
		return customerDaoMapper.findLottoCustomerExcel(vo);
	}

	@Override
	public LottoCustomerBO findLottoCustomerDetail(StringVO vo) {
		LottoCustomerBO customer = customerDaoMapper.findLottoCustomerDetail(vo.getStr());
		if(customer != null && StringUtils.hasText(customer.getHeadUrl())) {
			customer.setHeadUrl(beforeFileUrl + customer.getHeadUrl());
		}
		customer.setCusMailCount(getSendCount(customer.getCusMail()));
		Long mobile = customer.getCusMobile();
		if(mobile != null && mobile > 0){
			customer.setCusMobileCount(getSendCount(mobile.toString()));
		}
		return customer;
	}
	/**
	 * 获取当天发送信息次数
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2018年1月11日 下午5:44:41
	 * @param account
	 * @return
	 */
	private int getSendCount(String account){
		if(StringUtils.isEmpty(account)){
			return 0;
		}
		String startDate = DateUtil.getNow(DateUtil.DATE_FORMAT);
		String endDate = DateUtil.getNow(DateUtil.DEFAULT_FORMAT);
	    return userMessageDaoMapper.findSendCount(startDate,endDate,account);
	};

	@Override
	public int updLottoCustomer(LottoCustomerVO vo) {
		LottoCustomerPO po = new LottoCustomerPO(vo);
		return customerDaoMapper.updateByCms(po);
	}

	@Override
	public PagingBO<UserWinningStatisticsBO> listUserWinningStatistics(final UserWinningStatisticsVO vo) {
		return pageService.getPageData(vo,new ISimplePage<UserWinningStatisticsBO>() {
			@Override
			public int getTotal() {
				return userWinningStatisticsDaoMapper.findTotal(vo);
			}
			@Override
			public List<UserWinningStatisticsBO> getData() {
				return userWinningStatisticsDaoMapper.find(vo);
			}
		});
	}

	@Override
	public List<UserWinningStatisticsExcelBO> listUserWinningStatisticsExcel(UserWinningStatisticsVO vo) {
		int num = userWinningStatisticsDaoMapper.findTotal(vo);
		Assert.isTrue(num <= Constants.EXCEL_NUM,Constants.EXCEL_ERROR_MSG);
		return userWinningStatisticsDaoMapper.findUserWinningStatisticsExcel(vo);
	}

	@Override
	public int addUserType(UserTypeVO vo) {
		UserTypePO po = new UserTypePO();
		po.setCode(vo.getCode());
		po.setName(vo.getName());
		po.setDescribe(vo.getDescribe());
		po.setRemark(vo.getRemark());
		po.setCreateBy(vo.getCreateBy());
		int num = userTypeDaoMapper.insert(po);
		if(num > 0)
			return po.getId();
		return num;
	}
	
	@Override
	public void addTypeToUser(String typeCode) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("typeCode", typeCode);
		userTypeDaoMapper.addTypeToUser(paramMap);
	}

	@Override
	public int delUserTypeByIds(StringVO vo) {
		List<String> ids = Arrays.asList(vo.getStr().split(SymbolConstants.UNDERLINE));
		return userTypeDaoMapper.deleteByIds(ids);
	}

	@Override
	public PagingBO<UserTypeBO> findUserTypeList(final UserTypeVO vo) {
		return pageService.getPageData(vo, new ISimplePage<UserTypeBO>() {

			@Override
			public int getTotal() {
				return userTypeDaoMapper.findTotal(vo);
			}

			@Override
			public List<UserTypeBO> getData() {
				return userTypeDaoMapper.find(vo);
			}
			
		});
	}

	@Override
	public int updateUserTypeById(UserTypeVO vo) {
		UserTypePO po = new UserTypePO();
		po.setId(vo.getId());
		po.setCode(vo.getCode());
		po.setName(vo.getName());
		po.setDescribe(vo.getDescribe());
		po.setRemark(vo.getRemark());
		po.setModifyBy(vo.getModifyBy());
		return userTypeDaoMapper.updateById(po);
	}
	
	@Override
	public List<UserTypeBO> findBaseUserType(){
		return userTypeDaoMapper.findBaseUserType();
	}

	@Override
	public List<UserTypeExcelBO> findExcelByTypeId(Integer typeId) {
		return userTypeDaoMapper.findExcelByTypeId(typeId);
	}

	@Override
	public int valiUserTypeCode(String code) {
		return userTypeDaoMapper.valiUserTypeCode(code);
	}
	
	@Override
	public int updateMsgConfig(OperateMsgUserConfigVo vo) {
		LottoCustomerPO po=new LottoCustomerPO(vo);
		return customerDaoMapper.updateMsgConfig(po);
	}

	/**
	 * @desc   查找用户id
	 * @author Tony Wang
	 * @create 2017年7月6日
	 * @param vo
	 * @return 
	 */
	@Override
	public List<Integer> findIds(LottoCustomerVO vo) {
		return customerDaoMapper.findIds(vo);
	}

	/*************************** 发单相关 start *****************************************/
	@Override
	public PagingBO<UserIssueBO> pageUserIssue(final UserIssueVO vo) {
		if(vo.getLevel() != null) {
			// 当按'专家''用户'查询时要特殊处理
			// 先查询出是专家的所有user_issue_info_id
			UserIssueLevelVO levelvo = new UserIssueLevelVO();
			// 0：普通用户,1:专家
			levelvo.setLevel(1);
			List<Integer> ids = userIssueLevelDaoMapper.findDistinctUserId(levelvo);
			// 在level表中没有专家记录即为用户
			if(Objects.equals(1, vo.getLevel())) {
				vo.setIds(ids);
			} else {
				vo.setNegativeIds(ids);
			}
			vo.setLevel(null);
		}
		return pageService.getPageData(vo,new ISimplePage<UserIssueBO>() {
			@Override
			public int getTotal() {
				return userIssueDaoMapper.count(vo);
			}
			@Override
			public List<UserIssueBO> getData() {
				return processIssueLevle(userIssueDaoMapper.find(vo));
			}
		});
	}

	private List<UserIssueBO> processIssueLevle(List<UserIssueBO> userIssues) {
		// 需要查询level的用户
		Set<Integer> users = new HashSet<>();
		for(UserIssueBO userIssue : userIssues) {
			users.add(userIssue.getId());
		}
		UserIssueLevelVO vo = new UserIssueLevelVO();
		vo.setUserIssueInfoIds(users);
		// 0：普通用户,1:专家
		vo.setLevel(1);
		List<UserIssueLevelBO> list = userIssueLevelDaoMapper.find(vo);
		Set<Integer> userIds = new HashSet<>();
		// m_user_issue_level的user_issue_info_id即为m_user_issue_info的id
		for(UserIssueLevelBO userLevel : list) {
			userIds.add(userLevel.getUserIssueInfoId());
		}
		for(UserIssueBO userIssue : userIssues) {
			// 用户等级,0：普通用户,1:专家
			userIssue.setLevel(userIds.contains(userIssue.getId()) ? 1 : 0);
		}
		return userIssues;
	}

	@Override
	public List<UserIssueBO> findUserIssue(UserIssueVO vo) {
		return userIssueDaoMapper.find(vo);
	}

	@Override
	public int updateUserIssue(UserIssueVO vo) {
		UserIssuePO po = new UserIssuePO(vo);
		Assert.notNull(po.getId(), "======>更新发单用户时id为空，参数为"+po);
		return userIssueDaoMapper.update(po);
	}
	
	@Override
	public List<UserIssueExcelBO> excelUserIssue(UserIssueVO vo) {
		return processIssueExcelLevel(userIssueDaoMapper.excel(vo));
	}
	
	private List<UserIssueExcelBO> processIssueExcelLevel(List<UserIssueExcelBO> userIssues) {
		// 需要查询level的用户
		Set<Integer> users = new HashSet<>();
		for(UserIssueExcelBO userIssue : userIssues) {
			users.add(userIssue.getId());
		}
		UserIssueLevelVO vo = new UserIssueLevelVO();
		vo.setUserIssueInfoIds(users);
		// 0：普通用户,1:专家
		vo.setLevel(1);
		List<UserIssueLevelBO> list = userIssueLevelDaoMapper.find(vo);
		Set<Integer> userIds = new HashSet<>();
		for(UserIssueLevelBO userLevel : list) {
			userIds.add(userLevel.getUserIssueInfoId());
		}
		for(UserIssueExcelBO userIssue : userIssues) {
			// 用户等级,0：普通用户,1:专家
			userIssue.setLevel(userIds.contains(userIssue.getId()) ? "1" : "0");
		}
		return userIssues;
	}

	@Override
	public int mergeUserIssueLevel(UserIssueLevelVO vo) {
		Date now = new Date();
		vo.setModifyTime(now);
		vo.setUpdateTime(now);
		UserIssueLevelPO po = new UserIssueLevelPO(vo);
		if(po.getId()==null) {
			// 若是新增
			Assert.notNull(po.getUserIssueInfoId(), "======>新增发单用户级别时发单用户id为空，参数为"+po);
			Assert.notNull(po.getLotteryCode(), "======>新增发单用户级别时彩种为空，参数为"+po);
			po.setCreateTime(now);
		} 
		return userIssueLevelDaoMapper.merge(po);
	}
	
	@Override
	public UserIssueLevelBO findOneUserIssueLevel(UserIssueLevelVO vo) {
		return userIssueLevelDaoMapper.findOne(vo);
	}
	/*************************** 发单相关  end*****************************************/

	@Override
	public void updLottoCustomerPassword(LottoCustomerVO vo) {
		LottoCustomerPO po=new LottoCustomerPO();
		po.setId(vo.getId());
		po.setAccountPassword(vo.getAccountPassword());
		po.setModifyBy(vo.getModifyBy());
		customerDaoMapper.updLottoCustomerPassword(po);
	}

	@Override
	public void updateCleanMessage(LottoCustomerVO vo) {
		String account = "";
		if("0".equals(vo.getType()) && vo.getCusMobile() !=null ){
			account =  String.valueOf(vo.getCusMobile());
		}else if("1".equals(vo.getType())){
			account =  vo.getCusMail();
		}
		if(StringUtils.isEmpty(account)){
			throw new ServiceRuntimeException("参数错误！手机号或邮箱不能为空");
		}
		userMessageDaoMapper.updateCleanMessage(account);
	}
}