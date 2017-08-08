package com.szh.redis.task;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhihaosong on 17-8-3.
 */
public class SmsThreadFactory implements ThreadFactory {

    private AtomicInteger counter = new AtomicInteger(0);
    private String prefix = "smsSend";

    public SmsThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, prefix + "-" + counter.getAndIncrement());
    }
}
