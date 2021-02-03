package com.java.dsa.algorithms.sorting;

import java.util.Arrays;

/**
 * Find the smallest element in each iteration and then swap it with the
 * current element.
 * O(n^2)
 */
public class SelectionSort {

    public static void selectionSort (int[] input) {

        for (int i = 0; i < input.length; i++) {
            boolean flag = false;
            int smallestElement = input[i];
            int smallestIndex = 0;

            for (int j = i; j < input.length; j++) {
                if (input [j] < smallestElement) {
                    smallestElement = input[j];
                    smallestIndex = j;
                    flag = true;
                }
            }
            if (flag) {
                //swap the smallest element
                int temp = input[i];
                input[smallestIndex] = input[i];
                input[i] = smallestElement;
            }
        }

        System.out.println(Arrays.toString(input));
    }

    public static void main(String[] args) {
        //int[] input = {4, 3, 2, 1};
        int[] input = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        selectionSort(input);
    }
}
