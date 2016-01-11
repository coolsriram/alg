package interview.crack.dynamic;

import java.util.Stack;

/**
 * Created by selvarajs on 12/29/15.
 */
public class HanoiFromBook {

    public static void main(String[] args) {
        System.out.println("Hanoi from book");

        int n = 3;
        Tower[] towers = new Tower[n];

        for (int i = 0; i < 3; i++){
            towers[i] = new Tower(i);
        }

        int noOfTowers = 3;
        for (int i = noOfTowers; i > 0; i--) {
            towers[0].add(i);
        }

        towers[0].moveDisks(noOfTowers, towers[2], towers[1]);

        System.out.println(towers[2].disks);
    }

    static class Tower {
        private Stack<Integer> disks;
        private int index;

        public Tower(int i){
            disks = new Stack<Integer>();
            index = i;
        }

        public int index(){
            return index;
        }

        public void add(int d){
            if (!disks.isEmpty() && disks.peek() <= d){
                System.out.println("Error placing disk: " + d);
            } else {
                disks.push(d);
                System.out.println("Tower" + index + ": added: " + d);
            }
        }

        public void moveTopTo(Tower t){
            int top = disks.pop();
            System.out.println("Tower" + index + ": removed: " + top);
            t.add(top);
        }

        public void moveDisks(int n, Tower destination, Tower buffer){
            if (n > 0){
                moveDisks(n - 1, buffer, destination);
                moveTopTo(destination);
                buffer.moveDisks(n - 1, destination, this);
            }
        }

        public String toString(){
            return "Tower" + index + ": " + disks;
        }
    }
}
