package com.java.dsa.algorithms.sortalgorithms;

/**
 *  Its is a stable algorithm with O(n2).
 *  Drawback is it requires a lot of shifting of elements to find the right insertion place.
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] inputArray = {20, 35, -15, 7, 55, 1, -22}; //length is 7

        //assuming the sorted partition of length 1 starts with -22 initially
        for (int firstUnsortedIndex = inputArray.length - 2; firstUnsortedIndex >= 0; firstUnsortedIndex--) {
            //newElement should be the first element from unsorted partition; compare it with all elements in sorted partition
            int newElement = inputArray[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i < inputArray.length - 1 && newElement > inputArray[i + 1] ; i++) {
                inputArray[i] = inputArray[i + 1];
            }

            inputArray[i] = newElement;
        }


        /* with forward iteration
        for (int lastUnsortedIndex = 1 ; lastUnsortedIndex <= inputArray.length - 1; lastUnsortedIndex++) {
            int newElement = inputArray[lastUnsortedIndex];
            int i;
            for (i = lastUnsortedIndex; i > 0 && newElement < inputArray[i - 1] ; i--) {
                inputArray[i] = inputArray[i - 1];
            }

            inputArray[i] = newElement;
        }*/

        for (int i : inputArray) {
            System.out.println(i);
        }
    }
}
