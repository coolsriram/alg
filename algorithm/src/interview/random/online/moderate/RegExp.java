package interview.random.online.moderate;

/**
 * Created by selvarajs on 2/25/16.
 */
public class RegExp {
    public static void main(String[] args) {
        String s = "abbcdacxegfcxifd";
        String p = "ab*cx?fd";

        p = "x*yz";
        s = "xyz";

        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p){
        int sInx = 0, pInx = 0, wInx = -1;

        while (sInx < s.length() && pInx < p.length()){

            char sc = s.charAt(sInx);
            char pc = p.charAt(pInx);

            // wildcard, mark the index
            if (pc == '*'){
                wInx = pInx;
                pInx++;
                continue;
            }

            if (sc == pc || pc == '?'){
                pInx++; sInx++;
                continue;
            }

            // Not Matching & no wild card encountered
            if (wInx == -1){
                break;
            }

            // Wild card encountered, pattern moved, reset it
            if ((wInx + 1) < pInx){
                pInx = wInx + 1;
            } else {
                sInx++;
            }
        }

        // Loop complete, if both index is at the last, then match
        if (pInx == p.length() && sInx == s.length()){
            return true;
        }

        // edge case, if last char in pattern is * & we reached there
        if (pInx == p.length() - 1 && wInx == pInx){
            return true;
        }

        return false;
    }
}
