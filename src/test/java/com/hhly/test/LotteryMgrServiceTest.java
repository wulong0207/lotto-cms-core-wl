package com.hhly.test;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.hhly.cmscore.cms.remote.service.ILotteryMgrService;
import com.hhly.persistence.util.HessianUtils;
import com.hhly.skeleton.cms.base.vo.StringVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryChildCmsVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryIssueCmsVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryLimitInfoVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryLimitVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryTypeVO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryWinningVO;

/**
 * @author jiangwei
 * @Version 1.0
 * @CreatDate 2016-12-20 下午3:12:30
 * @Desc 彩种管理
 */
public class LotteryMgrServiceTest {
	private String url;
	
	private ILotteryMgrService sys;
    @Before
	public void before() throws MalformedURLException{
    	url = "http://localhost:8081/lotto-cms-core/remote/lotteryMgrService";
    	sys = HessianUtils.getRemoteService(ILotteryMgrService.class, url);
    }
    /**
     * 测试彩期自动生成
     */
    @Test
    public void createIssueSSQ(){
    	//System.out.println(sys.createIssue(100));
    	/*System.out.println("测试彩期自动生成开始");
    	for(Lottery lot :Lottery.values()){
    		System.out.println(JSONUtils.valueToString(sys.createIssue(lot.getName())));
    	}
    	System.out.println("测试彩期自动生成结束");*/
    }
    @Test
    public void createIssueCQSSC(){
    	//System.out.println(sys.createIssue(201));
    }
    
    private LotteryTypeVO getLotteryTypeVo() {
		LotteryTypeVO vo = new LotteryTypeVO();
		vo.setLotteryCode(100);
    	vo.setPageIndex(0);
    	vo.setPageSize(30);
    	return vo;
	}
    
    @Test
    public void testFindLotteryType() {   	
    	LotteryTypeVO vo = getLotteryTypeVo();   	
    	sys.findLotteryType(vo);
    }
  
    @Test
    public void testFindSingle() {
    	LotteryTypeVO vo = getLotteryTypeVo();
    	sys.findSingle(vo);
    }
    
    @Test
    public void testFindLotteryDettingMul() {
    	StringVO vo = getStringVo();
    	sys.findLotteryDettingMul(vo);
    }
    
    @Test
    public void testFindLotteryChild() {
    	StringVO vo = getStringVo();
    	sys.findLotteryChild(vo);
    }
    
    @Test
    public void testFindIssueCode() {   	
    	LotteryIssueCmsVO vo = getLotteryIssueCmsVO();
    	sys.findIssueCode(vo);
    }
	private LotteryIssueCmsVO getLotteryIssueCmsVO() {
		LotteryIssueCmsVO vo = new LotteryIssueCmsVO();
    	vo.setIssueCode("91591");
    	vo.setLotteryCode(100);
    	vo.setPageIndex(0);
    	vo.setPageSize(30); 
    	vo.setQryCount(10);
		return vo;
	}
    
    @Test
    public void testFindLotteryIssue() {   	
    	LotteryIssueCmsVO vo = getLotteryIssueCmsVO();
    	sys.findLotteryIssue(vo);
    }
    
    @Test
    public void testFindLotteryIssueDetail() {
    	StringVO vo = getStringVo();
    	sys.findLotteryIssueDetail(vo);
    }
    
	private StringVO getStringVo() {
		StringVO vo = new StringVO();
    	vo.setStr("100");
		return vo;
	}
		
	@Test
	public void testFindIssue(){
		Short currentIssue = 1;
		Integer lotteryCode = 100;
		sys.findIssue(lotteryCode, currentIssue);
	}
	
	// 测试根据彩种分类查询
	@Test
	public void testFindLotteryTypeDic() {
		StringVO vo = getStringVo();
		sys.findLotteryTypeDic(vo);
	}
	
	 //@desc 测试查询多个子玩法列表
	@Test
	public void testfindMultipleChild() {
		LotteryChildCmsVO lotteryChildCms = new LotteryChildCmsVO();
		lotteryChildCms.setLotteryChildCode(100);
		lotteryChildCms.setLotteryCode(100);
		sys.findMultipleChild(lotteryChildCms);
	}
	
	@Test
	public void testListCurrentIssue() {
		String lotteryCategory = "1";
		sys.listCurrentIssue(lotteryCategory);
	}
	
	@Test
	public void testGetLotteryIssueMonitor() {
		int  lotteryCode = 100;
		sys.getLotteryIssueMonitor(lotteryCode);
	}
	
	@Test
	public void testFindSingleLimit() {	
		LotteryLimitVO lotteryLimitVO = new LotteryLimitVO();
		lotteryLimitVO.setLotteryCode(100);		
		sys.findSingleLimit(lotteryLimitVO);
	}
	
	@Test
	public void testFindPagingLimit() {	
		LotteryLimitVO lotteryLimitVO = new LotteryLimitVO();
		lotteryLimitVO.setLotteryCode(100);		
		lotteryLimitVO.setPageIndex(0);
		lotteryLimitVO.setPageSize(30);
		sys.findPagingLimit(lotteryLimitVO);
	}
	
	
	@Test
	public void testFindSingleLimitInfo() {	
		LotteryLimitInfoVO lotteryLimitInfoVO = new LotteryLimitInfoVO();
		lotteryLimitInfoVO.setLimitId(100);
		sys.findSingleLimitInfo(lotteryLimitInfoVO);
	}
	
	@Test
	public void testFindPagingLimitInfo() {	
		LotteryLimitInfoVO lotteryLimitInfoVO = new LotteryLimitInfoVO();
		lotteryLimitInfoVO.setLimitId(100);
		lotteryLimitInfoVO.setPageIndex(0);
		lotteryLimitInfoVO.setPageSize(30);
		sys.findSingleLimitInfo(lotteryLimitInfoVO);
	}
	
	@Test
	public void testFindSingleLotWinning() {		
		LotteryWinningVO lotteryWinningVO = new LotteryWinningVO();
		lotteryWinningVO.setLotteryCode(100);
		sys.findSingleLotWinning(lotteryWinningVO);
	}
		
	@Test
	public void testFindMultipleLotWinning() {		
		LotteryWinningVO lotteryWinningVO = new LotteryWinningVO();
		lotteryWinningVO.setLotteryCode(100);
		sys.findMultipleLotWinning(lotteryWinningVO);
	}
	
	@Test
	public void testFindAllLotteryType() {
		sys.findAllLotteryType();
	}
	
	@Test
	public void testFindIssueByParam() {
		sys.findIssueByParam(100, "2016051", 1);
	}
	
	
	
	
}
