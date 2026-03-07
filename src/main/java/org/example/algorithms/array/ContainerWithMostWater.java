package org.example.algorithms.array;

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
