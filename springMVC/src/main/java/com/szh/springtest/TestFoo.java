package com.szh.springtest;

/**
 * @author zhihao.song
 */
public class TestFoo implements ITest {
    @Override
    public void perform() {
        System.out.println("foo");
    }
}
