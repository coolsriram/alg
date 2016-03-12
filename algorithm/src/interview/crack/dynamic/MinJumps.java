package interview.crack.dynamic;

/**
 * Created by selvarajs on 3/3/16.
 */
public class MinJumps {
    public static void main(String[] args) {
        // http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
        int[] arr = {2,3,1,1,2,4,2,0,1,1};

        System.out.println(getMinJump(arr));

    }

    public static int getMinJump(int[] arr){
        int n = arr.length;

        int[] buf = new int[n];

        for (int i = n - 2; i >=0; i--){
            buf[i] = Math.min(1 + jump(arr[i], n - 1 - i),
                    minS(arr, i, buf));
        }

        return buf[0];
    }

    private static int jump(int x, int y){
        return (x == y) ? 0 : Integer.MAX_VALUE - 1;
    }

    private static int minS(int[] arr, int x, int[] buf){
        int min = 0;
        int n = arr.length;

        for (int i = x + 1; i < n - 2 && i <= ( x + 1 + arr[i]); i++){
            if (buf[i] != 0){
                min = Math.min(min, buf[i]);
            }
        }

        System.out.println("Pos: " + x + ", min " + min);
        return min;
    }
}
