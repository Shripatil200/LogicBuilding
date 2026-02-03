package org.example.algorithms.slidingwindow;

/*
209. Minimum Size Subarray Sum
Medium
https://leetcode.com/problems/minimum-size-subarray-sum/

Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 */

public class MinSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums) {
        int windowSum = 0;
        int smallestWindowSize = Integer.MAX_VALUE;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];


            while (windowSum >= target) {
                smallestWindowSize = Math.min(smallestWindowSize, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }

        }
        return smallestWindowSize == Integer.MAX_VALUE ? 0 : smallestWindowSize;
    }


    public static void main(String[] args) {
        int[] arr = {2,5,2,56,9,32,2,78,32,4,54};
        System.out.println("MinSubArrayLen: "+minSubArrayLen(100, arr));
    }
}
