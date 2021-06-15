package com.freekash.springboot.Eyaad;

public class Book {
    private String title;
    private String author;

    public Book(String t, String a) {
        title = t;
        author = a;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return "Your book is " + title + ", written by " + author;
    }
}