package com.java.dsa.datastructres.queues;

/**
 * FIFO implementation
 * eg: 1-->2-->3
 *     F       L
 */
public class Queue {

    private Node first;
    private Node last;
    private int length;

    Queue() {
        this.first = null;
        this.last = first;
        length = 0;
    }

    //O(1)
    //adds an element to the queue
    public void enqueue (int value) {
        Node myNode = new Node(value);
        if (length == 0) {
            this.first = myNode;
            this.last = first;
        } else {
            this.last.next = myNode;
            this.last = myNode;
        }
        length++;
    }
    //3-->2-->1
    //O(1)
    //removes the first element from the queue
    public void dequeue () {
        if (length > 0) {
            this.first = this.first.next;
            if (length == 1) {
                this.last = null;
            }
            length--;
        }
    }

    //O(1)
    public int peek() {
        if (length > 0) {
            return this.first.value;
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);

        System.out.println(myQueue.peek());
        myQueue.dequeue();
        System.out.println(myQueue.peek());
        System.out.println(myQueue.isEmpty());
    }

    class Node {
        private int value;
        private Node next;

        Node (int value) {
            this.value = value;
            this.next = null;
        }
    }
}
