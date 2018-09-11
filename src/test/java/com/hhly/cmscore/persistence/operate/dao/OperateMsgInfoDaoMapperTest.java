package com.hhly.cmscore.persistence.operate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateMsgInfoDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateMsgConfigPO;
import com.hhly.cmscore.persistence.operate.po.OperateMsgInfoPO;
import com.hhly.cmscore.persistence.operate.po.OperateMsgLotteryConfigPO;
import com.hhly.cmscore.persistence.operate.po.OperateMsgNewPO;
import com.hhly.cmscore.persistence.operate.po.OperateMsgTemplatePO;
import com.hhly.cmscore.persistence.operate.po.OperateWechatTemplatePO;
import com.hhly.skeleton.base.common.OrderEnum.NumberCode;
import com.hhly.skeleton.base.util.DateUtil;
import com.hhly.skeleton.base.util.OrderNoUtil;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMsgConfigBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMsgInfoBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMsgLotteryConfigBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMsgNewBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateMsgTemplateBO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateWechatTemplateBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgConfigVo;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgInfoVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgLotteryConfigVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgNewVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgTemplateVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateWechatTemplateVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateMsgBO;
import com.hhly.skeleton.user.bo.UserInfoBO;

/**
 * 
* @Description:通知消息DAO方法测试 
* @author HouXiangBao289
* @date 2017年6月5日 上午10:45:09 
* @version V1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager") 
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
public class OperateMsgInfoDaoMapperTest {

	@Resource
	private OperateMsgInfoDaoMapper operateMsgDaoMapper;
	
	/**
	 * CMS分页查询总条数
	 * @param vo
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindTotal(){
		try
		{
			OperateMsgInfoVO vo = new OperateMsgInfoVO();
			vo.setMsgBatch("SC1705261701122001");
			int sum = operateMsgDaoMapper.findTotal(vo);
			System.out.println("【通知信息管理】 根据批次号SC1705261701122001查询通知信息总记录数：" + sum);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * CMS 通知信息查询
	 * 
	 * @param vo
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindList(){
		try
		{
			OperateMsgInfoVO vo = new OperateMsgInfoVO();
			vo.setMsgBatch("SC1705261701122001");
			List<OperateMsgInfoBO> list = operateMsgDaoMapper.findList(vo);
			System.out.println("【通知信息管理】 根据批次号SC1705261701122001查询通知信息list size：" + list.size());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @Desc   查询通知信息模板查询
	 * @Author HouXB
	 * @Date   2017年3月3日 下午3:52:12
	 * @param vo
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindMsgTemplate(){
		try
		{
			OperateMsgTemplateVO vo = new OperateMsgTemplateVO();
			vo.setStatus(1);
			List<OperateMsgTemplateBO>  list = operateMsgDaoMapper.findMsgTemplate(vo);
			System.out.println("【通知信息管理】 查询有效模板list size：" + list.size());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc   查询通知信息模板总记录数
	 * @Author HouXB
	 * @Date   2017年3月3日 下午4:00:54
	 * @param vo
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindMsgTemplateTotal(){
		try
		{
			OperateMsgTemplateVO vo = new OperateMsgTemplateVO();
			vo.setStatus(1);
			int sum = operateMsgDaoMapper.findMsgTemplateTotal(vo);
			System.out.println("【通知信息管理】 查询有效模板个数：" + sum);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


	/**
	 * 
	 * @Desc   微信公众号设置模板查询
	 * @Author HouXB
	 * @Date   2017年3月3日 下午3:55:50
	 * @param vo
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindWechatTemplate(){
		try
		{
			OperateWechatTemplateVO vo = new OperateWechatTemplateVO();
			vo.setStatus(1);
			List<OperateWechatTemplateBO>  list = operateMsgDaoMapper.findWechatTemplate(vo);
			System.out.println("【通知信息管理】 查询有效微信模板 list size：" + list.size());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc   查询通知信息详情
	 * @Author HouXB
	 * @Date   2017年3月8日 上午10:45:20
	 * @param id
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindMsgInfoById(){
		try
		{
			OperateMsgInfoBO bo = operateMsgDaoMapper.findMsgInfoById(99);
			System.out.println("【通知信息管理】 查询Id为99的通知信息详情，其通知用户账号为：" + bo.getAccountName());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc   查询信息模板详情
	 * @Author HouXB
	 * @Date   2017年3月8日 上午10:45:37
	 * @param id
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindMsgTemplateById(){
		try
		{
			OperateMsgTemplateBO bo = operateMsgDaoMapper.findMsgTemplateById(99);
			System.out.println("【通知信息管理】 查询Id为99的信息模板详情，其模板编号为：" + bo.getTypeId());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc   查询微信公众号模板设置详情
	 * @Author HouXB
	 * @Date   2017年3月8日 上午10:45:52
	 * @param id
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindWechatTemplateById(){
		try
		{
			OperateWechatTemplateBO bo = operateMsgDaoMapper.findWechatTemplateById(99);
			System.out.println("【通知信息管理】 查询Id为99的微信公众号模板详情，Id：" + bo.getId());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc   新增通知消息
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:18:13
	 * @param po
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testAddMsgInfo(){
		try
		{
			List<OperateMsgInfoPO> list = new ArrayList<OperateMsgInfoPO>();
			OperateMsgInfoPO po = new OperateMsgInfoPO();
			po.setCusMobile(Long.parseLong("15811821078"));
			po.setMsgBatch(OrderNoUtil.getOrderNo(NumberCode.SEND_BATCH));
			po.setMsgContent("junit test");
			po.setMsgTitle("test");
			po.setMsgType(1);
			po.setPreSendTime(DateUtil.getAfterDayHour(2, 0));
			po.setUserId(99);
			list.add(po);
			int num = operateMsgDaoMapper.addMsgInfo(list);
			System.out.println("【通知信息管理】添加通知信息返回结果：" + num);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc   新增消息模板
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:18:41
	 * @param po
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testAddMsgTemplate(){
		try
		{
			OperateMsgTemplatePO po = new OperateMsgTemplatePO();
			po.setTypeName("红包到账提醒");
			po.setTypeNode("1");
			po.setStatus(1);
			po.setMobStatus(1);
			po.setSiteStatus(1);
			po.setAppStatus(1);
			po.setWechatStatus(1);
			po.setMobTitle("");
			po.setAppTitle("");
			po.setSiteTitle("您获赠了[充20送20]红包1个！");
			po.setWechatTitle("");
			po.setMobContent("尊敬的${昵称}$：恭喜您获得[充20送20]红包一个，充值即送！趁此幸运日赶紧来一注，2亿奖池正等着你呢！【2N彩票】");
			po.setAppContent("尊敬的${昵称}$：恭喜您获得[充20送20]红包一个，充值即送！趁此幸运日赶紧来一注，2亿奖池正等着你呢！【2N彩票】");
			po.setSiteContent("恭喜您获得奥彩网[充20送20]红包一个，充值就送！趁此幸运日赶紧来一注双色球碰碰运气吧，2亿奖池正等着你呢！【查看详情】【立即使用】");
			po.setAppAddFields("userId:用户Id;redPacketId:红包编号");
			po.setWechatId(24);
			int num = operateMsgDaoMapper.addMsgTemplate(po);
			System.out.println("【通知信息管理】添加模板返回结果：" + num);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc   新增微信公众号设置模板
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:18:53
	 * @param po
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testAddWechatTemplate(){
		try
		{
			OperateWechatTemplatePO po = new OperateWechatTemplatePO();
			po.setColor("#00001;#00001");
			po.setFooterColor("#00001");
			po.setHeaderColor("#00001");
			po.setTitle("测试一;测试二");
			po.setTypeName("test template");
			po.setStatus(1);
			int num = operateMsgDaoMapper.addWechatTemplate(po);
			System.out.println("【通知信息管理】添加微信公众号模板返回结果：" + num);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc   更新消息状态
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:21:46
	 * @param list
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testUpdateMsgStatus(){
		try
		{
			List<OperateMsgInfoVO> list = new ArrayList<OperateMsgInfoVO>();
			OperateMsgInfoVO vo = new OperateMsgInfoVO();
			vo.setId(99);
			vo.setStatus((short)0);
			list.add(vo);
			int num = operateMsgDaoMapper.updateMsgStatus(list);
			System.out.println("【通知信息管理】更新消息状态返回结果：" + num);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc   更新模板
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:22:03
	 * @param po
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testUpdateMsgTemplate(){
		try
		{
			OperateMsgTemplatePO vo = new OperateMsgTemplatePO();
			vo.setTypeName("开奖号码通知");
			vo.setTypeNode("1");
			vo.setTypeId(101);
			vo.setStatus(1);
			vo.setMobStatus(1); 
			vo.setSiteStatus(1);
			vo.setAppStatus(1);
			vo.setWechatStatus(1);
			vo.setMobTitle("mob title test");
			vo.setMobContent("mob content test");
			vo.setSiteTitle("site tile test");
			vo.setSiteContent("test site content");
			vo.setAppTitle("test app title");
			vo.setAppContent("test app");
			vo.setTypeDesc("test");
			vo.setCreateBy("admin");
			vo.setWechatId(25);
			vo.setWechatTitle("test wetchat title");
			vo.setHeaderCon("test header");
			vo.setFooterCon("test footer");
			vo.setModifyBy("admin");
			vo.setAppAddFields("test:test");
			vo.setMsgType(1);
			vo.setId(1);
			int num = operateMsgDaoMapper.updateMsgTemplate(vo);
			System.out.println("【通知信息管理】更新模板返回结果：" + num);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc   设置微信公众号模板
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:22:20
	 * @param po
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testUpdateWechatTemplate(){
		try
		{
			OperateWechatTemplatePO vo = new OperateWechatTemplatePO();
			int num = operateMsgDaoMapper.updateWechatTemplate(vo);
			System.out.println("【通知信息管理】更新微信公众号模板返回结果：" + num);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc   根据用户ID查询用户配置信息
	 * @Author HouXB
	 * @Date   2017年3月11日 上午9:53:58
	 * @param userId
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindConfigByUserId(){
		try
		{
			List<OperateMsgConfigBO> list = operateMsgDaoMapper.findConfigByUserId(99);
			System.out.println("【通知信息管理】查询用户Id为99的信息接收配置list size：" + list.size());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc   更新发布消息
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:22:03
	 * @param po
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testUpdateNewMsg(){
		try
		{
			OperateMsgNewPO vo = new OperateMsgNewPO();
			vo.setStatus(1);
			vo.setMobStatus(1);
			vo.setAppStatus(1);
			vo.setSiteStatus(1);
			vo.setWechatStatus(1);
			vo.setSiteTitle("测试");		
			vo.setSiteContent("测试");
			vo.setMobTitle("测试");		
			vo.setMobContent("测试");
			vo.setAppTitle("测试");		
			vo.setAppContent("测试");
			vo.setCreateBy("admin");
			vo.setWechatId(24);
			vo.setWechatTitle("测试数据");
			vo.setHeaderCon("测试 内容");
			vo.setFooterCon("测试 内容");
			vo.setModifyBy("admin");
			vo.setTemplateId(19);
			vo.setPreSendTime(DateUtil.getAfterDayHour(3, 0));
			vo.setSendReason("test");
			vo.setRemark("test");
			vo.setMsgType(1);
			vo.setAppFields("测试:测试:haha");
			vo.setWechatFields("测试一:测试;测试二:haha");
			vo.setId(1);
			int num = operateMsgDaoMapper.updateNewMsg(vo);
			System.out.println("【通知信息管理】更新发送信息返回：" + num);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc   发布消息
	 * @Author HouXB
	 * @Date   2017年3月8日 下午12:18:41
	 * @param po
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testAddNewMsg(){
		try
		{
			OperateMsgNewPO vo = new OperateMsgNewPO();
			vo.setStatus(1);
			vo.setMobStatus(1);
			vo.setAppStatus(1);
			vo.setSiteStatus(1);
			vo.setWechatStatus(1);
			vo.setSiteTitle("测试 add");		
			vo.setSiteContent("测试 add");
			vo.setMobTitle("测试 add ${开奖号码}$");		
			vo.setMobContent("测试  add");
			vo.setAppTitle("测试");		
			vo.setAppContent("测试");
			vo.setCreateBy("admin");
			vo.setWechatId(24);
			vo.setWechatTitle("测试数据");
			vo.setHeaderCon("测试 内容");
			vo.setFooterCon("测试 内容");
			vo.setModifyBy("admin");
			vo.setTemplateId(19);
			vo.setPreSendTime(DateUtil.getAfterDayHour(3, 0));
			vo.setSendReason("test");
			vo.setRemark("test");
			vo.setMsgType(1);
			vo.setAppFields("测试:测试:haha");
			vo.setWechatFields("测试一:测试;测试二:haha");
			int num = operateMsgDaoMapper.addNewMsg(vo);
			System.out.println("【通知信息管理】新增发送信息返回：" + num);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * CMS分页查询总条数
	 * 
	 * @param vo
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindNewMsgTotal(){
		try
		{
			OperateMsgNewVO vo = new OperateMsgNewVO();
			vo.setMsgBatch("SC1705232110211001");
			vo.setStatus(1);
			int num = operateMsgDaoMapper.findNewMsgTotal(vo);
			System.out.println("【通知信息管理】查询发送信息总记录数：" + num);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * CMS 发布信息查询
	 * @param vo
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindNewMsgList(){
		try
		{
			OperateMsgNewVO vo = new OperateMsgNewVO();
			vo.setMsgBatch("SC1705232110211001");
			vo.setStatus(1);
			List<OperateMsgNewBO> list = operateMsgDaoMapper.findNewMsgList(vo);
			System.out.println("【通知信息管理】查询发送信息 list size：" + list.size());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * 查询发布信息详情
	 * @param id
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindNewMsgById(){
		try
		{
			OperateMsgNewBO bo = operateMsgDaoMapper.findNewMsgById(99);
			System.out.println("【通知信息管理】查询Id为99的发送信息详情，返回Id：" + bo.getId());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**查询短信通知信息*/
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindHomeMsg(){
		try
		{
			List<OperateMsgBO> list = operateMsgDaoMapper.findHomeMsg(99);
			System.out.println("【通知信息管理】查询用户userId为99的通知消息，list size：" + list.size());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询用户已关闭通知的模板列表
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindUserCloseNoticConfig(){
		try
		{
			List<OperateMsgConfigBO> list = operateMsgDaoMapper.findUserCloseNoticConfig(99);
			System.out.println("【通知信息管理】查询用户userId为99的已关闭通知配置：list size：" + list.size());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除用户的已关闭配置
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testDeleteMsgConfByUserId(){
		try
		{
			int num= operateMsgDaoMapper.deleteMsgConfByUserId(99);
			System.out.println("【通知信息管理】删除用户userId为99的接收设置，返回结果：" + num);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @Desc 
	 * @author tangxiaobo
	 * @CreatDate 2017年4月26日 下午3:33:47
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testAddMsgConfig(){
		try
		{
			List<OperateMsgConfigPO> list = new ArrayList<OperateMsgConfigPO>();
			OperateMsgConfigVo vo = new OperateMsgConfigVo();
			vo.setApp(1);
			vo.setMob(1);
			vo.setSite(1);
			vo.setWechat(1);
			vo.setTemplateId(19);
			OperateMsgConfigPO po = new OperateMsgConfigPO(vo);
			po.setUserId(99);
			list.add(po);
			operateMsgDaoMapper.addMsgConfig(list);
			System.out.println("【通知信息管理】添加用户接收配置");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @Desc 获取具体彩种通知开关列表
	 * @author tangxiaobo
	 * @CreatDate 2017年4月27日 下午5:17:46
	 * @param userId
	 * @param type
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindLotteryConfig(){
		try
		{
			List<OperateMsgLotteryConfigBO> list = operateMsgDaoMapper.findLotteryConfig(99,1);
			System.out.println("【通知信息管理】查询用户userId为99的彩种类型消息接收设置，list size：" + list.size());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @Desc 更新彩种通知开关列表
	 * @author tangxiaobo
	 * @CreatDate 2017年4月27日 下午5:18:12
	 * @param po
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testUpdateLotteryConfigList(){
		try
		{
			List<OperateMsgLotteryConfigPO> list = new ArrayList<OperateMsgLotteryConfigPO>();
			
			OperateMsgLotteryConfigVO vo = new OperateMsgLotteryConfigVO();
			vo.setApp(1);
			vo.setLotteryCode(1);
			vo.setType(1);
			vo.setUserId(99);
			OperateMsgLotteryConfigPO po = new OperateMsgLotteryConfigPO(vo);
			list.add(po);
			operateMsgDaoMapper.updateLotteryConfig(list);
			System.out.println("【通知信息管理】添加用户彩种类型消息接收配置");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询彩种消息接收开关
	 * @param id
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindLotteryConfigById(){
		try
		{
			OperateMsgLotteryConfigBO bo = operateMsgDaoMapper.findLotteryConfigById(99);
			System.out.println("【通知信息管理】查询用户userId为99的接收彩种类型消息配置，Id：" + bo.getId());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加彩种消息接收配置
	 * @param vo
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testUpdateLotteryConfig(){
		try
		{
			OperateMsgLotteryConfigVO vo = new OperateMsgLotteryConfigVO();
			vo.setId(1);
			vo.setApp(0);
			vo.setLotteryCode(1);
			vo.setType(1);
			vo.setUserId(99);
			operateMsgDaoMapper.updateLotteryConfig(vo);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新彩种消息接收配置
	 * @param vo
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testAddLotteryConfig(){
		try
		{
			OperateMsgLotteryConfigVO vo = new OperateMsgLotteryConfigVO();
			vo.setApp(1);
			vo.setLotteryCode(1);
			vo.setType(1);
			vo.setUserId(99);
			operateMsgDaoMapper.addLotteryConfig(vo);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 根据批次号查询信息
	 * @param msgBatch
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindNewMsgByBatch(){
		try
		{
			OperateMsgNewBO bo = operateMsgDaoMapper.findNewMsgByBatch("SC1705232110211001");
			System.out.println("【通知信息管理】根据批次号SC1705232110211001查询发送信息，Id："+bo.getId());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新信息状态
	 * @param status
	 * @param id
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testUpdateNewMsgStatus(){
		try
		{
			int num = operateMsgDaoMapper.updateNewMsgStatus(0,99);
			System.out.println("【通知信息管理】 更新发送信息状态，返回结果："+num);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc 根据用户id集合分次查询用户列表
	 * @CreatDate 2017年4月14日 下午2:28:46
	 * @param list
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindUserInfoByIds(){
		try
		{
			 List<Integer> list = new  ArrayList<Integer>();
			 list.add(98);
			 list.add(99);
			 list.add(100);
			 list.add(101);
			 List<UserInfoBO> rs = operateMsgDaoMapper.findUserInfoByIds(list);
			System.out.println("【通知信息管理】查询用户信息，list size：" + rs.size());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询用户模板接收设置信息
	 * @param userId
	 * @param typeId
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindUserConfig(){
		try
		{
			OperateMsgConfigBO rs = operateMsgDaoMapper.findUserConfig(99,1);
			System.out.println("【通知信息管理】查询用户userId为99的类型消息接收配置：Id："+rs.getId());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc 查询有效用户个数
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindValidUserInfoCount(){
		try
		{
			int num = operateMsgDaoMapper.findValidUserInfoCount();
			System.out.println("【通知信息管理】查询有效用户个数："+num);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Desc 分次查询有效用户列表
	 * @param list
	 * @param begin
	 * @param end
	 * @return
	 */
	@Test
	@Rollback(true)
//	@Transactional
	public void testFindValidUserInfo(){
		try
		{
			List<UserInfoBO> list = operateMsgDaoMapper.findValidUserInfo(1,10);
			System.out.println("【通知信息管理】查找有效用户信息，list size："+list.size());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
