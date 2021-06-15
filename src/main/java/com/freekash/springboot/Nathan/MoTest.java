package com.freekash.springboot.Nathan;

import java.util.ArrayList;

public class MoTest {

    static class Aclass {

        public Aclass(){
            Aclass a = new Aclass();
        }
        public void methodX()

        {

            System.out.print("Super X ");

            methodY();

        }

        public void methodY()

        {

            System.out.print("Super Y ");

            methodZ();

        }

        public void methodZ(){

        System.out.print("Super Z");

    }

}

static class Bclass extends Aclass {

    public void methodX() {

        super.methodX();

    }

    public void methodY() {

        System.out.print("Sub Y ");

        methodZ();

    }

}


    static class A{
        private void m(){
            System.out.println("A");
        }
    }

    static class B extends A{
        void m(){
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        //new Aclass();

        A aIsA = new A();
        A aIsB = new B();
        B bIsB = new B();
        System.out.println(aIsA + " " + aIsB + " " + bIsB);
        aIsA.m();
        aIsB.m();
        bIsB.m();

        int m = new Integer(5);

        Runtime r = Runtime.getRuntime();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("hello");
        strings.add("there");
        strings.add("hello");
        strings.add("there");
        strings.add("there");

        for(int i=0;i<strings.size();i++){
            String s = strings.get(i);
            if(s.equals("hello")){
                strings.remove(i);
                i -= 1;
            }
        }

        System.out.println(strings);
    }

}
