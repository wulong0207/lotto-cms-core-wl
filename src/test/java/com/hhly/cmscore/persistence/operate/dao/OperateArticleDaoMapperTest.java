package com.hhly.cmscore.persistence.operate.dao;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hhly.cmscore.persistence.operate.dao.OperateArticleDaoMapper;
import com.hhly.cmscore.persistence.operate.po.OperateArticlePO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateArticleBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateArticleVO;
import com.hhly.skeleton.cms.sysmgr.bo.CMSUserBO;
import com.hhly.skeleton.lotto.base.operate.bo.ClickBO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateArticleBaseBO;
import com.hhly.skeleton.lotto.base.operate.bo.OperateArticleLottBO;
import com.hhly.skeleton.lotto.base.operate.vo.OperateArticleLottVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class OperateArticleDaoMapperTest {

	@Autowired
	private OperateArticleDaoMapper mapper;
	
	@Test
	public void testFindTotal() {
		int total = mapper.findTotal(new OperateArticleVO());
		System.out.println(total);
	}

	@Test
	public void testList() {
		List<OperateArticleBO> bos = mapper.list(new OperateArticleVO());
		int total = mapper.findTotal(new OperateArticleVO());
		assertTrue(bos.size()==total);
	}

	@Test(expected=Exception.class)
	public void testAddNull() {
		OperateArticleVO vo = new OperateArticleVO();
		OperateArticlePO po = new OperateArticlePO(vo);
		mapper.add(po);
	}
	
	@Test
	public void testAdd() {
		OperateArticleVO vo = new OperateArticleVO();
		vo.setArticleId("junitTestArticleId");
		vo.setArticleTitle("junit测试新增文章");
		vo.setArticleContent("<p>junit测试新增文章</p>");
		vo.setTypeId(2L);
		vo.setTypeName("网站公告");
		vo.setStatus(1);
		vo.setWeb((byte)1);
		vo.setWap((byte)1);
		vo.setAndroid((byte)0);
		vo.setIos((byte)0);
		vo.setOrderId(0);
		vo.setArticleFrom("stackoverflow");
		vo.setFromUrl("https://stackoverflow.com/questions/18656089/japanese-characters-escape-and-decoding-in-js");
		vo.setArticleUrl("http://192.168.74.169/jczx.html#/detail/2017052900001ce3d8ad.html");
		vo.setArticleSummary("北京时间5月29日，意甲联赛结束了第38轮的争夺，2016-17赛季落下帷幕。尤文图斯再次蝉联联赛冠军，实现6连冠霸业；罗马成为联赛亚军，那不勒斯最终排名第3。");
		vo.setArticleLabel("意甲联赛,第38轮,争夺");
		vo.setClick(666L);
		vo.setCreateBy("junit测试");
		vo.setModifyBy("junit测试Modify");
		vo.setReleaseTime(new Date());
		vo.setTypeCode("1.1");
		OperateArticlePO po = new OperateArticlePO(vo);
		int ret = mapper.add(po);
		assertTrue(ret==1);
	}

	@Test
	public void testUpdate() {
		OperateArticleVO vo = new OperateArticleVO();
		vo.setId(1L);
		vo.setArticleId("junitUpdateArticleId");
		vo.setArticleTitle("junit测试更新文章");
		vo.setArticleContent("<p>junit测试更新文章</p>");
		vo.setTypeId(3L);
		vo.setTypeName("赛事公告");
		vo.setStatus(1);
		vo.setReleaseTime(new Date());
		vo.setWeb((byte)1);
		vo.setWap((byte)1);
		vo.setAndroid((byte)0);
		vo.setIos((byte)0);
		vo.setOrderId(0);
		vo.setArticleFrom("stackoverflow");
		vo.setFromUrl("https://stackoverflow.com/questions/18656089/japanese-characters-escape-and-decoding-in-js");
		vo.setArticleUrl("http://192.168.74.169/jczx.html#/detail/2017052900001ce3d8ad.html");
		vo.setArticleSummary("北京时间5月29日，意甲联赛结束了第38轮的争夺，2016-17赛季落下帷幕。尤文图斯再次蝉联联赛冠军，实现6连冠霸业；罗马成为联赛亚军，那不勒斯最终排名第3。");
		vo.setArticleLabel("意甲联赛,第38轮,争夺");
		vo.setClick(666L);
		vo.setCreateBy("junit测试");
		vo.setModifyBy("junit测试Modify");
		vo.setTypeCode("1.2");
		OperateArticlePO po = new OperateArticlePO(vo);
		int ret = mapper.add(po);
		assertTrue(ret==1);
	}

	@Test
	public void testFindSingle() {
		OperateArticleBO bo = mapper.findSingle(new OperateArticleVO(200L));
		System.out.println(bo);
	}

	@Test
	public void testUpdateStatus() {
		OperateArticleVO vo = new OperateArticleVO();
		vo.setId(253L);
		vo.setStatus(1);
		vo.setAuditBy("AuditByJunit");
		OperateArticlePO po = new OperateArticlePO(vo);
		int ret = mapper.updateStatus(po);
		assertTrue(ret==1);
	}

	@Test
	public void testFindArticleByTop() {
		OperateArticleLottVO vo = new OperateArticleLottVO();
		vo.setStartRow(1);
		vo.setPageSize(10);
		List<OperateArticleLottBO> bos = mapper.findArticleByTop(vo);
		System.out.println(bos);
	}

	@Test
	public void testFindNewArticle() {
		OperateArticleLottVO vo = new OperateArticleLottVO();
		vo.setStartRow(1);
		vo.setPageSize(10);
		List<OperateArticleLottBO> bos = mapper.findNewArticle(vo);
		System.out.println(bos);
	}

	@Test
	public void testFindArticle() {
		OperateArticleLottVO vo = new OperateArticleLottVO();
		vo.setId(200L);
		OperateArticleLottBO bo = mapper.findArticle(vo);
		System.out.println(bo);
	}

	@Test
	public void testFindArticleByTypeList() {
		OperateArticleLottVO vo = new OperateArticleLottVO();
		vo.setTypeCode("1.1");
		OperateArticleLottVO vo2 = new OperateArticleLottVO();
		vo2.setTypeCode("1.2");
		List<OperateArticleLottVO> vos = new ArrayList<>();
		vos.add(vo);
		vos.add(vo2);
		List<OperateArticleBaseBO> bos = mapper.findArticleByTypeList(vos);
		System.out.println(bos);
	}

	@Test
	public void testFindNewsByTypeList() {
		OperateArticleLottVO vo = new OperateArticleLottVO();
		vo.setTypeCode("1.1");
		OperateArticleLottVO vo2 = new OperateArticleLottVO();
		vo2.setTypeCode("1.2");
		List<OperateArticleLottVO> vos = new ArrayList<>();
		vos.add(vo);
		vos.add(vo2);
		List<OperateArticleLottBO> bos = mapper.findNewsByTypeList(vos);
		System.out.println(bos);
	}

	@Test
	public void testUpdateClick() {
		OperateArticleLottVO vo = new OperateArticleLottVO();
		//vo.setArticleId("20170605000019a3baa8");
		vo.setId(200L);
		int ret = mapper.updateClick(vo);
		System.out.println(ret);
	}

	@Test
	public void testUpdateClickList() {
		ClickBO bo = new ClickBO();
		ClickBO bo2 = new ClickBO();
		List<ClickBO> bos = new ArrayList<>();
		bos.add(bo);
		bos.add(bo2);
		int ret = mapper.updateClickList(bos);
		System.out.println(ret);
	}

	@Test
	public void testFindUserByArtType() {
		OperateArticleLottVO vo = new OperateArticleLottVO();
		vo.setRownum(10);
		List<CMSUserBO> bos = mapper.findUserByArtType(vo);
		System.out.println(bos);
	}

	@Test
	public void testFindArticleByUserList() {
		OperateArticleLottVO vo = new OperateArticleLottVO();
		vo.setRownum(10);
		List<CMSUserBO> bos = mapper.findUserByArtType(vo);
		System.out.println(bos);
	}

	@Test
	public void testFindArticleLabel() {
		OperateArticleLottVO vo = new OperateArticleLottVO();
		List<OperateArticleLottBO> bos = mapper.findArticleLabel(vo);
		System.out.println(bos);
	}

	@Test
	public void testFindMaxArticleId() {
		String maxArticleId = mapper.findMaxArticleId("20170605");
		System.out.println(maxArticleId);
	}

	@Test
	public void testFindSidebarNews() {
		OperateArticleLottVO vo = new OperateArticleLottVO();
		vo.setRownum(10);
		List<OperateArticleLottBO> bos = mapper.findSidebarNews(vo);
		System.out.println(bos);
	}

	@Test
	public void testFindClick() {
		List<ClickBO> bos = mapper.findClick();
		System.out.println(bos);
	}

}
