package interview.random.online.dynamic;

import java.util.*;

/**
 * Created by selvarajs on 1/26/16.
 */
public class LongestCommonSubSeq {
    public static void main(String[] args) {
        System.out.println("Longest Common Subsequence");
        int arr[] = {2, 7, 3, 4, 9, 8, 12};

        System.out.println("Max: " + longestSubSeqBottomUp(arr));
    }

    public static int longestSubSeqBottomUp(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }

        int lSeq[] = new int[arr.length];

        lSeq[0] = 1;

        int n = arr.length;

        for (int i = 1; i < n; i++){
            int max = 0;

            for (int j = i - 1; j >= 0; j--){
                if (arr[i] > arr[j]){
                    max = (max > lSeq[j]) ? max : lSeq[j];
                }
            }

            lSeq[i] = 1 + max;
        }

        int valToReturn = 0;

        for (int cValue: lSeq){
            valToReturn = (valToReturn > cValue) ? valToReturn : cValue;
        }

        return valToReturn;
    }
}
