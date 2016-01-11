package interview.random.online.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selvarajs on 1/10/16.
 */
public class PopulateListsForTreeDepth {
    public static void main(String[] args) {
        // 4.3 cracking interview
        // List of lists for nodes in each depth of the tree

        // Make tree
        int[] arr = {1,22,3,4,5,6,7,8,9,10,13,15,18,20,22,24};

        Node root = BuildBinaryTree.buildBinaryTree(arr);

        List<List<Node>> listsOfLists = listForDepth(root);

        System.out.println("Tree Depth: " + listsOfLists.size());

        for (List<Node> curList: listsOfLists) {
            System.out.println(curList);
        }
    }

    public static List<List<Node>> listForDepth (Node root) {
        List<List<Node>> depthList = new ArrayList<>();


        populateListForDepth(root, depthList, 0);

        return depthList;
    }

    private static void populateListForDepth(Node node, List<List<Node>> listsOfList, int depth) {
        if (node == null) {
            return;
        }

        List<Node> curList = null;

        if (depth == listsOfList.size()) {
            // create a new one.
            listsOfList.add(new ArrayList<Node>());
        }

        curList = listsOfList.get(depth);

        curList.add(node);

        /*
        if (node.getLeft() != null){
            curList.add(node.getLeft());
        }

        if (node.getRight() != null){
            curList.add(node.getRight());
        }
        */

        populateListForDepth(node.getLeft(), listsOfList, depth + 1);
        populateListForDepth(node.getRight(), listsOfList, depth + 1);
    }

}
