package interview.random.online.arrays;

/**
 * Created by selvarajs on 1/17/16.
 */
public class DuplicateInArrary {
    public static void main(String[] args) {
        // http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
        // Repeating elements in array 1 - n, 2 elements repeat twice, so arr size is n + 2
        int[] arr = {4, 2, 1, 5, 3, 3, 5};

        printDuplicateItems(arr, 5);
    }

    public static void printDuplicateItems(int[] arr, int n){
        int i = 0;

        while ( i < n + 2){
            if (arr[i] <= 0) {
                i++;
                continue;
            }

            int curEle = arr[i] - 1;

            if (arr[curEle] < 0){
                arr[curEle] --;
                arr[i] = 0;
                i++;
                continue;
            }

            arr[i] = arr[curEle];
            arr[curEle] = -1;
        }

        i = 0;

        while (i < n){
            if (arr[i] == -2){
                System.out.print(i+1 + "\t");
            }
            i++;
        }
    }



}
