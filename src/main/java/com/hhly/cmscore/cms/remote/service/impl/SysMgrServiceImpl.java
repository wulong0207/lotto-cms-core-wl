package com.hhly.cmscore.cms.remote.service.impl;

import com.hhly.cmscore.cms.remote.service.ISysMgrService;
import com.hhly.cmscore.persistence.dic.dao.DicDataDaoMapper;
import com.hhly.cmscore.persistence.dic.dao.DicDataDetailDaoMapper;
import com.hhly.cmscore.persistence.dic.po.DicDataDetailPO;
import com.hhly.cmscore.persistence.dic.po.DicDataPO;
import com.hhly.cmscore.persistence.sys.dao.*;
import com.hhly.cmscore.persistence.sys.po.*;
import com.hhly.persistence.util.MD5Util;
import com.hhly.persistence.util.RedisUtil;
import com.hhly.redis.annotation.DeleteThroughAssignCache;
import com.hhly.redis.annotation.ParameterValueKeyProvider;
import com.hhly.redis.annotation.ReadThroughAssignCache;
import com.hhly.redis.annotation.RedisCacheType;
import com.hhly.skeleton.base.bo.DictionaryBO;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.constants.CacheConstants;
import com.hhly.skeleton.base.constants.SymbolConstants;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.page.ISimplePage;
import com.hhly.skeleton.base.util.ObjectUtil;
import com.hhly.skeleton.cms.base.vo.StringVO;
import com.hhly.skeleton.cms.dicmgr.bo.DicDataBO;
import com.hhly.skeleton.cms.dicmgr.bo.DicDataDetailBO;
import com.hhly.skeleton.cms.dicmgr.vo.DicDataDetailVO;
import com.hhly.skeleton.cms.dicmgr.vo.DicDataVO;
import com.hhly.skeleton.cms.sysmgr.bo.*;
import com.hhly.skeleton.cms.sysmgr.vo.*;
import com.hhly.skeleton.user.bo.KeywordBO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lgs on 2016/11/11. 系统管理hessian接口
 */
@Service("sysMgrService")
public class SysMgrServiceImpl implements ISysMgrService {

	@Autowired
	private DicDataDetailDaoMapper dataDetailDaoMapper;

	@Autowired
	private DicDataDaoMapper dicDataDaoMapper;

	@Autowired
	private CmsMenuDaoMapper cmsMenuDaoMapper;

	@Autowired
	private CmsRoleMenuDaoMapper cmsRoleMenuDaoMapper;

	@Autowired
	private CmsRoleDaoMapper cmsRoleDaoMapper;

	@Autowired
	private CmsUserDaoMapper cmsUserDaoMapper;
	
	@Autowired
	private CmsUserTypeDaoMapper cmsUserTypeDaoMapper;

	@Autowired
	private CmsUserMenuDaoMapper cmsUserMenuDaoMapper;
	
	@Autowired
	private CmsUserLogDaoMapper cmsUserLogDaoMapper;

	@Autowired
	private DicDataDetailDaoMapper dicDataDetailDaoMapper;

	@Autowired
	private CmsKeywordDaoMapper cmsKeywordDaoMapper;

	@Autowired
	private PayBankSegmentDaoMapper payBankSegmentDaoMapper;

	@Autowired
	private IPageService pageService;

	@Resource
	private RedisUtil redisUtil;
	
	@Value("${before_file_url}")
	private String beforeFileUrl;

	@Override
	public List<CMSMenuBO> selectAll() {
		List<CMSMenuBO> results = cmsMenuDaoMapper.selectMenuAll();
		return results;
	}

	@Override
	public List<CMSMenuBO> findMenuByUserId(Integer userId) {
		return cmsMenuDaoMapper.findMenuByUserId(userId);
	}

	@Override
	public int updateCmsMenu(List<CMSMenuBO> updBo, List<CMSMenuBO> insBo, List<Integer> ids) {
		try {
			// 更新菜单
			for (CMSMenuBO bo : updBo) {
				cmsMenuDaoMapper.updateByPrimaryKeySelective(new CmsMenuPO(bo));
			}
			// 新增菜单
			for (CMSMenuBO bo : insBo) {
				cmsMenuDaoMapper.insert(new CmsMenuPO(bo));
			}
			// 删除菜单
			for (Integer item : ids) {// 删除前先把角色所拥有的菜单的删除
				CmsRoleMenuPO po = new CmsRoleMenuPO();
				po.setMenuId(item);
				cmsRoleMenuDaoMapper.deleteByPrimaryKey(po);
				cmsMenuDaoMapper.deleteByPrimaryKey(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

		return 1;
	}

	/**
	 * @desc   根据条件查询菜单
	 * @author Tony Wang
	 * @create 2017年5月26日
	 * @param vo
	 * @return 
	 */
	@Override
	public List<CMSMenuBO> findMenus(CMSMenuVO vo) {
		return cmsMenuDaoMapper.findMenus(vo);
	}
	
	@Override
	public PagingBO<CMSRoleBO> selectRoleData(final CMSRoleVO cmsRoleVO) {

		return pageService.getPageData(cmsRoleVO, new ISimplePage<CMSRoleBO>() {
			@Override
			public int getTotal() {
				return cmsRoleDaoMapper.findTotalBySelective(cmsRoleVO);
			}

			@Override
			public List<CMSRoleBO> getData() {
				return cmsRoleDaoMapper.findDataBySelective(cmsRoleVO);
			}
		});
	}

	@Override
	public List<CMSRoleBO> findRoleName() {
		return cmsRoleDaoMapper.findRoleName();
	}

	@Override
	public List<CMSRoleMenuBO> findAuthorityByRoleId(Integer roleId) {
		List<CMSRoleMenuBO> bos = cmsRoleMenuDaoMapper.findAuthorityByRoleId(roleId);
		for (CMSRoleMenuBO bo : bos) {
			getAuth(bo);
		}
		return bos;
	}

	@Override
	public int saveRoleChange(List<CMSRoleMenuVO> roleMenus, CMSRoleVO vo) {
		if (vo.getRoleId() != null) {
			cmsRoleDaoMapper.updateByPrimaryKey(new CmsRolePO(vo));
			CmsRoleMenuPO po = new CmsRoleMenuPO();
			po.setRoleId(vo.getRoleId());
			cmsRoleMenuDaoMapper.deleteByPrimaryKey(po);
			for (CMSRoleMenuVO roleMenuVO : roleMenus) {
				roleMenuVO.setRoleId(vo.getRoleId());
				cmsRoleMenuDaoMapper.insert(new CmsRoleMenuPO(roleMenuVO));
			}
		} else {
			CmsRolePO po = new CmsRolePO(vo);
			cmsRoleDaoMapper.insert(po);
			for (CMSRoleMenuVO roleMenuVO : roleMenus) {
				roleMenuVO.setRoleId(po.getRoleId());
				cmsRoleMenuDaoMapper.insert(new CmsRoleMenuPO(roleMenuVO));
			}
		}
		return 1;
	}

	@Override
	public int deleteRole(CMSRoleVO vo) {
		cmsRoleDaoMapper.deleteByPrimaryKey(vo.getRoleId());
		CmsRoleMenuPO po = new CmsRoleMenuPO();
		po.setRoleId(vo.getRoleId());
		return cmsRoleMenuDaoMapper.deleteByPrimaryKey(po);
	}

	@Override
	public PagingBO<CMSUserBO> findUserData(final CMSUserVO vo) {
		return pageService.getPageData(vo, new ISimplePage<CMSUserBO>() {
			@Override
			public int getTotal() {
				return cmsUserDaoMapper.findTotalBySelective(vo);
			}
			@Override
			public List<CMSUserBO> getData() {
				List<CMSUserBO> users = cmsUserDaoMapper.findDataBySelective(vo);
		    	if(!CollectionUtils.isEmpty(users)) {
		    		for(CMSUserBO user : users) {
		    			if(StringUtils.hasText(user.getHeadUrl())) {
		    				user.setHeadUrl(beforeFileUrl + user.getHeadUrl());
		    			}
		    		}
		    	}
		    	return users;
			}
		});
	}

	@Override
	public List<CMSUserAuthTreeBO> findUserAuth(CMSUserVO vo) {
		List<CMSUserAuthTreeBO> bos = cmsUserMenuDaoMapper.findUserAuthTree(vo);
		for (CMSUserAuthTreeBO bo : bos) {
			getAuth(bo);
		}
		return bos;
	}

	@Override
	public Integer saveUser(CMSUserVO vo, List<CMSUserMenuVO> userMenuVOs) {
		try {
			if (vo.getUserId() == null) {
				vo.setUserPassword(MD5Util.encrypt("CPadmin888"));
				CmsUserPO po = new CmsUserPO(vo);
				cmsUserDaoMapper.insert(po);
				for (CMSUserMenuVO menuVO : userMenuVOs) {
					menuVO.setUserId(po.getUserId());
					cmsUserMenuDaoMapper.insert(new CmsUserMenuPO(menuVO));
				}
			} else {
				cmsUserDaoMapper.updateByPrimaryKeySelective(new CmsUserPO(vo));
				CmsUserMenuPO po = new CmsUserMenuPO();
				po.setUserId(vo.getUserId());
				cmsUserMenuDaoMapper.deleteByPrimaryKey(po);
				for (CMSUserMenuVO menuVO : userMenuVOs) {
					menuVO.setUserId(vo.getUserId());
					cmsUserMenuDaoMapper.insert(new CmsUserMenuPO(menuVO));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

		return 1;
	}

	@Override
	public Integer delUser(Integer userId) {
		return cmsUserDaoMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public String findUserName(CMSUserVO vo) {
		return cmsUserDaoMapper.findUserName(vo);
	}

	@Override
	public Integer findCount(CMSUserVO vo) {
		return cmsUserDaoMapper.findCount(vo);
	}

	@Override
	public Integer updatePwd(CMSUserVO vo) {
		return cmsUserDaoMapper.updatePwd(new CmsUserPO(vo));
	}

	@Override
	public CMSUserLoginBO login(CMSUserVO vo) {
		return cmsUserDaoMapper.findUser(vo);
	}

	@Override
	public Integer updateUserLastLoginTime(CMSUserVO vo) {
		return cmsUserDaoMapper.updateUserLastLoginTime(new CmsUserPO(vo));
	}

	@Override
	public PagingBO<DicDataBO> findDicData(final DicDataVO vo) {
		return pageService.getPageData(vo, new ISimplePage<DicDataBO>() {

			@Override
			public int getTotal() {
				return dicDataDaoMapper.findTotal(vo);
			}

			@Override
			public List<DicDataBO> getData() {
				return dicDataDaoMapper.find(vo);
			}
		});
	}

	@Override
	public int addDicData(DicDataVO dicDataVO) {
		DicDataPO po = new DicDataPO(dicDataVO);
		return dicDataDaoMapper.add(po);
	}

	@Override
	public int updDicData(DicDataVO dicDataVO) {
		DicDataPO po = new DicDataPO(dicDataVO);
		return dicDataDaoMapper.updByPrimaryKey(po);
	}

	public List<DicDataDetailBO> findDicDataDetail(StringVO vo) {
		return dataDetailDaoMapper.findByCode(vo.getStr());
	}

	@Override
	public PagingBO<DicDataDetailBO> findDicDataDetails(final DicDataDetailVO vo) {

		return pageService.getPageData(vo, new ISimplePage<DicDataDetailBO>() {

			@Override
			public int getTotal() {
				return dataDetailDaoMapper.findTotal(vo);
			}

			@Override
			public List<DicDataDetailBO> getData() {
				return dataDetailDaoMapper.findDicDatail(vo);
			}
		});
	}

	@Override
	public int delDicDataDetail(StringVO vo) {
		List<String> ids = Arrays.asList(vo.getStr().split(SymbolConstants.UNDERLINE));
		if (CollectionUtils.isEmpty(ids)) {
			return 0;
		}
		String code = dataDetailDaoMapper.getdataDetailCode(ids.get(0));
		((SysMgrServiceImpl) AopContext.currentProxy()).deleteRedis(code);
		int result = dataDetailDaoMapper.delByPrimaryKeyList(ids);
		//如果更新了号码段，则实时更新缓存
		resetRedis(code);
		return result;
	}

	@Override
	public int updDicDataDetail(DicDataDetailVO vo) {
		DicDataDetailPO po = new DicDataDetailPO(vo);
		((SysMgrServiceImpl) AopContext.currentProxy()).deleteRedis(po.getDicCode());
		int result = dataDetailDaoMapper.updByPrimaryKey(po);
		//如果更新了号码段，则实时更新缓存
		resetRedis(po.getDicCode());
		return result;
	}

	@Override
	public int addDicDataDetail(DicDataDetailVO vo) {
		DicDataDetailPO po = new DicDataDetailPO(vo);
		((SysMgrServiceImpl) AopContext.currentProxy()).deleteRedis(vo.getDicCode());
		int result = dataDetailDaoMapper.add(po);
		//如果更新了号码段，则实时更新缓存
		resetRedis(po.getDicCode());
		return result;
	}

	@Override
	public List<DicDataDetailBO> findDicDataDetailSimple(StringVO vo) {
		List<String> codes = Arrays.asList(vo.getStr().split(SymbolConstants.COMMA));
		List<DicDataDetailBO> list = new ArrayList<DicDataDetailBO>();
		for (String code : codes) {
			List<DicDataDetailBO> child = ((SysMgrServiceImpl) AopContext.currentProxy()).listDicDataDetail(code);
			list.addAll(child);
		}
		return list;
	}

	//@ReadThroughAssignCache(namespace=CacheConstants.DICTIONARY_SIMPLE,cacheType=RedisCacheType.String,serializeEnable=true,expireTime=60*60*24)
	@Override
	public List<DicDataDetailBO> listDicDataDetail(@ParameterValueKeyProvider String code) {
		return dataDetailDaoMapper.findSimple(code);
	}

	/**
	 * 删除缓存
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017-2-13 下午5:45:14
	 * @param code
	 */
	@DeleteThroughAssignCache(namespace = CacheConstants.DICTIONARY_SIMPLE, cacheType = RedisCacheType.String)
	public void deleteRedis(@ParameterValueKeyProvider String code) {

	}

	public void getAuth(CMSRoleMenuBO bo) {
		String menuButton = bo.getMenuButton();
		if (menuButton != null && !menuButton.equals("")) {
			String[] menuButtons = null;
			if (menuButton.contains(SymbolConstants.COMMA)) {
				menuButtons = menuButton.split(SymbolConstants.COMMA);
			} else {
				menuButtons = new String[1];
				menuButtons[0] = menuButton;
			}
			List<ButtonsBO> buttons = new ArrayList<>();
			String aut = bo.getAuthority();

			List<DicDataDetailBO> dicDataDetailBOs = dicDataDetailDaoMapper.findByCode("113");
			for (String button : menuButtons) {
				ButtonsBO buttonBo = new ButtonsBO();
				buttonBo.setName(getButtonName(button, dicDataDetailBOs));
				buttonBo.setButton(button);
				buttonBo.setChecked("false");
				// 为了避免"6,21,22,23,24,25".contains("4")返回true,首尾加上","
				if (aut != null && (","+aut+",").contains(","+button+",")) {
					if(bo.getMenuId()==92){
						System.out.println(bo);
					}
					buttonBo.setChecked("true");
				}
				buttons.add(buttonBo);
				bo.setButtons(buttons);
			}
		}
		bo.setAuthority(null);
		bo.setMenuButton(null);
	}

	private String getButtonName(String button, List<DicDataDetailBO> dicDataDetailBOs) {
		String name = null;
		if (button != null) {
			for (DicDataDetailBO bo : dicDataDetailBOs) {
				if (bo.getDicDataValue().equals(button)) {
					return bo.getDicDataName();
				}
			}
		}
		return name;
	}

	@Override
	public int addKeywordList(List<CmsKeywordVO> list) {

		List<CmsKeywordPO> poList = new ArrayList<CmsKeywordPO>();

		for (CmsKeywordVO vo : list) {
			poList.add(new CmsKeywordPO(vo));
		}
		cmsKeywordDaoMapper.addList(poList);
		List<KeywordBO> keywordBOs = cmsKeywordDaoMapper.queryKeywordInfo();
		if (!ObjectUtil.isBlank(keywordBOs)) {
			redisUtil.delObj(CacheConstants.C_CORE_ACCOUNT_KEYWORD);
			redisUtil.addObj(CacheConstants.C_CORE_ACCOUNT_KEYWORD, keywordBOs, CacheConstants.TWELVE_HOURS);
		}
		return 1;
	}

	@Override
	public PagingBO<CmsKeywordBO> findKeyword(final CmsKeywordVO vo) {
		return pageService.getPageData(vo, new ISimplePage<CmsKeywordBO>() {

			@Override
			public int getTotal() {
				return cmsKeywordDaoMapper.findTotal(vo);
			}

			@Override
			public List<CmsKeywordBO> getData() {
				return cmsKeywordDaoMapper.find(vo);
			}

		});
	}

	@Override
	public int updateKeywordList(List<CmsKeywordVO> list) {

		List<CmsKeywordPO> poList = new ArrayList<CmsKeywordPO>();

		for (CmsKeywordVO vo : list) {
			poList.add(new CmsKeywordPO(vo));
		}
		cmsKeywordDaoMapper.updateList(poList);
		List<KeywordBO> keywordBOs = cmsKeywordDaoMapper.queryKeywordInfo();
		if (!ObjectUtil.isBlank(keywordBOs)) {
			redisUtil.delObj(CacheConstants.C_CORE_ACCOUNT_KEYWORD);
			redisUtil.addObj(CacheConstants.C_CORE_ACCOUNT_KEYWORD, keywordBOs, CacheConstants.TWELVE_HOURS);
		}
		return 1;
	}

	@Override
	public List<CmsKeywordBO> keywordExcelList(CmsKeywordVO vo) {
		int num=cmsKeywordDaoMapper.findTotal(vo);
		Assert.isTrue(num <= com.hhly.persistence.common.Constants.EXCEL_NUM,com.hhly.persistence.common.Constants.EXCEL_ERROR_MSG);
		return cmsKeywordDaoMapper.excelList(vo);
	}

    /**
     * @desc  查询所有用户类型
     * @author Tony Wang
     * @create 2017年4月21日
     * @return 
     */
	@Override
	public List<CmsUserTypeBO> findUserType() {
		return cmsUserTypeDaoMapper.find();
	}

	/**
	 * @desc   根据条件查询用户
	 * @author Tony Wang
	 * @create 2017年6月9日
	 * @return 
	 */
	@Override
	public List<CMSUserBO> findUsers(CMSUserVO vo) {
		return cmsUserDaoMapper.findDataBySelective(vo);
	}
	/***************************用户操作日志相关 start*************************************************/
	/**
	 * @desc   添加操作日志
	 * @author Tony Wang
	 * @create 2017年5月12日
	 * @param vo
	 * @return 
	 */
	@Override
	public int addUserLog(CmsUserLogVO vo) {
		// 找出模块名称
		CMSMenuVO  menuVO = new CMSMenuVO();
		menuVO.setMenuUrl(vo.getControllerPath());
		CMSMenuBO menu = findMenuByUrl(menuVO);
		// 若所访问的方法未配置菜单，则不记录
		if(menu.getMenuTitle() == null) return 0;
		vo.setTypeName(menu.getMenuTitle());
		return cmsUserLogDaoMapper.add(new CmsUserLogPO(vo));
	}
	
	private CMSMenuBO findMenuByUrl(CMSMenuVO vo) {
		String menuUrl = vo.getMenuUrl();
		Assert.notNull(menuUrl, "按路径查询系统菜单时，路径参数为空");
		// CMS_MENU表的url开头是没有"/",故需删除controller中的开头"/", "/sysmgr/user/log/list"-->"sysmgr/user/log/list"
		if(menuUrl.startsWith(SymbolConstants.OBLIQUE_LINE))
			vo.setMenuUrl(menuUrl.substring(1, menuUrl.length()));
		// 按路径逐层匹配menu表，真到找到对应的菜单为止，如：sysmgr/user/log/list----》第1，2，3次查找的路径依次为sysmgr/user/log/list,sysmgr/user/log,sysmgr/user
		CMSMenuBO menu = cmsMenuDaoMapper.findMenu(vo);
		if(menu != null) return menu;
		while(vo.getMenuUrl().indexOf(SymbolConstants.OBLIQUE_LINE) != -1) {
			menuUrl = vo.getMenuUrl();
			menuUrl = menuUrl.substring(0, menuUrl.lastIndexOf(SymbolConstants.OBLIQUE_LINE));
			vo.setMenuUrl(menuUrl);
			menu = cmsMenuDaoMapper.findMenu(vo);
			if(menu != null) return menu;
		}
		// 返回空菜单
		return new CMSMenuBO();
	}

	/**
	 * @desc   查询操作日志列表
	 * @author Tony Wang
	 * @create 2017年5月15日
	 * @param vo
	 * @return 
	 */
	@Override
	public PagingBO<CmsUserLogBO> listUserLog(final CmsUserLogVO vo) {
		return pageService.getPageData(vo, new ISimplePage<CmsUserLogBO>() {
			@Override
			public int getTotal() {
				return cmsUserLogDaoMapper.count(vo);
			}
			@Override
			public List<CmsUserLogBO> getData() {
				return cmsUserLogDaoMapper.list(vo);
			}
		});
	}
	
	/**
	 * @desc   根据条件查询操作日志
	 * @author Tony Wang
	 * @create 2017年5月26日
	 * @param vo
	 * @return 
	 */
	@Override
	public CmsUserLogBO findUserLog(CmsUserLogVO vo) {
		return cmsUserLogDaoMapper.find(vo);
	}


	/***************************用户操作日志相关 end *************************************************/

	/***************************银行卡BIN码管理表 start *************************************************/
	@Override
	public PagingBO<PayBankSegmentVO> pagePayBankSegment(final PayBankSegmentVO vo) {
		return pageService.getPageData(vo, new ISimplePage<PayBankSegmentVO>() {

			@Override
			public int getTotal() {
				return payBankSegmentDaoMapper.count(vo);
			}

			@Override
			public List<PayBankSegmentVO> getData() {
				return payBankSegmentDaoMapper.find(vo);
			}
		});
	}

	@Override
	public int mergePayBankSegment(PayBankSegmentVO vo) {
		return payBankSegmentDaoMapper.merge(vo);
	}
	/***************************银行卡BIN码管理表 end *************************************************/

	/**
	 * 更新缓存
	 * @param dicCode
	 */
	private void resetRedis(String dicCode) {
		if (!ObjectUtil.isBlank(dicCode) && dicCode.equals("9997")) {
			List<String> list = dicDataDetailDaoMapper.findMobileNumLimitList();
			if (!ObjectUtil.isBlank(list)) {
				redisUtil.addObj(CacheConstants.C_CORE_MEMBER_MOBILE_NUM_SEGMENT, list, null );
			}
		}
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(DigestUtils.md5DigestAsHex(("足总杯" + "1").getBytes("UTF-8")));
	}

	@Override
	public List<DictionaryBO> findRcmdUserLevel() {
		return dicDataDaoMapper.findRcmdUserLevel();
	}
}
