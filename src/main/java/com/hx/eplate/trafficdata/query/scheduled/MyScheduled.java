package com.hx.eplate.trafficdata.query.scheduled;

/**
 * Created by wuhaochao on 2017/7/21.
 */

import com.hx.eplate.trafficdata.query.theadPoolConfig.AsyncTranscationTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 定时任务,每五分钟探测一次区块链中的是否存在最新交易信息
 */
@Component
public class MyScheduled {
    private static final Logger logger = LoggerFactory.getLogger(MyScheduled.class);
    @Autowired
    private AsyncTranscationTask asyncTranscationTask;
    /*每天每5秒执行一次*/
    @Scheduled(cron = "0/5 * * * * ?")
    @Transactional
    public void executeTask2() {
        //获取最新区块编号
        try {
            //批量插入
            //asyncTranscationTask.insertTransTask(i);
            System.out.println("定时任务启动");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
