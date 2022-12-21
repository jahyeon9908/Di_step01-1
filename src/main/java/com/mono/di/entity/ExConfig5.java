package com.mono.di.entity;

import com.mono.di.ui.ColorPrinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ExConfig5 {

  public void exTest1() {
    ColorPrinter printer = new ColorPrinter();

    Personinfo personinfo = new Personinfo();
    personinfo.setPrinter(printer);
    personinfo.setNames(new ArrayList<String>() {{
      add("Spring");
      add("Ioc");
      add("DI");
    }});
    personinfo.setPersons(
        new ArrayList<Person>() {{ //익명클래스를 쓰려면 {{ }} 두번씩 써준다
          add(new Person() {{
            setAge(30);
            setName("power");
          }});
          add(new Person() {{
            setAge(50);
            setName("abcd");
          }});
          add(new Person() {{
            setAge(24);
            setName("next");
          }});
        }});
    personinfo.setAges(new HashMap<String, Integer>() {{
      put("Kim", 10);
      put("Lee", 20);
      put("Ahn", 30);
    }});
    personinfo.setEmails(new HashSet<String>() {{
      add("kor@naver.com");
      add("eng@naver.com");
      add("eng@naver.com");
    }});
  }
}
