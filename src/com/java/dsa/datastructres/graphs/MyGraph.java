package com.java.dsa.datastructres.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *   3---4---5
 *   |   |   |
 *   1---2   6
 *    \ /
 *     0
 */
public class MyGraph {

    int numberOfNodes = 0;
    Map<Integer, ArrayList<Integer>> adjacentList = new HashMap<>();

    public void addVertex (Integer value) {
        adjacentList.put(value, new ArrayList<>());
        numberOfNodes++;
    }

    public void addEdge (int value1, int value2) {
        adjacentList.get(value1).add(value2);
        adjacentList.get(value2).add(value1);
    }

    public void showConnections() {
        Object[] keys = adjacentList.keySet().toArray();
        for (Object key : keys) {
            System.out.println(key + " ---> " + adjacentList.get(key));
        }
    }

    public static void main(String[] args) {
        MyGraph myGraph = new MyGraph();
        myGraph.addVertex(0);
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);
        myGraph.addVertex(5);
        myGraph.addVertex(6);
        myGraph.addEdge(3, 1);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(4, 2);
        myGraph.addEdge(4, 5);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(1, 0);
        myGraph.addEdge(0, 2);
        myGraph.addEdge(6, 5);

        myGraph.showConnections();
    }
}
