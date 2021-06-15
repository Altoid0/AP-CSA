package com.freekash.springboot.Nathan;

import java.util.ArrayList;

public class BigTest {

    public static void main(String[] args) {
        ArrayList<String> arrs = new ArrayList<>();
        for(int i=0; i<10; i++)
            arrs.add(i+"");

        System.out.println(arrs);

//        for(String x: arrs){
//            if(Integer.valueOf(x) % 2 == 0 ){
//                arrs.remove(x);
//            }
//        }

//        for(int i=0; i<arrs.size(); i++){
//            if(Integer.valueOf(arrs.get(i)) % 3 != 0 ){
//                arrs.remove(i);
//            }
//        }

        for(int i=0; i<arrs.size(); i++){
            if(Integer.valueOf(arrs.get(i)) % 3 != 0 ){
                arrs.remove(i);
                i--;
            }
        }


        System.out.println(arrs);

}

}
