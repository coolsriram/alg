package interview.crack.dynamic;

/**
 * Created by selvarajs on 2/25/16.
 */
public class CoinChangeWithCombination {

    public static void main(String[] args) {
        int n = 50;
        int k = 3;
        int[] memory = new int[n+1];

        System.out.println(countWays(n, k, memory));
    }


    public static int countWays(int n, int k, int[] memory) {
        if (n < 0) {
            return 0; // negative, so don’t count this
        }
        if (n == 0) {
            return 1; // 0, so return this as valid way 1
        }

        if(memory[n-1] > 0) { return memory[n-1]; }

        int res = 0;
        for (int i = 1; i <= k; i++) {
            res += countWays(n - i, k, memory);
        }

        memory[n-1] = res;
        return res;
    }
}
