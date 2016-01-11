package interview.crack.dynamic;

/**
 * Created by selvarajs on 12/29/15.
 */
public class MagicIndex {

    public static void main(String[] args) {
        System.out.println("Magic Index");

        int[] arr = {-10, -3, +2, +2, +2, +3, +4, +8, 9, 12, 13};
        //             0   1   2   3   4   5   6   7  8   9  10

        boolean hasMagicInx = checkForMagicInxDistinct(arr);

        System.out.println("Magic inx present? " + hasMagicInx);
    }

    public static boolean checkForMagicInxDistinct(int[] arr){
        if (arr == null || arr.length == 0){
            return false;
        }

        boolean hasMagicInx = checkForMagicInxDistinct(arr, 0, arr.length - 1);

        return hasMagicInx;
    }

    public static boolean checkForMagicInxDistinct(int[] arr, int l, int h){
        if (h < l){
            return false;
        }

        int m = l + (h - l / 2);

        boolean hasMagicInx = false;

        if (arr[m] == m){
            hasMagicInx = true;
        } else if (arr[m] > m){
            hasMagicInx = checkForMagicInxDistinct(arr, l, m - 1);
        } else {
            hasMagicInx = checkForMagicInxDistinct(arr, m + 1, h);
        }

        return hasMagicInx;
    }
}
