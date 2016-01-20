package interview.crack.graph;


import interview.random.online.graph.DirectedGraph;
import interview.random.online.graph.TopologicalDiGraphOrder;

/**
 * Created by selvarajs on 1/11/16.
 */
public class BuildOrder {
    public static void main(String[] args) {
        //4.7 BuildOrder
        /*
            0, 1, 2, 3, 4, 5
            dep: (3, 0), (1, 5), (3, 1), (0, 5), (2,3) // (3, 0) - 3 depends on 0, 0 -> 3
            o/p - 5, 4, 0, 1, 3, 2

            TopologicalOrder (Reverse post)
         */

        if (false) {
            System.out.println(Integer.MAX_VALUE);
            System.out.println(Integer.MIN_VALUE);

            System.out.println(Long.MAX_VALUE);
            System.out.println(Long.MIN_VALUE);

            long counter = 0;
            long longValue = 0;

            while (longValue >= 0) {
                longValue += Integer.MAX_VALUE;
                counter++;
            }

            System.out.println(longValue);
            System.out.println(counter);

            if (true) return;
        }

        // Construct digraph & use topologicalOrder

        DirectedGraph graph = new DirectedGraph(6);

        graph.addEdge(0, 3);
        graph.addEdge(5, 1);
        graph.addEdge(1, 3);
        graph.addEdge(5, 0);
        graph.addEdge(3, 2);

        TopologicalDiGraphOrder tOrder = new TopologicalDiGraphOrder(graph);

        System.out.println(tOrder.order());
    }
}
