package com.elizwy.javatech.base;

import java.util.UUID;

public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        final ThreadLocal<String> threadLocal = new ThreadLocal<>();
        final ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
        final ThreadLocal<String> threadLocal3 = new ThreadLocal<>();

        new Thread(() -> {
            threadLocal.set(UUID.randomUUID().toString());
            threadLocal2.set(UUID.randomUUID().toString());
            threadLocal3.set(UUID.randomUUID().toString());
            final String result = threadLocal.get();
            System.out.println(result);
            final String result2 = threadLocal2.get();
            System.out.println(result2);
            final String result3 = threadLocal3.get();
            System.out.println(result3);
            threadLocal2.remove();
        }).start();


    }
}
