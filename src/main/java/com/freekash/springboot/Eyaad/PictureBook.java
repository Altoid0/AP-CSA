package com.freekash.springboot.Eyaad;

public class PictureBook extends Book {
    private String illustrator;
    public PictureBook(String t, String a, String i) {
        super(t, a);
        illustrator = i;
    }
    public String toString() {
        return super.toString() + " and illustrated by " + illustrator;
    }
}
