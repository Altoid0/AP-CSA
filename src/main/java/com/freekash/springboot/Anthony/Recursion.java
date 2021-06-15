package com.freekash.springboot.Anthony;

public class Recursion {

    public int factorial (int n) {
        return n>0 ? n*factorial(n-1) : 1;
    }

    public String returnFac (int n) {
        int result = factorial(n);
        return "The factorial of " + n + " is " + result + ".";
    }

    public int frogsProblem (int steps) { //problem finding the number of ways a frog can hop across a given number of steps if said frog can hop 1 or 2 steps
        if (steps == 1 || steps == 0) 
            return 1;
        if (steps < 0) {
            return 0;
        }
        return frogsProblem(steps-1) + frogsProblem(steps-2);
    }

    public String returnFrog (int steps) {
        int result = frogsProblem(steps);
        return "With a total of " + steps + " steps, the frog has " + result + " paths that it can go on.";
    }
}