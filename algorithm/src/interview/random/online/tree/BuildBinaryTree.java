package interview.random.online.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by selvarajs on 1/10/16.
 */
public class BuildBinaryTree {

    public static void main(String[] args) {
        // 4.2 cracking interview
        // Increasing int array, build a balanced binary tree

        int[] arr = {1,20,31,34,45,  56, 88};

        Node root = buildBinaryTree(arr, 0, arr.length - 1);

        System.out.println("\n\t\tResults\n\n");
        System.out.println(root.getValue());
        BinaryTreeUtil.printInOrder(root);
        System.out.println("\n\nMax Tree depth: " + BinaryTreeUtil.maxTreeDept(root));

        BTreeBST.printLevel(root, 0, BinaryTreeUtil.maxTreeDept(root));

        Queue<Node> q = new LinkedList<>();
        System.out.println("\n\nkeys");

        keys(root, q, 55, 56);

        for (Node n: q){
            System.out.println(n.getValue());
        }
    }

    public static Node buildBinaryTree(int[] sortedArray) {
        return buildBinaryTree(sortedArray, 0, sortedArray.length - 1);
    }



    private static void keys(Node x, Queue<Node> q, int low, int high){
        if (x == null){
            return;
        }

        int cmpLo = low - x.getValue();
        int cmpHi = high - x.getValue();

        if (cmpLo < 0){
            keys(x.getLeft(), q, low, high);
        }

        if (cmpLo <= 0 && cmpHi >= 0) q.add(x);

        if (cmpHi > 0){
            keys(x.getRight(), q, low, high);
        }

    }



    private static Node buildBinaryTree (int[] arr, int low, int high) {
        //System.out.println(low + ", " + high);

        if (high < 0 || low > high) {
            return null;
        }

        if (low == high){
            return new Node(arr[low]);
        }

        int mid = low + ((high - low) / 2);

        //System.out.println("\t" + low + ", " + high + ", " + mid);

        Node parent = new Node(arr[mid]);

        parent.setLeft(buildBinaryTree(arr, low, mid - 1));
        parent.setRight(buildBinaryTree(arr, mid + 1, high));

        return parent;
    }




}
