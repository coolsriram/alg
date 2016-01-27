package interview.random.online.dynamic;

/**
 * Created by selvarajs on 1/26/16.
 */
public class MinNoCoins {
    public static void main(String[] args) {
        System.out.println("Minimum no of coins");

        int money[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};

        int minCoins = calculateMinCoins(70, money);

        System.out.println("Minimum coins : " + minCoins);
    }

    private static int calculateMinCoins(int value, int[] money){
        int noOfCoins = 0;

        int bal = value;

        for (int cValue = money.length - 1; cValue >= 0 && bal > 0; cValue--){
            noOfCoins += bal/money[cValue];

            bal %= money[cValue];
        }

        return noOfCoins;
    }


}
