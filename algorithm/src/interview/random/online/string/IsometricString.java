package interview.random.online.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by selvarajs on 2/1/16.
 */
public class IsometricString {
    public static void main(String[] args) {
        // http://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-each-other/
        String str1 = "abcefac";
        String str2 = "klmnokm";

        boolean isIsomorphic = isIsomorphic(str1, str2);

        System.out.println("Is given string isomorphic: " + isIsomorphic);
    }

    public static boolean isIsomorphic(String str1, String str2){
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0 || str1.length() != str2.length()){
            return false;
        }

        Map<Character, Character> mapping = new HashMap<>();

        char c1 = str1.charAt(0);
        char c2 = str2.charAt(0);
        mapping.put(c1, c2);

        for (int inx = 1; inx < str1.length(); inx++){
            c1 = str1.charAt(inx);
            c2 = str2.charAt(inx);

            if (mapping.containsKey(c1)){
                if (mapping.get(c1) != c2){
                    return false;
                }
            } else {
                mapping.put(c1, c2);
            }
        }

        return true;
    }
}
