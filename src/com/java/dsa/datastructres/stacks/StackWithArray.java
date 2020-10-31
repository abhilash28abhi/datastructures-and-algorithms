package com.java.dsa.datastructres.stacks;

import java.util.ArrayList;
import java.util.List;

public class StackWithArray {

    //Using arraylist here since we cannot have a dynamic array in Java
    private List<Integer> stackArray;

    StackWithArray () {
        this.stackArray = new ArrayList<>();
    }

    //O(1)
    public void push (int value) {
        stackArray.add(value);
    }

    //O(1)
    public Integer peek () {
        if (this.stackArray.size() > 0) {
            return stackArray.get(stackArray.size() - 1);
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return stackArray.size() == 0;
    }

    //O(1)
    public void pop () {
        stackArray.remove(stackArray.size() - 1);
    }

    public static void main(String[] args) {
        StackWithArray myStack = new StackWithArray();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.peek());
        System.out.println(myStack.isEmpty());
    }
}
