package com.hhly.persistence.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Bruce Liu
 * @create on: 2016-5-11  下午05:25:04
 * @describe : used it to get/set Properties' value
 */
public class PropertiesHandler {
	private static Properties prop = null;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PropertiesHandler.class);
	
	private static final String SYS_PROPERTIES_PATH = "sys.properties";

	public static String getConfigValue(String propertyName) {
		prop = getPropertiesInstance();
		try {
			if (prop != null) {
				return new String(
						prop.getProperty(propertyName).getBytes("ISO-8859-1"), "UTF-8");
			} else {
				return "";
			}
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage());
		}
		return "";
	}
	

	public static void setConfigValue(String propertyName, String propertyValue) {
		prop = getPropertiesInstance();
		if (prop != null) {
			prop.setProperty(propertyName, propertyValue);
		}
		
	}
	
	/**
	 * @return
	 * 加载系统配置文件
	 */
	private static Properties getPropertiesInstance() {
		if (prop == null) {
			prop = new Properties();
		} else {
			return prop;
		}
		try {
			prop.load(PropertiesHandler.class.getClassLoader().getResourceAsStream(SYS_PROPERTIES_PATH));
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage());
			return null;
		}
		return prop;
	}
	
}
