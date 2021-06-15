package com.freekash.springboot.Dhruv;

public class Recursion {

    // introductory recursion practice
    public int sum(int n) {
        if (n >= 1) {
            return sum(n - 1) + n;
        }
        return n;
    }

    //tail recursion practice
    public int tail(int current, int n) {
        if (n <= 1) {
            return current + n;
        }
        return tail(current +n, n -1);
    }

    // Finding the N-th power of 10 practice
    public int power(int n) {
        if (n == 0) {
            return 1;
        }
        return power(n - 1) * 10;
    }

    //Decimal to Binary
    public String toBinary(int n) {
        if (n <= 1) {
            return String.valueOf(n);
        }
        return toBinary(n/2) + String.valueOf(n % 2);
    }
}
