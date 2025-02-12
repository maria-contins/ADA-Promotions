
import graphs.AnyGraph;
import graphs.DigraphClass;
import promotions.PromotionsSolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String input = in.readLine();
            String[] tokens = input.split(" ");

            int endpointA, endpointB, nEmployees, precedences;

            endpointA = Integer.parseInt(tokens[0]);
            endpointB = Integer.parseInt(tokens[1]);
            nEmployees = Integer.parseInt(tokens[2]);
            precedences = Integer.parseInt(tokens[3]);

            AnyGraph graph = new DigraphClass(nEmployees);

            for (int i = 0; i < precedences; i++) {
                input = in.readLine();
                tokens = input.split(" ");

                graph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), 0);
            }

            PromotionsSolver pClass = new PromotionsSolver(nEmployees, endpointA, endpointB, graph);
            pClass.getSolution();

            System.out.println(pClass.promotedIfA());
            System.out.println(pClass.promotedIfB());
            System.out.println(pClass.neverPromoted());

        } catch (Exception ignored) {}
    }
}
