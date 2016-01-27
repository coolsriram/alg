package interview.random.online.dynamic;

import java.util.Arrays;

/**
 * Created by selvarajs on 1/26/16.
 */
public class LeastCommonSubStr {
    public static void main(String[] args) {
        System.out.println("Least Common Substring");

        String s1 = "ABCDGH";
        String s2 = "AEDGHR";

        int[][] buff = new int[s1.length()][s2.length()];

        for (int[] cRow: buff){
            Arrays.fill(cRow, -1);
        }

        int value = lcs(s1, s2, 0, 0, buff);

        System.out.println("LCS: " + value);
        System.out.println("Count: " + count);
    }

    static int count = 0;

    public static int lcs(String s1, String s2, int inx1, int inx2, int[][] buff){
        if (s1.length() == inx1 || s2.length() == inx2){
            return 0;
        }

        if (buff[inx1][inx2] != -1){
            return buff[inx1][inx2];
        }

        int value = 0;

        count++;

        if (s1.charAt(inx1) == s2.charAt(inx2)){
            value = 1 + lcs(s1, s2, inx1 + 1, inx2 + 1, buff);
        } else {
            value = Math.max(lcs(s1, s2, inx1, inx2 + 1, buff), lcs(s1, s2, inx1 + 1, inx2, buff));
        }

        buff[inx1][inx2] = value;

        return value;
    }
}
