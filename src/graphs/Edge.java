package graphs;
import org.w3c.dom.Node;

public interface Edge<L> {
    // Returns the edge label.
    L label( );
    // Returns the first endpoint of the edge, which is its origin if the edge is directed.
    Node firstNode( );
    // Returns the second endpoint of the edge, which is its destination if the edge is directed.
    Node secondNode( );
    // Returns the edge endpoint that is distinct from the specified node.
    Node oppositeNode( Node node );
}
