package com.java.dsa.datastructres.hashtables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//There is no order in HashTables
public class MyHashTable {

    private ArrayList<KeyValue>[] data;

    MyHashTable(int size) {
        data = new ArrayList[size];
    }

    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.codePointAt(i) * i) % data.length;
        }
        //System.out.println("Key hash is : "+ hash);
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        ArrayList<KeyValue> list = data[index];
        if (list == null) {
            list = new ArrayList<>();
            data[index] = list;
        }
        list.add(new KeyValue(key, value));
    }

    public int get(String key) {
        int result = 0;
        int index = hash(key);

        ArrayList<KeyValue> list = data[index];
        for (KeyValue keyValue : list) {
            if (keyValue.key.equals(key)) {
                result = keyValue.value;
            }
        }
        return result;
    }

    public Set<String> keys() {
        Set<String> keySet = new HashSet<>();
        ArrayList<KeyValue>[] buckets = data;

        for (ArrayList<KeyValue> list : buckets) {
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    keySet.add(list.get(i).key);
                }
            }
        }
        return keySet;
    }

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(50);
        hashTable.set("grapes", 1200);
        hashTable.set("apple", 1500);
        hashTable.set("orange", 1000);
        System.out.println("value for key grapes: " + hashTable.get("grapes"));
        System.out.println("value for key apple: " + hashTable.get("apple"));
        System.out.println("list of keys: " + hashTable.keys());
    }

    private class KeyValue {
        private String key;
        private int value;

        public KeyValue(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
