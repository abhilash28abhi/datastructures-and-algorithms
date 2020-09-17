package com.java.dsa.algorithms.sortalgorithms;

/**
 * This is an unstable algorithm with O(n2). On each traversal of the array it finds
 * the largest element. It differs from bubble sort as it has less swap operations
 * and hence a bit faster.
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] inputArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = inputArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            //assume the largest element is at index 0
            int largestElementIndex = 0;
            //iterate over the array to find the largest element index and then swap that number with the unsorted index
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                //compare the current element with the largest element
                if (inputArray[i] > inputArray[largestElementIndex]) {
                    largestElementIndex = i;
                }
            }
            int temp = inputArray[largestElementIndex];
            inputArray[largestElementIndex] = inputArray[lastUnsortedIndex];
            inputArray[lastUnsortedIndex] = temp;
        }

        for (int i : inputArray) {
            System.out.println(i);
        }
    }
}
