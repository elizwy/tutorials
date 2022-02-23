package com.elizwy.javatech.base;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemoryOverFlow {
    public static void main(String[] args) {
        List<B> list=new ArrayList<>();
        while (true){
            A a = new A();
            list.add(new B(a));
        }
    }

    static class A{
       String s = UUID.randomUUID().toString();

        public String getS() {
            return s;
        }
    }

    static class B{
        A a;

        public B(A a) {
            this.a = a;
        }
    }
}
