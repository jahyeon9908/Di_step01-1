package com.mono.di.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class S3_JunitBeforeEachTest {

    private ApplicationContext ctx;

    @BeforeEach

    public void BeforeEachMessage1(){
        ctx = new ClassPathXmlApplicationContext("classpath:config1.xml"); //모두가 공통으로 갖는 속성이 ctx;
        System.out.println("BeforeEach.this : " + this); //this : 현재 클래스(+주소) //this는 동작하는 주체라고 정리하자 //현재의 클래스의 주소라면 출력할 때마다 같은 주소여야 하는 거 아님?//메소드의 주소를 말하는건가?
        System.out.println("BeforeEachMessage context : " + ctx);
    }
    
    @Test
    @DisplayName("springContainerTest의 BeforeEach this확인")
    public void springContainerTest1(){

        System.out.println("springContainerTest1.this : " + this);
        System.out.println("springContainerTest1.ctx : " + ctx); //여기에서의 ctx와 밑에서의 ctx의 주소는 다르다 //왜지?? test때마다 다른 컨테이너를 쓴다는건가??
        Hello hello = ctx.getBean("hello" , Hello.class);
        hello.print("hello...");
    }

    @Test
    @DisplayName("springContainerTest2의 BeforeEach this확인")
    public void springContainerTest2(){

        System.out.println("springContainerTest2.this : " + this);
        System.out.println("springContainerTest2.ctx : " + ctx);
        Hello hello = ctx.getBean("hello" , Hello.class);
        hello.print("hello...");

    }
}