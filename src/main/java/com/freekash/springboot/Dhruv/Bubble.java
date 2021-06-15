package com.freekash.springboot.Dhruv;

import java.util.Arrays;

public class Bubble {
    //Integer Bubble Sort
    public void Bubble(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int value = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = value;
                }
    }

    //String Bubble Sort
    public void Bubble(String[] arr, int n){
        String temp;
        for (int j = 0; j < n - 1; j++)
        {
            for (int i = j + 1; i < n; i++)
            {
                if (arr[j].compareTo(arr[i]) > 0)
                {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void main(String args[]) {
        Bubble test = new Bubble();
        int nums[] = {5,6,2,89,123,74};
        String letters[] = {"B","F","H","A","C"};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(letters));

        test.Bubble(nums);
        test.Bubble(letters,letters.length);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(nums));
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(letters));

    }

}
