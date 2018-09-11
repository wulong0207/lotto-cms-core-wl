package com.hhly.test;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.hhly.cmscore.cms.remote.service.IOperateMgrService;
import com.hhly.persistence.util.HessianUtils;
import com.hhly.skeleton.cms.base.vo.StringVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityConfigVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdMenuVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdTypeVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateAdVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleTypeVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateCouponVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateFastVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpCorrectVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpTypeVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateHelpVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateImgVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMarketChannelVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgInfoVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgNewVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateMsgTemplateVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateRebateUserVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateSoftwareVersionVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateUserAnalysisVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateWechatTemplateVO;
import com.hhly.skeleton.cms.operatemgr.vo.SportAgainstVO;

public class OperateMgrServiceTest {
	
	private String url;
	
	private IOperateMgrService sys;
	
	
	 @Before
		public void before() throws MalformedURLException{
	    	url = "http://localhost:8081/lotto-cms-core/remote/operateMgrService";
	    	sys = HessianUtils.getRemoteService(IOperateMgrService.class, url);
	    }

	 
	 @Test
	 public void testFindChannelAllSimple() {
		 sys.findChannelAllSimple();
	 }
	 
	 @Test
	 public void testFindMarketChannel() {
		 OperateMarketChannelVO vo = getOperateMarketChannelVO();
		 sys.findMarketChannel(vo);
	 }
	 
	 @Test
	 public void testFindParentId() {
		 StringVO vo = new StringVO();
		 vo.setStr("1");
		 sys.findParentId(vo);
	 }
	  
	 @Test
	 public void testFindExcelMarketChannel() {
		 OperateMarketChannelVO vo = getOperateMarketChannelVO();
		 sys.findExcelMarketChannel(vo);
	 }

	 
	 @Test
	 public void testFindActivity() {
		 OperateActivityVO vo = new OperateActivityVO();
		 vo.setChannelId("1");
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 sys.findActivity(vo);
	 }
	 
	 @Test
	 public void testFindActivityConfigDetail() {
		 OperateActivityConfigVO vo = new OperateActivityConfigVO();
		 vo.setId(1);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 sys.findActivityConfigDetail(vo);
	 }
	 
	 @Test
	 public void testFindActivityRuleDetail() {		 
		 sys.findActivityRuleDetail(4);
	 }
	 
	 @Test
	 public void testFindOperateActivityDetail() {		 
		 sys.findOperateActivityDetail(4);
	 }
	 
	 @Test
	 public void testFindCoupon() {		
		 OperateCouponVO vo = new OperateCouponVO();
		 vo.setId(4);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 sys.findCoupon(vo);
	 }	 
	 
	 @Test
	 public void testFindCouponDetail() {		
		 StringVO vo = new StringVO();
		 vo.setStr("1");
		 sys.findCouponDetail(vo);
	 }
	 	 
	 @Test
	 public void testFindOperateAd() {		
		 OperateAdVO vo = new OperateAdVO();
		 vo.setChannelId(1);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 sys.findOperateAd(vo);
	 }
	 	 
	 @Test
	 public void testListAdType() {		
		 OperateAdTypeVO vo = new OperateAdTypeVO();
		 vo.setChannelId("1");
		 sys.listAdType(vo);
	 }
	 
	 @Test
	 public void testListAdMenu() {		
		 OperateAdMenuVO vo = getOperateAdMenuVO();
		 sys.listAdMenu(vo);
	 }
	 	 
	 @Test
	 public void testFindAdMenus() {		
		 OperateAdMenuVO vo = getOperateAdMenuVO();
		 sys.findAdMenus(vo);
	 }
	 
	 @Test
	 public void testFindPagingUserAnalysis() {		
		 OperateUserAnalysisVO vo = new OperateUserAnalysisVO();
		 vo.setChannelId("1");
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 sys.findPagingUserAnalysis(vo);
	 }
	 
	 @Test
	 public void testFindOperateFast() {		
		 OperateFastVO vo = new OperateFastVO();
		 vo.setFastCode("FastCode_test");
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 sys.findOperateFast(vo);
	 }
	 
	 @Test
	 public void testFindMsgInfo() {		
		 OperateMsgInfoVO vo = new OperateMsgInfoVO();
		 vo.setId(1);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 sys.findMsgInfo(vo);
	 }
	
	 @Test
	 public void testFindMsgTemplatePage() {		
		 OperateMsgTemplateVO vo = getOperateMsgInfoVO();
		 sys.findMsgTemplatePage(vo);
	 }
	 
	 @Test
	 public void testFindMsgTemplate() {		
		 OperateMsgTemplateVO vo = getOperateMsgInfoVO();
		 sys.findMsgTemplatePage(vo);
	 }
	 
	 @Test
	 public void testFindWechatTemplate() {		
		 OperateWechatTemplateVO vo = new OperateWechatTemplateVO();
		 vo.setId(1);
		 sys.findWechatTemplate(vo);
	 }
	 
	 @Test
	 public void testFindArticleType() {		
		 OperateArticleTypeVO vo = new OperateArticleTypeVO();
		 vo.setId((long) 1);
		 sys.findArticleType(vo);
	 }
	 
	 @Test
	 public void testListArticle() {		
		 OperateArticleVO vo = getOperateArticleVO();
		 sys.listArticle(vo);
	 }
	 
	 @Test
	 public void testFindSingleArticle() {		
		 OperateArticleVO vo = getOperateArticleVO();
		 sys.listArticle(vo);
	 }
	 
	 @Test
	 public void testFindArticleParentPaths() {		
		 OperateArticleVO vo = getOperateArticleVO();
		 sys.listArticle(vo);
	 }
	 
	 @Test
	 public void testFindArticle() {		
		 OperateArticleVO vo = getOperateArticleVO();
		 sys.listArticle(vo);
	 }
	 
	 @Test
	 public void testFindMsgInfoById() {				
		 sys.findMsgInfoById(1);
	 }

	 @Test
	 public void findMsgTemplateById() {				
		 sys.findMsgTemplateById(1);
	 }
	 
	 @Test
	 public void testFindWechatTemplateById() {				
		 sys.findWechatTemplateById(1);
	 }
	 
	 @Test
	 public void testFindConfigByUserId() {				
		 sys.findConfigByUserId(1);
	 }
	 
	 @Test
	 public void testFindNewMsg() {	
		 OperateMsgNewVO vo = new OperateMsgNewVO();
		 vo.setId(1);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 sys.findNewMsg(vo);
	 }
	 
	 @Test
	 public void testListOperateImg() {	
		 OperateImgVO vo = getOpreateImgVO();
		 sys.listOperateImg(vo);
	 }
	 
	 @Test
	 public void testGetOperateImg() {	
		 OperateImgVO vo = getOpreateImgVO();
		 sys.listOperateImg(vo);
	 }

	 @Test
	 public void testFindOperateCorrectList() {	
		 OperateHelpCorrectVO vo = new OperateHelpCorrectVO();
		 vo.setId(1);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 sys.findOperateCorrectList(vo);
	 }
	 
	 @Test
	 public void testListHelpType() {	
		 sys.listHelpType();
	 }
	 
	 @Test
	 public void testFindSingleHelp() {	
		 OperateHelpVO vo = new OperateHelpVO();
		 vo.setId((long) 1);
		 sys.findSingleHelp(vo);
	 }
	 
	 @Test
	 public void testFindHelpParentPaths() {	
		 OperateHelpVO vo = new OperateHelpVO();
		 vo.setId((long) 1);
		 sys.findHelpParentPaths(vo);
	 }
	 
	 @Test
	 public void testFindHelpType() {	
		 OperateHelpTypeVO vo = new OperateHelpTypeVO();
		 vo.setId((long) 1);
		 sys.findHelpType(vo);
	 }
	 
	 @Test
	 public void testFindUserCloseNoticConfig() {			
		 sys.findUserCloseNoticConfig(1);
	 }
	 
	 @Test
	 public void testFindLotteryConfig() {			
		 sys.findLotteryConfig(1,1);
	 }
	 
	 @Test
	 public void testFindUserConfig() {			
		 sys.findUserConfig(1,1);
	 }
	 
	 @Test
	 public void testFindValidUserInfo() {			
		 sys.findValidUserInfo(1,4);
	 }
	 
	 @Test
	 public void testFindLotteryConfigById() {			
		 sys.findLotteryConfigById(1);
	 }
	 
	 @Test
	 public void testFindSoftwareVersionList() {		
		 OperateSoftwareVersionVO vo = getOperateSoftwareVersionVO();
		 sys.findSoftwareVersionList(vo);
	 }
	 
	 @Test
	 public void testFindNewSoftwareVersion() {		
		 OperateSoftwareVersionVO vo = getOperateSoftwareVersionVO();
		 sys.findNewSoftwareVersion(vo);
	 }

	 @Test
	 public void testListMarketchannel() {		
		 OperateMarketChannelVO vo = new OperateMarketChannelVO();
		 vo.setId(1);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 sys.listMarketchannel(vo);
	 }
	 
	 @Test
	 public void testFindSportAgainstInfo() {		
		 SportAgainstVO vo = new SportAgainstVO();
		 vo.setLotteryCode((short) 100);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 sys.findSportAgainstInfo(vo);
	 }
	 
	 @Test
	 public void testFindRebateUser() {		
		 OperateRebateUserVO vo = new OperateRebateUserVO();
		 vo.setId(1);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 sys.findRebateUser(vo);
	 }
	 	 
	 @Test
	 public void testFindOneSoftwareVersion() {		
		 OperateSoftwareVersionVO vo = getOperateSoftwareVersionVO();
		 sys.findOneSoftwareVersion(vo);
	 }
	 
	 
	 private OperateSoftwareVersionVO getOperateSoftwareVersionVO() {
		 OperateSoftwareVersionVO vo = new OperateSoftwareVersionVO();
		 vo.setId(1);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 return vo;
	 }

	 private OperateImgVO getOpreateImgVO() {
		 OperateImgVO vo = new OperateImgVO();
		 vo.setId(1);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		return vo;
	 }
	 
	 
	 
	 private OperateArticleVO getOperateArticleVO() {
		 OperateArticleVO vo = new OperateArticleVO();
		 vo.setId((long) 1);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 return vo;
	 }
	 
	 
	 

	 private OperateMsgTemplateVO getOperateMsgInfoVO() {
		 OperateMsgTemplateVO vo = new OperateMsgTemplateVO();
		 vo.setId(1);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 return vo;
	 }
	 
	 

	 
	 
	 

	 private OperateAdMenuVO getOperateAdMenuVO() {
		 OperateAdMenuVO vo = new OperateAdMenuVO();
		 vo.setMenu(1);
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 return vo;
	 }
	 
	 
	 
	 
	 private OperateMarketChannelVO getOperateMarketChannelVO() {
		 OperateMarketChannelVO vo = new OperateMarketChannelVO();
		 vo.setChannelId("1");
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 return vo;
	 }
	 
	 
	 
	 
	 
	 
}
