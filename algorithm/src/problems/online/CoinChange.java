package problems.online;

/**
 * Created by selvarajs on 1/8/16.
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println("Coin change");

        System.out.println(count(new int[]{1,2,3, 5}, 4, 5));
    }

    private static int count( int S[], int m, int n )
    {
        // If n is 0 then there is 1 solution (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n is greater than 0, then no solution exist
        if (m <=0 && n >= 1)
            return 0;

        // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
        return count( S, m - 1, n ) + count( S, m, n-S[m-1] );
    }
}
