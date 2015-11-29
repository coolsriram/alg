package com.alg.sedgewick.priority.q;

/**
 * Created by selvarajs on 11/28/15.
 */
public class Item<T extends Comparable> implements Comparable<Item<T>>{
    private T key;
    private String value;

    public Item(T key, String value){
        this.key = key;
        this.value = value;
    }

    public int compareTo(Item<T> keyToCompare){
        return key.compareTo(keyToCompare.key);
    }

    public String toString() {
        return key + " : " + value;
    }
}
