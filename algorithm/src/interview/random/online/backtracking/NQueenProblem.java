package interview.random.online.backtracking;

/**
 * Created by selvarajs on 1/21/16.
 */
public class NQueenProblem {
    public static void main(String[] args) {
        System.out.println("N Queen problem");

        for (int n = 1; n <= 9; n++) {
            int arr[][] = new int[n][n];

            System.out.println("\n\t\tPlacement for " + n);
            if (placeQueen(arr, 0)) {
                printMatrix(arr);
                System.out.println();
            } else {
                System.out.println("\nUnable to find placements for " + n);
            }
        }
    }

    public static boolean placeQueen(int[][] sol, int row){
        final int rMax = sol.length;
        final int cMax = sol[0].length;

        for (int c = 0; c < cMax; c++){
            sol[row][c] = 1;

            if (isValidPlacement(sol, row, c)){
                if (row == rMax - 1 || placeQueen(sol, row + 1)){
                    return true;
                }
            }

            sol[row][c] = 0;
        }

        // if it made it to here, then its a miss
        return false;
    }

    private static boolean isValidPlacement(int[][] sol, int rowToChk, int colToChk) {
        // we are moving in top down way. So just have to check up

        int rMax = sol.length;
        int cMax = sol[0].length;

        // check up
        for (int cRow = rowToChk - 1; cRow >= 0; cRow--){
            if (cRow >= 0 && cRow < rMax && sol[cRow][colToChk] == 1){
                return false;
            }
        }

        // check diagonal up right

        for (int cRow = rowToChk - 1, cCol = colToChk + 1; cRow >= 0 && cCol < cMax; cRow--, cCol++){
            if (cRow >= 0 && cRow < rMax && cCol >= 0 && cCol < cMax && sol[cRow][cCol] == 1){
                return false;
            }
        }

        // check diagonal up left

        for (int cRow = rowToChk - 1, cCol = colToChk - 1; cRow >= 0 && cCol >= 0; cRow--, cCol--){
            if (cRow >= 0 && cRow < rMax && cCol >= 0 && cCol < cMax && sol[cRow][cCol] == 1){
                return false;
            }
        }

        return true;
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
