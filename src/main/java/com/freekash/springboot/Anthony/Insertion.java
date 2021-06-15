package com.freekash.springboot.Anthony;
import java.util.ArrayList;

public class Insertion {
    public String insertionSort (int min, int max, int size) {
        ArrayList<Integer> newArr = new ArrayList<Integer>();

        ArrayList<Integer> originalArr = new ArrayList<Integer>();

        for (int i=0; i<size; i++) {
            originalArr.add( (int)(Math.random() * (max-min)) + min  );
        }

        String finalStr = "Original array: " + originalArr.toString() + "; ";

        Integer[] array = new Integer[originalArr.size()];
        array = originalArr.toArray(array);

        for (int i=0; i < array.length; i++) {
            //finalStr += "Step " + (i+1) + ":\n";

            int index=0;
            if (newArr.size() == 0) {
                //finalStr += "Adding the first element, " + array[i] + ", to the array\n";
                newArr.add(array[i]);
            } else {
                //finalStr += "Comparing new element, " + array[i] + ", to output array elements\n";
                for (int j=0; j < newArr.size(); j++) {
                    if (array[i].compareTo(newArr.get(j)) >= 0) {
                        index = j+1;
                        //finalStr += array[i] + " is greater than " + newArr.get(j) + "\n";
                    } else {
                        //finalStr += array[i] + " is NOT greater than " + newArr.get(j) + "\n";
                    }
                }
                //finalStr += "Finding index of new element, " + array[i] + ", to be " + index + "\n";
                newArr.add(index, array[i]);
            }
            //if (i != array.length-1)
                //finalStr += "Current output array: " + newArr.toString() + "\n";
        }
        finalStr += "Final output: " + newArr.toString();


        return finalStr;
    }
}
