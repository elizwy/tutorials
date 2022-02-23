package com.elizwy.leetcode;

public class MoveZeroes {
    public static void main(String[] args) {
        final MoveZeroes instance = new MoveZeroes();
        int[] result = instance.move(new int[]{1, 3, 0, 0, 7, 0, 3, 5, 0, 3, 5});
        for (int r : result) {
            System.out.print(r);
        }
        System.out.println();
    }

    private int[] move(int[] ints) {
        int zeroNumber = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                ints[i - zeroNumber] = ints[i];
            } else {
                zeroNumber++;
            }
        }
        for (int i = ints.length - zeroNumber; i < ints.length; i++) {
            ints[i] = 0;
        }
        return ints;
    }
}
