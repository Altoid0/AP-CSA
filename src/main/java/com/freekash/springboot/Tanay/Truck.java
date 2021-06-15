package com.freekash.springboot.Tanay;

public class Truck extends Car {

    private int hp;

    public Truck(String make, String model, int age, int hp) {
        super(make, model, age);
        this.hp = hp;
    }

    public void setHorsePower(int newHorsePower) {
        hp = newHorsePower;
    }

    public String toString() {
        return ("This " + super.make + " " + super.model + " was manufactured in " + super.age + " and has " + hp + " hp");
    }
}
