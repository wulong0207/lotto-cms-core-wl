package com.hhly.cmscore.persistence.customer.typehandler;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hhly.skeleton.base.exception.ServiceRuntimeException;

/**
 * @desc    拼接"7中x"
 * @author  Tony Wang
 * @date    2017年8月2日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class UserIssueExcelTypeHandler extends AbstractTypeHandler<String> {


	  @Override
	  public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
		if("recent_record".equalsIgnoreCase(columnName)) {
			try {
				// m_user_issue_info表的recent_record字段有值时才会返回值
				int hit = rs.getInt("recent_record");
				return "7中"+hit;
			} catch (SQLException e) {
				return "7中0";
			}
		}
		throw new ServiceRuntimeException("不支持转化此列"+columnName);
	  }
	}