package com.hhly.cmscore.persistence.operate.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateSoftwareVersionDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateSoftwareVersionPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateSoftwareVersionBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateSoftwareVersionVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateLottSoftwareVersionBO;
import com.hhly.skeleton.lotto.base.operate.vo.OperateLottSoftwareVersionVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateSoftwareVersionDaoMapperTest {

	@Autowired
	private OperateSoftwareVersionDaoMapper mapper;
	
	@Test
	public void testInsert() {
		OperateSoftwareVersionVO vo = new OperateSoftwareVersionVO();
		vo.setCode(123);
		vo.setIsnew((short)1);
		vo.setIsupdate((short)1);
		vo.setDescribe("sfasdf");
		vo.setUrl("http://lasdfasfd");
		vo.setRemark("remarkkkkk");
		vo.setName("asdfa");
		vo.setSize("sizesize");
		vo.setType((short)1);
		vo.setAppUrl("app://localhost:aaaa");
		vo.setCreateBy("by junit");
		OperateSoftwareVersionPO po = new OperateSoftwareVersionPO(vo);
		int ret = mapper.insert(po);
		System.out.println(ret);
	}

	@Test
	public void testFindTotal() {
		OperateSoftwareVersionVO vo = new OperateSoftwareVersionVO();
		int ret = mapper.findTotal(vo);
		System.out.println(ret);
	}

	@Test
	public void testFind() {
		OperateSoftwareVersionVO vo = new OperateSoftwareVersionVO();
		List<OperateSoftwareVersionBO> ret = mapper.find(vo);
		System.out.println(ret);
	}

	@Test
	public void testFindBaseSoftwareVersion() {
		OperateSoftwareVersionVO vo = new OperateSoftwareVersionVO();
		List<OperateSoftwareVersionBO> ret = mapper.findBaseSoftwareVersion(vo);
		System.out.println(ret);
	}

	@Test
	public void testDeleteByIds() {
		int ret = mapper.deleteByIds(Arrays.asList("1"));
		System.out.println(ret);
	}

	@Test
	public void testUpdateById() {
		OperateSoftwareVersionVO vo = new OperateSoftwareVersionVO();
		vo.setId(1);
		OperateSoftwareVersionPO po = new OperateSoftwareVersionPO(vo);
		int ret = mapper.updateById(po);
		System.out.println(ret);
	}

	@Test
	public void testUpdateIsnew() {
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("newIsnew", 1);
		paramMap.put("isnew", 1);
		paramMap.put("type", 1);
		int ret = mapper.updateIsnew(paramMap);
		System.out.println(ret);
	}

	@Test
	public void testValiSoftwareVersionCode() {
		int ret = mapper.valiSoftwareVersionCode(123);
		System.out.println(ret);
	}

	@Test
	public void testFindNewVersion() {
		OperateLottSoftwareVersionVO vo = new OperateLottSoftwareVersionVO();
		vo.setType((short)1);
		vo.setChannelId(1);
		OperateLottSoftwareVersionBO ret = mapper.findNewVersion(vo);
		System.out.println(ret);

	}

}
