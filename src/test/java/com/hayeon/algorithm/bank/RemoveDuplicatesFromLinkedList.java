package com.hayeon.algorithm.bank;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

public class RemoveDuplicatesFromLinkedList {

    @Test
    void test() {
        int[] input = new int[]{1, 1, 3, 4, 4, 4, 5, 6, 6};

        MyLinkedList list = removeDuplicates2(input);

        Node current = list.first;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
        //Assertions.assertThat(list.size()).isEqualTo(5);

    }

    public MyLinkedList removeDuplicates2(int[] numbers) {
        MyLinkedList list = new MyLinkedList();
        for (int number : numbers) {
            list.add(number);
        }
        HashSet<Integer> hashSet = new HashSet<>();

        Node current = list.first;
        Node previous = null;
        while (current != null) {
           if (hashSet.contains(current.value)) {
               previous.next = current.next;
           } else {
               hashSet.add(current.value);
               previous = current;
           }
           current = current.next;
        }
        return list;
    }


    public MyLinkedList removeDuplicates(int[] numbers) {

        MyLinkedList list = new MyLinkedList();
        for (int number : numbers) {
            list.add(number);
        }
        Node ptr1 = null, ptr2 = null, dup = null;
        ptr1 = list.first;
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;

            while (ptr2.next != null) {
                if (ptr1.value == ptr2.next.value) {

                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
        return list;
    }

    public class Node {
        int value;
        Node next;

        public Node(){}
        public Node(int value){
            this.value = value;
        }
    }

    public class MyLinkedList {
        Node first;
        Node last;
        int size;

        public void add(int data) {
            Node node = new Node(data);
            if (size == 0) {
                first = last = node;
            } else {
                last.next = node;
                last = node;
            }
            size++;
        }

        public Node get(int index) {
            Node cursor = first;
            for (int i = 0; i < index; i++) {
                cursor = cursor.next;
            }
            return cursor;
        }

        public int size() {
            return size;
        }
    }
}
