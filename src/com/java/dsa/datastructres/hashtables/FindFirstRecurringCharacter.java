package com.java.dsa.datastructres.hashtables;

//Given an array = [2,5,1,2,3,5,1,2,4]:
//It should return 2

//Given an array = [2,1,1,2,3,5,1,2,4]:
//It should return 1


import java.util.HashMap;
import java.util.Map;

public class FindFirstRecurringCharacter {

    private static int firstRecurringCharacter(int[] arr) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i : arr) {
            if (integerMap.get(i) == null) {
                integerMap.put(i, 0);
            } else {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 5, 2, 3, 5, 1, 2, 4 };
        System.out.print(firstRecurringCharacter(arr));
    }
}
