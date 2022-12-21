package com.mono.di.entity;

import com.mono.di.ui.Printer;

public class Hello {

    private Printer printer;
    private String name;

    public Hello() {
    }

    public Hello(Printer printer, String name) {
        this.printer = printer;
        this.name = name;
        System.out.println("생성자 인젝션??");
    }

    public void print(String message){
//        System.out.println(this.name);
    if (this.name == null) //this는 동작하는 클래스// 지금 이메소드 안에서 동작하는
        printer.print(message);
    else
        printer.print(String.format("Message : %s %s" , name , message));
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
        System.out.println("Hello 클래스의 Setter 인젝션224??");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "printer=" + printer +
                ", name='" + name + '\'' +
                '}';
    }
}
