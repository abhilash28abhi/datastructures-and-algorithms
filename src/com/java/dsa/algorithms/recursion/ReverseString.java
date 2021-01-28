package com.java.dsa.algorithms.sortalgorithms.recursion;

public class ReverseString {

    public static void reverseString (String input) {
        char[] charArr = input.toCharArray();
        for (int i = charArr.length - 1; i >= 0; i--) {
            System.out.print(charArr[i] + " ");
        }
    }

    public static String reverseStringRecursive (String input) {
        if (input.equals("")) return "";

        return reverseStringRecursive(input.substring(1)) + input.charAt(0);
    }

    public static void main(String[] args) {
        reverseString("Abhilash");
        System.out.println();
        System.out.print(reverseStringRecursive("Abhilash"));
    }
}
