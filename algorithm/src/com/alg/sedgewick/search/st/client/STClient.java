package com.alg.sedgewick.search.st.client;

import com.alg.sedgewick.search.st.ST;
import com.alg.sedgewick.utils.fromsite.StdIn;
import com.alg.sedgewick.utils.fromsite.StdOut;

/**
 * Created by selvarajs on 3/26/15.
 */
public class STClient {

    public static void main(String[] args){
        ST<String, Integer> st;

        st = new ST<String, Integer>();

        for (int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();

            if (key.equalsIgnoreCase(",")) break;

            st.put(key, i);
        }

        StdOut.println("Now printing results");
        for (String s: st.keys()){
            StdOut.println(s + " " + st.get(s));
        }
        StdOut.println("All done");
    }
}
