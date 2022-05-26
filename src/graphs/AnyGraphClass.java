package graphs;

import java.util.LinkedList;
import java.util.List;

public class AnyGraphClass implements AnyGraph {

    protected int nNodes;
    protected int nEdges;
    public List<Integer> nodes;
    protected List<Edge> edges;
    protected List<Integer>[] adjacent;

    @SuppressWarnings("unchecked")
    public AnyGraphClass(int nNodes){
        this.nNodes = nNodes;
        this.nEdges = 0;
        this.adjacent = new LinkedList[nNodes];
        this.edges = new LinkedList<>();
        this.nodes = new LinkedList<>();

        addNodes(nNodes);
    }

    private void addNodes(int nNodes){
        for(int i=0;i<nNodes;i++){
            nodes.add(i);
            adjacent[i] = new LinkedList<>();
        }
    }

    @Override
    public int numNodes() {
        return this.nNodes;
    }

    @Override
    public int numEdges() {
        return this.nEdges;
    }

    @Override
    public int aNode() {
        return (int) (Math.random() * ((nNodes) + 1));
    }

    @Override
    public void addEdge(int node1, int node2, int label) { // label is cost
        this.nEdges++;

        adjacent[node1].add(node2);
        adjacent[node2].add(node1);

        Edge edge = new EdgeClass(node1, node2, label);
        edges.add(edge);
    }

    @Override
    public boolean edgeExists(int node1, int node2) {
        if(nodes.contains(node1) && nodes.contains(node2))
            return (adjacent[node1].contains(node2));
        else
            return false;
    }

    @Override
    public Iterable<Integer> nodes() {
        return this.nodes;
    }

    @Override
    public Iterable<Edge> edges() {
        return edges;
    }

}

