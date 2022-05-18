package graphs;

import java.util.LinkedList;
import java.util.List;

public class AnyGraphClass implements AnyGraph {

    protected int nNodes;
    protected int nEdges;
    protected List<Integer> nodes;
    protected List<Integer>[] ant, succ;

    @SuppressWarnings("unchecked")
    public AnyGraphClass(int nNodes){
        this.nNodes = nNodes;
        this.nEdges = 0;
        this.ant = new LinkedList[nNodes];
        this.succ = new LinkedList[nNodes];

        addNodes(this.nNodes);
    }

    private void addNodes(int nNodes){
        for(int i=0;i<nNodes;i++){
            nodes.add(i);
            ant[i] = new LinkedList<>();
            succ[i] = new LinkedList<>();
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
        return 0;   ///TODO: WHY DO WE NEED THIS?
    }

    @Override
    public void addEdge(int node1, int node2, int label) { // label?
        this.nEdges++;
        ant[node1].add(node2);
        ant[node2].add(node1);
        succ[node1].add(node2);
        succ[node2].add(node1);
    }

    @Override
    public boolean edgeExists(int node1, int node2) {
        return (ant[node1].contains(node2) || ant[node2].contains(node1) || succ[node1].contains(node2) || succ[node2].contains(node1));
    }

    @Override
    public Iterable<Integer> nodes() {
        return this.nodes;
    }

    @Override
    public Iterable<Edge> edges() {
        return null;
    }


}
