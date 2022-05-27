package promotions;
import java.util.*;

import graphs.AnyGraph;
import graphs.DigraphClass;

public class PromotionsSolver {

    private DigraphClass graph;
    private int numEmployees;
    private int promosA;
    private int promosB;
    private int promotedIfA;
    private int promotedIfB;
    private int [] result;



    public PromotionsSolver(int employees, int promosA, int promosB, AnyGraph graph) {
        this.numEmployees = employees;
        this.graph = (DigraphClass) graph;
        this.promosA = promosA;
        this.promosB = promosB;
        this.result = new int[employees];
    }

    public void getSolution() {
        result = topologicalSort();
    }

    int[] topologicalSort() {
        int[] permutation = new int[graph.numNodes()]; //vector com a ordenação topológica
        int permSize = 0; //índice de permutation (vector acompanhado)
        int[] inDegree = new int[graph.numNodes()]; //tabela (vector) #ant.
        Queue<Integer> ready = new PriorityQueue<>(); //Fila com nós com 0 ant.
        for (int v : graph.nodes()) {
            inDegree[v] = graph.inDegree(v);
            if (inDegree[v] == 0 && !ready.contains(v)) {
                ready.add(v);
                if (promosA > 0) {
                    promotedIfA++;
                    promosA--;
                }
                if (promosB > 0) {
                    promotedIfB++;
                    promosB--;
                }
            }
        }
        do {
            int node = ready.remove();
            //permutation[permSize++] = node;
            for (int v : graph.outAdjacentNodes(node)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    ready.add(v);
                    if (promosB > 0) {
                        promotedIfB++;
                        promosB--;
                    }
                }
            }
            int r = 0;
            for (int v : ready) {
                if (inDegree[v] == 0)
                    r++;
            }
            if (promosA > 0 && promosA >= r) {
                promotedIfA += r;
            }
            promosA -= r;
        } while (!ready.isEmpty());
        return permutation;
    }


    public int promotedIfA() {
        return promotedIfA;
    }

    public int promotedIfB() {
        return promotedIfB;
    }


    public int neverPromoted() {
        return numEmployees - promotedIfB;
    }



}
	
	
	