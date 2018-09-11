package com.hhly.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.hhly.cmscore.cms.remote.service.ISysMgrService;
import com.hhly.persistence.util.HessianUtils;
import com.hhly.skeleton.cms.base.vo.StringVO;
import com.hhly.skeleton.cms.dicmgr.vo.DicDataDetailVO;
import com.hhly.skeleton.cms.dicmgr.vo.DicDataVO;
import com.hhly.skeleton.cms.sysmgr.vo.CMSMenuVO;
import com.hhly.skeleton.cms.sysmgr.vo.CMSRoleVO;
import com.hhly.skeleton.cms.sysmgr.vo.CMSUserVO;
import com.hhly.skeleton.cms.sysmgr.vo.CmsKeywordVO;
import com.hhly.skeleton.cms.sysmgr.vo.CmsUserLogVO;

public class SysMgrServiceTest {
	private String url;
	
	private ISysMgrService sys;
    @Before
	public void before() throws MalformedURLException{
    	url = "http://localhost:8081/lotto-cms-core/remote/sysMgrService";
    	sys = HessianUtils.getRemoteService(ISysMgrService.class, url);
    }
    
    @Test
    public void selectDicData(){
    	DicDataVO dicDataVO = new DicDataVO();
    	/*dicDataVO.setEndRow(1);
    	dicDataVO.setEndRow(2);*/
    	//dicDataVO.setDicName("哈");
    	dicDataVO.setDicCode("1");
    	//List<DicDataBO> result =sys.findDicData(dicDataVO);
    	//System.out.println(result.size());
//    	dicDataVO.setDicCode("1");
//    	List<DicDataBO> result =sys.findDicData(dicDataVO);
//    	System.out.println(result.size());
    }
    @Test
    public void listDicDataDetail(){
        sys.listDicDataDetail("0302");
    }
    @Test
    public  void  ip() throws IOException {
    	File file=new File("F:\\kj_access_trend.2016-12-15.log");
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();
        @SuppressWarnings("resource")
		BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        temp=br.readLine();
        Map<String,Integer> map = new HashMap<>();
        while(temp!=null){
        	if(temp.length()>20){
	        	int num =temp.indexOf(" - -");
	        	if(num !=-1){
	        		String s = temp.substring(0,num);
	        		if(map.containsKey(s)){
	        			map.put(s, map.get(s)+1);
	        		}else{
	        			map.put(s, 1);
	        		}
	        	}
        	}
            temp=br.readLine();
        }
        int num = 0;
        for (String key : map.keySet()) {
        	int value = map.get(key);
			if(value >=1000){
				System.out.println(key+":"+value);
				num++;
			}
		}
        System.out.println(num);
	}
    
    
    @Test
    public void testSelectAll() {
    	sys.selectAll();
    }
       
    @Test
    public void testFindMenuByUserId() {
    	Integer userId = 96;
    	sys.findMenuByUserId(userId);
    }
    
    @Test
    public void testFindMenus() {
    	CMSMenuVO vo = new CMSMenuVO();
    	vo.setMenuId(3);
    	sys.findMenus(vo);
    }
    
    @Test
    public void testSelectRoleData() {
    	CMSRoleVO cmsRoleVO = new CMSRoleVO();
    	cmsRoleVO.setRoleId(2);
    	cmsRoleVO.setPageIndex(0);
    	cmsRoleVO.setPageSize(30);
    	sys.selectRoleData(cmsRoleVO);
    }
    
    @Test
    public void testFindRoleName() {
    	sys.findRoleName();
    }
    
    @Test
    public void testFindAuthorityByRoleId() {
    	sys.findAuthorityByRoleId(2);
    }
    
    @Test
    public void testFindUserData() {
    	CMSUserVO vo = getCMSUserVO();
    	sys.findUserData(vo);
    }
    
    @Test
    public void testFindUserAuth() {
    	CMSUserVO vo = getCMSUserVO();
    	sys.findUserAuth(vo);
    }
    
    
    @Test
    public void testFindUserName() {
    	CMSUserVO vo = getCMSUserVO();
    	sys.findUserName(vo);
    }
    
    @Test
    public void testFindCount() {
    	CMSUserVO vo = getCMSUserVO();
    	sys.findCount(vo);
    }
    
    @Test
    public void testFindDicData() {
    	DicDataVO dicDataVO = getDicDataVO();   	
    	sys.findDicData(dicDataVO);
    }
    
    @Test
    public void testFindDicDataDetail() {
    	StringVO vo = getStingVO();
    	sys.findDicDataDetail(vo);
    }
    
    @Test
    public void testFindDicDataDetails() {
    	DicDataDetailVO vo = new DicDataDetailVO();
    	vo.setDicCode("101");
    	vo.setPageIndex(0);
    	vo.setPageSize(30);
    	sys.findDicDataDetails(vo);
    }
    
    @Test
    public void testFindDicDataDetailSimple() {
    	StringVO vo = getStingVO();
    	sys.findDicDataDetailSimple(vo);
    }

    @Test
    public void testListDicDataDetail() {
    	sys.listDicDataDetail("101");
    }
    
    @Test
    public void testFindKeyword() {
    	CmsKeywordVO vo = new CmsKeywordVO();
    	vo.setId(1);
    	vo.setPageIndex(0);
    	vo.setPageSize(30);
    	sys.findKeyword(vo);
    }
    
    @Test
    public void testFindUserType() {   	
    	sys.findUserType();
    }
    
    @Test
    public void testFindUsers() {   	
    	CMSUserVO vo = getCMSUserVO();
    	sys.findUsers(vo);
    }
    
    @Test
    public void testListUserLog() {   	
    	CmsUserLogVO vo = getCMSUserLogVO();
    	sys.listUserLog(vo);
    }
    
    @Test
    public void testFindUserLog() {   	
    	CmsUserLogVO vo = getCMSUserLogVO();
    	sys.findUserLog(vo);
    }
    
	private CmsUserLogVO getCMSUserLogVO() {
		CmsUserLogVO vo = new CmsUserLogVO();
    	vo.setUserName("ruru");
    	vo.setPageIndex(0);
    	vo.setPageSize(30);
		return vo;
	}
    
	private StringVO getStingVO() {
		StringVO vo = new StringVO();
    	vo.setStr("6");
		return vo;
	}

	private DicDataVO getDicDataVO() {
		DicDataVO dicDataVO = new DicDataVO();
    	dicDataVO.setDicCode("0001");
    	dicDataVO.setPageIndex(0);
    	dicDataVO.setPageSize(30);
		return dicDataVO;
	}

	private CMSUserVO getCMSUserVO() {
		CMSUserVO vo = new CMSUserVO();
    	vo.setUserId(2);
    	vo.setPageIndex(0);
    	vo.setPageSize(30);
		return vo;
	}
    
    
}