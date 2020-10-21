package com.java.dsa.datastructres.linkedlist;

import java.util.Arrays;

//Overcomes the problem of ordering which was present in HashTables
public class MySinglyLinkedList {

    @Override public String toString() {
        return "MySinglyLinkedList{" + "head=" + head + ", tail=" + tail + ", length=" + length + '}';
    }

    private Node head;
    private Node tail;
    private int length;

    MySinglyLinkedList (int value) {
        head = new Node(value);
        tail = head;
        length = 1;
    }

    // O(1)
    public void append (int value) {
        Node myNode = new Node(value);
        tail.next = myNode;
        tail = myNode;
        length++;

    }

    // O(1)
    public void prepend (int value) {
        Node myNode = new Node(value);
        myNode.next = head;
        head = myNode;
        length++;
    }

    //O(n)
    public void insert (int index, int value) {
        if (index < 0 || index > length) {
            System.err.println("Index Out Of Bounds For Length " + length);
        } else if (index == 0) {
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
            length++;
        }
    }

    //O(n)
    public void remove (int index) {
        Node currentNode = this.head;

        if (index == 0) {
            head = this.head.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
            if (index == length - 1) {
                tail = currentNode;
            }
        }
        length--;
    }

    //O(n)
    public MySinglyLinkedList reverse () {
        MySinglyLinkedList linkedList = new MySinglyLinkedList(this.head.value);
        Node currentNode = this.head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            Node myNode = new Node(currentNode.value);
            myNode.next = linkedList.head;
            linkedList.head = myNode;
            linkedList.length++;
        }
        return linkedList;
    }

    public int[] printLinkedList () {
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
        MySinglyLinkedList linkedList = new MySinglyLinkedList(2);
        linkedList.append(3);
        linkedList.append(5);
        linkedList.prepend(1);
        linkedList.insert(3, 4);
        System.out.println(Arrays.toString(linkedList.printLinkedList()));
        linkedList.remove(3);
        System.out.println(Arrays.toString(linkedList.printLinkedList()));

        System.out.println("reverse linkedList : " + Arrays.toString(linkedList.reverse().printLinkedList()));
    }

    class Node {

        @Override public String toString() {
            return "Node{" + "value=" + value + ", next=" + next + '}';
        }

        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
