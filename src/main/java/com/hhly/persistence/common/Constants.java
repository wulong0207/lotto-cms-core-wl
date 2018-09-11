package com.hhly.persistence.common;

import org.apache.commons.lang.math.NumberUtils;

import com.hhly.persistence.util.PropertiesHandler;

/**
 * 
 * @author jiangwei
 * @Version 1.0
 * @CreatDate 2016-12-15 上午10:22:19
 * @Desc 常量
 */
public class Constants extends com.hhly.skeleton.base.constants.Constants {
	/**
	 * excel导出最大数
	 */
	public static final int EXCEL_NUM;
	
	public static final String EXCEL_ERROR_MSG;
	
	static {
		EXCEL_NUM = NumberUtils.toInt(PropertiesHandler.getConfigValue("excel_export_max_num"));
		EXCEL_ERROR_MSG = "导出错误，一次最多能导出"+ EXCEL_NUM + "条数据";
	}
}
