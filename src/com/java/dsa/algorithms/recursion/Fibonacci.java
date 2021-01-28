package com.java.dsa.algorithms.sortalgorithms.recursion;

//Fibonacci sequence, where the sequence is:
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
public class Fibonacci {

    public static void findFibonacciSeries(int input) {
        int sum = 0;
        int a = 0, b = 1;

        if (input == 0) {
            System.out.print(0);
        } else if (input == 1 || input == 2) {
            System.out.print(0);
            System.out.print("\t" + 1);
        } else {
            for (int i = 0; i < input; i++) {
                System.out.print(a + "\t");
                sum =  a + b;
                a = b;
                b = sum;
            }
        }
    }

    public static int findFibonacciRecursive(int input) {
        if (input == 0) {
            return 0;
        } else if (input == 1 || input == 2) {
            return 1;
        }
        return findFibonacciRecursive(input - 1) + findFibonacciRecursive(input - 2);
    }

    public static void main(String[] args) {
        findFibonacciSeries(6);
        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.print(findFibonacciRecursive(i) + "\t");
        }

    }
}
