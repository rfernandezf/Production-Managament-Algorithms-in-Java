import java.util.ArrayList;
import java.util.List;

/**
 * Created by Plata on 04/10/2016.
 */
public class SolveFlowShopPermutational {

        private List<List<Integer>> inputMatrix = new ArrayList<List<Integer>>();
        private List<List<Integer>> outputMatrix = new ArrayList<List<Integer>>();
        private List<Integer> permutation = new ArrayList<Integer>();
        private int numberOfMachines;
        private int numberOfOrders;

        public SolveFlowShopPermutational(MatrixFromFile inputMatrix, Permutation permutation){
            this.inputMatrix = inputMatrix.getInputMatrix();
            this.numberOfMachines = inputMatrix.getMachNum();
            this.numberOfOrders = inputMatrix.getOrderNum();
            this.permutation = permutation.result();

            boolean processEnd = false;
            List<Integer> machines = new ArrayList<Integer>();
            for (int i = 0; i < this.numberOfMachines; i++){
                machines.add(0);
            }

            while (processEnd == false){
                processEnd=true;
            }

        }

        public List<List<Integer>> result(){
            return this.outputMatrix;
        }
}
