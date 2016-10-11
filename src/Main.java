public class Main {

    public static void main(String[] args) {


        MatrixFromFile initialMatrix = new MatrixFromFile("rsc/ejem_clase1.txt");

        System.out.print("Number of orders: " + initialMatrix.getOrderNum() + ".\n");
        System.out.print("Number of machines: " + initialMatrix.getMachNum() + ".\n");
        System.out.println("Input matrix: " + initialMatrix.getInputMatrix());

        Permutation permutation = new Permutation(initialMatrix.getOrderNum());
        System.out.println("Permutation: " + permutation.result());


        SolveFlowShopPermutational outputMatrix = new SolveFlowShopPermutational(initialMatrix, permutation);
        System.out.println("Result matrix: " + outputMatrix.result());
    }

}
