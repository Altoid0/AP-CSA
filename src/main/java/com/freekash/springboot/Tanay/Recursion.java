package com.freekash.springboot.Tanay;

import java.util.Scanner;

public class Recursion {
    public static int factorial(int n) {
        if (n < 2) {
            return 1;
        }
        else {
            return n * factorial(n-1);
        }
    }
    public static void main(String[] args){
        Scanner inputFactorial = new Scanner(System.in);
        System.out.println("Enter number to take factorial of: ");
        int userFact = inputFactorial.nextInt();
        System.out.println(factorial(userFact));
    }
}