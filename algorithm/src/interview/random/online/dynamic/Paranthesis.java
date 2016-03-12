package interview.random.online.dynamic;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by selvarajs on 3/4/16.
 */
public class Paranthesis {
    public static void main(String[] args) {
        System.out.println(paranPerm(3));
    }

    public static Set<String> paranPerm(int count){
        Set<String> r = new HashSet<>();
        r.add("");

        final String P = "()";

        for (int i = 0; i < count; i++){
            Set<String> ts = new HashSet<>();

            for (String s: r){
                int l = s.length();

                for (int j = 0; j <= l; j++){
                    ts.add(s.substring(0, j) + P + s.substring(j));
                }
            }

            r = ts;
        }

        return r;
    }
}
