package interview.random.online.moderate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by selvarajs on 2/4/16.
 */
public class NumberToWord {

    private static final String[] units = {"", "One", "Two", "Three", "Four" ,"Five" ,"Six" ,"Seven" ,"Eight" ,"Nine" ,
            "Ten" ,"Eleven" ,"Twelve" ,"Thirteen" ,"Fourteen" ,"Fifteen" ,"Sixteen" ,"Seventeen" ,"Eighteen",
            "Nineteen" ,"Twenty"};

    private static final String[] tenth = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety"};

    private static final String[] value = {"Hundred", "Thousand", "Million", "Billion", "Trillion"};

    public static void main(String[] args) {

        long num = 953700000L;
        int n = 2147;
        System.out.println("Conversion for " + num + "\n");
        System.out.println(convertToWords(num));
    }

    public static String convertToWords(long num){
        Stack<String> values = new Stack<>();
        int valueCnt = 1;

        int t = (int) num % 1000;

        String ts = handleHundreds(t);

        if (ts != null && ts.trim().length() > 0){
            values.push(ts);
        }

        t = (int) num / 1000;

        while (t > 0){
            ts = handleHundreds(t % 1000);

            if (ts.length() > 0){
                values.push(ts + " " + value[valueCnt]);
            }

            valueCnt++;

            t = t / 1000;
        }

        StringBuffer result = new StringBuffer();

        while (!values.isEmpty()){
            result.append(values.pop()).append(" ");
        }

        return result.toString();
    }

    private static String handleHundreds(int num){
        StringBuffer s = new StringBuffer();

        int t = num / 100;
        boolean isHundredPresent = false;

        if (t > 0){
            s.append(units[t]).append(" ").append(value[0]).append(" ");
            isHundredPresent = true;
        }

        t = num % 100;

        /*if (t > 0 && isHundredPresent){
            s.append(" And ");
        }*/

        if (t > 0 && t < 20){
            s.append(units[t]);
        } else {
            s.append(tenth[t/10]).append(" ").append(units[t%10]);
        }

        return s.toString();
    }
}
