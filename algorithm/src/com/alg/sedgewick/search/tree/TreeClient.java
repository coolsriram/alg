package com.alg.sedgewick.search.tree;

/**
 * Created by selvarajs on 11/17/15.
 */
public class TreeClient {

    public static void main (String args[]) {
        System.out.println("main");

        BST<String, String> bstTree = new BST<>();

        bstTree.put("c", "abc");
        bstTree.put("s", "efg");
        bstTree.put("p", "abc");
        bstTree.put("e", "efg");
        bstTree.put("g", "abc");
        bstTree.put("q", "efg");
        bstTree.put("a", "xyz");



        bstTree.traverseAndPrintInAscOrder();
    }
}
