package com.java.dsa.algorithms.searching;

import java.util.Arrays;

public class BinarySearch {

    private static int binarySearch(int[] input, int key) {
        int first = 0;
        int last = input.length;
        int mid = (first + last) / 2;

        while (first <= last) {
            if (input[mid] < key) {
                first = mid;
            } else if (input[mid] == key) {
                return mid;
            } else {
                last = mid;
            }
            mid = first + last / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {23, 45, 67, 3, 12};
        Arrays.sort(input);
        System.out.println(binarySearch(input, 67));
    }
}
