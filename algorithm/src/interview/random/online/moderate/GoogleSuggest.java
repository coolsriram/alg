package interview.random.online.moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by selvarajs on 2/19/16.
 */
public class GoogleSuggest {
    Node root;

    public static void main(String[] args) {

        String l = "sriram";

        System.out.println(l.substring(3, 2));

        if (true) return;

        GoogleSuggest gs = new GoogleSuggest();
        gs.add("I want icecream");
        gs.add("I want bat");
        gs.add("I want ball");
        gs.add("I want helmet");
        gs.add("I have cold");
        gs.add("I have a car");
        gs.add("I am not evil");

        List<String> ls = gs.getS("I want", 2);
        ls.remove(0);
        System.out.println(ls);

    }

    public void add(String sen){
        if (root == null){
            root = new Node(' ');
        }

        Node prev = root;

        for (char c: sen.toCharArray()){
            Node cur = null;

            if (c == ' ' ){
                prev.isW = true;
                continue;
            }

            if (prev.nodeMap.containsKey(c)){
                cur = prev.nodeMap.get(c);
            }

            if (cur == null){
                cur = new Node(c);
                prev.nodeMap.put(c, cur);
            }

            prev = cur;
        }

        if (prev != root){
            prev.isW = true;
        }
    }

    public List<String> getS(String str, int size){
        List<String> l = new ArrayList<>();

        Node n = locate(str);

        if (n != null){
            getS(n, new StringBuffer(str), size, l);
        }

        return l;
    }

    private void getS(Node n, StringBuffer s, int k, List<String> l){
        if (k + 1 == l.size()){
            return;
        }

        if (n.isW){
            l.add(s.toString());
            s.append(" ");
        }

        for (char c: n.nodeMap.keySet()){
            getS(n.nodeMap.get(c), new StringBuffer(s.toString() + c), k, l);
        }
    }


    private Node locate(String s){
        Node n = null;
        Node c = root;

        for (Character ch: s.toCharArray()){
            if (c.nodeMap.containsKey(ch)){
                n = c.nodeMap.get(ch);
                c = n;
            } else if (ch == ' '){
                continue;
            } else {
                n = null;
                break;
            }
        }

        return n;
    }
}

class Node{
    Map<Character, Node> nodeMap;
    Character data;
    boolean isW;

    public Node(char c){
        this.data = c;
        nodeMap = new HashMap<>();
    }
}
