package com.freekash.springboot.Dhruv;


import org.thymeleaf.util.ArrayUtils;

import java.util.ArrayList;

public class QuickSortLinkedList {

    public static class Node {
        public Node next;
        int value;
        Node(int v) {
            this.value = v;
            this.next = null;
        }
    }
    public Node head;

    public void addNode(int value){
        if (head == null){
            head = new Node(value);
            return;
        }
        Node current = head;

        while(current.next != null) {
            current = current.next;
        }
        Node newNode = new Node(value);
        current.next = newNode;

    }

    public Object[] printList(Node n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(n != null){
            arr.add(n.value);
            n = n.next;
        }
        Object[] convarr = arr.toArray();
        return convarr;
    }

    // takes first and last node,
// but do not break any links in
// the whole linked list
    Node paritionLast(Node start, Node end)
    {
        if(start == end ||
                start == null || end == null) {

            return start;
        }
        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.value;

        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while(start != end )
        {
            if(start.value < pivot)
            {
                // keep tracks of last modified item
                pivot_prev = curr;
                int temp = curr.value;
                curr.value = start.value;
                start.value = temp;
                curr = curr.next;
            }

            start = start.next;
        }

        // swap the position of curr i.e.
        // next suitable index and pivot
        int temp = curr.value;
        curr.value = pivot;
        end.value = temp;

        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }

    public void sort(Node start, Node end)
    {
        if(start == end ) {
            return;
        }
        // split list and partion recurse
        Node pivot_prev = paritionLast(start, end);

        sort(start, pivot_prev);

        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if( pivot_prev != null &&
                pivot_prev == start ) {
            sort(pivot_prev.next, end);
        }
            // if pivot is in between of the list,
            // start from next of pivot,
            // since we have pivot_prev, so we move two nodes
        else if(pivot_prev != null &&
                pivot_prev.next != null) {
            sort(pivot_prev.next.next, end);
        }
    }

    public static void main(String[] args) {
        QuickSortLinkedList testlist = new QuickSortLinkedList();

        testlist.addNode(4);
        testlist.addNode(7);
        testlist.addNode(33);
        testlist.addNode(12);
        testlist.addNode(9);
        testlist.addNode(54);
        testlist.addNode(27);


        Node n = testlist.head;
        while(n.next != null){
            n = n.next;
        }

        System.out.println("Unsorted List: ");
        testlist.printList(testlist.head);

        testlist.sort(testlist.head, n);

        System.out.println("\nSorted List: ");
        testlist.printList(testlist.head);
    }
}
