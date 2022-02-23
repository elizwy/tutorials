package com.elizwy.javatech.base;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class VMBean {
    public static void main(String[] args) {
        final RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        final String name = runtimeMXBean.getName();
        System.out.println(name);
    }
}