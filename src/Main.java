import flowshop.FlowShop;
import flowshop.MatrixFromFile;
import flowshop.RandomPermutation;
import geneticalgorithm.GeneticAlgorithm;
import randomsearch.RandomSearch;

import java.util.List;

public class Main
{

    public static void main(String[] args)
    {

        long start;
        MatrixFromFile initialMatrix = new MatrixFromFile("rsc/Doc11.txt");
        //MatrixFromFile initialMatrix = new MatrixFromFile("rsc/ejem_clase1.txt");

        System.out.print("Number of orders: " + initialMatrix.getOrderNum() + ".\n");
        System.out.print("Number of machines: " + initialMatrix.getMachNum() + ".\n");
        System.out.println("Input matrix: " + initialMatrix.getInputMatrix());

        RandomPermutation permutation = new RandomPermutation(initialMatrix.getOrderNum());
        System.out.println("flowshop.RandomPermutation: " + permutation.result());


        FlowShop outputMatrix = new FlowShop(initialMatrix, permutation.result());
        System.out.println("Result matrix: " + outputMatrix.result());

        System.out.println("Fmed: " + outputMatrix.fmed());

        System.out.println("\n\nRandom Search with 1000 iterations:\n");
        List<Integer> randomSearchSolution = new RandomSearch(1000,initialMatrix).run();
        System.out.println("Best solution: " + randomSearchSolution);
        FlowShop randomSearchFlowshop = new FlowShop(initialMatrix, randomSearchSolution);
        System.out.println("Fmed: " + randomSearchFlowshop.fmed());

        /*System.out.println("\n\nFirst Best solution:");
        System.out.println("Processing. Please wait...\n");
        start = System.currentTimeMillis();
        List<Integer> firstBestSolution = new FirstBest(permutation, initialMatrix).run();
        System.out.println("Finished in: " + (System.currentTimeMillis() - start)/1000 + "s.");
        System.out.println("Best solution: " + firstBestSolution);
        FlowShop firstBestFlowShop = new FlowShop(initialMatrix,firstBestSolution);
        System.out.println("Fmed: " + firstBestFlowShop.fmed());

        System.out.println("\n\nSimulated Annealing solution:");
        System.out.println("Processing. Please wait...\n");
        start = System.currentTimeMillis();
        List<Integer> simulatedAnnealingSolution = new SimulatedAnnealing(permutation, initialMatrix).run();
        System.out.println("Finished in: " + (System.currentTimeMillis() - start)/1000 + "s.");
        System.out.println("Best solution: " + simulatedAnnealingSolution);
        FlowShop simulatedAnnealingFlowShop = new FlowShop(initialMatrix,simulatedAnnealingSolution);
        System.out.println("Fmed: " + simulatedAnnealingFlowShop.fmed());*/

        System.out.println("\n\nGenetic Algorithm solution:");
        System.out.println("Processing. Please wait...\n");
        start = System.currentTimeMillis();
        List<Integer> geneticSolution = new GeneticAlgorithm(initialMatrix).run();
        System.out.println("Finished in: " + (System.currentTimeMillis() - start)/1000 + "s.");
        System.out.println("Best solution: " + geneticSolution);
        FlowShop geneticFlowShop = new FlowShop(initialMatrix, geneticSolution);
        System.out.println("Fmed: " + geneticFlowShop.fmed());


    }

}
