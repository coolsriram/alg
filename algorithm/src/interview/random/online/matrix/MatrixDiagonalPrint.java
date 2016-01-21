package interview.random.online.matrix;

/**
 * Created by selvarajs on 1/18/16.
 */
public class MatrixDiagonalPrint {
    public static void main(String[] args) {
        System.out.println("Diagonal print");
        // http://www.geeksforgeeks.org/print-matrix-diagonally/

        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };

        diagonalPrint(arr);
    }

    public static void diagonalPrint(int[][] arr){
        int rowMax = arr.length;
        int colMax = arr[0].length;

        //first go row & then col
        for (int r = 0; r < rowMax; r++) {
            diagonalPrint(arr, r, 0);
            System.out.println();
        }

        for (int c = 1; c < colMax; c++) {
            diagonalPrint(arr, rowMax - 1, c);
            System.out.println();
        }
    }

    private static void diagonalPrint(int[][] arr, int r, int c) {
        int rowMax = arr.length - 1;
        int colMax = arr[0].length - 1;

        if (r < 0 || c < 0 || r > rowMax || c > colMax){
            return;
        }

        System.out.print(arr[r][c] + " ");
        diagonalPrint(arr, r - 1, c + 1);
    }
}
