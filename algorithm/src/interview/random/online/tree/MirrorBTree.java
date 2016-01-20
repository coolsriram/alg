package interview.random.online.tree;

import java.util.List;

/**
 * Created by selvarajs on 1/13/16.
 */
public class MirrorBTree {
    public static void main(String[] args) {
        //Mirror image a given binary tree
        System.out.println("Mirror BTree");

        int[] arr = {1,20,31,34,45,  56, 88};

        Node root = BuildBinaryTree.buildBinaryTree(arr);

        List<List<Node>> listInOrder = PopulateListsForTreeDepth.listForDepth(root);

        System.out.println("\nBefore mirror\n");
        System.out.println(listInOrder);

        mirrorBTree(root);

        listInOrder = PopulateListsForTreeDepth.listForDepth(root);

        System.out.println("\nAfter mirror\n");
        System.out.println(listInOrder);

    }

    public static void mirrorBTree(Node node) {
        if (node == null) return;

        Node left = node.getLeft();
        Node right = node.getRight();

        node.setLeft(right);
        node.setRight(left);

        mirrorBTree(left);
        mirrorBTree(right);
    }
}
