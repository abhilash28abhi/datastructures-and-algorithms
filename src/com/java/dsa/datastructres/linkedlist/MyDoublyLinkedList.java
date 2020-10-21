package com.java.dsa.datastructres.linkedlist;

import java.util.Arrays;

/**
 * Doubly linked list has an advantage over singly list that it can be easily traversed in both direction.
 */
public class MyDoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    MyDoublyLinkedList (int value) {
        Node myNode = new Node(value);
        this.head = myNode;
        this.tail = head;
        length = 1;
    }

    // O(1)
    public void append (int value) {
        Node myNode = new Node(value);
        Node currentNode = this.tail;

        myNode.prev = currentNode;
        currentNode.next = myNode;
        tail = myNode;
        length++;
    }

    // O(1)
    public void prepend (int value) {
        Node myNode = new Node(value);
        Node currentNode = this.head;

        myNode.next = currentNode;
        currentNode.prev = myNode;
        head = myNode;
        length++;
    }

    // O(n)
    public void insert (int index, int value) {
        if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node myNode = new Node(value);
            Node currentNode = this.head;

            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            myNode.next = currentNode.next;
            currentNode.next = myNode;
            myNode.prev = currentNode;
            myNode.next.prev = myNode;
            length++;
        }
    }

    //O(n)
    public void remove (int index) {
        Node currentNode = this.head;

        if (index == 0) {
            head = currentNode.next;
            head.prev = null;
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
            currentNode.next.prev = currentNode;
        }
        length--;
    }

    public int[] printList () {
        int[] myArr = new int[length];
        Node currentNode = this.head;

        int i = 0;
        while (currentNode != null) {
            myArr[i] = currentNode.value;
            currentNode = currentNode.next;
            i++;
        }

        return myArr;
    }

    public static void main(String[] args) {
        MyDoublyLinkedList linkedList = new MyDoublyLinkedList(2);
        linkedList.append(4);
        linkedList.prepend(1);
        linkedList.insert(2, 3);
        System.out.println(Arrays.toString(linkedList.printList()));
        linkedList.remove(2);
        System.out.println(Arrays.toString(linkedList.printList()));

        System.out.println("head value: " + linkedList.head.value);
        System.out.println("head.previous: " + linkedList.head.prev);

        System.out.println("tail value: " + linkedList.tail.value);
        System.out.println("tail.next: " + linkedList.tail.next);
    }

    class Node {

        int value;
        Node next;
        Node prev;

        Node (int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}
