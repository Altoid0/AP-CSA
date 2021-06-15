package com.freekash.springboot.Eyaad;

import java.util.ArrayList;

public class LinkedList {

    Node head;
    ArrayList<Node> nodeslist;
    public LinkedList(int[] arr) {
        head = new Node(arr[0]);
        ArrayList<Node> nodeslist = new ArrayList<Node>();
        nodeslist.add(head);
        for (int i = 1; i < arr.length; i++) {
            nodeslist.add(new Node(arr[i]));
        }
        for (int i = 0; i < nodeslist.size() - 1; i++) {
            nodeslist.get(i).next = nodeslist.get(i+1);
        }
    }
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
        public Node returnNext() {
            return next;
        }
    }

    public ArrayList<Integer> returnLinkedList() {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        Node node = head;
        while(node != null) {
            nums.add(node.data);
            node = node.next;
        }
        return nums;
    }

    public String toString() {
        String list = "This is the LinkedList: [";
        for (int a : returnLinkedList()) {
            list+= (a + ", ");
        }
        list+="]";
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 8};
        LinkedList linkedList = new LinkedList(arr);
        System.out.println(linkedList);
    }
}
