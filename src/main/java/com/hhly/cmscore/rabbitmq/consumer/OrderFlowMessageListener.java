package com.hhly.cmscore.rabbitmq.consumer;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSONObject;
import com.hhly.skeleton.base.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;


/**
 * 消息监听者
 *
 * @author yuanshangbing
 * @create 2017/5/22 17:06
 */
@Component("orderFlowMessageListener")
public class OrderFlowMessageListener implements MessageListener {
	private Logger logger = LoggerFactory.getLogger(OrderFlowMessageListener.class);


    @Override
    public void onMessage(Message message) {
        try {
        	String msg = new String(message.getBody(),"UTF-8");
			Map<String, Object> result1 = JsonUtil.json2Map(msg);
			System.out.println(result1);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
    }
    
    

}
