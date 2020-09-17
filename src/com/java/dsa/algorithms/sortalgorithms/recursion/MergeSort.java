package com.java.dsa.algorithms.sortalgorithms.recursion;

/**
 * It is a stable algorithm with O(nlogn) time complexity.
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] inputArray = { 20, 35, -15, 7, 55, 1, -22 }; //length is 7
        mergeSort(inputArray, 0, inputArray.length);

        for (int i : inputArray) {
            System.out.println(i);
        }
    }

    public static void mergeSort(int[] input, int startIndex, int endIndex) {
        //breaking condition for recursion
        if ((endIndex - startIndex) < 2) {
            return;
        }

        //end index is 1 more than the last end index of array
        int mid = (startIndex + endIndex) / 2;
        mergeSort(input, startIndex, mid);
        mergeSort(input, mid, endIndex);
        //merge logic would be called only when all the elements in sub array are of length 1
        merge(input, startIndex, mid, endIndex);
    }

    private static void merge(int[] input, int startIndex, int mid, int endIndex) {

        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int[] tempArray = new int[endIndex - startIndex];
        int i = startIndex;
        int j = mid;
        int tempIndex = 0;

        while (i < mid && j < endIndex) {
            tempArray[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, startIndex + tempIndex, mid - i);
        System.arraycopy(tempArray, 0, input, startIndex, tempIndex);
    }
}
