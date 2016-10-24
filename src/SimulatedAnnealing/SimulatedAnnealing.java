package SimulatedAnnealing;

import flowshop.MatrixFromFile;
import flowshop.RandomPermutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Plata on 24/10/2016.
 */
public class SimulatedAnnealing{

    private RandomPermutation randomPermutation;
    private MatrixFromFile inputMatrix;

    public SimulatedAnnealing(RandomPermutation randomPermutation, MatrixFromFile inputMatrix)
    {
        this.randomPermutation =randomPermutation;
        this.inputMatrix = inputMatrix;
    }

    public List<Integer> run() {
        List<Integer> solution = new ArrayList<Integer>();
        //Try values
        solution.add(5);
        solution.add(3);
        solution.add(1);
        solution.add(4);
        solution.add(2);

        return solution;
    }


}
