package graphs;

import java.util.LinkedList;
import java.util.List;

public class DigraphClass extends AnyGraphClass implements Digraph {

    public List<Integer>[] anterior, successor;
    protected List<Edge>[] inEdge, outEdge;

    @SuppressWarnings("unchecked")
    public DigraphClass(int nNodes) {
        super(nNodes);
        this.anterior = new LinkedList[nNodes];
        this.successor = new LinkedList[nNodes];

        this.inEdge = new LinkedList[nNodes];
        this.outEdge = new LinkedList[nNodes];

        addNodes(nNodes);
    }

    private void addNodes(int nNodes){
        for(int i=0;i<nNodes;i++){
            nodes.add(i);
            anterior[i] = new LinkedList<>();
            successor[i] = new LinkedList<>();
        }
    }

    @Override
    public void addEdge(int node1, int node2, int label) {
        successor[node1].add(node2);
        anterior[node2].add(node1);
        this.nEdges++;

        Edge edge = new EdgeClass(node1, node2, label);
        super.edges.add(edge);
    }

    @Override
    public boolean edgeExists(int node1, int node2) {
        if(nodes.contains(node1) && nodes.contains(node2))
            return successor[node1].contains(node2);
        else
            return false;

    }

    @Override
    public int inDegree(int node) {
        return anterior[node].size();
    }

    @Override
    public int outDegree(int node) {
        return successor[node].size();
    }

    @Override
    public Iterable<Integer> inAdjacentNodes(int node) {
        return anterior[node];
    }

    @Override
    public Iterable<Integer> outAdjacentNodes(int node) {
        return successor[node];
    }

    @Override
    public Iterable<Edge> inIncidentEdges(int node) {
        LinkedList<Edge> edges = new LinkedList<>();
        for (Edge e : super.edges) {
            if (e.secondNode() == node)
                edges.add(e);
        }
        return edges;
    }

    @Override
    public Iterable<Edge> outIncidentEdges(int node) {
        LinkedList<Edge> edges = new LinkedList<>();
        for (Edge e : super.edges) {
            if (e.firstNode() == node)
                edges.add(e);
        }
        return edges;
    }
}
