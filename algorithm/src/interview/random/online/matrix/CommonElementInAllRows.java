package interview.random.online.matrix;

import java.util.Arrays;
import java.util.jar.Pack200;

/**
 * Created by selvarajs on 1/19/16.
 */
public class CommonElementInAllRows {
    public static void main(String[] args) {
        int arr[][] = {
                {1, 2, 14, 15, 16},
                {1, 4, 5, 7,  8},
                {1, 5, 8, 9, 10},
                {1, 5, 6, 7,  8}
        };

        printCommonELementInAllRows(arr);
    }

    public static void printCommonELementInAllRows(int[][] arr){
        int rMax = arr.length;
        int cMax = arr[0].length;

        int[] cols = new int[rMax];

        Arrays.fill(cols, cMax - 1);

        int equalCount = 0;
        boolean isCommonElementFound = false;

        while (cols[0] >= 0){
            int noToCheck = arr[0][cols[0]];
            equalCount = 0;

            int minColInx = cols[0];

            for (int r = 1; r < rMax; r++) {
                int curCol = cols[r];

                while (curCol >= 0 && arr[r][curCol] > noToCheck){
                    curCol--;
                }

                minColInx = Math.min(minColInx, curCol);

                if (arr[r][curCol] == noToCheck){
                    equalCount++;
                }

                cols[r] = curCol;
            }

            if (equalCount == rMax - 1){
                System.out.println("Common element is " + noToCheck);
                isCommonElementFound = true;
                break;
            }

            if (minColInx == -1){
                break;
            }
            cols[0] -= 1;
        }

        if (!isCommonElementFound){
            System.out.println("No common element found");
        }
    }
}
