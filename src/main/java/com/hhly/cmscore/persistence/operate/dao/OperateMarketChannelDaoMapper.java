package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.operate.po.OperateMarketChannelPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMarketChannelBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMarketChannelExcelBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMarketChannelVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateLottSoftwareVersionBO;
import com.hhly.skeleton.lotto.base.operate.vo.OperateLottSoftwareVersionVO;

public interface OperateMarketChannelDaoMapper {
	/**
	 * 查询简要信息，用于下拉列表
	 * 
	 * @return
	 */
	List<OperateMarketChannelBO> findAllSimple();

	/**
	 * CMS分页查询总条数
	 * 
	 * @param vo
	 * @return
	 */
	int findTotal(OperateMarketChannelVO vo);

	/**
	 * CMS 分析查询
	 * 
	 * @param vo
	 * @return
	 */
	List<OperateMarketChannelBO> findList(OperateMarketChannelVO vo);

	/**
	 * 根据级别查询能成为父级渠道ID的ID
	 * 
	 * @param grage
	 * @return
	 */
	List<String> findParentId(@Param("grade")String grade);

	/**
	 * cms 修改渠道
	 * 
	 * @param vo
	 * @return
	 */
	int updOperateMarketChannel(OperateMarketChannelPO po);

	/**
	 * cms 添加渠道
	 * 
	 * @param po
	 * @return
	 */
	int addOperateMarketChannel(OperateMarketChannelPO po);
    /**
     * 根据渠道ID查询主键id
     * @param channelId
     * @return
     */
	List<Integer> findIdByChannelId(@Param("channelId")String channelId);
    /**
     * 导出excel
     * @param vo
     * @return
     */
	List<OperateMarketChannelExcelBO> findExcelMarketChannel(
			OperateMarketChannelVO vo);
	/**
	 * 获取最大渠道编号
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年8月10日 下午2:31:06
	 * @return
	 */
	List<String> findMaxChannelId();

	int updAppUrl(OperateMarketChannelPO po);
	/**
	 * 根据渠道查询appurl
	 * @param vo
	 * @return
	 */
	OperateLottSoftwareVersionBO findVersionByChannel(OperateLottSoftwareVersionVO vo);


	/**
	 * @desc   查询符合条件的叶子结点
	 * @author Tony Wang
	 * @create 2017年11月8日
	 * @param criteria
	 * @return 
	 */
	List<OperateMarketChannelBO> findLeaf(OperateMarketChannelVO criteria);
}