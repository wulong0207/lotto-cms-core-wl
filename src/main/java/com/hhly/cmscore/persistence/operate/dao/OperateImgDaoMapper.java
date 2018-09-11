package com.hhly.cmscore.persistence.operate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.skeleton.cms.operatemgr.bo.OperateImgBO;
import com.hhly.skeleton.cms.operatemgr.vo.OperateImgVO;

/**
 * 
 * @desc 图片管理
 * @author jiangwei
 * @date 2017年4月10日
 * @company 益彩网络科技公司
 * @version 1.0
 */
/**
 * @desc
 * @author jiangwei
 * @date 2017年4月11日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public interface OperateImgDaoMapper {
	/**
	 * 图片总数
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年4月10日 上午10:19:41
	 * @param vo
	 * @return
	 */
	int findTotal(OperateImgVO vo);
	
	/**
	 * 分页数据
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年4月10日 上午10:19:55
	 * @param vo
	 * @return
	 */
	List<OperateImgBO> findList(OperateImgVO vo);
    /**
     * 添加
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017年4月11日 上午10:38:36
     * @param vos
     */
	void addOperateImg(@Param("images")List<OperateImgVO> vos);
	/**
	 * 修改
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年4月11日 上午10:38:44
	 * @param vo
	 * @return
	 */
	int updOperateImg(OperateImgVO vo);
    /**
     * 查询信息
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017年4月11日 上午10:38:58
     * @param id
     * @return
     */
	List<OperateImgBO> listOperateImgInfo(@Param("ids")List<String> id);
	/**
	 * 删除
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年4月11日 上午10:39:09
	 * @param id
	 * @return
	 */
	int delOperateImg(@Param("ids")List<String> id);
	/**
	 * 移动
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年4月11日 上午10:39:20
	 * @param asList
	 * @param vo
	 * @return
	 */
	int updOperateImgMove(@Param("ids")List<String> id,@Param("groupid")Integer groupid,@Param("modifyBy")String modifyBy);
    /**
     * 查询图片信息
     * @author jiangwei
     * @Version 1.0
     * @CreatDate 2017年4月14日 下午12:16:44
     * @param vo
     * @return
     */
	OperateImgBO getOperateImg(OperateImgVO vo);
	/**
	 * 通过图片名查询存在图片
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年7月25日 下午4:06:06
	 * @param images
	 * @return
	 */
	List<String> findImageByName(@Param("images")List<String> images);
   
}