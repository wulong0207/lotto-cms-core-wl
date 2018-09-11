package com.hhly.cmscore.persistence.sport.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.hhly.cmscore.persistence.sport.po.SportDrawFBPO;
import com.hhly.skeleton.cms.sportmgr.bo.SportFBDataExcelBO;
import com.hhly.skeleton.cms.sportmgr.bo.SportFBLotteryInfoBO;
import com.hhly.skeleton.cms.sportmgr.vo.SMGLotteryParamVO;

public interface SportDrawFBDaoMapper {

    Integer findCountFBData(SMGLotteryParamVO vo);

    List<SportFBLotteryInfoBO> findFBData(SMGLotteryParamVO vo);

    int insert(SportDrawFBPO record);

//    List<SportDrawFBDao> selectByExample(SportDrawFBDaoExample example);

    int updateByPrimaryKey(SportDrawFBPO record);
    
    List<SportFBDataExcelBO> findAllList(SMGLotteryParamVO vo);
    
    @MapKey("systemCode")
    Map<String, SportFBLotteryInfoBO> findFbOrderMatchDetail(SMGLotteryParamVO vo);
    
    /**
     * 查询已审核的赛事数据
     * @return
     */
	List<SportFBLotteryInfoBO> findFBDataOfCheckScore(@Param("lotteryCode") Integer lotteryCode, @Param("matchStatus") Integer matchStatus);
}