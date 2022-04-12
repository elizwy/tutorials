package com.elizwy.javatech.base;

public class CloneTest {
    private static String a = null;
    private static Integer b = null;

    public static void main(String[] args) {
        final CloneTest test = new CloneTest();

        test.clone(null);
        test.clone(test.a);
    }

    private void clone(String... str) {
        System.out.println(str);
        if (str == null) {
            System.out.println("检测到null");
        }

    }
}
