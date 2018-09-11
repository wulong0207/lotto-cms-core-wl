package com.hhly.cmscore.cms.remote.service.common;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @desc 线程池
 * @author jiangwei
 * @date 2017-2-15
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class ThreadPool {
    
    public static  final ThreadPoolExecutor THREAD_POOL = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
}
