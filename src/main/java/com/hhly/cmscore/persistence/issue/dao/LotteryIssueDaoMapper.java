package com.hhly.cmscore.persistence.issue.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.issue.po.LotteryIssuePO;
import com.hhly.skeleton.base.issue.entity.NewIssueBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryIssueCmsBO;
import com.hhly.skeleton.cms.lotterymgr.bo.LotteryIssueExcelBO;
import com.hhly.skeleton.cms.lotterymgr.vo.LotteryIssueCmsVO;
import com.hhly.skeleton.lotto.base.issue.bo.IssueBO;
import com.hhly.skeleton.lotto.base.issue.bo.IssueDrawBO;
import com.hhly.skeleton.lotto.base.issue.bo.IssueLottBO;
import com.hhly.skeleton.lotto.base.issue.bo.IssueLottJCBO;
import com.hhly.skeleton.lotto.base.issue.bo.IssueOfficialTimeBO;
import com.hhly.skeleton.lotto.base.issue.bo.CurrentAndPreIssueBO;
import com.hhly.skeleton.lotto.base.issue.vo.LottoIssueVO;
import com.hhly.skeleton.lotto.base.lottery.vo.LotteryVO;

/**
 * @desc 彩期
 * @author jiangwei
 * @date 2017-2-16
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface LotteryIssueDaoMapper {

	/**************************** Used to CMS ********************************/
	/**
	 * 查询最近彩期，用于加载下拉
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017-2-16 上午9:53:17
	 * @param vo
	 * @return
	 */
	List<String> findIssueCode(LotteryIssueCmsVO vo);
	/**
	 * 查询当前期+历史期
	 * @param lotteryCode
	 * @param qryCount
	 * @author wul687 2018-08-15
	 * @return
	 */
	List<String> findcutOffHistoryIssue(@Param("lotteryCode") Integer lotteryCode,@Param("qryCount") Integer qryCount);
	
	/**
	 * 分页查询
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017-2-16 上午9:53:50
	 * @param vo
	 * @return
	 */
	List<LotteryIssueCmsBO> find(LotteryIssueCmsVO vo);

	/**
	 * 分页统计
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017-2-16 上午9:54:04
	 * @param vo
	 * @return
	 */
	int findTotal(LotteryIssueCmsVO vo);

	/**
	 * 修改
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017-2-16 上午9:54:15
	 * @param po
	 * @return
	 */
	int updIssueByKey(LotteryIssuePO po);

	/**
	 * 添加
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017-2-16 上午9:54:23
	 * @param po
	 * @return
	 */
	int addIssue(LotteryIssuePO po);

	/**
	 * 查询导出数据
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017-2-16 上午9:54:32
	 * @param vo
	 * @return
	 */
	List<LotteryIssueExcelBO> findIssueToExcel(LotteryIssueCmsVO vo);

	/**
	 * 查询详情
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017-2-16 上午9:55:13
	 * @param id
	 * @return
	 */
	LotteryIssueCmsBO findIssueDetial(@Param("id") String id);
	/**
	 * @desc 查询符合条件的期号数量
	 * @author Tony Wang
	 * @create 2017年2月13日
	 * @param vo
	 * @return
	 */
	int findIssueCount(LotteryIssueCmsVO vo);

	/**
	 * 查询当前期信息
	 * 
	 * @param lotteryCode
	 * @return
	 */
	LotteryIssueCmsBO findIssue(@Param("lotteryCode") Integer lotteryCode, @Param("currentIssue") short curr);

	
	/**
	 * 查询当前期彩种信息集合信息
	 * 
	 * @param lotteryCode
	 * @return
	 */
	List<LotteryIssuePO> findIssueCurrentList(List<Integer> list);
	/**
	 * 修改彩期销售截止时间
	 * 
	 * @param buyEndTime
	 * @return
	 */
	int updIssueBuyEndTime(@Param("buyEndTime") Integer buyEndTime, @Param("lotteryCode") Integer lotteryCode,
			@Param("issueCode") String issueCode);

	/**
	 * 查询当前期和之后期的官方截止时间
	 * 
	 * @param lotteryCode
	 * @return
	 */
	List<LotteryIssuePO> findIssueOfficialEndTime(@Param("lotteryCode") Integer lotteryCode,
			@Param("issueCode") String issueCode);

	int updateByKeySelective(LotteryIssuePO po);

	/**
	 * 批量修改开售时间
	 * 
	 * @param updateList
	 * @return
	 */
	int updateSaleTime(@Param("updateList") List<LotteryIssuePO> updateList);
	/**
	 * 查询彩种是否存在当前期
	 * 
	 * @param lotteryCode
	 * @return
	 */
	int findIssueCountCurrent(@Param("lotteryCode") Integer lotteryCode);

	/**
	 * 修改当前期为不是当前期
	 * 
	 * @param lotteryCode
	 * @return
	 */
	int updCurrentIssue(@Param("lotteryCode") Integer lotteryCode, @Param("currentIssue") Short currentIssue);

	/**
	 * @desc 查询已销售期数量
	 * @author Tony Wang
	 * @create 2017年2月13日
	 * @param vo
	 * @return
	 */
	short findSaledNum(LotteryIssueCmsVO vo);

	/**
	 * 获取彩种当前期信息
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017-2-15 上午9:24:38
	 * @param lotteryCategory
	 * @return
	 */
	List<LotteryIssueCmsBO> listCurrentIssue(@Param("lotteryCategory") String lotteryCategory);

	/**
	 * 查询该彩种马上截止的期数
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017-2-16 下午4:26:30
	 * @param lotteryCode
	 * @return
	 */
	LotteryIssueCmsBO getLotteryIssueMonitor(@Param("lotteryCode") int lotteryCode);

	
	
	/**************************** Used to LOTTO ******************************/

	/**
	 * @desc 前端接口：查询单个彩期信息
	 * @author huangb
	 * @date 2017年3月6日
	 * @param lotteryVO
	 *            参数对象
	 * @return 前端接口：查询单个彩期信息
	 */
	IssueBO findSingleFront(LotteryVO lotteryVO);
	/**
	 * 前端接口：查询所有符合条件的彩期信息，默认查所有，可以按条件
	 * @author longguoyou
	 * @date 2017年3月28日
	 * @param lotteryVO
	 * @return
	 */
	List<IssueBO> findMultipleFront(LotteryVO lotteryVO);

	/**
	 * @desc 前端接口：查询最新开奖彩期(即当前期的上一期)
	 * @author huangb
	 * @date 2017年3月6日
	 * @param issueVO
	 *            参数对象
	 * @return 前端接口：查询最新开奖彩期(即当前期的上一期)
	 */
	IssueDrawBO findLatestDrawIssue(LotteryVO lotteryVO);

	/**
	 * @desc 前端接口：查询最近开奖详情列表
	 * @author huangb
	 * @date 2017年3月6日
	 * @param issueVO
	 *            参数对象
	 * @return 前端接口：查询最近开奖详情列表
	 */
	List<IssueDrawBO> findRecentDrawIssue(LotteryVO lotteryVO);
    /**
     * 获取彩期信息用于生成模拟数据
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017年3月8日 下午3:45:08
     * @param lotteryCode
     * @param issue
     * @return
     */
	NewIssueBO findLotteryIssue(@Param("lotteryCode")int lotteryCode, @Param("issueCode")String issueCode);

	/**
	 * 查询当前期下一期彩期新
	 *
	 * @param lotteryVO
	 * @return
	 */
	IssueBO findNextIssue(LotteryVO lotteryVO);
	
	/**
	 * 查询首页开奖公告
	 */
	List<IssueLottBO> findfindHomeDrawLott();
	
	/**
	 * 查询开奖公告上显示的双色球或者大乐透的开奖信息
	 * @return
	 */
	IssueLottBO findNewsHomeDraw();
	
	/**
	 * 查询当天有开奖的彩种
	 * @return
	 */
	List<IssueLottBO> findDrawNameToday();
	
	/**
	 *  查询当前期和之后的预售期组成列表 
	 * @return
	 */
	List<IssueLottJCBO> findIssueByCode(@Param("lotteryCode") int lotteryCode);


	Integer findIssueListByCodeTotal(LottoIssueVO vo);

	/**
	 * 根据彩种查询彩期列表。支持分页查询
	 *
	 * @return
	 */
	List<IssueLottJCBO> findIssueListByCode(LottoIssueVO vo);


	/**
	 * 根据彩种查询后5期的彩期列表。支持分页查询
	 *
	 * @return
	 */
	List<IssueLottJCBO> findAfterFiveIssueListByCode(LottoIssueVO vo);
	
	/**
	 * @desc 前端接口：用户中心-查询低频彩等待出票的官方出票时间段
	 * @author huangb
	 * @date 2017年4月19日
	 * @param lotteryVO
	 *            查询对象
	 * @return 前端接口：用户中心-查询低频彩等待出票的官方出票时间段
	 */
	IssueOfficialTimeBO findNumOfficialTime(LotteryVO lotteryVO);

	/**
	 * @desc 前端接口：用户中心-查询高频彩等待出票的官方出票时间段
	 * @author huangb
	 * @date 2017年4月19日
	 * @param lotteryVO
	 *            查询对象
	 * @return 前端接口：用户中心-查询高频彩等待出票的官方出票时间段
	 */
	IssueOfficialTimeBO findHighOfficialTime(LotteryVO lotteryVO);
	
	/**
	 * @desc 前端接口：用户中心-查询竞技彩等待出票的官方出票时间段
	 * @author huangb
	 * @date 2017年4月19日
	 * @param lotteryVO
	 *            查询对象
	 * @return 前端接口：用户中心-查询竞技彩等待出票的官方出票时间段
	 */
	List<IssueOfficialTimeBO> findSportOfficialTime(LotteryVO lotteryVO);
	
	/**
	 * 查询当前期和上一期信息
	 * @return
	 */
	CurrentAndPreIssueBO findIssueAndPreIssueByCode(@Param("lotteryCode") int lotteryCode);
	/**
	 * 查询当前期和上一期信息列表
	 * @return
	 */
	List<CurrentAndPreIssueBO> findIssueAndPreIssueByCodeList(List<Integer> lotteryCode);
	/**
	 * 查询所有当前期和上一期信息列表
	 * @return
	 */
	List<CurrentAndPreIssueBO> findAllIssueAndPreIssue();
	   /**
     * 修改开奖号码生成遗漏数据
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017年5月12日 上午9:06:46
     */
	void getOmotAll(Map<String, Object> param);
	
	/**
	 * 修改是否最新开奖为否
	 * @param lotteryCode
	 * @return
	 * @date 2017年5月26日下午6:39:58
	 * @author cheng.chen
	 */
	int updIssueLastest(@Param("lotteryCode") Integer lotteryCode);
	/**
	 * 查询截止彩期
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年6月14日 上午10:09:33
	 * @param vo
	 * @return
	 */
	List<String> findCutOffIssueCode(LotteryIssueCmsVO vo);

	IssueLottBO findIssueByParam(@Param("lotteryCode") Integer lotteryCode,@Param("issueCode") String issueCode,@Param("issueLastest") Integer issueLastest);
	
	/**
	 * 查询彩期是不是当前期
	 * @param lotteryCode
	 * @param issueCode
	 * @return
	 */
	Boolean isCurrentIssue(@Param("lotteryCode") Integer lotteryCode,@Param("issueCode") String issueCode);
	
	/**
	 * 根据彩种编码查询所有彩期
	 * @param lotteryCode
	 * @return
	 * @date 2017年9月23日上午11:24:02
	 * @author cheng.chen
	 */
	List<String> queryIssueByLottery(LotteryVO lotteryVO);

	/**
	 * 同步“十四场”的draw_code，issue_lastest两个字段的值到“任选九场”
	 * @param drawCode
	 * @param issueLastest 
	 * @param issueCode
	 * @param lotteryStr
	 */
	void updIssueByLotteryName(@Param("drawCode")String drawCode, @Param("issueLastest")Integer issueLastest, @Param("issueCode")String issueCode, @Param("lotteryIssue")Integer lotteryIssue);
	
	void updateMinIssueCode(@Param("issueCode")String issueCode, @Param("lotteryCode")Integer lotteryCode );
	
}