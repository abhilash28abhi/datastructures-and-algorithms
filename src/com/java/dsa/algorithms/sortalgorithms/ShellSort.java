package com.java.dsa.algorithms.sortalgorithms;

/**
 *  It was created to reduce the number of shifting operations from the insertion sort. It's performance is
 *  based on the gap value which is most of them times governed by Knuth Principle. The time complexity is difficult to find
 *  as it is based on the gap value. When the gap value is 1 then it will use insertion sort since by then the array
 *  would have been in a near sorted state there by reducing the shifting operations.
 */
public class ShellSort {

    public static void main(String[] args) {

        int[] inputArray = {20, 35, -15, 7, 55, 1, -22}; //length is 7

        for (int gap = inputArray.length / 2; gap > 0 ; gap = gap / 2) {

            for (int i = gap ; i < inputArray.length; i++) {
                int newElement = inputArray[i];
                int j;
                for (j = i; j >= gap && newElement < inputArray[j - gap]; j = j - gap) {
                    //shifting operation
                    inputArray[j] = inputArray[j - gap];
                }
                //when k = 0
                inputArray[j] = newElement;
            }
        }

        for (int i : inputArray) {
            System.out.println(i);
        }
    }
}
