package com.hhly.cmscore.persistence.customerservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.skeleton.cms.customerservice.bo.MUserMessageBO;
import com.hhly.skeleton.cms.customerservice.vo.MUserMessageVO;

public interface MUserMessageDaoMapper {
	
    int findTotal(MUserMessageVO vo);

    List<MUserMessageBO> find(MUserMessageVO vo);
    
    void updateStatus(@Param("id") Integer id,@Param("sendStatus") Integer sendStatus);
    /**
     * 清理账号当天信息发送次数
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2018年1月11日 下午5:30:01
     * @param account
     */
	void updateCleanMessage(@Param("account")String account);
    /**
     * 获取当天发送信息次数
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2018年1月11日 下午5:45:03
     * @param startDate
     * @param endDate
     * @param account
     * @return
     */
	int findSendCount(@Param("startDate")String startDate,@Param("endDate") String endDate,@Param("account") String account);

}