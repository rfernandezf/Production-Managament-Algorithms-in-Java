import flowshop.RandomPermutation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;


public class RandomPermutationTest
{
    @Test
    public void randomnessTest() throws Exception
    {
        List<RandomPermutation> permutations = new ArrayList<>();

        for (int i = 0; i < 50; i++)
        {
            permutations.add(new RandomPermutation(50));
        }

        Iterator<RandomPermutation> it =  permutations.iterator();

        boolean same = false;

        RandomPermutation previous = it.next();
        RandomPermutation current;

        while (it.hasNext())
        {
            current = it.next();
            System.out.println(current.result());

            same = current.result().equals(previous.result());

            previous = current;
        }

        assertFalse(same);
    }

}