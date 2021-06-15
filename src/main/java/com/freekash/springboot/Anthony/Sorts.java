package com.freekash.springboot.Anthony;

public class Sorts {
    public <T extends Comparable<T>> T[] insertionSort (T[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            T key = array[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }

    public <T extends Comparable<T>> T[] selectionSort (T[] array) {

        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[smallestIndex]) < 0)
                    smallestIndex = j;
            }

            T temp = array[i];
            array[i] = array[smallestIndex];
            array[smallestIndex] = temp;

        }
        return array;
    }

    public <T extends Comparable<T>> T[] bubbleSort (T[] array) {
        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    T temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    j--;
                }
            }
        }

        return array;
    }

    public static class Champion implements Comparable<Champion> {
        private String name;
        private int mastery;

        public Champion (String name, int mastery) {
            this.name = name;
            this.mastery = mastery;
        }

        public int getMastery () {
            return this.mastery;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return "Champion " + this.getName() + " with mastery " + this.getMastery();
        }

        @Override
        public int compareTo(Champion c) {
            if (this.getMastery() > c.getMastery())
                return 1;
            if (this.getMastery() < c.getMastery())
                return -1;
            return 0;
        }
    }
}
