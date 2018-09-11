package com.hhly.cmscore.persistence.customer.typehandler;

import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.binary.Base64;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.StringUtils;

import com.hhly.skeleton.base.exception.ServiceRuntimeException;

/**
 * @desc    推荐理由的加密、解密
 * @author  Tony Wang
 * @date    2017年8月2日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class OrderIssueTypeHandler extends AbstractTypeHandler<String> {

	  @Override
	  public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
		if("recommend_reason".equalsIgnoreCase(columnName)) {
			try {
				String reason = rs.getString("recommend_reason");
				return StringUtils.hasText(reason) ? new String(Base64.decodeBase64(reason.getBytes("UTF-8"))): reason;
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServiceRuntimeException("======>解密推荐理由时出错："+e.getMessage());
			} 
		}
		throw new ServiceRuntimeException("不支持转化此列"+columnName);
	  }

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
			throws SQLException {
		try {
			String encodeStr = StringUtils.hasText(parameter) ? new String(Base64.encodeBase64(parameter.getBytes("UTF-8"))): parameter;
			ps.setString(i, encodeStr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new ServiceRuntimeException("======>加密推荐理由时出错："+e.getMessage());

		}

	}
	  
}