package interview.random.online.moderate;

/**
 * Created by selvarajs on 2/4/16.
 */
public class DivingBoard {
    public static void main(String[] args) {
        int s = 3;
        int l = 5;
        int k = 3;

        System.out.println("Lengths are ");
        printLengths(s, l, k);
    }

    public static void printLengths(int s, int l, int k){

        for (int i = 0; i <= k; i++){
            System.out.println((Math.pow(s, k - i) * Math.pow(l, i)));
        }
    }
}
