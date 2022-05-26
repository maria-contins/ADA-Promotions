package promotions;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

import graphs.Digraph;
import graphs.DigraphClass;
import org.w3c.dom.Node;

public class PromotionsSolver {

    private DigraphClass graph;
    private int numEmployees;
    private int promosA;
    private int promosB;
    private int promotedIfA;
    private int promotedIfB;
    private int neverPromoted;
    private int[] descendants;
    private int[] ascendants;
    private int [] result;
    private int promoted;



    public PromotionsSolver(int employees, int promosA, int promosB) {
        // TODO Auto-generated constructor stub
        this.numEmployees = employees;
        this.graph = new DigraphClass(employees);
        this.promosA = promosA;
        this.promosB = promosB;
        this.descendants = new int[employees];
        this.ascendants = new int[employees];
        this.result = new int[employees];
        this.promoted = 0;
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
            if (inDegree[v] == 0) {
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
            permutation[1] = node;
            for (int v : graph.outAdjacentNodes(node)) {
                inDegree[v] = inDegree[v]-1; //actualização da tabela
                if (inDegree[v] == 0) { //se agora v tem 0 ant. vai para a fila
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
        } while (!ready.isEmpty());
        return permutation;
    }


    public int promotedIfA() {
        // TODO Auto-generated method stub
        return promotedIfA;
    }

    public int promotedIfB() {
        // TODO Auto-generated method stub
        return promotedIfB;
    }


    public int neverPromoted() {
        // TODO Auto-generated method stub
        return numEmployees - promotedIfB;
    }



}
	
	
	