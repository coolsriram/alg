package interview.crack.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selvarajs on 12/29/15.
 */
public class Permutation {
    public static void main(String[] args) {
        System.out.println("Permutation without dups");

        List<String> permutatedList = permutate("abcabc", true );

        System.out.println(permutatedList.size());
        System.out.println(permutatedList);

    }

    public static List<String> permutate(String str, boolean ignoreDups){
        if (str == null || str.length() == 0){
            return null;
        }

        return permutateWithoutDups(str.substring(0, str.length() - 1), str.charAt(str.length() - 1), ignoreDups);
    }

    private static List<String> permutateWithoutDups(String str, char c, boolean ignoreDups) {

        if (str.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(c));
            return list;
        }

        List<String> pList = permutateWithoutDups(str.substring(0, str.length() - 1), str.charAt(str.length() - 1),
                ignoreDups);

        List<String> combinedList = new ArrayList<>();

        for (String cStr: pList) {
            if (ignoreDups && cStr.contains(String.valueOf(c))){
                combinedList.add(cStr);
                continue;
            }
            for (int i = 0; i <= cStr.length(); i++) {
                String s = new StringBuffer().append(cStr.substring(0, i))
                                             .append(c)
                                             .append(cStr.substring(i)).toString();

                combinedList.add(s);
            }
        }

        return combinedList;
    }
}
