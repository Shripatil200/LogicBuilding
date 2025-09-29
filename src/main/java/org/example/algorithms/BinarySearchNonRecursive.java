package org.example.algorithms;

public class BinarySearchNonRecursive {

    public int searchElement(int[] arr, int element){

        int start = 0;
        int end = arr.length -1 ;
        while(start <= end){
            int mid = start + ( end - start) / 2;

            if(arr[mid] == element) {
                return mid;
            }
            else if (element < arr[mid]){
                end = mid -1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,15,16,18,21,56,98};

        BinarySearchNonRecursive search = new BinarySearchNonRecursive();

        int position = search.searchElement(arr, 98);
        System.out.println(position);
    }
}
