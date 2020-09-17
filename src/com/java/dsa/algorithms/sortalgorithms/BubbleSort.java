package com.java.dsa.algorithms.sortalgorithms;


/**
 * Its a stable algorithm with O(n2). Here we compare each element with one
 * another and swap if we find the larger value until all elements are covered.
 */
public class BubbleSort {

    public static void main (String[] args) {

        int[] inputArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = inputArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    if (i == i + 1) break;
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                }
            }
        }

        for (int i : inputArray) {
            System.out.println(i);
        }
    }
}
