package problems.online;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selvarajs on 1/7/16.
 */
public class MinCostPath {
    public static void main(String[] args) {
        System.out.println("Min Cost Path");

        int arr[][]= {
                {1,  2, 3, 3},
                {4,  8, 9, 11},
                {1,  5, 3, 12},
                {1,  5, 3, 2},
        };

        int buf[][] = new int[arr.length][arr[0].length];

        for (int row = 0; row < buf.length; row++) {
            for (int col = 0; col < buf[row].length; col++){
                buf[row][col] = -1;
            }
        }

        ArrayList<Integer> path = new ArrayList<>();

        System.out.println("Min cost path: " + minCostPath(arr, arr.length - 1, arr[0].length - 1, buf, path));

        System.out.println("Saved: " + saved);

        System.out.println(path);
    }

    static int saved = 0;

    private static int minCostPath(int arr[][], int row, int col, int[][] buffer, List<Integer> path) {

        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }

        if (row == 0 && col == 0){
            return arr[row][col];
        }

        if (buffer[row][col] != -1) {
            saved++;
            return buffer[row][col];
        }

        int costGoingUp = 0, costGoingLeft = 0, costGoingDiagonalLeftUp = 0;
        int curColVal = arr[row][col];

        // Calculate the min cost in 3 ways
        costGoingUp = minCostPath(arr, row - 1, col, buffer, path);
        costGoingUp = (costGoingUp == Integer.MAX_VALUE) ? costGoingUp : costGoingUp + curColVal;

        costGoingLeft = minCostPath(arr, row, col - 1, buffer, path);
        costGoingLeft = (costGoingLeft == Integer.MAX_VALUE) ? costGoingLeft : costGoingLeft + curColVal;

        costGoingDiagonalLeftUp = minCostPath(arr, row - 1, col - 1, buffer, path);
        costGoingDiagonalLeftUp = (costGoingDiagonalLeftUp == Integer.MAX_VALUE) ? costGoingDiagonalLeftUp : costGoingDiagonalLeftUp + curColVal;

        int minCost = Math.min(costGoingUp, costGoingLeft);

        minCost = Math.min(minCost, costGoingDiagonalLeftUp);

        buffer[row][col] = minCost;

        return minCost;
    }
}
