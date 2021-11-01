package com.elizwy.leetcode;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));

    }

    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int totalLength=nums1.length+nums2.length;
            int index1=0,index2=0;
            double result=0;
            if(totalLength%2==0){
                double r0=0;
                for(int i=0;i<=totalLength/2;i++){
                    if (element(index1,nums1) < element(index2,nums2)) {
                        if(i == totalLength/2-1 || i==totalLength/2){
                            r0+= element(index1,nums1);
                        }
                        index1++;
                    }else {
                        if(i == totalLength/2-1 || i==totalLength/2){
                            r0+= element(index2,nums2);
                        }
                        index2++;
                    }
                }
                result=r0/2;

            }else {
                for(int i=0;i<=totalLength/2;i++){
                    if (nums1[index1] <nums2[index2]) {
                        result= element(index1,nums1);
                        index1++;
                    }else {
                        result= element(index2,nums2);
                        index2++;
                    }
                }
            }
            return result;
    }

    public static double element(int index, int[] nums){
        if(index > nums.length-1){
            return Integer.MAX_VALUE;
        }else {
            return nums[index];
        }

    }
}
