package com.java.dsa.algorithms.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic programming is nothing but using the memoization technique to optimise your code.
 * Memoization is same as caching, there by reducing the computations
 * Series: 0 1 1 2 3 5 8 13 21 34 55 ...
 */
public class Fibonacci {

    int withoutMemoCalculations = 0;

    /**
     * O (2^n)
     */
    private int fibonacciWithoutMemoization (int input) {
        withoutMemoCalculations++;
        if (input < 2) {
            return input;
        } else {
            return fibonacciWithoutMemoization(input - 1) + fibonacciWithoutMemoization(input - 2);
        }
    }

    Map<Integer, Integer> cache = new HashMap<>();
    int withMemoCalculations = 0;

    /**
     *  O (n)
     */
    private int fibonacciWithMemoization (int input) {

        if (cache.get(input) != null) {
            return cache.get(input);
        } else {
            if (input < 2) {
                return input;
            } else {
                withMemoCalculations++;
                int result = fibonacciWithMemoization(input - 1) + fibonacciWithMemoization(input - 2);
                cache.put(input, result);
                return cache.get(input);
            }
        }

    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("Fibonacci number at index is " + fibonacci.fibonacciWithoutMemoization(10));
        System.out.println("No of calculations without optimization is " + fibonacci.withoutMemoCalculations);

        System.out.println("Fibonacci number at index with cache is " + fibonacci.fibonacciWithMemoization(10));
        System.out.println("No of calculations with optimization is " + fibonacci.withMemoCalculations);
    }
}
