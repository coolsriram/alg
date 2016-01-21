package interview.random.online.arrays;

import java.util.Arrays;

/**
 * Created by selvarajs on 1/15/16.
 */
public class MaxSumSubseqNotConsequtive {
    public static void main(String[] args) {
        // {3,2,7,10} op - 13 (3, 10)
        // {3, 2, 5, 10, 7}, op - 15 (3,5,10)

        int[] arr = {3, 2, 5, 10, 7};

        //memoization
        int[] sumFrom = new int[arr.length];

        Arrays.fill(sumFrom, -1);

        System.out.println(calcMaxSum(arr, 0, arr.length - 1, sumFrom));

    }

    public static int calcMaxSum (int[] arr, int l, int h, int[] sumFrom){

        if (l > h) return 0;

        if (l == h) return arr[l];

        if (sumFrom[l] != -1) {
            return sumFrom[l];
        }

        sumFrom[l] = Math.max( (arr[l] + calcMaxSum(arr, l + 2, h, sumFrom)), calcMaxSum(arr, l + 1, h, sumFrom));

        return sumFrom[l];
    }
}
