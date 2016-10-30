package geneticalgorithm;

import flowshop.RandomPermutation;

import java.util.List;
import java.util.Random;

class Individual
{
    private List<Integer> chromosomes;
    private int size;
    private float fitness;
    private int mutationProb;

    Individual(RandomPermutation chromosomePermutation)
    {
        this.chromosomes = chromosomePermutation.result();
        this.size = this.chromosomes.size();
        this.fitness = 0;
        this.mutationProb = 15;
    }

    Individual(List<Integer> chromosomes)
    {
        this.chromosomes = chromosomes;
        this.size = this.chromosomes.size();
        this.fitness = 0;
        this.mutationProb = 15;
    }

    List<Integer> getChromosomes()
    {
        return chromosomes;
    }

    float getFitness()
    {
        return fitness;
    }

    boolean setFitness(float fitness)
    {
        this.fitness = fitness;
        return true;
    }

    /**
     * Method that prints out the individual.
     */
    void print()
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
    void mutate()
    {
        Random random = new Random();
        if (mutationProb > random.nextInt(100) + 1)
        {
            int chrom = random.nextInt(size);
            int chrom2 = random.nextInt(size);
            while (chrom2 == chrom)
                chrom2 = random.nextInt(size);

            int mutValue = chromosomes.get(chrom);
            int mutValue2 = chromosomes.get(chrom2);

            chromosomes.set(chrom, mutValue2);
            chromosomes.set(chrom2, mutValue);
        }
    }
}
