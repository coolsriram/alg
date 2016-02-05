package interview.random.online.string;

import java.util.Stack;

/**
 * Created by selvarajs on 2/1/16.
 */
public class LongestValidSubstring {
    public static void main(String[] args) {
        // http://www.geeksforgeeks.org/length-of-the-longest-valid-substring/

        String str = "((())()())()()";
        str = "()(()))))";
        str = "())()))";

        int maxLength = longestValidParanthesisSubString(str);

        System.out.println("Max valid substring = " + maxLength);
    }

    public static int longestValidParanthesisSubString(String str){
        int maxLength = 0;

        int closeCt = 0;
        int result = 0;

        Stack<Character> charStack = new Stack<>();

        for (char c: str.toCharArray()){
            if (c != '(' && c != ')'){
                throw new IllegalArgumentException("Found illegal char: " + c);
            }
            charStack.push(c);
        }

        while (!charStack.isEmpty()){
            char c = charStack.pop();

            if (c == ')'){
                closeCt++;
                continue;
            }

            if (closeCt > 0){
                result += 2;
                closeCt--;
                maxLength = (maxLength > result) ? maxLength : result;
            } else {
                result = 0;
            }
        }

        return maxLength;
    }
}
