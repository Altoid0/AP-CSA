package com.freekash.springboot.Nathan;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RefTest {

    static class Dog{
        private String name;

        HashMap<String, String> hm;

        public Dog(){
            hm = new HashMap<>();
            hm.hashCode();

            name = "troy";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static void setNull(Dog[] dogs){
        dogs[0].setName("max");
    }

    public static void main(String[] args) {

        Dog[] dogs = new Dog[]{new Dog(), new Dog(), new Dog()};
        System.out.println(Arrays.toString(dogs));
        dogs[2] = null;
        System.out.println(Arrays.toString(dogs));
        setNull(dogs);
        System.out.println(Arrays.toString(dogs));

        System.out.println(po("FAMILY"));
        Dog dm = new Dog();
        dm.setName("little dog");
        System.out.println(dm.getName());

        foo(dm);

        System.out.println(dm.getName());


        ArrayList<Dog> dogies = new ArrayList<>();
        System.out.println(dogies);
        fooList(dogies);
        System.out.println(dogies);

    }

    static void fooList(ArrayList<Dog> d ){
        d.add(new Dog());
    }

    static void foo(Dog d){
        d.setName("monkey");
    }

    static void foo(String s){
        String[] d = new String[0];
    }

    static String po(String s){
        if(s.length() < 1) return "";
        return po(s.substring(1)) + s.substring(0,1);
    }



}
