package com.hhly.test;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.hhly.cmscore.cms.remote.service.IUserWalletMgrService;
import com.hhly.persistence.util.HessianUtils;
import com.hhly.skeleton.cms.customermgr.vo.UserWalletVO;

public class UserWalletMgrServiceTest {

	private String url;
	
	private IUserWalletMgrService sys;
	
	@Before
	public void before() throws MalformedURLException{
	    url = "http://localhost:8081/lotto-cms-core/remote//userWalletMgrService";
	    sys = HessianUtils.getRemoteService(IUserWalletMgrService.class, url);
	}
	
	@Test
	public void testFindPaging() {		
		UserWalletVO vo = new UserWalletVO();
		vo.setId((long) 1);
		vo.setPageIndex(0);
		vo.setPageSize(30);
		sys.findPaging(vo);
	}
}
