package graphs;

import org.w3c.dom.Node;

public interface AnyGraph<L> {

    // Returns the number of nodes.
    int numNodes( );
    // Returns the number of edges.
    int numEdges( );
    // Returns an arbitrary node.
    Node aNode( );
    // Inserts edge (node1, node2) whose label is the specified label.
    void addEdge( Node node1, Node node2, L label );
    // Returns true iff there is an edge of the form (node1, node2).
    boolean edgeExists( Node node1, Node node2 );
    // Returns the nodes.
    Iterable<Node> nodes( );
    // Returns the edges.
    Iterable<Edge<L>> edges( );


}
