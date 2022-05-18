import promotions.PromotionSolver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input = in.readLine();
        String[] tokens = input.split(" ");

        int endpoint1, endpoint2, nEmployees, precedences;

        endpoint1 = Integer.parseInt(tokens[0]);
        endpoint2 = Integer.parseInt(tokens[1]);
        nEmployees = Integer.parseInt(tokens[2]);
        precedences = Integer.parseInt(tokens[3]);

        PromotionSolver pClass = new PromotionSolver(endpoint1, endpoint2, nEmployees);

        for(int i=0;i<precedences;i++){
            input = in.readLine();
            tokens = input.split(" ");

            pClass.addPrecedence(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        }

        System.out.println();
    }
}
