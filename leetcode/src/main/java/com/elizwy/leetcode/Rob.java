package com.elizwy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


// 198
public class Rob {
    public static Map<Integer, Integer> memory = new HashMap();

    public static void main(String[] args) {
        int[] array = {3, 5, 6, 8, 9, 1, 2, 4, 6, 2, 6, 8};
        System.out.println(maxArray(array));

        long start = System.currentTimeMillis();
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " result: " + maxArray02(array, 0));
        System.out.println(memory);

        System.out.println(maxArray03(array));

    }

    /**
     * 暴力求解 + 记忆化搜索
     *
     * @return
     */
    private static int maxArray02(int[] array, int index) {
        if (index >= array.length) {
            return 0;
        }
        int result = 0;
        for (int i = index; i < array.length; i++) {
            int temp = array[i] + (memory.get(i + 2) != null ? memory.get(i + 2) : maxArray02(array, i + 2));
            result = Math.max(result, temp);
            memory.put(i, temp);
        }
        return result;
    }

    /**
     * 动态规划
     *
     * @param array
     * @return
     */

    public static int maxArray03(int[] array) {
        int[] result = new int[array.length];
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[1];
        }
        if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }

        result[0] = array[0];
        result[1] = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            result[i] = Math.max(array[i] + result[i - 2], result[i - 1]);
        }
        return result[array.length - 1];
    }

    private static int maxArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }
        if (array.length == 3) {
            return Math.max(array[0] + array[2], array[1]);
        }
        if (array.length == 4) {
            return Math.max(Math.max(array[0] + array[2], array[1] + array[3]), array[0] + array[3]);
        }
        return Math.max(array[0] + maxArray(Arrays.copyOfRange(array, 2, array.length)), array[1] + maxArray(Arrays.copyOfRange(array, 3, array.length)));
    }
}
