package com.freekash.springboot.Tanay;

public class BubbleSort {
    public void bsort(int array[]){
        int n = array.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String args[]){
        int array[] = {3, 5, 7, 12, 11, 2};
        BubbleSort sort = new BubbleSort();
        sort.bsort(array);
        System.out.print("Sorted Array: ");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if (i != array.length - 1){
                System.out.print(", ");
            }
        }
    }
}
