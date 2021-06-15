package com.freekash.springboot.Nathan;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiSort<T> {

    public <T extends Comparable<T>> T[] insertionSort(T[] arr){

        for(int i=1;i<arr.length; i++){

            int index1 = i;
            int index2 = i-1;
            while (index2 >= 0 && arr[index1].compareTo(arr[index2]) < 0){
                //Swap
                T val1 = arr[index1];
                arr[index1] = arr[index2];
                arr[index2] = val1;

                //decrement
                index1 -= 1;
                index2 -= 1;
            }

        }

        return arr;
    }

    public <T extends Comparable<T>> T[] bubbleSort(T[] arr){

        boolean sorted = false;
        while (!sorted){
            sorted = true;
            for(int i=0;i<arr.length-1;i++){
                if(arr[i].compareTo(arr[i+1]) > 0){
                    sorted = false;
                    T temp  = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        return arr;
    }

    public <T extends Comparable<T>> T[] selectionSort(T[] arr){

        for(int i =0; i< arr.length;i++){
            int lowest = i;
            for(int j=i;j<arr.length;j++){
                if(arr[j].compareTo(arr[lowest]) < 0){
                    lowest = j;
                }
            }

            //Swap
            T itemLowest = arr[lowest];
            arr[lowest] = arr[i];
            arr[i] = itemLowest;
        }
        return arr;
    }

    public <T extends Comparable<T>> T[] swap(T[] arr, int a, int b){
        T temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
        return arr;
    }


    public static void main(String[] args) {

//        for (int n = 0; n < 7; n += 2){
//            System.out.println(n);
//        }

        String[] strings = new String[]{"nathan", "apple", "classroom", "hat", "cat"};
        MultiSort<String> ms = new MultiSort<>();
        System.out.println(Arrays.toString(ms.insertionSort(strings)));

        Car[] cars = new Car[10];
        for(int i=0;i<cars.length;i++){
            cars[i] = new Car((int)(Math.random()*1000));
        }
        MultiSort<Car> cs = new MultiSort<>();
        System.out.println(Arrays.toString(cs.insertionSort(cars)));

        Integer[] ints = new Integer[10];
        for(int i=0;i<ints.length;i++){
            ints[i] = (int)(Math.random()*1000);
        }
        MultiSort<Integer> is = new MultiSort<>();
        System.out.println(Arrays.toString(is.insertionSort(ints)));

    }

    public static class Car implements Comparable<Car>{
        private int price;
        public Car(int price){
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "price=$" + price +
                    '}';
        }

        @Override
        public int compareTo(Car c) {
            if(c.getPrice() < this.getPrice()){
                return 1;
            }else if(c.getPrice() > this.getPrice()){
                return -1;
            }else{
                return 0;
            }
        }
    }

}
