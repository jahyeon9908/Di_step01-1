package com.mono.di.entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class S2_HelloTest {
    @DisplayName("Container를 사용한 객체주입(Di)")
    @ParameterizedTest
    @ValueSource(strings = {"config1.xml" , "config2.xml" , "config3.xml" , "config3-1.xml" , "config4.xml" , "config5.xml"})
    public void springContainerTest(String resourceFileName){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:" + resourceFileName);
        //ctx란 스프링의 컨테이너==웹 컨테이너==빈 팩토리 를 생성
        //"classpath:" + resourceFileName 경로가 어떻게 되는거냐???
        //classpath : target 안의 classes 안의 파일들
        //ClassPathXmlApplicationContext : ClassPath에 위치한 xml 파일을 읽어 설정 정보를 로딩, root로부터 경로를 지정함 //src를 root로 보고 경로를 적어주면 됨
        //-> ClassPath안의 xml 파일들을 ApplicationContext화 해서 ctx라는 컨테이너에 담음

        String[] beanName = ctx.getBeanDefinitionNames();
        //beamName이라는 이름의 String 배열을 만들어서 ctx 컨테이너에 들어있는 빈들의 이름을 문자열 배열로 받음
        //getBeanDefinitionNames() : 어떤 객체가 스프링 빈으로 등록 됐는지 확인할 때 유용하다
        System.out.println("dddddddddddddddddddddddddddddd");
        //System.out.println(Arrays.toString(beanName)); //[mprinter, cprinter, hello, hello2]
        Arrays.stream(beanName).iterator().forEachRemaining(System.out::println);
        //Arrays.stream(beanName).iterator().forEachRemaining( s -> System.out.println(s));
        /*
        mprinter
        cprinter
        hello
        hello2
         */
        //Arrays.stream(배열명)- 컬렉션
        //iterator()는??
        //forEachRemaining : Iterator의 메소드로 Iterator를 ArrayList로 변환해주며
        //모든 요소가 처리되거나 작업에서 예외가 발생할 때까지 나머지 각 요소에 대해 지정된 작업을 수행하는 함수
        //iterator를 통해 원본인 beanName 배열이 Arrays.stream에 복사되고 forEachRemaining()을 수행한다 그럼 출력할 때마다 stream에 들은 원소가 하나씩 사라짐
        //다 사라지면 다음 작업 넘어감

        System.out.println("dddddddddddddddddddddddddddddd");

        Hello hello = ctx.getBean("hello" , Hello.class);
        //getBean("빈의 이름", 빈의 데이터타입) //빈의 이름은 안 적어도 됨
        //ctx라는 컨테이너에서 해당 bean을 찾아서 hello에 넣겠다
        hello.print("hello...");

       /*
        config5에만 있고 다른 config들에는 없어서 Personinfo p = ctx.getBean( "personInfo", Personinfo.class); 이 문장에서 오류남
        어노테이션을 배우게 될 것이다

        Personinfo p = ctx.getBean( "personInfo", Personinfo.class);
        if(){
            System.out.println("null");
        }else{
            System.out.println( p.getAges());
        }
        */

    }
}