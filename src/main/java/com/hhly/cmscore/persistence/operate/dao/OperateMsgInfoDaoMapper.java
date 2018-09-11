package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.operate.po.OperateMsgConfigPO;
import com.hhly.cmscore.persistence.operate.po.OperateMsgInfoPO;
import com.hhly.cmscore.persistence.operate.po.OperateMsgLotteryConfigPO;
import com.hhly.cmscore.persistence.operate.po.OperateMsgNewPO;
import com.hhly.cmscore.persistence.operate.po.OperateMsgTemplatePO;
import com.hhly.cmscore.persistence.operate.po.OperateWechatTemplatePO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMsgConfigBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMsgInfoBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMsgLotteryConfigBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMsgNewBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMsgTemplateBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateWechatTemplateBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgInfoVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgLotteryConfigVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgNewVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgTemplateVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateWechatTemplateVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateMsgBO;
import com.hhly.skeleton.user.bo.UserInfoBO;

public interface OperateMsgInfoDaoMapper {
	
	/**
	 * CMS分页查询总条数
	 * 
	 * @param vo
	 * @return
	 */
	int findTotal(OperateMsgInfoVO vo);

	/**
	 * CMS 通知信息查询
	 * 
	 * @param vo
	 * @return
	 */
	List<OperateMsgInfoBO> findList(OperateMsgInfoVO vo);
	
	/**
	 * @Desc   查询通知信息模板查询
	 * @Author HouXB
	 * @Date   2017年3月3日 下午3:52:12
	 * @param vo
	 * @return
	 */
	List<OperateMsgTemplateBO> findMsgTemplate(OperateMsgTemplateVO vo);
	
	/**
	 * 
	 * @Desc   查询通知信息模板总记录数
	 * @Author HouXB
	 * @Date   2017年3月3日 下午4:00:54
	 * @param vo
	 * @return
	 */
	int findMsgTemplateTotal(OperateMsgTemplateVO vo);

	/**
	 * 
	 * @Desc   微信公众号设置模板查询
	 * @Author HouXB
	 * @Date   2017年3月3日 下午3:55:50
	 * @param vo
	 * @return
	 */
	List<OperateWechatTemplateBO> findWechatTemplate(OperateWechatTemplateVO vo);
	
	/**
	 * 
	 * @Desc   查询通知信息详情
	 * @Author HouXB
	 * @Date   2017年3月8日 上午10:45:20
	 * @param id
	 * @return
	 */
	OperateMsgInfoBO findMsgInfoById(@Param("id") int id);
	
	/**
	 * 
	 * @Desc   查询信息模板详情
	 * @Author HouXB
	 * @Date   2017年3月8日 上午10:45:37
	 * @param id
	 * @return
	 */
	OperateMsgTemplateBO findMsgTemplateById(@Param("id") int id);
	
	/**
	 * 
	 * @Desc   查询微信公众号模板设置详情
	 * @Author HouXB
	 * @Date   2017年3月8日 上午10:45:52
	 * @param id
	 * @return
	 */
	OperateWechatTemplateBO findWechatTemplateById(@Param("id") int id);
	
	/**
	 * 
	 * @Desc   新增通知消息
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:18:13
	 * @param po
	 * @return
	 */
	int addMsgInfo(@Param("list")List<OperateMsgInfoPO> list);
	
	/**
	 * 
	 * @Desc   新增消息模板
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:18:41
	 * @param po
	 * @return
	 */
	int addMsgTemplate(OperateMsgTemplatePO po);
	
	/**
	 * 
	 * @Desc   新增微信公众号设置模板
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:18:53
	 * @param po
	 * @return
	 */
	int addWechatTemplate(OperateWechatTemplatePO po);
	
	/**
	 * 
	 * @Desc   更新消息状态
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:21:46
	 * @param list
	 * @return
	 */
	int updateMsgStatus(@Param("list") List<OperateMsgInfoVO> list);
	
	/**
	 * 
	 * @Desc   更新模板
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:22:03
	 * @param po
	 * @return
	 */
	int updateMsgTemplate(OperateMsgTemplatePO po);
	
	/**
	 * 
	 * @Desc   设置微信公众号模板
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:22:20
	 * @param po
	 * @return
	 */
	int updateWechatTemplate(OperateWechatTemplatePO po);
	
	/**
	 * 
	 * @Desc   根据用户ID查询用户配置信息
	 * @Author HouXB
	 * @Date   2017年3月11日 上午9:53:58
	 * @param userId
	 * @return
	 */
	List<OperateMsgConfigBO> findConfigByUserId(@Param("userId") int userId);
	
	/**
	 * 
	 * @Desc   更新发布消息
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:22:03
	 * @param po
	 * @return
	 */
	int updateNewMsg(OperateMsgNewPO po);
	
	/**
	 * 
	 * @Desc   发布消息
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:18:41
	 * @param po
	 * @return
	 */
	int addNewMsg(OperateMsgNewPO po);
	/**
	 * CMS分页查询总条数
	 * 
	 * @param vo
	 * @return
	 */
	int findNewMsgTotal(OperateMsgNewVO vo);

	/**
	 * CMS 发布信息查询
	 * @param vo
	 * @return
	 */
	List<OperateMsgNewBO> findNewMsgList(OperateMsgNewVO vo);
	
	/*
	 * 查询发布信息详情
	 * @param id
	 * @return
	 */
	OperateMsgNewBO findNewMsgById(@Param("id") int id);
	
	/**查询短信通知信息*/
	List<OperateMsgBO> findHomeMsg(@Param("userId") Integer userId );
	
	/**
	 * 查询用户已关闭通知的模板列表
	 */
	List<OperateMsgConfigBO> findUserCloseNoticConfig(@Param("userId") Integer userId);
	
	/**
	 * 删除用户的已关闭配置
	 */
	int deleteMsgConfByUserId(@Param("userId") Integer userId );
	/**
	 * @Desc 
	 * @author tangxiaobo
	 * @CreatDate 2017年4月26日 下午3:33:47
	 */
	void addMsgConfig(@Param("po") List<OperateMsgConfigPO> po);
	
	/**
	 * @Desc 获取具体彩种通知开关列表
	 * @author tangxiaobo
	 * @CreatDate 2017年4月27日 下午5:17:46
	 * @param userId
	 * @param type
	 * @return
	 */
	List<OperateMsgLotteryConfigBO> findLotteryConfig(@Param("userId") Integer userId,@Param("type") Integer type);
	
	/**
	 * @Desc 更新彩种通知开关列表
	 * @author tangxiaobo
	 * @CreatDate 2017年4月27日 下午5:18:12
	 * @param po
	 */
	void updateLotteryConfig(@Param("po") List<OperateMsgLotteryConfigPO> po);
	
	/**
	 * 查询彩种消息接收开关
	 * @param id
	 * @return
	 */
	OperateMsgLotteryConfigBO findLotteryConfigById(@Param("id") Integer id);
	
	/**
	 * 添加彩种消息接收配置
	 * @param vo
	 */
	void updateLotteryConfig(OperateMsgLotteryConfigVO vo);
	
	/**
	 * 更新彩种消息接收配置
	 * @param vo
	 */
	void addLotteryConfig(OperateMsgLotteryConfigVO vo);

	/**
	 * 根据批次号查询信息
	 * @param msgBatch
	 * @return
	 */
	OperateMsgNewBO findNewMsgByBatch(@Param("msgBatch") String msgBatch);
	
	/**
	 * 更新信息状态
	 * @param status
	 * @param id
	 * @return
	 */
	int updateNewMsgStatus(@Param("status") int status,@Param("id") Integer id);
	
	/**
	 * 
	 * @Desc 根据用户id集合分次查询用户列表
	 * @CreatDate 2017年4月14日 下午2:28:46
	 * @param list
	 * @return
	 */
	List<UserInfoBO> findUserInfoByIds(@Param("list") List<Integer> list);
	
	/**
	 * 查询用户模板接收设置信息
	 * @param userId
	 * @param typeId
	 */
	OperateMsgConfigBO findUserConfig(@Param("userId") Integer userId,@Param("typeId") Integer typeId);
	
	/**
	 * 
	 * @Desc 查询有效用户个数
	 * @return
	 */
	int findValidUserInfoCount();
	
	/**
	 * 
	 * @Desc 分次查询有效用户列表
	 * @param list
	 * @param begin
	 * @param end
	 * @return
	 */
	List<UserInfoBO> findValidUserInfo(@Param("begin") Integer begin,@Param("pageSize") Integer pageSize);

	/**
	 * 
	 * @Description 取消发送
	 * @author HouXiangBao289
	 * @param list
	 */
	void cancelSendMsg(List<OperateMsgInfoVO> list);
	
	/**
	 * 
	 * @Desc   更新批量消息状态
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:21:46
	 * @param list
	 * @return
	 */
	int updateBatchMsgStatus(@Param("list") List<OperateMsgInfoVO> list);
	
}