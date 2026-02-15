package org.example.algorithms.slidingwindow;

/*
219. Contains Duplicate II
Easy

https://leetcode.com/problems/contains-duplicate-ii/description/

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */


import java.util.HashSet;

public class ContainsDuplicateTwo {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(containsNearbyDuplicate(arr, 3));
    }
}