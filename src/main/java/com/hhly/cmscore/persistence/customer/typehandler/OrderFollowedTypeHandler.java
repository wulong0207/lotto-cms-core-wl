package com.hhly.cmscore.persistence.customer.typehandler;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hhly.skeleton.base.exception.ServiceRuntimeException;
import com.hhly.skeleton.base.util.MathUtil;

/**
 * @desc    计算派发奖金：税后金额-推单人提成-平台提成
 * @author  Tony Wang
 * @date    2017年8月2日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class OrderFollowedTypeHandler extends AbstractTypeHandler<Double> {

	  @Override
	  public Double getNullableResult(ResultSet rs, String columnName) throws SQLException {
		if("send_amount".equalsIgnoreCase(columnName)) {
			try {
				double sendAmount = MathUtil.sub(rs.getDouble("aft_bonus"), rs.getDouble("commission_amount"));
				return sendAmount;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ServiceRuntimeException("======>转换派发奖金时出错："+e.getMessage());
			}
		}
		throw new ServiceRuntimeException("不支持转化此列"+columnName);
	  }
	}