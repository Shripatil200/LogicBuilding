package org.example.algorithms.array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
1. Two Sum
Easy

https://leetcode.com/problems/two-sum/description/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */
public class TwoSum {

    private static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> hashMap = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++){
            int value = target - nums[i];
            if(hashMap.containsKey(value)){
                result[0] = hashMap.get(value);
                result[1] = i;
                break;
            }
            hashMap.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(arr, target)));

    }

}
