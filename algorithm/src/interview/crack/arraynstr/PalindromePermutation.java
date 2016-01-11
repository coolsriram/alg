package interview.crack.arraynstr;

import java.util.Arrays;

/**
 * Created by selvarajs on 12/27/15.
 */
public class PalindromePermutation {

    public static void main (String args[]) {
        System.out.println("Palindrome Permutation check");

        PalindromePermutation pp = new PalindromePermutation();

        pp.isPPWithSort("Tact Coa");
    }

    public boolean isPPWithSort(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        // Sort string, ignore case

        char c[] = str.toLowerCase().toCharArray();
        Arrays.sort(c);

        boolean isPP = true;
        boolean isOddValidated = false;

        int strInx = 0;

        int spaceCnt = countChar(str, ' ');

        boolean isOddStr = ((c.length - spaceCnt) %2 == 1);

        while (strInx < c.length) {
            char curChar = c[strInx];

            if (curChar == ' ') {
                strInx++;
                continue;
            }

            // last char check
            if ((strInx+1) == c.length) {
                if (isOddStr && !isOddValidated) {
                    isOddValidated = true;
                    strInx++;
                    continue;
                } else {
                    isPP = false;
                    break;
                }
            }

            if (curChar != c[strInx + 1]) {
                if (isOddStr && !isOddValidated) {
                    isOddValidated = true;
                    strInx++;
                    continue;
                } else {
                    isPP = false;
                    break;
                }
            } else {
                strInx += 2;
            }
        }


        System.out.println(str + " is pp? " + isPP);
        return isPP;
    }

    private int countChar(String str, char c){
        int cnt = 0;

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == c) {
                cnt++;
            }
        }

        return cnt;
    }

}
