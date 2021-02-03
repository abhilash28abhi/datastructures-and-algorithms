package com.java.dsa.algorithms.sorting;

import java.util.Arrays;

/**
 *  O(n^2) -- time complexity
 *  O(1) - space complexity because its sorting on the existing array itself not creating a new one
 */
public class BubbleSort {

    public static void bubbleSort (int[] input) {

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - 1; j++) {
                if (input[j] > input[j + 1]) {
                    //swap the numbers
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(input));
    }

    public static void main(String[] args) {
       // int[] input = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        int[] input = {4,3,2,1};
        bubbleSort(input);
    }
}
