package org.example.algorithms;

public class BinarySearch {


    public int searchElement(int[] arr, int start , int end, int element){
        if (start > end){
           return -1;
        }

        int mid = start + ( end - start ) /2;

        if ( element == arr[mid] ) {
            return mid;
        }
        else if ( element < arr[mid]){
            return searchElement(arr, start , mid -1, element);
        }
        else{
            return searchElement(arr, mid + 1, end, element);
        }

    }

    public static void main(String[] args) {


        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,15,16,18,21,56,98};

        BinarySearch search = new BinarySearch();

        int position = search.searchElement(arr, 0, arr.length -1, 5);

        System.out.println(position);


    }
}
