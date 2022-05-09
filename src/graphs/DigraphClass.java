package graphs;

import org.w3c.dom.Node;

public class DigraphClass<L> extends AnyGraphClass<L> implements DiGraph<L> {


    @Override
    public int inDegree(Node node) {
        return 0;
    }

    @Override
    public int outDegree(Node node) {
        return 0;
    }

    @Override
    public Iterable<Node> inAdjacentNodes(Node node) {
        return null;
    }

    @Override
    public Iterable<Node> outAdjacentNodes(Node node) {
        return null;
    }

    @Override
    public Iterable<Edge<L>> inIncidentEdges(Node node) {
        return null;
    }

    @Override
    public Iterable<Edge<L>> outIncidentEdges(Node node) {
        return null;
    }
}
