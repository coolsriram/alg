package interview.random.online.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selvarajs on 1/11/16.
 */
public class DirectedGraph implements Graph{
    private int[] vertices;
    private List<List<Integer>> edges;
    int edgeCount;

    public DirectedGraph(int vertexCount){
        vertices = new int[vertexCount];
        edges = new ArrayList<>();

        for (int i = 0; i < vertexCount; i++) {
            vertices[i] = i;
            edges.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int fromVertex, int toVertex){
        edges.get(fromVertex).add(toVertex);
        edgeCount++;
    }

    public Iterable<Integer> adj(int vertex){
        return edges.get(vertex);
    }

    public int getVertexCount(){
        return vertices.length;
    }
}
