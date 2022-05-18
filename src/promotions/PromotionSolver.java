package promotions;
import graphs.DigraphClass;

import java.util.Stack;

public class PromotionSolver {

    private int nEmployees, endpoint1, endpoint2;
    private DigraphClass graph;

    private int promotedIfA;
    private int promotedIfB;
    private int neverPromoted;

    public PromotionSolver(int endpoint1, int endpoint2, int nEmployees){
        this.endpoint1 = endpoint1;
        this.endpoint2 = endpoint2;
        this.nEmployees = nEmployees;
        graph = new DigraphClass(nEmployees);

        promotedIfA = 0;
        promotedIfB = 0;
        neverPromoted = 0;
    }

    public void addPrecedence(int employee1, int employee2){
        graph.addEdge(employee1, employee2, 0);
    }

    public void calculateSolution() {
        for(int i: this.graph.nodes()) {
            dfsExplore(i, true, ascendants);
            dfsExplore(i, false, descendants);

            if(endpoint1 >= (nEmployees - descendants[i]))
                promotedIfA++;

            if(endpoint2 >= (nEmployees - descendants[i]))
                promotedIfB++;

            if(endpoint2 <= ascendants[i])
                neverPromoted++;

        }

    }

    private void dfsExplore(int root, boolean inAdjacent, int[] result) {
        Stack<Integer> foundUnprocessed = new Stack<Integer>();

        boolean[] processed = new boolean[this.nEmployees];

        foundUnprocessed.push(root);

        result[root]--;

        do {
            int node = foundUnprocessed.pop();

            if (!processed[node]) {
                processed[node] = true;
                result[root]++;

                Iterable<Integer> adjacent = (inAdjacent) ? graph.inAdjacentNodes(node) : graph.outAdjacentNodes(node);
                for (Integer integer : adjacent) {
                    if (!processed[integer]) {
                        foundUnprocessed.push(integer);
                    }
                }
            }
        } while(!foundUnprocessed.isEmpty());

    }


    public int promotedIfA() {
        return promotedIfA;
    }

    public int promotedIfB() {
        return promotedIfB;
    }


    public int neverPromoted() {
        return neverPromoted;
    }


}

}
