package com.java.dsa.datastructres.queues;

import java.util.Stack;

/**
 * Implementing a Queue using Stack
 */
public class QueueUsingStack {

    Stack<Integer> queueStack = new Stack<>();
    Stack<Integer> revStack = new Stack<>();

    public void push (int value) {
        if (queueStack.size() == 0) {
            queueStack.push(value);
        } else {
            while (queueStack.size() != 0) {
                this.revStack.push(this.queueStack.pop());
            }

            this.revStack.push(value);
            while (this.revStack.size() != 0) {
                this.queueStack.push(this.revStack.pop());
            }
        }
    }

    public Integer pop () {
        if (queueStack.size() > 0) {
            return queueStack.pop();
        }
        return null;
    }

    public Integer peek () {
        if (this.queueStack.size() > 0) {
            return this.queueStack.get(this.queueStack.size() - 1);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        QueueUsingStack myQueue = new QueueUsingStack();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);

        System.out.println(myQueue.peek());

        myQueue.pop();
        System.out.println(myQueue.peek());
    }
}
