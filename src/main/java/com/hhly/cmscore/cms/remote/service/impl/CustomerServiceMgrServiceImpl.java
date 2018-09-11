package com.hhly.cmscore.cms.remote.service.impl;

import com.hhly.cmscore.cms.remote.service.ICustomerServiceMgrService;
import com.hhly.cmscore.persistence.customerservice.dao.MUserMessageDaoMapper;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.page.ISimplePage;
import com.hhly.skeleton.cms.customerservice.bo.MUserMessageBO;
import com.hhly.skeleton.cms.customerservice.vo.MUserMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerServiceMgrService")
public class CustomerServiceMgrServiceImpl implements ICustomerServiceMgrService{
	@Autowired
	private MUserMessageDaoMapper mUserMessageDaoMapper;
	@Autowired
	private IPageService pageService;

	@Override
	public PagingBO<MUserMessageBO> findMUserMeaasge(final MUserMessageVO vo) {
		return pageService.getPageData(vo, new ISimplePage<MUserMessageBO>(){

			@Override
			public int getTotal() {
				return mUserMessageDaoMapper.findTotal(vo);
			}

			@Override
			public List<MUserMessageBO> getData() {
				return mUserMessageDaoMapper.find(vo);
			}
			
		} );
	}

	@Override
	public void updateStatus(Integer id, Integer sendStatus) {
		mUserMessageDaoMapper.updateStatus(id, sendStatus);
	}

}
