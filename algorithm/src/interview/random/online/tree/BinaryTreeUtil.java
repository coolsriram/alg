package interview.random.online.tree;

/**
 * Created by selvarajs on 1/10/16.
 */
public class BinaryTreeUtil {
    public static void printInOrder(Node root){
        if (root == null) {
            return;
        }

        printInOrder(root.getLeft());
        System.out.print("\t" + root.getValue());
        printInOrder(root.getRight());
    }

    public static int maxTreeDept(Node root){

        if (root == null){
            return 0;
        }

        return 1 + Math.max(maxTreeDept(root.getLeft()), maxTreeDept(root.getRight()));
    }
}
