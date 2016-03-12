package problems.online;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by selvarajs on 3/7/16.
 */
public class MaxInSubArraySizeK {
    // Using DQ, http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/

    public static void main(String[] args) {
        int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};

        printMaxInSubArray(arr, 3);
    }

    public static void printMaxInSubArray (int[] arr, int k){
        int i = 0;

        LinkedList<Integer> dq = new LinkedList<>();

        // Process k items
        for (; i < k; i++){
            validateAndAddToQ(dq, arr, i);
        }

        // Process rest of items
        for (; i < arr.length; i++){
            int n = dq.peekFirst();

            System.out.println(arr[n]);

            while (!dq.isEmpty() && dq.peekFirst() <= (i-k)){
                dq.removeFirst();
            }

            validateAndAddToQ(dq, arr, i);
        }

        System.out.println(arr[dq.peekFirst()]);
    }

    private  static void validateAndAddToQ(Deque<Integer> dq, int[] arr, int i){
        while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
            dq.removeLast();
        }

        dq.addLast(i);
    }
}
