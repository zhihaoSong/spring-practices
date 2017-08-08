package com.szh.redis.task;


import com.szh.redis.LockRedis;
import freemarker.template.utility.DateUtil;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by zhihaosong on 17-7-28.
 */
@Component("smsScanSendTask")
public class SmsScanSendTask {


    @Scheduled(fixedDelay = 5 * 1000)
    @LockRedis
    public void jobTask() { //每10秒执行一次
        scanSend();
    }

    public void scanSend() {
        System.out.println("scanSend start ..." +
                new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(new Date()));
    }


}
