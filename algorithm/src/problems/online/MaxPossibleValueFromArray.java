package problems.online;

/**
 * Created by selvarajs on 1/8/16.
 */
public class MaxPossibleValueFromArray {
    public static void main(String[] args) {
        System.out.println("MaxPossibleFromArray");
        // {10, 20, 30, 50}, N = 45, result = 40 (10+30)

        int[] arr = new int[]{10, 20, 30, 3, 50, 1};

        System.out.println(maxPossibleValue(arr, arr.length - 1, 25));
        System.out.println(count);
    }

    static int count = 0;
    public static int maxPossibleValue(int[] arr, int index, int N) {
        count++;
        if (index < 0 && N > 0) {
            return 0;
        }

        if (N <= 0) {
            return 0;
        }

        if (arr[index] > N) {
            return maxPossibleValue(arr, index - 1, N);
        }

        return arr[index] + maxPossibleValue(arr, index - 1, N - arr[index]);
    }
}
