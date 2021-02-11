package com.java.dsa.datastructres.trees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private Node root;

    private BinarySearchTree () {
        this.root = null;
    }


    //O(log N)
    private void insert (int value) {
        Node myNode = new Node(value);

        if (this.root == null) {
            this.root = myNode;
        } else {
            Node currentNode = this.root;

            while (true) {
                if (value > currentNode.value) {
                    //right side branch
                    if (currentNode.right != null) {
                        currentNode = currentNode.right;
                    } else {
                        currentNode.right = myNode;
                        break;
                    }
                } else {
                    //left side branch
                    if (currentNode.left != null) {
                        currentNode = currentNode.left;
                    } else {
                        currentNode.left = myNode;
                        break;
                    }
                }
            }
        }
    }

    //returns true if that value exists in the tree
    // O(log N)
    private boolean lookup (int value) {
        Node currentNode = this.root;

        while (currentNode != null) {
            if (value > currentNode.value) {
                currentNode = currentNode.right;
            } else if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     *  O(n)
     *  Takes less memory and helps in determining if the path exists for a node
     */
    private void depthFirstSearch () {

    }

    private List<Integer> DFSInOrder () {
        return traverseInOrder(this.root, new ArrayList<>());
    }

    private List<Integer> DFSPreOrder () {
        return traversePreOrder(this.root, new ArrayList<>());
    }

    private List<Integer> DFSPostOrder () {
        return traversePostOrder(this.root, new ArrayList<>());
    }

    private List<Integer> traverseInOrder(Node node, List<Integer> result) {
        if (node.left != null) {
            traverseInOrder(node.left, result);
        }
        result.add(node.value);
        if (node.right != null) {
            traverseInOrder(node.right, result);
        }
        return result;
    }

    private List<Integer> traversePreOrder(Node node, List<Integer> result) {
        result.add(node.value);
        if (node.left != null) {
            traversePreOrder(node.left, result);
        }
        if (node.right != null) {
            traversePreOrder(node.right, result);
        }
        return result;
    }

    private List<Integer> traversePostOrder(Node node, List<Integer> result) {
        if (node.left != null) {
            traversePostOrder(node.left, result);
        }
        if (node.right != null) {
            traversePostOrder(node.right, result);
        }
        result.add(node.value);
        return result;
    }

    /**
     *  O(n)
     *  Good for finding shortest paths but take more space or memory
     */
    private void breadthFirstSearch () {
        List<Integer> result = new ArrayList<>();
        Node currentNode = this.root;
        List<Node> queue = new ArrayList<>();
        queue.add(currentNode);

        while (queue.size() > 0) {
            currentNode = queue.remove(0);
            result.add(currentNode.value);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        System.out.println("BFS result is : " + result);
    }

    private List<Integer> breadthFirstSearchRecursive (List<Node> queue, List<Integer> result) {
        if (queue.size() == 0) {
            return result;
        }
        Node currentNode = queue.remove(0);
        result.add(currentNode.value);
        if (currentNode.left != null) {
            queue.add(currentNode.left);
        }
        if (currentNode.right != null) {
            queue.add(currentNode.right);
        }
        return breadthFirstSearchRecursive(queue, result);
    }

    /**
     *         9
     *    4         20
     * 1    6   15     170
     */
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);
        System.out.println(bst.lookup(7));

        bst.breadthFirstSearch();

        List<Node> queue = new ArrayList<>();
        queue.add(bst.root);
        System.out.println("BFS recursive result is : "+ bst.breadthFirstSearchRecursive(queue, new ArrayList<>()));

        System.out.println("InOrder result is : "+ bst.DFSInOrder());
        System.out.println("PreOrder result is : "+ bst.DFSPreOrder());
        System.out.println("PostOrder result is : "+ bst.DFSPostOrder());
    }

    class Node {

        private int value;
        private Node left;
        private Node right;

        Node (int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
