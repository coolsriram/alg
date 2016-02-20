package interview.random.online.moderate;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by selvarajs on 2/4/16.
 */
public class MasterMind {
    public static void main(String[] args) {
        List<Ball> r = new ArrayList<>();
        r.add(Ball.R);
        r.add(Ball.G);
        r.add(Ball.B);
        r.add(Ball.Y);

        List<Ball> u = new ArrayList<>();
        u.add(Ball.G);
        u.add(Ball.G);
        u.add(Ball.R);
        u.add(Ball.Y);

        masterMind(r.size(), r, u);
    }

    public static void masterMind(int slot, List<Ball> r, List<Ball> u){
        if (slot < 0 || r.size() != slot || r.size() != u.size()){
            System.out.println("Invalid input");
            return;
        }

        Map<Ball, AtomicInteger> rMap = new HashMap<>();
        Map<Ball, AtomicInteger> uMap = new HashMap<>();

        int hit = 0, pHit = 0;

        for (int i = 0; i < slot; i++){
            if (r.get(i) == u.get(i)){
                hit++;
                continue;
            }

            addToMap(rMap, r.get(i));
            addToMap(uMap, u.get(i));
        }

        Iterator<Ball> rItr = rMap.keySet().iterator();

        while (rItr.hasNext()){
            Ball t = rItr.next();

            if (uMap.containsKey(t)){
                pHit += Math.min(uMap.get(t).get(), rMap.get(t).get());
            }
        }

        System.out.println("Hit: " + hit + ", Psudo Hit: " + pHit);
    }

    private static void addToMap(Map<Ball, AtomicInteger> map, Ball ball) {
        if (!map.containsKey(ball)) {
            map.put(ball, new AtomicInteger(0));
        }

        map.get(ball).incrementAndGet();
    }

    public static enum Ball{B, G, R, Y};
}
