import graphs.AnyGraph;
import graphs.Digraph;
import graphs.DigraphClass;
import promotions.PromotionSolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        AnyGraph<Integer> graph = new DigraphClass<Integer>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
        String[] line = in.readLine().split(" ");

        int intervalEndpointA = Integer.parseInt(line[0]);
        int intervalEndpointB = Integer.parseInt(line[1]);
        int employees = Integer.parseInt(line[2]);
        int precedence = Integer.parseInt(line[3]);


        for (int i = 0; i < precedence; i++) {

        }


        } catch (IOException e) {
            e.printStackTrace();
        }

        PromotionSolver ps = new PromotionSolver();
        ps.calculateSolution();

        // output
        System.out.println(pr.promotedIfA());
        System.out.println(pr.promotedIfB());
        System.out.println(pr.neverPromoted());


    }
}

