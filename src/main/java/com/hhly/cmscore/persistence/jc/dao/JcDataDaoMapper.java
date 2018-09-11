package com.hhly.cmscore.persistence.jc.dao;

import com.hhly.skeleton.lotto.base.sport.bo.*;
import com.hhly.skeleton.lotto.base.sport.vo.JcParamVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auth lgs on
 * @date 2017/2/22.
 * @desc 竞彩显示持久层
 * @compay 益彩网络科技有限公司
 * @vsersion 1.0
 */
public interface JcDataDaoMapper {

    List<JczqDaoBO> findJczqData(JcParamVO vo);

    Integer findJcSaleEndDataTotal(JcParamVO vo);

    List<JczqDaoBO> findJczqSaleEndData(JcParamVO vo);

    List<SportDataFbWDFBO> findJczqWdfSpData(@Param("sportAgainstInfoId") Long sportAgainstInfoId);

    List<MatchDataBO> findMatchTotal(JcParamVO vo);

    JczqOrderBO findJczqOrderDataBySystemCode(JcParamVO vo);

    List<JclqDaoBO> findJclqData(JcParamVO vo);

    List<JclqDaoBO> findJclqSaleEndData(JcParamVO vo);

    JclqOrderBO findJclqOrderDataBySystemCode(JcParamVO vo);

    List<SportDataBbWFBO> findJclqWfSpData(@Param("sportAgainstInfoId") Long sportAgainstInfoId);

    List<SportDataBbWSBO> findJclqWSSpData(@Param("sportAgainstInfoId") Long sportAgainstInfoId);

    List<SportDataBbSSSBO> findJclqSssSpData(@Param("sportAgainstInfoId") Long sportAgainstInfoId);

    List<JcOldDataBO> findJcOldData(@Param("issueCode") String issueCode, @Param("lotteryCode") String lotteryCode);

    List<JcOldDataSpBO> findJcOldDataSp(@Param("issueCode") String issueCode, @Param("lotteryCode") String lotteryCode);

    List<JczqOrderBO> findJczqOrderDataByIssueCode(JcParamVO vo);

    List<BjDaoBO> findBjData(JcParamVO vo);

    BjDaoBO findBjDataBySystemCode(JcParamVO vo);

    List<BjDaoBO> findSaleEndTimeBjData(JcParamVO vo);

    BjDaoBO findBjDataByBjNum(@Param("lotteryCode") String lotteryCode, @Param("bjNum") String bjNum);

    List<MatchDataBO> findBjMatch(JcParamVO vo);

    JczqDaoBO findFootBallSpById(@Param("id") Long id);
}