package com.lzh.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lzh
 * create 2019-10-26-16:30
 */

@Component
public class Dog implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Dog(){
        System.out.println("dog construct ...");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("Dog...@PostConstruct...");
    }

    //容器移除之前
    @PreDestroy
    public void detory(){
        System.out.println("Dog...@PreDestroy...");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
