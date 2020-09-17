package com.java.dsa.datastructres.arrays;

import java.util.Arrays;

public class MyArray {

    //O(1)
    public static int getArrayElement(int[] input, int index) {
        return input[index];
    }

    //O(n)
    public static int findArrayElementIndex(int[] input, int element) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == element) {
                return i;
            }
        }
        return 0;
    }

    //O(n)
    public static void insertArrayElement (int[] input, int position, int element) {
        int[] arr = new int[input.length + 1];

        for (int i = 0; i < arr.length ; i++) {
            if (i < position) {
                arr[i] = input[i];
            } else if (i == position) {
                arr[i] = element;
            } else {
                arr[i] = input[i - 1];
            }
        }
        printArrayValues(arr);
    }

    //O(n)
    public static void deleteArrayElement (int[] input, int element) {
        int[] arr = new int[input.length - 1];
        for (int i = 0 , j = 0; i < input.length ; i++) {
            if (input[i] == element) {
                continue;
            }
            arr[j++] = input[i];
        }
        printArrayValues(arr);
    }

    private static void printArrayValues(int[] arr) {
        Arrays.stream(arr).forEach(e -> System.out.print(e + ","));
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};

        System.out.println(getArrayElement(input, 3));
        System.out.println(findArrayElementIndex(input, 2));
        insertArrayElement(input, 3, 6);
        System.out.println();
        deleteArrayElement(input, 2);
    }
}
