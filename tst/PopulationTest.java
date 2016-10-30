import flowshop.MatrixFromFile;
import geneticalgorithm.Individual;
import geneticalgorithm.Population;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;


public class PopulationTest
{

    @Test
    public void randomnessTest() throws Exception
    {
        MatrixFromFile initialMatrix = new MatrixFromFile("rsc/Doc11.txt");

        Population population = new Population(50, initialMatrix);
        population.print();

        Iterator<Individual> it =  population.getIndividuals().iterator();

        Individual previous = it.next();
        Individual current;
        boolean same = false;

        while (it.hasNext())
        {
            current = it.next();
            same = previous.getChromosomes().equals(current.getChromosomes());
            previous = current;
        }

        assertFalse(same);
    }
}