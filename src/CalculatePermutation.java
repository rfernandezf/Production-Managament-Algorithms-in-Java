import java.util.ArrayList;
import java.util.List;

/**
 * Created by Plata on 30/09/2016.
 */
public class CalculatePermutation {
    private List<Integer> permutation = new ArrayList<Integer>();
    private int numberOfOrders;

    //Random numbers without repetition fron 0 to N, where N is numberOfOrders.
    public CalculatePermutation(int numberOfOrders){
        this.numberOfOrders = numberOfOrders;
        for (int i = 0; i < numberOfOrders; i++) {
            this.permutation.add(i);
        }
    }

    public List<Integer> result(){
        return this.permutation;
    }
}
