package com.java.dsa.datastructres.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

    //O(n^2)
    public static void mergeSortedInputArrays(int[] input1, int[] input2) {
        int[] output = new int[input1.length + input2.length];

        for (int i = 0; i < input1.length ; i++) {
            output[i] = input1[i];
        }
        for (int i = 0, j = input1.length; i < input2.length ; i++) {
            output[j++] = input2[i];
        }

        //sort the merged array
        for (int i = 0 ; i < output.length; i++) {
            for (int j = 0; j < output.length; j++) {
                if (output[i] <= output[j]) {
                    int temp = output[i];
                    output[i] = output[j];
                    output[j] = temp;
                    //break;
                }
            }
        }
        Arrays.stream(output).forEach(e -> System.out.print(e + ","));
    }

    public static void main(String[] args) {
        int[] input1 = {1,3,5,7,9};
        int[] input2 = {2,4,6,8,10};
        mergeSortedInputArrays(input1, input2);
    }
}
