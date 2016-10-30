package flowshop;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomPermutation
{
    private List<Integer> permutation = new ArrayList<>();

    //Random numbers without repetition from 0 to N, where N is numberOfOrders.
    public RandomPermutation(int numberOfOrders) {

        while (this.permutation.size() < numberOfOrders) {
            Random rnd = new SecureRandom();
            int numberRandom = rnd.nextInt(numberOfOrders) + 1;

            if (!this.permutation.contains(numberRandom)) {
                this.permutation.add(numberRandom);
            }
        }
    }

    public List<Integer> result() {
        return this.permutation;
    }

    public List<Integer> clonePermutation()
    {
        List<Integer> clone = new ArrayList<>();


            for (int number : result())
            {
                clone.add(number);
            }


        return clone;
    }
}
