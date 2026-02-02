package org.example.algorithms.slidingwindow;

/*
643. Maximum Average Subarray I
Easy
https://leetcode.com/problems/maximum-average-subarray-i/
 */

public class FindMaxAvg {

    private static double findMaxAverage(int[] nums, int k){
        double maxAvg = Integer.MIN_VALUE;
        int windowStart = 0;
        double windowSum = 0;

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++){
            windowSum += nums[windowEnd];

            if(windowEnd >= k-1){
                maxAvg = Math.max(maxAvg, windowSum / k);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return maxAvg;
    }


    public static void main(String[] args){

        int[] nums = {1,12,-5,-6,50,3};
        System.out.println("MaxAverage: "+ findMaxAverage(nums, 4) );
    }

}
