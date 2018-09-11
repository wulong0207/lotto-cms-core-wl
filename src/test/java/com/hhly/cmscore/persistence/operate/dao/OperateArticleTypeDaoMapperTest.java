package com.hhly.cmscore.persistence.operate.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateArticleTypeDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateArticleTypePO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateArticleTypeBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleTypeVO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleVO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateArticleBaseBO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateArticleLottBO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateArticleTypeLottBO;
import com.hhly.skeleton.lotto.base.operate.vo.OperateArticleLottVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateArticleTypeDaoMapperTest {

	@Autowired
	private OperateArticleTypeDaoMapper mapper;
	
	@Test
	public void testMerge() {
		OperateArticleTypeVO vo = new OperateArticleTypeVO();
		vo.setTypeCode("1.1.1");
		vo.setTypeFullName("testByJunit");
		vo.setTypeShortName("tbj");
		vo.setTypeParent(1L);
		vo.setTypeLevel((byte)1);
		vo.setStatus((byte)1);
		vo.setIdentifiers("Junit");
		vo.setVirtual((byte)1);
		OperateArticleTypePO po = new OperateArticleTypePO(vo);
		int ret = mapper.merge(po);
		System.out.println(ret);
	}

	@Test
	public void testList() {
		List<OperateArticleTypeBO> bos = mapper.list();
		System.out.println(bos);
	}

	@Test
	public void testFind() {
		OperateArticleTypeVO vo = new OperateArticleTypeVO();
		vo.setId(2L);
		OperateArticleTypeBO bo = mapper.find(vo);
		System.out.println(bo);
	}

	@Test
	public void testFindListByFaType() {
		List<OperateArticleTypeLottBO> bos = mapper.findListByFaType("1");
		System.out.println(bos);
	}

	@Test
	public void testFindMaxTypeCode() {
		OperateArticleTypeVO vo = new OperateArticleTypeVO();
		vo.setId(2L);
		String ret = mapper.findMaxTypeCode(vo);
		System.out.println(ret);
	}

	@Test
	public void testCount() {
		OperateArticleTypeVO vo = new OperateArticleTypeVO();
		int ret = mapper.count(vo);
		System.out.println(ret);
	}

	@Test
	public void testUpdateOrder() {
		OperateArticleTypeVO vo = new OperateArticleTypeVO();
		vo.setTypeCode("1.1.1");
		vo.setTypeFullName("testByJunit");
		vo.setTypeShortName("tbj");
		vo.setTypeParent(1L);
		vo.setTypeLevel((byte)1);
		vo.setStatus((byte)1);
		vo.setIdentifiers("Junit");
		vo.setVirtual((byte)1);
		OperateArticleTypeVO vo2 = new OperateArticleTypeVO();
		vo2.setTypeCode("1.1.2");
		vo2.setTypeFullName("testByJunit");
		vo2.setTypeShortName("tbj");
		vo2.setTypeParent(1L);
		vo2.setTypeLevel((byte)1);
		vo2.setStatus((byte)1);
		vo2.setIdentifiers("Junit");
		vo2.setVirtual((byte)1);
		List<OperateArticleTypePO> pos = new ArrayList<>();
		pos.add(new OperateArticleTypePO(vo));
		pos.add(new OperateArticleTypePO(vo2));
		int ret = mapper.updateOrder(pos);
		System.out.println(ret);
	}

	@Test
	public void testFindParents() {
		OperateArticleVO vo = new OperateArticleVO();
		vo.setTypeId(2L);
		List<String> ret = mapper.findParents(vo);
		System.out.println(ret);
	}

	@Test
	public void testFindNewsTypeList() {
		List<OperateArticleBaseBO> ret = mapper.findNewsTypeList();
		System.out.println(ret);
	}

	@Test
	public void testFindNewTypeRelatList() {
		OperateArticleLottVO vo = new OperateArticleLottVO();
		List<OperateArticleLottBO> ret = mapper.findNewTypeRelatList(vo);
		System.out.println(ret);
	}

}
