package com.elizwy.leetcode;

public class BinarySearch {
    public static void main(String[] args) {
        int result = search(new int[]{1, 3, 5, 6, 7, 8, 11, 14, 21, 34}, 12);
        System.out.println(result);
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = -1;
        int right = nums.length ;

        while (1 < right-left) {
            int middle = left + (right-left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return -1;
    }
}
