package com.elizwy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Fib {
    private Map<Long,Long> map=new HashMap();
    private Map<Long,Long> map2=new HashMap();
    public static void main(String[] args) {
        Fib fib = new Fib();
        long start = System.currentTimeMillis();
        long result=fib.fib1(42);
        System.out.println("cost time:"+(System.currentTimeMillis()-start));
        System.out.println("result: "+result);


        long start2 = System.currentTimeMillis();
        long result2=fib.fib2(42);
        System.out.println("cost time:"+(System.currentTimeMillis()-start2));
        System.out.println("result: "+result2);

        long start3 = System.currentTimeMillis();
        long result3=fib.fib2(42);
        System.out.println("cost time:"+(System.currentTimeMillis()-start3));
        System.out.println("result: "+result3);
    }


    public long fib1(int n){
        if(n==0 || n ==1 ){
            return n;
        }
        return fib1(n-1) + fib1(n-2);
    }

//    记忆化搜索，自上而下解决问题, int -> long 很耗时
    public long fib2(long n){
        if(n==0 || n ==1 ){
            return n;
        }
        if(map.get(n)!=null){
            return map.get(n);
        }
        long result= fib2(n-1) + fib2(n-2);
        map.put(Long.valueOf(n),result);
        return result;
    }
//    动态规划，从下至上解决问题
    public long fib3(long n){
        if(n==0 || n ==1 ){
            return n;
        }
        for(long i=2; i<=n; i++){
            map2.put(i, map2.get(n-1)+map2.get(n-2));
        }
        return map2.get(n);
    }

}
