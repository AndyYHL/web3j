package com.hx.eplate.trafficdata.query.theadPoolConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by wuhaochao on 2017/7/25.
 */
@Component
public class AsyncTranscationTask {
    private static final Logger logger = LoggerFactory.getLogger(AsyncTranscationTask.class);

    //myTaskAsynPool即配置线程池的方法名，此处如果不写自定义线程池的方法名，会使用默认的线程池
    @Async("myTaskAsyncPool")
    public void insertTransTask(int i) throws InterruptedException {
        logger.info("TranscationTask" + i + " started.");
        //开始导入交易信息
        String method_BlockByNumber = "eth_getBlockByNumber";
        //批量插入
        //transcationMapper.insertTranscationList(list);
    }

}
