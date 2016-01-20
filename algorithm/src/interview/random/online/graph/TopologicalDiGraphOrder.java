package interview.random.online.graph;

import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by selvarajs on 1/11/16.
 */
public class TopologicalDiGraphOrder {
    Stack<Integer> order;
    DirectedGraph graph;
    boolean marked[];

    public TopologicalDiGraphOrder(DirectedGraph graph){
        this.graph = graph;
        order = new Stack<>();

        int vertexCount = graph.getVertexCount();
        marked = new boolean[vertexCount];

        for (int v = 0; v < vertexCount; v++){
            if (!marked[v]) {
                dfs(v);
            }
        }
    }

    private void dfs (int v){
        marked[v] = true;

        for (int adj: graph.adj(v)){
            if (!marked[adj]){
                dfs(adj);
            }
        }

        order.push(v);
    }

    public Iterable<Integer> order(){
        return order;
    }
}
