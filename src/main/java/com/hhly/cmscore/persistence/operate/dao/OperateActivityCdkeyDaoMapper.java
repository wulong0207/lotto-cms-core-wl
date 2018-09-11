package com.hhly.cmscore.persistence.operate.dao;

import com.hhly.cmscore.persistence.operate.po.OperateActivityCdkeyPO;
import com.hhly.skeleton.cms.operatemgr.bo.OperateActivityCdkeyBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateActivityCdkeyVO;
import com.hhly.skeleton.user.bo.UserInfoBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperateActivityCdkeyDaoMapper {

    /**
     * 查询cdk数据
     * @param vo
     * @return
     */
    List<OperateActivityCdkeyBO> findCdkeyList(OperateActivityCdkeyVO vo);

    /**
     * 查询cdk的总记录
     * @param vo
     * @return
     */
    int findTotal(OperateActivityCdkeyVO vo);

    /**
     * 查询有效cdk数量
     * @param vo
     * @return
     */
    int findValidCdkcount(OperateActivityCdkeyVO vo);

    /**
     * 查询账户信息
     * @param userId
     * @return
     */
    UserInfoBO findMemberInfo(@Param("userId") Integer userId);

    /**
     * 批量写入cdkey
     *
     * @param poList poList
     */
    int addBatchInsert(List<OperateActivityCdkeyPO> poList);

    /**
     * 新增
     * @param po
     * @return
     */
    int insert(OperateActivityCdkeyPO po);

    /**
     * 删除
     *
     * @param num
     * @return
     */
    int deleteCdkey(int num);
    
    int findCountByCdkey(@Param("cdkey") String cdkey);
    
    List<String> findExistCdkeys(@Param("cdkeys") List<String> cdkeys);
}