package graphs;

import org.w3c.dom.Node;

public interface DiGraph<L> extends AnyGraph<L> {

    // Returns the in-degree of the specified node.
    int inDegree(Node node);

    // Returns the out-degree of the specified node.
    int outDegree(Node node);

    // Returns the nodes adjacent to the specified node along incoming edges to it.
    Iterable<Node> inAdjacentNodes(Node node);

    // Returns the nodes adjacent to the specified node along outgoing edges from it.
    Iterable<Node> outAdjacentNodes(Node node);

    // Returns the incoming edges to the specified node.
    Iterable<Edge<L>> inIncidentEdges(Node node);

    // Returns the outgoing edges from the specified node.
    Iterable<Edge<L>> outIncidentEdges(Node node);
}
