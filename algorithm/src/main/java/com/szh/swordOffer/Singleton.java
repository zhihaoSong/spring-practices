package com.szh.swordOffer;

/**
 * Created by zhihaosong on 17-7-24.
 * 静态内部类实现的线程安全的单例
 */
public class Singleton {
    private Singleton() {
    }

    private static class SingltonHolder {
        private static final Singleton singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return SingltonHolder.singleton;
    }
}
