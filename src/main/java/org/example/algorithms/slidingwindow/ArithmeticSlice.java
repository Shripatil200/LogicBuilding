package org.example.algorithms.slidingwindow;


import java.util.Arrays;

/*
413. Arithmetic Slices
Medium

https://leetcode.com/problems/arithmetic-slices/description/

An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.
 */
public class ArithmeticSlice {

    public static int numberOfArithmeticSlices(int[] nums) {
//        if (nums.length < 3) return 0;
//
//        int[] arr = new int[nums.length];
//
//        for(int i = 2; i < nums.length; i++){
//            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
//                arr[i] = arr[i-1] + 1;
//            }
//        }
//        return Arrays.stream(arr).sum();

        if(nums.length < 3) return 0;
        int count = 0;
        int current = 0;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                current++;
                count += current;
            }else{
                current = 0;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9};

        System.out.println(numberOfArithmeticSlices(nums));
    }
}

