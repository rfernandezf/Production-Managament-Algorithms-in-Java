package geneticalgorithm;


import flowshop.MatrixFromFile;

import java.util.List;

public class GeneticAlgorithm
{
    private Population population;
    private float itNumber;

    public GeneticAlgorithm(MatrixFromFile inputmatrix)
    {

        this.population = new Population(60, inputmatrix);
        population.updateFitness();
        //population.printFitness();

        this.itNumber = 100;

    }

    public List<Integer> run()
    {
        boolean solutionFound = false;
        float iterations = 0;
        int lastPercent = 0;
        while (!solutionFound)
        {
            iterations++;

            population.newGen();


            if ((int) ((iterations / itNumber) * 100) > lastPercent)
            {
                System.out.print((int) ((iterations / itNumber) * 100) + "%...");
                lastPercent = (int) ((iterations / itNumber) * 100);
                if (lastPercent % 10 == 0)
                {
                    System.out.print("\n");
                    //population.printFitness();
                }
            }

            if (iterations > itNumber)
            {
                solutionFound = true;
            }

        }

        return population.getBest().getChromosomes();
    }
}