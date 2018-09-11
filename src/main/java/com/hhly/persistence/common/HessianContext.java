package com.hhly.persistence.common;

import javax.servlet.ServletRequest;

/**
 * 
 * @author jiangwei
 * @Version 1.0
 * @CreatDate 2016-11-16 上午10:03:46
 * @Desc 保存request
 */
public class HessianContext {
    private ServletRequest _request;  
    private static final ThreadLocal<HessianContext> _localContext   
                                  = new ThreadLocal<HessianContext>() {  
        @Override  
        public HessianContext initialValue() {  
            return new HessianContext();  
        }  
    };  
  
    private HessianContext() {  
    }  
  
    public static void setRequest(ServletRequest request) {  
        _localContext.get()._request = request;  
    }  
  
    public static ServletRequest getRequest() {  
        return _localContext.get()._request;  
    }  
  
    public static void clear() {  
        _localContext.get()._request = null;  
    } 
}
