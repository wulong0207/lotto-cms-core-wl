package com.hhly.test;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.hhly.cmscore.cms.remote.service.ISportBallMgrService;
import com.hhly.persistence.util.HessianUtils;
import com.hhly.skeleton.cms.sportmgr.vo.SMGLotteryParamVO;

public class SportBallMgrServiceTest {
	
	private String url;
	
	private ISportBallMgrService sys;
	
	 @Before
	 public void before() throws MalformedURLException{
	    url = "http://localhost:8081/lotto-cms-core/remote//sportBallMgrService";
	    sys = HessianUtils.getRemoteService(ISportBallMgrService.class, url);
	 }
	 
	 @Test
	 public void testFindOldLotteryInfo() {
		 SMGLotteryParamVO vo = getSMGLotteryParamVO();
		 sys.findOldLotteryInfo(vo);
	 }
	 
	 @Test
	 public void testFindOldSp() {
		 sys.findOldSp((long) 1);
	 }
	 
	 @Test
	 public void testFindFBData() {
		 SMGLotteryParamVO vo = getSMGLotteryParamVO();
		 sys.findFBData(vo);
	 }
	 
	 @Test
	 public void testFindFBSp() {		
		 sys.findFBSp((long) 1);
	 }
	 
	 @Test
	 public void testFindBJSp() {		
		 sys.findBJSp((long) 1);
	 }
	 
	 @Test
	 public void testFindWFSp() {		
		 sys.findWFSp((long) 1);
	 }
	 
	 @Test
	 public void testFindBJData() {	
		 SMGLotteryParamVO vo = getSMGLotteryParamVO();
		 sys.findBJData(vo);
	 }
	 
	 @Test
	 public void testFindBBData() {	
		 SMGLotteryParamVO vo = getSMGLotteryParamVO();
		 sys.findBBData(vo);
	 }
	 
	 @Test
	 public void testFindWFData() {	
		 SMGLotteryParamVO vo = getSMGLotteryParamVO();
		 sys.findWFData(vo);
	 }
	 
	 @Test
	 public void testFindFbExcelList() {	
		 SMGLotteryParamVO vo = getSMGLotteryParamVO();
		 sys.findFbExcelList(vo);
	 }
	 
	 @Test
	 public void testFindOldOrderMatchDetail() {	
		 SMGLotteryParamVO vo = getSMGLotteryParamVO();
		 sys.findOldOrderMatchDetail(vo);
	 }
	 
	 @Test
	 public void testFindBjOrderMatchDetail() {	
		 SMGLotteryParamVO vo = getSMGLotteryParamVO();
		 sys.findBjOrderMatchDetail(vo);
	 }
	 
	 @Test
	 public void testFindFbOrderMatchDetail() {	
		 SMGLotteryParamVO vo = getSMGLotteryParamVO();
		 sys.findFbOrderMatchDetail(vo);
	 }	 
	 
	 private SMGLotteryParamVO getSMGLotteryParamVO() {
		 SMGLotteryParamVO vo = new SMGLotteryParamVO();
		 vo.setLotteryCode(100);
		 vo.setLotteryIssue("2016117");
		 vo.setPageIndex(0);
		 vo.setPageSize(30);
		 vo.setSystemCode("00");
		 return vo;
	 }
	 
	 
}
