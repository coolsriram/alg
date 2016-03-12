package interview.random.online.tree;

/**
 * Created by selvarajs on 3/7/16.
 */
public class SegmentMinTree {
        // From tushar's video

    public static void main(String[] args) {
        int[] input = new int[]{-1, 2, 4, 0, 1, 3, 5, -2};

        int n = nearestP2(input.length) * 2 - 1;
        int[] sTree = new int[n];

        constructTree(input, sTree, 0, input.length - 1, 0);

        int min = queryMinSegTree(sTree, 2, 4, 0, input.length - 1, 0);

        System.out.println("Minimum: " + min);
    }

    public static void constructTree(int[] input, int[] sTree, int l, int h, int p){
        if (l == h){
            sTree[p] = input[l];
            return;
        }

        int m = (l + h)/2;

        constructTree(input, sTree, l, m, 2*p + 1);
        constructTree(input, sTree, m + 1, h, 2*p + 2);

        sTree[p] = Math.min(sTree[2*p + 1], sTree[2*p+2]);
    }

    public static int queryMinSegTree(int[] sTree, int qLow, int qHigh, int l, int h, int p){
        if (qLow <= l && qHigh >= h){
            return sTree[p];
        }

        if (qLow > h || qHigh < l){
            return  Integer.MAX_VALUE;
        }

        int m = (l + h)/ 2;

        return Math.min(queryMinSegTree(sTree, qLow, qHigh, l, m, 2*p + 1),
                queryMinSegTree(sTree, qLow, qHigh,m+1, h, 2*p+2));
    }

    private static int nearestP2(int num){
        int cnt = 1;

        while (num > cnt){
            cnt *= 2;
        }

        return cnt;
    }
}
