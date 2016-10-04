import java.util.ArrayList;
import java.util.List;

/**
 * Created by Plata on 04/10/2016.
 */
public class SolveFlowShopPermutational {

        private List<List<Integer>> inputMatrix = new ArrayList<List<Integer>>();
        private List<List<Integer>> outputMatrix = new ArrayList<List<Integer>>();
        private List<Integer> permutation = new ArrayList<Integer>();

        public SolveFlowShopPermutational(MatrixFromFile inputMatrix, Permutation permutation){
            this.inputMatrix = inputMatrix.getInputMatrix();
            this.permutation = permutation.result();



        }

        public List<List<Integer>> result(){
            return this.outputMatrix;
        }
}
