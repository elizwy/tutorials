package com.elizwy.leetcode;

/**
 * 189
 */
public class RotateArray {
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int rotateNumber = 3;
        int[] result1 = rotateArray.rotate1(a, rotateNumber);
        sout(result1);

        int[] result2 = rotateArray.rotate2(a, rotateNumber);
        sout(result2);


    }

    /**
     * 原地迁移
     *
     * @param a
     * @param rotateNumber
     * @return
     */
    private int[] rotate2(int[] a, int rotateNumber) {
        rotateNumber %= a.length;

        reverse(a, 0, a.length - 1);
        reverse(a, 0, rotateNumber - 1);
        reverse(a, rotateNumber, a.length - 1);

        return a;
    }

    private void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }


    private static void sout(int[] result1) {
        System.out.println("-------");
        for (int r : result1) {
            System.out.print(r);
        }
        System.out.println("");
    }

    /**
     * 新数组
     *
     * @param a
     * @param rotateNumber
     * @return
     */
    private int[] rotate1(int[] a, int rotateNumber) {
        final int[] newA = new int[a.length];
        int length = a.length;
        for (int i = 0; i < a.length; i++) {
            newA[(i + rotateNumber) % length] = a[i];
        }
        return newA;
    }
}
