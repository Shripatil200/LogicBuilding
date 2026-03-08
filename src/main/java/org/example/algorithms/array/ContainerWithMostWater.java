package org.example.algorithms.array;

/*
11. Container With Most Water

Medium

https://leetcode.com/problems/container-with-most-water/description

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                maxWater = Math.max(maxWater, (right - left) * height[left]);
                left++;
            } else {
                maxWater = Math.max(maxWater, (right - left) * height[right]);
                right--;
            }
        }
        return maxWater;
    }


    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println("Max area: " + maxArea(height));
    }
}
