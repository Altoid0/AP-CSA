package com.freekash.springboot.Dhruv;
import java.util.Arrays;

public class Insertion {
    public void Insertion(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > value) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = value;
        }
    }
    public void Insertion(String[] letters) {
        for (int k = 1; k < letters.length; k++) {
            String key = letters[k];
            int l = k - 1;
            while (l >= 0) {
                if (key.compareTo(letters[l]) > 0) {
                    break;
                }
                letters[l + 1] = letters[l];
                l--;
            }
            letters[l + 1] = key;
        }

    }


    public static void main(String args[]) {
        Insertion test = new Insertion();
        int nums[] = {5,6,2,89,123,74};
        String letters[] = {"B","F","H","A","C"};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(letters));

        test.Insertion(nums);
        test.Insertion(letters);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(nums));
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(letters));

    }

}
