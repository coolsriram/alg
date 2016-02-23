package problems.online;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by selvarajs on 2/22/16.
 */
public class ShuffleCard {
    public static void main(String[] args) {
        int arr[] = new int[20];

        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }

        shuffle(arr);

        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void shuffle(int[] arr){
        int l = arr.length;

        for (int i = 0; i < l; i++){
            int r = ThreadLocalRandom.current().nextInt(i, l);

            int t = arr[r];
            arr[r] = arr[i];
            arr[i] = t;
        }
    }
}
