package interview.random.online.matrix;

import java.util.Arrays;

/**
 * Created by selvarajs on 1/19/16.
 */
public class LongestConseqCharMatrix {

    public static void main(String[] args) {
        // Longest char consecutive path cnt for a given starting char
        // char can go all 8 ways

        char[][] arr = {
                {'a', 'c', 'd'},
                {'h', 'b', 'e'},
                {'i', 'g', 'f'}
        };

        int[][] buff = new int[arr.length][arr[0].length];

        for (int[] curRow : buff){
            Arrays.fill(curRow, -1);
        }



        System.out.println(getLongestConsecutiveCount(arr, 'b', 1, 1, buff));
        System.out.println("Count: " + count);
    }

    static int count = 0;

    public static int getLongestConsecutiveCount(char[][] arr, char charToChk, int row, int col, int[][] buff){

        int rMax = arr.length;
        int cMax = arr[0].length;

        if (charToChk > 'z' || row < 0 || col < 0 || row == rMax || col == cMax){
            return 0;
        }

        if (arr[row][col] != charToChk){
            return 0;
        }

        Arrays.fill(arr[0], 'c');

        count++;

        char nextChar = (char)(charToChk + 1);
        return 1 + max(
                getLongestConsecutiveCount(arr, nextChar, row - 1, col - 1, buff),
                getLongestConsecutiveCount(arr, nextChar, row - 1, col, buff),
                getLongestConsecutiveCount(arr, nextChar, row - 1, col + 1, buff),
                getLongestConsecutiveCount(arr, nextChar, row, col - 1, buff),
                getLongestConsecutiveCount(arr, nextChar, row, col + 1, buff),
                getLongestConsecutiveCount(arr, nextChar, row + 1, col - 1, buff),
                getLongestConsecutiveCount(arr, nextChar, row + 1, col, buff),
                getLongestConsecutiveCount(arr, nextChar, row + 1, col + 1, buff)
                );
    }

    private static int max(int... nos){
        int max = -1;

        for (int curNum : nos){
            max = (max < curNum) ? curNum : max;
        }

        return max;
    }
}
