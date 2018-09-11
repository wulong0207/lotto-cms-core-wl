package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;
import java.util.Map;

import com.hhly.cmscore.persistence.operate.po.OperateSoftwareVersionPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateSoftwareVersionBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateSoftwareVersionVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateLottSoftwareVersionBO;
import com.hhly.skeleton.lotto.base.operate.vo.OperateLottSoftwareVersionVO;

public interface OperateSoftwareVersionDaoMapper {

    int insert(OperateSoftwareVersionPO po);
    
    int findTotal(OperateSoftwareVersionVO vo);
    
    List<OperateSoftwareVersionBO> find(OperateSoftwareVersionVO vo);
    
    List<OperateSoftwareVersionBO> findBaseSoftwareVersion(OperateSoftwareVersionVO vo);
    
    int deleteByIds(List<String> ids);
    
	int updateById(OperateSoftwareVersionPO po);
	
	int updateIsnew(Map<String, Integer> paramMap);
	
	int valiSoftwareVersionCode(int code);
	/**
	 * 根据客户端信息查询最新的版本号
	 * @param type
	 * @return
	 */
	//OperateLottSoftwareVersionBO findNewVersion(@Param("type")Short type);
	OperateLottSoftwareVersionBO findNewVersion(OperateLottSoftwareVersionVO vo);

	OperateLottSoftwareVersionBO findSingle(OperateSoftwareVersionVO vo);

	/**
	 * @desc   更新审核开关
	 * @author Tony Wang
	 * @create 2017年10月14日
	 * @param po
	 * @return 
	 */
	int updSwitch(OperateSoftwareVersionPO po);

	/**
	 * @desc   查找每个渠道最新的版本
	 * @author Tony Wang
	 * @create 2017年10月14日
	 * @param vo
	 * @return 
	 */
	List<OperateSoftwareVersionBO> findNew(OperateSoftwareVersionVO vo);

	/**
	 * @desc   查找单条版本
	 * @author Tony Wang
	 * @create 2017年10月15日
	 * @param vo
	 * @return 
	 */
	OperateSoftwareVersionBO findOne(OperateSoftwareVersionVO vo);

	/**
	 * @desc   按条件删除记录
	 * @author Tony Wang
	 * @create 2017年11月8日
	 * @param criteria
	 * @return 
	 */
	int delete(OperateSoftwareVersionVO criteria);

	/**
	 * @desc   根据条件更新
	 * @author Tony Wang
	 * @create 2017年11月8日
	 * @param po
	 * @return 
	 */
	int update(OperateSoftwareVersionPO po);

	/**
	 * @desc   查询不同名称的版本
	 * @author Tony Wang
	 * @create 2017年12月22日
	 * @param vo
	 * @return 
	 */
	List<OperateSoftwareVersionBO> distinctName(OperateSoftwareVersionVO vo);

}