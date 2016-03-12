package interview.random.online.tree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by selvarajs on 3/3/16.
 */
public class BTreeBST implements Serializable{
    public static void main(String[] args) {
        int[] arr = {1,20,31,34,45,  56, 88, 90,91,92,93,94,95,96,97};

        Node root = BuildBinaryTree.buildBinaryTree(arr);

        printLevel(root, 2, 3);

        System.out.println("\n\n");

        BinaryTreeUtil.printInOrder(root);

    }

    public static void printLevel(Node n, int low, int high){
        if (n == null)
            return;

        Queue<Node> cur = new LinkedList<>();
        Queue<Node> next = new LinkedList<>();

        cur.add(n);
        int level = 1;

        while (!cur.isEmpty()){
            Node x = cur.remove();

            if (level >= low && level <= high) {
                System.out.print(x.getValue() + "\t");
            }

            if (x.getLeft() != null){
                next.add(x.getLeft());
            }

            if (x.getRight() != null){
                next.add(x.getRight());
            }

            // If its last item in cur
            if (cur.isEmpty() && !next.isEmpty()){
                cur.addAll(next);
                next.clear();;
                if (level >= low && level <= high) {
                    System.out.println();
                }
                level++;
            }
        }
    }
}
