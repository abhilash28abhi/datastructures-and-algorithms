package com.java.dsa.algorithms.sortalgorithms.recursion;

public class Factorial {

    public static int findFactorialRecursion (int input) {
        if (input == 0) {
            return 1;
        }
        return input * findFactorialRecursion(input - 1);
    }

    public static int findFactorialIterative (int input) {
        int factorial = 1;
        int i = input;

        if (input == 0) {
            return 1;
        }

        do {
            factorial = factorial * i;
            i--;
        } while (i > 0);
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(findFactorialRecursion(5));
        System.out.println(findFactorialIterative(3));
    }
}
