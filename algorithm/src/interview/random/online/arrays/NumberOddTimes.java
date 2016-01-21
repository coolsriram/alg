package interview.random.online.arrays;

/**
 * Created by selvarajs on 1/14/16.
 */
public class NumberOddTimes {
    public static void main(String[] args) {
        int a[] = {2,3,4,5,4,3,2,16,5};

        int result = 0;
        for (int n : a){
            result ^= n;
            System.out.println(n + ", " + result);
        }

        System.out.println(result);

        System.out.println(gcd(6, 12));
        System.out.println(gcd(12, 6));
    }

    private static int gcd(int a,int b)
    {
        if(b==0)
            return a;
        else
            return gcd(b, a%b);
    }


}
