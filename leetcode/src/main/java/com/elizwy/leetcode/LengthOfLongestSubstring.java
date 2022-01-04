package com.elizwy.leetcode;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    private static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int right = 0 ; right<s.length(); right++){
            if( map.containsKey(s.charAt(right))){
            // 类似remove 上一个left之前的所有字符
                left = Math.max(map.get(s.charAt(right))+1,left);
            }
            max = max > right-left+1 ? max : right-left+1;
            map.put(s.charAt(right),right);
        }
        return max;
    }


}
