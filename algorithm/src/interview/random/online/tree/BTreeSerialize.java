package interview.random.online.tree;

import java.io.Serializable;

/**
 * Created by selvarajs on 3/3/16.
 */
public class BTreeSerialize<T extends  Serializable> {
    T node;

    public BTreeSerialize(T node){
        this.node = node;
    }

    public static void main(String[] args) {
        BTreeSerialize<String> s = new BTreeSerialize<>("Hello");
    }
}
