package interview.random.online.graph;

import java.util.List;
import java.util.Stack;

/**
 * Created by selvarajs on 1/11/16.
 */
public class ConnectedGraph {
    DirectedGraph graph;
    boolean[] marked;
    int edgeTo[];
    int fromVertex;

    public ConnectedGraph(DirectedGraph graph, int vertex){
        this.graph = graph;
        this.fromVertex = vertex;

        marked = new boolean[graph.getVertexCount()];
        edgeTo = new int[graph.getVertexCount()];

        for (int i = 0; i < graph.getVertexCount(); i++){
            edgeTo[i] = -1;
        }

        dfs(vertex);
    }

    private void dfs(int vertex){
        marked[vertex] = true;

        for (int adj: graph.adj(vertex)){
            if (!marked[adj]){
                edgeTo[adj] = vertex;
                dfs(adj);
            }
        }
    }

    public boolean isConnected(int toVertex){
        return marked[toVertex];
    }

    public Iterable<Integer> pathTo(int toVertex) {
        Stack<Integer> path = null;

        if (marked[toVertex]){
            int curVertexInx = toVertex;
            path = new Stack<>();
            path.push(toVertex);

            while (edgeTo[curVertexInx] != -1){
                path.push(edgeTo[curVertexInx]);
                curVertexInx = edgeTo[curVertexInx];
            }
        }

        return path;
    }


    public static void main(String[] args) {
        System.out.println("Connected Graph test main");

        DirectedGraph graph = new DirectedGraph(6);
        // a = 0, b = 1, c = 2, d = 3, e = 4, f = 5
        // dep, (d, a) - d depends on a
        // (d,a), (b,f), (d,b), (a,f), (c,d)
        // (3, 0), (1, 5), (3, 1), (5, 0), (2, 3)
        // topology order, f, e, a, b, d, c
        // topology order, 5, 4, 0, 1, 3, 2

        graph.addEdge(0, 3);
        graph.addEdge(1, 5);
        graph.addEdge(3, 1);
        graph.addEdge(5, 0);
        graph.addEdge(2, 3);

        ConnectedGraph cg = new ConnectedGraph(graph, 2);

        int toCheck = 0;
        System.out.println("Is " + toCheck + " connected: " + cg.isConnected(toCheck));
        System.out.println("Path to " + toCheck + " : " + cg.pathTo(toCheck));
    }
}
