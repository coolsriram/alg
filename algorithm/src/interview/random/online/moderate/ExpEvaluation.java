package interview.random.online.moderate;

import java.util.Stack;

/**
 * Created by selvarajs on 2/9/16.
 */
public class ExpEvaluation {
    public static void main(String[] args) {
        String exp = "2+3*5+1";


        System.out.println(new ExpEvaluation().evaluate(exp));
    }

    public int evaluate(String exp){
        ExpHandler eh = new ExpEvaluation.ExpHandler(exp);
        Stack<Integer> nStack = new Stack<>();
        Stack<Character> oStack = new Stack<>();

        while (eh.hasMore()){
            int n = eh.getNextNum();
            Character op = eh.getNextOp();

            if (op == null){
                pushElement(nStack, n);
                continue;
            }

            if (nStack.isEmpty()){
                pushElement(nStack, n);
                pushElement(oStack, op);
                continue;
            } else if (op.charValue() == '*' || op.charValue() == '/'){
                if (!oStack.isEmpty()){
                    int r = performOp(nStack.pop(), n, oStack.pop());
                    nStack.push(r);
                    oStack.push(op);
                }
            }
        }

        while (!oStack.isEmpty()){
            Character op = oStack.pop();
            int a = nStack.pop();
            int b = nStack.pop();
            int r = performOp(b, a, op);
            nStack.push(r);
        }

        return nStack.pop();
    }

    private int performOp(int a, int b, final Character pop1) {
        int r = -1;

        if (pop1.charValue() == '*'){
            r = a * b;
        } else if (pop1.charValue() == '/'){
            r = a / b;
        } else if (pop1.charValue() == '+'){
            r = a + b;
        }else if (pop1.charValue() == '-'){
            r = a - b;
        }

        return r;
    }

    public void pushElement(Stack s, Comparable c){
        if (c != null){
            s.push(c);
        }
    }

    class ExpHandler {
        String exp;
        int inx;

        public ExpHandler(String exp){
            this.exp = exp;
            inx = 0;
        }

        boolean hasMore(){
            return inx < exp.length();
        }

        int getNextNum(){
            int n = 0;
            int p = 1;

            while (inx < exp.length() && Character.isDigit(exp.charAt(inx))){
                n += (Character.digit(exp.charAt(inx), 10) * p);
                p *= 10;
                inx++;
            }

            return n;
        }

        Character getNextOp(){
            if (inx < exp.length()) {
                return exp.charAt(inx++);
            } else {
                return null;
            }
        }
    }

}

