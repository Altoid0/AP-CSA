package com.freekash.springboot.Nathan;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class test {

    static class Fish{
        public String type = "bone";
        private int a;
         String type(){
            return "fi";
        }
        public Fish(){
             construct();
        }

        private void construct(){
            System.out.println("Fish Contstructed");
        }

        static void swim(){

        }
    }

    static class Shark extends Fish{
        public String type = "cart";

         String type(){
            return "sha";
        }

        public Shark(){
             int d = 3;
             System.out.println("Shark Constructed LOL");
        }

        private void construct(){
            System.out.println("SHARK Contstructed");
        }

        public int swim(int m) {
            return 1;
        }

        public void chomp(){
             swim();
        }
    }


    /**
     * Changes the array at index 0
     * @param arr the array reference
     */
    static void changeIt(int[] arr){
        arr[0] = -1;
        //arr = new int[5];
    }


    public static void main(String[] args) {
//        Fish fish = new Fish();
//        int x  = fish.a;
            Fish shark = new Shark();
//        Shark shark1 = new Shark();
//        System.out.println(fish.type() + " " + shark.type() + " " + shark1.type());

        Shark s = new Shark();
        s.chomp();

        Fish[] things = new Shark[4];
        //things[0] = new Fish();
        things[1] = new Shark();
        things[2] = shark;

        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
        changeIt(arr);
        System.out.println(Arrays.toString(arr));

        ArrayList<String> d = new ArrayList();
        d.add("sdf");


        ArrayList<Integer> integerArrayList = new ArrayList<>();
        Integer in = 2;

        System.out.println();

        int[] ar2 = {1,2,3};

        ArrayList<String> arrList = new ArrayList<String>();
        arrList.add("A");
        arrList.add("B");
        arrList.add("C");
        arrList.add("D");
        for (int i = 0; i < arrList.size(); i++) {
            System.out.print(arrList.remove(i));
        }

    }
}
