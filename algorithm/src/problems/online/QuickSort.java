package problems.online;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by selvarajs on 2/22/16.
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {7, 15, 4, 1, 3, 2};

        sort(arr, 0, arr.length - 1);

        for (int n: arr){
            System.out.print(n +  " ");
        }
    }

    private static int partition(int arr[], int l, int h){
        int i = l;
        int j = h + 1;
        int v = arr[l];

        while (true){
            while (arr[++i] < v) {
                if (i == h) {
                    break;
                }
            }

            while (arr[--j] > v){
                if (j == l){
                    break;
                }
            }

            if (i >= j){
                break;
            }

            exch(arr, i, j);
        }

        exch (arr, l, j);

        return j;
    }

    public static void sort(int arr[], int l, int h){
        if (l >= h) return;

        int p = partition(arr, l, h);

        sort(arr, l, p - 1);
        sort(arr, p + 1, h);
    }

    private static void exch(int[] arr, int l, int r) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }


}
