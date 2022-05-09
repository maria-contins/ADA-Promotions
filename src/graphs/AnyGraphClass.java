package graphs;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.List;

public class AnyGraphClass<L> implements AnyGraph<L> {
    protected List<L>[] adjArray;
    protected int numEdges;

    @SuppressWarnings("unchecked")
    public AnyGraphClass(int numNodes) {
        this.adjArray = new LinkedList[numNodes];

        for(int i=0; i<numNodes; i++) {
            adjArray[i] = new LinkedList<>();
            adjArray[i].add(i); // TODO
        }

    }
    @Override
    public int numNodes() {
        return 0;
    }

    @Override
    public int numEdges() {
        return 0;
    }

    @Override
    public Node aNode() {
        return null;
    }

    @Override
    public void addEdge(Node node1, Node node2, L label) {

    }

    @Override
    public boolean edgeExists(Node node1, Node node2) {
        return false;
    }

    @Override
    public Iterable<Node> nodes() {
        return null;
    }

    @Override
    public Iterable<Edge<L>> edges() {
        return null;
    }
}
