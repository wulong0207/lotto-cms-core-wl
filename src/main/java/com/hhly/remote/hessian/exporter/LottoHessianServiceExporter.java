/**
 * @desc    Hessian 加入Auth权限管理 
 * @author  scott
 * @date    2017-02-21
 * @company 益彩网络科技
 * @version V1.0
 */
package com.hhly.remote.hessian.exporter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.security.crypto.codec.Base64;

import com.hhly.skeleton.base.constants.SymbolConstants;
import com.hhly.skeleton.base.util.PropertyUtil;


public class LottoHessianServiceExporter extends HessianServiceExporter {
	
	private Logger log = LogManager.getLogger(LottoHessianServiceExporter.class);
	
	// 设置权限校验值
	private static final String AUTH;
	
	static{
		//计算hessian的校验值
		String user = PropertyUtil.getPropertyValue("sys_dynamic.properties","hessian_username");
		String password = PropertyUtil.getPropertyValue("sys_dynamic.properties","hessian_password");
		String str = user + SymbolConstants.COLON +password;
		AUTH = "Basic " + new String(Base64.encode(str.getBytes()));
	}
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("hessian get Authorization !");
		String auth = request.getHeader("Authorization") ;
		if(!Objects.equals(auth, AUTH)){
			log.info("Authorization fail");
			return  ;
		}
		super.handleRequest(request, response);
	}

}
