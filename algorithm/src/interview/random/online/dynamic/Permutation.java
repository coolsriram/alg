package interview.random.online.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selvarajs on 2/19/16.
 */
public class Permutation {

    public static void main(String[] args) {
        String str = "abc";

        List<String> l = new ArrayList<>();

        //getPerm(str.toCharArray(), 0, l);

        l = getPermIteration(str);

        System.out.println(l);
        System.out.println(l.size());
    }

    public static List<String> getPermIteration(String s){
        List<String> res = new ArrayList<>();

        res.add("");

        for (int i = 0; i < s.length(); i++){
            List<String> tempL = new ArrayList<>();

            for (String ls: res){
                for (int j = 0; j <= ls.length(); j++){
                    tempL.add(ls.substring(0, j) + s.charAt(i) + ls.substring(j));
                }
            }

            // For subset, u dont need a inner loop to add in each position
//            res.addAll(tempL);

            // For permutation
            res = tempL;
        }

        return res;
    }

    public static void getPerm(char[] str, int ix, List<String> l){

        if (ix == str.length){
            l.add(String.valueOf(str));
            return;
        }

        for (int i = ix; i < str.length; i++){
            swap(str, ix, i);
            getPerm(str, ix + 1, l);;
            swap(str, ix, i);
        }
    }

    private static void swap(char[] str, int ix, int i) {
        char t = str[ix];
        str[ix] = str[i];
        str[i] = t;
    }
}
