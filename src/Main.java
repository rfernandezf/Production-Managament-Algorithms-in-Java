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

        long start = System.currentTimeMillis();
        MatrixFromFile initialMatrix = null;
        try {
            initialMatrix = new MatrixFromFile(args[0]);

            System.out.print("Number of orders: " + initialMatrix.getOrderNum() + ".\n");
            System.out.print("Number of machines: " + initialMatrix.getMachNum() + ".\n");
            System.out.println("Input matrix: ");
            initialMatrix.printMatrix();

            System.out.println("\nRunning genetic algorithm...");
            List<Integer> solution = new GeneticAlgorithm(initialMatrix).run();
            System.out.println("Solution's Fmed after genetic algorithm: " + new FlowShop(initialMatrix, solution).fmed());
            System.out.println("Ran for: " + (System.currentTimeMillis() - start)/1000 + " secs.");

            System.out.println("Running first best...");
            solution = new FirstBest(new Permutation(solution), initialMatrix).run();
            System.out.println("First first best solution's Fmed: " + new FlowShop(initialMatrix, solution).fmed());
            System.out.println("Ran for: " + (System.currentTimeMillis() - start)/1000 + " secs.");

            System.out.println("Running simulated annealing...");
            solution = new SimulatedAnnealing(new Permutation(solution), initialMatrix).run();
            System.out.println("\nSolution's Fmed after simulated annealing: " + new FlowShop(initialMatrix, solution).fmed());
            System.out.println("Ran for: " + (System.currentTimeMillis() - start)/1000 + " secs.");

            System.out.println("Running first best...");
            solution = new FirstBest(new Permutation(solution), initialMatrix).run();
            System.out.println("Final solution's Fmed: " + new FlowShop(initialMatrix, solution).fmed());
            System.out.println("Finished in: " + (System.currentTimeMillis() - start)/1000 + " secs.");


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
