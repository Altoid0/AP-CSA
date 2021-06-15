package com.freekash.springboot.Dhruv;

import java.util.Arrays;

public class Selection {
    //Selection sort with Integers
    public void Selection(int[] arr) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    //Selection Sort with Strings
    public void Selection(String[] array) {
        for ( int j=0; j < array.length-1; j++ )
        {
            // Find min: the index of the string reference that should go into cell j.
            // Look through the unsorted strings (those at j or higher) for the one that is first in lexicographic order
            int min = j;
            for ( int k=j+1; k < array.length; k++ )
                if ( array[k].compareTo( array[min] ) < 0 ) min = k;

            // Swap the reference at j with the reference at min
            String temp = array[j];
            array[j] = array[min];
            array[min] = temp;
        }
    }


    public static void main(String args[]) {
        Selection test = new Selection();
        int nums[] = {5,6,2,89,123,74};
        String letters[] = {"B","F","H","A","C"};

        System.out.println("Original Selection Array:");
        System.out.println(Arrays.toString(nums));
        System.out.println("Original Selection Array:");
        System.out.println(Arrays.toString(letters));

        test.Selection(nums);
        test.Selection(letters);

        System.out.println("Sorted Selection Array:");
        System.out.println(Arrays.toString(nums));
        System.out.println("Sorted Selection Array:");
        System.out.println(Arrays.toString(letters));

    }


}
