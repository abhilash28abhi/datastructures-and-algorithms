package com.java.dsa.datastructres.stacks;

/**
 * LIFO implementation
 *
 */
public class Stack {

    private Node top;
    private Node bottom;
    private int length;

    Stack() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    //O(1)
    //insert the element at the top
    public void push (int value) {
        Node myNode = new Node(value);
        if (length == 0) {
            this.top = myNode;
            this.bottom = top;
        } else {
            Node currentNode = this.top;
            myNode.next = currentNode;
            this.top = myNode;
        }
        length++;
    }

    //O(1)
    //remove the top element
    public void pop () {
        if (length > 0) {
            Node currentNode = this.top;
            this.top = currentNode.next;
            if (length == 1) {
                this.bottom = null;
            }
            length--;
        }
    }

    //O(1)
    //retrieves the top element
    public int peek () {
        if (length > 0) {
            return this.top.value;
        } else {
            return -1;
        }
    }

    public int getLastElement() {
        if (length > 0) {
            return bottom.value;
        }
        return -1;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.peek());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.getLastElement());
    }

    class Node {

        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
