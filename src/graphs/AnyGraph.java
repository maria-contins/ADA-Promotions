package graphs;

import org.w3c.dom.Node;

public interface AnyGraph<Integer> {

    // Returns the number of nodes.
    int numNodes( );
    // Returns the number of edges.
    int numEdges( );
    // Returns an arbitrary node.
    int aNode( );
    // Inserts edge (node1, node2) whose label is the specified label.
    void addEdge( int node1, int node2, int label );
    // Returns true if there is an edge of the form (node1, node2).
    boolean edgeExists( int node1, int node2 );
    // Returns the nodes.
    Iterable<Node> nodes( );
    // Returns the edges.
    Iterable<Edge<Integer>> edges( );

}
