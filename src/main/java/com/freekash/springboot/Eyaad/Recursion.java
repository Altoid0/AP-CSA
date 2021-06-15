package com.freekash.springboot.Eyaad;
import java.util.Arrays;

public class Recursion {
    //main function
    public static void main(String[] args) {
        /*Recursion runner = new Recursion();
        System.out.println(runner.returnFact(5));
        System.out.println(runner.fact(5));
        System.out.println(runner.gcf(24,9));
        System.out.println(runner.decimalToBinary(7));
        System.out.println(runner.digitSum(1357));
        System.out.println(runner.isPali("racecar"));
        InsertionSort sort = new InsertionSort();
        String[] arrray = {"Win", "Loss", "James", "Dog","Cat"};
        System.out.println(Arrays.toString(sort.sort(arrray)));
        Book book = new Book("Balls", "Adam");
        Book book2 = new Book("League", "Eyaad");
        Book book3 = new PictureBook("Poggers", "Anthony", "James Pellerin");
        Book[] books = {book2, book3, book};
        System.out.println(Arrays.toString(sort.sort(books)));*/


        Book book1 = new Book("League of Legends Guide", "Eyaad Mir");
        Book book2 = new PictureBook("Diary of a Wimpy Kid", "Jeff Kinney", "Jeff Kinney");
        System.out.println(book1);
        System.out.println(book2);



    }

    //Factorial recursion
    public int fact(int n) { return n>0 ? n*fact(n-1) : 1; }

    public String returnFact(int n) { return n + "! is equal to " + fact(n); }

    //Greatest Common Factor with recursion
    public int gcf(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcf(b, a % b);
    }

    public String returnGcf(int a, int b) {
        return "The greatest common factor of " + a + " and " + b + " is " + gcf(a,b);
    }

    //Convert decimal to binary with recursion
    public int decimalToBinary(int n) {
        if (n <= 1) {
            return n;
        }
        return n % 2 + 10 * decimalToBinary(n/2);
    }

    public String returnBinary(int n) {
        return n + " in binary is " + decimalToBinary(n);
    }

    //Adds up all the digits in the input together
    public int digitSum(int n) {
        if (n / 10 == 0) {
            return n;
        }
        return n % 10 + digitSum(n / 10);
    }

    //Checks if string is palindrome or not(doesn't work with spaces/upper case/special characters
    public boolean isPali(String str) {
        if (str.length()<=1) {
            return true;
        }
        if (str.charAt(0) == str.charAt(str.length()-1)) {
            return isPali(str.substring(1,str.length() - 1));
        }
        return false;
    }
}
