package interview.random.online.backtracking;

import java.util.Arrays;

/**
 * Created by selvarajs on 1/20/16.
 */
public class RatInAMaze {

    public static void main(String[] args) {
        System.out.println("Rat in a maze");

        int[][] arr = {
                {1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 0, 1},
                {0, 0, 0, 1, 0, 1},
                {0, 1, 1, 1, 1, 1}
        };

        int[][] sol = new int[arr.length][arr[0].length];

        for (int[] curRow: sol){
            Arrays.fill(curRow, 0);
        }

        boolean isSolved = checkRatMaze(0, 0, sol, arr, arr.length - 1, arr[0].length - 1);

        if (isSolved){
            System.out.println("Found a path");
            printMatrix(sol);
        } else {
            System.out.println("Unable to find the solution");
        }
    }

    public static boolean checkRatMaze(int r, int c, int sol[][], int arr[][], int er, int ec){
        if ((r > arr.length - 1 || c > arr[0].length - 1) || arr[r][c] == 0){
            return false;
        }

        sol[r][c] = 1;

        if (r == er && c == ec){
            return true;
        }

        // Move down
        boolean isSolved = checkRatMaze(r + 1, c, sol, arr, er, ec);

        if (!isSolved){
            // Move right
            isSolved = checkRatMaze(r, c + 1, sol, arr, er, ec);
        }

        if (!isSolved){
            sol[r][c] = 0;
        }

        return isSolved;
    }

    public static void printMatrix(int[][] arr){
        if (arr == null){
            return;
        }

        for (int[] row: arr){
            System.out.println();
            for (int item: row){
                System.out.print(item + "\t");
            }
        }
    }
}
