package com.mono.di.ui;

public class ColorPrinter implements Printer{

    @Override
    public void print(String msg) {
        System.out.println("--- ColorPrint Start ---");
        System.out.println(msg);
        System.out.println("--- ColorPrint end ---");
    }
}
