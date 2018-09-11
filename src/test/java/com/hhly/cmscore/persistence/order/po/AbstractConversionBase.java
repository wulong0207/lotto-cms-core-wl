package com.hhly.cmscore.persistence.order.po;

import org.springframework.beans.BeanUtils;

/**
 * 
 * @author longguoyou

 * @date 2017年2月5日 下午4:27:40

 * @desc 用于VO、BO、PO之间相同属性赋值，不同属性需重写基类conversionTheOthersProperties方法
 *
 */
abstract public class AbstractConversionBase<T> {
	public void conversionTheSameProperties(Object source, Object  target){
		BeanUtils.copyProperties(source, target);
	}
	/**
	 * 
	 * @author longguoyou
	
	 * @date 2017年2月5日 下午4:54:29
	
	 * @desc 处理属性名称不一致的赋值
	 *
	 * @param target
	 */
	abstract public void conversionTheOthersProperties(T target);
}
