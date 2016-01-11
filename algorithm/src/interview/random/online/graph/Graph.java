package interview.random.online.graph;

/**
 * Created by selvarajs on 1/11/16.
 */
public interface Graph {
    public void addEdge(int fromVertex, int toVertex);
    public Iterable<Integer> adj(int vertex);
    public int getVertexCount();
}
