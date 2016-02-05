package interview.random.online.dynamic;

/**
 * Created by selvarajs on 1/27/16.
 */
public class MaxSumIncrSubSeq {
    public static void main(String[] args) {
        System.out.println("Max Sum Sub Seq");

        int[] arr = {1, 101, 2, 3, 100, 4, 5};
//        int[] arr = {4, 3, 2, 1};

        System.out.println("Max: " + maxSumBrute(arr, 1, arr[0]));
    }

    public static int maxSumBrute(int arr[], int index, int highNo){
        if (index == arr.length){
            return 0;
        }

        if (arr[index] < highNo){ // 3, 2 . skip and move on to next one
            return maxSumBrute(arr, index + 1, highNo);
        }

        int val = Math.max(arr[index] + maxSumBrute(arr, index + 1, arr[index]),
                highNo + maxSumBrute(arr, index + 1, highNo));

        return val;
    }
}
