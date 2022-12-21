package com.mono.di.entity;
import com.mono.di.ui.ColorPrinter;
import com.mono.di.entity.Personinfo;
import com.mono.di.ui.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Ex { //generic 인터페이스
    public void Extest1() {

        ColorPrinter printer = new ColorPrinter();

        Personinfo personInfo = new Personinfo();
        personInfo.setPrinter(printer);

        ArrayList<String> namelist = new ArrayList();
        namelist.add("Spring");
        namelist.add("Ioc");
        namelist.add("DI");

        personInfo.setNames(namelist);

        ArrayList<Person> info = new ArrayList<Person>();
        Person p1 = new Person();
        p1.setAge(30);
        p1.setName("power");
        info.add(p1);

        Person p2 = new Person();
        p2.setAge(50);
        p2.setName("abcd");
        info.add(p2);

        personInfo.setPersons(info);

        HashMap<String, Integer> info2 = new HashMap<String, Integer>();
        info2.put("Kim", 10);
        info2.put("Lee", 20);
        info2.put("Ahn", 30);

        personInfo.setAges(info2);

        HashSet<String> email = new HashSet<String>();
        email.add("kor@naver.com");
        email.add("eng@naver.com");
        email.add("eng@naver.com");

        personInfo.setEmails(email);

        Hello h = new Hello();
        h.setPrinter(printer);

    }
}