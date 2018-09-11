package com.hhly.cmscore.rabbitmq.provider.impl;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hhly.skeleton.base.util.DateUtil;

import net.sf.json.JSONObject;

/**
 * @desc 发送消息
 * @author jiangwei
 * @date 2017年6月6日
 * @company 益彩网络科技公司
 * @version 1.0
 */
@Service
public class SendMessage {

	@Autowired
	private MQProducerImpl producer;
	/**
	 * 出票失败
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年8月14日 下午5:57:31
	 * @param lotteryCode
	 * @param lotteryIssue
	 */
	public void sendOutTicketFail(Collection<String> orders){
		if(CollectionUtils.isEmpty(orders)){
			return;
		}
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("orderCode", StringUtils.collectionToDelimitedString(orders,","));
        jsonObject.put("createTime", DateUtil.getNow());
        jsonObject.put("status",6);
        producer.sendMessage("orderflow_queue", jsonObject.toString());
	}
	
}
