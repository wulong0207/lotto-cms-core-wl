package com.hhly.cmscore.cms.remote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhly.cmscore.cms.remote.service.IRedisMgrService;
import com.hhly.persistence.util.RedisUtil;

@Service("redisMgrService")
public class RedisMgrServiceImpl implements IRedisMgrService{
	@Autowired
    private RedisUtil objectRedisUtil;
	
	@Override
	public void delCacheList(List<String> cacheList, Boolean flag) {
		
		for(String key : cacheList){
			if(flag)
				key +="*";
			objectRedisUtil.delKeys(key);			
		}					
	}	
}
