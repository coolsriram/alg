package interview.random.online.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by selvarajs on 1/27/16.
 */
public class CuttingRod {
    public static void main(String[] args) {
        System.out.println("Cutting rod");

        int[] length = {1, 2, 3, 4}; //, 5, 6, 7, 8, 9};
        int[] price = {2, 5, 7, 8}; //, 10, 17, 17, 20, 21};

        Map<String, Integer> buff = new HashMap<>();

        System.out.println("Max price: " + cutBrute(length, price, length.length - 1, 5, buff));
        System.out.println("Count: " + count);
    }

    static int count = 0;

    public static int cutBrute(int[] length, int[] price, int lInx, int balLength, Map<String, Integer> buff ){

        if (lInx < 0 || balLength <= 0){
            return 0;
        }

        if (balLength < length[lInx]){
            return cutBrute(length, price, lInx - 1, balLength, buff);
        }

        String buffKey = new StringBuffer().append(lInx).append("_").append(balLength).toString();

        if (buff.containsKey(buffKey)){
            return buff.get(buffKey);

        }
        count++;
        int val1 = price[lInx] + cutBrute(length, price, lInx, balLength - length[lInx], buff);

        int val2 = cutBrute(length, price, lInx - 1, balLength, buff);

        int max = Math.max(val1, val2);;

        buff.put(buffKey, max);

        return max;
    }
}
