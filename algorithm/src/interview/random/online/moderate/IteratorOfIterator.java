package interview.random.online.moderate;

import java.util.*;

/**
 * Created by selvarajs on 2/20/16.
 */
public class IteratorOfIterator<T> {
    private Queue<Iterator<T>> queue;

    public IteratorOfIterator(List<Iterator<T>> list){
        queue = new LinkedList<>();

        for (Iterator<T> i : list){
            if (i.hasNext()) {
                queue.add(i);
            }
        }
    }

    public boolean hasNext(){
        return !queue.isEmpty();
    }

    public T next(){
        T n = null;

        if (hasNext()){
            Iterator<T> itr = queue.remove();
            n = itr.next();

            if (itr.hasNext()){
                queue.add(itr);
            }
        }

        return n;
    }

    public void add(Iterator<T> itr){
        if (itr != null && itr.hasNext()){
            queue.add(itr);
        }
    }


    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);

        List<Integer> l2 = new ArrayList<>();
        l2.add(4);
        l2.add(5);
        l2.add(6);

        List<Integer> l3 = new ArrayList<>();
        l3.add(7);
        l3.add(8);
        l3.add(9);

        List<Iterator<Integer>> input = new ArrayList<>();
        input.add(l1.iterator());
        input.add(l2.iterator());
        input.add(l3.iterator());

       IteratorOfIterator<Integer> itr = new IteratorOfIterator<>(input);

        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }


}
