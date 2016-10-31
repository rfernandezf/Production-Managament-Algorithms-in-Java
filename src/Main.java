import SimulatedAnnealing.SimulatedAnnealing;
import firstbest.FirstBest;
import flowshop.FlowShop;
import flowshop.MatrixFromFile;
import flowshop.Permutation;
import geneticalgorithm.GeneticAlgorithm;
import randomsearch.RandomSearch;

import java.io.FileNotFoundException;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {

        long start;
        MatrixFromFile initialMatrix = null;
        try {
            initialMatrix = new MatrixFromFile(args[0]);

            System.out.print("Number of orders: " + initialMatrix.getOrderNum() + ".\n");
            System.out.print("Number of machines: " + initialMatrix.getMachNum() + ".\n");
            System.out.println("Input matrix: ");
            initialMatrix.printMatrix();

            Permutation permutation = new Permutation(initialMatrix.getOrderNum());
            System.out.println("Permutation: " + permutation.result());


            FlowShop outputMatrix = new FlowShop(initialMatrix, permutation.result());

            System.out.println("Fmed: " + outputMatrix.fmed());

            System.out.println("\n\nRandom Search with 1000 iterations:\n");
            List<Integer> randomSearchSolution = new RandomSearch(1000,initialMatrix).run();
            System.out.println("Best solution: " + randomSearchSolution);
            FlowShop randomSearchFlowshop = new FlowShop(initialMatrix, randomSearchSolution);
            System.out.println("Fmed: " + randomSearchFlowshop.fmed());

            System.out.println("\n\nFirst Best solution:");
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
            System.out.println("Fmed: " + simulatedAnnealingFlowShop.fmed());
            Permutation permutation2 = new Permutation(simulatedAnnealingSolution);
            System.out.println("Optimizating solution with FirstBest. Please Wait...");
            List<Integer> firstBestSolution2 = new FirstBest(permutation2, initialMatrix).run();
            System.out.println("Best solution: " + firstBestSolution2);
            FlowShop firstBestFlowShop2 = new FlowShop(initialMatrix,firstBestSolution2);
            System.out.println("Fmed: " + firstBestFlowShop2.fmed());

            System.out.println("\n\nGenetic Algorithm solution:");
            System.out.println("Processing. Please wait...\n");
            start = System.currentTimeMillis();
            List<Integer> geneticSolution = new GeneticAlgorithm(initialMatrix).run();
            System.out.println("Finished in: " + (System.currentTimeMillis() - start)/1000 + "s.");
            System.out.println("Best solution: " + geneticSolution);
            FlowShop geneticFlowShop = new FlowShop(initialMatrix, geneticSolution);
            System.out.println("Fmed: " + geneticFlowShop.fmed());
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Exiting...");
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("No arguments were passed.");
            System.out.println("Exiting...");
        }

    }

}
