package com.hhly.cmscore.cms.remote.service.impl;

import com.hhly.cmscore.cms.remote.service.ISportBallMgrService;
import com.hhly.cmscore.persistence.sport.dao.*;
import com.hhly.cmscore.persistence.sport.po.*;
import com.hhly.persistence.util.StringUtil;
import com.hhly.skeleton.base.bo.PagingBO;
import com.hhly.skeleton.base.common.LotteryEnum;
import com.hhly.skeleton.base.common.LotteryEnum.Lottery;
import com.hhly.skeleton.base.common.SportEnum;
import com.hhly.skeleton.base.constants.Constants;
import com.hhly.skeleton.base.constants.SymbolConstants;
import com.hhly.skeleton.base.page.IPageService;
import com.hhly.skeleton.base.page.ISimplePage;
import com.hhly.skeleton.base.util.ObjectUtil;
import com.hhly.skeleton.cms.base.vo.StringVO;
import com.hhly.skeleton.cms.sportmgr.bo.*;
import com.hhly.skeleton.cms.sportmgr.vo.*;
import com.hhly.skeleton.lotto.base.sport.vo.FBDataVO;
import com.hhly.skeleton.lotto.base.sport.vo.OldDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by lgs on 2016/12/28.
 * 竞彩球类Service实现类
 */
@Service("sportBallMgrService")
public class SportBallMgrServiceImpl implements ISportBallMgrService{

    private static final Short NOT_LET_SCORE_FLAG = 1; //不让分标识值

    private static final Short LET_SCORE_FLAG = 2;//让分标识值

    private static final Short NOT_LET_NUM_FLAG = 1; //不让分标识值

    private static final Short LET_NUM_FLAG = 2;//让分标识值
    /**
     * 全场赔率
     */
    private static final String FULL_SP = "1";
    /**
     * 半场赔率
     */
    @SuppressWarnings("unused")
    private static final String HALF_SP = "0";

    @Autowired
    private SportDrawBBDaoMapper sportDrawBBDaoMapper;

    @Autowired
    private SportDataBbSSSDaoMapper sportDataBbSSSDaoMapper;

    @Autowired
    private SportDataBbWFDaoMapper sportDataBbWFDaoMapper;

    @Autowired
    private SportDataBbWSDaoMapper sportDataBbWSDaoMapper;

    @Autowired
    private SportDrawFBDaoMapper sportDrawFBDaoMapper;

    @Autowired
    private SportDataFbGoalDaoMapper sportDataFbGoalDaoMapper;

    @Autowired
    private SportDataFbHfWDFDaoMapper sportDataFbHfWDFDaoMapper;

    @Autowired
    private SportDataFbScoreDaoMapper sportDataFbScoreDaoMapper;

    @Autowired
    private SportDataFbWDFDaoMapper sportDataFbWDFDaoMapper;

    @Autowired
    private SportStatusFBDaoMapper sportStatusFBDaoMapper;

	// @Autowired
	// private SportStatusWFDaoMapper sportStatusWFDaoMapper;

    @Autowired
    private SportDrawWFDaoMapper sportDrawWFDaoMapper;

    @Autowired
    private SportDataSfWFDaoMapper sportDataSfWFDaoMapper;

    @Autowired
    private SportDrawOldInfoDaoMapper drawOldInfoDaoMapper;

    @Autowired
    private SportMatchInfoDaoMapper sportMatchInfoDaoMapper;

    @Autowired
    private SportTeamInfoDaoMapper sportTeamInfoDaoMapper;

    @Autowired
    private SportDataFbOldDaoMapper sportDataFbOldDaoMapper;

    @Autowired
    private SportStatusBBDaoMapper sportStatusBBDaoMapper;
    
    @Autowired
    private SportDataBjGoalDaoMapper sportDataBjGoalDaoMapper;

    @Autowired
    private SportDataBjHfWDFDaoMapper sportDataBjHfWDFDaoMapper;

    @Autowired
    private SportDataBjScoreDaoMapper sportDataBjScoreDaoMapper;

    @Autowired
    private SportDataBjUDSDDaoMapper sportDataBjUDSDDaoMapper;

    @Autowired
    private SportDataBjWDFDaoMapper sportDataBjWDFDaoMapper;

    @Autowired
    private SportDrawBJDaoMapper sportDrawBJDaoMapper;

    @Autowired
    private SportStatusBJDaoMapper sportStatusBJDaoMapper;

    @Autowired
    private SportAgainstInfoDaoMapper sportAgainstInfoDaoMapper;
    
    @Autowired
    private SportMatchSourceInfoDaoMapper sportMatchSourceInfoDaoMapper;
    
    @Autowired
    private SportTeamSourceInfoDaoMapper sportTeamSourceInfoDaoMapper;
    
    @Autowired
	private IPageService pageService;
    
	@Value("${before_file_url}")
	private String beforeFileUrl;

    @Override
    public PagingBO<SportOldLotteryInfoBO> findOldLotteryInfo(final SMGLotteryParamVO vo) {
        
        PagingBO<SportOldLotteryInfoBO> bo = pageService.getPageData(vo,new ISimplePage<SportOldLotteryInfoBO>() {
			@Override
			public int getTotal() {
				return drawOldInfoDaoMapper.countByParamVO(vo);
			}
			@Override
			public List<SportOldLotteryInfoBO> getData() {
				List<SportOldLotteryInfoBO> infos = drawOldInfoDaoMapper.selectByParamVO(vo);
				if(!CollectionUtils.isEmpty(infos)) {
					for(SportOldLotteryInfoBO info : infos) {
						if(StringUtils.hasText(info.getHomeLogoUrl())) {
							info.setHomeLogoUrl(beforeFileUrl + info.getHomeLogoUrl());
						}
						if(StringUtils.hasText(info.getGuestLogoUrl())) {
							info.setGuestLogoUrl(beforeFileUrl + info.getGuestLogoUrl());
						}
						if(StringUtils.hasText(info.getLogoUrl())) {
							info.setLogoUrl(beforeFileUrl + info.getLogoUrl());
						}
						if(StringUtils.hasText(info.getMatchInfoUrl())) {
							info.setMatchInfoUrl(beforeFileUrl + info.getMatchInfoUrl());
						}
					}
				}
				return infos;
			}
		});
        
        for (SportOldLotteryInfoBO old : bo.getData()) {
            old.setWrong(setWrong(old));
        }
        return bo;
    }


    @Override
    public Map<String, Object> findOldSp(Long againstId) {
        List<SportDataFBOldBO> fullFBBos = new ArrayList<>();
        List<SportDataFBOldBO> halfFBBos = new ArrayList<>();
        List<SportDataFBOldBO> sportDataFBOldBOs = sportDataFbOldDaoMapper.findByAgainstInfoId(againstId);
        for (SportDataFBOldBO fbBo : sportDataFBOldBOs) {
            if (fbBo.getSpType().equals(Short.valueOf(FULL_SP))) {
                halfFBBos.add(fbBo);
            } else {
                fullFBBos.add(fbBo);
            }
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("fullFBBos", fullFBBos);
        resultMap.put("halfFBBos", halfFBBos);
        return resultMap;
    }

    @Override
    public int saveOldData(OldDataVO vo) {
        sportMatchInfoDaoMapper.updateById(new SportMatchInfoPO(vo));
        sportTeamInfoDaoMapper.updateById(new SportTeamInfoPO(vo.getHomeTeamPrimaryId(),null,vo.getHomeTeamDataUrl(),null,vo.getHomeTeamShortName(),vo.getHomeTeamOrder(),vo.getHomeLogoUrl(),vo.getModifyTime(),vo.getModifyBy(),vo.getCreateBy(),null,vo.getModifyTime(),null));
        sportTeamInfoDaoMapper.updateById(new SportTeamInfoPO(vo.getGuestTeamPrimaryId(),null,vo.getGuestTeamDataUrl(),null,vo.getGuestTeamShortName(),vo.getGuestTeamOrder(),vo.getGuestLogoUrl(),vo.getModifyTime(),vo.getModifyBy(),vo.getCreateBy(),null,vo.getModifyTime(),null));
        drawOldInfoDaoMapper.updateByPrimaryKey(new SportDrawOldInfoPO(vo));
        return sportAgainstInfoDaoMapper.updateByPrimaryKey(new SportAgainstInfoPO(vo));
    }

    @Override
    public PagingBO<SportFBLotteryInfoBO> findFBData(final SMGLotteryParamVO vo) {
        vo.setLotteryCode(Lottery.FB.getName());
        PagingBO<SportFBLotteryInfoBO> resultBO = pageService.getPageData(vo,new ISimplePage<SportFBLotteryInfoBO>() {
			@Override
			public int getTotal() {
				return sportDrawFBDaoMapper.findCountFBData(vo);
			}
			@Override
			public List<SportFBLotteryInfoBO> getData() {
				List<SportFBLotteryInfoBO> infos = sportDrawFBDaoMapper.findFBData(vo);
				if(!CollectionUtils.isEmpty(infos)) {
					for(SportFBLotteryInfoBO info : infos) {
						if(StringUtils.hasText(info.getHomeLogoUrl())) {
							info.setHomeLogoImg(beforeFileUrl + info.getHomeLogoUrl());
						}
						if(StringUtils.hasText(info.getGuestLogoUrl())) {
							info.setGuestLogoImg(beforeFileUrl + info.getGuestLogoUrl());
						}
						if(StringUtils.hasText(info.getLogoUrl()) && !info.getLogoUrl().contains("http")) {
							info.setLogoImg(beforeFileUrl + info.getLogoUrl());
						}
					}
				}
				return infos;
			}
		});
        
        for(SportFBLotteryInfoBO bo : resultBO.getData()){

            //获取未开售玩法
            String notSalePay ="";
            if(bo.getStatusWdf() != null && bo.getStatusWdf().equals(Constants.STOP_SALE)){
                notSalePay = getNotSalePay(notSalePay, Constants.WDF);
            }

            if(bo.getStatusLetWdf() != null && bo.getStatusLetWdf().equals(Constants.STOP_SALE)){
                notSalePay = getNotSalePay(notSalePay,Constants.LET_WDF);
            }

            if(bo.getStatusScore() != null && bo.getStatusScore().equals(Constants.STOP_SALE)){
                notSalePay = getNotSalePay(notSalePay,Constants.SCORE);
            }

            if(bo.getStatusGoal() != null && bo.getStatusGoal().equals(Constants.STOP_SALE)){
                notSalePay = getNotSalePay(notSalePay,Constants.GOAL);
            }

            if(bo.getStatusHfWdf() != null && bo.getStatusHfWdf().equals(Constants.STOP_SALE)){
                notSalePay = getNotSalePay(notSalePay,Constants.HF_WDF);
            }

            bo.setNotSalePay(notSalePay);
            bo.setWrong(setWrong(bo));
        }
        return resultBO;
    }


    @Override
    public Map<String, Object> findFBSp(Long againstId) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sportDataFbGoalBOs", sportDataFbGoalDaoMapper.findByAgainstInfoId(againstId));
        resultMap.put("sportDataFbHfWDFBOs", sportDataFbHfWDFDaoMapper.findByAgainstInfoId(againstId));
        resultMap.put("sportDataFbScoreBOs", sportDataFbScoreDaoMapper.findByAgainstInfoId(againstId));
        List<SportDataFbWDFBO> sportDataFbWDFBOs = sportDataFbWDFDaoMapper.findByAgainstInfoId(againstId);
        List<SportDataFbWDFBO> letNums = new ArrayList<>();
        List<SportDataFbWDFBO> notLetNums = new ArrayList<>();
        for (SportDataFbWDFBO fbWDFBos : sportDataFbWDFBOs) {
            Short letNumFlag = fbWDFBos.getSpType();
            if (letNumFlag == NOT_LET_NUM_FLAG) {
                notLetNums.add(fbWDFBos);
            } else if (letNumFlag == LET_NUM_FLAG) {
                letNums.add(fbWDFBos);
            }
        }
        resultMap.put("sportLetNumDataFbWDFBOs", letNums);
        resultMap.put("sportNotLetNumDataFbWDFBOs", notLetNums);
        return resultMap;
    }

    @Override
    public int saveFBData(FBDataVO vo) {
        sportMatchInfoDaoMapper.updateById(new SportMatchInfoPO(vo));
        sportTeamInfoDaoMapper.updateById(new SportTeamInfoPO(vo.getHomeTeamPrimaryId(),null,vo.getHomeTeamDataUrl(),null,vo.getHomeTeamShortName(),vo.getHomeTeamOrder(),vo.getHomeLogoUrl(),vo.getModifyTime(),vo.getModifyBy(),vo.getCreateBy(),null,vo.getModifyTime(),null));
        sportTeamInfoDaoMapper.updateById(new SportTeamInfoPO(vo.getGuestTeamPrimaryId(),null,vo.getGuestTeamDataUrl(),null,vo.getGuestTeamShortName(),vo.getGuestTeamOrder(),vo.getGuestLogoUrl(),vo.getModifyTime(),vo.getModifyBy(),vo.getCreateBy(),null,vo.getModifyTime(),null));
        sportDrawFBDaoMapper.updateByPrimaryKey(new SportDrawFBPO(vo));
        sportAgainstInfoDaoMapper.updateByPrimaryKey(new SportAgainstInfoPO(vo));
        int result = sportStatusFBDaoMapper.updateByPrimaryKey(new SportStatusFBPO(vo));
        saveOldDrawDataFromFb(vo);//同步更新老足彩彩果
        return result;
    }

    @Override
    public PagingBO<SportBJLotteryInfoBO> findBJData(final SMGLotteryParamVO vo) {
        vo.setLotteryCode(Lottery.BJDC.getName());
        PagingBO<SportBJLotteryInfoBO> resultBO = pageService.getPageData(vo,new ISimplePage<SportBJLotteryInfoBO>() {
			@Override
			public int getTotal() {
				return sportDrawBJDaoMapper.findBJDataCount(vo);
			}
			@Override
			public List<SportBJLotteryInfoBO> getData() {
				List<SportBJLotteryInfoBO> infos = sportDrawBJDaoMapper.findBJData(vo);
				if(!CollectionUtils.isEmpty(infos)) {
					for(SportBJLotteryInfoBO info : infos) {
						if(StringUtils.hasText(info.getHomeLogoUrl())) {
							info.setHomeLogoImg(beforeFileUrl + info.getHomeLogoUrl());
						}
						if(StringUtils.hasText(info.getGuestLogoUrl())) {
							info.setGuestLogoImg(beforeFileUrl + info.getGuestLogoUrl());
						}
						if(StringUtils.hasText(info.getLogoUrl()) && !info.getLogoUrl().contains("http")) {
							info.setLogoImg(beforeFileUrl + info.getLogoUrl());
						}
					}
				}
				return infos;
			}
		});
        
        for (SportBJLotteryInfoBO bo : resultBO.getData()) {

            //获取未开售玩法
            String notSalePay ="";
            if(!ObjectUtil.isBlank(bo.getStatusUdSd()) && bo.getStatusUdSd().equals(Constants.BJ_STOP_SALE)){
                notSalePay = getNotSalePay(notSalePay, Constants.BJ_UDSD);
            }

            if(!ObjectUtil.isBlank(bo.getStatusLetWdf()) && bo.getStatusLetWdf().equals(Constants.BJ_STOP_SALE)){
                notSalePay = getNotSalePay(notSalePay,Constants.BJ_LET_WDF);
            }

            if(!ObjectUtil.isBlank(bo.getStatusScore()) && bo.getStatusScore().equals(Constants.BJ_STOP_SALE)){
                notSalePay = getNotSalePay(notSalePay,Constants.BJ_SCORE);
            }

            if(!ObjectUtil.isBlank(bo.getStatusGoal()) && bo.getStatusGoal().equals(Constants.BJ_STOP_SALE)){
                notSalePay = getNotSalePay(notSalePay,Constants.BJ_GOAL);
            }

            if(!ObjectUtil.isBlank(bo.getStatusHfWdf()) && bo.getStatusHfWdf().equals(Constants.BJ_STOP_SALE)){
                notSalePay = getNotSalePay(notSalePay,Constants.BJ_HF_WDF);
            }

            bo.setNotSalePay(notSalePay);
            bo.setWrong(setWrong(bo));
        }
        
        return resultBO;
    }


    @Override
    public Map<String, Object> findBJSp(Long againstId) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sportDataBjGoalBOs", sportDataBjGoalDaoMapper.findByAgainstInfoId(againstId));
        resultMap.put("sportDataBjHfWDFBOs", sportDataBjHfWDFDaoMapper.findByAgainstInfoId(againstId));
        resultMap.put("sportDataBJScoreBOs", sportDataBjScoreDaoMapper.findByAgainstInfoId(againstId));
        resultMap.put("sportDataBJWDFBOs", sportDataBjWDFDaoMapper.findByAgainstInfoId(againstId));
        resultMap.put("sportDataBjUDSDBOs", sportDataBjUDSDDaoMapper.findByAgainstInfoId(againstId));
        return resultMap;
    }

    @Override
    public int saveBJData(BJDataVO vo) {
        sportMatchInfoDaoMapper.updateById(new SportMatchInfoPO(vo));
        sportTeamInfoDaoMapper.updateById(new SportTeamInfoPO(vo.getHomeTeamPrimaryId(),null,vo.getHomeTeamDataUrl(),null,vo.getHomeTeamShortName(),vo.getHomeTeamOrder(),vo.getHomeLogoUrl(),vo.getModifyTime(),vo.getModifyBy(),vo.getCreateBy(),null,vo.getModifyTime(),null));
        sportTeamInfoDaoMapper.updateById(new SportTeamInfoPO(vo.getGuestTeamPrimaryId(),null,vo.getGuestTeamDataUrl(),null,vo.getGuestTeamShortName(),vo.getGuestTeamOrder(),vo.getGuestLogoUrl(),vo.getModifyTime(),vo.getModifyBy(),vo.getCreateBy(),null,vo.getModifyTime(),null));
        sportDrawBJDaoMapper.updateByPrimaryKey(new SportDrawBJPO(vo));
        sportAgainstInfoDaoMapper.updateByPrimaryKey(new SportAgainstInfoPO(vo));
        return sportStatusBJDaoMapper.updateByPrimaryKey(new SportStatusBJPO(vo));
    }

    @Override
    public PagingBO<SportBBLotteryInfoBO> findBBData(final SMGLotteryParamVO vo) {
        vo.setLotteryCode(Lottery.BB.getName());
        PagingBO<SportBBLotteryInfoBO> resultBO = pageService.getPageData(vo,new ISimplePage<SportBBLotteryInfoBO>() {
			@Override
			public int getTotal() {
				return sportDrawBBDaoMapper.findBBDataCount(vo);
			}
			@Override
			public List<SportBBLotteryInfoBO> getData() {
				List<SportBBLotteryInfoBO> infos = sportDrawBBDaoMapper.findBBData(vo);
				if(!CollectionUtils.isEmpty(infos)) {
					for(SportBBLotteryInfoBO info : infos) {
						if(StringUtils.hasText(info.getHomeLogoUrl())) {
							info.setHomeLogoImg(beforeFileUrl + info.getHomeLogoUrl());
						}
						if(StringUtils.hasText(info.getGuestLogoUrl())) {
							info.setGuestLogoImg(beforeFileUrl + info.getGuestLogoUrl());
						}
						if(StringUtils.hasText(info.getLogoUrl()) && !info.getLogoUrl().contains("http")) {
							info.setLogoImg(beforeFileUrl + info.getLogoUrl());
						}
					}
				}
				return infos;
			}
		});
        
        for (SportBBLotteryInfoBO bo : resultBO.getData()) {

            //获取未开售玩法
            String notSalePay ="";
            if (!ObjectUtil.isBlank(bo.getStatusBigSmall()) && bo.getStatusBigSmall().equals(Constants.STOP_SALE)) {
                notSalePay = getNotSalePay(notSalePay, Constants.BB_BIG_SMALL);
            }

            if (!ObjectUtil.isBlank(bo.getStatusLetWf()) && bo.getStatusLetWf().equals(Constants.STOP_SALE)) {
                notSalePay = getNotSalePay(notSalePay,Constants.BB_LET_WF);
            }

            if (!ObjectUtil.isBlank(bo.getStatusScoreWf()) && bo.getStatusScoreWf().equals(Constants.STOP_SALE)) {
                notSalePay = getNotSalePay(notSalePay,Constants.BB_SCORE_WF);
            }

            if (!ObjectUtil.isBlank(bo.getStatusWf()) && bo.getStatusWf().equals(Constants.STOP_SALE)) {
                notSalePay = getNotSalePay(notSalePay,Constants.BB_WF);
            }

            bo.setNotSalePay(notSalePay);
            bo.setWrong(setWrong(bo));
        }
        
        return resultBO;
    }


    @Override
    public Map<String, Object> findBBSp(Long againstId) {
        Map<String, Object> resultMap = new HashMap<>();

        List<SportDataBbWFBO> wfBos = sportDataBbWFDaoMapper.findByAgainstInfoId(againstId);
        List<SportDataBbWFBO> letBos = new ArrayList<>();
        List<SportDataBbWFBO> notLetBos = new ArrayList<>();
        for (SportDataBbWFBO wfBo : wfBos) {
            if (wfBo.getSpType().equals(NOT_LET_SCORE_FLAG)) {
                notLetBos.add(wfBo);
            } else if (wfBo.getSpType().equals(LET_SCORE_FLAG)) {
                letBos.add(wfBo);
            }
        }
        resultMap.put("sportDataBbSSSBOs", sportDataBbSSSDaoMapper.findByAgainstInfoId(againstId));
        resultMap.put("sportDataBbWSBOs", sportDataBbWSDaoMapper.findByAgainstInfoId(againstId));
        resultMap.put("notLetSportDataBbWFBOs", notLetBos);
        resultMap.put("letSportDataBbWFBOs", letBos);
        return resultMap;
    }

    @Override
    public int saveBBData(BBDataVO vo) {
        sportMatchInfoDaoMapper.updateById(new SportMatchInfoPO(vo));
        sportTeamInfoDaoMapper.updateById(new SportTeamInfoPO(vo.getHomeTeamPrimaryId(),null,vo.getHomeTeamDataUrl(),null,vo.getHomeTeamShortName(),vo.getHomeTeamOrder(),vo.getHomeLogoUrl(),vo.getModifyTime(),vo.getModifyBy(),vo.getCreateBy(),null,vo.getModifyTime(),null));
        sportTeamInfoDaoMapper.updateById(new SportTeamInfoPO(vo.getGuestTeamPrimaryId(),null,vo.getGuestTeamDataUrl(),null,vo.getGuestTeamShortName(),vo.getGuestTeamOrder(),vo.getGuestLogoUrl(),vo.getModifyTime(),vo.getModifyBy(),vo.getCreateBy(),null,vo.getModifyTime(),null));
        sportAgainstInfoDaoMapper.updateByPrimaryKey(new SportAgainstInfoPO(vo));
        sportDrawBBDaoMapper.updateByPrimaryKey(new SportDrawBBPO(vo));
        return sportStatusBBDaoMapper.updateByPrimaryKey(new SportStatusBBPO(vo));
    }

    @Override
    public PagingBO<SportWFLotteryInfoBO> findWFData(final SMGLotteryParamVO vo) {
        vo.setLotteryCode(Lottery.SFGG.getName());
        PagingBO<SportWFLotteryInfoBO> resultBO = pageService.getPageData(vo,new ISimplePage<SportWFLotteryInfoBO>() {
			@Override
			public int getTotal() {
				return sportDrawWFDaoMapper.findCountWFData(vo);
			}
			@Override
			public List<SportWFLotteryInfoBO> getData() {
				List<SportWFLotteryInfoBO> infos = sportDrawWFDaoMapper.findWFData(vo);
				if(!CollectionUtils.isEmpty(infos)) {
					for(SportWFLotteryInfoBO info : infos) {
						if(StringUtils.hasText(info.getHomeLogoUrl())) {
							info.setHomeLogoImg(beforeFileUrl + info.getHomeLogoUrl());
						}
						if(StringUtils.hasText(info.getGuestLogoUrl())) {
							info.setGuestLogoImg(beforeFileUrl + info.getGuestLogoUrl());
						}
						if(StringUtils.hasText(info.getLogoUrl()) && !info.getLogoUrl().contains("http")) {
							info.setLogoImg(beforeFileUrl + info.getLogoUrl());
						}
					}
				}
				return infos;
			}
		});
        
        for(SportWFLotteryInfoBO bo : resultBO.getData()){
            bo.setWrong(setWrong(bo));
        }
        return resultBO;
    }


    @Override
    public Map<String, Object> findWFSp(Long againstId) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sportDataSfWFBOs", sportDataSfWFDaoMapper.findByAgainstInfoId(againstId));
        return resultMap;
    }

    @Override
    public int saveWFData(WFDataVO vo) {
        sportMatchInfoDaoMapper.updateById(new SportMatchInfoPO(vo));
        sportTeamInfoDaoMapper.updateById(new SportTeamInfoPO(vo.getHomeTeamPrimaryId(),null,vo.getHomeTeamDataUrl(),null,vo.getHomeTeamShortName(),vo.getHomeTeamOrder(),vo.getHomeLogoUrl(),vo.getModifyTime(),vo.getModifyBy(),vo.getCreateBy(),null,vo.getModifyTime(),null));
        sportTeamInfoDaoMapper.updateById(new SportTeamInfoPO(vo.getGuestTeamPrimaryId(),null,vo.getGuestTeamDataUrl(),null,vo.getGuestTeamShortName(),vo.getGuestTeamOrder(),vo.getGuestLogoUrl(),vo.getModifyTime(),vo.getModifyBy(),vo.getCreateBy(),null,vo.getModifyTime(),null));
        sportAgainstInfoDaoMapper.updateByPrimaryKey(new SportAgainstInfoPO(vo));
        sportDrawWFDaoMapper.updateByPrimaryKey(new SportDrawWFPO(vo));
        return sportStatusBJDaoMapper.updateByPrimaryKey(new SportStatusBJPO(vo));
    }

    public String getNotSalePay(String notSalePay , String value){
        if(ObjectUtil.isBlank(notSalePay)){
            notSalePay = value;
        }else{
            notSalePay += (SymbolConstants.COMMA+value);
        }

        return notSalePay;
    }

    /***
     * 设置其他数问题
     * @param bo cans
     */
    private String setWrong(SportFBBaseBO bo){
        StringBuilder wrong = new StringBuilder("");
        if(bo == null){
            return null;
        }
        if(StringUtil.isEmpty(bo.getAnalysisUrl())){
            wrong.append("赛事分析url").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getColor())){
            wrong.append("赛事颜色").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getMatchInfoUrl())){
            wrong.append("赛事详细url").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getOfficialId())){
            wrong.append("官方ID").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getStadium())){
            wrong.append("场馆").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getWeather())){
            wrong.append("天气").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getMatchDataUrl())){
            wrong.append("赛事数据url").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getMatchShortName())){
            wrong.append("赛事简称").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getLogoUrl())){
            wrong.append("赛事LOGO").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getHomeTeamDataUrl())){
            wrong.append("主队数据分析url").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getHomeTeamShortName())){
            wrong.append("主队简称").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getHomeTeamOrder())){
            wrong.append("主队排名").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getHomeLogoUrl())){
            wrong.append("主队LOGO").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getGuestTeamDataUrl())){
            wrong.append("客队数据分析url").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getGuestTeamShortName())){
            wrong.append("客队简称").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getGuestTeamOrder())){
            wrong.append("客队排名").append(SymbolConstants.COMMA);
        }

        if(StringUtil.isEmpty(bo.getGuestLogoUrl())){
            wrong.append( "客队LOGO").append(SymbolConstants.COMMA);
        }

        return wrong.toString();
    }

	@Override 
	public List<SportDataFbOldExcelBo> findOldFbExcelList(SMGLotteryParamVO vo) {
		
		int num=drawOldInfoDaoMapper.countByParamVO(vo);
		Assert.isTrue(num <= com.hhly.persistence.common.Constants.EXCEL_NUM,com.hhly.persistence.common.Constants.EXCEL_ERROR_MSG);
		List<SportDataFbOldExcelBo> list=drawOldInfoDaoMapper.findAllList(vo);
		return list;
	}


	@Override
	public List<SportFBDataExcelBO> findFbExcelList(SMGLotteryParamVO vo) {
		
		int num=sportDrawFBDaoMapper.findCountFBData(vo);
		Assert.isTrue(num <= com.hhly.persistence.common.Constants.EXCEL_NUM,com.hhly.persistence.common.Constants.EXCEL_ERROR_MSG);
		List<SportFBDataExcelBO> list=sportDrawFBDaoMapper.findAllList(vo);
		return list;
	}


	@Override
	public List<SportBBDataExcelBO> findBbExcelList(SMGLotteryParamVO vo) {
		
		int num=sportDrawBBDaoMapper.findBBDataCount(vo);
		Assert.isTrue(num <= com.hhly.persistence.common.Constants.EXCEL_NUM,com.hhly.persistence.common.Constants.EXCEL_ERROR_MSG);
		List<SportBBDataExcelBO> list=sportDrawBBDaoMapper.findAllList(vo);
		return list;
	}


	@Override
	public List<SportBJDataExcelBO> findBjExcelList(SMGLotteryParamVO vo) {
		
		int num=sportDrawBJDaoMapper.findBJDataCount(vo);
		Assert.isTrue(num <= com.hhly.persistence.common.Constants.EXCEL_NUM,com.hhly.persistence.common.Constants.EXCEL_ERROR_MSG);
		List<SportBJDataExcelBO> list=sportDrawBJDaoMapper.findAllList(vo);
		return list;
	}


	@Override
	public List<SportWFDataExcelBO> findWfExcelList(SMGLotteryParamVO vo) {
		
		int num=sportDrawWFDaoMapper.findCountWFData(vo);
		Assert.isTrue(num <= com.hhly.persistence.common.Constants.EXCEL_NUM,com.hhly.persistence.common.Constants.EXCEL_ERROR_MSG);
		List<SportWFDataExcelBO> list=sportDrawWFDaoMapper.findAllList(vo);
		return list;
	}


	@Override
	public int updCheckScore(String lotteryCode, String drawTable, String modifyBy) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("lotteryCode", lotteryCode);
		param.put("drawTable", drawTable);
		param.put("modifyBy", modifyBy);
		int result = sportAgainstInfoDaoMapper.updCheckScore(param);
		//竞足审核后同步比分到老足彩
		if(String.valueOf(LotteryEnum.Lottery.FB.getName()).equals(lotteryCode) && result > 0) {
			saveOldDrawDataFormCheckScore(modifyBy);
		}
		return result;
	}
	
	@Override
	public int updSportAgainstInfo(SportDataBaseVO vo){
		return sportAgainstInfoDaoMapper.updateByPrimaryKey(new SportAgainstInfoPO(vo));
	}


	@Override
	public List<SportOldLotteryInfoBO> findOldOrderMatchDetail(SMGLotteryParamVO vo) {
		return drawOldInfoDaoMapper.findOldOrderMatchDetail(vo);
	}


	@Override
	public Map<String, SportFBLotteryInfoBO> findFbOrderMatchDetail(SMGLotteryParamVO vo) {
		return sportDrawFBDaoMapper.findFbOrderMatchDetail(vo);
	}


	@Override
	public Map<String, SportBBLotteryInfoBO> findBbOrderMatchDetail(SMGLotteryParamVO vo) {
		return sportDrawBBDaoMapper.findBbOrderMatchDetail(vo);
	}

	@Override
	public Map<String, SportBJLotteryInfoBO> findBjOrderMatchDetail(SMGLotteryParamVO vo) {
		return sportDrawBJDaoMapper.findBjOrderMatchDetail(vo);
	}

	@Override
	public Map<String, SportWFLotteryInfoBO> findWfOrderMatchDetail(SMGLotteryParamVO vo) {
		return sportDrawWFDaoMapper.findWfOrderMatchDetail(vo);
	}


	@Override
	public List<SportMatchInfoBO> findMatchLikeList(SportMatchInfoVO sportMatchInfoVO) {
		return sportMatchInfoDaoMapper.findLikeList(sportMatchInfoVO);
	}

	@Override
	public PagingBO<SportMatchInfoBO> findMatchList(final SportMatchInfoVO vo) {
		return pageService.getPageData(vo, new ISimplePage<SportMatchInfoBO>() {

			@Override
			public int getTotal() {
				return sportMatchInfoDaoMapper.findTotal(vo);
			}

			@Override
			public List<SportMatchInfoBO> getData() {
				List<SportMatchInfoBO> list = sportMatchInfoDaoMapper.findList(vo);
				for (SportMatchInfoBO sportMatchInfoBO : list) {
					if(StringUtils.hasText(sportMatchInfoBO.getLogoUrl()) && !sportMatchInfoBO.getLogoUrl().contains("http")) {
						sportMatchInfoBO.setLogoImg(beforeFileUrl + sportMatchInfoBO.getLogoUrl());
					}					
				}
				return list;
			}

		});
	}

	@Override
	public int insertMatchInfo(SportMatchInfoVO vo) {
		try {
			String union = DigestUtils.md5DigestAsHex((vo.getMatchFullName() + vo.getMatchType()).getBytes("UTF-8"));
			vo.setMd5Value(union);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sportMatchInfoDaoMapper.insert(new SportMatchInfoPO(vo));
	}

	@Override
	public int updateMatchInfo(SportMatchInfoVO vo) {
		try {
			String union = DigestUtils.md5DigestAsHex((vo.getMatchFullName() + vo.getMatchType()).getBytes("UTF-8"));
			vo.setMd5Value(union);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return sportMatchInfoDaoMapper.updateById(new SportMatchInfoPO(vo));
	}

	@Override
	public int deleteBatchMatchInfo(StringVO vo) {
		List<String> ids = Arrays.asList(vo.getStr().split(SymbolConstants.UNDERLINE));
		return sportMatchInfoDaoMapper.deleteBatch(ids);
	}
	

	@Override
	public PagingBO<SportMatchSourceInfoBO> findMatchSourceList(final SportMatchSourceInfoVO vo) {
		return pageService.getPageData(vo, new ISimplePage<SportMatchSourceInfoBO>() {

			@Override
			public int getTotal() {
				return sportMatchSourceInfoDaoMapper.findTotal(vo);
			}

			@Override
			public List<SportMatchSourceInfoBO> getData() {
				return sportMatchSourceInfoDaoMapper.findList(vo);
			}
			
		});
	}
	
	@Override
	public int updateMatchSourceInfo(SportMatchSourceInfoVO vo) {
		return sportMatchSourceInfoDaoMapper.updateById(new SportMatchSourceInfoPO(vo));
	}	


	@Override
	public int removeMatchBind(Integer id) {
		return sportMatchSourceInfoDaoMapper.removeBind(id);
	}

	@Override
	public void deleteBatchMatchSource(StringVO vo) {
		List<String> ids = Arrays.asList(vo.getStr().split(SymbolConstants.UNDERLINE));
		sportMatchSourceInfoDaoMapper.deleteBatch(ids);
	}

	@Override
	public List<SportTeamInfoBO> findTeamLikeList(SportTeamInfoVO sportTeamInfoVO) {
		return sportTeamInfoDaoMapper.findLikeList(sportTeamInfoVO);
	}
	
	@Override
	public PagingBO<SportTeamInfoBO> findTeamList(final SportTeamInfoVO vo) {
		return pageService.getPageData(vo, new ISimplePage<SportTeamInfoBO>() {

			@Override
			public int getTotal() {
				return sportTeamInfoDaoMapper.findTotal(vo);
			}

			@Override
			public List<SportTeamInfoBO> getData() {
				List<SportTeamInfoBO> list = sportTeamInfoDaoMapper.findList(vo);
				for (SportTeamInfoBO sportTeamInfoBO : list) {
					if(StringUtils.hasText(sportTeamInfoBO.getLogoUrl()) && !sportTeamInfoBO.getLogoUrl().contains("http")) {
						sportTeamInfoBO.setLogoImg(beforeFileUrl + sportTeamInfoBO.getLogoUrl());
					}					
				}
				return list;
			}
		});
	}

	@Override
	public int insertTeamInfo(SportTeamInfoVO vo) {
		try {
			String union = DigestUtils.md5DigestAsHex((vo.getTeamFullName() + vo.getTeamType()).getBytes("UTF-8"));
			vo.setMd5Value(union);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return sportTeamInfoDaoMapper.insert(new SportTeamInfoPO(vo));
	}

	@Override
	public int updateTeamInfo(SportTeamInfoVO vo) {
		try {
			String union = DigestUtils.md5DigestAsHex((vo.getTeamFullName() + vo.getTeamType()).getBytes("UTF-8"));
			vo.setMd5Value(union);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return sportTeamInfoDaoMapper.updateById(new SportTeamInfoPO(vo));
	}

	@Override
	public int deleteBatchTeamInfo(StringVO vo) {
		List<String> ids = Arrays.asList(vo.getStr().split(SymbolConstants.UNDERLINE));
		return sportTeamInfoDaoMapper.deleteBatch(ids);
	}


	@Override
	public PagingBO<SportTeamSourceInfoBO> findTeamSourceList(final SportTeamSourceInfoVO vo) {
		return pageService.getPageData(vo, new ISimplePage<SportTeamSourceInfoBO>() {

			@Override
			public int getTotal() {
				return sportTeamSourceInfoDaoMapper.findTotal(vo);
			}

			@Override
			public List<SportTeamSourceInfoBO> getData() {
				return sportTeamSourceInfoDaoMapper.findList(vo);
			}
		});
	}


	@Override
	public int updateTeamSourceInfo(SportTeamSourceInfoVO vo) {
		return sportTeamSourceInfoDaoMapper.updateById(new SportTeamSourceInfoPO(vo));
	}


	@Override
	public int removeTeamBind(Integer id) {
		return sportTeamSourceInfoDaoMapper.removeBind(id);
	}
	

	@Override
	public void deleteBatchTeamSource(StringVO vo) {
		List<String> ids = Arrays.asList(vo.getStr().split(SymbolConstants.UNDERLINE));
		sportTeamSourceInfoDaoMapper.deleteBatch(ids);
	}	

    @Override
    public PagingBO<SportAgainstInfoBO> pageGj(SMGLotteryParamVO vo) {
        return pageService.getPageData(vo, new ISimplePage<SportAgainstInfoBO>() {
            @Override
            public int getTotal() {
                return sportAgainstInfoDaoMapper.count(vo);
            }
            @Override
            public List<SportAgainstInfoBO> getData() {
                return sportAgainstInfoDaoMapper.findSportAgainstInfoCms(vo);
            }
        });
    }

    @Override
    public int updateSportAgainstInfo(SportDataBaseVO vo) {
	    Objects.requireNonNull(vo.getAgainstId(),"更新时对阵id不能为空");
        return sportAgainstInfoDaoMapper.updateByPrimaryKey(new SportAgainstInfoPO(vo));
    }
    
    //审核时同步比分到老足彩
    private void saveOldDrawDataFormCheckScore(String modifyBy) {
		List<SportFBLotteryInfoBO> fbDataList = sportDrawFBDaoMapper.findFBDataOfCheckScore(LotteryEnum.Lottery.FB.getName(),
				SportEnum.JcMatchStatusEnum.CHECK.getCode());
		if (ObjectUtil.isBlank(fbDataList)) {
			return;
		}
		fbDataList.forEach(fbData -> {
			FBDataVO vo = new FBDataVO();
			vo.setAgainstId(fbData.getAgainstId());
			vo.setOfficialId(fbData.getOfficialId());
			vo.setMatchStatus(fbData.getMatchStatus() == null ? null : fbData.getMatchStatus().toString());
			vo.setFullScore(fbData.getFullScore());
			vo.setHalfScore(fbData.getHalfScore());
			vo.setFullSpf(fbData.getFullSpf());
			vo.setHfWdf(fbData.getHfWdf());
			vo.setGoalNum(fbData.getGoalNum());
			vo.setModifyBy(modifyBy);
			vo.setModifyTime(new Date());
			saveOldDrawDataFromFb(vo);
		});
    }
    
    //保存竞彩足球有比分时同步保存老足彩
    private void saveOldDrawDataFromFb(FBDataVO vo){
    	if(ObjectUtil.isBlank(vo.getOfficialId()) || ObjectUtil.isBlank(vo.getMatchStatus())) {
    		return;
    	}
    	int matchStatus = Integer.valueOf(vo.getMatchStatus()).intValue();
    	int oldMatchStatus = 0;
		if (matchStatus == SportEnum.JcMatchStatusEnum.CHECK.getCode() || matchStatus == SportEnum.JcMatchStatusEnum.RUN_LOTTERY.getCode()
				|| matchStatus == SportEnum.JcMatchStatusEnum.ALLOT_LOTTERY.getCode()) {
			//已审核，已开奖，已派奖-->已完场
			if(!ObjectUtil.isBlank(vo.getFullScore())) {
				oldMatchStatus = SportEnum.JcMatchStatusEnum.OLD_END.getCode();
			}
		} else if (matchStatus == SportEnum.JcMatchStatusEnum.DELAY.getCode()) {
			oldMatchStatus = SportEnum.JcMatchStatusEnum.OLD_DELAY.getCode();
		} else if (matchStatus == SportEnum.JcMatchStatusEnum.CANCEL.getCode()) {
			oldMatchStatus = SportEnum.JcMatchStatusEnum.OLD_CANCEL.getCode();
		} else {
			return;
		}
    	SMGLotteryParamVO paramVO = new SMGLotteryParamVO();
		paramVO.setLotteryCodeList(Arrays.asList(LotteryEnum.Lottery.SFC.getName(), LotteryEnum.Lottery.ZC_NINE.getName(),
				LotteryEnum.Lottery.ZC6.getName(), LotteryEnum.Lottery.JQ4.getName()));
		paramVO.setOfficialId(vo.getOfficialId());
		List<SportOldLotteryInfoBO> oldLotteryInfoBOList = drawOldInfoDaoMapper.findDrawInfoByParamVO(paramVO);
		if(ObjectUtil.isBlank(oldLotteryInfoBOList)) {
			return;
		}
		final int newOldMatchStatus = oldMatchStatus;
		oldLotteryInfoBOList.forEach(oldLotteryInfoBO->{
			OldDataVO oldDataVO = new OldDataVO();
			oldDataVO.setAgainstId(oldLotteryInfoBO.getAgainstId());
			oldDataVO.setDrawOldInfoId(oldLotteryInfoBO.getDrawOldInfoId());
			oldDataVO.setHalfScore(vo.getHalfScore());
			oldDataVO.setFullScore(vo.getFullScore());
			oldDataVO.setSixHfWdf(vo.getHfWdf());
			oldDataVO.setFourteenWdf(vo.getFullSpf() == null ? null : vo.getFullSpf().toString());
			oldDataVO.setFourGoal(vo.getGoalNum() == null ? null : vo.getGoalNum().toString());
			oldDataVO.setModifyBy(vo.getModifyBy());
			oldDataVO.setModifyTime(vo.getModifyTime());
			drawOldInfoDaoMapper.updateByPrimaryKey(new SportDrawOldInfoPO(oldDataVO));
			if (newOldMatchStatus != 0) {
				oldDataVO.setMatchStatus(String.valueOf(newOldMatchStatus));
				sportAgainstInfoDaoMapper.updateByPrimaryKey(new SportAgainstInfoPO(oldDataVO));
			}
		});
    }

}
