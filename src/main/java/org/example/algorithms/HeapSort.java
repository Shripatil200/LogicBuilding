package org.example.algorithms;

public class HeapSort {


    public  void heapsort(int[] arr){
        int n = arr.length;

        for (int i = (n / 2) -1; i >= 0 ; i--){
            heapify(arr, n, i);
        }

        for (int i = n -1; i >= 0 ; i-- ){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }

    }


    public void heapify(int[] arr, int n , int i){

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if ( left < n && arr[left] > arr[largest]){
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]){
            largest = right;
        }

        if (largest != i){
            int swap = arr[largest];
            arr[largest] = arr[i];
            arr[i] = swap;

            heapify(arr, n, largest);
        }

    }






    public static void main(String[] args) {

        int[] arr = {17, 32, 45, 76, 40, 13,1, 55, 30, 7, 11};

        HeapSort heapSort = new HeapSort();
        heapSort.heapsort(arr);

        for( int num : arr){
            System.out.print(num+ " ");
        }
    }
}
