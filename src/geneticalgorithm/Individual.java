package geneticalgorithm;

import flowshop.RandomPermutation;

import java.util.List;
import java.util.Random;

public class Individual
{
    private List<Integer> chromosomes;
    private Random random = new Random();
    private int size;
    private int fitness;
    private int mutationProb;

    public Individual(RandomPermutation chromosomePermutation)
    {
        this.chromosomes = chromosomePermutation.result();
        this.size = this.chromosomes.size();
        this.fitness = 0;
        this.mutationProb = 15;
    }

    public Individual(List<Integer> chromosomes)
    {
        this.chromosomes = chromosomes;
        this.size = this.chromosomes.size();
        this.fitness = 0;
        this.mutationProb = 15;
    }

    public List<Integer> getChromosomes()
    {
        return chromosomes;
    }

    public int size()
    {
        return size;
    }

    public int getFitness()
    {
        return fitness;
    }

    public boolean setFitness(int fitness)
    {
        this.fitness = fitness;
        return true;
    }

    /**
     * Method that prints out the individual.
     */
    public void print()
    {
        System.out.print("\n[");
        for (Integer chromosome : chromosomes)
        {
            System.out.print(chromosome + " ");
        }
        System.out.print("]\n");
    }

    /**
     * Method that performs a mutation in the chromosomes depending on the probability.
     */
    public void mutate()
    {
        Random random = new Random();
        if (mutationProb > random.nextInt(100) + 1)
        {
            int chrom = random.nextInt(size) + 1;
            int chrom2 = random.nextInt(size) + 1;
            while (chrom2 == chrom)
                chrom2 = random.nextInt(size) + 1;

            int mutValue = chromosomes.get(chrom);
            int mutValue2 = chromosomes.get(chrom2);

            chromosomes.set(chrom, mutValue2);
            chromosomes.set(chrom2, mutValue);
        }
    }
}
