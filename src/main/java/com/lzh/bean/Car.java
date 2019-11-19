package com.lzh.bean;

import org.springframework.stereotype.Component;

/**
 * @author lzh
 * create 2019-10-26-11:20
 */
@Component
public class Car {

    public Car(){
        System.out.println("car constructor...");
    }

    public void init(){
        System.out.println("car ... init ...");
    }

    public void detory(){
        System.out.println("car ... destory ...");
    }
}
