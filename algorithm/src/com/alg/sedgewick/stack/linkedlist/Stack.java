package com.alg.sedgewick.stack.linkedlist;

/**
 * Created by selvarajs on 11/9/15.
 */
public interface Stack<T> {
    public void push(T item);
    public T pop();
    public int size();
    public T peek();
    public boolean isEmpty();

}
