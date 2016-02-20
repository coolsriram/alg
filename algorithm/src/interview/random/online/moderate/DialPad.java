package interview.random.online.moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by selvarajs on 2/20/16.
 */
public class DialPad {
    // Dial pad is a combination problem

    public static void main(String[] args) {
        List<String> res = dialPad("123");
        System.out.println(res);
        System.out.println(res.size());
    }

    public static List<String> dialPad(String d) {
        List<String> res = new ArrayList<>();
        res.add("");

        for (int i = 0; i < d.length(); i++){
            List<String> tempL = new ArrayList<>();

            String l = map.get(d.charAt(i));

            for (int j = 0; j < l.length(); j++){
                for (String s: res){
                    tempL.add(s + l.charAt(j));
                }
            }

            if (tempL.size() > 0) {
                res = tempL;
            }
        }

        return res;
    }

    static HashMap<Character, String> map = new HashMap<>(8);

    static {
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    ;
}
