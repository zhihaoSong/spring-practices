package com.szh.redis;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhihaosong on 17-7-18.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LockRedis {
    String key() default "SMS_PLAN_SCAN";

    String value() default "SMS_PLAN_SCAN_VALUE";

    //5分钟
    long expire() default 5 * 1000;
}