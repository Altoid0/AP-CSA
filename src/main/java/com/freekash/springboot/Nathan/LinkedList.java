package com.freekash.springboot.Nathan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedList implements Iterable<LinkedList.Item> {

    public LinkedList(){}
    public LinkedList(int[] arr){
        for(int a: arr){
            addHead(new Item(a));
        }
    }

    public static class Item {
        Item next;
        private int value;
        public Item(int val){
            next = null;
            value = val;
        }

        public int getValue() {
            return value;
        }

        public String getNextNode(){
            if(next == null) return "null";
            return next.getMem();
        }

        public String getMem(){
            return super.toString().substring(38);
        }

        @Override
        public String toString() {
            return "Item{" +
                    "value=" + value +
                    "mem=" + getMem() +
                    '}';
        }
    }


    Item head = null;
    public void addHead(Item i){
        if(head == null){
            head = i;
            return;
        }

        i.next = head;
        head = i;
    }

    public Item getLast(){
        if(head == null) return null;
        Item temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        return temp;
    }

    public void addTail(Item i){
        Item last = getLast();
        if(last == null) return;
        last.next = i;
    }

    public Item removeFirst(){
        if(head == null) return null;
        Item second = head.next;
        Item first = head;
        head = second;
        return first;
    }

    public Item removeLast(){
        if(head == null) return null;
        if(head.next == null) {
            Item t = head;
            head = null;
            return t;
        }
        Item last = head;
        Item secondToLast = null;
        while (last.next != null){
            secondToLast = last;
            last = last.next;
        }
        secondToLast.next = null;
        return last;
    }

    public List<Item> toList(){
        ArrayList<Item> items = new ArrayList<>();
        if(head == null) return items;
        Item temp = head;
        while (temp.next != null){
            items.add(temp);
            temp = temp.next;
        }
        return items;
    }


    @Override
    public String toString() {
        String s = "";
        Item temp = head;
        while (temp != null){
            s += temp+", ";
            temp = temp.next;
        }
        return s;
        //String sup = super.toString();
        //return sup.substring(27);
    }

    @Override
    public Iterator<Item> iterator() {

        return new Iterator<Item>() {

            Item temp = head;

            @Override
            public boolean hasNext() {
                //System.out.println("TE: " + temp);
                //if(temp == null) return false;
                return temp != null;
            }

            @Override
            public Item next() {
                Item t = temp;
                temp = temp.next;
                return t;
            }
        };
    }


    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addHead(new Item(1));
        l.addHead(new Item(2));
        l.addHead(new Item(3));
        l.addTail(new Item(4));
        l.addTail(new Item(5));
        l.addTail(new Item(6));

        System.out.println(l);
        l.removeFirst();
        System.out.println(l);
        l.removeLast();
        System.out.println(l);

        for(Item i: l){
            System.out.println(i);
        }

        //System.out.println(l.getLast());
        //System.out.println(l.getClass());
    }
}
