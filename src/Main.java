import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int numberOfMachines = 2;
        int numberOfOrders = 5;


        MatrixFromFile initialMatrix = new MatrixFromFile("file.txt");
        List<List<Integer>> inputMatrix = new ArrayList<List<Integer>>();

        Permutation permutation = new Permutation(numberOfOrders);
        System.out.println("Permutation: " + permutation.result());

        SolveFlowShopPermutational outputMatrix = new SolveFlowShopPermutational(initialMatrix, permutation);
        System.out.println("Result matrix: " + outputMatrix.result());


    }

}
