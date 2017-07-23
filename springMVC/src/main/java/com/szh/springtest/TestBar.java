package com.szh.springtest;

/**
 * @author zhihao.song
 */
public class TestBar implements ITest {
    @Override
    public void perform() {
        System.out.println("bar");
    }
}
