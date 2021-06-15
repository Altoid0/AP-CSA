package com.freekash.springboot.Nathan;

import java.util.ArrayList;
import java.util.Arrays;

public class Insertion {

    public static int[] insertionSort(int[] arr){

        for(int i=1;i<arr.length; i++){

            int index1 = i;
            int index2 = i-1;
            while (index2 >= 0 && arr[index1] <= arr[index2]){
                //Swap
                int val1 = arr[index1];
                arr[index1] = arr[index2];
                arr[index2] = val1;

                //decrement
                index1 -= 1;
                index2 -= 1;
            }

        }

        return arr;
    }

    public static int[][] insertionSortWithSteps(int[] arr){

        ArrayList<int[]> steps = new ArrayList<>();
        steps.add(arr.clone());

        for(int i=1;i<arr.length; i++){

            int index1 = i;
            int index2 = i-1;
            while (index2 >= 0 && arr[index1] <= arr[index2]){
                //Swap
                int val1 = arr[index1];
                arr[index1] = arr[index2];
                arr[index2] = val1;

                //decrement
                index1 -= 1;
                index2 -= 1;

                steps.add(arr.clone());
            }

        }

        steps.add(arr.clone());

        return steps.toArray(new int[steps.size()][arr.length]);
    }

    public static void main(String[] args) {
        int[] vals = new int[]{5,2,8,23,6,7,123,-1,435,2,7,2,7,8,90};
        //System.out.println(Arrays.toString(Insertion.insertionSort(vals)));

        int[] vals2 = new int[]{5,2,8,23,6,7};
        System.out.println(Arrays.deepToString(Insertion.insertionSortWithSteps(vals2)));

    }

}
