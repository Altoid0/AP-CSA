package com.freekash.springboot.Tanay;

import java.util.ArrayList;

// Primary parent class
public class Car {

    // Static variable that gets incremented everytime a car is created or "added to the lot"
    static int lotSize;

    // Attributes for each car
    String make;
    String model;
    int age;

    // Overloaded constructor
    public Car(String make, String model, int age) {
        // The keyword "this" lets us reference the variable that belongs to an instance of a class
        this.make = make;
        this.model = model;
        this.age = age;

        // Note that we increase the lot size here where the object is made
        lotSize++;
    }

    // Default Constructor
    public Car(){}
}

// Driver class to create objects and run classes
class Driver {
    public static void main(String args[]) {

        // Arraylist to store all of the objects we are about to make
        ArrayList<Car> Cars = new ArrayList<>();

        // First object created, the 2006 Mazda Miata
        // Notice how since we want this to be a sports car we create the object with "SportsCar <objname> = new SportsCar()
        SportsCar miata = new SportsCar("Mazda", "Miata", 2006, 135);
        // Add new miata to arraylist
        Cars.add(miata);
        SportsCar brz = new SportsCar("Subaru", "Brz", 2020, 145);
        Cars.add(brz);
        miata.setTopSpeed(145);
        Truck f150 = new Truck("Ford", "F150", 2017, 350);
        Cars.add(f150);

        for(int i=0; i < Cars.size(); i++){
            System.out.println(Cars.get(i));
        }
        System.out.println("The total amount of cars currently in the lot is " + Car.lotSize);
    }
}