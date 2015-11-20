package com.alg.sedgewick.search.tree;

/**
 * Created by selvarajs on 11/17/15.
 */
public class BST<Key extends Comparable<Key>, Value>
{
    private Node root; // root of BST

    private class Node
    {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N)
        { this.key = key; this.value = val; this.N = N; }
    }

    public int size() {
        return size(root);
    }

    public int size(Node node) {
        int size = 0;

        if (node != null) {
            size = node.N;
        }

        return size;
    }

    public Value get(Key key) {
        // TODO implement
        return null;
    }

    public void put(Key key, Value value) {

        // Handle root empty, new node and existing node value update

        // If root is empty, then start with root

        if (root == null) {
            root = new Node(key, value, 1);
            return;
        }

        put (key, value, root);
    }

    private Node put(Key key, Value value, Node node) {
        // chk if node is null, then new one and return, if not, compare
        // with its value & branch accordingly
        Node nodeToReturn = node;

        if (node == null) {
            nodeToReturn = new Node(key, value, 1);
            return nodeToReturn;
        }


        // compare the values
        // a - b = 97 - 98 = -1
        // compValue -ve, shld go on left, +ve on the right and == update
        int compValue = key.compareTo(node.key);

        if (compValue == 0) {
            nodeToReturn.value = value;
        } else if (compValue < 0) {
            nodeToReturn.left = put(key, value, node.left);
        } else {
            nodeToReturn.right = put(key, value, node.right);
        }

        // TODO should be able to do in one line
        nodeToReturn.N = 1;

        if (nodeToReturn.left != null) {
            nodeToReturn.N += nodeToReturn.left.N;
        }

        if (nodeToReturn.right != null) {
            nodeToReturn.N += nodeToReturn.right.N;
        }


        return nodeToReturn;
    }

    public void traverseAndPrintInAscOrder() {
        // Do an Inorder traversal (left, in, right)
        // Perform in order traversal
        if (root != null) {
            performInOrderTraversal(root);
        }
    }

    private void performInOrderTraversal(Node node) {
        if (node != null) {
            performInOrderTraversal(node.left);
            System.out.print(" ," + node.key + ", ");
            performInOrderTraversal(node.right);
        }
    }



}

/*




*/
