package com.alg.sedgewick.priority.q;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by selvarajs on 11/28/15.
 */
public class PriorityQ<T extends Comparable> {
    private List<T> items;
    private static final int DEFAULT_MAX = 50;
    private int currentMax;
    private int size = 0;

    public PriorityQ() {
        this(DEFAULT_MAX);
    }

    public PriorityQ(int maxCount){
        currentMax = maxCount;

        items = new ArrayList<T>(currentMax);

        // Just for this pgm to start with 1, temp fix
        items.add(null);
    }

    public void enqueue(T item) {
        // chk the size and increase as req, we dont need this since its array list
        items.add(++size, item);
        swim(size);
    }

    public T dequeue() {
        if (size < 1) {
            System.out.println("Unable to dequeue, size 0");
            return null;
        }

        T item = items.get(1);
        exch(1, size);
        items.remove(size--);
        sink(1);

        return item;
    }

    private void swim (int location) {
        if (items.size() < location) {
            System.out.println("Swim, location: " + location + "greater than size: " + items.size());
        };

        T item = items.get(location);

        int p = location / 2;

        if (p > 0) {
            if (items.get(p).compareTo(item) < 0) {
                exch(p, location);
                swim(p);
            }
        }
    }

    private void sink (int location) {
        int p = location * 2;

        if (p > size) {
            //System.out.println("Sink, location: " + location + "has no children: " + p);
            return;
        }

        if (p+1 <= size && items.get(p).compareTo(items.get(p+1)) < 0) {
            p++;
        }

        if (items.get(location).compareTo(items.get(p)) < 0) {
            exch(location, p);
            sink(p);
        }
    }

    private void exch(int p, int location) {
        Collections.swap(items, p, location);
    }

    public static void main(String args[]) {

        System.out.println("." + "abc".substring(0, 0).length() + ".");

        String name = "Sriram";
        String yourName = "Raj";


        String a = String.format("Hi %s, my name is %s", name, yourName);

        System.out.println(a);

        if (true) return;

        PriorityQ<Item<String>> pq = new PriorityQ<>(10);
        Item<String> item = null;

        List<Integer> intList = new ArrayList<>(10);
        intList.add(1);
        intList.add(1, 10);
        intList.add(0, intList.get(1));

        System.out.println(intList.size());
        System.out.println(pq.items.size());

        pq.enqueue(new Item<String>("c", "efg"));
        pq.enqueue(new Item<String>("c", "abc"));
        pq.enqueue(new Item<String>("f", "def"));
        pq.enqueue(new Item<String>("a", "ghi"));
        pq.enqueue(new Item<String>("b", "jkl"));
        pq.enqueue(new Item<String>("y", "jkl"));
        pq.enqueue(new Item<String>("w", "jkl"));

        while ((item = pq.dequeue()) != null) {
            System.out.println(item);
        }

        System.out.println(pq.dequeue());

        pq.enqueue(new Item<String>("y", "abc"));
        pq.enqueue(new Item<String>("f", "def"));
        pq.enqueue(new Item<String>("a", "ghi"));
        pq.enqueue(new Item<String>("b", "jkl"));
        pq.enqueue(new Item<String>("y", "jkl"));

        while ((item = pq.dequeue()) != null) {
            System.out.println(item);
        }
    }
}
