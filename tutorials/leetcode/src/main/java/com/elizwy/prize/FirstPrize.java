package com.elizwy.prize;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FirstPrize {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            get();
        }

    }

    private static void get() {
        List<Integer> rebBalls=new ArrayList();
        List<Integer> blueBalls=new ArrayList();
        for(int i=1; i<=33; i++){
            rebBalls.add(i);
        }
        for(int i=1; i<=16; i++){
            blueBalls.add(i);
        }

        List result=new ArrayList();
        for(int i=1;i<=6; i++){
            Random random = new Random();
            int index = random.nextInt(rebBalls.size());
            Integer number = rebBalls.get(index);
            result.add(number);
            rebBalls.remove(number);
        }

        result.stream().sorted().forEach(i-> System.out.print(i+" "));

        Random random = new Random();
        int index = random.nextInt(blueBalls.size());
        System.out.print(blueBalls.get(index)+" ");
        System.out.println();
    }
}
