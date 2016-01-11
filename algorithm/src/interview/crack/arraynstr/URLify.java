package interview.crack.arraynstr;

/**
 * Created by selvarajs on 12/27/15.
 */
public class URLify {

    public static void main (String args[]) {
        System.out.println("URLify");

        URLify ans = new URLify();

        ans.urlify("Mr John Smith    ".toCharArray(), 13);
    }

    public void urlify(char[] inpStr, int l){
        //chk ip for null, str length & l > 0

        int truLengthInx = inpStr.length;
        final String encStr="%20";

        for (int strInx = l - 1; strInx >= 0; strInx--) {
            char curChar = inpStr[strInx];

            if (curChar == ' ') {
                truLengthInx -= encStr.length();
                insertString(inpStr, truLengthInx, encStr);
            } else {
                inpStr[--truLengthInx] = curChar;
            }
        }

        System.out.println("Result is: \n");

        for (char curChar: inpStr) {
            System.out.print(curChar);
        }
    }

    private void insertString (char[] inpStr, int strInx, String toIns){
        for (char curChar: toIns.toCharArray()) {
            inpStr[strInx++] = curChar;
        }
    }
}
