package com.freekash.springboot.Dhruv;

import org.springframework.web.servlet.resource.CachingResourceResolver;

import java.sql.Driver;
import java.util.ArrayList;

public class Inheritance {
    public static class Animal {
        private String species;
        private String name;
        private int age;
        public Animal(String species, String name, int age) {
            this.species = species;
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public String getSpecies() {
            return species;
        }
        public int getAge() {
            return age;
        }
        public String returnabout() {
            return "Species: " + species + ", Name: " + name + ", Age: " + age;
        }
    }
    public static class Bird extends Animal{
        public Bird (String name, int age) {super("Bird", name, age);}
    }
    public static class Giraffe extends Animal{
        public Giraffe (String name, int age) {super("Giraffe", name, age);}
    }

    public static void main(String[] args){
        ArrayList<Animal> animals = new ArrayList<>();

        Bird bird = new Bird("Nigel", 3);
        animals.add(bird);

        Giraffe giraffe = new Giraffe("Monty", 9);
        animals.add(giraffe);

        animals.forEach((animal -> {
            System.out.println(animal.returnabout());
        }));
    }

}
