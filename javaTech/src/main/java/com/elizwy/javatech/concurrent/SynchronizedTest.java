package com.elizwy.javatech.concurrent;

public class SynchronizedTest {
    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();
        synchronized (test){
            System.out.println("i'm a tester");
        }

    }
}
