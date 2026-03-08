package org.example.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
15. 3Sum

Medium

https://leetcode.com/problems/3sum/description/

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int fix = 0; fix < nums.length - 2; fix++){
            if(fix > 0 && nums[fix] == nums[fix-1]){
                continue;
            }

            int left = fix + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[fix] + nums[left] + nums[right];

                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    List<Integer> l1 = Arrays.asList(nums[fix], nums[left], nums[right]);
                    list.add(l1);
                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                }
            }

        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println("result: "+ threeSum(nums));
    }
}
