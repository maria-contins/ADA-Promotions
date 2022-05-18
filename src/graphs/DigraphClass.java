package graphs;

public class DigraphClass extends AnyGraphClass {


    public DigraphClass(int nNodes) {
        super(nNodes);
    }


    @Override
    public void addEdge(int node1, int node2, int label) {
        succ[node1].add(node2);
        ant[node2].add(node1);
        this.nEdges++;
    }

    public int inDegree(int node){
        if(this.nodes.contains(node))
            return ant[node].size();
        return -1;
    }

    public int outDegree(int node){
        if(this.nodes.contains(node))
            return succ[node].size();
        return -1;
    }

    public Iterable<Integer> inAdjacentNodes(int node){
        return this.ant[node];
    }

    public Iterable<Integer> outAdjacentNodes(int node){
        return this.succ[node];
    }

}
