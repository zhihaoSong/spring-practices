package com.szh.redis;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by zhihaosong on 17-7-18.
 */
@Component
@Aspect
public class LockAspect {

    private static AtomicBoolean atomicBoolean = new AtomicBoolean(true);

    @Around("@annotation(com.szh.redis.LockRedis)")
    public Object distributeLock(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("LockAspect is exec start...." + Thread.currentThread());
        Long start = System.currentTimeMillis();
        Object resultObject = null;

        //确认此注解是用在方法上
        Signature signature = pjp.getSignature();
        if (!(signature instanceof MethodSignature)) {
            System.out.println("LockRedis is method annotation!");
            return resultObject;
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();

        LockRedis lockRedis = targetMethod.getAnnotation(LockRedis.class);
        String key = lockRedis.key();
        String value = lockRedis.value();
        long expire = lockRedis.expire();

        boolean result = atomicBoolean.compareAndSet(false, true);
        if (!result) {
            System.out.println("LockAspect fail get lock key:{} cost:{}:" + key);
            atomicBoolean.getAndSet(false);
            return resultObject;
        }
        resultObject = pjp.proceed(); //调用对应方法执行
        System.out.println("LockAspect success exec end.... ");
        atomicBoolean.getAndSet(true);
        return resultObject;
    }
}