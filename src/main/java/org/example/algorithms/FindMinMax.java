package org.example.algorithms;

import java.util.Arrays;

public class FindMinMax {


    public int[] minMax(int[] arr, int low, int high){

        int[] result = new int[2];

        if( low == high){
           result[0] = arr[low];
           result[1] = arr[low];
           return result;
        }

        if (high == low + 1){
            if(arr[low] < arr[high]){
                result[0] = arr[low];
                result[1] = arr[high];
            }
            else{
                result[0] = arr[high];
                result[1] = arr[low];
            }
            return result;
        }

        int mid = (low + high) /2;

        int[] left = minMax(arr, low, mid);
        int[] right = minMax(arr, mid +1 , high);


        result[0] = Math.min(left[0], right[0]);
        result[1] = Math.max(left[1], right[1]);

        return result;


     }


    public static void main(String[] args) {
        int[] arr = {4,6,9,4,3,1,0,7,3,11,54,2};

        FindMinMax findMinMax = new FindMinMax();

        System.out.println(Arrays.toString(findMinMax.minMax(arr, 0, arr.length -1)));
    }

}
