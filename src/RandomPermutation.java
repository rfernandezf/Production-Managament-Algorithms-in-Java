import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomPermutation
{
    private List<Integer> permutation = new ArrayList<Integer>();
    private Random rnd = new Random();

    //Random numbers without repetition from 0 to N, where N is numberOfOrders.
    public RandomPermutation(int numberOfOrders) {

        while (this.permutation.size() < numberOfOrders) {
            int numberRandom = rnd.nextInt(numberOfOrders) + 1;

            if (!this.permutation.contains(numberRandom)) {
                this.permutation.add(numberRandom);
            }
        }
    }

    public List<Integer> result() {
        return this.permutation;
    }

}
