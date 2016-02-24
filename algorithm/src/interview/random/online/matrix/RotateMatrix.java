package interview.random.online.matrix;

/**
 * Created by selvarajs on 2/23/16.
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                { 0,  1,  2,  3,  4},
                { 5,  6,  7,  8,  9},
                {10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24}
        };

        printMatrix(arr);
        rotateInPlace(arr);
        System.out.println("After rotating");
        printMatrix(arr);

    }

    public static void rotateInPlace(int[][] arr){

        // nxn matrix
        int n = arr.length;

        for (int i = 0; i <= n/2; i++){

            for (int j = i; j < n -i -1; j++){
                int top = arr[i][j];
                arr[i][j] = arr[n-1-j][i];
                arr[n-1-j][i] = arr[n-1-i][n-1-j];
                arr[n-1-i][n-1-j] = arr[j][n-i-1];
                arr[j][n-i-1] = top;
            }
        }
    }

    public static void printMatrix(int[][] arr){
        System.out.println("\n\n");
        int n = arr.length;

        for (int i = 0; i < n; i++){
            System.out.println("\n");

            for (int j = 0; j < n; j++){
                System.out.print("\t" + arr[i][j]);
            }
        }
    }
}
