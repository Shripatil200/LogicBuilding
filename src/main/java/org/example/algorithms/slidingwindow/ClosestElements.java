package org.example.algorithms.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/*
658. Find K Closest Elements

Medium

https://leetcode.com/problems/find-k-closest-elements/description/

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 */
public class ClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        int l= 0;
        int r = arr.length - k;

        while(l < r){
            int m = (l + r) / 2;

            if(x - arr[m] > arr[m + k] -x) {
                l = m + 1;
            }else{
                r = m;
            }
        }

        for(int i = l; i < l + k; i++){
            list.add(arr[i]);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,8,9,11,25,66};
        System.out.println(findClosestElements(arr, 6, 15));
    }
}