import java.util.ArrayList;
import java.util.List;

/**
 * Created by Plata on 04/10/2016.
 */
public class SolveFlowShopPermutational {

    private List<List<Integer>> outputMatrix = new ArrayList<List<Integer>>();
    private List<Integer> permutation = new ArrayList<Integer>();
    private int numberOfMachines;

    public SolveFlowShopPermutational(MatrixFromFile inputMatrix, Permutation permutation) {
        this.numberOfMachines = inputMatrix.getMachNum();
        this.permutation = permutation.result();
        this.outputMatrix = inputMatrix.getInputMatrix();

        int[] currentTime;
        currentTime = new int[this.numberOfMachines];
        for (int i = 0; i < this.numberOfMachines; i++) {
            currentTime[i] = 0;
        }
        int time;
        for (int i = 0; i < this.permutation.size(); i++) {
            for (int j = 0; j < this.numberOfMachines; j++) {
                if (j == 0) {
                    time = currentTime[0];
                } else {
                    time = currentTime[j];
                    if (time < currentTime[j - 1]) {
                        time = currentTime[j - 1];
                    }
                }
                this.outputMatrix.get(this.permutation.get(i) - 1).set(j, time + this.outputMatrix.get(this.permutation.get(i) - 1).get(j));
                currentTime[j] = this.outputMatrix.get(this.permutation.get(i) - 1).get(j);

            }
        }


    }

    public List<List<Integer>> result() {
        return this.outputMatrix;
    }
}
