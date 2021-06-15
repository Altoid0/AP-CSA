package com.freekash.springboot.Nathan;

import java.util.ArrayList;
import java.util.Arrays;

public class Inheritance {

    public static abstract class Consumable {

        private String itemName;
        private int calories;

        public Consumable(String name, int cals){
            this.itemName = name;
            this.calories = cals;
        }

        public int getCalories() {
            return calories;
        }

        @Override
        public String toString() {
            return String.format("Name: %s, Calories %s", itemName, calories);
        }
    }

    public static class Hotdog extends Consumable{

        private String condiments;

        public Hotdog(String condiments){
            super("Hotdog", 400);
            this.condiments = condiments;
        }

        @Override
        public String toString() {
            return String.format("%s, Condiments: %s", super.toString(), condiments);
        }
    }

    public static abstract class Chip extends Consumable{
        private String brand;

        public Chip(String brand, int calories){
            super("Chips", calories);
            this.brand = brand;
        }

        @Override
        public String toString() {
            return String.format("%s, brand: %s", super.toString(), brand);
        }
    }

    public static class PlainChip extends Chip{
        public PlainChip(){
            super("Generic", 200);
        }
    }

    public static class Doritos extends Chip{
        private String flavor;
        public Doritos(String flavor){
            super("Doritos", 300);
            this.flavor = flavor;
        }

        @Override
        public String toString() {
            return String.format("%s, with flavor: %s", super.toString(), flavor);
        }
    }



    public static void main(String[] args) {
        ArrayList<Consumable> lunch = new ArrayList<>();

        lunch.add(new Hotdog("relish"));
        lunch.add(new Hotdog("relish"));
        lunch.add(new PlainChip());
        lunch.add(new Doritos("spicy"));


        lunch.forEach((consumable -> {
            System.out.println(consumable);
        }));

    }


}
