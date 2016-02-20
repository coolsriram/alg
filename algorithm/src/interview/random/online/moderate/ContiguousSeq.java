package interview.random.online.moderate;

/**
 * Created by selvarajs on 2/5/16.
 */
public class ContiguousSeq {
    public static void main(String[] args) {
        int[] arr = {2, -8, 3, -2, 4, -10};

        arr = new int[]{-1, 2, 3, -1, 1, -8, 6};
        System.out.println(findMaxSum(arr));
    }

    public static int findMaxSum(int[] arr){
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("Invalid input list");
        }

        int sum = arr[0];
        int max = sum;

        for (int i = 0; i < arr.length; i++){
            if (sum < 0 && arr[i] > 0){
                sum = arr[i];
            } else {
                sum += arr[i];
            }

            if (max < sum){
                max = sum;
            }
        }

        return max;
    }
}
