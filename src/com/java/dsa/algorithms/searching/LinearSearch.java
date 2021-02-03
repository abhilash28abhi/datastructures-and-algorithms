package com.java.dsa.algorithms.searching;

public class LinearSearch {

    private static int linearSearch(int[] input, int key) {

        for (int i = 0; i < input.length; i++) {
            if (input[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {23, 45, 67, 3, 12};
        System.out.println(linearSearch(input, 45));
    }
}
