package com.mono.di.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {

    @Test
    @DisplayName("프레임워크 사용없는 객체 생성 테스트")
    public void manualTest1(){
        Printer printer = new BluePrinter();
        /*Hello hello = new Hello(printer,"Blue");
        hello.print("aaa");*/
        printer.print("Hello");
    }

    @Test
    @DisplayName("다형성을 이횽한 프린트")
    public void manualTest2(){
        Collection<Printer> printers = new LinkedHashSet<>();
        printers.add(new BluePrinter());
        printers.add(new ColorPrinter());
        printers.add(new MonoPrinter());
        printers.forEach(p -> p.print("Hello"));

    }
}