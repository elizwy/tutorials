package com.elizwy.javatech.base;

import lombok.Synchronized;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ThreadLocalTest {
    static Object o = new Object();
    public static void main(String[] args) throws InterruptedException {
        final ThreadLocal<String> threadLocal = new ThreadLocal<>();
        for (int i = 0; i < 30; i++) {
            synchronized (o){
                new Thread(()->{
                    threadLocal.set(UUID.randomUUID().toString());
                    final String result = threadLocal.get();
                    System.out.println(result);
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();


            }
        }
    }
}
