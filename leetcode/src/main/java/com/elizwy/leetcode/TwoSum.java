package com.elizwy.leetcode;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(new int[]{1, 4, 5, 6, 8, 5, 8, 2, 1, 5}, 5);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index=0; index<nums.length ; index++){
            int expect = target - nums[index];
            if(map.get(expect) != null){
                return new int[]{index,map.get(expect)};
            }
            map.put(nums[index],index);
        }
        return new int[]{};
    }
}
