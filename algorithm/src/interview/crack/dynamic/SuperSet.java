package interview.crack.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selvarajs on 3/3/16.
 */
public class SuperSet {
    public static void main(String[] args) {
        // Power set
        char[] arr = {'a', 'b', 'c'};

        System.out.println(powerSet(arr));
    }


    public static List<String> powerSet(char[] arr){
        List<String> l = new ArrayList<>();
        l.add("");

        for (char c: arr){
            List<String> nl = new ArrayList<>();

            for (String s: l){
                nl.add(c + s);
            }

            //l.addAll(nl);
            l = nl;
        }

        return l;
    }
}

