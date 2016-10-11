public class Main {

    public static void main(String[] args) {


        MatrixFromFile initialMatrix = new MatrixFromFile("rsc/ejem_clase1.txt");

        System.out.print("Number of orders: " + initialMatrix.getOrderNum() + ".\n");
        System.out.print("Number of machines: " + initialMatrix.getMachNum() + ".\n");
        System.out.println("Input matrix: " + initialMatrix.getInputMatrix());

        RandomPermutation permutation = new RandomPermutation(initialMatrix.getOrderNum());
        System.out.println("RandomPermutation: " + permutation.result());


        FlowShop outputMatrix = new FlowShop(initialMatrix, permutation.result());
        System.out.println("Result matrix: " + outputMatrix.result());

        System.out.println("Fmed: " + outputMatrix.fmed());
    }

}
