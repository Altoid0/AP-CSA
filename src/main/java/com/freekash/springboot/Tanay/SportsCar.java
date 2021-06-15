package com.freekash.springboot.Tanay;

// Extended class
public class SportsCar extends Car {

    // Create new instance variable specific to sports cars
    private int topSpeed;

    // Main overloaded constructor
    public SportsCar(String make, String model, int age, int topSpeed) {
        super(make, model, age);
        this.topSpeed = topSpeed;
    }

    // Default constructor
    public SportsCar() {
    }

    // Method to change the instance variable from before and set a top speed for our sports car
    public void setTopSpeed(int newSpeed) {
        topSpeed = newSpeed;
    }

    // toString method, we use this so that when we print the object with System.out.println we get a nice formatted string
    // You can see that this is used on line System.out.println(Cars.get(i)); to print the object
    public String toString() {
        return ("This " + super.make + " " + super.model + " was manufactured in " + super.age + " and has a top speed of " + topSpeed + " mph");
    }
}
