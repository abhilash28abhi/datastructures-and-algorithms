package com.java.dsa.algorithms.sorting;

import java.util.Arrays;

/**
 * Works really fast if the elements are nearly sorted already
 *  O(n^2)
 */
public class InsertionSort {

    private static void insertionSort(int[] input) {


        for (int i = 1; i < input.length; i++) {
            int prevElementIndex = i - 1;
            int currentElement = input[i];

            while ( prevElementIndex >=0 && currentElement < input[prevElementIndex] ) {
                input[prevElementIndex + 1] = input[prevElementIndex];
                prevElementIndex--;
            }

            input[prevElementIndex + 1] = currentElement;
        }

        System.out.println(Arrays.toString(input));
    }

    public static void main(String[] args) {
        int[] input = {4, 3, 2, 1};
        //int[] input = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        insertionSort(input);
    }
}
