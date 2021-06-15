package com.freekash.springboot.Tanay;

public class InsertionSort {
    public void sort(int arr[])
    {
        // Get length aka max index
        int n = arr.length;
        // For each element in the index
        for (int i = 1; i < n; ++i) {
            // Set the current element to key
            int key = arr[i];
            // set j to the index night before the current element
            int j = i - 1;

            // While j is greater than or equal to 0 AND the element before is greater than the key element
            while (j >= 0 && arr[j] > key) {
                // Set the element before equal to the next index slot
                arr[j + 1] = arr[j];
                // decrease j so we can check the next element before and see if that too is greater than key and needs to be shifted right
                j = j - 1;
            }
            // Since the while loop will stop when the value at index j is no longer greater than the key we will insert the key right after that lesser value
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args){
        int[] array = {3, 5, 7, 12, 11, 2};
        InsertionSort isort = new InsertionSort();
        isort.sort(array);
        System.out.print("Sorted Array: ");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if (i != array.length - 1){
                System.out.print(", ");
            }
        }
    }
}
