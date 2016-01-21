package interview.random.online.arrays;

/**
 * Created by selvarajs on 1/16/16.
 */
public class SegregateBinaries {
    public static void main(String[] args) {
        //Segregate 0s & 1s,
        // http://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/

        int[] arr = {0, 0, 1, 1, 0, 1, 0, 1, 0};

        printArray(arr);

        segregate(arr);

        printArray(arr);
    }

    public static void segregate(int[] arr){
        int l = 0;
        int r = arr.length - 1;
        int length = arr.length;

        while (l < r) {
            while (l < length && arr[l] != 1) l++;

            while (r >= 0 && arr[r] != 0) r--;

            if (l < r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
    }

    private static void printArray(int[] arr){
        System.out.println("\n\n");

        for (int x: arr) {
            System.out.print(x + ", ");
        }

        System.out.println("\n");
    }
}
