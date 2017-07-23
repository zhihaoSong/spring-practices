package com.szh.demo;

import org.springframework.stereotype.Component;

@Component
public class Foo implements IFoo {
    @Override
    public String output(String val){
        return "Foo " + val;
    }
    public void run(){
        System.out.println("Hello Foo");
    }
}
