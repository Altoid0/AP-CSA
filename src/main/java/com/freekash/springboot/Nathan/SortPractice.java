package com.freekash.springboot.Nathan;

import java.util.Arrays;

public class SortPractice {

    public static int[] selectionSort(int[] arr) {

        for(int i=0; i<arr.length; i++){ // iterate through entire array

            int minIndex = i;
            for(int j=i+1; j<arr.length; j++){ //find minimumIndex
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            // swap values
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr){
        for (int i=1; i<arr.length; i++){
            int temp = arr[i];
            int j = i-1;
            while (j >= 0 && temp < arr[j]){
                arr[j+1] = arr[j];
                j -= 1;
            }
            arr[j+1] = temp;
        }
        return arr;
    }

    public static int binarySearch(int[] arr, int target, int low, int high){

        if(low > high){ // not found
            return -1;
        }

        int mid = (low + high) / 2;

        // case 1: equal
        if(target == arr[mid]) {
            return mid;
        }else if(target < arr[mid]){
            return binarySearch(arr, target, low, mid-1);
        }else if(target > arr[mid]){
            return binarySearch(arr, target, mid+1, high);
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {4,1,6,3,8,9,10};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {4,-10,6,3,-8,9,10};
        insertionSort(arr2);
        System.out.println(Arrays.toString(arr2));

        System.out.println(binarySearch(arr, 6, 0, arr.length));

//        arr = new int[]{-1,5,2,9,12,3,4,20};
//        insertionSort(arr);
//        System.out.println(Arrays.toString(arr));

    }

}
