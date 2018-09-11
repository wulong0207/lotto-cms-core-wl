package com.hhly.cmscore.persistence.sys.dao;

import com.hhly.skeleton.cms.sysmgr.vo.PayBankSegmentVO;

import java.util.List;

/**
 * @author Tony Wang
 * @version 1.0
 * @desc
 * @date 2018/1/12 14:30
 * @company 益彩网络科技有限公司
 */
public interface PayBankSegmentDaoMapper {
    int count(PayBankSegmentVO vo);

    List<PayBankSegmentVO> find(PayBankSegmentVO vo);

    int merge(PayBankSegmentVO vo);
}
