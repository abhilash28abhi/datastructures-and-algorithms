package com.java.dsa.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Works on divide and conquer principle. Its a stable algo keeping the elements in order
 * in case of duplicate entries
 * O(n log n)
 */
public class MergeSort {

    private static List<Integer> mergeSort(List<Integer> input) {

        if (input.size() == 1) {
            return input;
        }

        //divide the array into half until 1 element is left
        int mid = input.size() / 2;
        List<Integer> left = input.subList(0, mid);
        List<Integer> right = input.subList(mid, input.size());

        return merge(mergeSort(left), mergeSort(right));
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();

        int leftIndex = 0;
        int rightIndex = 0;

        while ((leftIndex < left.size() && (rightIndex < right.size()))) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                //it already in correct order dont change
                result.add(left.get(leftIndex));
                leftIndex++;
            } else {
                //change the positions
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        List<Integer> leftRemaining = left.subList(leftIndex, left.size());
        List<Integer> rightRemaining = right.subList(rightIndex, right.size());

        result.addAll(leftRemaining);
        result.addAll(rightRemaining);

        return result;
    }

    public static void main(String[] args) {
        //int[] input = {4, 3, 2, 1};
        //int[] input = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.println(mergeSort(Arrays.asList(4, 3, 2, 1)));
    }
}
