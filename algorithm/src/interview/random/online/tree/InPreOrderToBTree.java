package interview.random.online.tree;

/**
 * Created by selvarajs on 3/7/16.
 */
public class InPreOrderToBTree {
    private int pInx;

    public InPreOrderToBTree(){

    }

    public static void main(String[] args) {
        char[] in = {'d', 'b', 'e', 'a', 'f', 'c'};
        char[] pre = {'a', 'b', 'd', 'e', 'c', 'f'};
        char[] post = {'d', 'e', 'b', 'f', 'c', 'a'};

        TNode<Character> node = new InPreOrderToBTree().buildBTree(pre, in);

        new InPreOrderToBTree().printInOrder(node);
    }

    public TNode<Character> buildBTree(char[] pre, char[] in){
        pInx = 0;
        TNode<Character> root = buildBTree(pre, in, 0, pre.length - 1);
        return root;
    }

    private TNode<Character> buildBTree(char[] pre, char[] in, int l, int h){
        if (l > h){
            return null;
        }

        TNode<Character> n = new TNode<>(pre[pInx++]);

        if (l == h){
            return n;
        }

        int i = findIndex(in, l, h, n.data);

        n.left = buildBTree(pre, in, l, i - 1);
        n.right = buildBTree(pre, in, i + 1, h);

        return n;
    }

    private int findIndex(char[] in, int l, int h, Character data) {
        int i = l;

        for (; i <= h; i++){
            if (in[i] == data.charValue()){
                break;
            }
        }

        return i;
    }

    private void printInOrder(TNode node){
        if (node == null){
            return;
        }

        printInOrder(node.left);
        System.out.print(node.data + "\t");
        printInOrder(node.right);
    }
}

class TNode<T>{
    public T data;
    public TNode<T> left;
    public TNode<T> right;

    public TNode(T data){
        this.data = data;
    }
}
