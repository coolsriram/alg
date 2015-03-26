package com.alg.sedgewick.search.st;

/**
 * Created by selvarajs on 3/26/15.
 */
public class ST<Key, Value> {

    public ST(){

    }

    public void put(Key Key, Value value){

    }

    public Value get(Key key){
        return null;
    }

    public void delete(Key key){
        put(key, null);
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return -1;
    }

    public Iterable<Key> keys(){
        return null;
    }
}
