package com.elizwy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;


// 198
public class Rob {
    public static void main(String[] args) {
        int[] array= {3, 5, 6, 8, 9, 1, 2, 4, 6, 2, 6, 8};
        System.out.println(maxArray(array));
    }

    private static int maxArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
           
            return array[0];
        }
        if (array.length == 2) {
            return Math.max(array[0],array[1]);
        }
        if(array.length == 3){
            return Math.max(array[0]+array[2],array[1]);
        }
        if(array.length == 4){
            return Math.max(Math.max(array[0]+array[2],array[1]+array[3]),array[0]+array[3]);
        }
        return Math.max(array[0] + maxArray(Arrays.copyOfRange(array,2,array.length)), array[1] + maxArray(Arrays.copyOfRange(array,3,array.length)));
    }
}
