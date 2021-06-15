package com.freekash.springboot.Nathan;

public class AnotherTest {

    static class Book{
        public boolean compare(Book other){
            return true;
        }
    }

    static class Dictionary extends Book{
        public int compare(){
            return 1;
        }

        public boolean compare(Book other){
            return true;
        }

        public boolean compare(Dictionary other){
            return true;
        }
    }

}
