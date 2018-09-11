package com.hhly.cmscore.persistence.customer.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * @desc    抽象TypeHandler
 * @author  Tony Wang
 * @date    2017年8月2日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public abstract class AbstractTypeHandler<T> extends BaseTypeHandler<T> {
	  
	public abstract T getNullableResult(ResultSet rs, String columnName) throws SQLException;

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
		throw new UnsupportedOperationException("AbstractTypeHandler不支持setNonNullParameter()");
	}

	@Override
	public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		throw new UnsupportedOperationException(
				"AbstractTypeHandler不支持getNullableResult(ResultSet rs, int columnIndex)");
	}

	@Override
	public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		throw new UnsupportedOperationException(
				"AbstractTypeHandler不支持getNullableResult(CallableStatement cs, int columnIndex)");
	}
}