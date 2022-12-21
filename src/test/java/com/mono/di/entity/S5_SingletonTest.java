package com.mono.di.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

class S5_SingletonTest { //왜 prototype부터 출력되지? --랜덤임 테스트는 서로 관련없음(단위 테스트) 순차적으로 돌려지는 게 아님
    private ApplicationContext ctx;

    @BeforeEach
    public void before(){
        System.out.println("1");
        ctx = new ClassPathXmlApplicationContext("classpath:config4.xml");
        System.out.println("2");
        String[] beanName = ctx.getBeanDefinitionNames();
        Arrays.stream(beanName).iterator().forEachRemaining(System.out::println);
        System.out.println("4");
    }

    @DisplayName("SingleTon 객체 테스트")
    @Test
    public void singleTonTest(){
        Hello hello1 = ctx.getBean("hello" , Hello.class);
        System.out.println("5");
        Hello hello2 = ctx.getBean("hello" , Hello.class);

        Assertions.assertSame(hello1, hello2);//동일 객체인지 //객체의 주소값을 비교
        //System.out.println("hello1 : " + hello1 + "\n hello2 : " + hello2);
        System.out.println("hello1 : " + System.identityHashCode(hello1) + "\n hello2 : " + System.identityHashCode(hello2));
    }

    @DisplayName("Prototype 객체 테스트")
    @Test
    public void prototypeTest(){

        Hello hello1 = ctx.getBean("hello" , Hello.class);
        System.out.println("6");
        Hello hello3 = ctx.getBean("protoHello" , Hello.class); //prototype은 처음에 setter 안 거치고 getBean할 때 거침
        System.out.println("7");
        Hello hello4 = ctx.getBean("protoHello" , Hello.class);

        System.out.println("hello1 : "+System.identityHashCode(hello1));
        Assertions.assertNotSame(hello3,hello4);
        System.out.println("hello3 : " + System.identityHashCode(hello3) + "\n hello4 : " + System.identityHashCode(hello4));
    }

}