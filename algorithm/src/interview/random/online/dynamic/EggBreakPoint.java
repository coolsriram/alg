package interview.random.online.dynamic;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by selvarajs on 1/10/16.
 */
public class EggBreakPoint {
    public static void main(String[] args) {
        System.out.println("EggBreakPoint");
        // http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/


        breakPointFloor = ThreadLocalRandom.current().nextInt(1, 35); // 1 - 34
        System.out.println("Breaking point floor is " + breakPointFloor);
        System.out.println("Now starting to test.");

        System.out.println("\n\nBreaking floor: " + findBreakingPoint(1, 34, 2));

        System.out.println("\n\nTotal drops: " + attempts);

    }

    private static int findBreakingPoint (int low, int high, int eggCount){
        if (low == high) {
            return low;
        }

        if ( eggCount == 0 ){
            throw new RuntimeException("No more eggs to break.");
        }

        int mid = low + ((high - low) / 2);

        if (isStableDropFromFloor(mid)) {
            return findBreakingPoint(mid + 1, high, eggCount);
        } else {
            for (int i = low; i < mid; i++) {
               if (!isStableDropFromFloor(i)) {
                   return i;
               }
            }
        }

        return -1; // should not return this unless none of the floor is breaking the egg
    }

    private static int breakPointFloor = 0;
    private static int attempts = 0;

    private static boolean isStableDropFromFloor (int floorNo){
        System.out.println("isStable: " + floorNo + ": " + (floorNo <= breakPointFloor));
        attempts++;
        return floorNo < breakPointFloor;
    }
}
