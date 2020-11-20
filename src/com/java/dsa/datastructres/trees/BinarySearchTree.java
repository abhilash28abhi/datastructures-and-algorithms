package com.java.dsa.datastructres.trees;

public class BinarySearchTree {

    private Node root;

    BinarySearchTree () {
        this.root = null;
    }


    //O(log N)
    public void insert (int value) {
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
    public boolean lookup (int value) {
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

    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();
        myBST.insert(1);
        myBST.insert(2);
        myBST.insert(3);
        System.out.println(myBST.lookup(3));
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
