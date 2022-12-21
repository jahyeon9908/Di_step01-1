package com.mono.di.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;


public class S6_ColleciontDiTest {

    private ApplicationContext context;
    Personinfo personInfo;

    @BeforeEach
    public void before() {
        //IoC 컨테이너를 생성
        //1.ApplicationContext 객체 생성
        context = new ClassPathXmlApplicationContext("classpath:config5.xml"); //메타파일 빈을 생성할 때 참고한다?? 빈은 기본으로 싱글톤타입(처음에 빈을 만들어둔다?) 프로토타입은 새로운 것을 줄 때마다 만든다?
        personInfo= context.getBean(Personinfo.class);

        System.out.println("======================");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);//가진 빈의 종류를 찍어본다


        System.out.println("컨테이너생성");
        System.out.println("Before 객체 : " + this);
        System.out.println("컨테이너 객체 : " + context);
    }

    @Test
    @DisplayName("List Di 테스트")  //이걸로 뭘 알 수 있는 거임?
    public void listDiTest() {

        personInfo.print("HELLO");

        System.out.println("------------------------");

        List<String> list = personInfo.getNames();
        list.forEach(System.out::println);
        //list.forEach(a->System.out.println(a))

        System.out.println("------------------------");

        /* 확장 for */
        for (String value : list) { //우에서 좌방향으로 list에서 하나씩 꺼내서 value에 넣음
            // nmList.accept(value);
            System.out.println(value);
        }

        System.out.println("------------------------");

        /* Iterator */
        Iterator<String> lst = list.iterator(); //Iterator:화살표 처음에는 -1을 가리키고 있고 next연산을 통해 화살표를 옮기고 next연산이 해당 값을 리턴받아줌
        while (lst.hasNext()) { //hasNext는 다음 next가 있는지 true, false로 알아봄
            System.out.println(lst.next());
        }
    }

    @Test
    @DisplayName("Map Di 테스트")
    public void mapDiTest() {

        /* enhenced for */
        Map<String, Integer> ages = personInfo.getAges();
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println("KEY : " + entry.getKey() + ", VALUE : " + entry.getValue());
        }

        System.out.println("------------------------");

        // Iterator가 안되서 set(keyset)을 통해서 iterator를 얻음
        Iterator<String> keys = ages.keySet().iterator();
        //ages라는 map에서는 iterator를 못 쓰니까 keySet을 통해 key 컬럼만 set으로 만들어서 iterator를  쓴다
        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println("key : " + key + ", value : " + ages.get(key));
        }

        System.out.println("------------------------");

        /* lamda */
        ages.forEach((key, value) -> System.out.println("key:" + key + " | value:" + value)); //ages.forEach((key, value)하나의 entry를 꺼냄
        ages.entrySet().forEach(entry -> System.out.println("key:" + entry.getKey() + " | value:" + entry.getValue())); //forEach(Consumer : 값을 소비만 하고 리턴값x)
        ages.keySet().forEach(key -> System.out.println("key : " + key));
        ages.values().forEach(value -> System.out.println("value : " + value)); //이것도 set임?
    }

    @Test
    @DisplayName("Set Di 테스트")
    public void setDiTest() {

        Set<String> hs = personInfo.getEmails();
        Iterator<String> hi = hs.iterator();

        /* lamda method 참조*/
        hs.forEach(System.out::println);

        System.out.println("------------------------");

        /* 중복제거 */
        /* Iterator */
        while (hi.hasNext()) {
            System.out.println(hi.next());
        }

        System.out.println("------------------------");

        /* enhenced for */
        for (String s : hs) {
            System.out.println(s);
        }
    }

    @Test
    @DisplayName("comparable sort Test")
    public void comparableTest() {

        List<Person> persons = personInfo.getPersons();

        System.out.println("-------- before person name sort  ----------------");
        persons.forEach(row -> System.out.println(row.getName() + " : " + row.getAge()));

        /* List 정렬 */
        Collections.sort(persons); //<T extends Comparable<? super T>> //sort의 default는 오름차순 //기준이 뭐임

        System.out.println("-------- after person name sort ----------------");
        persons.forEach(row -> System.out.println(row.getName() + " : " + row.getAge()));

    }
}