package com.java.dsa.datastructres.arrays;

public class ReverseString {

    //O(n)
    public static String reverseInputArray(String input) {
        String result = "";
        char[] arr = input.toCharArray();
        for (int i = arr.length - 1; i >= 0 ; i--) {
            result = result + arr[i];
        }
        return result;
    }

    public static void main (String[] args) {
        String input = "My Name is Abhilash";
        System.out.println(reverseInputArray(input));
    }
}
