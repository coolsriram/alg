package problems.online;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selvarajs on 2/23/16.
 */
public class LongestIncreasingSubswq {
    public static void main(String[] args) {
        int arr[] = {10, 11, 12, 13, 21, 50, 41, 60, 80, 90};

        System.out.println(lis(arr));

    }

    public static int lis(int[] arr){
        int maxSub = 0;
        List<Integer> maxList = new ArrayList<>();

        int n = arr.length;

        for (int i = 0; i < n; i++){

            for (int k = i + 1; k < n; k++) {
                int cSub = 0;
                int prevL = arr[i];
                List<Integer> curList = new ArrayList<>();
                curList.add(arr[i]);

                for (int j = k; j < n; j++) {
                    if (arr[j] > prevL) {
                        cSub++;
                        prevL = arr[j];
                        curList.add(prevL);
                    }
                }

                if (cSub > maxSub) {
                    maxSub = cSub;
                    maxList = curList;
                }
            }
        }

        System.out.println(maxList);
        return maxSub;
    }
}
